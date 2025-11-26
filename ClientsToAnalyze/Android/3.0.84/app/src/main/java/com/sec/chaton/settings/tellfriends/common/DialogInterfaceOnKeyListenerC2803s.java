package com.sec.chaton.settings.tellfriends.common;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: SnsMessageFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.s */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC2803s implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ boolean f10313a;

    /* renamed from: b */
    final /* synthetic */ SnsMessageFragment f10314b;

    DialogInterfaceOnKeyListenerC2803s(SnsMessageFragment snsMessageFragment, boolean z) {
        this.f10314b = snsMessageFragment;
        this.f10313a = z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.f10314b.f10241g != null && this.f10314b.f10241g.isShowing()) {
            this.f10314b.f10241g.dismiss();
            this.f10314b.f10241g = null;
        }
        if (this.f10313a) {
            this.f10314b.f10235a.finish();
        }
        return true;
    }
}
