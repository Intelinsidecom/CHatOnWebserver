package twitter4j.internal.json;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class DataObjectFactoryUtil {
    private static final Method CLEAR_THREAD_LOCAL_MAP;
    private static final Method REGISTER_JSON_OBJECT;
    static Class class$twitter4j$json$DataObjectFactory;

    private DataObjectFactoryUtil() {
        throw new AssertionError("not intended to be instantiated.");
    }

    static {
        Class clsClass$;
        if (class$twitter4j$json$DataObjectFactory == null) {
            clsClass$ = class$("twitter4j.json.DataObjectFactory");
            class$twitter4j$json$DataObjectFactory = clsClass$;
        } else {
            clsClass$ = class$twitter4j$json$DataObjectFactory;
        }
        Method[] declaredMethods = clsClass$.getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        Method method = null;
        Method method2 = null;
        while (i < length) {
            Method method3 = declaredMethods[i];
            if (method3.getName().equals("clearThreadLocalMap")) {
                method3.setAccessible(true);
            } else if (method3.getName().equals("registerJSONObject")) {
                method3.setAccessible(true);
                method2 = method3;
                method3 = method;
            } else {
                method3 = method;
            }
            i++;
            method = method3;
        }
        if (method == null || method2 == null) {
            throw new AssertionError();
        }
        CLEAR_THREAD_LOCAL_MAP = method;
        REGISTER_JSON_OBJECT = method2;
    }

    static Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static void clearThreadLocalMap() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            CLEAR_THREAD_LOCAL_MAP.invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    public static Object registerJSONObject(Object obj, Object obj2) {
        try {
            return REGISTER_JSON_OBJECT.invoke(null, obj, obj2);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }
}
