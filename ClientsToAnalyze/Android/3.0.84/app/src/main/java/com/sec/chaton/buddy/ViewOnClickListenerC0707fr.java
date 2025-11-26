package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.specialbuddy.ChatONLiveBuddyListActivity;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.fr */
/* loaded from: classes.dex */
class ViewOnClickListenerC0707fr implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f2948a;

    ViewOnClickListenerC0707fr(BuddyRecommendFragment buddyRecommendFragment) {
        this.f2948a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2948a.startActivity(new Intent(this.f2948a.getActivity(), (Class<?>) ChatONLiveBuddyListActivity.class));
    }
}
