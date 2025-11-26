package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import org.apache.http.NameValuePair;

/* compiled from: GetVersionTask.java */
/* renamed from: com.sec.chaton.d.a.cq */
/* loaded from: classes.dex */
public class C1216cq extends AbstractC1145a {
    public C1216cq(Handler handler, C1580h c1580h) {
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
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            for (NameValuePair nameValuePair : c0267d.m1353d().m6706f()) {
                if (nameValuePair.getName().equals("regid")) {
                    String value = nameValuePair.getValue();
                    C3250y.m11450b("Save get version push registration id to pref: " + value, C1216cq.class.getSimpleName());
                    C3159aa.m10962a().m10986b("get_version_push_reg_id", value);
                }
            }
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000002", "0001", c0267d);
        }
    }
}
