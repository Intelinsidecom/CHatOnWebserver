package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.ce */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3541ce implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f13029a;

    DialogInterfaceOnClickListenerC3541ce(ActivityPasswordLockSet activityPasswordLockSet) {
        this.f13029a = activityPasswordLockSet;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f13029a.f12583F = false;
    }
}
