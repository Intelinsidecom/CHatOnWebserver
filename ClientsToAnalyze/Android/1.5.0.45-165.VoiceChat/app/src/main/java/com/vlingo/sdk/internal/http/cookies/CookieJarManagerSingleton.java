package com.vlingo.sdk.internal.http.cookies;

/* loaded from: classes.dex */
public class CookieJarManagerSingleton {
    private static CookieJarManager instance = null;
    private static Class<?> ImplClass = null;

    public static synchronized void setCookieJarManagerImpl(Class<?> implClass) {
        if (implClass == null) {
            throw new RuntimeException("CookieJarManager clazz null");
        }
        if (!CookieJarManager.class.isAssignableFrom(implClass)) {
            throw new RuntimeException("CookieJarManager invalid impl: " + implClass);
        }
        ImplClass = implClass;
    }

    public static synchronized CookieJarManager getInstance() {
        if (instance == null) {
            if (ImplClass == null) {
                throw new RuntimeException("CookieJarManager implementation class is not set");
            }
            try {
                try {
                    instance = (CookieJarManager) ImplClass.newInstance();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                    throw new RuntimeException("CookieJarManager IllegalAccessException: " + ex);
                }
            } catch (InstantiationException ex2) {
                ex2.printStackTrace();
                throw new RuntimeException("CookieJarManager InstantiationException: " + ex2);
            }
        }
        return instance;
    }

    public static void cleanup() {
        ImplClass = null;
        instance = null;
    }
}
