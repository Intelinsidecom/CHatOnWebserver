package com.sec.chaton.settings.tellfriends.common;

import android.view.View;
import com.sec.chaton.settings.tellfriends.C2732ai;

/* compiled from: SnsFriendsAdapter.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC2789e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C2732ai f10277a;

    /* renamed from: b */
    final /* synthetic */ C2788d f10278b;

    ViewOnClickListenerC2789e(C2788d c2788d, C2732ai c2732ai) {
        this.f10278b = c2788d;
        this.f10277a = c2732ai;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f10278b.f10270b.mo9718a(this.f10277a);
    }
}
