package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.i */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2042i implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f7335a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7336b;

    DialogInterfaceOnClickListenerC2042i(AMSComposerActivity aMSComposerActivity, int i) {
        this.f7336b = aMSComposerActivity;
        this.f7335a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7336b.m6956j();
        dialogInterface.dismiss();
        this.f7336b.m6973n(this.f7335a);
    }
}
