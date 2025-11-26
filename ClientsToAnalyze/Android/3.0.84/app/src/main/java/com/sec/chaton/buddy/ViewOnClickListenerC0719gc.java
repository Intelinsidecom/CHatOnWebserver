package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.tellfriends.WeiboFriendsPickerActivity;
import com.sec.common.CommonApplication;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.gc */
/* loaded from: classes.dex */
class ViewOnClickListenerC0719gc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f2962a;

    ViewOnClickListenerC0719gc(BuddyRecommendFragment buddyRecommendFragment) {
        this.f2962a = buddyRecommendFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f2962a.f2211x.mo9774d()) {
            this.f2962a.f2193f.show();
            this.f2962a.f2211x.mo9771a(new C0720gd(this));
        } else {
            this.f2962a.startActivity(new Intent(CommonApplication.m11493l(), (Class<?>) WeiboFriendsPickerActivity.class));
        }
    }
}
