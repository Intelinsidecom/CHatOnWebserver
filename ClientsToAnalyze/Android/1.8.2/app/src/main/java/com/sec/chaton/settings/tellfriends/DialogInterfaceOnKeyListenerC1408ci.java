package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: TellFriendsWeiboActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ci */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1408ci implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ TellFriendsWeiboActivity f5272a;

    DialogInterfaceOnKeyListenerC1408ci(TellFriendsWeiboActivity tellFriendsWeiboActivity) {
        this.f5272a = tellFriendsWeiboActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.f5272a.f5057c != null && this.f5272a.f5057c.isShowing()) {
            this.f5272a.f5057c.dismiss();
            this.f5272a.f5057c = null;
        }
        this.f5272a.finish();
        return true;
    }
}
