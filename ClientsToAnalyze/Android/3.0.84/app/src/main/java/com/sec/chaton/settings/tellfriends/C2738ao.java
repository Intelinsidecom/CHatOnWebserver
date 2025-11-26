package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.settings.tellfriends.common.InterfaceC2787c;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import twitter4j.ResponseList;
import twitter4j.User;

/* compiled from: SnsHelperTwitter.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ao */
/* loaded from: classes.dex */
class C2738ao implements InterfaceC2787c {

    /* renamed from: a */
    final /* synthetic */ C2737an f10112a;

    C2738ao(C2737an c2737an) {
        this.f10112a = c2737an;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2787c
    /* renamed from: a */
    public void mo9799a(int i, int i2, Object obj) {
        switch (i) {
            case 12001:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_GET_FRIENDS \tRESULT_OK \t- " + i2, C2737an.f10103a);
                    if (obj instanceof ResponseList) {
                        ArrayList<C2732ai> arrayList = new ArrayList<>();
                        for (User user : (ResponseList) obj) {
                            arrayList.add(new C2732ai(Long.toString(user.getId()), user.getName(), user.getScreenName(), user.getProfileImageURL() != null ? user.getProfileImageURL().toString() : ""));
                        }
                        this.f10112a.f10107e.mo5655a(arrayList);
                        break;
                    }
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_GET_FRIENDS \tRESULT_CANCELED \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10107e.mo5653a();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_GET_FRIENDS \tRESULT_ERROR \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10107e.mo5654a(i2);
                    break;
                }
                break;
            case 12002:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_POST_TO_FRIEND \tRESULT_OK \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10108f.mo9779a();
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_POST_TO_FRIEND \tRESULT_CANCELED \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10108f.mo9781b();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_POST_TO_FRIEND \tRESULT_ERROR \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10108f.mo9780a(i2);
                    break;
                }
            case 12003:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_LOGOUT \tRESULT_OK \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10106d.onComplete();
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_LOGOUT \tRESULT_CANCELED \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10106d.onCancelled();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_LOGOUT \tRESULT_ERROR \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10106d.onError();
                    break;
                }
            case 12004:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_LOGIN \tRESULT_OK \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10105c.onComplete();
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_LOGIN \tRESULT_CANCELED \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10105c.onCancelled();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_LOGIN \tRESULT_ERROR \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10105c.onError(i2);
                    break;
                }
            case 12005:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_PREPARE_LOGIN \tRESULT_OK \t- " + i2, C2737an.f10103a);
                    this.f10112a.mo9771a(this.f10112a.f10105c);
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_PREPARE_LOGIN \tRESULT_CANCELED \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10105c.onCancelled();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_PREPARE_LOGIN \tRESULT_ERROR \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10105c.onError(i2);
                    break;
                }
            case 12006:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_GET_FRIENDS_ID \tRESULT_OK \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10109g.mo5658a(obj);
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_GET_FRIENDS_ID \tRESULT_CANCELED \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10109g.mo5656a();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_GET_FRIENDS_ID \tRESULT_ERROR \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10109g.mo5657a(i2);
                    break;
                }
            case 12007:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_GET_USER_INFO \tRESULT_CANCELED \t- " + i2, C2737an.f10103a);
                    if (obj instanceof ResponseList) {
                        ArrayList arrayList2 = new ArrayList();
                        for (User user2 : (ResponseList) obj) {
                            arrayList2.add(new C2732ai(Long.toString(user2.getId()), user2.getName(), user2.getScreenName(), user2.getProfileImageURL() != null ? user2.getProfileImageURL().toString() : ""));
                        }
                        this.f10112a.f10110h.m9778a(arrayList2);
                        break;
                    }
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_GET_USER_INFO \tRESULT_CANCELED \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10110h.m9776a();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_GET_USER_INFO \tRESULT_ERROR \t- " + i2, C2737an.f10103a);
                    this.f10112a.f10110h.m9777a(i2);
                    break;
                }
                break;
        }
    }
}
