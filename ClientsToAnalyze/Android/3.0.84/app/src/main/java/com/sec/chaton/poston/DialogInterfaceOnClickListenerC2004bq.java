package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2004bq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7719a;

    DialogInterfaceOnClickListenerC2004bq(PostONWriteFragment postONWriteFragment) {
        this.f7719a = postONWriteFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f7719a.f7600aa != null) {
            this.f7719a.f7600aa.m8036a();
        }
        this.f7719a.f7601ab = true;
    }
}
