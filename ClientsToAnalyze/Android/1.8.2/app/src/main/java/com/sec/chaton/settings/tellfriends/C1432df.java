package com.sec.chaton.settings.tellfriends;

import java.util.TimerTask;

/* compiled from: TwitterSignIn.java */
/* renamed from: com.sec.chaton.settings.tellfriends.df */
/* loaded from: classes.dex */
class C1432df extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ TwitterSignIn f5315a;

    private C1432df(TwitterSignIn twitterSignIn) {
        this.f5315a = twitterSignIn;
    }

    /* synthetic */ C1432df(TwitterSignIn twitterSignIn, HandlerC1424cy handlerC1424cy) {
        this(twitterSignIn);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f5315a.f5095f != null) {
            this.f5315a.f5095f.sendEmptyMessage(9001);
        }
    }
}
