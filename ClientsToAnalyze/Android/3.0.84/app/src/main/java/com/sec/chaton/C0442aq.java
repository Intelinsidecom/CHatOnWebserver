package com.sec.chaton;

import android.text.TextUtils;
import com.sec.chaton.account.C0423i;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3204bs;
import java.io.UnsupportedEncodingException;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.aq */
/* loaded from: classes.dex */
class C0442aq implements InterfaceC3204bs {

    /* renamed from: a */
    final /* synthetic */ TabActivity f1509a;

    C0442aq(TabActivity tabActivity) {
        this.f1509a = tabActivity;
    }

    @Override // com.sec.chaton.util.InterfaceC3204bs
    /* renamed from: a */
    public boolean mo3063a() throws UnsupportedEncodingException {
        C3250y.m11450b("mGetAllBuddiesTask run [UID] " + C3159aa.m10962a().m10987b("uid") + " [MSISDN] " + C3159aa.m10962a().m10979a("msisdn", ""), TabActivity.f732f);
        if (C3159aa.m10962a().m10987b("uid")) {
            if (!TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", ""))) {
                C0423i.m3051c("getAllBuddies");
            } else {
                new C1330h(null).m5717a();
            }
            new C1330h(null).m5736c();
            new C1330h(null).m5752g();
        }
        C3250y.m11450b("mGetAllBuddiesTask finish", TabActivity.f732f);
        return true;
    }
}
