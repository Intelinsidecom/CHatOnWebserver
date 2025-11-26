package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.util.C1786r;
import java.util.TimerTask;

/* compiled from: SnsFriendsUsingChatOnActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ap */
/* loaded from: classes.dex */
class C1361ap extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1360ao f5187a;

    C1361ap(AsyncTaskC1360ao asyncTaskC1360ao) {
        this.f5187a = asyncTaskC1360ao;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        C1786r.m6054a("Time Out! \t- 30000ms", SnsFriendsUsingChatOnActivity.f4981d);
        synchronized (this.f5187a.f5185c) {
            this.f5187a.f5185c = true;
            this.f5187a.cancel(true);
            this.f5187a.f5183a.runOnUiThread(new RunnableC1362aq(this));
        }
    }
}
