package com.sec.chaton.buddy;

import android.view.View;

/* renamed from: com.sec.chaton.buddy.ay */
/* loaded from: classes.dex */
class ViewOnClickListenerC0101ay implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f644a;

    ViewOnClickListenerC0101ay(BuddyFragment buddyFragment) {
        this.f644a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f644a.f467w.requestFocus();
    }
}
