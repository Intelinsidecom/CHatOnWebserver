package com.sec.chaton.settings.tellfriends;

import com.facebook.model.GraphCustomUser;
import com.facebook.model.GraphObjectList;
import com.sec.chaton.p020c.C0817b;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2787c;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: SnsHelperFacebook.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ak */
/* loaded from: classes.dex */
class C2734ak implements InterfaceC2787c {

    /* renamed from: a */
    final /* synthetic */ C2733aj f10095a;

    C2734ak(C2733aj c2733aj) {
        this.f10095a = c2733aj;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2787c
    /* renamed from: a */
    public void mo9799a(int i, int i2, Object obj) {
        switch (i) {
            case 0:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_GET_FRIENDS \tRESULT_OK \t- resultCode : " + i2, C2733aj.f10088a);
                    if (obj instanceof GraphObjectList) {
                        ArrayList<C2732ai> arrayList = new ArrayList<>();
                        for (GraphCustomUser graphCustomUser : (GraphObjectList) obj) {
                            arrayList.add(new C2732ai(graphCustomUser.getId(), graphCustomUser.getName(), C0817b.f3136h + graphCustomUser.getId() + "/picture", graphCustomUser.getInstalled().booleanValue()));
                        }
                        this.f10095a.f10091d.mo5655a(arrayList);
                        break;
                    }
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_GET_FRIENDS \tRESULT_CANCELED \t- resultCode : " + i2, C2733aj.f10088a);
                    this.f10095a.f10091d.mo5653a();
                    break;
                } else {
                    C3250y.m11442a("REQUEST_GET_FRIENDS \tRESULT_ERROR \t- resultCode : " + i2, C2733aj.f10088a);
                    this.f10095a.f10091d.mo5654a(i2);
                    break;
                }
                break;
            case 1:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_POST_TO_FRIEND \tRESULT_OK \t- resultCode : " + i2, C2733aj.f10088a);
                    this.f10095a.f10092e.mo9779a();
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_POST_TO_FRIEND \tRESULT_CANCELED \t- resultCode : " + i2, C2733aj.f10088a);
                    this.f10095a.f10092e.mo9781b();
                    break;
                } else {
                    C3250y.m11442a("REQUEST_POST_TO_FRIEND \tRESULT_ERROR \t- resultCode : " + i2, C2733aj.f10088a);
                    this.f10095a.f10092e.mo9780a(i2);
                    break;
                }
            case 2:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_LOGOUT \tRESULT_OK \t- resultCode : " + i2, C2733aj.f10088a);
                    this.f10095a.f10093f.onComplete();
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_LOGOUT \tRESULT_CANCELED \t- resultCode : " + i2, C2733aj.f10088a);
                    this.f10095a.f10093f.onCancelled();
                    break;
                } else {
                    C3250y.m11442a("REQUEST_LOGOUT \tRESULT_ERROR \t- resultCode : " + i2, C2733aj.f10088a);
                    this.f10095a.f10093f.onError();
                    break;
                }
            case 3:
                if (i2 == -1) {
                    C3250y.m11450b("REQUEST_LOGIN \tRESULT_OK \t- " + i2, C2733aj.f10088a);
                    this.f10095a.f10094g.onComplete();
                    break;
                } else if (i2 == 0) {
                    C3250y.m11450b("REQUEST_LOGIN \tRESULT_CANCELED \t- " + i2, C2733aj.f10088a);
                    this.f10095a.f10094g.onCancelled();
                    break;
                } else {
                    C3250y.m11442a("REQUEST_LOGIN \tRESULT_ERROR \t- resultCode : " + i2, C2733aj.f10088a);
                    this.f10095a.f10094g.onError(i2);
                    break;
                }
        }
    }
}
