package com.ledsonsilva.strformatter.annotation;

import com.ledsonsilva.strformatter.enums.PaddingDirectionEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PositionalFormatter {
    int size() default 0;
    char padding() default ' ';
    PaddingDirectionEnum paddingDirection() default PaddingDirectionEnum.RIGHT;
    String dateFormat() default "YYYY-MM-dd";
}
