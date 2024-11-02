package com.depman;

public @interface DependiencyMethod
{
    String[] value() default "DependienciesManager";
}

