package com.sec.chaton.hide;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: HideListFragment.java */
/* renamed from: com.sec.chaton.hide.s */
/* loaded from: classes.dex */
class C1528s implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ HideListFragment f5616a;

    C1528s(HideListFragment hideListFragment) {
        this.f5616a = hideListFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f5616a.f5549d = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f5616a.f5549d = null;
    }
}
