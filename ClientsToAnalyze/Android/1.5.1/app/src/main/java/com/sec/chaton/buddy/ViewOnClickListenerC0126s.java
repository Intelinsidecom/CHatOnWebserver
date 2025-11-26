package com.sec.chaton.buddy;

import android.view.View;

/* renamed from: com.sec.chaton.buddy.s */
/* loaded from: classes.dex */
class ViewOnClickListenerC0126s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyAdapter f708a;

    ViewOnClickListenerC0126s(BuddyAdapter buddyAdapter) {
        this.f708a = buddyAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f708a.m443a((String) view.getTag(), false);
        this.f708a.m444b();
        this.f708a.f383a.invalidateViews();
    }
}
