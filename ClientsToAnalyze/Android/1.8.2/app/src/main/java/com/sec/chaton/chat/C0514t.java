package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p017e.C0701p;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.t */
/* loaded from: classes.dex */
class C0514t extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2124a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0514t(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f2124a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f2124a.f1783X.startQuery(5, null, C0701p.m3164a(this.f2124a.f1912z), new String[]{"buddy_no", "buddy_name", "buddy_status_message"}, null, null, "rowid DESC");
    }
}
