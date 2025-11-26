package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ay */
/* loaded from: classes.dex */
class ViewOnClickListenerC1134ay implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4352a;

    ViewOnClickListenerC1134ay(BuddyFragment buddyFragment) {
        this.f4352a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4352a.f3614U.setEnabled(false);
        Intent intent = new Intent(this.f4352a.getActivity(), (Class<?>) AddBuddyActivity.class);
        intent.putExtra("ADD_BUDDY_TYPE", 103);
        this.f4352a.startActivityForResult(intent, 100);
    }
}
