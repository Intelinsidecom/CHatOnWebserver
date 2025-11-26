package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.p007a.p008a.C0107h;

/* compiled from: ProfileRegistPushName.java */
/* renamed from: com.sec.chaton.userprofile.bb */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1652bb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1651ba f6143a;

    DialogInterfaceOnClickListenerC1652bb(HandlerC1651ba handlerC1651ba) {
        this.f6143a = handlerC1651ba;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C0107h c0107h = new C0107h();
        c0107h.m683a(this.f6143a.f6142a.f5956b.getText().toString());
        this.f6143a.f6142a.f5961j.m2963a(c0107h, "");
        if (!this.f6143a.f6142a.isFinishing()) {
            this.f6143a.f6142a.f5962k.show();
        }
    }
}
