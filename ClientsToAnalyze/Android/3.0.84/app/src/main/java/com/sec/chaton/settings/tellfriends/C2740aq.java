package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.settings.tellfriends.common.InterfaceC2787c;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Iterator;
import weibo4android.User;

/* compiled from: SnsHelperWeibo.java */
/* renamed from: com.sec.chaton.settings.tellfriends.aq */
/* loaded from: classes.dex */
class C2740aq implements InterfaceC2787c {

    /* renamed from: a */
    final /* synthetic */ C2739ap f10122a;

    C2740aq(C2739ap c2739ap) {
        this.f10122a = c2739ap;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2787c
    /* renamed from: a */
    public void mo9799a(int i, int i2, Object obj) {
        switch (i) {
            case 12001:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_GET_FRIENDS \tRESULT_OK \t- " + i2, C2739ap.f10113a);
                    if (obj instanceof ArrayList) {
                        ArrayList<C2732ai> arrayList = new ArrayList<>();
                        Iterator it = ((ArrayList) obj).iterator();
                        while (it.hasNext()) {
                            User user = (User) it.next();
                            arrayList.add(new C2732ai(String.valueOf(user.getId()), user.getName(), user.getScreenName(), user.getProfileImageURL() != null ? user.getProfileImageURL().toString() : ""));
                        }
                        this.f10122a.f10117e.mo5655a(arrayList);
                        break;
                    }
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_GET_FRIENDS \tRESULT_CANCELED \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10117e.mo5653a();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_GET_FRIENDS \tRESULT_ERROR \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10117e.mo5654a(i2);
                    break;
                }
                break;
            case 12002:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_POST_TO_FRIEND \tRESULT_OK \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10118f.mo9779a();
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_POST_TO_FRIEND \tRESULT_CANCELED \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10118f.mo9781b();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_POST_TO_FRIEND \tRESULT_ERROR \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10118f.mo9780a(i2);
                    break;
                }
            case 12003:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_LOGOUT \tRESULT_OK \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10115c.onComplete();
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_LOGOUT \tRESULT_CANCELED \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10115c.onCancelled();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_LOGOUT \tRESULT_ERROR \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10115c.onError();
                    break;
                }
            case 12004:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_LOGIN \tRESULT_OK \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10116d.onComplete();
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_LOGIN \tRESULT_CANCELED \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10116d.onCancelled();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_LOGIN \tRESULT_ERROR \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10116d.onError(i2);
                    break;
                }
            case 12005:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_PREPARE_LOGIN \tRESULT_OK \t- " + i2, C2739ap.f10113a);
                    this.f10122a.mo9771a(this.f10122a.f10116d);
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_PREPARE_LOGIN \tRESULT_CANCELED \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10116d.onCancelled();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_PREPARE_LOGIN \tRESULT_ERROR \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10116d.onError(i2);
                    break;
                }
            case 12006:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_GET_FRIENDS_ID \tRESULT_OK \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10119g.mo5658a(obj);
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_GET_FRIENDS_ID \tRESULT_CANCELED \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10119g.mo5656a();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_GET_FRIENDS_ID \tRESULT_ERROR \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10119g.mo5657a(i2);
                    break;
                }
            case 12007:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_GET_USER_INFO \tRESULT_OK \t- " + i2, C2739ap.f10113a);
                    if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it2 = ((ArrayList) obj).iterator();
                        while (it2.hasNext()) {
                            User user2 = (User) it2.next();
                            C3250y.m11450b("REQUEST_GET_USER_INFO \tLong id=" + user2.getId() + " int id=" + user2.getId(), C2739ap.f10113a);
                            arrayList2.add(new C2732ai(String.valueOf(user2.getId()), user2.getName(), user2.getScreenName(), user2.getProfileImageURL() != null ? user2.getProfileImageURL().toString() : ""));
                        }
                        this.f10122a.f10120h.m9778a(arrayList2);
                        break;
                    }
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_GET_USER_INFO \tRESULT_CANCELED \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10120h.m9776a();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_GET_USER_INFO \tRESULT_ERROR \t- " + i2, C2739ap.f10113a);
                    this.f10122a.f10120h.m9777a(i2);
                    break;
                }
                break;
        }
    }
}
