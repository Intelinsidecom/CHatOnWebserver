package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.be */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1141be implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f3971a;

    DialogInterfaceOnClickListenerC1141be(TrunkCommentView trunkCommentView) {
        this.f3971a = trunkCommentView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f3971a.f3755c != null) {
            this.f3971a.f3755c.mo3961d();
        }
    }
}
