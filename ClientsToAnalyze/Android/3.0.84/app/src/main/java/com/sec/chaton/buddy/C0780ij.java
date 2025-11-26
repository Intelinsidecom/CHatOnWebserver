package com.sec.chaton.buddy;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: SpecialBuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.ij */
/* loaded from: classes.dex */
class C0780ij implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyRecommendListFragment f3052a;

    C0780ij(SpecialBuddyRecommendListFragment specialBuddyRecommendListFragment) {
        this.f3052a = specialBuddyRecommendListFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f3052a.f2322a = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f3052a.f2322a = null;
    }
}
