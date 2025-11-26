package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.InstallSoundEntry;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: InstallSoundTask.java */
/* renamed from: com.sec.chaton.d.a.cy */
/* loaded from: classes.dex */
public class C1224cy extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4739b = C1198bz.class.getSimpleName();

    public C1224cy(Handler handler, C1580h c1580h, EnumC1172b enumC1172b) {
        super(handler, c1580h, enumC1172b);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000011", "4002", c0267d);
        }
        if (c0267d.m1351b() == EnumC1587o.SUCCESS && ((InstallSoundEntry) c0267d.m1354e()) == null && C3250y.f11737e) {
            C3250y.m11442a("Http result object is null.", f4739b);
        }
    }
}
