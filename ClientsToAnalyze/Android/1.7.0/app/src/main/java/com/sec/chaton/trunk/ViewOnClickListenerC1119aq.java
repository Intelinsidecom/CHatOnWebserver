package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.util.C1346u;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.aq */
/* loaded from: classes.dex */
class ViewOnClickListenerC1119aq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f3930a;

    ViewOnClickListenerC1119aq(TrunkItemView trunkItemView) {
        this.f3930a = trunkItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1346u.m4676a() && this.f3930a.f3803f != null) {
            int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
            if (-3 == iM2526a || -2 == iM2526a) {
                this.f3930a.m4023l();
            } else {
                this.f3930a.f3803f.mo3963a(this.f3930a.f3772E, this.f3930a.f3774G);
            }
        }
    }
}
