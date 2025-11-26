package com.sec.p007b.p008a;

import android.os.Debug;

/* compiled from: CommonUtils.java */
/* renamed from: com.sec.b.a.a */
/* loaded from: classes.dex */
public class C0108a {

    /* renamed from: a */
    private static final String f205a = C0108a.class.getSimpleName();

    /* renamed from: a */
    public static boolean m578a() {
        try {
            return ((Integer) Debug.class.getMethod("isProductShip", null).invoke(null, null)).intValue() == 1;
        } catch (Throwable th) {
            return false;
        }
    }
}
