package com.sec.chaton.specialbuddy;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2299s;

/* compiled from: SpecialBuddyChatFragment.java */
/* renamed from: com.sec.chaton.specialbuddy.t */
/* loaded from: classes.dex */
class C4555t extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyChatFragment f16427a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4555t(SpecialBuddyChatFragment specialBuddyChatFragment, Handler handler) {
        super(handler);
        this.f16427a = specialBuddyChatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f16427a.f16372q.startQuery(98, null, C2299s.f8209a, null, "inbox_unread_count > 0", null, null);
    }
}
