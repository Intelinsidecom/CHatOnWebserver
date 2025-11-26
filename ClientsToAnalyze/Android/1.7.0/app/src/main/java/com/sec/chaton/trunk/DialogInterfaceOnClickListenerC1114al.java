package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.al */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1114al implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f3924a;

    DialogInterfaceOnClickListenerC1114al(TrunkItemView trunkItemView) {
        this.f3924a = trunkItemView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f3924a.f3803f != null) {
            int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
            if (-3 == iM2526a || -2 == iM2526a) {
                this.f3924a.m4023l();
            } else {
                this.f3924a.f3803f.mo3965b_();
            }
        }
    }
}
