package com.sec.chaton.block;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.h */
/* loaded from: classes.dex */
class C0482h implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f1594a;

    C0482h(BlockFragment blockFragment) {
        this.f1594a = blockFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1594a.f1543d = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f1594a.f1543d = null;
    }
}
