package com.sec.vip.amschaton;

import android.content.DialogInterface;

/* renamed from: com.sec.vip.amschaton.cc */
/* loaded from: classes.dex */
class DialogInterfaceOnShowListenerC0683cc implements DialogInterface.OnShowListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4304a;

    DialogInterfaceOnShowListenerC0683cc(AMSComposerActivity aMSComposerActivity) {
        this.f4304a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        this.f4304a.f3863n.setPadding(0, 0, 0, 0);
    }
}
