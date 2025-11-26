package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: TWFollowingsListActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bg */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1379bg implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ TWFollowingsListActivity f5219a;

    DialogInterfaceOnKeyListenerC1379bg(TWFollowingsListActivity tWFollowingsListActivity) {
        this.f5219a = tWFollowingsListActivity;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.f5219a.f5016c != null && this.f5219a.f5016c.isShowing()) {
            this.f5219a.f5016c.dismiss();
            this.f5219a.f5016c = null;
        }
        this.f5219a.finish();
        return true;
    }
}
