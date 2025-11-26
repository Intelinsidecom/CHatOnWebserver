package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.settings.tellfriends.common.AbstractC2800p;
import weibo4android.WeiboException;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bz */
/* loaded from: classes.dex */
class C2776bz extends AbstractC2800p {

    /* renamed from: a */
    String f10206a;

    /* renamed from: b */
    final /* synthetic */ C2770bt f10207b;

    /* synthetic */ C2776bz(C2770bt c2770bt, String str, HandlerC2771bu handlerC2771bu) {
        this(c2770bt, str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C2776bz(C2770bt c2770bt, String str) {
        super(c2770bt, "InviteMessageTask");
        this.f10207b = c2770bt;
        this.f10206a = null;
        this.f10206a = str;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.AbstractC2800p
    /* renamed from: a */
    protected int mo9862a() {
        String message = null;
        try {
            C2770bt.f10195d.updateStatus(this.f10206a);
        } catch (WeiboException e) {
            e.printStackTrace();
            this.f10304e = -1005;
            message = e.getMessage();
        }
        this.f10305f = message;
        return this.f10304e;
    }
}
