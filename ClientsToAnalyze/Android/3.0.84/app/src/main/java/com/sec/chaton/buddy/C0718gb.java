package com.sec.chaton.buddy;

import android.content.Intent;
import com.sec.chaton.settings.tellfriends.InterfaceC2729af;
import com.sec.chaton.settings.tellfriends.TwitterFriendsPickerActivity;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.gb */
/* loaded from: classes.dex */
class C0718gb implements InterfaceC2729af {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0717ga f2961a;

    C0718gb(ViewOnClickListenerC0717ga viewOnClickListenerC0717ga) {
        this.f2961a = viewOnClickListenerC0717ga;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onError(int i) {
        this.f2961a.f2960a.f2193f.dismiss();
        this.f2961a.f2960a.m3779a(true);
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onComplete() {
        C3250y.m11450b("onComplete() \t- Login", getClass().getSimpleName());
        this.f2961a.f2960a.f2193f.dismiss();
        this.f2961a.f2960a.startActivity(new Intent(CommonApplication.m11493l(), (Class<?>) TwitterFriendsPickerActivity.class));
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onCancelled() {
        this.f2961a.f2960a.f2193f.dismiss();
    }
}
