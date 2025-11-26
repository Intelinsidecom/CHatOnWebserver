package com.sec.common.widget;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: IcsSpinner.java */
/* renamed from: com.sec.common.widget.w */
/* loaded from: classes.dex */
class C3390w implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ IcsSpinner f12266a;

    /* renamed from: b */
    final /* synthetic */ C3389v f12267b;

    C3390w(C3389v c3389v, IcsSpinner icsSpinner) {
        this.f12267b = c3389v;
        this.f12266a = icsSpinner;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f12267b.f12263a.setSelection(i);
        this.f12267b.m11920b();
    }
}
