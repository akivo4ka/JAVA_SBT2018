package beanutils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils {
    /**
     *      Scans object "from" for all getters. If object "to"
     *      contains correspondent setter, it will invoke it
     *      to set property value for "to" which equals to the property
     *      of "from".
     *      <p/>
     *      The type in setter should be compatible to the value returned
     *      by getter (if not, no invocation performed).
     *      Compatible means that parameter type in setter should
     *      be the same or be superclass of the return type of the getter.
     *      <p/>
     *      The method takes care only about public methods.
     *      
     *      @param to   Object which properties will be set.
     *      @param from Object which properties will be used to get values.
     *      
     */


    public static void assign(Object to, Object from) {
        List<Method> from_getters = getAllGetters(from);
        List<Method> to_setters = getAllSetters(to);

        for (Method getter : from_getters)
            for (Method setter : to_setters)
                if (areCompatible(getter, setter)) try {
                    setter.invoke(to, getter.invoke(from));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
    }

    private static boolean areCompatible(Method getter, Method setter) {
        return (getter.getReturnType() == setter.getParameterTypes()[0] || getter.getReturnType() == setter.getParameterTypes()[0].getSuperclass()) &&
                getter.getName().substring(3).equals(setter.getName().substring(3));
    }


    private static List<Method> getAllSetters(Object o) {
        List<Method> setters = new ArrayList<>();
        for (Method method : o.getClass().getMethods()) {
            if (!method.getName().startsWith("set")) continue;
            if (method.getParameterCount() != 1) continue;
            setters.add(method);
        }
        return setters;
    }

    private static List<Method> getAllGetters(Object o) {
        List<Method> getters = new ArrayList<>();
        for (Method method : o.getClass().getMethods()) {
            if (!method.getName().startsWith("get")) continue;
            if (method.getParameterCount() != 0) continue;
            if (void.class.equals(method.getReturnType())) continue;
            getters.add(method);
        }
        return getters;
    }
}
