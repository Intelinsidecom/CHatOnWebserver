package com.sec.chaton.buddy.honeycomb;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.p010a.C0257c;

/* compiled from: BuddySelectAdapter.java */
/* renamed from: com.sec.chaton.buddy.honeycomb.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0419b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0257c f1626a;

    /* renamed from: b */
    final /* synthetic */ C0418a f1627b;

    ViewOnClickListenerC0419b(C0418a c0418a, C0257c c0257c) {
        this.f1627b = c0418a;
        this.f1626a = c0257c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f1627b.f1619e, (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", this.f1626a.m2318a());
        intent.putExtra("PROFILE_BUDDY_NAME", this.f1626a.m2324b());
        intent.setFlags(268435456);
        this.f1627b.f1619e.startActivity(intent);
    }
}
