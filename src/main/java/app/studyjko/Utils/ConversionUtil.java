package app.studyjko.Utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ConversionUtil {

    private ConversionUtil(){
        throw new RuntimeException("Utility class");
    }

    public static Object mapObject(Object source, Class<?> clazz){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper.convertValue(source, clazz);
    }
}
