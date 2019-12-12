package com.ledsonsilva.strformatter.utils;

import com.ledsonsilva.strformatter.annotation.PositionalFormatter;
import com.ledsonsilva.strformatter.exception.PositionSizeException;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringPositionalFormatter {

    @SuppressWarnings({"rawtypes"})
    public static String format(Object object) throws PositionSizeException {

        String stringFormat = "";
        List<String> values = new ArrayList<>();

        Class clazz = object.getClass();

        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);

            if (f.isAnnotationPresent(PositionalFormatter.class)) {
                PositionalFormatter annotation = f.getAnnotation(PositionalFormatter.class);
                String value = "";

                try {
                    value = Objects.nonNull(f.get(object)) ? String.valueOf(f.get(object)) : "";

                    if (f.getType().equals(LocalDate.class) || f.getType().equals(LocalDateTime.class)) {
                        LocalDate data = (LocalDate) f.get(object);
                        value = data.format(DateTimeFormatter.ofPattern(annotation.dateFormat()));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                if (annotation.size() < value.length()) {
                    throw new PositionSizeException(clazz.getName(), f.getName());
                }

                if (annotation.padding() != ' ') {
                    switch (annotation.paddingDirection()) {
                        case LEFT:
                            value = StringUtils.leftPad(value, annotation.size(), annotation.padding());
                            break;
                        case RIGHT:
                            value = StringUtils.rightPad(value, annotation.size(), annotation.padding());
                            break;
                    }
                }

                values.add(value);

                stringFormat = stringFormat.concat("%-" + annotation.size() + "s");
            }
        }

        return String.format(stringFormat.trim(), values.toArray());

    }

}
