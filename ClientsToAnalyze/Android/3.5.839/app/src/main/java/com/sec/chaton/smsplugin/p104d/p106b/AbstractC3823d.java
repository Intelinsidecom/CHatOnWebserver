package com.sec.chaton.smsplugin.p104d.p106b;

import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import org.p146b.p147a.p149b.InterfaceC5244d;
import org.p146b.p147a.p149b.InterfaceC5247g;
import org.p146b.p147a.p149b.InterfaceC5257q;

/* compiled from: ElementTimeImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.d */
/* loaded from: classes.dex */
public abstract class AbstractC3823d implements InterfaceC5244d {

    /* renamed from: a */
    final InterfaceC5247g f13698a;

    /* renamed from: f */
    abstract InterfaceC5244d mo14517f();

    AbstractC3823d(InterfaceC5247g interfaceC5247g) {
        this.f13698a = interfaceC5247g;
    }

    /* renamed from: p_ */
    int m14522p_() {
        return 255;
    }

    /* renamed from: e */
    int m14516e() {
        return 255;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: g */
    public InterfaceC5257q mo14518g() {
        String[] strArrSplit = this.f13698a.getAttribute("begin").split(Config.KEYVALUE_SPLIT);
        ArrayList arrayList = new ArrayList();
        for (String str : strArrSplit) {
            try {
                arrayList.add(new C3841v(str, m14522p_()));
            } catch (IllegalArgumentException e) {
            }
        }
        if (arrayList.size() == 0) {
            arrayList.add(new C3841v(Spam.ACTIVITY_CANCEL, 255));
        }
        return new C3842w(arrayList);
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: b */
    public float mo14506b() {
        try {
            String attribute = this.f13698a.getAttribute("dur");
            if (attribute == null) {
                return 0.0f;
            }
            return C3841v.m14607a(attribute) / 1000.0f;
        } catch (IllegalArgumentException e) {
            return 0.0f;
        }
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: h */
    public InterfaceC5257q mo14519h() {
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = this.f13698a.getAttribute("end").split(Config.KEYVALUE_SPLIT);
        if (strArrSplit.length != 1 || strArrSplit[0].length() != 0) {
            for (String str : strArrSplit) {
                try {
                    arrayList.add(new C3841v(str, m14516e()));
                } catch (IllegalArgumentException e) {
                    C3890m.m14995a("ElementTimeImpl", "Malformed time value.", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            float fMo14506b = mo14506b();
            if (fMo14506b < 0.0f) {
                arrayList.add(new C3841v("indefinite", m14516e()));
            } else {
                InterfaceC5257q interfaceC5257qMo14518g = mo14518g();
                for (int i = 0; i < interfaceC5257qMo14518g.mo14613a(); i++) {
                    arrayList.add(new C3841v((interfaceC5257qMo14518g.mo14614a(i).mo14611c() + fMo14506b) + "s", m14516e()));
                }
            }
        }
        return new C3842w(arrayList);
    }

    /* renamed from: a */
    private boolean m14514a() {
        InterfaceC5257q interfaceC5257qMo14518g = mo14518g();
        InterfaceC5257q interfaceC5257qMo14519h = mo14519h();
        if (interfaceC5257qMo14518g.mo14613a() == 1 && interfaceC5257qMo14519h.mo14613a() == 1) {
            return interfaceC5257qMo14518g.mo14614a(0).mo14609a() == 0.0d && interfaceC5257qMo14519h.mo14614a(0).mo14609a() == 0.0d;
        }
        return false;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: i */
    public short mo14520i() {
        short sM14521j;
        String attribute = this.f13698a.getAttribute("fill");
        if (attribute.equalsIgnoreCase("freeze")) {
            return (short) 1;
        }
        if (attribute.equalsIgnoreCase("remove")) {
            return (short) 0;
        }
        if (attribute.equalsIgnoreCase("hold") || attribute.equalsIgnoreCase("transition")) {
            return (short) 1;
        }
        return (attribute.equalsIgnoreCase("auto") || (sM14521j = m14521j()) == 2) ? ((this.f13698a.getAttribute("dur").length() == 0 && this.f13698a.getAttribute("end").length() == 0 && this.f13698a.getAttribute("repeatCount").length() == 0 && this.f13698a.getAttribute("repeatDur").length() == 0) || m14514a()) ? (short) 1 : (short) 0 : sM14521j;
    }

    /* renamed from: j */
    public short m14521j() {
        String attribute = this.f13698a.getAttribute("fillDefault");
        if (attribute.equalsIgnoreCase("remove")) {
            return (short) 0;
        }
        if (attribute.equalsIgnoreCase("freeze")) {
            return (short) 1;
        }
        if (attribute.equalsIgnoreCase("auto")) {
            return (short) 2;
        }
        if (attribute.equalsIgnoreCase("hold") || attribute.equalsIgnoreCase("transition")) {
            return (short) 1;
        }
        InterfaceC5244d interfaceC5244dMo14517f = mo14517f();
        if (interfaceC5244dMo14517f == null) {
            return (short) 2;
        }
        return ((AbstractC3823d) interfaceC5244dMo14517f).m14521j();
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5244d
    /* renamed from: b */
    public void mo14515b(float f) {
        this.f13698a.setAttribute("dur", Integer.toString((int) (1000.0f * f)) + "ms");
    }
}
