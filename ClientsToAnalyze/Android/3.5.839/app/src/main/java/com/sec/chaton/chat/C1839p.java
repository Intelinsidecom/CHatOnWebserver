package com.sec.chaton.chat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.support.v4.app.C0014a;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.p */
/* loaded from: classes.dex */
class C1839p extends C0014a {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6961a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1839p(ChatFragment chatFragment, Activity activity, DrawerLayout drawerLayout, int i, int i2, int i3) {
        super(activity, drawerLayout, i, i2, i3);
        this.f6961a = chatFragment;
    }

    @Override // android.support.v4.app.C0014a, android.support.v4.widget.InterfaceC0250j
    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void mo70b(View view) {
        this.f6961a.f5694dg.setClickable(true);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f6961a.f5624cN.invalidateOptionsMenu();
        }
    }

    @Override // android.support.v4.app.C0014a, android.support.v4.widget.InterfaceC0250j
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo67a(View view) {
        this.f6961a.f5694dg.setClickable(false);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f6961a.f5624cN.invalidateOptionsMenu();
        }
        this.f6961a.f5564bF.clearFocus();
        this.f6961a.mo8272q();
    }
}
