package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.bs */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3120bs implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f11353a;

    DialogInterfaceOnClickListenerC3120bs(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f11353a = profileImageHistoryFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f11353a.m10846l();
        this.f11353a.f11256p.m5931a(this.f11353a.f11224Z, true);
        this.f11353a.f11255o.show();
    }
}
