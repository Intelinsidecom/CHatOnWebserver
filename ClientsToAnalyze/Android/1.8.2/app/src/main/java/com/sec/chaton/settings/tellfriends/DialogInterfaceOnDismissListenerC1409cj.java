package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: TellFriendsWeiboActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cj */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC1409cj implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ TellFriendsWeiboActivity f5273a;

    DialogInterfaceOnDismissListenerC1409cj(TellFriendsWeiboActivity tellFriendsWeiboActivity) {
        this.f5273a = tellFriendsWeiboActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f5273a.f5073s) {
            if (this.f5273a.f5071q) {
                this.f5273a.f5071q = false;
            }
            this.f5273a.f5073s = false;
        }
    }
}
