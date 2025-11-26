package com.sec.chaton.specialbuddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatONLiveMainFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.h */
/* loaded from: classes.dex */
class C4543h extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatONLiveMainFragment f16403a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4543h(ChatONLiveMainFragment chatONLiveMainFragment, Handler handler) {
        super(handler);
        this.f16403a = chatONLiveMainFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C4904y.m18639b("onChange() SpecialBuddyObserver, live buddy follow/unfollow DB. mIsActivityStarted : " + this.f16403a.mIsActivityStarted, ChatONLiveMainFragment.f16291a);
        if (!this.f16403a.mIsActivityStarted) {
            this.f16403a.f16292b = true;
        } else {
            this.f16403a.refreshWebContents();
        }
    }
}
