package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: ActivityPasswordLockSet.java */
/* renamed from: com.sec.chaton.settings.bf */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2445bf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockSet f9305a;

    DialogInterfaceOnClickListenerC2445bf(ActivityPasswordLockSet activityPasswordLockSet) {
        this.f9305a = activityPasswordLockSet;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f9305a.f9023C = false;
    }
}
