package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: SetChatProfileTitleTask.java */
/* renamed from: com.sec.chaton.d.a.dq */
/* loaded from: classes.dex */
public class C1243dq extends AbstractC1145a {
    public C1243dq(Handler handler, C1580h c1580h) {
        super(handler, c1580h);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3250y.m11450b("[Before request]", getClass().getSimpleName());
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        C3250y.m11450b("[After request]", getClass().getSimpleName());
        if (c0267d.m1351b() != EnumC1587o.SUCCESS && CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000006", "1007", c0267d);
        }
    }
}
