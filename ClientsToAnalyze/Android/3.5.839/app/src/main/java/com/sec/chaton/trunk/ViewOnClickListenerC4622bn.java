package com.sec.chaton.trunk;

import android.os.Environment;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.widget.AdaptableEditText;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.bn */
/* loaded from: classes.dex */
class ViewOnClickListenerC4622bn implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f16797a;

    ViewOnClickListenerC4622bn(TrunkItemView trunkItemView) {
        this.f16797a = trunkItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a() && !this.f16797a.f16524L) {
            if (this.f16797a.f16550b != null) {
                this.f16797a.f16551c = (AdaptableEditText) this.f16797a.f16553e.findViewById(R.id.edit_text1);
                if (this.f16797a.f16551c != null) {
                    this.f16797a.f16550b.hideSoftInputFromWindow(this.f16797a.f16551c.getWindowToken(), 0);
                }
            }
            if (this.f16797a.f16517E == EnumC4642g.IMAGE || this.f16797a.f16517E == EnumC4642g.AMS) {
                if (this.f16797a.f16554f != null) {
                    this.f16797a.f16554f.mo17300a(this.f16797a.f16517E, this.f16797a.f16518F);
                    return;
                }
                return;
            }
            if (this.f16797a.f16517E == EnumC4642g.VIDEO) {
                if (!"mounted".equals(Environment.getExternalStorageState())) {
                    C5179v.m19811a(this.f16797a.f16553e, this.f16797a.getString(R.string.toast_sdcard_amount), 1).show();
                    return;
                }
                if (C4636a.m17601a(this.f16797a.f16518F) != null) {
                    if (this.f16797a.f16554f != null) {
                        this.f16797a.f16554f.mo17303b(this.f16797a.f16518F);
                    }
                } else {
                    int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                    if (-3 == iM10677a || -2 == iM10677a) {
                        this.f16797a.m17361a(EnumC4629bu.Nonetwork);
                    } else {
                        this.f16797a.m17386k();
                    }
                }
            }
        }
    }
}
