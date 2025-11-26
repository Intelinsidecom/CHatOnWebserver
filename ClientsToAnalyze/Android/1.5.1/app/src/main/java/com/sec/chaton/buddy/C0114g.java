package com.sec.chaton.buddy;

import android.os.Handler;
import java.util.TimerTask;

/* renamed from: com.sec.chaton.buddy.g */
/* loaded from: classes.dex */
class C0114g extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f658a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f659b;

    C0114g(BuddyFragment buddyFragment, Handler handler) {
        this.f659b = buddyFragment;
        this.f658a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f658a.post(new RunnableC0099aw(this));
    }
}
