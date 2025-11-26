package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ag */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4582ag implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f16692a;

    DialogInterfaceOnClickListenerC4582ag(TrunkCommentView trunkCommentView) {
        this.f16692a = trunkCommentView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f16692a.f16445e.setText("");
    }
}
