package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: SnsMessageFragment.java */
/* renamed from: com.sec.chaton.sns.ui.ab */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC4448ab implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ boolean f16088a;

    /* renamed from: b */
    final /* synthetic */ SnsMessageFragment f16089b;

    DialogInterfaceOnKeyListenerC4448ab(SnsMessageFragment snsMessageFragment, boolean z) {
        this.f16089b = snsMessageFragment;
        this.f16088a = z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.f16089b.f16043g != null && this.f16089b.f16043g.isShowing()) {
            this.f16089b.f16043g.dismiss();
            this.f16089b.f16043g = null;
        }
        if (this.f16088a) {
            this.f16089b.f16037a.finish();
        }
        return true;
    }
}
