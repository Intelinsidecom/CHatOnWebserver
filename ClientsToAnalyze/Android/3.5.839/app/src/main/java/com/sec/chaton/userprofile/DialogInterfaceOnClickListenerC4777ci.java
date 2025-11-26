package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.ci */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4777ci implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f17495a;

    DialogInterfaceOnClickListenerC4777ci(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f17495a = profileImageHistoryFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
