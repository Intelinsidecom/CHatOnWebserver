package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: TellFriendsWeiboActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cn */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1413cn implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1412cm f5279a;

    DialogInterfaceOnKeyListenerC1413cn(AsyncTaskC1412cm asyncTaskC1412cm) {
        this.f5279a = asyncTaskC1412cm;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f5279a.f5276a = true;
        this.f5279a.f5278c.f5057c.dismiss();
        return true;
    }
}
