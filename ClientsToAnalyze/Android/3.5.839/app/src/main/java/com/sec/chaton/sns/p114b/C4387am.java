package com.sec.chaton.sns.p114b;

import com.sec.chaton.sns.p113a.InterfaceC4367d;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import p010b.InterfaceC0285d;
import p010b.InterfaceC0323j;

/* compiled from: SnsHelperTwitter.java */
/* renamed from: com.sec.chaton.sns.b.am */
/* loaded from: classes.dex */
class C4387am implements InterfaceC4367d {

    /* renamed from: a */
    final /* synthetic */ C4386al f15893a;

    C4387am(C4386al c4386al) {
        this.f15893a = c4386al;
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4367d
    /* renamed from: a */
    public void mo16563a(int i, int i2, Object obj) {
        switch (i) {
            case 12001:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS \tRESULT_OK \t- " + i2, C4386al.f15884a);
                    if (obj instanceof InterfaceC0285d) {
                        ArrayList<C4379ae> arrayList = new ArrayList<>();
                        for (InterfaceC0323j interfaceC0323j : (InterfaceC0285d) obj) {
                            arrayList.add(new C4379ae(Long.toString(interfaceC0323j.m1084a()), interfaceC0323j.m1085b(), interfaceC0323j.m1086c(), interfaceC0323j.m1087d() != null ? interfaceC0323j.m1087d().toString() : ""));
                        }
                        this.f15893a.f15888e.mo9439a(arrayList);
                        break;
                    }
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS \tRESULT_CANCELED \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15888e.mo9437a();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_GET_FRIENDS \tRESULT_ERROR \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15888e.mo9438a(i2);
                    break;
                }
                break;
            case 12002:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_POST_TO_FRIEND \tRESULT_OK \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15889f.mo16621a();
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_POST_TO_FRIEND \tRESULT_CANCELED \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15889f.mo16623b();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_POST_TO_FRIEND \tRESULT_ERROR \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15889f.mo16622a(i2);
                    break;
                }
            case 12003:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_LOGOUT \tRESULT_OK \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15887d.mo13845a();
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_LOGOUT \tRESULT_CANCELED \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15887d.mo13846b();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_LOGOUT \tRESULT_ERROR \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15887d.mo13847c();
                    break;
                }
            case 12004:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_LOGIN \tRESULT_OK \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15886c.mo9434a();
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_LOGIN \tRESULT_CANCELED \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15886c.mo9436b();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_LOGIN \tRESULT_ERROR \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15886c.mo9435a(i2);
                    break;
                }
            case 12005:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_PREPARE_LOGIN \tRESULT_OK \t- " + i2, C4386al.f15884a);
                    this.f15893a.mo16641a(this.f15893a.f15886c);
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_PREPARE_LOGIN \tRESULT_CANCELED \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15886c.mo9436b();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_PREPARE_LOGIN \tRESULT_ERROR \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15886c.mo9435a(i2);
                    break;
                }
            case 12006:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS_ID \tRESULT_OK \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15890g.mo9442a(obj);
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS_ID \tRESULT_CANCELED \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15890g.mo9440a();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_GET_FRIENDS_ID \tRESULT_ERROR \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15890g.mo9441a(i2);
                    break;
                }
            case 12007:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_GET_USER_INFO \tRESULT_CANCELED \t- " + i2, C4386al.f15884a);
                    if (obj instanceof InterfaceC0285d) {
                        ArrayList arrayList2 = new ArrayList();
                        for (InterfaceC0323j interfaceC0323j2 : (InterfaceC0285d) obj) {
                            arrayList2.add(new C4379ae(Long.toString(interfaceC0323j2.m1084a()), interfaceC0323j2.m1085b(), interfaceC0323j2.m1086c(), interfaceC0323j2.m1087d() != null ? interfaceC0323j2.m1087d().toString() : ""));
                        }
                        this.f15893a.f15891h.m16620a(arrayList2);
                        break;
                    }
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_GET_USER_INFO \tRESULT_CANCELED \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15891h.m16618a();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_GET_USER_INFO \tRESULT_ERROR \t- " + i2, C4386al.f15884a);
                    this.f15893a.f15891h.m16619a(i2);
                    break;
                }
                break;
        }
    }
}
