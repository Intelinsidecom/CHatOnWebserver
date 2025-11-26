package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.n */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2047n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7341a;

    DialogInterfaceOnClickListenerC2047n(AMSComposerActivity aMSComposerActivity) {
        this.f7341a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7341a.m6956j();
        dialogInterface.dismiss();
        this.f7341a.f7152M = true;
        this.f7341a.m6946h();
    }
}
