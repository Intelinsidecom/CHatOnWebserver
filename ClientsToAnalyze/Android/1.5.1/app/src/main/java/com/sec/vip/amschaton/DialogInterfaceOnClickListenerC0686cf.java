package com.sec.vip.amschaton;

import android.content.DialogInterface;

/* renamed from: com.sec.vip.amschaton.cf */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0686cf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4307a;

    DialogInterfaceOnClickListenerC0686cf(AMSComposerActivity aMSComposerActivity) {
        this.f4307a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4307a.f3855ae = i;
    }
}
