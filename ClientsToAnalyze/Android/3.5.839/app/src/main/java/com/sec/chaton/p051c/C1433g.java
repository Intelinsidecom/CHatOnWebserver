package com.sec.chaton.p051c;

import android.text.TextUtils;
import com.sec.chaton.util.C4822an;

/* compiled from: NetworkConstant.java */
/* renamed from: com.sec.chaton.c.g */
/* loaded from: classes.dex */
public final class C1433g {

    /* renamed from: a */
    private static String f5121a;

    /* renamed from: a */
    public static void m7527a(String str, Integer num, Integer num2, Integer num3, Integer num4) {
        f5121a = str;
        C1428b.f5097c.put("XXX", Integer.valueOf(num.intValue() * 1000));
        C1428b.f5098d.put("XXX", Integer.valueOf(num2.intValue() * 1000));
        C1428b.f5099e.put("XXX", Integer.valueOf(num3.intValue() * 1000));
        C1428b.f5100f.put("XXX", Integer.valueOf(num4.intValue() * 1000));
    }

    /* renamed from: a */
    public static void m7526a() {
        f5121a = "";
    }

    /* renamed from: b */
    public static int m7528b() {
        if (!TextUtils.isEmpty(f5121a)) {
            return C1428b.f5097c.get("XXX").intValue();
        }
        if (C1428b.f5097c.containsKey(C4822an.m18241i())) {
            return C1428b.f5097c.get(C4822an.m18241i()).intValue();
        }
        return 20000;
    }

    /* renamed from: c */
    public static int m7529c() {
        if (!TextUtils.isEmpty(f5121a)) {
            return C1428b.f5098d.get("XXX").intValue();
        }
        if (C1428b.f5098d.containsKey(C4822an.m18241i())) {
            return C1428b.f5098d.get(C4822an.m18241i()).intValue();
        }
        return 30000;
    }

    /* renamed from: d */
    public static int m7530d() {
        if (!TextUtils.isEmpty(f5121a)) {
            return C1428b.f5099e.get("XXX").intValue();
        }
        if (C1428b.f5099e.containsKey(C4822an.m18241i())) {
            return C1428b.f5099e.get(C4822an.m18241i()).intValue();
        }
        return 20000;
    }

    /* renamed from: e */
    public static int m7531e() {
        if (!TextUtils.isEmpty(f5121a)) {
            return C1428b.f5100f.get("XXX").intValue();
        }
        if (C1428b.f5100f.containsKey(C4822an.m18241i())) {
            return C1428b.f5100f.get(C4822an.m18241i()).intValue();
        }
        return 40000;
    }
}
