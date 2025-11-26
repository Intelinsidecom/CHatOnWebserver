package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ac */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1517ac implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f5545a;

    DialogInterfaceOnClickListenerC1517ac(TrunkCommentView trunkCommentView) {
        this.f5545a = trunkCommentView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5545a.f5439e.setText("");
    }
}
