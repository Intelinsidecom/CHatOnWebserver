package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0678e;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.da */
/* loaded from: classes.dex */
class HandlerC0343da extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f1486a;

    HandlerC0343da(BuddyProfileFragment buddyProfileFragment) {
        this.f1486a = buddyProfileFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 8) {
            C0668l.m3077a(new C0668l(), 2, new C0678e(this.f1486a.f1149k, this.f1486a.f1158t, 2, true));
        }
    }
}
