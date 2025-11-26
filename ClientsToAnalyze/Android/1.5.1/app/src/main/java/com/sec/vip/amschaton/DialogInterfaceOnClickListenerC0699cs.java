package com.sec.vip.amschaton;

import android.content.DialogInterface;

/* renamed from: com.sec.vip.amschaton.cs */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0699cs implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4321a;

    DialogInterfaceOnClickListenerC0699cs(AMSComposerActivity aMSComposerActivity) {
        this.f4321a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
