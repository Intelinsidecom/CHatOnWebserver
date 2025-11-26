package com.sec.chaton.specialbuddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatONLiveBuddyListFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.d */
/* loaded from: classes.dex */
class C2923d extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatONLiveBuddyListFragment f10453a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2923d(ChatONLiveBuddyListFragment chatONLiveBuddyListFragment, Handler handler) {
        super(handler);
        this.f10453a = chatONLiveBuddyListFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C3250y.m11450b("onChange() SpecialBuddyObserver, live buddy follow/unfollow DB. mIsActivityStarted : " + this.f10453a.f6165f, ChatONLiveBuddyListFragment.f10389k);
        if (this.f10453a.f6165f) {
            this.f10453a.mo6965j();
        } else {
            this.f10453a.f10390i = true;
        }
    }
}
