package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3108bg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f11321a;

    DialogInterfaceOnClickListenerC3108bg(MyPageFragment myPageFragment) {
        this.f11321a = myPageFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                this.f11321a.m10734f("profile");
                break;
            case 1:
                this.f11321a.m10732e("profile");
                break;
        }
    }
}
