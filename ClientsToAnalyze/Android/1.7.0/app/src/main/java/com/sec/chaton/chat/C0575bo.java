package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p025d.C0671x;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bo */
/* loaded from: classes.dex */
class C0575bo extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1992a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0575bo(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f1992a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f1992a.f1760U.startQuery(6, null, C0671x.f2315a, null, "inbox_unread_count > 0", null, null);
    }
}
