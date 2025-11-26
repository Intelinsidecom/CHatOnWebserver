package com.sec.chaton.trunk;

import android.content.DialogInterface;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.bo */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4623bo implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f16798a;

    DialogInterfaceOnClickListenerC4623bo(TrunkItemView trunkItemView) {
        this.f16798a = trunkItemView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            this.f16798a.m17361a(EnumC4629bu.Nonetwork);
        } else {
            this.f16798a.m17385j();
        }
    }
}
