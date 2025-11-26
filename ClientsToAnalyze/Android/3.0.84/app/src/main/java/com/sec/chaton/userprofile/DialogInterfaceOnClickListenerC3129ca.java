package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.ca */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3129ca implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f11362a;

    DialogInterfaceOnClickListenerC3129ca(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f11362a = profileImageHistoryFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f11362a.m10840i();
                break;
        }
    }
}
