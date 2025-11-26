package com.sec.chaton.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.sec.chaton.util.C3225cm;

/* compiled from: ActivityHelper.java */
/* renamed from: com.sec.chaton.base.a */
/* loaded from: classes.dex */
public class C0456a {
    /* renamed from: a */
    public static void m3090a(Activity activity, Bundle bundle) {
        C3225cm.m11337a(activity);
        if (Build.VERSION.SDK_INT >= 11) {
            LayoutInflater.from(activity).setFactory2(new LayoutInflaterFactory2C0457b());
        }
    }
}
