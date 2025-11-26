package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.util.C1346u;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.ai */
/* loaded from: classes.dex */
class ViewOnClickListenerC1111ai implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f3920a;

    ViewOnClickListenerC1111ai(TrunkItemView trunkItemView) {
        this.f3920a = trunkItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1346u.m4676a()) {
            int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
            if (-3 == iM2526a || -2 == iM2526a) {
                this.f3920a.m4023l();
            } else {
                this.f3920a.m4008e();
            }
        }
    }
}
