package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.settings.tellfriends.common.AbstractC2800p;
import weibo4android.User;
import weibo4android.WeiboException;
import weibo4android.http.AccessToken;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bx */
/* loaded from: classes.dex */
class C2774bx extends AbstractC2800p {

    /* renamed from: a */
    AccessToken f10203a;

    /* renamed from: b */
    final /* synthetic */ C2770bt f10204b;

    /* synthetic */ C2774bx(C2770bt c2770bt, AccessToken accessToken, HandlerC2771bu handlerC2771bu) {
        this(c2770bt, accessToken);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C2774bx(C2770bt c2770bt, AccessToken accessToken) {
        super(c2770bt, "GetMyInfoTask");
        this.f10204b = c2770bt;
        this.f10203a = accessToken;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.AbstractC2800p
    /* renamed from: a */
    protected int mo9862a() {
        this.f10204b.m10014b("GetMyInfoTask() : Get my name");
        String message = null;
        try {
            User userShowUser = C2770bt.f10195d.showUser(String.valueOf(this.f10203a.getUserId()));
            if (userShowUser != null) {
                C2780cc.m9919b(this.f10204b.f10300b, String.valueOf(this.f10203a.getUserId()));
                C2780cc.m9915a(this.f10204b.f10300b, userShowUser.getName());
                C2780cc.m9921c(this.f10204b.f10300b, userShowUser.getProfileImageURL().toString());
            }
            new C1330h(this.f10204b.f10197f).m5724a(C2831y.f10363b, C2780cc.m9922d(this.f10204b.f10300b));
            this.f10304e = -1;
        } catch (WeiboException e) {
            e.printStackTrace();
            this.f10304e = -1005;
            message = e.getMessage();
        }
        this.f10305f = message;
        return this.f10304e;
    }
}
