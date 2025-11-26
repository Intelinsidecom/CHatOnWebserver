package com.samsung.android.sdk.pen.plugin.framework;

import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
class DoubleClassLoaderProxyBuilder {

    public static class DoubleClassLoaderInvocationHandler implements InvocationHandler {
        private Class<?> clazz;
        public Object instance;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] aobj) throws Throwable {
            Object obj1 = this.clazz.getMethod(method.getName(), method.getParameterTypes()).invoke(this.instance, aobj);
            return obj1;
        }

        public DoubleClassLoaderInvocationHandler(Class<?> class1, ClassLoader classloader, Object obj) throws ClassNotFoundException {
            this.clazz = Class.forName(class1.getName(), true, classloader);
            this.instance = obj;
        }

        public DoubleClassLoaderInvocationHandler(Class<?> class1, String s, ClassLoader classloader) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
            this.clazz = Class.forName(class1.getName(), true, classloader);
            this.instance = Class.forName(s, true, classloader).newInstance();
        }
    }

    public static Object build(Class<?> class1, Object obj, ClassLoader classloader) throws ClassNotFoundException {
        Log.i("PLUGIN_DEBUG_TAG", "build proxy for " + obj);
        if (!class1.isInterface()) {
            throw new IllegalArgumentException(class1 + " should be interface");
        }
        ClassLoader classloader1 = class1.getClassLoader();
        DoubleClassLoaderInvocationHandler doubleclassloaderinvocationhandler = new DoubleClassLoaderInvocationHandler(class1, classloader, obj);
        Class[] aclass = {class1};
        return Proxy.newProxyInstance(classloader1, aclass, doubleclassloaderinvocationhandler);
    }

    public static Object build(Class<?> class1, String s, ClassLoader classloader) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Log.i("PLUGIN_DEBUG_TAG", "build proxy for " + s);
        if (!class1.isInterface()) {
            throw new IllegalArgumentException(class1 + " should be interface");
        }
        ClassLoader classloader1 = class1.getClassLoader();
        Class[] aclass = {class1};
        InvocationHandler h = new DoubleClassLoaderInvocationHandler(class1, s, classloader);
        return Proxy.newProxyInstance(classloader1, aclass, h);
    }
}
