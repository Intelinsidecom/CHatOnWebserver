package com.sec.chaton.block;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: BlockListFragment.java */
/* renamed from: com.sec.chaton.block.p */
/* loaded from: classes.dex */
class C1088p implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BlockListFragment f3479a;

    C1088p(BlockListFragment blockListFragment) {
        this.f3479a = blockListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f3479a.f3430f.isItemChecked(i) || !this.f3479a.f3434j.isChecked()) {
            if (this.f3479a.m6203b() == this.f3479a.f3430f.getCount() && !this.f3479a.f3434j.isChecked()) {
                this.f3479a.f3434j.setChecked(true);
            }
        } else {
            this.f3479a.f3434j.setChecked(false);
        }
        if (!this.f3479a.f3430f.isItemChecked(i)) {
            this.f3479a.f3433i.f3464b.remove(this.f3479a.f3433i.f3463a.get(i));
        } else {
            this.f3479a.f3433i.f3464b.add(this.f3479a.f3433i.f3463a.get(i));
        }
        this.f3479a.f3435k.onClick();
    }
}
