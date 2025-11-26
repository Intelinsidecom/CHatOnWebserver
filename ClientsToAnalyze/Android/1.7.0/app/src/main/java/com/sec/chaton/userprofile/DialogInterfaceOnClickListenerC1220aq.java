package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.p015b.p016a.C0260h;

/* compiled from: ProfileRegistStatusMessage.java */
/* renamed from: com.sec.chaton.userprofile.aq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1220aq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1269s f4297a;

    DialogInterfaceOnClickListenerC1220aq(HandlerC1269s handlerC1269s) {
        this.f4297a = handlerC1269s;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C0260h c0260h = new C0260h();
        c0260h.m941b(this.f4297a.f4366a.f4183b.getText().toString());
        this.f4297a.f4366a.f4184c.m873a(c0260h, "");
        if (!this.f4297a.f4366a.isFinishing()) {
            this.f4297a.f4366a.f4185d.show();
        }
    }
}
