package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: OauthSignin.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ac */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1348ac implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1347ab f5155a;

    DialogInterfaceOnClickListenerC1348ac(AsyncTaskC1347ab asyncTaskC1347ab) {
        this.f5155a = asyncTaskC1347ab;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5155a.f5154a.finish();
    }
}
