package com.sec.chaton.chat.p023a;

import android.view.View;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: SystemBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.aa */
/* loaded from: classes.dex */
class ViewOnClickListenerC0889aa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f3813a;

    /* renamed from: b */
    final /* synthetic */ String[] f3814b;

    /* renamed from: c */
    final /* synthetic */ C0922z f3815c;

    ViewOnClickListenerC0889aa(C0922z c0922z, String str, String[] strArr) {
        this.f3815c = c0922z;
        this.f3813a = str;
        this.f3814b = strArr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f3815c.f3789c);
        abstractC3271aM11494a.mo11495a(R.string.chat_view_menu_invite);
        abstractC3271aM11494a.mo11509b(this.f3813a).mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0891ac(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0890ab(this));
        abstractC3271aM11494a.mo11512b();
    }
}
