package com.sec.chaton.trunk;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C1739av;
import com.sec.chaton.widget.C1797a;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.ap */
/* loaded from: classes.dex */
class C1530ap implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f5579a;

    C1530ap(TrunkItemView trunkItemView) {
        this.f5579a = trunkItemView;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (this.f5579a.getActivity() != null) {
            if (view.isPressed() || view.isInTouchMode()) {
                if (!((C1797a) this.f5579a.f5477ab.get(i)).equals(this.f5579a.f5478ac)) {
                    if (!((C1797a) this.f5579a.f5477ab.get(i)).equals(this.f5579a.f5479ad)) {
                        if (((C1797a) this.f5579a.f5477ab.get(i)).equals(this.f5579a.f5480ae)) {
                            this.f5579a.m5319d();
                            return;
                        }
                    } else if (!C1739av.m5927a()) {
                        this.f5579a.m5275g();
                    } else {
                        return;
                    }
                } else if (!C1739av.m5927a()) {
                    if (this.f5579a.f5488g != null) {
                        this.f5579a.f5488g.mo5221a(this.f5579a.f5455G, this.f5579a.f5456H);
                    }
                } else {
                    return;
                }
                this.f5579a.f5481af.setVisibility(8);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }
}
