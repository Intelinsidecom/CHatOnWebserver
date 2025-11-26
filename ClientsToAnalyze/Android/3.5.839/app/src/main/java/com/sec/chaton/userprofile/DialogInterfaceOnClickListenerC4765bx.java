package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.bx */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4765bx implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f17483a;

    DialogInterfaceOnClickListenerC4765bx(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f17483a = profileImageHistoryFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f17483a.m17995i();
                break;
        }
    }
}
