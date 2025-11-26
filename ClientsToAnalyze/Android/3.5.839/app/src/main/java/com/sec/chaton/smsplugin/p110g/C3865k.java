package com.sec.chaton.smsplugin.p110g;

import android.content.Context;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p108e.C3849b;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.C5077a;
import com.sec.google.android.p134a.p135a.C5086i;
import com.sec.google.android.p134a.p135a.C5094q;
import org.p146b.p147a.p149b.InterfaceC5249i;
import org.p146b.p147a.p149b.InterfaceC5252l;
import org.p146b.p147a.p149b.InterfaceC5254n;
import org.p146b.p147a.p149b.InterfaceC5256p;
import org.p146b.p147a.p149b.InterfaceC5257q;

/* compiled from: MediaModelFactory.java */
/* renamed from: com.sec.chaton.smsplugin.g.k */
/* loaded from: classes.dex */
public class C3865k {
    /* renamed from: a */
    public static AbstractC3863i m14829a(Context context, InterfaceC5249i interfaceC5249i, C3862h c3862h, C5086i c5086i) {
        String tagName = interfaceC5249i.getTagName();
        String strMo14538a = interfaceC5249i.mo14538a();
        C5094q c5094qM14830a = m14830a(c5086i, strMo14538a);
        return interfaceC5249i instanceof InterfaceC5254n ? m14828a(context, tagName, strMo14538a, (InterfaceC5254n) interfaceC5249i, c3862h, c5094qM14830a) : m14827a(context, tagName, strMo14538a, interfaceC5249i, c5094qM14830a, (C3868n) null);
    }

    /* renamed from: a */
    private static C5094q m14830a(C5086i c5086i, String str) {
        C5094q c5094qM19335c = null;
        if (str != null) {
            String strM14831a = m14831a(str);
            if (strM14831a.startsWith("cid:")) {
                c5094qM19335c = c5086i.m19329a("<" + strM14831a.substring("cid:".length()) + ">");
            } else {
                c5094qM19335c = c5086i.m19335c(strM14831a);
                if (c5094qM19335c == null && (c5094qM19335c = c5086i.m19336d(strM14831a)) == null) {
                    c5094qM19335c = c5086i.m19334b(strM14831a);
                }
            }
        }
        if (c5094qM19335c != null) {
            return c5094qM19335c;
        }
        throw new IllegalArgumentException("No part found for the model.");
    }

