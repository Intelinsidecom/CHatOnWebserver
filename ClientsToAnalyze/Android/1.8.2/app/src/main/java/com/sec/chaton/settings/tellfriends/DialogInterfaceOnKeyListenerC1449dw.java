package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: WeiboSubMenuActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dw */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1449dw implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ boolean f5343a;

    /* renamed from: b */
    final /* synthetic */ WeiboSubMenuActivity f5344b;

    DialogInterfaceOnKeyListenerC1449dw(WeiboSubMenuActivity weiboSubMenuActivity, boolean z) {
        this.f5344b = weiboSubMenuActivity;
        this.f5343a = z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.f5344b.f5138h != null && this.f5344b.f5138h.isShowing()) {
            this.f5344b.f5138h.dismiss();
            this.f5344b.f5138h = null;
        }
        if (this.f5343a) {
            this.f5344b.finish();
        }
        return true;
    }
}
