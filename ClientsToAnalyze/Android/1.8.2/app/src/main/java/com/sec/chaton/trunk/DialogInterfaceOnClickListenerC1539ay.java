package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.ay */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1539ay implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f5590a;

    DialogInterfaceOnClickListenerC1539ay(TrunkItemView trunkItemView) {
        this.f5590a = trunkItemView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f5590a.f5488g != null) {
            this.f5590a.f5488g.mo5224b_();
        }
    }
}
