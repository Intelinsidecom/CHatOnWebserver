package com.sec.chaton.hide;

import android.view.View;

/* compiled from: HideListFragment.java */
/* renamed from: com.sec.chaton.hide.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC1530u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HideListFragment f5618a;

    ViewOnClickListenerC1530u(HideListFragment hideListFragment) {
        this.f5618a = hideListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f5618a.f5553h.isChecked()) {
            this.f5618a.f5553h.setChecked(false);
            this.f5618a.f5552g.m6517a(false);
            this.f5618a.f5556k.setEnabled(false);
        } else {
            this.f5618a.f5553h.setChecked(true);
            this.f5618a.f5552g.m6517a(true);
            this.f5618a.f5556k.setEnabled(true);
        }
        this.f5618a.f5552g.notifyDataSetChanged();
        this.f5618a.f5550e.invalidate();
    }
}
