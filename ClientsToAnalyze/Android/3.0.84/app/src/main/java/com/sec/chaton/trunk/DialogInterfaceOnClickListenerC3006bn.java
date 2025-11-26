package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.bn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3006bn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f10852a;

    /* renamed from: b */
    final /* synthetic */ TrunkItemView f10853b;

    DialogInterfaceOnClickListenerC3006bn(TrunkItemView trunkItemView, String str) {
        this.f10853b = trunkItemView;
        this.f10852a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            this.f10853b.m10264a(EnumC3010br.Nonetwork);
        } else {
            this.f10853b.m10298n();
            this.f10853b.f10591Z.mo10502a(this.f10852a);
        }
    }
}
