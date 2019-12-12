package com.ledsonsilva.strformatter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PositionalFormatter {
    int size() default 0;
    String dateFormat() default "YYYY-MM-dd";
}
