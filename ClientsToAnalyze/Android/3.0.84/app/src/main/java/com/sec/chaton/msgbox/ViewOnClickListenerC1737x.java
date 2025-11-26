package com.sec.chaton.msgbox;

import android.view.View;
import com.sec.chaton.util.C3250y;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.x */
/* loaded from: classes.dex */
class ViewOnClickListenerC1737x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f6410a;

    ViewOnClickListenerC1737x(MsgboxFragment msgboxFragment) {
        this.f6410a = msgboxFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((InterfaceC1701ae) this.f6410a.getActivity()).mo1318b();
        C3250y.m11450b("startActivity(CallLogActivity.class)", getClass().getSimpleName());
    }
}
