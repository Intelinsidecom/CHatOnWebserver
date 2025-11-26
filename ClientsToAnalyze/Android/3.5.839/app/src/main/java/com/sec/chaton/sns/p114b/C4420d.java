package com.sec.chaton.sns.p114b;

import com.facebook.C0443am;
import com.facebook.C0456az;
import com.facebook.EnumC0434ad;
import com.facebook.InterfaceC0450at;
import com.facebook.model.GraphCustomUser;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.dlc.api.DlcApi;
import java.util.List;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.sns.b.d */
/* loaded from: classes.dex */
class C4420d implements InterfaceC0450at {

    /* renamed from: a */
    final /* synthetic */ C4374a f15975a;

    C4420d(C4374a c4374a) {
        this.f15975a = c4374a;
    }

    @Override // com.facebook.InterfaceC0450at
    /* renamed from: a */
    public void mo1623a(List<GraphCustomUser> list, C0456az c0456az) {
        C0443am c0443amM1662c = c0456az.m1662c();
        synchronized (this.f15975a.f15850f) {
            this.f15975a.f15850f.remove(c0443amM1662c);
        }
        if (c0456az.m1659a() == null) {
            this.f15975a.f15848d.mo16563a(0, -1, list);
            return;
        }
        C4904y.m18634a("error from facebook getFriends API Call error: " + c0456az.m1659a() + "error Type = " + c0456az.m1659a().m1558d(), "[FaceBookManager]");
        EnumC0434ad enumC0434adM1555a = c0456az.m1659a().m1555a();
        if (enumC0434adM1555a == EnumC0434ad.AUTHENTICATION_REOPEN_SESSION || enumC0434adM1555a == EnumC0434ad.AUTHENTICATION_RETRY) {
            this.f15975a.f15848d.mo16563a(0, DlcApi.RC_SVC_NOT_CONNECTED, "NeedUserLoginAgain");
        } else {
            this.f15975a.f15848d.mo16563a(0, DlcApi.RC_SVC_NOT_CONNECTED, c0456az.m1659a().m1558d());
        }
    }
}
