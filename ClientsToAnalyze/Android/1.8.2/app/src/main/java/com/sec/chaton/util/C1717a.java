package com.sec.chaton.util;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/* compiled from: ActivityHelper.java */
/* renamed from: com.sec.chaton.util.a */
/* loaded from: classes.dex */
public class C1717a {

    /* renamed from: a */
    protected Activity f6317a;

    /* renamed from: a */
    public static C1717a m5866a(Activity activity) {
        return C1770bz.m6008a() ? new C1744b(activity) : new C1717a(activity);
    }

    protected C1717a(Activity activity) {
        this.f6317a = activity;
    }

    /* renamed from: a */
    public void m5867a(Bundle bundle) {
    }

    /* renamed from: a */
    public boolean mo5868a(Menu menu) {
        return false;
    }

    /* renamed from: a */
    public boolean m5869a(MenuItem menuItem) {
        return false;
    }
}
