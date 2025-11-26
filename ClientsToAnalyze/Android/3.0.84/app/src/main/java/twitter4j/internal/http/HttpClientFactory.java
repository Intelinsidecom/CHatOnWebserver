package twitter4j.internal.http;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class HttpClientFactory {
    private static final Constructor HTTP_CLIENT_CONSTRUCTOR;
    private static final String HTTP_CLIENT_IMPLEMENTATION = "twitter4j.http.httpClient";
    static Class class$twitter4j$internal$http$HttpClientConfiguration;

    static {
        Class<?> cls;
        Class<?> clsClass$;
        Class<?> cls2 = null;
        String property = System.getProperty(HTTP_CLIENT_IMPLEMENTATION);
        if (property != null) {
            try {
                cls2 = Class.forName(property);
            } catch (ClassNotFoundException e) {
            }
        }
        if (cls2 == null) {
            try {
                cls2 = Class.forName("twitter4j.internal.http.alternative.HttpClientImpl");
            } catch (ClassNotFoundException e2) {
            }
        }
        if (cls2 == null) {
            try {
                cls = Class.forName("twitter4j.internal.http.HttpClientImpl");
            } catch (ClassNotFoundException e3) {
                throw new AssertionError(e3);
            }
        } else {
            cls = cls2;
        }
        try {
            Class<?>[] clsArr = new Class[1];
            if (class$twitter4j$internal$http$HttpClientConfiguration == null) {
                clsClass$ = class$("twitter4j.internal.http.HttpClientConfiguration");
                class$twitter4j$internal$http$HttpClientConfiguration = clsClass$;
            } else {
                clsClass$ = class$twitter4j$internal$http$HttpClientConfiguration;
            }
            clsArr[0] = clsClass$;
            HTTP_CLIENT_CONSTRUCTOR = cls.getConstructor(clsArr);
        } catch (NoSuchMethodException e4) {
            throw new AssertionError(e4);
        }
    }

    static Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static HttpClient getInstance(HttpClientConfiguration httpClientConfiguration) {
        try {
            return (HttpClient) HTTP_CLIENT_CONSTRUCTOR.newInstance(httpClientConfiguration);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new AssertionError(e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }
}
