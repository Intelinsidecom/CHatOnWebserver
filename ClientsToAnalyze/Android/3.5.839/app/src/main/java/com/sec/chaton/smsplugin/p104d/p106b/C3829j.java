package com.sec.chaton.smsplugin.p104d.p106b;

import com.sec.chaton.smsplugin.p104d.p105a.C3813a;
import com.sec.chaton.smsplugin.p111h.C3890m;
import org.p146b.p147a.p148a.InterfaceC5236a;
import org.p146b.p147a.p148a.InterfaceC5237b;
import org.p146b.p147a.p149b.InterfaceC5244d;
import org.p146b.p147a.p149b.InterfaceC5247g;

/* compiled from: SmilMediaElementImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.j */
/* loaded from: classes.dex */
class C3829j extends AbstractC3823d {

    /* renamed from: b */
    final /* synthetic */ C3828i f13702b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3829j(C3828i c3828i, InterfaceC5247g interfaceC5247g) {
        super(interfaceC5247g);
        this.f13702b = c3828i;
    }

    /* renamed from: a */
    private InterfaceC5237b m14540a(String str) {
        InterfaceC5237b interfaceC5237bMo14523a = ((InterfaceC5236a) this.f13702b.getOwnerDocument()).mo14523a("Event");
        interfaceC5237bMo14523a.mo14489a(str, false, false);
        return interfaceC5237bMo14523a;
    }

    /* renamed from: a */
    private InterfaceC5237b m14541a(String str, int i) {
        C3813a c3813a = (C3813a) ((InterfaceC5236a) this.f13702b.getOwnerDocument()).mo14523a("Event");
        c3813a.m14490a(str, false, false, i);
        return c3813a;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: c */
    public boolean mo14525c() {
        this.f13702b.mo14501a(m14540a("SmilMediaStart"));
        return true;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: d */
    public boolean mo14526d() {
        this.f13702b.mo14501a(m14540a("SmilMediaEnd"));
        return true;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: r_ */
    public void mo14532r_() {
        this.f13702b.mo14501a(m14540a("SmilMediaStart"));
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: q_ */
    public void mo14531q_() {
        this.f13702b.mo14501a(m14540a("SmilMediaPause"));
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: c */
    public void mo14524c(float f) {
        this.f13702b.mo14501a(m14541a("SmilMediaSeek", (int) f));
    }

    @Override // com.sec.chaton.smsplugin.p104d.p106b.AbstractC3823d, org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: b */
    public float mo14506b() {
        float fMo14506b = super.mo14506b();
        if (fMo14506b == 0.0f) {
            String tagName = this.f13702b.getTagName();
            if (tagName.equals("video") || tagName.equals("audio")) {
                return -1.0f;
            }
            if (tagName.equals("text") || tagName.equals("img")) {
                return 0.0f;
            }
            C3890m.m14997c("Mms:smil", "Unknown media type");
            return fMo14506b;
        }
        return fMo14506b;
    }

    @Override // com.sec.chaton.smsplugin.p104d.p106b.AbstractC3823d
    /* renamed from: f */
    InterfaceC5244d mo14517f() {
        return ((C3830k) this.f13698a.getParentNode()).f13703b;
    }
}
