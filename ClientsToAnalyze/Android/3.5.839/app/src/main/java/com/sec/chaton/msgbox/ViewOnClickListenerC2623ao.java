package com.sec.chaton.msgbox;

import android.view.View;
import com.sec.chaton.util.C4904y;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ao */
/* loaded from: classes.dex */
class ViewOnClickListenerC2623ao implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9472a;

    ViewOnClickListenerC2623ao(MsgboxFragment msgboxFragment) {
        this.f9472a = msgboxFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((InterfaceC2641bf) this.f9472a.getActivity()).mo3091i();
        C4904y.m18639b("startActivity(CallLogActivity.class)", MsgboxFragment.f9318i);
    }
}
