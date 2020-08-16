package com.atguigu.annotationaop;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AspectAnnotaton {
    boolean value() default false;
}
