package com.sec.chaton.trunk;

import android.view.View;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.au */
/* loaded from: classes.dex */
class ViewOnClickListenerC1535au implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f5585a;

    ViewOnClickListenerC1535au(TrunkItemView trunkItemView) {
        this.f5585a = trunkItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f5585a.f5469U != null) {
            this.f5585a.m5285l();
            this.f5585a.f5464P = false;
            this.f5585a.f5469U.mo5389a(20, 239);
        }
    }
}
