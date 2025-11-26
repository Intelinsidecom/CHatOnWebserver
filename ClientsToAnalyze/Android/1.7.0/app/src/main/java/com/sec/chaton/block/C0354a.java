package com.sec.chaton.block;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.a */
/* loaded from: classes.dex */
class C0354a implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f1036a;

    C0354a(BlockFragment blockFragment) {
        this.f1036a = blockFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        this.f1036a.f1028d = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
        this.f1036a.f1028d = null;
    }
}
