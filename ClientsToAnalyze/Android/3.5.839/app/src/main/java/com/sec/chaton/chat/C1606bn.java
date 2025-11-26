package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bn */
/* loaded from: classes.dex */
class C1606bn extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6122a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1606bn(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f6122a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C4904y.m18641c("QUERY_PARTICIPANTS_AFTER_INSERTED_onChange", ChatFragment.f5461a);
        this.f6122a.f5546ao.startQuery(5, null, C2220ah.m10090b(this.f6122a.f5750v), null, null, null, null);
    }
}
