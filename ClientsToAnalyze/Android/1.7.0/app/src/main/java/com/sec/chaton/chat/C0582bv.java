package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p025d.C0671x;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bv */
/* loaded from: classes.dex */
class C0582bv extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2003a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0582bv(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f2003a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f2003a.f1760U.startQuery(10, null, C0671x.f2315a, new String[]{"inbox_valid", "inbox_session_id", "inbox_last_timestamp"}, "inbox_no=?", new String[]{this.f2003a.f1861t}, null);
    }
}
