package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: TwitterMessageActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cv */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1421cv implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ TwitterMessageActivity f5302a;

    DialogInterfaceOnKeyListenerC1421cv(TwitterMessageActivity twitterMessageActivity) {
        this.f5302a = twitterMessageActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f5302a.f5089i.dismiss();
        return true;
    }
}
