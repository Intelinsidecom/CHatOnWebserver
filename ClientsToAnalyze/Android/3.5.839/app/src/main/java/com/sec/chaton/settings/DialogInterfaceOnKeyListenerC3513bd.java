package com.sec.chaton.settings;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: ActivityManageAccounts.java */
/* renamed from: com.sec.chaton.settings.bd */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC3513bd implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ ActivityManageAccounts f13001a;

    DialogInterfaceOnKeyListenerC3513bd(ActivityManageAccounts activityManageAccounts) {
        this.f13001a = activityManageAccounts;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (this.f13001a.f12531n != null) {
            this.f13001a.f12531n.dismiss();
        }
        return true;
    }
}
