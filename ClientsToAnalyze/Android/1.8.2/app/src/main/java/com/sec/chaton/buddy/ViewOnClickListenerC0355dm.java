package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.BuddyRecommendActivity;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BuddyRecommendActivity.java */
/* renamed from: com.sec.chaton.buddy.dm */
/* loaded from: classes.dex */
class ViewOnClickListenerC0355dm implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendActivity.BuddyRecommendFragment f1499a;

    ViewOnClickListenerC0355dm(BuddyRecommendActivity.BuddyRecommendFragment buddyRecommendFragment) {
        this.f1499a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f1499a.getActivity(), (Class<?>) BuddyRecommendListActivity.class);
        intent.putExtra("RECOMMENDED_BUDDY_TYPE", HttpResponseCode.f7897OK);
        this.f1499a.startActivity(intent);
    }
}
