package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescription {
    Class<?> internalClass;

    public TestClassDescription(Class<?> classe){
        this.internalClass = classe;
    }

    public List<Method> listTestMethods(){
        List<Method> listOfMethod = new ArrayList<Method>();
        for (Method method : internalClass.getDeclaredMethods()){
            int type = method.getModifiers();
                if  (Modifier.isPublic(type) && method.getReturnType().equals(Void.TYPE) &&
                    (method.getParameterTypes().length == 0 && method.isAnnotationPresent(TestMethod.class))
                ) {
                    listOfMethod.add(method);
                    System.out.println(method);
                }
        }
        return listOfMethod;
    }
}
