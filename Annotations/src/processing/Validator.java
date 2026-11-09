package processing;

import validation.NotBlank;
import validation.NotNull;
import validation.Range;

import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object obj) throws ValidationException, IllegalAccessException {
        Class<?> cClass = obj.getClass();
        for (Field field : cClass.getDeclaredFields()) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(Range.class)) {
                Range range = field.getAnnotation(Range.class);
                long value = field.getLong(obj);
                if (value < range.min() || value > range.max()) {
                    throw new ValidationException("Wrong range");
                }
            }

            if (field.isAnnotationPresent(NotBlank.class)) {
                String name = field.get(obj).toString();
                if (name.isEmpty()) {
                    throw new ValidationException("is Empty");
                }
            }

            if (field.isAnnotationPresent(NotNull.class)) {
                String email = field.get(obj).toString();
                if (email == null) {
                    throw new ValidationException("is null");
                }
            }
        }
    }
}

