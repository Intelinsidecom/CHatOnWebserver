package com.sec.chaton.hide;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: HideListFragment.java */
/* renamed from: com.sec.chaton.hide.r */
/* loaded from: classes.dex */
class C2383r implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ HideListFragment f8470a;

    C2383r(HideListFragment hideListFragment) {
        this.f8470a = hideListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f8470a.f8420f.isItemChecked(i) || !this.f8470a.f8423i.isChecked()) {
            if (this.f8470a.m10336a() == this.f8470a.f8420f.getCount() && !this.f8470a.f8423i.isChecked()) {
                this.f8470a.f8423i.setChecked(true);
            }
        } else {
            this.f8470a.f8423i.setChecked(false);
        }
        if (!this.f8470a.f8420f.isItemChecked(i)) {
            this.f8470a.f8422h.f8454b.remove(this.f8470a.f8422h.f8453a.get(i));
        } else {
            this.f8470a.f8422h.f8454b.add(this.f8470a.f8422h.f8453a.get(i));
        }
        this.f8470a.f8424j.onClick();
    }
}
