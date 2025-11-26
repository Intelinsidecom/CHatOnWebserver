package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.util.C1341p;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.ap */
/* loaded from: classes.dex */
class ViewOnClickListenerC1118ap implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f3929a;

    ViewOnClickListenerC1118ap(TrunkItemView trunkItemView) {
        this.f3929a = trunkItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f3929a.f3794aa != null) {
            if (this.f3929a.f3784Q) {
                C1341p.m4661d("Already all comments are loaded.", TrunkItemView.f3767a);
                return;
            }
            int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
            if (-3 == iM2526a || -2 == iM2526a) {
                this.f3929a.m4023l();
            } else {
                this.f3929a.m4019j();
                this.f3929a.f3794aa.mo4202a(this.f3929a.f3783P, 30);
            }
        }
    }
}
