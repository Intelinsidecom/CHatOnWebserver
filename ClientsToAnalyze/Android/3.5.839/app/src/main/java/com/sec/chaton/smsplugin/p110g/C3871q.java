package com.sec.chaton.smsplugin.p110g;

import com.sec.chaton.smsplugin.p104d.p106b.C3824e;
import com.sec.chaton.smsplugin.p104d.p106b.p107a.C3819b;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.C5077a;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5086i;
import com.sec.google.android.p134a.p135a.C5094q;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.p146b.p147a.p148a.InterfaceC5240e;
import org.p146b.p147a.p149b.InterfaceC5246f;
import org.p146b.p147a.p149b.InterfaceC5247g;
import org.p146b.p147a.p149b.InterfaceC5248h;
import org.p146b.p147a.p149b.InterfaceC5249i;
import org.p146b.p147a.p149b.InterfaceC5250j;
import org.p146b.p147a.p149b.InterfaceC5252l;
import org.p146b.p147a.p149b.InterfaceC5254n;
import org.xml.sax.SAXException;

/* compiled from: SmilHelper.java */
/* renamed from: com.sec.chaton.smsplugin.g.q */
/* loaded from: classes.dex */
public class C3871q {

    /* renamed from: a */
    private static boolean f13933a;

    /* renamed from: a */
    public static InterfaceC5246f m14927a(C5086i c5086i) {
        C5094q c5094qM14935b = m14935b(c5086i);
        InterfaceC5246f interfaceC5246fM14928a = null;
        if (c5094qM14935b == null) {
            f13933a = true;
            C3890m.m14994a("Mms/smil", "getDocument smilPart is null.");
        }
        if (c5094qM14935b != null) {
            interfaceC5246fM14928a = m14928a(c5094qM14935b);
        }
        if (interfaceC5246fM14928a == null) {
            return m14938c(c5086i);
        }
        return interfaceC5246fM14928a;
    }

    /* renamed from: a */
    public static InterfaceC5246f m14926a(C3870p c3870p) {
        return m14936b(c3870p);
    }

