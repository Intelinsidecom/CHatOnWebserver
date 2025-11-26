package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.as */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4733as implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f17397a;

    DialogInterfaceOnClickListenerC4733as(MyPageFragment myPageFragment) {
        this.f17397a = myPageFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f17397a.m17894b("profile");
                break;
            case 1:
                this.f17397a.m17898c("profile");
                break;
        }
    }
}
