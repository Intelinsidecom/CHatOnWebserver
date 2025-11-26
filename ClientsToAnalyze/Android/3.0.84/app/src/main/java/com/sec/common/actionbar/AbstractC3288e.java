package com.sec.common.actionbar;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ActionBarHelper.java */
/* renamed from: com.sec.common.actionbar.e */
/* loaded from: classes.dex */
abstract class AbstractC3288e {

    /* renamed from: a */
    protected Activity f11915a;

    /* renamed from: a */
    public abstract void mo11607a(int i);

    /* renamed from: a */
    public abstract void mo11609a(View view);

    /* renamed from: a */
    public abstract void mo11610a(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: a */
    protected abstract void mo11611a(CharSequence charSequence, int i);

    /* renamed from: b */
    public abstract AbstractC3284a mo11614b();

    /* renamed from: a */
    public static AbstractC3288e m11604a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new C3293j(activity);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new C3292i(activity);
        }
        return new C3289f(activity);
    }

    protected AbstractC3288e(Activity activity) {
        this.f11915a = activity;
    }

    /* renamed from: a */
    public void mo11608a(Bundle bundle) {
    }

    /* renamed from: b */
    public void mo11615b(Bundle bundle) {
    }

    /* renamed from: a */
    public boolean mo11612a(Menu menu) {
        return true;
    }

    /* renamed from: b */
    public boolean mo11616b(Menu menu) {
        return true;
    }

    /* renamed from: a */
    public void mo11606a() {
    }

    /* renamed from: a */
    public boolean mo11613a(MenuItem menuItem) {
        return true;
    }

    /* renamed from: a */
    public MenuInflater mo11605a(MenuInflater menuInflater) {
        return menuInflater;
    }
}
