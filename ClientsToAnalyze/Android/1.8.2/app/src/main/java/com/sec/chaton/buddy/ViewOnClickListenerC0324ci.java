package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyGroupEditAdapter.java */
/* renamed from: com.sec.chaton.buddy.ci */
/* loaded from: classes.dex */
class ViewOnClickListenerC0324ci implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0322cg f1461a;

    ViewOnClickListenerC0324ci(C0322cg c0322cg) {
        this.f1461a = c0322cg;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1461a.m2402a((String) view.getTag(), false);
        this.f1461a.m2398a(this.f1461a.f1450i);
        this.f1461a.f1444c.invalidateViews();
    }
}
