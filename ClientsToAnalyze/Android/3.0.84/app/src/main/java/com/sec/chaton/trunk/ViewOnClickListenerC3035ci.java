package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C3228cp;

/* compiled from: TrunkView.java */
/* renamed from: com.sec.chaton.trunk.ci */
/* loaded from: classes.dex */
class ViewOnClickListenerC3035ci implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkView f10916a;

    ViewOnClickListenerC3035ci(TrunkView trunkView) {
        this.f10916a = trunkView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f10916a.f10671F.isChecked()) {
            this.f10916a.f10671F.setChecked(false);
            this.f10916a.f10702s.m10605a(false);
        } else {
            this.f10916a.f10671F.setChecked(true);
            this.f10916a.f10702s.m10605a(true);
        }
        if (this.f10916a.f10702s.m10600a().isEmpty()) {
            this.f10916a.f10675J.findItem(R.id.btnDeleteComplete).setEnabled(false);
            C3228cp.m11343a(this.f10916a.f10675J.findItem(R.id.btnDeleteComplete));
            this.f10916a.m10381b(false);
        } else {
            this.f10916a.f10675J.findItem(R.id.btnDeleteComplete).setEnabled(true);
            C3228cp.m11343a(this.f10916a.f10675J.findItem(R.id.btnDeleteComplete));
            this.f10916a.m10381b(true);
        }
        this.f10916a.f10696m.invalidateViews();
    }
}
