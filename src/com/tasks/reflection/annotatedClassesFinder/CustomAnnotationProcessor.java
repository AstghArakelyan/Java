package com.tasks.reflection.annotatedClassesFinder;


import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CustomAnnotationProcessor extends ClassFinder {
    public static void main(String[] args) {
        CustomAnnotationProcessor processor = new CustomAnnotationProcessor();
        try {
            processor.doProcess("com.tasks.reflection");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Map<String, Object> annotatedClassWithObjects = new HashMap<>();

    public void doProcess(String scanPackage) throws IllegalAccessException, IOException,
            ClassNotFoundException, InvocationTargetException, InstantiationException {
        annotatedClassWithObjects = getClassesWithCustomAnnotation(scanPackage);
        String[] classNames = annotatedClassWithObjects.keySet().toArray(new String[0]);
        System.out.println("Annotated classes: ");
        for (String className : classNames) {
            System.out.println(className);
        }
    }

    public Map<String, Object> getClassesWithCustomAnnotation(String packageName) throws IOException,
            ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Map<String, Object> annotatedClassAndObj = new HashMap<>();
        Set<Class<?>> filteredClasses = getAnnotatedClasses(getClass(packageName));
        for (Class<?> _class : filteredClasses) {
            Object obj = _class.getConstructors()[0].newInstance();
            annotatedClassAndObj.put(_class.getName(), obj);
        }
        return annotatedClassAndObj;
    }

    private Set<Class<?>> getAnnotatedClasses(ArrayList<Class<?>> classes) {
        Set<Class<?>> filteredClasses = new HashSet<>();
        for (Class<?> _class : classes) {
            Annotation[] annotations = _class.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof CustomAnnotation) {
                    filteredClasses.add(_class);
                    break;
                }
            }
        }
        return filteredClasses;
    }
}