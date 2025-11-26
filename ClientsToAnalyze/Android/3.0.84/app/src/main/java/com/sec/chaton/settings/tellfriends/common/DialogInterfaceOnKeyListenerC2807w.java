package com.sec.chaton.settings.tellfriends.common;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: SnsSubMenuFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.w */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC2807w implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ boolean f10318a;

    /* renamed from: b */
    final /* synthetic */ SnsSubMenuFragment f10319b;

    DialogInterfaceOnKeyListenerC2807w(SnsSubMenuFragment snsSubMenuFragment, boolean z) {
        this.f10319b = snsSubMenuFragment;
        this.f10318a = z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.f10319b.f10263p != null && this.f10319b.f10263p.isShowing()) {
            this.f10319b.f10263p.dismiss();
            this.f10319b.f10263p = null;
        }
        if (this.f10318a) {
            this.f10319b.f10255h.finish();
        }
        return true;
    }
}
