package com.sec.chaton.mobileweb;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.support.v4.app.C0014a;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

/* compiled from: GeneralWebFragment.java */
/* renamed from: com.sec.chaton.mobileweb.g */
/* loaded from: classes.dex */
class C2593g extends C0014a {

    /* renamed from: a */
    final /* synthetic */ GeneralWebFragment f9253a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2593g(GeneralWebFragment generalWebFragment, Activity activity, DrawerLayout drawerLayout, int i, int i2, int i3) {
        super(activity, drawerLayout, i, i2, i3);
        this.f9253a = generalWebFragment;
    }

    @Override // android.support.v4.app.C0014a, android.support.v4.widget.InterfaceC0250j
    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void mo70b(View view) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.f9253a.f9216t.invalidateOptionsMenu();
        }
    }

    @Override // android.support.v4.app.C0014a, android.support.v4.widget.InterfaceC0250j
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo67a(View view) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.f9253a.f9216t.invalidateOptionsMenu();
        }
    }
}
