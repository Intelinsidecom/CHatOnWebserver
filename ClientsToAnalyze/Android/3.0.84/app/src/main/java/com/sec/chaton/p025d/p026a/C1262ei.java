package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p016a.p017a.C0276m;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.LinkedHashMap;

/* compiled from: UploadProfileTask2.java */
/* renamed from: com.sec.chaton.d.a.ei */
/* loaded from: classes.dex */
public class C1262ei extends AbstractC1145a {

    /* renamed from: b */
    private C0276m f4850b;

    /* renamed from: c */
    private String f4851c;

    /* renamed from: e */
    private String f4852e;

    public C1262ei(Handler handler, C1580h c1580h, C0276m c0276m, String str) {
        super(handler, c1580h);
        this.f4850b = c0276m;
        this.f4852e = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.f4850b.m1367a() != null) {
            linkedHashMap.put("name", this.f4850b.m1367a());
        }
        if (this.f4850b.m1369b() != null) {
            linkedHashMap.put("status", this.f4850b.m1369b());
        }
        if (this.f4850b.m1371c() != null) {
            this.f4851c = this.f4850b.m1371c();
            if ("FULL".equals(this.f4852e)) {
                linkedHashMap.put("birthday", this.f4850b.m1371c());
            } else if ("SHORT".equals(this.f4852e)) {
                linkedHashMap.put("birthday", this.f4850b.m1371c().substring(5, 10));
            } else if ("DONT".equals(this.f4852e) || "FULL_HIDE".equals(this.f4852e) || "SHORT_HIDE".equals(this.f4852e)) {
                linkedHashMap.put("birthday", "0000-12-31");
            } else {
                C3250y.m11450b("Unknown birthday option", getClass().getSimpleName());
            }
        }
        if (this.f4850b.m1373d() != null) {
            linkedHashMap.put("email", this.f4850b.m1373d());
        }
        if (this.f4850b.m1374e() != null) {
            linkedHashMap.put("samsungemail", this.f4850b.m1374e());
        }
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            if (this.f4850b.m1367a() != null) {
                C3159aa.m10966a("Push Name", this.f4850b.m1367a());
            }
            if (this.f4850b.m1369b() != null) {
                C3159aa.m10966a("status_message", this.f4850b.m1369b());
            }
            if (this.f4850b.m1371c() != null) {
                C3159aa.m10966a("birthday", this.f4851c);
                C3159aa.m10966a("birthday_type", this.f4852e);
                if ("FULL".equals(this.f4852e) || "SHORT".equals(this.f4852e)) {
                    C3159aa.m10963a("birthday_show", (Boolean) true);
                } else {
                    C3159aa.m10963a("birthday_show", (Boolean) false);
                }
                if ("FULL".equals(this.f4852e) || "FULL_HIDE".equals(this.f4852e)) {
                    C3159aa.m10963a("birthday_year_show", (Boolean) true);
                } else {
                    C3159aa.m10963a("birthday_year_show", (Boolean) false);
                }
            }
            if (this.f4850b.m1373d() != null) {
                C3159aa.m10966a("email", this.f4850b.m1373d());
            }
            if (this.f4850b.m1374e() != null) {
                C3159aa.m10966a("samsung_email", this.f4850b.m1374e());
                return;
            }
            return;
        }
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000004", "0001", c0267d);
        }
    }
}
