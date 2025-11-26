package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1995bh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7710a;

    DialogInterfaceOnClickListenerC1995bh(PostONWriteFragment postONWriteFragment) {
        this.f7710a = postONWriteFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        if (this.f7710a.f7578D != null && this.f7710a.f7578D.isShowing()) {
            this.f7710a.f7578D.dismiss();
        }
        if (this.f7710a.f7577C != null && this.f7710a.f7577C.isShowing()) {
            this.f7710a.f7577C.dismiss();
        }
    }
}
