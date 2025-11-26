package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.tellfriends.TwitterFriendsPickerActivity;
import com.sec.common.CommonApplication;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.ga */
/* loaded from: classes.dex */
class ViewOnClickListenerC0717ga implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f2960a;

    ViewOnClickListenerC0717ga(BuddyRecommendFragment buddyRecommendFragment) {
        this.f2960a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f2960a.f2210w.mo9774d()) {
            this.f2960a.f2193f.show();
            this.f2960a.f2210w.mo9771a(new C0718gb(this));
        } else {
            this.f2960a.startActivity(new Intent(CommonApplication.m11493l(), (Class<?>) TwitterFriendsPickerActivity.class));
        }
    }
}
