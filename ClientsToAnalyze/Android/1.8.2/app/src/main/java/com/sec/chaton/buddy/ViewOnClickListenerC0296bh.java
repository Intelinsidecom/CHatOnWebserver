package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bh */
/* loaded from: classes.dex */
class ViewOnClickListenerC0296bh implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1393a;

    ViewOnClickListenerC0296bh(BuddyFragment buddyFragment) {
        this.f1393a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1393a.startActivityForResult(new Intent(this.f1393a.getActivity(), (Class<?>) AddBuddyActivity.class), 1);
    }
}
