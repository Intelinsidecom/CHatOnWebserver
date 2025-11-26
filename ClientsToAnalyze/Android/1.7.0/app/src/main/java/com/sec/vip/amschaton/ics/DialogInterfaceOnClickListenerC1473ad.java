package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ad */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1473ad implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f5281a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f5282b;

    DialogInterfaceOnClickListenerC1473ad(AMSComposerActivity aMSComposerActivity, int i) {
        this.f5282b = aMSComposerActivity;
        this.f5281a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5282b.m5393i();
        dialogInterface.dismiss();
        this.f5282b.m5379f(this.f5281a);
    }
}
