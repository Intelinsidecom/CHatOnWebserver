package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.C1793y;
import java.util.LinkedHashMap;

/* compiled from: SetExtraInfoTask.java */
/* renamed from: com.sec.chaton.d.a.br */
/* loaded from: classes.dex */
public class C0577br extends AbstractRunnableC0532a {

    /* renamed from: d */
    private String f2304d;

    public C0577br(Handler handler, C0798h c0798h, String str, int i) {
        super(handler, c0798h);
        this.f2304d = m2763a(C1789u.m6075a().getString("pref_extra_info", ""), str, i);
    }

    public C0577br(Handler handler, C0798h c0798h, int i, String[] strArr, int[] iArr) {
        super(handler, c0798h);
        String string = C1789u.m6075a().getString("pref_extra_info", "");
        for (int i2 = 0; i2 < i; i2++) {
            this.f2304d = m2763a(string, strArr[i2], iArr[i2]);
            string = this.f2304d;
            C1786r.m6064d("SetExtraInfoTask:mExtraInfo  i= " + i2 + " key " + strArr[i2] + "value " + iArr[i2] + "mExtraInfo:" + this.f2304d);
        }
    }

    /* renamed from: f */
    public static boolean m2767f() {
        return C1789u.m6075a().getBoolean("pref_extra_info_need_update", false);
    }

    /* renamed from: g */
    public static String m2768g() {
        return C1789u.m6075a().getString("pref_extra_info", "");
    }

    /* renamed from: a */
    public static boolean m2764a(String str) {
        return str != null && str.contains("voip=1");
    }

    /* renamed from: b */
    public static boolean m2765b(String str) {
        return str != null && str.contains("call=1");
    }

    /* renamed from: c */
    public static boolean m2766c(String str) {
        return str != null && str.contains("vcall=1");
    }

    /* renamed from: h */
    public static boolean m2769h() {
        return C1789u.m6075a().getInt("enable_voice_call", 0) == 1;
    }

    /* renamed from: i */
    public static boolean m2770i() {
        return C1789u.m6075a().getInt("enable_video_call", 0) == 1;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1789u.m6076a("pref_extra_info_need_update", (Boolean) true);
        C1793y c1793y = new C1793y();
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        linkedHashMap.put("einfo", this.f2304d);
        String strM6112a = c1793y.m6112a((Object) linkedHashMap);
        C1786r.m6066e(strM6112a, getClass().getSimpleName());
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
            C1786r.m6064d("SetExtraInfoTask:afterRequest" + c0101b.m665b());
            C1789u.m6079a("pref_extra_info", this.f2304d);
            C1789u.m6075a().edit().remove("pref_extra_info_need_update").commit();
        }
        C1786r.m6064d("SetExtraInfoTask:afterRequest" + c0101b.m665b());
        C1786r.m6064d("SetExtraInfoTask:afterRequest" + C1789u.m6075a().getString("pref_extra_info", ""));
    }

    /* renamed from: a */
    private String m2763a(String str, String str2, int i) {
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
