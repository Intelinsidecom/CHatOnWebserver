package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyRecommendActivity;

/* compiled from: BuddyRecommendActivity.java */
/* renamed from: com.sec.chaton.buddy.dk */
/* loaded from: classes.dex */
class ViewOnClickListenerC0353dk implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendActivity.BuddyRecommendFragment f1497a;

    ViewOnClickListenerC0353dk(BuddyRecommendActivity.BuddyRecommendFragment buddyRecommendFragment) {
        this.f1497a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f1497a.getActivity(), (Class<?>) BuddyRecommendListActivity.class);
        intent.putExtra("RECOMMENDED_BUDDY_TYPE", 100);
        this.f1497a.startActivity(intent);
    }
}
