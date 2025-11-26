package com.sec.chaton.block;

import android.view.View;

/* renamed from: com.sec.chaton.block.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC0075e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f380a;

    /* renamed from: b */
    final /* synthetic */ BlockBuddyAdapter f381b;

    ViewOnClickListenerC0075e(BlockBuddyAdapter blockBuddyAdapter, int i) {
        this.f381b = blockBuddyAdapter;
        this.f380a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f381b.f361g = ((C0071a) this.f381b.f355a.get(this.f380a)).f372b;
        this.f381b.f360f = ((C0071a) this.f381b.f355a.get(this.f380a)).f373c;
    }
}
