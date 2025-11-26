package com.sec.chaton.msgbox;

import android.view.View;
import com.sec.chaton.util.C3250y;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.v */
/* loaded from: classes.dex */
class ViewOnClickListenerC1735v implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f6408a;

    ViewOnClickListenerC1735v(MsgboxFragment msgboxFragment) {
        this.f6408a = msgboxFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((InterfaceC1701ae) this.f6408a.getActivity()).mo1318b();
        C3250y.m11450b("startActivity(CallLogActivity.class)", getClass().getSimpleName());
    }
}
