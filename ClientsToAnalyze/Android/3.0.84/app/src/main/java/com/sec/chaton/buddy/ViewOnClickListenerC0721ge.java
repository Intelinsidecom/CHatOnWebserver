package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.tellfriends.RenrenFriendsPickerActivity;
import com.sec.common.CommonApplication;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.ge */
/* loaded from: classes.dex */
class ViewOnClickListenerC0721ge implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f2964a;

    ViewOnClickListenerC0721ge(BuddyRecommendFragment buddyRecommendFragment) {
        this.f2964a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f2964a.f2212y.mo9774d()) {
            this.f2964a.f2193f.show();
            this.f2964a.f2212y.mo9771a(new C0722gf(this));
        } else {
            this.f2964a.startActivity(new Intent(CommonApplication.m11493l(), (Class<?>) RenrenFriendsPickerActivity.class));
        }
    }
}
