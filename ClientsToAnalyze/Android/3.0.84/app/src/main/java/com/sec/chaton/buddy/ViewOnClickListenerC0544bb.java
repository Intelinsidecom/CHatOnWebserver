package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bb */
/* loaded from: classes.dex */
class ViewOnClickListenerC0544bb implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2503a;

    ViewOnClickListenerC0544bb(BuddyFragment buddyFragment) {
        this.f2503a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = !this.f2503a.f1749M.isChecked();
        if (z) {
            this.f2503a.m3412w();
        } else {
            this.f2503a.m3430a(true);
        }
        this.f2503a.f1749M.setChecked(z);
    }
}
