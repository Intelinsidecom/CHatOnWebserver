package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.bc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1139bc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f3969a;

    DialogInterfaceOnClickListenerC1139bc(TrunkCommentView trunkCommentView) {
        this.f3969a = trunkCommentView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3969a.f3757e.setText("");
    }
}
