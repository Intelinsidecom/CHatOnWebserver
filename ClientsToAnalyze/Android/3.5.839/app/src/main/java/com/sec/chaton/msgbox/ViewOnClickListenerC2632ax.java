package com.sec.chaton.msgbox;

import android.view.View;
import com.sec.chaton.util.C4847bl;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ax */
/* loaded from: classes.dex */
class ViewOnClickListenerC2632ax implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9481a;

    ViewOnClickListenerC2632ax(MsgboxFragment msgboxFragment) {
        this.f9481a = msgboxFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            ((InterfaceC2641bf) this.f9481a.getActivity()).mo3092j();
        }
    }
}
