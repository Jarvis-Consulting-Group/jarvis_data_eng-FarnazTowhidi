package ca.jrvs.apps.trading.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class JsonUtil {
    //Map a JSON string into an object.
    public static String toJson(Object object, boolean prettyJson, boolean includeNullValues)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        if(!includeNullValues) {
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }
        if(prettyJson) {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        }

        return objectMapper.writeValueAsString(object);
    }

    //Map object to Json
    public static <T> T toObjectFromJson(String json, Class clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return (T) objectMapper.readValue(json, clazz);
    }
}
