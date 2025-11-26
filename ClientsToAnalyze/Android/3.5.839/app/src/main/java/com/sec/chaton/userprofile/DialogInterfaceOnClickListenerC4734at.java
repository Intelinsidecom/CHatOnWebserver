package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.at */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4734at implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f17398a;

    DialogInterfaceOnClickListenerC4734at(MyPageFragment myPageFragment) {
        this.f17398a = myPageFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f17398a.m17894b("profile");
                break;
        }
    }
}
