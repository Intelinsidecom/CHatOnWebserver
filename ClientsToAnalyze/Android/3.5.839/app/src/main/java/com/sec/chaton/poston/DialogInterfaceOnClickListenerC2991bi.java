package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bi */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2991bi implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11106a;

    DialogInterfaceOnClickListenerC2991bi(PostONWriteFragment postONWriteFragment) {
        this.f11106a = postONWriteFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        if (this.f11106a.f10974F != null && this.f11106a.f10974F.isShowing()) {
            this.f11106a.f10974F.dismiss();
        }
        if (this.f11106a.f10973E != null && this.f11106a.f10973E.isShowing()) {
            this.f11106a.f10973E.dismiss();
        }
    }
}
