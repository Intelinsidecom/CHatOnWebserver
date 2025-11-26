package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2306z;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bm */
/* loaded from: classes.dex */
class C1605bm extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6121a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1605bm(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f6121a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f6121a.f5509aB) {
            this.f6121a.f5546ao.startQuery(12, null, C2306z.m10220b(this.f6121a.f5750v), null, null, null, null);
        } else if (this.f6121a.m7989aR() != null) {
            this.f6121a.f5747ez.m8774c();
        }
    }
}
