package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.LinkedHashMap;

/* compiled from: UpdateMSISDNTask.java */
/* renamed from: com.sec.chaton.d.a.ed */
/* loaded from: classes.dex */
public class C1257ed extends AbstractC1145a {

    /* renamed from: b */
    private String f4825b;

    /* renamed from: c */
    private String f4826c;

    /* renamed from: e */
    private String f4827e;

    public C1257ed(Handler handler, C1580h c1580h, String str, String str2, String str3) {
        super(handler, c1580h);
        this.f4825b = str;
        this.f4826c = str2;
        this.f4827e = str3;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("msisdn", this.f4825b);
        linkedHashMap.put("token", this.f4826c);
        linkedHashMap.put("authnum", this.f4827e);
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if ((!c0267d.m11704n() || c0267d.m1354e() == null || c0267d.m1351b() == EnumC1587o.ERROR) && CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000002", "0105", c0267d);
        }
    }
}
