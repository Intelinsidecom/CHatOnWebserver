package com.sec.chaton.block;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.g */
/* loaded from: classes.dex */
class C1079g implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f3459a;

    C1079g(BlockFragment blockFragment) {
        this.f3459a = blockFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f3459a.f3408d = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f3459a.f3408d = null;
    }
}
