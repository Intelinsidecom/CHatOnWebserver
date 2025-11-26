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
abstract class AbstractC4950e {

    /* renamed from: a */
    protected Activity f18113a;

    /* renamed from: a */
    public abstract void mo18846a(int i);

    /* renamed from: a */
    public abstract void mo18848a(View view);

    /* renamed from: a */
    public abstract void mo18849a(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: a */
    protected abstract void mo18850a(CharSequence charSequence, int i);

    /* renamed from: b */
    public abstract AbstractC4946a mo18853b();

    /* renamed from: a */
    public static AbstractC4950e m18843a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new C4955j(activity);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new C4954i(activity);
        }
        return new C4951f(activity);
    }

    protected AbstractC4950e(Activity activity) {
        this.f18113a = activity;
    }

    /* renamed from: a */
    public void mo18847a(Bundle bundle) {
    }

    /* renamed from: b */
    public void mo18854b(Bundle bundle) {
    }

    /* renamed from: a */
    public boolean mo18851a(Menu menu) {
        return true;
    }

    /* renamed from: b */
    public boolean mo18855b(Menu menu) {
        return true;
    }

    /* renamed from: a */
    public void mo18845a() {
    }

    /* renamed from: a */
    public boolean mo18852a(MenuItem menuItem) {
        return true;
    }

    /* renamed from: a */
    public MenuInflater mo18844a(MenuInflater menuInflater) {
        return menuInflater;
    }
}
