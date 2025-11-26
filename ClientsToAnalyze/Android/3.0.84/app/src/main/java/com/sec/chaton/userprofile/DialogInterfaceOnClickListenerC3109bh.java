package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3109bh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f11322a;

    DialogInterfaceOnClickListenerC3109bh(MyPageFragment myPageFragment) {
        this.f11322a = myPageFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 3:
                this.f11322a.m10732e("profile");
                break;
        }
    }
}
