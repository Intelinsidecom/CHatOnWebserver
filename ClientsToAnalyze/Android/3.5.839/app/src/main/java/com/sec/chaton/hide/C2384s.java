package com.sec.chaton.hide;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: HideListFragment.java */
/* renamed from: com.sec.chaton.hide.s */
/* loaded from: classes.dex */
class C2384s implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ HideListFragment f8471a;

    C2384s(HideListFragment hideListFragment) {
        this.f8471a = hideListFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f8471a.f8418d = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f8471a.f8418d = null;
    }
}
