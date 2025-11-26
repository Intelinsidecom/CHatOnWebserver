package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: FacebookMessageActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.d */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1426d implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ boolean f5309a;

    /* renamed from: b */
    final /* synthetic */ FacebookMessageActivity f5310b;

    DialogInterfaceOnKeyListenerC1426d(FacebookMessageActivity facebookMessageActivity, boolean z) {
        this.f5310b = facebookMessageActivity;
        this.f5309a = z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f5310b.f4928j.dismiss();
        if (this.f5309a) {
            this.f5310b.finish();
        }
        return true;
    }
}
