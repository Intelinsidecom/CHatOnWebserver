package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: TwitterSubMenuActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.di */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1435di implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TwitterSubMenuActivity f5319a;

    DialogInterfaceOnClickListenerC1435di(TwitterSubMenuActivity twitterSubMenuActivity) {
        this.f5319a = twitterSubMenuActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f5319a.m5033g();
    }
}
