package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1554c;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: SendSMSTask.java */
/* renamed from: com.sec.chaton.d.a.dm */
/* loaded from: classes.dex */
public class C1239dm extends AbstractC1145a {

    /* renamed from: b */
    private String f4794b;

    public C1239dm(Handler handler, C1580h c1580h, String str) {
        super(handler, c1580h);
        this.f4794b = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() == EnumC1587o.ERROR) {
            String str = c0267d.m11702l().get("exptime");
            if (str != null && str != null) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("Response exptime : " + str + " Method : " + this.f4794b, C1554c.class.getSimpleName());
                }
                if (this.f4794b.equals("SMS")) {
                    C3159aa.m10966a("sms_expire_time", str);
                    return;
                } else {
                    if (this.f4794b.equals("ACS")) {
                        C3159aa.m10966a("acs_expire_time", str);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000002", "0402", c0267d);
        }
    }
}
