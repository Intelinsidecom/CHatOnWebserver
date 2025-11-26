package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ad */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1518ad implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f5546a;

    DialogInterfaceOnClickListenerC1518ad(TrunkCommentView trunkCommentView) {
        this.f5546a = trunkCommentView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5546a.f5446l.mo5491a(this.f5546a.f5439e.getText().toString());
        this.f5546a.m5237b();
    }
}
