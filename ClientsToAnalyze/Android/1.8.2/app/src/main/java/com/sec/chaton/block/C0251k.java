package com.sec.chaton.block;

import android.database.DataSetObserver;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;

/* compiled from: BlockFragment.java */
/* renamed from: com.sec.chaton.block.k */
/* loaded from: classes.dex */
class C0251k extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ BlockFragment f834a;

    C0251k(BlockFragment blockFragment) {
        this.f834a = blockFragment;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        if (this.f834a.isAdded()) {
            int count = this.f834a.f802h.getCount();
            C1786r.m6061b("SUMITA -- onChanged()" + count, getClass().getSimpleName());
            if (count == 0) {
                this.f834a.f805k.setText(R.string.settings_blocked);
            } else {
                this.f834a.f805k.setText(this.f834a.getString(R.string.settings_blocked) + " (" + count + ")");
            }
        }
    }
}
