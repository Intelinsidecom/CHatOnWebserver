package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C3228cp;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.ch */
/* loaded from: classes.dex */
class ViewOnClickListenerC3034ch implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkView f10915a;

    ViewOnClickListenerC3034ch(TrunkView trunkView) {
        this.f10915a = trunkView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f10915a.f10681P.setVisibility(8);
        this.f10915a.m10373a(EnumC3041co.DeleteMode);
        if (this.f10915a.f10675J != null) {
            this.f10915a.f10675J.findItem(R.id.btnDeleteComplete).setEnabled(false);
            C3228cp.m11343a(this.f10915a.f10675J.findItem(R.id.btnDeleteComplete));
        }
        this.f10915a.m10381b(false);
    }
}
