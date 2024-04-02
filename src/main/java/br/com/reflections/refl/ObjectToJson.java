package br.com.reflections.refl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ObjectToJson {

    public String transform(Object object) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Map<String, Object> mapper = new HashMap<>();

        Class<?> classToTransform = object.getClass();

        Arrays.stream(classToTransform.getDeclaredFields()).toList().forEach(field -> {
            field.setAccessible(true);
            String key = field.getName();

            Object value = null;
            try {
                value = field.get(object);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            mapper.put(key, value);

        });
        
        return objectMapper.writeValueAsString(mapper);

    }

}
