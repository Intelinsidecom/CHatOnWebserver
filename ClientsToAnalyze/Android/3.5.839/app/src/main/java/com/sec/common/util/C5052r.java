package com.sec.common.util;

import org.p138a.p139a.p140a.InterfaceC5223f;
import org.p138a.p139a.p140a.p141a.C5218p;

/* compiled from: StringUtils.java */
/* renamed from: com.sec.common.util.r */
/* loaded from: classes.dex */
public class C5052r {

    /* renamed from: a */
    private static InterfaceC5223f<StringBuilder> f18398a = new C5218p(new C5054t());

    /* renamed from: a */
    public static String m19199a(Object... objArr) throws Throwable {
        StringBuilder sb = null;
        try {
            StringBuilder sbMo19898c = f18398a.mo19898c();
            try {
                for (Object obj : objArr) {
                    try {
                        sbMo19898c.append(obj.toString());
                    } catch (NullPointerException e) {
                        sbMo19898c.append("null");
                    }
                }
                String string = sbMo19898c.toString();
                if (sbMo19898c != null) {
                    try {
                        f18398a.mo19897a(sbMo19898c);
                    } catch (Exception e2) {
                    }
                }
                return string;
            } catch (Exception e3) {
                sb = sbMo19898c;
                if (sb == null) {
                    return "";
                }
                try {
                    f18398a.mo19897a(sb);
                    return "";
                } catch (Exception e4) {
                    return "";
                }
            } catch (Throwable th) {
                sb = sbMo19898c;
                th = th;
                if (sb != null) {
                    try {
                        f18398a.mo19897a(sb);
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
