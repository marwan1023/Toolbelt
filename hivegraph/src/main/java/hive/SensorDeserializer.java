package hive;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import hive.Sensor;

import java.io.IOException;

public class SensorDeserializer extends StdDeserializer<Sensor> {

    public SensorDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Sensor deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
        Sensor sensor = new Sensor();
        while(!parser.isClosed()){
            JsonToken jsonToken = parser.nextToken();

            if(JsonToken.FIELD_NAME.equals(jsonToken)){
                String fieldName = parser.getCurrentName();


                parser.nextToken();

                if("temperature".equals(fieldName)){
                    sensor.setTemperature(parser.getValueAsString());
                } else if ("humidity".equals(fieldName)){
                    sensor.setHumidity(parser.getValueAsString());
                } else if ("host".equals(fieldName)) {
                    sensor.setHost(parser.getValueAsString());
                }
            }
        }
        return sensor;
    }
}
