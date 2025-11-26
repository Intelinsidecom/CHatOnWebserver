package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: WeiboSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1443dq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ WeiboSignIn f5337a;

    DialogInterfaceOnClickListenerC1443dq(WeiboSignIn weiboSignIn) {
        this.f5337a = weiboSignIn;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5337a.finish();
    }
}
