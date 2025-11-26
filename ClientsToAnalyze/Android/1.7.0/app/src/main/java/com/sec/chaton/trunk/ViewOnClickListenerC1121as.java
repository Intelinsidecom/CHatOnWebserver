package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.as */
/* loaded from: classes.dex */
class ViewOnClickListenerC1121as implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f3932a;

    ViewOnClickListenerC1121as(TrunkItemView trunkItemView) {
        this.f3932a = trunkItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f3932a.f3790W != null) {
            this.f3932a.f3784Q = false;
            int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
            if (-3 == iM2526a || -2 == iM2526a) {
                this.f3932a.m4023l();
            } else {
                this.f3932a.m4019j();
                this.f3932a.f3790W.mo4181a(2, 239);
            }
        }
    }
}
