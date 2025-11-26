package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ah */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1477ah implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5288a;

    DialogInterfaceOnClickListenerC1477ah(AMSComposerActivity aMSComposerActivity) {
        this.f5288a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5288a.m5393i();
        dialogInterface.dismiss();
        this.f5288a.m5390h();
    }
}
