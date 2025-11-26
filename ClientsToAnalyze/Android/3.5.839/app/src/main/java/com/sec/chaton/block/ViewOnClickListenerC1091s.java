package com.sec.chaton.block;

import android.view.View;

/* compiled from: BlockListFragment.java */
/* renamed from: com.sec.chaton.block.s */
/* loaded from: classes.dex */
class ViewOnClickListenerC1091s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlockListFragment f3482a;

    ViewOnClickListenerC1091s(BlockListFragment blockListFragment) {
        this.f3482a = blockListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f3482a.f3434j.isChecked()) {
            this.f3482a.f3434j.setChecked(false);
            this.f3482a.f3433i.m6229a(false);
            this.f3482a.f3437m.setEnabled(false);
            for (int i = 0; i < this.f3482a.f3430f.getCount(); i++) {
                this.f3482a.f3430f.setItemChecked(i, false);
            }
        } else {
            this.f3482a.f3434j.setChecked(true);
            this.f3482a.f3433i.m6229a(true);
            this.f3482a.f3437m.setEnabled(true);
            for (int i2 = 0; i2 < this.f3482a.f3430f.getCount(); i2++) {
                this.f3482a.f3430f.setItemChecked(i2, true);
            }
        }
        this.f3482a.f3433i.notifyDataSetChanged();
        this.f3482a.f3430f.invalidate();
        this.f3482a.f3433i.m6230b();
    }
}
