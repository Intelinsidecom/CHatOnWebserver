package com.sec.chaton.sns.p114b;

import com.sec.chaton.sns.p113a.InterfaceC4367d;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;
import p021c.C0346e;

/* compiled from: SnsHelperWeibo.java */
/* renamed from: com.sec.chaton.sns.b.as */
/* loaded from: classes.dex */
class C4393as implements InterfaceC4367d {

    /* renamed from: a */
    final /* synthetic */ C4392ar f15919a;

    C4393as(C4392ar c4392ar) {
        this.f15919a = c4392ar;
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4367d
    /* renamed from: a */
    public void mo16563a(int i, int i2, Object obj) {
        switch (i) {
            case 12001:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS \tRESULT_OK \t- " + i2, C4392ar.f15910a);
                    if (obj instanceof ArrayList) {
                        ArrayList<C4379ae> arrayList = new ArrayList<>();
                        Iterator it = ((ArrayList) obj).iterator();
                        while (it.hasNext()) {
                            C0346e c0346e = (C0346e) it.next();
                            arrayList.add(new C4379ae(String.valueOf(c0346e.m1217a()), c0346e.m1218b(), c0346e.m1219c(), c0346e.m1220d() != null ? c0346e.m1220d().toString() : ""));
                        }
                        this.f15919a.f15914e.mo9439a(arrayList);
                        break;
                    }
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS \tRESULT_CANCELED \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15914e.mo9437a();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_GET_FRIENDS \tRESULT_ERROR \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15914e.mo9438a(i2);
                    break;
                }
                break;
            case 12002:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_POST_TO_FRIEND \tRESULT_OK \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15915f.mo16621a();
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_POST_TO_FRIEND \tRESULT_CANCELED \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15915f.mo16623b();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_POST_TO_FRIEND \tRESULT_ERROR \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15915f.mo16622a(i2);
                    break;
                }
            case 12003:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_LOGOUT \tRESULT_OK \t- " + i2, C4392ar.f15910a);
                    if (this.f15919a.f15912c != null) {
                        this.f15919a.f15912c.mo13845a();
                        break;
                    }
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_LOGOUT \tRESULT_CANCELED \t- " + i2, C4392ar.f15910a);
                    if (this.f15919a.f15912c != null) {
                        this.f15919a.f15912c.mo13846b();
                        break;
                    }
                } else {
                    C4904y.m18639b("REQUEST_LOGOUT \tRESULT_ERROR \t- " + i2, C4392ar.f15910a);
                    if (this.f15919a.f15912c != null) {
                        this.f15919a.f15912c.mo13847c();
                        break;
                    }
                }
                break;
            case 12004:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_LOGIN \tRESULT_OK \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15913d.mo9434a();
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_LOGIN \tRESULT_CANCELED \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15913d.mo9436b();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_LOGIN \tRESULT_ERROR \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15913d.mo9435a(i2);
                    break;
                }
            case 12005:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_PREPARE_LOGIN \tRESULT_OK \t- " + i2, C4392ar.f15910a);
                    this.f15919a.mo16641a(this.f15919a.f15913d);
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_PREPARE_LOGIN \tRESULT_CANCELED \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15913d.mo9436b();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_PREPARE_LOGIN \tRESULT_ERROR \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15913d.mo9435a(i2);
                    break;
                }
            case 12006:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS_ID \tRESULT_OK \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15916g.mo9442a(obj);
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS_ID \tRESULT_CANCELED \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15916g.mo9440a();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_GET_FRIENDS_ID \tRESULT_ERROR \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15916g.mo9441a(i2);
                    break;
                }
            case 12007:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_GET_USER_INFO \tRESULT_OK \t- " + i2, C4392ar.f15910a);
                    if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it2 = ((ArrayList) obj).iterator();
                        while (it2.hasNext()) {
                            C0346e c0346e2 = (C0346e) it2.next();
                            C4904y.m18639b("REQUEST_GET_USER_INFO \tLong id=" + c0346e2.m1217a() + " int id=" + c0346e2.m1217a(), C4392ar.f15910a);
                            arrayList2.add(new C4379ae(String.valueOf(c0346e2.m1217a()), c0346e2.m1218b(), c0346e2.m1219c(), c0346e2.m1220d() != null ? c0346e2.m1220d().toString() : ""));
                        }
                        this.f15919a.f15917h.m16620a(arrayList2);
                        break;
                    }
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_GET_USER_INFO \tRESULT_CANCELED \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15917h.m16618a();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_GET_USER_INFO \tRESULT_ERROR \t- " + i2, C4392ar.f15910a);
                    this.f15919a.f15917h.m16619a(i2);
                    break;
                }
                break;
        }
    }
}
