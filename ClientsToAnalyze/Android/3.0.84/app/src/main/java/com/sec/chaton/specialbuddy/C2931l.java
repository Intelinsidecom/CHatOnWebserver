package com.sec.chaton.specialbuddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatONLiveMainFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.l */
/* loaded from: classes.dex */
class C2931l extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatONLiveMainFragment f10462a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2931l(ChatONLiveMainFragment chatONLiveMainFragment, Handler handler) {
        super(handler);
        this.f10462a = chatONLiveMainFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C3250y.m11450b("onChange() SpecialBuddyObserver, live buddy follow/unfollow DB. mIsActivityStarted : " + this.f10462a.f6165f, ChatONLiveMainFragment.f10403k);
        if (this.f10462a.f6165f) {
            this.f10462a.mo6965j();
        } else {
            this.f10462a.f10404i = true;
        }
    }
}
