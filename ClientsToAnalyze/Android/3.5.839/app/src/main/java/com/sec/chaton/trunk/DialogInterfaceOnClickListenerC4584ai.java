package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ai */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4584ai implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f16694a;

    DialogInterfaceOnClickListenerC4584ai(TrunkCommentView trunkCommentView) {
        this.f16694a = trunkCommentView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f16694a.f16443c != null) {
            this.f16694a.f16443c.mo17298a();
        }
    }
}
