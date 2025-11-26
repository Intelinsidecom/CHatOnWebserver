package com.sec.chaton.trunk;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.as */
/* loaded from: classes.dex */
class C1533as implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f5583a;

    C1533as(TrunkItemView trunkItemView) {
        this.f5583a = trunkItemView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f5583a.f5481af.getOnItemSelectedListener().onItemSelected(adapterView, view, i, j);
        this.f5583a.f5481af.setVisibility(8);
    }
}
