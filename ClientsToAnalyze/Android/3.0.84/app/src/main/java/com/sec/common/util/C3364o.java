package com.sec.common.util;

import org.p072a.p073a.p074a.InterfaceC3711f;
import org.p072a.p073a.p074a.p075a.C3706p;

/* compiled from: StringUtils.java */
/* renamed from: com.sec.common.util.o */
/* loaded from: classes.dex */
public class C3364o {

    /* renamed from: a */
    private static InterfaceC3711f<StringBuilder> f12116a = new C3706p(new C3366q());

    /* renamed from: a */
    public static String m11849a(Object... objArr) throws Throwable {
        StringBuilder sbMo13370c;
        StringBuilder sb = null;
        try {
            sbMo13370c = f12116a.mo13370c();
        } catch (Exception e) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            for (Object obj : objArr) {
                try {
                    sbMo13370c.append(obj.toString());
                } catch (NullPointerException e2) {
                    sbMo13370c.append("null");
                }
            }
            String string = sbMo13370c.toString();
            if (sbMo13370c != null) {
                try {
                    f12116a.mo13369a(sbMo13370c);
                } catch (Exception e3) {
                }
            }
            return string;
        } catch (Exception e4) {
            sb = sbMo13370c;
            if (sb == null) {
                return "";
            }
            try {
                f12116a.mo13369a(sb);
                return "";
            } catch (Exception e5) {
                return "";
            }
        } catch (Throwable th2) {
            sb = sbMo13370c;
            th = th2;
            if (sb != null) {
                try {
                    f12116a.mo13369a(sb);
                } catch (Exception e6) {
                }
            }
            throw th;
        }
    }
}
