package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.p010a.C0257c;

/* compiled from: MyPageRelationshipRankFragment.java */
/* renamed from: com.sec.chaton.userprofile.av */
/* loaded from: classes.dex */
class ViewOnClickListenerC1645av implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f6135a;

    /* renamed from: b */
    final /* synthetic */ C1644au f6136b;

    ViewOnClickListenerC1645av(C1644au c1644au, int i) {
        this.f6136b = c1644au;
        this.f6135a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f6136b.getContext(), (Class<?>) BuddyProfileActivity.class);
        intent.putExtra("PROFILE_BUDDY_NO", ((C0257c) this.f6136b.getItem(this.f6135a)).m2318a());
        intent.putExtra("PROFILE_BUDDY_NAME", ((C0257c) this.f6136b.getItem(this.f6135a)).m2324b());
        this.f6136b.getContext().startActivity(intent);
    }
}
