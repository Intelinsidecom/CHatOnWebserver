package com.sec.vip.amschaton;

import android.content.DialogInterface;

/* renamed from: com.sec.vip.amschaton.cq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0697cq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4319a;

    DialogInterfaceOnClickListenerC0697cq(AMSComposerActivity aMSComposerActivity) {
        this.f4319a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
