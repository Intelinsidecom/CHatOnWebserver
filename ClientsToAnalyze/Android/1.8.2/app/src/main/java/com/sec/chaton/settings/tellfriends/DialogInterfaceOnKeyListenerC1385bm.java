package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: TWFollowingsListActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bm */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1385bm implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1384bl f5232a;

    DialogInterfaceOnKeyListenerC1385bm(AsyncTaskC1384bl asyncTaskC1384bl) {
        this.f5232a = asyncTaskC1384bl;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f5232a.f5229a = true;
        this.f5232a.f5231c.f5016c.dismiss();
        return true;
    }
}
