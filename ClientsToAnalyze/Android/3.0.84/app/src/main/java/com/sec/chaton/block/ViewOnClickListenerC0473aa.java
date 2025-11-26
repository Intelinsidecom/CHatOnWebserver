package com.sec.chaton.block;

import android.view.View;

/* compiled from: BlockListFragment.java */
/* renamed from: com.sec.chaton.block.aa */
/* loaded from: classes.dex */
class ViewOnClickListenerC0473aa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlockListFragment f1582a;

    ViewOnClickListenerC0473aa(BlockListFragment blockListFragment) {
        this.f1582a = blockListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f1582a.f1566j.isChecked()) {
            this.f1582a.f1566j.setChecked(false);
            this.f1582a.f1565i.m3158a(false);
            this.f1582a.f1569m.setEnabled(false);
        } else {
            this.f1582a.f1566j.setChecked(true);
            this.f1582a.f1565i.m3158a(true);
            this.f1582a.f1569m.setEnabled(true);
        }
        this.f1582a.f1565i.notifyDataSetChanged();
        this.f1582a.f1562f.invalidate();
        this.f1582a.f1565i.m3159b();
    }
}
