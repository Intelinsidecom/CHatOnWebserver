package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4188dp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4108aq f15513a;

    /* renamed from: b */
    final /* synthetic */ HandlerC4186dn f15514b;

    DialogInterfaceOnClickListenerC4188dp(HandlerC4186dn handlerC4186dn, C4108aq c4108aq) {
        this.f15514b = handlerC4186dn;
        this.f15513a = c4108aq;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean z = true;
        if (i == 0 || i != 1) {
            z = false;
        }
        switch (z) {
            case false:
                if (new C4132bn(this.f15514b.f15511a.getApplicationContext(), this.f15514b.f15511a, this.f15513a, this.f15513a.m16307j(), this.f15513a.f15267b).m16386a(this.f15513a, this.f15514b.f15511a.f14935G, false)) {
                    this.f15514b.f15511a.m15965a(new RunnableC4189dq(this));
                    break;
                }
                break;
            case true:
                this.f15514b.f15511a.m15936a(new DialogInterfaceOnClickListenerC4251fy(this.f15514b.f15511a, this.f15513a.f15283r, this.f15513a.f15273h), this.f15513a.f15273h);
                break;
        }
        dialogInterface.cancel();
    }
}
