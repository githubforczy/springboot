package com.springboot.day06.service;

@FunctionalInterface
public interface LambdaInterface <F,T>{
    T convert(F from);
}
