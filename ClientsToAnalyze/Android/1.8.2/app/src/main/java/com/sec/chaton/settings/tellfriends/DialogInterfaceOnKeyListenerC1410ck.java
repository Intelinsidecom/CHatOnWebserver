package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: TellFriendsWeiboActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ck */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1410ck implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ TellFriendsWeiboActivity f5274a;

    DialogInterfaceOnKeyListenerC1410ck(TellFriendsWeiboActivity tellFriendsWeiboActivity) {
        this.f5274a = tellFriendsWeiboActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.f5274a.f5057c != null && this.f5274a.f5057c.isShowing()) {
            this.f5274a.f5057c.dismiss();
            this.f5274a.f5057c = null;
        }
        this.f5274a.finish();
        return true;
    }
}
