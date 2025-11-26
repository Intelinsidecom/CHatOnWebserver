package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: WeiboSubMenuActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dy */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1451dy implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ WeiboSubMenuActivity f5346a;

    DialogInterfaceOnClickListenerC1451dy(WeiboSubMenuActivity weiboSubMenuActivity) {
        this.f5346a = weiboSubMenuActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f5346a.m5064f();
    }
}
