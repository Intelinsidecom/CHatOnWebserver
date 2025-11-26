package com.sec.chaton.buddy;

import android.content.Intent;
import com.sec.chaton.settings.tellfriends.InterfaceC2729af;
import com.sec.chaton.settings.tellfriends.WeiboFriendsPickerActivity;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.gd */
/* loaded from: classes.dex */
class C0720gd implements InterfaceC2729af {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0719gc f2963a;

    C0720gd(ViewOnClickListenerC0719gc viewOnClickListenerC0719gc) {
        this.f2963a = viewOnClickListenerC0719gc;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onError(int i) {
        this.f2963a.f2962a.f2193f.dismiss();
        this.f2963a.f2962a.m3779a(true);
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onComplete() {
        C3250y.m11450b("onComplete() \t- Login", getClass().getSimpleName());
        this.f2963a.f2962a.f2193f.dismiss();
        this.f2963a.f2962a.startActivity(new Intent(CommonApplication.m11493l(), (Class<?>) WeiboFriendsPickerActivity.class));
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onCancelled() {
        this.f2963a.f2962a.f2193f.dismiss();
    }
}
