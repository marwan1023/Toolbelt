package hive;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TelemetryGraphs extends Application {

    private TemperatureGraph tg = new TemperatureGraph();
    private HumidityGraph hg = new HumidityGraph();
    private PressureGraph pg = new PressureGraph();

    public void start(Stage stage) {
        stage.setTitle("ENVIROHIVE TELEMETRY DATA");
        stage.show();

        tg.start(stage);
        hg.start(stage);
        pg.start(stage);


        FlowPane root = new FlowPane();
        root.getChildren().addAll(tg.getTempChart(), hg.getHumidityChart(), pg.getPressureChart());
        root.setOrientation(Orientation.HORIZONTAL);

        Scene scene = new Scene(root);

        stage.setMaxWidth(1500);
        stage.setMaxHeight(500);

        stage.setWidth(1500);
        stage.setHeight(425);
        stage.setScene(scene);

        stage.setResizable(false);


    }

    public static void main(String[] args) {
        launch(args);
    }

}
