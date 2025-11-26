package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.bh */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2447bh implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f9307a;

    DialogInterfaceOnCancelListenerC2447bh(ActivityPasswordLockSet activityPasswordLockSet) {
        this.f9307a = activityPasswordLockSet;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f9307a.f9023C = false;
    }
}
