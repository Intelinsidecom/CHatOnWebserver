package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.cn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4656cn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkView f16867a;

    DialogInterfaceOnClickListenerC4656cn(TrunkView trunkView) {
        this.f16867a = trunkView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            this.f16867a.m17470a(EnumC4660cr.Nonetwork);
        } else {
            this.f16867a.m17505a(this.f16867a.f16621H);
        }
    }
}
