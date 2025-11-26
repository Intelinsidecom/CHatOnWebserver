package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ah */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4583ah implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f16693a;

    DialogInterfaceOnClickListenerC4583ah(TrunkCommentView trunkCommentView) {
        this.f16693a = trunkCommentView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f16693a.f16454n.mo17531a(this.f16693a.f16445e.getText().toString());
        this.f16693a.m17278b();
    }
}
