package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1554c;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3218cf;
import com.sec.chaton.util.EnumC3219cg;
import com.sec.common.CommonApplication;
import java.util.LinkedHashMap;

/* compiled from: UploadProfileImageHistoryTask.java */
/* renamed from: com.sec.chaton.d.a.eh */
/* loaded from: classes.dex */
public class C1261eh extends AbstractC1145a {

    /* renamed from: b */
    private String f4847b;

    /* renamed from: c */
    private String f4848c;

    /* renamed from: e */
    private String f4849e;

    public C1261eh(Handler handler, C1580h c1580h, String str, String str2) {
        super(handler, c1580h);
        this.f4847b = str;
        this.f4848c = str2;
        if (C3159aa.m10962a().m10977a("is_file_server_primary ", (Boolean) true).booleanValue()) {
            this.f4849e = C1554c.m6590a(EnumC3218cf.PRIMARY, EnumC3219cg.FILE);
        } else {
            this.f4849e = C1554c.m6590a(EnumC3218cf.SECONDARY, EnumC3219cg.FILE);
        }
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.f4847b != null) {
            linkedHashMap.put("profileimageurl", this.f4847b);
        }
        if (this.f4848c != null) {
            linkedHashMap.put("contenttype", this.f4848c);
        }
        if (this.f4849e != null) {
            linkedHashMap.put("hosturl", this.f4849e);
        }
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if ((!c0267d.m11704n() || c0267d.m1354e() == null || c0267d.m1351b() == EnumC1587o.ERROR) && CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000004", "0101", c0267d);
        }
    }
}
