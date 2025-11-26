package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.p007a.p008a.C0107h;

/* compiled from: ProfileRegistStatusMessage.java */
/* renamed from: com.sec.chaton.userprofile.bf */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1656bf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1655be f6147a;

    DialogInterfaceOnClickListenerC1656bf(HandlerC1655be handlerC1655be) {
        this.f6147a = handlerC1655be;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C0107h c0107h = new C0107h();
        c0107h.m685b(this.f6147a.f6146a.f5966b.getText().toString());
        this.f6147a.f6146a.f5971j.m2963a(c0107h, "");
        if (!this.f6147a.f6146a.isFinishing()) {
            this.f6147a.f6146a.f5972k.show();
        }
    }
}
