package com;

import ua.Invokable;
import ua.Reset;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationProcessor {

    private Field [] fields;

    public AnnotationProcessor() {}


    public void reset(Book book) throws Exception {
       fields = book.getClass().getDeclaredFields();
        for (Field field: fields) {
            if (field.isAnnotationPresent(Reset.class)) {
                Reset reset = field.getAnnotation(Reset.class);
                field.setAccessible(true);
                field.set(book,reset.name());
            }
        }
    }

    public void print(Book[] books) throws Exception{
        Method [] methods;

        for (Book book:books) {
            methods = book.getClass().getDeclaredMethods();
            for (Method method:methods){
                if (method.isAnnotationPresent(Invokable.class)) {
                    System.out.println(method.invoke(book));}}
        }

    }


}
