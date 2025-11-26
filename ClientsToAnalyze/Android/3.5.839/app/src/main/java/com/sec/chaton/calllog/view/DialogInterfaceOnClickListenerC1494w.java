package com.sec.chaton.calllog.view;

import android.content.DialogInterface;

/* compiled from: DeleteCallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.w */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1494w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DeleteCallLogFragment f5420a;

    DialogInterfaceOnClickListenerC1494w(DeleteCallLogFragment deleteCallLogFragment) {
        this.f5420a = deleteCallLogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f5420a.m7756h();
        new C1461ac(this.f5420a, this.f5420a.f5294l).start();
    }
}
