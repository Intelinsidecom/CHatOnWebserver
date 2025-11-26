package com.sec.chaton.settings.tellfriends;

import java.util.TimerTask;

/* compiled from: OauthSignin.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ad */
/* loaded from: classes.dex */
class C1349ad extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ OauthSignin f5156a;

    private C1349ad(OauthSignin oauthSignin) {
        this.f5156a = oauthSignin;
    }

    /* synthetic */ C1349ad(OauthSignin oauthSignin, HandlerC1473v handlerC1473v) {
        this(oauthSignin);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f5156a.f4976f.sendEmptyMessage(9001);
    }
}
