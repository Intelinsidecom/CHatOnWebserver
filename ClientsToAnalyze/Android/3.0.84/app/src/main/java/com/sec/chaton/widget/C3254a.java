package com.sec.chaton.widget;

import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: AdaptableTextView.java */
/* renamed from: com.sec.chaton.widget.a */
/* loaded from: classes.dex */
public class C3254a {

    /* renamed from: a */
    private static Method f11772a;

    static {
        try {
            f11772a = TextView.class.getMethod("setDeviceDefaultTheme", Boolean.TYPE);
        } catch (NoSuchMethodException e) {
        }
    }

    /* renamed from: a */
    public static void m11479a(TextView textView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f11772a != null) {
            try {
                f11772a.invoke(textView, true);
            } catch (IllegalAccessException e) {
            } catch (IllegalArgumentException e2) {
            } catch (InvocationTargetException e3) {
            }
        }
    }
}
