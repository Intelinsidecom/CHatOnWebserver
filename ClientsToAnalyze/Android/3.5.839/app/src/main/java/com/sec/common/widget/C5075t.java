package com.sec.common.widget;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: IcsSpinner.java */
/* renamed from: com.sec.common.widget.t */
/* loaded from: classes.dex */
class C5075t implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ IcsSpinner f18512a;

    /* renamed from: b */
    final /* synthetic */ C5074s f18513b;

    C5075t(C5074s c5074s, IcsSpinner icsSpinner) {
        this.f18513b = c5074s;
        this.f18512a = icsSpinner;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f18513b.f18509a.setSelection(i);
        this.f18513b.m19262b();
    }
}
