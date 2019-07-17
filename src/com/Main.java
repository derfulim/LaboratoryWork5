package com;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        Book libraryBook = new LibraryBook("Том Соер", "", 2000, 100, 58, 342, null);
        Book book = new Book("Том Соер", "", 2000, 100, 58);
        Book[] books = {libraryBook, book};

        printFieldsInfo(book);
        printMethodsInfo(book);
    }

    public static void printConstructorsInfo(Object o) {
        Constructor[] constructors = o.getClass().getConstructors();
            Class [] classes = constructors[0].getParameterTypes();
            for (Class clazz : classes) {
                System.out.println(clazz);
            }}

    public static void printClassInfo(Object o) {
        System.out.println(o.getClass().getName());

        int  mod = o.getClass().getModifiers();
                System.out.println(Modifier.isPublic(mod));

        System.out.println(o.getClass().getSimpleName());
                System.out.println(o.getClass().getPackage().getName());

                System.out.println(o.getClass().getSuperclass().getName());

                Annotation [] annotations = o.getClass().getAnnotations();
                for (Annotation ann:annotations
                     ) {
                    System.out.println(ann.getClass().getName());
                }

                Class [] interfaces = o.getClass().getInterfaces();
                for (Class interf:interfaces
                     ) {
                    System.out.println(interf.getName());
                }}


    public static void printMethodsInfo(Object o) {

        Method methods[] = o.getClass().getMethods();

        Map<Method, Annotation[]> anns = new HashMap<>();
        Map<Method, Class[]> params = new HashMap<>();
        Map<Method, Integer> modifiers = new HashMap<>();


            for (Method method : methods
            ) {
                anns.put(method, method.getAnnotations());
                params.put(method, method.getParameterTypes());
                modifiers.put(method, method.getModifiers());
            }

            for (Method method : methods
            ) {
                System.out.println(method.getName());
                Annotation[] annotations = anns.get(method);
                Class[] classes1 = params.get(method);
                for (Annotation ann : annotations
                ) {
                    System.out.println("List of methods annotation ");
                    System.out.print(ann.getClass().getName() + " ");
                    System.out.println();
                }
                System.out.println("List of methods modifiers");
                if (Modifier.isPublic(modifiers.get(method))) {
                    System.out.print("Public ");
                }
                if (Modifier.isFinal(modifiers.get(method))) {
                    System.out.print("Final ");
                }
                if (Modifier.isProtected(modifiers.get(method))) {
                    System.out.print("Protected ");
                }
                System.out.println();

                for (Class clazz : classes1
                ) {
                    System.out.println("List of methods parameters ");
                    System.out.print(clazz.getName() + " ");
                    System.out.println();
                }

            }
    }

        public static void printFieldsInfo(Object o){
            Class clazz = o.getClass();
            Field [] fields = clazz.getDeclaredFields();
            Annotation [] annotations;
            String accessModifier;

            for (Field field:fields
                 ) {
                System.out.println("Field name is " + field.getName());
                System.out.println("Field type is "+ field.getType().getName());

                switch (field.getModifiers()){
                    case Modifier.PUBLIC:
                        accessModifier = "Public";
                        break;
                    case Modifier.PROTECTED:
                        accessModifier = "Protected";
                        break;
                    case Modifier.PRIVATE:
                        accessModifier = "Private";
                        break;
                    default:accessModifier = "Default";
                }
                System.out.println("Field access modifier is " + accessModifier);

                annotations = field.getDeclaredAnnotations();
                if (annotations.length>0) {
                    System.out.println("Field annotations are :");
                    for (Annotation annotation : annotations
                    ) {
                        System.out.println(annotation.toString());
                    }
                }
                System.out.println();

            }
        }





    }




