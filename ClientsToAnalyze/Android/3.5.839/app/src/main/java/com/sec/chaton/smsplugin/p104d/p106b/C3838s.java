package com.sec.chaton.smsplugin.p104d.p106b;

import org.p146b.p147a.p149b.InterfaceC5246f;
import org.p146b.p147a.p149b.InterfaceC5252l;

/* compiled from: SmilRegionElementImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.s */
/* loaded from: classes.dex */
public class C3838s extends C3826g implements InterfaceC5252l {
    C3838s(C3824e c3824e, String str) {
        super(c3824e, str);
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5252l
    /* renamed from: a */
    public String mo14592a() {
        String attribute = getAttribute("fit");
        if ("fill".equalsIgnoreCase(attribute)) {
            return "fill";
        }
        if ("meet".equalsIgnoreCase(attribute)) {
            return "meet";
        }
        if ("scroll".equalsIgnoreCase(attribute)) {
            return "scroll";
        }
        if ("slice".equalsIgnoreCase(attribute)) {
            return "slice";
        }
        return "hidden";
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5252l
    /* renamed from: b */
    public int mo14594b() {
        try {
            return m14591a(getAttribute("left"), true);
        } catch (NumberFormatException e) {
            try {
                return (((InterfaceC5246f) getOwnerDocument()).mo14530m().mo14537b().mo14603f() - m14591a(getAttribute("right"), true)) - m14591a(getAttribute("width"), true);
            } catch (NumberFormatException e2) {
                return 0;
            }
        }
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5252l
    /* renamed from: c */
    public int mo14597c() {
        try {
            return m14591a(getAttribute("top"), false);
        } catch (NumberFormatException e) {
            try {
                return (((InterfaceC5246f) getOwnerDocument()).mo14530m().mo14537b().mo14602e() - m14591a(getAttribute("bottom"), false)) - m14591a(getAttribute("height"), false);
            } catch (NumberFormatException e2) {
                return 0;
            }
        }
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5252l
    /* renamed from: b */
    public void mo14596b(String str) {
        if (str.equalsIgnoreCase("fill") || str.equalsIgnoreCase("meet") || str.equalsIgnoreCase("scroll") || str.equalsIgnoreCase("slice")) {
            setAttribute("fit", str.toLowerCase());
        } else {
            setAttribute("fit", "hidden");
        }
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5252l
    /* renamed from: a */
    public void mo14593a(int i) {
        setAttribute("left", String.valueOf(i));
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5252l
    /* renamed from: b */
    public void mo14595b(int i) {
        setAttribute("top", String.valueOf(i));
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5241a
    /* renamed from: d */
    public String mo14600d() {
        return getAttribute("backgroundColor");
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5241a
    /* renamed from: e */
    public int mo14602e() {
        try {
            int iM14591a = m14591a(getAttribute("height"), false);
            return iM14591a == 0 ? ((InterfaceC5246f) getOwnerDocument()).mo14530m().mo14537b().mo14602e() : iM14591a;
        } catch (NumberFormatException e) {
            int iE = ((InterfaceC5246f) getOwnerDocument()).mo14530m().mo14537b().mo14602e();
            try {
                iE -= m14591a(getAttribute("top"), false);
            } catch (NumberFormatException e2) {
            }
            try {
                return iE - m14591a(getAttribute("bottom"), false);
            } catch (NumberFormatException e3) {
                return iE;
            }
        }
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5241a
    /* renamed from: f */
    public int mo14603f() {
        try {
            int iM14591a = m14591a(getAttribute("width"), true);
            return iM14591a == 0 ? ((InterfaceC5246f) getOwnerDocument()).mo14530m().mo14537b().mo14603f() : iM14591a;
        } catch (NumberFormatException e) {
            int iF = ((InterfaceC5246f) getOwnerDocument()).mo14530m().mo14537b().mo14603f();
            try {
                iF -= m14591a(getAttribute("left"), true);
            } catch (NumberFormatException e2) {
            }
            try {
                return iF - m14591a(getAttribute("right"), true);
            } catch (NumberFormatException e3) {
                return iF;
            }
        }
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5241a
    /* renamed from: c */
    public void mo14599c(String str) {
        setAttribute("backgroundColor", str);
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5241a
    /* renamed from: c */
    public void mo14598c(int i) {
        setAttribute("height", String.valueOf(i) + "px");
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5241a
    /* renamed from: d */
    public void mo14601d(int i) {
        setAttribute("width", String.valueOf(i) + "px");
    }

    @Override // com.sec.chaton.smsplugin.p104d.p106b.C3826g, org.p146b.p147a.p149b.InterfaceC5247g
    /* renamed from: j */
    public String mo14535j() {
        return getAttribute("id");
    }

    @Override // com.sec.chaton.smsplugin.p104d.p106b.C3826g, org.p146b.p147a.p149b.InterfaceC5247g
    /* renamed from: a */
    public void mo14534a(String str) {
        setAttribute("id", str);
    }

    /* renamed from: a */
    private int m14591a(String str, boolean z) {
        double dE;
        if (str.endsWith("px")) {
            return Integer.parseInt(str.substring(0, str.indexOf("px")));
        }
        if (str.endsWith("%")) {
            double d = 0.01d * Integer.parseInt(str.substring(0, str.length() - 1));
            if (z) {
                dE = d * ((InterfaceC5246f) getOwnerDocument()).mo14530m().mo14537b().mo14603f();
            } else {
                dE = d * ((InterfaceC5246f) getOwnerDocument()).mo14530m().mo14537b().mo14602e();
            }
            return (int) Math.round(dE);
        }
        return Integer.parseInt(str);
    }

    public String toString() {
        return super.toString() + ": id=" + mo14535j() + ", width=" + mo14603f() + ", height=" + mo14602e() + ", left=" + mo14594b() + ", top=" + mo14597c();
    }
}
