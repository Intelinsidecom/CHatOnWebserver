package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.ft */
/* loaded from: classes.dex */
class ViewOnClickListenerC0709ft implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f2950a;

    ViewOnClickListenerC0709ft(BuddyRecommendFragment buddyRecommendFragment) {
        this.f2950a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2950a.f2202o = false;
        Intent intent = new Intent(this.f2950a.f2178J, (Class<?>) BuddyRecommendListActivity.class);
        intent.putExtra("RECOMMENDED_BUDDY_TYPE", HttpResponseCode.f13733OK);
        this.f2950a.startActivity(intent);
    }
}
