package com.sec.chaton.settings.tellfriends;

import com.renren.android.p011b.C0200b;
import com.renren.android.p011b.C0201c;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2787c;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SnsHelperRenren.java */
/* renamed from: com.sec.chaton.settings.tellfriends.am */
/* loaded from: classes.dex */
class C2736am implements InterfaceC2787c {

    /* renamed from: a */
    final /* synthetic */ C2735al f10102a;

    C2736am(C2735al c2735al) {
        this.f10102a = c2735al;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2787c
    /* renamed from: a */
    public void mo9799a(int i, int i2, Object obj) {
        switch (i) {
            case 12001:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_GET_FRIENDS \tRESULT_OK \t- " + i2, C2735al.f10096a);
                    if (obj instanceof String) {
                        ArrayList<C2732ai> arrayList = new ArrayList<>();
                        Iterator<C0201c> it = new C0200b((String) obj).m535a().iterator();
                        while (it.hasNext()) {
                            C0201c next = it.next();
                            arrayList.add(new C2732ai(String.valueOf(next.m536a()), next.m537b(), next.m538c(), false));
                        }
                        this.f10102a.f10099d.mo5655a(arrayList);
                        break;
                    }
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_GET_FRIENDS \tRESULT_CANCELED \t- " + i2, C2735al.f10096a);
                    this.f10102a.f10099d.mo5653a();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_GET_FRIENDS \tRESULT_ERROR \t- " + i2, C2735al.f10096a);
                    this.f10102a.f10099d.mo5654a(i2);
                    break;
                }
                break;
            case 12002:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_POST_TO_FRIEND \tRESULT_OK \t- " + i2, C2735al.f10096a);
                    this.f10102a.f10100e.mo9779a();
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_POST_TO_FRIEND \tRESULT_CANCELED \t- " + i2, C2735al.f10096a);
                    this.f10102a.f10100e.mo9781b();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_POST_TO_FRIEND \tRESULT_ERROR \t- " + i2, C2735al.f10096a);
                    this.f10102a.f10100e.mo9780a(i2);
                    break;
                }
            case 12003:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_LOGOUT \tRESULT_OK \t- " + i2, C2735al.f10096a);
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_LOGOUT \tRESULT_CANCELED \t- " + i2, C2735al.f10096a);
                    break;
                } else {
                    C3250y.m11450b("REQUEST_LOGOUT \tRESULT_ERROR \t- " + i2, C2735al.f10096a);
                    break;
                }
            case 12004:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_LOGIN \tRESULT_OK \t- " + i2, C2735al.f10096a);
                    this.f10102a.f10098c.onComplete();
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_LOGIN \tRESULT_CANCELED \t- " + i2, C2735al.f10096a);
                    this.f10102a.f10098c.onCancelled();
                    break;
                } else {
                    C3250y.m11450b("REQUEST_LOGIN \tRESULT_ERROR \t- " + i2, C2735al.f10096a);
                    this.f10102a.f10098c.onError(i2);
                    break;
                }
            case 12006:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_GET_FRIENDS_ID \tRESULT_OK \t- " + i2, C2735al.f10096a);
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_GET_FRIENDS_ID \tRESULT_CANCELED \t- " + i2, C2735al.f10096a);
                    break;
                } else {
                    C3250y.m11450b("REQUEST_GET_FRIENDS_ID \tRESULT_ERROR \t- " + i2, C2735al.f10096a);
                    break;
                }
            case 12007:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_GET_USER_INFO \tRESULT_CANCELED \t- " + i2, C2735al.f10096a);
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_GET_USER_INFO \tRESULT_CANCELED \t- " + i2, C2735al.f10096a);
                    break;
                } else {
                    C3250y.m11450b("REQUEST_GET_USER_INFO \tRESULT_ERROR \t- " + i2, C2735al.f10096a);
                    break;
                }
        }
    }
}
