package com.sec.chaton.trunk;

import android.os.Environment;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.util.C4847bl;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: TrunkFullView.java */
/* renamed from: com.sec.chaton.trunk.aw */
/* loaded from: classes.dex */
class ViewOnClickListenerC4598aw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkFullView f16728a;

    ViewOnClickListenerC4598aw(TrunkFullView trunkFullView) {
        this.f16728a = trunkFullView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a() && !this.f16728a.f16508w) {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                C5179v.m19811a(this.f16728a.m17321h(), this.f16728a.getString(R.string.toast_sdcard_amount), 1).show();
                return;
            }
            if (C4636a.m17601a(this.f16728a.f16505t) != null) {
                if (this.f16728a.f16489d != null) {
                    this.f16728a.f16489d.mo17458a(this.f16728a.f16501p, this.f16728a.f16505t);
                }
            } else {
                int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                if (-3 == iM10677a || -2 == iM10677a) {
                    this.f16728a.m17330l();
                } else {
                    this.f16728a.m17323i();
                }
            }
        }
    }
}
