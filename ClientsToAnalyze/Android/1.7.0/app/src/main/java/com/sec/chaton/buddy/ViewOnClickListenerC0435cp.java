package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cp */
/* loaded from: classes.dex */
class ViewOnClickListenerC0435cp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1427a;

    ViewOnClickListenerC0435cp(BuddyFragment buddyFragment) {
        this.f1427a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f1427a.f1164v) {
            this.f1427a.f1097G.m5919a(view);
        } else {
            view.setEnabled(false);
            this.f1427a.m2097J();
        }
    }
}
