package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC0440e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1432a;

    ViewOnClickListenerC0440e(BuddyFragment buddyFragment) {
        this.f1432a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1432a.m2196a((String) view.getTag(), false, (String) null);
        if (this.f1432a.f1103M == 8) {
            this.f1432a.m2091G();
        }
    }
}
