package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: TwitterSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1425cz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TwitterSignIn f5308a;

    DialogInterfaceOnClickListenerC1425cz(TwitterSignIn twitterSignIn) {
        this.f5308a = twitterSignIn;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5308a.finish();
    }
}
