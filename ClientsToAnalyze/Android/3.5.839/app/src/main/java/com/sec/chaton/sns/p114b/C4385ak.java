package com.sec.chaton.sns.p114b;

import com.renren.android.p041b.C0712b;
import com.renren.android.p041b.C0713c;
import com.sec.chaton.sns.p113a.InterfaceC4367d;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SnsHelperRenren.java */
/* renamed from: com.sec.chaton.sns.b.ak */
/* loaded from: classes.dex */
class C4385ak implements InterfaceC4367d {

    /* renamed from: a */
    final /* synthetic */ C4384aj f15883a;

    C4385ak(C4384aj c4384aj) {
        this.f15883a = c4384aj;
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4367d
    /* renamed from: a */
    public void mo16563a(int i, int i2, Object obj) {
        switch (i) {
            case 12001:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS \tRESULT_OK \t- " + i2, C4384aj.f15877a);
                    if (obj instanceof String) {
                        ArrayList<C4379ae> arrayList = new ArrayList<>();
                        Iterator<C0713c> it = new C0712b((String) obj).m2267a().iterator();
                        while (it.hasNext()) {
                            C0713c next = it.next();
                            arrayList.add(new C4379ae(String.valueOf(next.m2268a()), next.m2269b(), next.m2270c(), false));
                        }
                        this.f15883a.f15880d.mo9439a(arrayList);
                        break;
                    }
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS \tRESULT_CANCELED \t- " + i2, C4384aj.f15877a);
                    this.f15883a.f15880d.mo9437a();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_GET_FRIENDS \tRESULT_ERROR \t- " + i2, C4384aj.f15877a);
                    this.f15883a.f15880d.mo9438a(i2);
                    break;
                }
                break;
            case 12002:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_POST_TO_FRIEND \tRESULT_OK \t- " + i2, C4384aj.f15877a);
                    this.f15883a.f15881e.mo16621a();
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_POST_TO_FRIEND \tRESULT_CANCELED \t- " + i2, C4384aj.f15877a);
                    this.f15883a.f15881e.mo16623b();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_POST_TO_FRIEND \tRESULT_ERROR \t- " + i2, C4384aj.f15877a);
                    this.f15883a.f15881e.mo16622a(i2);
                    break;
                }
            case 12003:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_LOGOUT \tRESULT_OK \t- " + i2, C4384aj.f15877a);
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_LOGOUT \tRESULT_CANCELED \t- " + i2, C4384aj.f15877a);
                    break;
                } else {
                    C4904y.m18639b("REQUEST_LOGOUT \tRESULT_ERROR \t- " + i2, C4384aj.f15877a);
                    break;
                }
            case 12004:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_LOGIN \tRESULT_OK \t- " + i2, C4384aj.f15877a);
                    this.f15883a.f15879c.mo9434a();
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_LOGIN \tRESULT_CANCELED \t- " + i2, C4384aj.f15877a);
                    this.f15883a.f15879c.mo9436b();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_LOGIN \tRESULT_ERROR \t- " + i2, C4384aj.f15877a);
                    this.f15883a.f15879c.mo9435a(i2);
                    break;
                }
            case 12006:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS_ID \tRESULT_OK \t- " + i2, C4384aj.f15877a);
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS_ID \tRESULT_CANCELED \t- " + i2, C4384aj.f15877a);
                    break;
                } else {
                    C4904y.m18639b("REQUEST_GET_FRIENDS_ID \tRESULT_ERROR \t- " + i2, C4384aj.f15877a);
                    break;
                }
            case 12007:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_GET_USER_INFO \tRESULT_CANCELED \t- " + i2, C4384aj.f15877a);
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_GET_USER_INFO \tRESULT_CANCELED \t- " + i2, C4384aj.f15877a);
                    break;
                } else {
                    C4904y.m18639b("REQUEST_GET_USER_INFO \tRESULT_ERROR \t- " + i2, C4384aj.f15877a);
                    break;
                }
        }
    }
}