    /* renamed from: a */
    private static String m14831a(String str) {
        return str.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&quot;", "\"").replaceAll("&apos;", "'").replaceAll("&amp;", "&");
    }

    /* renamed from: a */
    private static AbstractC3863i m14828a(Context context, String str, String str2, InterfaceC5254n interfaceC5254n, C3862h c3862h, C5094q c5094q) {
        String str3;
        InterfaceC5252l interfaceC5252lK = interfaceC5254n.mo14605k();
        if (interfaceC5252lK != null) {
            C3868n c3868nM14787a = c3862h.m14787a(interfaceC5252lK.mo14535j());
            if (c3868nM14787a != null) {
                return m14827a(context, str, str2, interfaceC5254n, c5094q, c3868nM14787a);
            }
        } else {
            if (str.equals("text")) {
                str3 = "Text";
            } else {
                str3 = "Image";
            }
            C3868n c3868nM14787a2 = c3862h.m14787a(str3);
            if (c3868nM14787a2 != null) {
                return m14827a(context, str, str2, interfaceC5254n, c5094q, c3868nM14787a2);
            }
        }
        throw new IllegalArgumentException("Region not found or bad region ID.");
    }

    /* renamed from: a */
    private static AbstractC3863i m14826a(Context context, C3849b c3849b, C3868n c3868n) {
        return c3849b != null ? new C3872r(context, "text/plain", (String) null, 0, c3849b, c3868n) : new C3872r(context, "text/plain", null, c3868n);
    }

    /* renamed from: a */
    private static AbstractC3863i m14827a(Context context, String str, String str2, InterfaceC5249i interfaceC5249i, C5094q c5094q, C3868n c3868n) {
        AbstractC3863i abstractC3863iM14826a;
        int iMo14611c;
        InterfaceC5257q interfaceC5257qH;
        InterfaceC5256p interfaceC5256pMo14614a;
        InterfaceC5256p interfaceC5256pMo14614a2;
        AbstractC3863i abstractC3863iM14826a2;
        byte[] bArrM19394g = c5094q.m19394g();
        if (bArrM19394g == null) {
            throw new IllegalArgumentException("Content-Type of the part may not be null.");
        }
        String str3 = new String(bArrM19394g);
        if (C5077a.m19294g(str3)) {
            C3849b c3849b = new C3849b(str3, c5094q.m19383b(), c5094q.m19382a());
            if (str.equals("text")) {
                abstractC3863iM14826a2 = new C3872r(context, str3, str2, c5094q.m19387d(), c3849b, c3868n);
            } else if (str.equals("img")) {
                abstractC3863iM14826a2 = new C3861g(context, str3, str2, c3849b, c3868n);
            } else if (str.equals("video")) {
                abstractC3863iM14826a2 = new C3873s(context, str3, str2, c3849b, c3868n);
            } else if (str.equals("audio")) {
                abstractC3863iM14826a2 = new C3856b(context, str3, str2, c3849b);
            } else if (str.equals("ref")) {
                String strM14729e = c3849b.m14729e();
                if (C5077a.m19286a(strM14729e)) {
                    abstractC3863iM14826a2 = new C3872r(context, str3, str2, c5094q.m19387d(), c3849b, c3868n);
                } else if (C5077a.m19288b(strM14729e)) {
                    abstractC3863iM14826a2 = new C3861g(context, str3, str2, c3849b, c3868n);
                } else if (C5077a.m19291d(strM14729e)) {
                    abstractC3863iM14826a2 = new C3873s(context, str3, str2, c3849b, c3868n);
                } else if (C5077a.m19290c(strM14729e)) {
                    abstractC3863iM14826a2 = new C3856b(context, str3, str2, c3849b);
                } else {
                    C3890m.m14996b("Mms:media", "[MediaModelFactory] getGenericMediaModel Unsupported Content-Type: " + str3);
                    abstractC3863iM14826a2 = m14826a(context, c3849b, c3868n);
                }
            } else {
                throw new IllegalArgumentException("Unsupported TAG: " + str);
            }
            abstractC3863iM14826a = abstractC3863iM14826a2;
        } else if (str.equals("text")) {
            abstractC3863iM14826a = new C3872r(context, str3, str2, c5094q.m19387d(), c5094q.m19382a(), c3868n);
        } else if (str.equals("img")) {
            abstractC3863iM14826a = new C3861g(context, str3, str2, c5094q.m19383b(), c3868n);
        } else if (str.equals("video")) {
            abstractC3863iM14826a = new C3873s(context, str3, str2, c5094q.m19383b(), c3868n);
        } else if (str.equals("audio")) {
            abstractC3863iM14826a = new C3856b(context, str3, str2, c5094q.m19383b());
        } else if (str.equals("ref")) {
            if (C5077a.m19286a(str3)) {
                abstractC3863iM14826a = new C3872r(context, str3, str2, c5094q.m19387d(), c5094q.m19382a(), c3868n);
            } else if (C5077a.m19288b(str3)) {
                abstractC3863iM14826a = new C3861g(context, str3, str2, c5094q.m19383b(), c3868n);
            } else if (C5077a.m19291d(str3)) {
                abstractC3863iM14826a = new C3873s(context, str3, str2, c5094q.m19383b(), c3868n);
            } else if (C5077a.m19290c(str3)) {
                abstractC3863iM14826a = new C3856b(context, str3, str2, c5094q.m19383b());
            } else {
                C3890m.m14996b("Mms:media", "[MediaModelFactory] getGenericMediaModel Unsupported Content-Type: " + str3);
                abstractC3863iM14826a = m14826a(context, null, c3868n);
            }
        } else {
            throw new IllegalArgumentException("Unsupported TAG: " + str);
        }
        int iMo14611c2 = 0;
        InterfaceC5257q interfaceC5257qG = interfaceC5249i.mo14518g();
        if (interfaceC5257qG != null && interfaceC5257qG.mo14613a() > 0 && (interfaceC5256pMo14614a2 = interfaceC5257qG.mo14614a(0)) != null) {
            iMo14611c2 = (int) (interfaceC5256pMo14614a2.mo14611c() * 1000.0d);
        }
        abstractC3863iM14826a.m14804a(iMo14611c2);
        int iB = (int) (interfaceC5249i.mo14506b() * 1000.0f);
        if (iB > 0 || (interfaceC5257qH = interfaceC5249i.mo14519h()) == null || interfaceC5257qH.mo14613a() <= 0 || (interfaceC5256pMo14614a = interfaceC5257qH.mo14614a(0)) == null || interfaceC5256pMo14614a.mo14612d() == 0) {
            iMo14611c = iB;
        } else {
            iMo14611c = ((int) (interfaceC5256pMo14614a.mo14611c() * 1000.0d)) - iMo14611c2;
            if (iMo14611c == 0 && ((abstractC3863iM14826a instanceof C3856b) || (abstractC3863iM14826a instanceof C3873s))) {
                iMo14611c = C3847e.m14713s();
                if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
                    C3890m.m14996b("Mms:media", "[MediaModelFactory] compute new duration for " + str + ", duration=" + iMo14611c);
                }
            }
        }
        abstractC3863iM14826a.m14809b(iMo14611c);
        if (!C3847e.m14714t()) {
            abstractC3863iM14826a.m14808a((short) 1);
        } else {
            abstractC3863iM14826a.m14808a(interfaceC5249i.mo14520i());
        }
        return abstractC3863iM14826a;
    }
}
