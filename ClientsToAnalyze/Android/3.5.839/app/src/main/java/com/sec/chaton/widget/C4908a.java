package com.sec.chaton.widget;

import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: AdaptableTextView.java */
/* renamed from: com.sec.chaton.widget.a */
/* loaded from: classes.dex */
public class C4908a {

    /* renamed from: a */
    private static Method f17954a;

    static {
        try {
            f17954a = TextView.class.getMethod("setDeviceDefaultTheme", Boolean.TYPE);
        } catch (NoSuchMethodException e) {
        }
    }

    /* renamed from: a */
    public static void m18711a(TextView textView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (f17954a != null) {
            try {
                f17954a.invoke(textView, true);
            } catch (IllegalAccessException e) {
            } catch (IllegalArgumentException e2) {
            } catch (InvocationTargetException e3) {
            }
        }
    }
}
