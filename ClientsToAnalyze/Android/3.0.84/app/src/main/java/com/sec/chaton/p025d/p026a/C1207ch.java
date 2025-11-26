package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.common.CommonApplication;

/* compiled from: GetSMSAuthTokenTask.java */
/* renamed from: com.sec.chaton.d.a.ch */
/* loaded from: classes.dex */
public class C1207ch extends AbstractC1145a {
    public C1207ch(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if ((!c0267d.m11704n() || c0267d.m1354e() == null || c0267d.m1351b() == EnumC1587o.ERROR) && CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000002", "0401", c0267d);
        }
    }
}
