package com.sec.chaton.calllog.view;

import android.content.DialogInterface;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.b */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1471b implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CallLogDetailFragment f5352a;

    DialogInterfaceOnClickListenerC1471b(CallLogDetailFragment callLogDetailFragment) {
        this.f5352a = callLogDetailFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f5352a.m7702t();
        new C1480k(this.f5352a, this.f5352a.f5216c).start();
    }
}
