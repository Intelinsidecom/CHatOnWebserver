package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: WeiboSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dr */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1444dr implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ WeiboSignIn f5338a;

    DialogInterfaceOnKeyListenerC1444dr(WeiboSignIn weiboSignIn) {
        this.f5338a = weiboSignIn;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f5338a.f5127g.dismiss();
        this.f5338a.finish();
        return true;
    }
}
