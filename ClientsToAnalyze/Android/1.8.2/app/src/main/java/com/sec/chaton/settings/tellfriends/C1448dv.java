package com.sec.chaton.settings.tellfriends;

import java.util.TimerTask;

/* compiled from: WeiboSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dv */
/* loaded from: classes.dex */
class C1448dv extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ WeiboSignIn f5342a;

    private C1448dv(WeiboSignIn weiboSignIn) {
        this.f5342a = weiboSignIn;
    }

    /* synthetic */ C1448dv(WeiboSignIn weiboSignIn, HandlerC1442dp handlerC1442dp) {
        this(weiboSignIn);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f5342a.f5125e != null) {
            this.f5342a.f5125e.sendEmptyMessage(9001);
        }
    }
}
