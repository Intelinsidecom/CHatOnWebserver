package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import java.io.IOException;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.bx */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3125bx implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f11358a;

    DialogInterfaceOnClickListenerC3125bx(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f11358a = profileImageHistoryFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws IOException {
        this.f11358a.m10799a(i);
    }
}