    /* renamed from: b */
    private static C5094q m14935b(C5086i c5086i) {
        int iM19333b = c5086i.m19333b();
        for (int i = 0; i < iM19333b; i++) {
            C5094q c5094qM19328a = c5086i.m19328a(i);
            if (Arrays.equals(c5094qM19328a.m19394g(), "application/smil".getBytes())) {
                return c5094qM19328a;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static InterfaceC5246f m14937b(InterfaceC5246f interfaceC5246f) {
        return interfaceC5246f;
    }

    /* renamed from: a */
    private static InterfaceC5246f m14928a(C5094q c5094q) {
        try {
            byte[] bArrM19382a = c5094q.m19382a();
            if (bArrM19382a == null) {
                C3890m.m14994a("Mms/smil", "getSmilDocument milPart.getData(); is null.");
            }
            if (bArrM19382a != null) {
                return m14937b(new C3819b().m14511a(new ByteArrayInputStream(bArrM19382a)));
            }
        } catch (C5111c e) {
            C3890m.m14995a("Mms/smil", "Failed to parse SMIL document.", e);
        } catch (IOException e2) {
            C3890m.m14995a("Mms/smil", "Failed to parse SMIL document.", e2);
        } catch (SAXException e3) {
            C3890m.m14995a("Mms/smil", "Failed to parse SMIL document.", e3);
        }
        return null;
    }

    /* renamed from: a */
    public static InterfaceC5250j m14930a(InterfaceC5246f interfaceC5246f) {
        InterfaceC5250j interfaceC5250j = (InterfaceC5250j) interfaceC5246f.createElement("par");
        interfaceC5250j.mo14515b(8.0f);
        interfaceC5246f.mo14529l().appendChild(interfaceC5250j);
        return interfaceC5250j;
    }

    /* renamed from: a */
    public static InterfaceC5249i m14929a(String str, InterfaceC5246f interfaceC5246f, String str2) {
        InterfaceC5249i interfaceC5249i = (InterfaceC5249i) interfaceC5246f.createElement(str);
        interfaceC5249i.mo14539b(m14925a(str2));
        return interfaceC5249i;
    }

    /* renamed from: a */
    public static String m14925a(String str) {
        return str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("'", "&apos;");
    }

    /* renamed from: c */
    private static InterfaceC5246f m14938c(C5086i c5086i) {
        C3824e c3824e = new C3824e();
        InterfaceC5247g interfaceC5247g = (InterfaceC5247g) c3824e.createElement("smil");
        interfaceC5247g.setAttribute("xmlns", "http://www.w3.org/2001/SMIL20/Language");
        c3824e.appendChild(interfaceC5247g);
        InterfaceC5247g interfaceC5247g2 = (InterfaceC5247g) c3824e.createElement("head");
        interfaceC5247g.appendChild(interfaceC5247g2);
        interfaceC5247g2.appendChild((InterfaceC5248h) c3824e.createElement("layout"));
        interfaceC5247g.appendChild((InterfaceC5247g) c3824e.createElement("body"));
        InterfaceC5250j interfaceC5250jM14930a = m14930a(c3824e);
        int iM19333b = c5086i.m19333b();
        if (iM19333b == 0) {
            return c3824e;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < iM19333b; i++) {
            if (f13933a && (z || z2)) {
                interfaceC5250jM14930a = m14930a(c3824e);
            } else if (interfaceC5250jM14930a == null || (z && z2)) {
                z2 = false;
                interfaceC5250jM14930a = m14930a(c3824e);
                z = false;
            }
            C5094q c5094qM19328a = c5086i.m19328a(i);
            String str = new String(c5094qM19328a.m19394g());
            if (str.equals("text/plain") || str.equalsIgnoreCase("application/vnd.wap.xhtml+xml") || str.equals("text/html")) {
                interfaceC5250jM14930a.appendChild(m14929a("text", c3824e, c5094qM19328a.m19399k()));
                z2 = true;
            } else if (C5077a.m19288b(str)) {
                interfaceC5250jM14930a.appendChild(m14929a("img", c3824e, c5094qM19328a.m19399k()));
                z = true;
            } else if (C5077a.m19291d(str)) {
                interfaceC5250jM14930a.appendChild(m14929a("video", c3824e, c5094qM19328a.m19399k()));
                z = true;
            } else if (C5077a.m19290c(str)) {
                interfaceC5250jM14930a.appendChild(m14929a("audio", c3824e, c5094qM19328a.m19399k()));
                z = true;
            } else {
                C3890m.m14997c("Mms/smil", "unsupport media type");
            }
        }
        return c3824e;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x011c A[Catch: all -> 0x019f, TryCatch #0 {, blocks: (B:11:0x00b4, B:12:0x00b8, B:14:0x00be, B:15:0x00de, B:17:0x00e4, B:19:0x00f2, B:21:0x0100, B:22:0x0116, B:24:0x011c, B:25:0x0128, B:27:0x012e, B:28:0x0133, B:29:0x013e, B:31:0x0142, B:32:0x0159, B:34:0x015d, B:35:0x0174, B:37:0x0178, B:38:0x0183, B:42:0x01a2), top: B:44:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x012e A[Catch: all -> 0x019f, TryCatch #0 {, blocks: (B:11:0x00b4, B:12:0x00b8, B:14:0x00be, B:15:0x00de, B:17:0x00e4, B:19:0x00f2, B:21:0x0100, B:22:0x0116, B:24:0x011c, B:25:0x0128, B:27:0x012e, B:28:0x0133, B:29:0x013e, B:31:0x0142, B:32:0x0159, B:34:0x015d, B:35:0x0174, B:37:0x0178, B:38:0x0183, B:42:0x01a2), top: B:44:0x00b4 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.p146b.p147a.p149b.InterfaceC5246f m14936b(com.sec.chaton.smsplugin.p110g.C3870p r16) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p110g.C3871q.m14936b(com.sec.chaton.smsplugin.g.p):org.b.a.b.f");
    }

    /* renamed from: a */
    private static InterfaceC5252l m14931a(ArrayList<InterfaceC5252l> arrayList, String str) {
        Iterator<InterfaceC5252l> it = arrayList.iterator();
        while (it.hasNext()) {
            InterfaceC5252l next = it.next();
            if (next.mo14535j().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m14934a(InterfaceC5254n interfaceC5254n, ArrayList<InterfaceC5252l> arrayList, InterfaceC5248h interfaceC5248h, String str, boolean z) {
        InterfaceC5252l interfaceC5252lM14931a = m14931a(arrayList, str);
        if (z || interfaceC5252lM14931a == null) {
            return false;
        }
        interfaceC5254n.mo14604a(interfaceC5252lM14931a);
        interfaceC5248h.appendChild(interfaceC5252lM14931a);
        return true;
    }

    /* renamed from: a */
    static void m14932a(InterfaceC5240e interfaceC5240e, AbstractC3863i abstractC3863i) {
        interfaceC5240e.mo14500a("SmilMediaStart", abstractC3863i, false);
        interfaceC5240e.mo14500a("SmilMediaEnd", abstractC3863i, false);
        interfaceC5240e.mo14500a("SmilMediaPause", abstractC3863i, false);
        interfaceC5240e.mo14500a("SmilMediaSeek", abstractC3863i, false);
    }

    /* renamed from: a */
    static void m14933a(InterfaceC5240e interfaceC5240e, C3869o c3869o) {
        interfaceC5240e.mo14500a("SmilSlideStart", c3869o, false);
        interfaceC5240e.mo14500a("SmilSlideEnd", c3869o, false);
    }
}
