package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import java.util.LinkedHashMap;

/* compiled from: DeleteMappingAccountTask.java */
/* renamed from: com.sec.chaton.d.a.al */
/* loaded from: classes.dex */
public class C1157al extends AbstractC1145a {

    /* renamed from: b */
    String f4595b;

    public C1157al(Handler handler, C1580h c1580h, String str, EnumC1172b enumC1172b) {
        super(handler, c1580h, enumC1172b);
        this.f4595b = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("email", C3159aa.m10962a().m10979a("samsung_account_email", ""));
        linkedHashMap.put("chatonid", this.f4595b);
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            if (C3250y.f11735c) {
                C3250y.m11453c("Success, Device ID : " + this.f4595b, getClass().getSimpleName());
            }
        } else if (C3250y.f11735c) {
            C3250y.m11453c("Fail, Device ID : " + this.f4595b, getClass().getSimpleName());
        }
    }
}
