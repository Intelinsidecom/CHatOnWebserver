package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ag */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2966ag implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f10746a;

    DialogInterfaceOnClickListenerC2966ag(TrunkCommentView trunkCommentView) {
        this.f10746a = trunkCommentView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f10746a.f10515n.mo10435a(this.f10746a.f10506e.getText().toString());
        this.f10746a.m10188b();
    }
}
