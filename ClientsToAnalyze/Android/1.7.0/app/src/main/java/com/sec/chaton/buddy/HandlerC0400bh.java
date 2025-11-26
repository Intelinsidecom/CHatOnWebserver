package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p025d.p026a.C0627g;
import com.sec.chaton.p025d.p027b.C0643f;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.bh */
/* loaded from: classes.dex */
class HandlerC0400bh extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f1374a;

    HandlerC0400bh(BuddyProfileActivity buddyProfileActivity) {
        this.f1374a = buddyProfileActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 8) {
            C0627g.m2858a(new C0627g(), 2, new C0643f(this.f1374a.f1235e, this.f1374a.f1241l, 2, true));
        }
    }
}
