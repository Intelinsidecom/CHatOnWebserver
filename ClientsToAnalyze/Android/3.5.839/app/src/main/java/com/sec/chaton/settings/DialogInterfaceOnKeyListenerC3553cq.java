package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.cq */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC3553cq implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f13042a;

    DialogInterfaceOnKeyListenerC3553cq(ActivityPrivacy activityPrivacy) {
        this.f13042a = activityPrivacy;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f13042a.f12637o.m9523e();
        if (this.f13042a.f12628f != null) {
            this.f13042a.f12628f.dismiss();
        }
        this.f13042a.finish();
        return true;
    }
}
