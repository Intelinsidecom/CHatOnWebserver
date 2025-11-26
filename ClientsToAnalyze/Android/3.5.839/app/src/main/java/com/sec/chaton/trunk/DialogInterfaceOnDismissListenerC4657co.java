package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.co */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC4657co implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ TrunkView f16868a;

    DialogInterfaceOnDismissListenerC4657co(TrunkView trunkView) {
        this.f16868a = trunkView;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f16868a.f16627N = false;
    }
}
