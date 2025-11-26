package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.settings.tellfriends.common.AsyncTaskC2801q;
import com.sec.chaton.settings.tellfriends.common.C2785a;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2786b;
import twitter4j.Twitter;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/* compiled from: TwitterManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bg */
/* loaded from: classes.dex */
public class C2757bg implements InterfaceC2786b {

    /* renamed from: a */
    final /* synthetic */ C2751ba f10163a;

    /* renamed from: b */
    private int f10164b;

    public C2757bg(C2751ba c2751ba, int i) {
        this.f10163a = c2751ba;
        this.f10164b = i;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo541a(Object obj) {
        this.f10163a.m10014b("Login Request:" + this.f10164b + " Done.");
        if (obj instanceof AccessToken) {
            AccessToken accessToken = (AccessToken) obj;
            C2760bj.m9869a(accessToken, this.f10163a.f10300b);
            new AsyncTaskC2801q(this.f10163a, this.f10164b).execute(new C2755be(this.f10163a, accessToken, null));
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo540a(C2785a c2785a) {
        this.f10163a.m10015c("Login Request:" + this.f10164b + " Webview Error. " + c2785a.getMessage());
        if (c2785a.m9994a() != -1002) {
            this.f10163a.f10301c.mo9799a(this.f10164b, c2785a.m9994a(), c2785a.getMessage());
        } else {
            this.f10163a.f10301c.mo9799a(this.f10164b, -1002, c2785a.getMessage());
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo539a() {
        this.f10163a.m10014b("Login Request:" + this.f10164b + " Canceled.");
        Twitter unused = C2751ba.f10150e = null;
        RequestToken unused2 = C2751ba.f10151f = null;
        this.f10163a.f10301c.mo9799a(this.f10164b, 0, null);
    }
}
