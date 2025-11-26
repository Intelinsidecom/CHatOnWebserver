package p010b.p014d.p015a;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: HttpClientFactory.java */
/* renamed from: b.d.a.e */
/* loaded from: classes.dex */
public final class C0290e {

    /* renamed from: a */
    private static final Constructor f644a;

    static {
        Class<?> cls = null;
        String property = System.getProperty("twitter4j.http.httpClient");
        if (property != null) {
            try {
                cls = Class.forName(property);
            } catch (ClassNotFoundException e) {
            }
        }
        if (cls == null) {
            try {
                cls = Class.forName("twitter4j.internal.http.alternative.HttpClientImpl");
            } catch (ClassNotFoundException e2) {
            }
        }
        if (cls == null) {
            try {
                cls = Class.forName("b.d.a.f");
            } catch (ClassNotFoundException e3) {
                throw new AssertionError(e3);
            }
        }
        try {
            f644a = cls.getConstructor(InterfaceC0289d.class);
        } catch (NoSuchMethodException e4) {
            throw new AssertionError(e4);
        }
    }

    /* renamed from: a */
    public static InterfaceC0287b m1003a(InterfaceC0289d interfaceC0289d) {
        try {
            return (InterfaceC0287b) f644a.newInstance(interfaceC0289d);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new AssertionError(e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }
}
