package p010b.p014d.p016b;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import p010b.p014d.p018d.p019a.C0312b;
import p010b.p014d.p018d.p019a.C0313c;

/* compiled from: z_T4JInternalParseUtil.java */
/* renamed from: b.d.b.d */
/* loaded from: classes.dex */
public final class C0306d {

    /* renamed from: a */
    private static final Map<String, LinkedBlockingQueue<SimpleDateFormat>> f687a = new HashMap();

    /* renamed from: a */
    public static String m1034a(String str, C0313c c0313c) {
        try {
            if (c0313c.m1062d(str)) {
                return null;
            }
            return c0313c.m1061c(str);
        } catch (C0312b e) {
            return null;
        }
    }

    /* renamed from: b */
    public static int m1035b(String str, C0313c c0313c) {
        return m1033a(m1034a(str, c0313c));
    }

    /* renamed from: a */
    public static int m1033a(String str) {
        if (str == null || "".equals(str) || "null".equals(str)) {
            return -1;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
