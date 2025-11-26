package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.LinkedHashMap;

/* compiled from: AcceptDisclaimerTask.java */
/* renamed from: com.sec.chaton.d.a.f */
/* loaded from: classes.dex */
public class C1267f extends AbstractC1145a {

    /* renamed from: b */
    private String f4865b;

    public C1267f(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4865b = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        String strM11082t;
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("imei", C3171am.m11045a());
        if (TextUtils.isEmpty(C3171am.m11082t())) {
            strM11082t = TextUtils.isEmpty(C3171am.m11060d()) ? "GB" : C3171am.m11060d().toUpperCase();
        } else {
            strM11082t = C3171am.m11082t();
        }
        linkedHashMap.put("iso", strM11082t);
        if (this.f4865b != null && !this.f4865b.equals("FIRST")) {
            linkedHashMap.put("disclaimerUID", this.f4865b);
        }
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            C3250y.m11450b("Success to accept disclaimer", getClass().getSimpleName());
        } else if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000002", "0301", c0267d);
        }
    }
}
