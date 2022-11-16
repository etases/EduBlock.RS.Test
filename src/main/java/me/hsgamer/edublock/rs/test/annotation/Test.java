package me.hsgamer.edublock.rs.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.*;

@Target({ElementType.METHOD})
@Retention(RUNTIME)
public @interface Test {
    String name() default "";

    int order() default 0;
}
