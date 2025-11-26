package com.sec.chaton.hide;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: HideFragment.java */
/* renamed from: com.sec.chaton.hide.h */
/* loaded from: classes.dex */
class C2373h implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ HideFragment f8449a;

    C2373h(HideFragment hideFragment) {
        this.f8449a = hideFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f8449a.f8399d = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f8449a.f8399d = null;
    }
}
