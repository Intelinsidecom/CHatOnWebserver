package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;
import android.content.res.Resources;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1526h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5354a;

    DialogInterfaceOnClickListenerC1526h(AMSComposerActivity aMSComposerActivity) {
        this.f5354a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f5354a.m5393i();
        dialogInterface.dismiss();
        this.f5354a.m5435y();
    }
}
