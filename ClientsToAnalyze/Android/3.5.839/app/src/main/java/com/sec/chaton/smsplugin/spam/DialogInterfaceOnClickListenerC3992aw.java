package com.sec.chaton.smsplugin.spam;

import android.content.DialogInterface;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.aw */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3992aw implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberList f14433a;

    DialogInterfaceOnClickListenerC3992aw(SetupSpamNumberList setupSpamNumberList) {
        this.f14433a = setupSpamNumberList;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f14433a.f14364n.postDelayed(new RunnableC3993ax(this), 200L);
        dialogInterface.dismiss();
    }
}
