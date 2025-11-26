package com.sec.chaton.buddy;

import android.view.View;

/* renamed from: com.sec.chaton.buddy.am */
/* loaded from: classes.dex */
class ViewOnClickListenerC0089am implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditAdapter f628a;

    ViewOnClickListenerC0089am(BuddyGroupEditAdapter buddyGroupEditAdapter) {
        this.f628a = buddyGroupEditAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f628a.m594a((String) view.getTag(), false);
        this.f628a.m590a(this.f628a.f537i);
        this.f628a.f531c.invalidateViews();
    }
}
