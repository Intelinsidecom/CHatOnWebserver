package com.sec.chaton.trunk;

import android.content.DialogInterface;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ah */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2967ah implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f10747a;

    DialogInterfaceOnClickListenerC2967ah(TrunkCommentView trunkCommentView) {
        this.f10747a = trunkCommentView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f10747a.f10504c != null) {
            this.f10747a.f10504c.mo10205b();
        }
    }
}
