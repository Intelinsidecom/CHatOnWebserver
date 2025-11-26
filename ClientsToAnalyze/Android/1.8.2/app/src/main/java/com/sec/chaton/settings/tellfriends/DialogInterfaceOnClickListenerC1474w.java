package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: OauthSignin.java */
/* renamed from: com.sec.chaton.settings.tellfriends.w */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1474w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ OauthSignin f5394a;

    DialogInterfaceOnClickListenerC1474w(OauthSignin oauthSignin) {
        this.f5394a = oauthSignin;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5394a.finish();
    }
}
