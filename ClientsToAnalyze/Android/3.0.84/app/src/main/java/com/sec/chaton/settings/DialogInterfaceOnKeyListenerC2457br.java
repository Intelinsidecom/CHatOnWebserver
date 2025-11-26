package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: ActivityPrivacy.java */
/* renamed from: com.sec.chaton.settings.br */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC2457br implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPrivacy f9317a;

    DialogInterfaceOnKeyListenerC2457br(ActivityPrivacy activityPrivacy) {
        this.f9317a = activityPrivacy;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f9317a.f9077o.m5740d();
        if (this.f9317a.f9068f != null) {
            this.f9317a.f9068f.dismiss();
        }
        this.f9317a.finish();
        return true;
    }
}
