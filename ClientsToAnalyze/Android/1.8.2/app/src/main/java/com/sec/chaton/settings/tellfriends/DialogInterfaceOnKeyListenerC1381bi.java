package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: TWFollowingsListActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bi */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1381bi implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ TWFollowingsListActivity f5221a;

    DialogInterfaceOnKeyListenerC1381bi(TWFollowingsListActivity tWFollowingsListActivity) {
        this.f5221a = tWFollowingsListActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.f5221a.f5016c != null && this.f5221a.f5016c.isShowing()) {
            this.f5221a.f5016c.dismiss();
            this.f5221a.f5016c = null;
        }
        this.f5221a.finish();
        return true;
    }
}
