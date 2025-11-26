package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.w */
/* loaded from: classes.dex */
class ViewOnClickListenerC0447w implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0442r f1696a;

    ViewOnClickListenerC0447w(C0442r c0442r) {
        this.f1696a = c0442r;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1696a.m2456a((String) view.getTag(), false);
        this.f1696a.m2460b();
        this.f1696a.f1669d.invalidateViews();
    }
}
