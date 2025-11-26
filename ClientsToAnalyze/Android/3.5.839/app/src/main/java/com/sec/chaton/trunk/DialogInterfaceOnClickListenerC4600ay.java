package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;

/* compiled from: TrunkFullView.java */
/* renamed from: com.sec.chaton.trunk.ay */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4600ay implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkFullView f16730a;

    DialogInterfaceOnClickListenerC4600ay(TrunkFullView trunkFullView) {
        this.f16730a = trunkFullView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            this.f16730a.m17330l();
        } else if (this.f16730a.f16489d != null) {
            this.f16730a.f16489d.mo17457a();
        }
    }
}
