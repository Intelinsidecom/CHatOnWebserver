package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ae */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1519ae implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f5547a;

    DialogInterfaceOnClickListenerC1519ae(TrunkCommentView trunkCommentView) {
        this.f5547a = trunkCommentView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f5547a.f5437c != null) {
            this.f5547a.f5437c.mo5219e();
        }
    }
}
