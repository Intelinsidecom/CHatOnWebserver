package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: TwitterSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.da */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1427da implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ TwitterSignIn f5311a;

    DialogInterfaceOnKeyListenerC1427da(TwitterSignIn twitterSignIn) {
        this.f5311a = twitterSignIn;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f5311a.f5096g.dismiss();
        this.f5311a.finish();
        return true;
    }
}
