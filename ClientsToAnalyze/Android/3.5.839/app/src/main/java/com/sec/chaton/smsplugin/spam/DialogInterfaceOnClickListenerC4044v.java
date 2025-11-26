package com.sec.chaton.smsplugin.spam;

import android.content.DialogInterface;

/* compiled from: SetupSpamKeywordList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.v */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4044v implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamKeywordList f14558a;

    DialogInterfaceOnClickListenerC4044v(SetupSpamKeywordList setupSpamKeywordList) {
        this.f14558a = setupSpamKeywordList;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f14558a.f14300a.postDelayed(new RunnableC4045w(this), 200L);
        dialogInterface.dismiss();
    }
}
