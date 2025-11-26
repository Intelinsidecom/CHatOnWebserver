package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.ax */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1538ax implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f5588a;

    /* renamed from: b */
    final /* synthetic */ TrunkItemView f5589b;

    DialogInterfaceOnClickListenerC1538ax(TrunkItemView trunkItemView, String str) {
        this.f5589b = trunkItemView;
        this.f5588a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5589b.m5288n();
        this.f5589b.f5474Z.mo5392a(this.f5588a);
    }
}
