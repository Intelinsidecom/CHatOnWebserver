package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: TellFriendsWeiboActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cl */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC1411cl implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ TellFriendsWeiboActivity f5275a;

    DialogInterfaceOnDismissListenerC1411cl(TellFriendsWeiboActivity tellFriendsWeiboActivity) {
        this.f5275a = tellFriendsWeiboActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f5275a.f5073s) {
            if (this.f5275a.f5071q) {
                this.f5275a.f5071q = false;
            }
            this.f5275a.f5073s = false;
        }
    }
}
