package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.trunk.database.C1589e;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.s */
/* loaded from: classes.dex */
class C0513s extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2123a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0513s(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f2123a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f2123a.f1783X.startQuery(9, null, C1589e.f5703a, null, "session_id=?", new String[]{this.f2123a.f1766G}, null);
    }
}
