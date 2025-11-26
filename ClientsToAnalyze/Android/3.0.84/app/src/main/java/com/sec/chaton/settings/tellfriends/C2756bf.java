package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.settings.tellfriends.common.AbstractC2800p;
import com.sec.spp.push.dlc.api.DlcApi;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bf */
/* loaded from: classes.dex */
class C2756bf extends AbstractC2800p {

    /* renamed from: a */
    final /* synthetic */ C2751ba f10162a;

    /* synthetic */ C2756bf(C2751ba c2751ba, HandlerC2752bb handlerC2752bb) {
        this(c2751ba);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C2756bf(C2751ba c2751ba) {
        super(c2751ba, "GetRequestTokenTask");
        this.f10162a = c2751ba;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.AbstractC2800p
    /* renamed from: a */
    protected int mo9862a() {
        this.f10162a.m10014b("GetRequestTokenTask() : Get Request Token");
        try {
            RequestToken unused = C2751ba.f10151f = C2751ba.f10150e.getOAuthRequestToken();
            if (C2751ba.f10151f == null || C2751ba.f10151f.getToken().isEmpty()) {
                this.f10162a.m10015c("Incorrect Request Token!");
                this.f10304e = DlcApi.RC_SVC_NOT_CONNECTED;
                this.f10305f = null;
            } else {
                this.f10304e = -1;
                this.f10305f = C2751ba.f10151f.getToken();
            }
        } catch (TwitterException e) {
            e.printStackTrace();
            this.f10304e = -1001;
            e.getMessage();
        }
        return this.f10304e;
    }
}
