package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;
import android.content.res.Resources;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.j */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1959j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7106a;

    DialogInterfaceOnClickListenerC1959j(AMSComposerActivity aMSComposerActivity) {
        this.f7106a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f7106a.m6625j();
        dialogInterface.dismiss();
        this.f7106a.m6659x();
    }
}
