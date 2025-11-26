package com.sec.chaton.buddy;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.au */
/* loaded from: classes.dex */
class C0279au extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f1374a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f1375b;

    C0279au(BuddyFragment buddyFragment, Handler handler) {
        this.f1375b = buddyFragment;
        this.f1374a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f1374a.post(new RunnableC0280av(this));
    }
}
