package HW3_7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestExecutor {
    public static void main(String[] args) {
        System.out.println("--------1--------");
        start(new Class1().getClass());
        System.out.println("--------2--------");
        start(Class2.class);
        System.out.println("--------3--------");
        start("HW3_7.Class3");
    }

    public static <T> void start(Class testClass) {
        Constructor constr = null;
        T objestTestClass = null;
        try {
            constr = testClass.getConstructor();
            objestTestClass = (T) constr.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        ArrayList<Method> before = new ArrayList();
        ArrayList<Method> after = new ArrayList();
        ArrayList<Pair> test = new ArrayList();

        Method[] methods = testClass.getDeclaredMethods();

        for (Method method : methods) {
            method.setAccessible(true);
            if (method.getAnnotation(HW3_7.annotation.BeforeSuite.class) != null) {
                before.add(method);
            }
            if (method.getAnnotation(HW3_7.annotation.AfterSuite.class) != null) {
                after.add(method);
            }
            if (method.getAnnotation(HW3_7.annotation.Test.class) != null) {
                test.add(new Pair(method.getAnnotation(HW3_7.annotation.Test.class).value(), method));
            }
        }

        if (before.size() > 1 || after.size() > 1) {
            throw new RuntimeException();
        } else {
            for (Method method : before) {
                try {
                    method.invoke(objestTestClass);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            test.sort(Pair::compareTo);
            for (Pair pair : test) {
                try {
                    pair.method.invoke(objestTestClass);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            for (Method method : after) {
                try {
                    method.invoke(objestTestClass);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void start(String nameCl) {
        try {
            start(Class.forName(nameCl));
        } catch (ClassNotFoundException e) {
            System.out.println("Не нашел такого метода");
            e.printStackTrace();
        }
    }
}
