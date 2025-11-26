package com.sec.chaton.p025d;

import android.os.Handler;
import com.sec.chaton.p025d.p026a.C1219ct;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.EnumC3219cg;
import java.util.ArrayList;

/* compiled from: IgnoreControl.java */
/* renamed from: com.sec.chaton.d.n */
/* loaded from: classes.dex */
public class C1336n {

    /* renamed from: a */
    private Handler f5034a;

    public C1336n(Handler handler) {
        this.f5034a = handler;
    }

    /* renamed from: a */
    public void m5791a(String str, ArrayList<String> arrayList) {
        C1595w.m6742a().m6745b().m6723a(new C1219ct(this.f5034a, new C1582j(EnumC3219cg.CONTACT, "/buddyrecommendee/ignorelist").m6710a(EnumC1583k.POST).m6709a(100).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6708a(), str, arrayList));
    }

    /* renamed from: a */
    public void m5792a(ArrayList<String> arrayList) {
        if (arrayList.size() > 0) {
            C1595w.m6742a().m6745b().m6723a(new C1219ct(this.f5034a, new C1582j(EnumC3219cg.CONTACT, "/buddyrecommendee/ignorelist").m6710a(EnumC1583k.POST).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6709a(103).m6708a(), "true", arrayList));
        }
    }
}
