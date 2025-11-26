package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.aj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1112aj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f3921a;

    DialogInterfaceOnClickListenerC1112aj(TrunkItemView trunkItemView) {
        this.f3921a = trunkItemView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
        if (-3 == iM2526a || -2 == iM2526a) {
            this.f3921a.m4023l();
        } else {
            this.f3921a.m4008e();
        }
    }
}
