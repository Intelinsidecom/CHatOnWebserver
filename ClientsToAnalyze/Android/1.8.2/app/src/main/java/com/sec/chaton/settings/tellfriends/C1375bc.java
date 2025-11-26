package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.facebook.InterfaceC0736q;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SnsHelperFacebook.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bc */
/* loaded from: classes.dex */
class C1375bc implements InterfaceC0736q {

    /* renamed from: a */
    final /* synthetic */ C1374bb f5214a;

    C1375bc(C1374bb c1374bb) {
        this.f5214a = c1374bb;
    }

    @Override // com.sec.chaton.facebook.InterfaceC0736q
    /* renamed from: a */
    public void mo3203a(int i, int i2, String str) {
        JSONArray jSONArray;
        int i3;
        switch (i) {
            case 0:
                if (i2 == -1) {
                    C1786r.m6061b("REQUEST_GET_FRIENDS \tRESULT_OK \t- resultCode : " + i2, C1374bb.f5207a);
                    ArrayList arrayList = new ArrayList();
                    try {
                        jSONArray = new JSONArray(str);
                        i3 = 0;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    while (true) {
                        int i4 = i3;
                        if (i4 < jSONArray.length()) {
                            arrayList.add(C1374bb.m5115b((JSONObject) jSONArray.get(i4)));
                            i3 = i4 + 1;
                        } else {
                            this.f5214a.f5210d.mo5087a(arrayList);
                            break;
                        }
                    }
                } else if (i2 == 0) {
                    C1786r.m6061b("REQUEST_GET_FRIENDS \tRESULT_CANCELED \t- resultCode : " + i2, C1374bb.f5207a);
                    this.f5214a.f5210d.mo5086a();
                    break;
                } else {
                    C1786r.m6054a("REQUEST_GET_FRIENDS \tRESULT_ERROR \t- resultCode : " + i2, C1374bb.f5207a);
                    this.f5214a.f5210d.mo5088b();
                    break;
                }
            case 1:
                if (i2 == -1) {
                    C1786r.m6061b("REQUEST_POST_TO_FRIEND \tRESULT_OK \t- resultCode : " + i2, C1374bb.f5207a);
                    this.f5214a.f5211e.mo5109a();
                    break;
                } else if (i2 == 0) {
                    C1786r.m6061b("REQUEST_POST_TO_FRIEND \tRESULT_CANCELED \t- resultCode : " + i2, C1374bb.f5207a);
                    this.f5214a.f5211e.mo5110b();
                    break;
                } else {
                    C1786r.m6054a("REQUEST_POST_TO_FRIEND \tRESULT_ERROR \t- resultCode : " + i2, C1374bb.f5207a);
                    this.f5214a.f5211e.mo5111c();
                    break;
                }
            case 2:
                if (i2 == -1) {
                    C1786r.m6061b("REQUEST_LOGOUT \tRESULT_OK \t- resultCode : " + i2, C1374bb.f5207a);
                    this.f5214a.f5212f.mo5106a();
                    break;
                } else if (i2 == 0) {
                    C1786r.m6061b("REQUEST_LOGOUT \tRESULT_CANCELED \t- resultCode : " + i2, C1374bb.f5207a);
                    this.f5214a.f5212f.mo5107b();
                    break;
                } else {
                    C1786r.m6054a("REQUEST_LOGOUT \tRESULT_ERROR \t- resultCode : " + i2, C1374bb.f5207a);
                    this.f5214a.f5212f.mo5108c();
                    break;
                }
            case 3:
                if (i2 == -1) {
                    C1786r.m6061b("REQUEST_LOGIN \tRESULT_OK \t- " + i2, C1374bb.f5207a);
                    this.f5214a.f5213g.mo5103a();
                    break;
                } else if (i2 == 0) {
                    C1786r.m6061b("REQUEST_LOGIN \tRESULT_CANCELED \t- " + i2, C1374bb.f5207a);
                    this.f5214a.f5213g.mo5104b();
                    break;
                } else {
                    C1786r.m6054a("REQUEST_LOGIN \tRESULT_ERROR \t- resultCode : " + i2, C1374bb.f5207a);
                    this.f5214a.f5213g.mo5105c();
                    break;
                }
        }
    }

    @Override // com.sec.chaton.facebook.InterfaceC0736q
    /* renamed from: a */
    public void mo3204a(int i, boolean z) {
    }
}
