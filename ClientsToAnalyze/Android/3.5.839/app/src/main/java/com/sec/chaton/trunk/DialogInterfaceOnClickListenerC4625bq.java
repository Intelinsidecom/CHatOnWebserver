package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.bq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4625bq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f16800a;

    /* renamed from: b */
    final /* synthetic */ TrunkItemView f16801b;

    DialogInterfaceOnClickListenerC4625bq(TrunkItemView trunkItemView, String str) {
        this.f16801b = trunkItemView;
        this.f16800a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            this.f16801b.m17361a(EnumC4629bu.Nonetwork);
        } else {
            this.f16801b.m17395o();
            this.f16801b.f16536X.mo17600a(this.f16800a);
        }
    }
}
