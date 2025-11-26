package com.sec.chaton.block;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: BlockListFragment.java */
/* renamed from: com.sec.chaton.block.y */
/* loaded from: classes.dex */
class C0499y implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ BlockListFragment f1637a;

    C0499y(BlockListFragment blockListFragment) {
        this.f1637a = blockListFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1637a.f1560d = view;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f1637a.f1560d = null;
    }
}
