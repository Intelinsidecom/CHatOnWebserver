package com.sec.chaton.userprofile;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.bo */
/* loaded from: classes.dex */
class C1665bo implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ RelationshipRankFragment2 f6158a;

    C1665bo(RelationshipRankFragment2 relationshipRankFragment2) {
        this.f6158a = relationshipRankFragment2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f6158a.f6010s.getOnItemSelectedListener().onItemSelected(adapterView, view, i, j);
        this.f6158a.f6010s.setVisibility(8);
    }
}
