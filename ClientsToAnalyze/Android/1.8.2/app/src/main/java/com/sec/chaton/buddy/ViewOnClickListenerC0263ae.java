package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC0263ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1358a;

    ViewOnClickListenerC0263ae(BuddyFragment buddyFragment) {
        this.f1358a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1358a.startActivityForResult(new Intent(this.f1358a.getActivity(), (Class<?>) AddBuddyActivity.class), 1);
    }
}
