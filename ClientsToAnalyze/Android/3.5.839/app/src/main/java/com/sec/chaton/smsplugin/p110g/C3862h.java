package com.sec.chaton.smsplugin.p110g;

import com.sec.chaton.smsplugin.p109f.C3852b;
import com.sec.chaton.smsplugin.p109f.InterfaceC3853c;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: LayoutModel.java */
/* renamed from: com.sec.chaton.smsplugin.g.h */
/* loaded from: classes.dex */
public class C3862h extends C3866l {

    /* renamed from: a */
    private int f13873a;

    /* renamed from: b */
    private C3868n f13874b;

    /* renamed from: c */
    private C3868n f13875c;

    /* renamed from: d */
    private C3868n f13876d;

    /* renamed from: e */
    private ArrayList<C3868n> f13877e;

    /* renamed from: f */
    private InterfaceC3853c f13878f;

    public C3862h() {
        this.f13873a = 0;
        this.f13878f = C3852b.m14736a().m14740b();
        m14782i();
        m14783j();
        m14784k();
    }

    public C3862h(C3868n c3868n, ArrayList<C3868n> arrayList) {
        this.f13873a = 0;
        this.f13878f = C3852b.m14736a().m14740b();
        this.f13874b = c3868n;
        this.f13877e = new ArrayList<>();
        Iterator<C3868n> it = arrayList.iterator();
        while (it.hasNext()) {
            C3868n next = it.next();
            String strM14838a = next.m14838a();
            if (strM14838a.equals("Image")) {
                this.f13875c = next;
            } else if (strM14838a.equals("Text")) {
                this.f13876d = next;
            } else {
                this.f13877e.add(next);
            }
        }
        m14785l();
    }

    /* renamed from: i */
    private void m14782i() {
        this.f13874b = new C3868n(null, 0, 0, this.f13878f.mo14732a(), this.f13878f.mo14733b());
    }

    /* renamed from: j */
    private void m14783j() {
        if (this.f13874b == null) {
            throw new IllegalStateException("Root-Layout uninitialized.");
        }
        this.f13875c = new C3868n("Image", 0, 0, this.f13874b.m14843e(), this.f13878f.mo14734c());
    }

    /* renamed from: k */
    private void m14784k() {
        if (this.f13874b == null) {
            throw new IllegalStateException("Root-Layout uninitialized.");
        }
        this.f13876d = new C3868n("Text", 0, this.f13878f.mo14734c(), this.f13874b.m14843e(), this.f13878f.mo14735d());
    }

    /* renamed from: l */
    private void m14785l() {
        if (this.f13874b == null) {
            m14782i();
        }
        if (this.f13875c == null) {
            m14783j();
        }
        if (this.f13876d == null) {
            m14784k();
        }
    }

    /* renamed from: a */
    public C3868n m14786a() {
        return this.f13875c;
    }

    /* renamed from: b */
    public C3868n m14790b() {
        return this.f13876d;
    }

    /* renamed from: c */
    public ArrayList<C3868n> m14792c() {
        ArrayList<C3868n> arrayList = new ArrayList<>();
        if (this.f13875c != null) {
            arrayList.add(this.f13875c);
        }
        if (this.f13876d != null) {
            arrayList.add(this.f13876d);
        }
        return arrayList;
    }

    /* renamed from: a */
    public C3868n m14787a(String str) {
        if ("Image".equals(str)) {
            return this.f13875c;
        }
        if ("Text".equals(str)) {
            return this.f13876d;
        }
        Iterator<C3868n> it = this.f13877e.iterator();
        while (it.hasNext()) {
            C3868n next = it.next();
            if (next.m14838a().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: d */
    public int m14793d() {
        return this.f13874b.m14843e();
    }

    /* renamed from: e */
    public int m14794e() {
        return this.f13874b.m14844f();
    }

    /* renamed from: f */
    public String m14795f() {
        return this.f13874b.m14845g();
    }

    /* renamed from: a */
    public void m14788a(int i) {
        if (this.f13874b == null) {
            throw new IllegalStateException("Root-Layout uninitialized.");
        }
        if (this.f13878f == null) {
            this.f13878f = C3852b.m14736a().m14740b();
        }
        if (this.f13873a != i) {
            switch (i) {
                case 0:
                    this.f13875c.m14839a(0);
                    this.f13876d.m14839a(this.f13878f.mo14734c());
                    this.f13873a = i;
                    m14833a(true);
                    return;
                case 1:
                    this.f13875c.m14839a(this.f13878f.mo14735d());
                    this.f13876d.m14839a(0);
                    this.f13873a = i;
                    m14833a(true);
                    return;
                default:
                    C3890m.m14997c("Mms/slideshow", "Unknown layout type: " + i);
                    return;
            }
        }
    }

    /* renamed from: g */
    public int m14796g() {
        return this.f13873a;
    }

    @Override // com.sec.chaton.smsplugin.p110g.C3866l
    /* renamed from: a */
    protected void mo14789a(InterfaceC3860f interfaceC3860f) {
        if (this.f13874b != null) {
            this.f13874b.m14834c(interfaceC3860f);
        }
        if (this.f13875c != null) {
            this.f13875c.m14834c(interfaceC3860f);
        }
        if (this.f13876d != null) {
            this.f13876d.m14834c(interfaceC3860f);
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.C3866l
    /* renamed from: b */
    protected void mo14791b(InterfaceC3860f interfaceC3860f) {
        if (this.f13874b != null) {
            this.f13874b.m14835d(interfaceC3860f);
        }
        if (this.f13875c != null) {
            this.f13875c.m14835d(interfaceC3860f);
        }
        if (this.f13876d != null) {
            this.f13876d.m14835d(interfaceC3860f);
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.C3866l
    /* renamed from: t_ */
    protected void mo14797t_() {
        if (this.f13874b != null) {
            this.f13874b.m14832E();
        }
        if (this.f13875c != null) {
            this.f13875c.m14832E();
        }
        if (this.f13876d != null) {
            this.f13876d.m14832E();
        }
    }
}
