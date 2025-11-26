package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.bo */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3007bo implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f10854a;

    DialogInterfaceOnClickListenerC3007bo(TrunkItemView trunkItemView) {
        this.f10854a = trunkItemView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            this.f10854a.m10264a(EnumC3010br.Nonetwork);
        } else if (this.f10854a.f10609f != null) {
            this.f10854a.f10609f.mo10204a(true, this.f10854a.f10602ak);
        }
    }
}
