package hive;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class HumidityGraph extends Application {

    private static final int MAX_DATA_POINTS = 200;
    private int xSeriesData = 0;
    private XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
    private XYChart.Series<Number, Number> series2 = new XYChart.Series<>();

    private ExecutorService executor;
    private ConcurrentLinkedQueue<Number> dataQ1 = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<Number> dataQ2 = new ConcurrentLinkedQueue<>();

    private NumberAxis xAxis;



    private Chart humidityChart;

    public Chart getChart() {

        xAxis = new NumberAxis(0, MAX_DATA_POINTS, MAX_DATA_POINTS / 10);
        xAxis.setForceZeroInRange(false);
        xAxis.setAutoRanging(false);
        xAxis.setTickLabelsVisible(false);
        xAxis.setTickMarkVisible(false);
        xAxis.setMinorTickVisible(false);

        NumberAxis yAxis = new NumberAxis();

        // Create a LineChart
        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis) {
            // Override to remove symbols on each data point
            @Override
            protected void dataItemAdded(Series<Number, Number> series, int itemIndex, Data<Number, Number> item) {
            }
        };

        lineChart.setAnimated(false);
        lineChart.setTitle("Humidity (Percentage)");
        lineChart.setHorizontalGridLinesVisible(true);

        // Set Name for Series
        series1.setName("192.168.52.1");
        series2.setName("192.168.52.2");


        // Add Chart Series
        lineChart.getData().addAll(series1, series2);

        lineChart.setCursor(Cursor.CROSSHAIR);

        return lineChart;

    }

    @Override
    public void start(Stage stage) {

        this.setHumidityChart(getChart());

        executor = Executors.newCachedThreadPool(r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

        HumidityGraph.AddToQueue addToQueue = new HumidityGraph.AddToQueue();
        executor.execute(addToQueue);
        //-- Prepare Timeline
        prepareTimeline();
    }


   private class AddToQueue implements Runnable {
        public void run() {
            try {
                // add a item of random data to queue
                Map<String,Double> data = getHiveData();


                dataQ1.add(data.get("192.168.52.1"));
                dataQ2.add(data.get("192.168.52.2"));


                Thread.sleep(3*1000);
                executor.execute(this);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public Map<String,Double> getHiveData() {
        Map<String,Double> data = new HashMap<>();

        try {

            String subnet = "192.168.52";

            for (int x=1; x <= 2; x++)
            {
                String ip = subnet + "." + x;

                URL u = new URL("http://" + ip + ":8090/telemetry");

                HttpURLConnection huc = (HttpURLConnection) u.openConnection();
                HttpURLConnection.setFollowRedirects(false);
                huc.setConnectTimeout(5 * 1000);

                BufferedReader in = new BufferedReader(new InputStreamReader(
                        huc.getInputStream()));
                String inputLine;
                if ((inputLine = in.readLine()) != null) {
                    SimpleModule module =
                            new SimpleModule("SensorDeserializer");
                    module.addDeserializer(Sensor.class, new SensorDeserializer(Sensor.class));

                    ObjectMapper mapper = new ObjectMapper();
                    mapper.registerModule(module);

                    Sensor sensor = mapper.readValue(inputLine, Sensor.class);

                    data.put(ip, Double.parseDouble(sensor.getHumidity()));


                }
                //System.out.println(inputLine);
                huc.disconnect();
                in.close();
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }


        return data;
    }


    //-- Timeline gets called in the JavaFX Main thread
    public void prepareTimeline() {
        // Every frame to take any data from queue and add to chart
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                addDataToSeries();
            }
        }.start();
    }

    private void addDataToSeries() {
        for (int i = 0; i < 20; i++) { //-- add 20 numbers to the plot+
            if (dataQ1.isEmpty()) break;


            series1.getData().add(new XYChart.Data(xSeriesData++, dataQ1.remove()));
            series2.getData().add(new XYChart.Data(xSeriesData++, dataQ2.remove()));

        }
        // remove points to keep us at no more than MAX_DATA_POINTS
        if (series1.getData().size() > MAX_DATA_POINTS) {
            series1.getData().remove(0, series1.getData().size() - MAX_DATA_POINTS);
        }
        if (series2.getData().size() > MAX_DATA_POINTS) {
            series2.getData().remove(0, series2.getData().size() - MAX_DATA_POINTS);
        }

        // update
        xAxis.setLowerBound(xSeriesData - MAX_DATA_POINTS);
        xAxis.setUpperBound(xSeriesData - 1);
    }

    public Chart getHumidityChart() {
        return humidityChart;
    }

    public void setHumidityChart(Chart humidityChart) {
        this.humidityChart = humidityChart;
    }

}
