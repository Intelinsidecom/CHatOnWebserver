package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;

/* compiled from: TrunkFullView.java */
/* renamed from: com.sec.chaton.trunk.av */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2981av implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkFullView f10781a;

    DialogInterfaceOnClickListenerC2981av(TrunkFullView trunkFullView) {
        this.f10781a = trunkFullView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            this.f10781a.m10232l();
        } else if (this.f10781a.f10543e != null) {
            this.f10781a.f10543e.mo10359a();
        }
    }
}
