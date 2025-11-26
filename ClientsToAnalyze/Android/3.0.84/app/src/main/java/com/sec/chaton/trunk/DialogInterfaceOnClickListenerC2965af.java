package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.af */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2965af implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f10745a;

    DialogInterfaceOnClickListenerC2965af(TrunkCommentView trunkCommentView) {
        this.f10745a = trunkCommentView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f10745a.f10506e.setText("");
    }
}
