package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.p046a.p047a.C0792p;

/* compiled from: EditNameFragment.java */
/* renamed from: com.sec.chaton.userprofile.r */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4799r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC4798q f17531a;

    DialogInterfaceOnClickListenerC4799r(HandlerC4798q handlerC4798q) {
        this.f17531a = handlerC4798q;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C0792p c0792p = new C0792p();
        c0792p.m3156a(this.f17531a.f17530a.f17120c.getText().toString().trim());
        this.f17531a.f17530a.f17121d.m9304a(c0792p, "");
        this.f17531a.f17530a.f17122e.show();
    }
}
