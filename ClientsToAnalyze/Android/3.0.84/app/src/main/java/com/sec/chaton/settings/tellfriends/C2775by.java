package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.settings.tellfriends.common.AbstractC2800p;
import com.sec.spp.push.dlc.api.DlcApi;
import weibo4android.WeiboException;
import weibo4android.http.RequestToken;

/* compiled from: WeiboManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.by */
/* loaded from: classes.dex */
class C2775by extends AbstractC2800p {

    /* renamed from: a */
    final /* synthetic */ C2770bt f10205a;

    /* synthetic */ C2775by(C2770bt c2770bt, HandlerC2771bu handlerC2771bu) {
        this(c2770bt);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C2775by(C2770bt c2770bt) {
        super(c2770bt, "GetRequestTokenTask");
        this.f10205a = c2770bt;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.AbstractC2800p
    /* renamed from: a */
    protected int mo9862a() {
        String message = null;
        this.f10205a.m10014b("GetRequestTokenTask() : Get Request Token");
        try {
            try {
                RequestToken unused = C2770bt.f10196e = C2770bt.f10195d.getOAuthRequestToken("chaton://WeiboSubMenuActivity");
                if (C2770bt.f10196e == null || C2770bt.f10196e.getToken().isEmpty()) {
                    this.f10205a.m10015c("Incorrect Request Token!");
                    this.f10304e = DlcApi.RC_SVC_NOT_CONNECTED;
                    this.f10305f = null;
                } else {
                    this.f10304e = -1;
                    message = C2770bt.f10196e.getToken();
                }
            } catch (WeiboException e) {
                e.printStackTrace();
                this.f10304e = -1005;
                message = e.getMessage();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f10304e = DlcApi.RC_SVC_NOT_CONNECTED;
            message = e2.getMessage();
        }
        this.f10305f = message;
        return this.f10304e;
    }
}
