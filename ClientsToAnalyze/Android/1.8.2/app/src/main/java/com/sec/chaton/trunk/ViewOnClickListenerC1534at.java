package com.sec.chaton.trunk;

import android.os.Environment;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.trunk.p053e.C1592a;
import com.sec.chaton.trunk.p053e.EnumC1599h;
import com.sec.chaton.util.C1739av;
import com.sec.widget.C2153y;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.at */
/* loaded from: classes.dex */
class ViewOnClickListenerC1534at implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f5584a;

    ViewOnClickListenerC1534at(TrunkItemView trunkItemView) {
        this.f5584a = trunkItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1739av.m5927a() && !this.f5584a.f5462N && !this.f5584a.f5461M) {
            if (this.f5584a.f5455G == EnumC1599h.IMAGE) {
                if (this.f5584a.f5488g != null) {
                    this.f5584a.f5488g.mo5223b(this.f5584a.f5455G, this.f5584a.f5456H);
                }
                this.f5584a.f5494m.setClickable(false);
            } else if (this.f5584a.f5455G == EnumC1599h.VIDEO) {
                if (!"mounted".equals(Environment.getExternalStorageState())) {
                    C2153y.m7536a(this.f5584a.f5487f, this.f5584a.getString(R.string.toast_sdcard_amount), 1).show();
                } else if (C1592a.m5492a(this.f5584a.f5456H) == null) {
                    this.f5584a.m5277h();
                } else if (this.f5584a.f5488g != null) {
                    this.f5584a.f5488g.mo5223b(this.f5584a.f5455G, this.f5584a.f5456H);
                }
            }
        }
    }
}
