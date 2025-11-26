package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.settings.tellfriends.common.AbstractC2800p;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.auth.AccessToken;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.be */
/* loaded from: classes.dex */
class C2755be extends AbstractC2800p {

    /* renamed from: a */
    AccessToken f10160a;

    /* renamed from: b */
    final /* synthetic */ C2751ba f10161b;

    /* synthetic */ C2755be(C2751ba c2751ba, AccessToken accessToken, HandlerC2752bb handlerC2752bb) {
        this(c2751ba, accessToken);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C2755be(C2751ba c2751ba, AccessToken accessToken) {
        super(c2751ba, "GetMyInfoTask");
        this.f10161b = c2751ba;
        this.f10160a = accessToken;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.AbstractC2800p
    /* renamed from: a */
    protected int mo9862a() {
        this.f10161b.m10014b("GetMyInfoTask() : Get my name");
        String message = null;
        try {
            User userShowUser = C2751ba.f10150e.showUser(this.f10160a.getUserId());
            if (userShowUser != null) {
                C2760bj.m9871b(this.f10161b.f10300b, String.valueOf(this.f10160a.getUserId()));
                C2760bj.m9867a(this.f10161b.f10300b, userShowUser.getName());
                C2760bj.m9873c(this.f10161b.f10300b, userShowUser.getProfileImageURL().toString());
            }
            new C1330h(this.f10161b.f10153h).m5724a(C2831y.f10363b, C2760bj.m9874d(this.f10161b.f10300b));
            this.f10304e = -1;
        } catch (TwitterException e) {
            e.printStackTrace();
            this.f10304e = -1001;
            message = e.getMessage();
        }
        this.f10305f = message;
        return this.f10304e;
    }
}
