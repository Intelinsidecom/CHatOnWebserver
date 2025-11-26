package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;
import android.content.res.Resources;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.q */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2050q implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7344a;

    DialogInterfaceOnClickListenerC2050q(AMSComposerActivity aMSComposerActivity) {
        this.f7344a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f7344a.m6956j();
        dialogInterface.dismiss();
        this.f7344a.m6882B();
    }
}
