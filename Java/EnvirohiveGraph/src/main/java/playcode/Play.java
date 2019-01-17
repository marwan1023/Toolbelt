package playcode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import hive.Sensor;
import hive.SensorDeserializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Play {

    public static void main(String[] args)
    {
        String hiveHome = System.getenv("HIVE_HOME");

        hiveHome = "192.168.52.1";
       // String json = "[{\"host\": \"192.168.52.2\", \"temperature\": \"75.19\", \"humidity\": \"33.76\"}]";


            if(hiveHome != null ){


//                try {
//
//
//                    SimpleModule module =
//                            new SimpleModule("SensorDeserializer");
//                    module.addDeserializer(Sensor.class, new SensorDeserializer(Sensor.class));
//
//                    ObjectMapper mapper = new ObjectMapper();
//                    mapper.registerModule(module);
//
//                    Sensor sensor = mapper.readValue(json, Sensor.class);
//
//                    StringBuilder sb = new StringBuilder();
//
//                    sb.append("temp = " + sensor.getTemperature() + "\n");
//                    sb.append("humidity = " + sensor.getHumidity() + "\n");
//                    sb.append("host = " + sensor.getHost());
//
//
//                    System.out.println(sb.toString());
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }


//                InetAddress ia = InetAddress.getByName(hiveHome);
//
//                scan(ia);

//                //Connecting to Redis server on localhost
//                Jedis jedis = new Jedis(ia.getHostAddress());
//
//                //check whether server is running or not
//                System.out.println("Server is running: "+jedis.ping());
//                System.out.println("Stored string in redis:: "+ jedis.get("telemetryReading"));


                try {

                    String subnet = "192.168.52";

                    for (int x=1; x <= 2; x++)
                    {
                        String ip = subnet + "." + x;

                        System.out.println(ip);
                        URL oracle = new URL("http://" + ip + ":8090/telemetry");
                       // URLConnection yc = oracle.openConnection();
                        HttpURLConnection huc = (HttpURLConnection) oracle.openConnection();
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

                            StringBuilder sb = new StringBuilder();


                            sb.append("temp = " + Double.parseDouble(sensor.getTemperature()) + "\n");
                            sb.append("humidity = " + Double.parseDouble(sensor.getHumidity()) + "\n");
                            sb.append("host = " + sensor.getHost());


                            System.out.println(sb.toString());
                        }
                        //System.out.println(inputLine);
                        huc.disconnect();
                        in.close();
                    }



                } catch (IOException ie) {
                    System.out.println(ie.getLocalizedMessage());
                   // ie.printStackTrace();
                }



//                TimerTask timerTask = new MyTimerTask();
//                //running timer task as daemon thread
//                Timer timer = new Timer(true);
//                timer.scheduleAtFixedRate(timerTask, 0, 5*1000);
//
//                System.out.println("TimerTask started");
//
//                //cancel after sometime
//                try {
//                    Thread.sleep(120000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                timer.cancel();
//                System.out.println("TimerTask cancelled");
//                try {
//                    Thread.sleep(30000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

            }

    }


    private static final HttpURLConnection getConnection(URL entries) throws InterruptedException, IOException {
        int retry = 0;
        boolean delay = false;
        HttpURLConnection connection = null;
        do {
            if (delay) {
                Thread.sleep(1000);
            }
            connection = (HttpURLConnection)entries.openConnection();
            switch (connection.getResponseCode()) {
                case HttpURLConnection.HTTP_OK:
                    //log.fine(entries + " **OK**");
                    return connection; // **EXIT POINT** fine, go on
                case HttpURLConnection.HTTP_GATEWAY_TIMEOUT:
                    //log.warning(entries + " **gateway timeout**");
                    break;// retry
                case HttpURLConnection.HTTP_UNAVAILABLE:
                    //log.warning(entries + "**unavailable**");
                    break;// retry, server is unstable
                default:
                    //log.severe(entries + " **unknown response code**.");
                    break; // abort
            }
            // we did not succeed with connection (or we would have returned the connection).
            connection.disconnect();
            // retry
            retry++;
            //log.warning("Failed retry " + retry + "/" + RETRIES);
            delay = true;

        } while (retry < 2);

        //log.severe("Aborting download of dataset.");

        return connection;
    }

    public static boolean scan(final InetAddress remote) {

        AtomicBoolean active = new AtomicBoolean(false);

        int port=8090;



            try {
                new Socket(remote,port).close();

                active.set(true);

            }
            catch (IOException ex) {
                // The remote host is not listening on this port

            }
        return active.get();
    }
}
