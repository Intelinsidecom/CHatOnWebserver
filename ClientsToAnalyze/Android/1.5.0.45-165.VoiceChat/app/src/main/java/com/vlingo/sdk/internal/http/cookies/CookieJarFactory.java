package com.vlingo.sdk.internal.http.cookies;

/* loaded from: classes.dex */
public class CookieJarFactory {
    private static Class<?> ImplClass = null;

    public static synchronized void setCookieJarImpl(Class<?> implClass) {
        if (implClass == null) {
            throw new RuntimeException("CookieJar clazz null");
        }
        if (!CookieJar.class.isAssignableFrom(implClass)) {
            throw new RuntimeException("CookieJar invalid impl: " + implClass);
        }
        ImplClass = implClass;
    }

    public static synchronized CookieJar newInstance() {
        if (ImplClass == null) {
            throw new RuntimeException("CookieJar implementation class is not set");
        }
        try {
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            throw new RuntimeException("CookieJar IllegalAccessException: " + ex);
        } catch (InstantiationException ex2) {
            ex2.printStackTrace();
            throw new RuntimeException("CookieJar InstantiationException: " + ex2);
        }
        return (CookieJar) ImplClass.newInstance();
    }

    public static void cleanup() {
        ImplClass = null;
    }
}
