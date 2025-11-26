package com.sec.chaton.calllog.view;

import android.content.DialogInterface;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.b */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0860b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CallLogDetailFragment f3379a;

    DialogInterfaceOnClickListenerC0860b(CallLogDetailFragment callLogDetailFragment) {
        this.f3379a = callLogDetailFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f3379a.m4547s();
        new C0869k(this.f3379a, this.f3379a.f3244c).start();
    }
}
