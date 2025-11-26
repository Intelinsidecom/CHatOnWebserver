package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: SnsFriendsUsingChatOnActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.aj */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1355aj implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ boolean f5172a;

    /* renamed from: b */
    final /* synthetic */ SnsFriendsUsingChatOnActivity f5173b;

    DialogInterfaceOnKeyListenerC1355aj(SnsFriendsUsingChatOnActivity snsFriendsUsingChatOnActivity, boolean z) {
        this.f5173b = snsFriendsUsingChatOnActivity;
        this.f5172a = z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f5173b.f4987e.dismiss();
        if (this.f5172a) {
            this.f5173b.finish();
        }
        return true;
    }
}
