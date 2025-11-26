package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.ck */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3037ck implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkView f10918a;

    DialogInterfaceOnClickListenerC3037ck(TrunkView trunkView) {
        this.f10918a = trunkView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            this.f10918a.m10372a(EnumC3040cn.Nonetwork);
        } else {
            this.f10918a.m10408a(this.f10918a.f10673H);
        }
    }
}
