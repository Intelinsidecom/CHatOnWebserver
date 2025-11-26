package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.util.C1341p;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bn */
/* loaded from: classes.dex */
class C0574bn extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1991a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0574bn(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f1991a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (!this.f1991a.f1745F) {
            if (C1341p.f4578b) {
                C1341p.m4658b("mUpdatedMessageObserver", getClass().getSimpleName());
            }
            this.f1991a.f1760U.startQuery(0, null, C0662o.m2995a(this.f1991a.f1852by), null, "message_inbox_no=?", new String[]{this.f1991a.f1861t}, null);
        }
    }
}
