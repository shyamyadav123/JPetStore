package com.nevercome.jpetstore.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

public class BeanFactory {
    private static HashMap<String, Object> objectMap;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("beans");
        Enumeration<String> keys = bundle.getKeys();
        objectMap = new HashMap<>();
        while (keys.hasMoreElements()) {
            String classNameStr = keys.nextElement();
            String classLongName = bundle.getString(classNameStr);
            try {
                Object object = Class.forName(classLongName).getConstructor().newInstance();
                objectMap.put(classNameStr, object);
            } catch (Exception e) {
                objectMap.put(classNameStr, null);
            }
        }
    }

    public static Object getInstance(String className) {
        return objectMap.get(className);
    }
}
