package com.sec.chaton.specialbuddy;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: SpecialBuddyInfo.java */
/* renamed from: com.sec.chaton.specialbuddy.a */
/* loaded from: classes.dex */
class C1504a implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyInfo f5422a;

    C1504a(SpecialBuddyInfo specialBuddyInfo) {
        this.f5422a = specialBuddyInfo;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f5422a.f5417q.getOnItemSelectedListener().onItemSelected(adapterView, view, i, j);
        this.f5422a.f5417q.setVisibility(8);
    }
}
