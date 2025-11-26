package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: SnsSubMenuFragment.java */
/* renamed from: com.sec.chaton.sns.ui.af */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC4452af implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ boolean f16093a;

    /* renamed from: b */
    final /* synthetic */ SnsSubMenuFragment f16094b;

    DialogInterfaceOnKeyListenerC4452af(SnsSubMenuFragment snsSubMenuFragment, boolean z) {
        this.f16094b = snsSubMenuFragment;
        this.f16093a = z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.f16094b.f16065p != null && this.f16094b.f16065p.isShowing()) {
            this.f16094b.f16065p.dismiss();
            this.f16094b.f16065p = null;
        }
        if (this.f16093a) {
            this.f16094b.f16057h.finish();
        }
        return true;
    }
}
