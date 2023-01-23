package shop.mtcoding.web1.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageConverter {

    private static ObjectMapper om = new ObjectMapper();

    public static <T> String  reslove(T object){
        String json = null;
        try {
            json = om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}
