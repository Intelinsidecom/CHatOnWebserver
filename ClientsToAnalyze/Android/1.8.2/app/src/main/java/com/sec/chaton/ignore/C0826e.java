package com.sec.chaton.ignore;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: IgnoreFragment.java */
/* renamed from: com.sec.chaton.ignore.e */
/* loaded from: classes.dex */
class C0826e implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ IgnoreFragment f3040a;

    C0826e(IgnoreFragment ignoreFragment) {
        this.f3040a = ignoreFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        this.f3040a.f3017d = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
        this.f3040a.f3017d = null;
    }
}
