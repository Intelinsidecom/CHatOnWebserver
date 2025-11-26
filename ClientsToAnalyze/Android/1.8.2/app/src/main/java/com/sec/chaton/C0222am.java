package com.sec.chaton;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: HomeTabletFragment.java */
/* renamed from: com.sec.chaton.am */
/* loaded from: classes.dex */
class C0222am implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ HomeTabletFragment f756a;

    C0222am(HomeTabletFragment homeTabletFragment) {
        this.f756a = homeTabletFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f756a.f253a.getOnItemSelectedListener().onItemSelected(adapterView, view, i, j);
        this.f756a.f253a.setVisibility(8);
    }
}
