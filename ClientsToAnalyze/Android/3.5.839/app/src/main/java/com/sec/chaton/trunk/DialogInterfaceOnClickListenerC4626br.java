package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.br */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4626br implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f16802a;

    DialogInterfaceOnClickListenerC4626br(TrunkItemView trunkItemView) {
        this.f16802a = trunkItemView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            this.f16802a.m17361a(EnumC4629bu.Nonetwork);
        } else if (this.f16802a.f16554f != null) {
            this.f16802a.f16554f.mo17302a(true, this.f16802a.f16547ai);
        }
    }
}
