package p010b.p014d.p017c;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p010b.p013c.C0283b;
import p010b.p013c.InterfaceC0282a;

/* compiled from: Logger.java */
/* renamed from: b.d.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC0307a {

    /* renamed from: a */
    private static final AbstractC0308b f688a;

    /* renamed from: a */
    public abstract void mo1038a(String str);

    /* renamed from: a */
    public abstract void mo1039a(String str, String str2);

    /* renamed from: a */
    public abstract void mo1040a(String str, Throwable th);

    /* renamed from: a */
    public abstract boolean mo1041a();

    static {
        AbstractC0308b c0310d = null;
        String property = System.getProperty("twitter4j.loggerFactory");
        if (property != null) {
            c0310d = m1037b(property, property);
        }
        InterfaceC0282a interfaceC0282aM989a = C0283b.m989a();
        String strM988l = interfaceC0282aM989a.m988l();
        if (strM988l != null) {
            c0310d = m1037b(strM988l, strM988l);
        }
        if (c0310d == null) {
            c0310d = m1037b("org.slf4j.impl.StaticLoggerBinder", "twitter4j.internal.logging.SLF4JLoggerFactory");
        }
        if (c0310d == null) {
            c0310d = m1037b("org.apache.commons.logging.Log", "twitter4j.internal.logging.CommonsLoggingLoggerFactory");
        }
        if (c0310d == null) {
            c0310d = m1037b("org.apache.log4j.Logger", "twitter4j.internal.logging.Log4JLoggerFactory");
        }
        if (c0310d == null) {
            c0310d = m1037b("com.google.appengine.api.urlfetch.URLFetchService", "twitter4j.internal.logging.JULLoggerFactory");
        }
        if (c0310d == null) {
            c0310d = new C0310d();
        }
        f688a = c0310d;
        try {
            Method method = interfaceC0282aM989a.getClass().getMethod("dumpConfiguration", new Class[0]);
            method.setAccessible(true);
            method.invoke(interfaceC0282aM989a, new Object[0]);
        } catch (IllegalAccessException e) {
        } catch (NoSuchMethodException e2) {
        } catch (InvocationTargetException e3) {
        }
    }

    /* renamed from: b */
    private static AbstractC0308b m1037b(String str, String str2) throws ClassNotFoundException {
        try {
            Class.forName(str);
            return (AbstractC0308b) Class.forName(str2).newInstance();
        } catch (ClassNotFoundException e) {
            return null;
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (InstantiationException e3) {
            throw new AssertionError(e3);
        } catch (SecurityException e4) {
            return null;
        }
    }

    /* renamed from: a */
    public static AbstractC0307a m1036a(Class cls) {
        return f688a.mo1042a(cls);
    }
}
