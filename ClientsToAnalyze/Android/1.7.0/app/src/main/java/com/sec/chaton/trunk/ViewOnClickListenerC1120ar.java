package com.sec.chaton.trunk;

import android.os.Environment;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.trunk.p045d.C1169g;
import com.sec.chaton.trunk.p045d.EnumC1168f;
import com.sec.chaton.util.C1346u;
import com.sec.widget.C1619g;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.ar */
/* loaded from: classes.dex */
class ViewOnClickListenerC1120ar implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f3931a;

    ViewOnClickListenerC1120ar(TrunkItemView trunkItemView) {
        this.f3931a = trunkItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1346u.m4676a() && !this.f3931a.f3782O && !this.f3931a.f3781N) {
            if (this.f3931a.f3775H == EnumC1168f.IMAGE) {
                if (this.f3931a.f3803f != null) {
                    this.f3931a.f3803f.mo3964b(this.f3931a.f3775H, this.f3931a.f3776I);
                    return;
                }
                return;
            }
            if (this.f3931a.f3775H == EnumC1168f.VIDEO) {
                if (!"mounted".equals(Environment.getExternalStorageState())) {
                    C1619g.m5889a(this.f3931a.f3802e, this.f3931a.getString(R.string.toast_sdcard_amount), 1).show();
                    return;
                }
                if (C1169g.m4214a(this.f3931a.f3776I) != null) {
                    if (this.f3931a.f3803f != null) {
                        this.f3931a.f3803f.mo3964b(this.f3931a.f3775H, this.f3931a.f3776I);
                    }
                } else {
                    int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
                    if (-3 == iM2526a || -2 == iM2526a) {
                        this.f3931a.m4023l();
                    } else {
                        this.f3931a.m4011f();
                    }
                }
            }
        }
    }
}
