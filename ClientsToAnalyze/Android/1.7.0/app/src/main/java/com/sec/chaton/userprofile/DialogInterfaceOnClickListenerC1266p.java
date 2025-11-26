package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.p015b.p016a.C0260h;

/* compiled from: ProfileRegistPushName.java */
/* renamed from: com.sec.chaton.userprofile.p */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1266p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1222as f4363a;

    DialogInterfaceOnClickListenerC1266p(HandlerC1222as handlerC1222as) {
        this.f4363a = handlerC1222as;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C0260h c0260h = new C0260h();
        c0260h.m939a(this.f4363a.f4299a.f4174b.getText().toString());
        this.f4363a.f4299a.f4178f.m873a(c0260h, "");
        if (!this.f4363a.f4299a.isFinishing()) {
            this.f4363a.f4299a.f4179g.show();
        }
    }
}
