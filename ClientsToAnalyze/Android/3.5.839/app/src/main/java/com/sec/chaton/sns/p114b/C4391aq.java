package com.sec.chaton.sns.p114b;

import com.p137vk.sdk.api.model.VKUser;
import com.p137vk.sdk.api.model.VKUsersArray;
import com.sec.chaton.sns.p113a.InterfaceC4367d;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: SnsHelperVKontakte.java */
/* renamed from: com.sec.chaton.sns.b.aq */
/* loaded from: classes.dex */
class C4391aq implements InterfaceC4367d {

    /* renamed from: a */
    final /* synthetic */ C4388an f15909a;

    C4391aq(C4388an c4388an) {
        this.f15909a = c4388an;
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4367d
    /* renamed from: a */
    public void mo16563a(int i, int i2, Object obj) {
        switch (i) {
            case 12001:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS \tRESULT_OK \t- " + i2, C4388an.f15894a);
                    if (obj instanceof VKUsersArray) {
                        VKUsersArray vKUsersArray = (VKUsersArray) obj;
                        ArrayList<C4379ae> arrayList = new ArrayList<>();
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= vKUsersArray.size()) {
                                this.f15909a.f15897d.mo9439a(arrayList);
                                break;
                            } else {
                                VKUser vKUser = vKUsersArray.get(i4);
                                arrayList.add(new C4379ae(Long.toString(vKUser.f18976id), vKUser.first_name + " " + vKUser.last_name, vKUser.screen_name, vKUser.getApproProfileUrl() != null ? vKUser.getApproProfileUrl().toString() : ""));
                                i3 = i4 + 1;
                            }
                        }
                    }
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS \tRESULT_CANCELLED \t- " + i2, C4388an.f15894a);
                    this.f15909a.f15897d.mo9437a();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_GET_FRIENDS \tRESULT_ERROR \t- " + i2, C4388an.f15894a);
                    if (!"NeedUserLoginAgain".equals(obj)) {
                        this.f15909a.f15897d.mo9438a(i2);
                        break;
                    } else {
                        C4904y.m18634a("REQUEST_GET_FRIENDS \tRESULT_ERROR \t- AUTH_TOKEN_FAILURE_revoked for VK", C4388an.f15894a);
                        this.f15909a.f15897d.mo9438a(1307);
                        break;
                    }
                }
                break;
            case 12002:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_POST_TO_FRIEND \tRESULT_OK \t- " + i2, C4388an.f15894a);
                    this.f15909a.f15899f.mo16621a();
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_POST_TO_FRIEND \tRESULT_CANCELLED \t- " + i2, C4388an.f15894a);
                    this.f15909a.f15899f.mo16623b();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_POST_TO_FRIEND \tRESULT_ERROR \t- " + i2, C4388an.f15894a);
                    this.f15909a.f15899f.mo16622a(i2);
                    break;
                }
            case 12003:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_LOGOUT \tRESULT_OK \t- " + i2, C4388an.f15894a);
                    if (this.f15909a.f15900g != null) {
                        this.f15909a.f15900g.mo13845a();
                        break;
                    }
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_LOGOUT \tRESULT_CANCELLED \t- " + i2, C4388an.f15894a);
                    if (this.f15909a.f15900g != null) {
                        this.f15909a.f15900g.mo13846b();
                        break;
                    }
                } else {
                    C4904y.m18639b("REQUEST_LOGOUT \tRESULT_ERROR \t- " + i2, C4388an.f15894a);
                    if (this.f15909a.f15900g != null) {
                        this.f15909a.f15900g.mo13847c();
                        break;
                    }
                }
                break;
            case 12004:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_LOGIN \tRESULT_OK \t- " + i2, C4388an.f15894a);
                    this.f15909a.f15896c.mo9434a();
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_LOGIN \tRESULT_CANCELLED \t- " + i2, C4388an.f15894a);
                    this.f15909a.f15896c.mo9436b();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_LOGIN \tRESULT_ERROR \t- " + i2, C4388an.f15894a);
                    this.f15909a.f15896c.mo9435a(i2);
                    break;
                }
            case 12006:
                if (i2 == -1) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS_ID \tRESULT_OK \t- " + i2, C4388an.f15894a);
                    this.f15909a.f15898e.mo9442a(obj);
                    break;
                } else if (i2 == 0) {
                    C4904y.m18639b("REQUEST_GET_FRIENDS_ID \tRESULT_CANCELLED \t- " + i2, C4388an.f15894a);
                    this.f15909a.f15898e.mo9440a();
                    break;
                } else {
                    C4904y.m18639b("REQUEST_GET_FRIENDS_ID \tRESULT_ERROR \t- " + i2, C4388an.f15894a);
                    this.f15909a.f15898e.mo9441a(i2);
                    break;
                }
        }
    }
}
