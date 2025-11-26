package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: WeiboMessageActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.do */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1441do implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1440dn f5335a;

    DialogInterfaceOnKeyListenerC1441do(AsyncTaskC1440dn asyncTaskC1440dn) {
        this.f5335a = asyncTaskC1440dn;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f5335a.f5331b = true;
        this.f5335a.f5334e.dismiss();
        return true;
    }
}
