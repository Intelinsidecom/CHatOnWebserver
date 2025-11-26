package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.br */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3000br implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11115a;

    DialogInterfaceOnClickListenerC3000br(PostONWriteFragment postONWriteFragment) {
        this.f11115a = postONWriteFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f11115a.f10997ad != null) {
            this.f11115a.f10997ad.m12356a();
        }
        this.f11115a.f10998ae = true;
    }
}
