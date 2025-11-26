package com.sec.chaton.settings.tellfriends;

import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: SnsFriendsUsingChatOnActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.aq */
/* loaded from: classes.dex */
class RunnableC1362aq implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1361ap f5188a;

    RunnableC1362aq(C1361ap c1361ap) {
        this.f5188a = c1361ap;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5188a.f5187a.f5184b.m4857j();
        Toast.makeText(this.f5188a.f5187a.f5183a, this.f5188a.f5187a.f5184b.getResources().getString(R.string.toast_network_unable), 0).show();
    }
}
