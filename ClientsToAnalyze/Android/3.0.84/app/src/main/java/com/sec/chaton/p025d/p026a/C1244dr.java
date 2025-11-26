package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.C3250y;
import java.util.LinkedHashMap;

/* compiled from: SetExtraInfoTask.java */
/* renamed from: com.sec.chaton.d.a.dr */
/* loaded from: classes.dex */
public class C1244dr extends AbstractC1145a {

    /* renamed from: b */
    private String f4807b;

    public C1244dr(Handler handler, C1580h c1580h, String str, int i) {
        super(handler, c1580h);
        this.f4807b = m5561a(C3159aa.m10962a().m10979a("pref_extra_info", ""), str, i);
    }

    /* renamed from: a */
    public static boolean m5562a(String str) {
        return str != null && str.contains("voip=1");
    }

    /* renamed from: b */
    public static boolean m5563b(String str) {
        return str != null && str.contains("call=1");
    }

    /* renamed from: c */
    public static boolean m5564c(String str) {
        return str != null && str.contains("vcall=1");
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        C3159aa.m10963a("pref_extra_info_need_update", (Boolean) true);
        C3164af c3164af = new C3164af();
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        linkedHashMap.put("einfo", this.f4807b);
        String strM11026a = c3164af.m11026a((Object) linkedHashMap);
        C3250y.m11456e(strM11026a, getClass().getSimpleName());
        return strM11026a;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
            C3250y.m11454d("SetExtraInfoTask:afterRequest" + c0267d.m1351b());
            C3159aa.m10966a("pref_extra_info", this.f4807b);
            C3159aa.m10962a().m10981a("pref_extra_info_need_update");
        }
        C3250y.m11454d("SetExtraInfoTask:afterRequest" + c0267d.m1351b());
        C3250y.m11454d("SetExtraInfoTask:afterRequest" + C3159aa.m10962a().m10979a("pref_extra_info", ""));
    }

    /* renamed from: a */
    private String m5561a(String str, String str2, int i) {
        if (str2 != null) {
            StringBuilder sb = new StringBuilder();
            String[] strArrSplit = str.split("\n");
            boolean z = false;
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                String[] strArrSplit2 = strArrSplit[i2].split("=");
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                if (str2.equals(strArrSplit2[0])) {
                    z = true;
                    sb.append(str2).append("=").append(i);
                } else {
                    sb.append(strArrSplit[i2]);
                }
            }
            if (!z) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(str2).append("=").append(i);
            }
            return sb.toString();
        }
        return str;
    }
}
