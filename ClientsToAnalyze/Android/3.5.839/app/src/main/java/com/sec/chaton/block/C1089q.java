package com.sec.chaton.block;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: BlockListFragment.java */
/* renamed from: com.sec.chaton.block.q */
/* loaded from: classes.dex */
class C1089q implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ BlockListFragment f3480a;

    C1089q(BlockListFragment blockListFragment) {
        this.f3480a = blockListFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f3480a.f3428d = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f3480a.f3428d = null;
    }
}
