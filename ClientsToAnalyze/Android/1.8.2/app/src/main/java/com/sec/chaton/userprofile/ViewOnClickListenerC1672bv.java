package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.p010a.C0257c;

/* compiled from: RelationshipRankFragment2.java */
/* renamed from: com.sec.chaton.userprofile.bv */
/* loaded from: classes.dex */
class ViewOnClickListenerC1672bv implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f6167a;

    /* renamed from: b */
    final /* synthetic */ C1671bu f6168b;

    ViewOnClickListenerC1672bv(C1671bu c1671bu, int i) {
        this.f6168b = c1671bu;
        this.f6167a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f6168b.getContext(), (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", ((C0257c) this.f6168b.getItem(this.f6167a)).m2318a());
        intent.putExtra("PROFILE_BUDDY_NAME", ((C0257c) this.f6168b.getItem(this.f6167a)).m2324b());
        this.f6168b.getContext().startActivity(intent);
    }
}
