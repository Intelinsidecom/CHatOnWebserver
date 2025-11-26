package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: FacebookSubMenuActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1459h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookSubMenuActivity f5366a;

    DialogInterfaceOnClickListenerC1459h(FacebookSubMenuActivity facebookSubMenuActivity) {
        this.f5366a = facebookSubMenuActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f5366a.m4787h();
    }
}
