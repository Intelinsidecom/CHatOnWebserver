package com.google.p034a.p036b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator.java */
/* renamed from: com.google.a.b.ak */
/* loaded from: classes.dex */
public abstract class AbstractC0634ak {
    /* renamed from: a */
    public abstract <T> T mo2045a(Class<T> cls);

    /* renamed from: a */
    public static AbstractC0634ak m2044a() throws NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new C0635al(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception e) {
            try {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                return new C0636am(declaredMethod);
            } catch (Exception e2) {
                try {
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod2.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
                    Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod3.setAccessible(true);
                    return new C0637an(declaredMethod3, iIntValue);
                } catch (Exception e3) {
                    return new C0638ao();
                }
            }
        }
    }
}
