package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.bl */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3004bl implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f10850a;

    DialogInterfaceOnClickListenerC3004bl(TrunkItemView trunkItemView) {
        this.f10850a = trunkItemView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            this.f10850a.m10264a(EnumC3010br.Nonetwork);
        } else {
            this.f10850a.m10288i();
        }
    }
}
