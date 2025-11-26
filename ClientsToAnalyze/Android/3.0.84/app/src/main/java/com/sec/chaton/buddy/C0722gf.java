package com.sec.chaton.buddy;

import android.content.Intent;
import com.sec.chaton.settings.tellfriends.InterfaceC2729af;
import com.sec.chaton.settings.tellfriends.RenrenFriendsPickerActivity;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.gf */
/* loaded from: classes.dex */
class C0722gf implements InterfaceC2729af {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0721ge f2965a;

    C0722gf(ViewOnClickListenerC0721ge viewOnClickListenerC0721ge) {
        this.f2965a = viewOnClickListenerC0721ge;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onError(int i) {
        this.f2965a.f2964a.f2193f.dismiss();
        this.f2965a.f2964a.m3779a(true);
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onComplete() {
        C3250y.m11450b("onComplete() \t- Login", getClass().getSimpleName());
        this.f2965a.f2964a.f2193f.dismiss();
        this.f2965a.f2964a.startActivity(new Intent(CommonApplication.m11493l(), (Class<?>) RenrenFriendsPickerActivity.class));
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onCancelled() {
        this.f2965a.f2964a.f2193f.dismiss();
    }
}
