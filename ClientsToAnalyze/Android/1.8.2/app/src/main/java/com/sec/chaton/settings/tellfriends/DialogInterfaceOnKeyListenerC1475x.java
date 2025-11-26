package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: OauthSignin.java */
/* renamed from: com.sec.chaton.settings.tellfriends.x */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1475x implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ OauthSignin f5395a;

    DialogInterfaceOnKeyListenerC1475x(OauthSignin oauthSignin) {
        this.f5395a = oauthSignin;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f5395a.f4977h.dismiss();
        this.f5395a.finish();
        return true;
    }
}
