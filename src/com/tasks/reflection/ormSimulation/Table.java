package com.tasks.reflection.ormSimulation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String schema() default "public";
    String value();
}
