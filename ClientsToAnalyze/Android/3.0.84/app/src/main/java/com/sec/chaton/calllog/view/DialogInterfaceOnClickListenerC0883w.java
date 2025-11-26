package com.sec.chaton.calllog.view;

import android.content.DialogInterface;

/* compiled from: DeleteCallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.w */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0883w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DeleteCallLogFragment f3475a;

    DialogInterfaceOnClickListenerC0883w(DeleteCallLogFragment deleteCallLogFragment) {
        this.f3475a = deleteCallLogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f3475a.m4600h();
        new C0850ac(this.f3475a, this.f3475a.f3321l).start();
    }
}
