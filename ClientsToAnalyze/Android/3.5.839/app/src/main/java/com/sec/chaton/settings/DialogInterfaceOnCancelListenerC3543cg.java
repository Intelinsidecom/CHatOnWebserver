package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.cg */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3543cg implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f13031a;

    DialogInterfaceOnCancelListenerC3543cg(ActivityPasswordLockSet activityPasswordLockSet) {
        this.f13031a = activityPasswordLockSet;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f13031a.f12583F = false;
    }
}
