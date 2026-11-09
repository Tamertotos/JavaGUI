package processing;

import json.JsonIgnore;
import json.JsonProperty;
import json.JsonSerializable;

import java.lang.reflect.Field;
import java.util.StringJoiner;

public class JsonSerializer {
    public static String serialize(Object obj) throws IllegalAccessException {

        if (obj == null){
            throw new IllegalArgumentException("The given object is null! Serialization is not possible!");
        }

        Class<?> cClass = obj.getClass();
        if(!cClass.isAnnotationPresent(JsonSerializable.class)){
            throw new IllegalArgumentException("Annotation is missing! Serialization is not possible!");
        }

        StringJoiner joiner = new StringJoiner(",");

        for (Field field: cClass.getDeclaredFields()){
            field.setAccessible(true);

            if (field.isAnnotationPresent(JsonIgnore.class)){
                continue;
            }

            String key = "";
            if (field.isAnnotationPresent(JsonProperty.class)) {
                key = field.getAnnotation(JsonProperty.class).value();
            } else {
                key = field.getName();
            }

            Object value = field.get(obj);
            if (value instanceof String){
                value = "\"" + value + "\"";
            } else {
                String.valueOf(value);
            }

            joiner.add("\"" + key + "\":" + value + "\"\n");

        }

        return "{" + joiner + "}";
    }
}
