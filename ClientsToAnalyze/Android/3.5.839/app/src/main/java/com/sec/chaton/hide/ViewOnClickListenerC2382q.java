package com.sec.chaton.hide;

import android.view.View;

/* compiled from: HideListFragment.java */
/* renamed from: com.sec.chaton.hide.q */
/* loaded from: classes.dex */
class ViewOnClickListenerC2382q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HideListFragment f8469a;

    ViewOnClickListenerC2382q(HideListFragment hideListFragment) {
        this.f8469a = hideListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f8469a.f8423i.isChecked()) {
            this.f8469a.f8423i.setChecked(false);
            this.f8469a.f8422h.m10362a(false);
            this.f8469a.f8426l.setEnabled(false);
            for (int i = 0; i < this.f8469a.f8420f.getCount(); i++) {
                this.f8469a.f8420f.setItemChecked(i, false);
            }
        } else {
            this.f8469a.f8423i.setChecked(true);
            this.f8469a.f8422h.m10362a(true);
            this.f8469a.f8426l.setEnabled(true);
            for (int i2 = 0; i2 < this.f8469a.f8420f.getCount(); i2++) {
                this.f8469a.f8420f.setItemChecked(i2, true);
            }
        }
        this.f8469a.f8422h.notifyDataSetChanged();
        this.f8469a.f8420f.invalidate();
        this.f8469a.f8422h.m10363b();
    }
}
