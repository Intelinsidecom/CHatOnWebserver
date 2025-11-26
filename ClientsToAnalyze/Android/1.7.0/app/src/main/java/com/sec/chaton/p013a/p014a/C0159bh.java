package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1349x;
import java.util.LinkedHashMap;

/* compiled from: SetExtraInfoTask.java */
/* renamed from: com.sec.chaton.a.a.bh */
/* loaded from: classes.dex */
public class C0159bh extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private String f377a;

    public C0159bh(Handler handler, C0503j c0503j, String str, int i) {
        super(handler, c0503j);
        this.f377a = m688a(C1323bs.m4575a().getString("pref_extra_info", ""), str, i);
    }

    public C0159bh(Handler handler, C0503j c0503j, int i, String[] strArr, int[] iArr) {
        super(handler, c0503j);
        String string = C1323bs.m4575a().getString("pref_extra_info", "");
        for (int i2 = 0; i2 < i; i2++) {
            this.f377a = m688a(string, strArr[i2], iArr[i2]);
            string = this.f377a;
            C1341p.m4659c("SetExtraInfoTask:mExtraInfo  i= " + i2 + " key " + strArr[i2] + "value " + iArr[i2] + "mExtraInfo:" + this.f377a);
        }
    }

    /* renamed from: b */
    public static boolean m690b() {
        return C1323bs.m4575a().getBoolean("pref_extra_info_need_update", false);
    }

    /* renamed from: f */
    public static String m693f() {
        return C1323bs.m4575a().getString("pref_extra_info", "");
    }

    /* renamed from: a */
    public static boolean m689a(String str) {
        return str != null && str.contains("voip=1");
    }

    /* renamed from: b */
    public static boolean m691b(String str) {
        return str != null && str.contains("call=1");
    }

    /* renamed from: c */
    public static boolean m692c(String str) {
        return str != null && str.contains("vcall=1");
    }

    /* renamed from: g */
    public static boolean m694g() {
        return C1323bs.m4575a().getInt("enable_voice_call", 0) == 1;
    }

    /* renamed from: h */
    public static boolean m695h() {
        return C1323bs.m4575a().getInt("enable_video_call", 0) == 1;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        C1323bs.m4576a("pref_extra_info_need_update", (Boolean) true);
        C1349x c1349x = new C1349x();
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        linkedHashMap.put("einfo", this.f377a);
        String strM4714a = c1349x.m4714a((Object) linkedHashMap);
        C1341p.m4662e(strM4714a, getClass().getSimpleName());
        return strM4714a;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
            C1341p.m4659c("SetExtraInfoTask:afterRequest" + c0259g.m928b());
            C1323bs.m4579a("pref_extra_info", this.f377a);
            C1323bs.m4575a().edit().remove("pref_extra_info_need_update").commit();
        }
        C1341p.m4659c("SetExtraInfoTask:afterRequest" + c0259g.m928b());
        C1341p.m4659c("SetExtraInfoTask:afterRequest" + C1323bs.m4575a().getString("pref_extra_info", ""));
    }

    /* renamed from: a */
    private String m688a(String str, String str2, int i) {
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
