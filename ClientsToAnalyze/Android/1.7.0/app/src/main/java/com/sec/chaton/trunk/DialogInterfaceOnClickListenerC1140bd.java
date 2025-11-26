package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.bd */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1140bd implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f3970a;

    DialogInterfaceOnClickListenerC1140bd(TrunkCommentView trunkCommentView) {
        this.f3970a = trunkCommentView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3970a.f3764l.mo4180a(this.f3970a.f3757e.getText().toString());
        this.f3970a.m3974b();
    }
}
