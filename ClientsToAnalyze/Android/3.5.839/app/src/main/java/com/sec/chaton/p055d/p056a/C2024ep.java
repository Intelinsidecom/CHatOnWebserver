package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import java.util.LinkedHashMap;

/* compiled from: SetExtraInfoTask.java */
/* renamed from: com.sec.chaton.d.a.ep */
/* loaded from: classes.dex */
public class C2024ep extends AbstractC1900a {

    /* renamed from: b */
    private String f7422b;

    public C2024ep(C2454e c2454e, String str, int i) {
        super(c2454e);
        this.f7422b = m9163a(C4809aa.m18104a().m18121a("pref_extra_info", ""), str, i);
    }

    /* renamed from: a */
    public static boolean m9164a(String str) {
        return str != null && str.contains("voip=1");
    }

    /* renamed from: b */
    public static boolean m9165b(String str) {
        return str != null && str.contains("call=1");
    }

    /* renamed from: c */
    public static boolean m9166c(String str) {
        return str != null && str.contains("vcall=1");
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4809aa.m18105a("pref_extra_info_need_update", (Boolean) true);
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        linkedHashMap.put("einfo", this.f7422b);
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            C4904y.m18644d("SetExtraInfoTask:afterRequest" + c0778b.m3107b());
            C4809aa.m18108a("pref_extra_info", this.f7422b);
            C4809aa.m18104a().m18123a("pref_extra_info_need_update");
        }
        C4904y.m18644d("SetExtraInfoTask:afterRequest" + c0778b.m3107b());
        C4904y.m18644d("SetExtraInfoTask:afterRequest" + C4809aa.m18104a().m18121a("pref_extra_info", ""));
    }

    /* renamed from: a */
    private String m9163a(String str, String str2, int i) {
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
