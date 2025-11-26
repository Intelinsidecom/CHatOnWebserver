package com.sec.chaton.sns.p114b;

import com.facebook.model.GraphCustomUser;
import com.facebook.model.GraphObjectList;
import com.sec.chaton.p051c.C1428b;
import com.sec.chaton.sns.p113a.InterfaceC4367d;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: SnsHelperFacebook.java */
/* renamed from: com.sec.chaton.sns.b.ag */
/* loaded from: classes.dex */
class C4381ag implements InterfaceC4367d {

    /* renamed from: a */
    final /* synthetic */ C4380af f15865a;

    C4381ag(C4380af c4380af) {
        this.f15865a = c4380af;
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4367d
    /* renamed from: a */
    public void mo16563a(int i, int i2, Object obj) {
        switch (i) {
            case 0:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS \tRESULT_OK \t- resultCode : " + i2, C4380af.f15857a);
                    if (obj instanceof GraphObjectList) {
                        ArrayList<C4379ae> arrayList = new ArrayList<>();
                        for (GraphCustomUser graphCustomUser : (GraphObjectList) obj) {
                            arrayList.add(new C4379ae(graphCustomUser.getId(), graphCustomUser.getName(), C1428b.f5108n + graphCustomUser.getId() + "/picture", graphCustomUser.getInstalled().booleanValue()));
                        }
                        this.f15865a.f15861e.mo9439a(arrayList);
                        break;
                    }
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS \tRESULT_CANCELED \t- resultCode : " + i2, C4380af.f15857a);
                    this.f15865a.f15861e.mo9437a();
                    break;
                } else {
                    C4904y.m18634a("REQUEST_GET_FRIENDS \tRESULT_ERROR \t- resultCode : " + i2, C4380af.f15857a);
                    if (!"NeedUserLoginAgain".equals(obj)) {
                        this.f15865a.f15861e.mo9438a(i2);
                        break;
                    } else {
                        C4904y.m18634a("REQUEST_GET_FRIENDS \tRESULT_ERROR \t- AUTH_TOKEN_FAILURE_revoked for FB", C4380af.f15857a);
                        this.f15865a.f15861e.mo9438a(1307);
                        break;
                    }
                }
                break;
            case 1:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_POST_TO_FRIEND \tRESULT_OK \t- resultCode : " + i2, C4380af.f15857a);
                    this.f15865a.f15862f.mo16621a();
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_POST_TO_FRIEND \tRESULT_CANCELED \t- resultCode : " + i2, C4380af.f15857a);
                    this.f15865a.f15862f.mo16623b();
                    break;
                } else {
                    C4904y.m18634a("REQUEST_POST_TO_FRIEND \tRESULT_ERROR \t- resultCode : " + i2, C4380af.f15857a);
                    this.f15865a.f15862f.mo16622a(i2);
                    break;
                }
            case 2:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_LOGOUT \tRESULT_OK \t- resultCode : " + i2, C4380af.f15857a);
                    if (this.f15865a.f15863g != null) {
                        this.f15865a.f15863g.mo13845a();
                        break;
                    }
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_LOGOUT \tRESULT_CANCELED \t- resultCode : " + i2, C4380af.f15857a);
                    if (this.f15865a.f15863g != null) {
                        this.f15865a.f15863g.mo13846b();
                        break;
                    }
                } else {
                    C4904y.m18634a("REQUEST_LOGOUT \tRESULT_ERROR \t- resultCode : " + i2, C4380af.f15857a);
                    if (this.f15865a.f15863g != null) {
                        this.f15865a.f15863g.mo13847c();
                        break;
                    }
                }
                break;
            case 3:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_LOGIN \tRESULT_OK \t- " + i2, C4380af.f15857a);
                    this.f15865a.f15864h.mo9434a();
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_LOGIN \tRESULT_CANCELED \t- " + i2, C4380af.f15857a);
                    this.f15865a.f15864h.mo9436b();
                    break;
                } else {
                    C4904y.m18634a("REQUEST_LOGIN \tRESULT_ERROR \t- resultCode : " + i2, C4380af.f15857a);
                    this.f15865a.f15864h.mo9435a(i2);
                    break;
                }
        }
    }
}
