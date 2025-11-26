package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.util.C4847bl;

/* compiled from: TrunkFullView.java */
/* renamed from: com.sec.chaton.trunk.av */
/* loaded from: classes.dex */
class ViewOnClickListenerC4597av implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkFullView f16727a;

    ViewOnClickListenerC4597av(TrunkFullView trunkFullView) {
        this.f16727a = trunkFullView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a() && !this.f16727a.f16508w && this.f16727a.f16501p == EnumC4642g.IMAGE && this.f16727a.f16489d != null) {
            this.f16727a.f16489d.mo17458a(this.f16727a.f16501p, this.f16727a.f16505t);
        }
    }
}
