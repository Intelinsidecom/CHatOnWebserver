package com.nuance.nmsp.client.sdk.oem.bluetooth;

import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class Reflection {

    /* renamed from: a */
    private LogFactory.Log f382a = LogFactory.getLog(getClass());

    /* renamed from: a */
    private void m132a(Exception exc) {
        if (this.f382a.isErrorEnabled()) {
            this.f382a.error("Exception received - ", exc);
        }
    }

    public Class<?> getClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("getClassForName failed", e);
        }
    }

    public Constructor<?> getConstructor(Class<?> cls, Class<?>... clsArr) {
        try {
            return cls.getConstructor(clsArr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("getConstructor failed", e);
        }
    }

    public Constructor<?> getConstructorForName(String str, Class<?>... clsArr) {
        Class<?> classForName = getClassForName(str);
        if (classForName != null) {
            return getConstructor(classForName, clsArr);
        }
        return null;
    }

    public Object getFieldValue(Class<?> cls, String str) {
        try {
            return cls.getField(str).get(null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("getFieldValue failed", e);
        }
    }

    public Object getFieldValue(Class<?> cls, String str, Object obj) {
        try {
            return cls.getField(str).get(null);
        } catch (Exception e) {
            return obj;
        }
    }

    public Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("getMethod failed", e);
        }
    }

    public Method getMethodOrNull(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (Exception e) {
            return null;
        }
    }

    public Object newObject(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Class.forName(str).newInstance();
        } catch (ClassNotFoundException e) {
            m132a(e);
            return null;
        } catch (IllegalAccessException e2) {
            m132a(e2);
            return null;
        } catch (InstantiationException e3) {
            m132a(e3);
            return null;
        }
    }

    public Object newObject(Constructor constructor, Object... objArr) {
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException e) {
            m132a(e);
            return null;
        } catch (InstantiationException e2) {
            m132a(e2);
            return null;
        } catch (InvocationTargetException e3) {
            m132a(e3);
            return null;
        }
    }
}
