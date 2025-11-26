package com.sec.chaton.hide;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: HideImpl.java */
/* renamed from: com.sec.chaton.hide.j */
/* loaded from: classes.dex */
class C1519j implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ C1516g f5597a;

    C1519j(C1516g c1516g) {
        this.f5597a = c1516g;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f5597a.f5578d = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f5597a.f5578d = null;
    }
}
