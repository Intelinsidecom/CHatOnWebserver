package com.sec.vip.amschaton;

import android.content.DialogInterface;

/* renamed from: com.sec.vip.amschaton.bt */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0673bt implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4294a;

    DialogInterfaceOnClickListenerC0673bt(AMSComposerActivity aMSComposerActivity) {
        this.f4294a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
