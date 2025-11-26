package com.sec.chaton.smsplugin.p104d.p106b;

import org.p146b.p147a.p149b.InterfaceC5255o;

/* compiled from: SmilRootLayoutElementImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.u */
/* loaded from: classes.dex */
public class C3840u extends C3826g implements InterfaceC5255o {
    C3840u(C3824e c3824e, String str) {
        super(c3824e, str);
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5241a
    /* renamed from: d */
    public String mo14600d() {
        return getAttribute("backgroundColor");
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5241a
    /* renamed from: e */
    public int mo14602e() {
        return m14606b(getAttribute("height"));
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5241a
    /* renamed from: f */
    public int mo14603f() {
        return m14606b(getAttribute("width"));
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

    /* renamed from: b */
    private int m14606b(String str) {
        if (str.endsWith("px")) {
            str = str.substring(0, str.indexOf("px"));
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
