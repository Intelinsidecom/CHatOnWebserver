package com.sec.common.p130e;

import android.os.Handler;
import android.os.Looper;
import com.sec.common.C4996f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Neuron.java */
/* renamed from: com.sec.common.e.a */
/* loaded from: classes.dex */
public class C4992a {

    /* renamed from: a */
    private static final String f18222a = C4992a.class.getSimpleName();

    /* renamed from: b */
    private static final Handler f18223b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private Map<Class<?>, List<C4994c>> f18224c = new HashMap();

    /* renamed from: a */
    public void m18959a(Object obj) {
        for (Method method : m18958e(obj)) {
            Class<?> cls = method.getParameterTypes()[0];
            synchronized (this) {
                List<C4994c> arrayList = this.f18224c.get(cls);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f18224c.put(cls, arrayList);
                }
                arrayList.add(new C4994c(obj, method));
            }
        }
    }

    /* renamed from: b */
    public void m18960b(Object obj) {
        Iterator<Method> it = m18958e(obj).iterator();
        while (it.hasNext()) {
            Class<?> cls = it.next().getParameterTypes()[0];
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                List<C4994c> list = this.f18224c.get(cls);
                for (C4994c c4994c : list) {
                    if (c4994c.f18227a == obj) {
                        arrayList.add(c4994c);
                    }
                }
                list.removeAll(arrayList);
                if (list.isEmpty()) {
                    this.f18224c.remove(cls);
                }
            }
        }
    }

    /* renamed from: c */
    public void m18961c(Object obj) {
        if (Thread.currentThread() != f18223b.getLooper().getThread()) {
            m18962d(obj);
        }
        Class<?> cls = obj.getClass();
        synchronized (this) {
            if (this.f18224c.containsKey(cls)) {
                for (C4994c c4994c : this.f18224c.get(cls)) {
                    try {
                        c4994c.f18228b.invoke(c4994c.f18227a, obj);
                    } catch (IllegalAccessException e) {
                        if (C4996f.f18229a.f18174f) {
                            C4996f.f18229a.mo18649a(f18222a, e.getMessage(), e);
                        }
                    } catch (InvocationTargetException e2) {
                        if (C4996f.f18229a.f18174f) {
                            C4996f.f18229a.mo18649a(f18222a, e2.getMessage(), e2);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void m18962d(Object obj) {
        if (Thread.currentThread() == f18223b.getLooper().getThread()) {
            m18961c(obj);
        } else {
            f18223b.post(new RunnableC4993b(this, obj));
        }
    }

    /* renamed from: e */
    private List<Method> m18958e(Object obj) throws SecurityException {
        ArrayList arrayList = new ArrayList();
        for (Method method : obj.getClass().getMethods()) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (method.isAnnotationPresent(InterfaceC4995d.class)) {
                if (parameterTypes.length != 1) {
                    throw new IllegalArgumentException("Subscriber should has one argment.");
                }
                arrayList.add(method);
            }
        }
        return arrayList;
    }
}
