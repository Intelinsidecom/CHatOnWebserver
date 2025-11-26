package com.sec.chaton.specialbuddy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.support.v4.app.C0014a;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.y */
/* loaded from: classes.dex */
class C4560y extends C0014a {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f16432a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4560y(SpecialBuddyChatFragment specialBuddyChatFragment, Activity activity, DrawerLayout drawerLayout, int i, int i2, int i3) {
        super(activity, drawerLayout, i, i2, i3);
        this.f16432a = specialBuddyChatFragment;
    }

    @Override // android.support.v4.app.C0014a, android.support.v4.widget.InterfaceC0250j
    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void mo70b(View view) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.f16432a.f16346al.invalidateOptionsMenu();
        }
    }

    @Override // android.support.v4.app.C0014a, android.support.v4.widget.InterfaceC0250j
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo67a(View view) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.f16432a.f16346al.invalidateOptionsMenu();
        }
    }
}
