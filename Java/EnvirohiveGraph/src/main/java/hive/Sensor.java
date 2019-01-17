package hive;

public class Sensor {

    private String host = null;
    private String temperature = null;
    private String humidity = null;
    private String pressure = null;

    public String getPressure() {return this.pressure;}
    public void setPressure(String pressure) {this.pressure = pressure;}

    public String getHost() { return this.host; }
    public void   setHost(String host){ this.host = host;}

    public String getTemperature() { return this.temperature; }
    public void   setTemperature(String temperature){ this.temperature = temperature;}

    public String getHumidity() {return this.humidity;}
    public void setHumidity(String humidity) {this.humidity = humidity; }
}
