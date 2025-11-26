package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bd */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3105bd implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f11318a;

    DialogInterfaceOnClickListenerC3105bd(MyPageFragment myPageFragment) {
        this.f11318a = myPageFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
