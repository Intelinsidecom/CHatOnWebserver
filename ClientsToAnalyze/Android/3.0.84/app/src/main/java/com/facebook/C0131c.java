package com.facebook;

import android.content.Context;
import android.os.Bundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.c */
/* loaded from: classes.dex */
class C0131c implements Serializable {

    /* renamed from: a */
    List<AbstractC0164i> f281a;

    /* renamed from: b */
    AbstractC0164i f282b;

    /* renamed from: c */
    transient Context f283c;

    /* renamed from: d */
    transient InterfaceC0175t f284d;

    /* renamed from: e */
    transient InterfaceC0172q f285e;

    /* renamed from: f */
    transient InterfaceC0166k f286f;

    /* renamed from: g */
    transient boolean f287g;

    /* renamed from: h */
    C0165j f288h;

    C0131c() {
    }

    /* renamed from: a */
    void m388a(Context context) {
        this.f283c = context;
        this.f284d = null;
    }

    /* renamed from: a */
    void m389a(C0165j c0165j) {
        if (m395b()) {
            m387a();
        } else {
            m393b(c0165j);
        }
    }

    /* renamed from: b */
    void m393b(C0165j c0165j) {
        if (c0165j != null) {
            if (this.f288h != null) {
                throw new C0180y("Attempted to authorize while a request is pending.");
            }
            if (!c0165j.m488i() || m398c()) {
                this.f288h = c0165j;
                this.f281a = m381c(c0165j);
                m400d();
            }
        }
    }

    /* renamed from: a */
    void m387a() {
        if (this.f288h == null || this.f282b == null) {
            throw new C0180y("Attempted to continue authorization without a pending request.");
        }
        if (this.f282b.mo475a()) {
            this.f282b.mo478c();
            m401e();
        }
    }

    /* renamed from: b */
    boolean m395b() {
        return (this.f288h == null || this.f282b == null) ? false : true;
    }

    /* renamed from: c */
    private List<AbstractC0164i> m381c(C0165j c0165j) {
        ArrayList arrayList = new ArrayList();
        EnumC0124br enumC0124brM482c = c0165j.m482c();
        if (enumC0124brM482c.m360a()) {
            if (!c0165j.m486g()) {
                arrayList.add(new C0167l(this));
                arrayList.add(new C0170o(this));
            }
            arrayList.add(new C0171p(this));
        }
        if (enumC0124brM482c.m361b()) {
            arrayList.add(new C0176u(this));
        }
        return arrayList;
    }

    /* renamed from: c */
    boolean m398c() {
        if (this.f287g) {
            return true;
        }
        if (m386a("android.permission.INTERNET") != 0) {
            m394b(C0173r.m495a("AndroidManifest Error", "WebView login requires INTERNET permission"));
            return false;
        }
        this.f287g = true;
        return true;
    }

    /* renamed from: d */
    void m400d() {
        while (this.f281a != null && !this.f281a.isEmpty()) {
            this.f282b = this.f281a.remove(0);
            if (m401e()) {
                return;
            }
        }
        if (this.f288h != null) {
            m383g();
        }
    }

    /* renamed from: g */
    private void m383g() {
        m394b(C0173r.m495a("Login attempt failed.", null));
    }

    /* renamed from: e */
    boolean m401e() {
        if (!this.f282b.mo477b() || m398c()) {
            return this.f282b.mo476a(this.f288h);
        }
        return false;
    }

    /* renamed from: a */
    void m391a(C0173r c0173r) {
        if (c0173r.f389b != null && this.f288h.m488i()) {
            m397c(c0173r);
        } else {
            m394b(c0173r);
        }
    }

    /* renamed from: b */
    void m394b(C0173r c0173r) {
        this.f281a = null;
        this.f282b = null;
        this.f288h = null;
        m382e(c0173r);
    }

    /* renamed from: a */
    void m390a(InterfaceC0172q interfaceC0172q) {
        this.f285e = interfaceC0172q;
    }

    /* renamed from: f */
    InterfaceC0175t m402f() {
        if (this.f284d != null) {
            return this.f284d;
        }
        if (this.f288h != null) {
            return new C0159d(this);
        }
        return null;
    }

    /* renamed from: a */
    int m386a(String str) {
        return this.f283c.checkCallingOrSelfPermission(str);
    }

    /* renamed from: c */
    void m397c(C0173r c0173r) {
        if (c0173r.f389b == null) {
            throw new C0180y("Can't validate without a token");
        }
        C0083ax c0083axM399d = m399d(c0173r);
        m384h();
        c0083axM399d.m206h();
    }

    /* renamed from: d */
    C0083ax m399d(C0173r c0173r) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strM89a = c0173r.f389b.m89a();
        C0160e c0160e = new C0160e(this, arrayList);
        String strM487h = this.f288h.m487h();
        C0072am c0072amM396c = m396c(strM487h);
        c0072amM396c.m171a((InterfaceC0077ar) c0160e);
        C0072am c0072amM396c2 = m396c(strM89a);
        c0072amM396c2.m171a((InterfaceC0077ar) c0160e);
        C0072am c0072amM392b = m392b(strM487h);
        c0072amM392b.m171a((InterfaceC0077ar) new C0161f(this, arrayList2));
        C0083ax c0083ax = new C0083ax(c0072amM396c, c0072amM396c2, c0072amM392b);
        c0083ax.m196a(this.f288h.m485f());
        c0083ax.m195a(new C0162g(this, arrayList, c0173r, arrayList2));
        return c0083ax;
    }

    /* renamed from: b */
    C0072am m392b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id");
        bundle.putString("access_token", str);
        return new C0072am(null, "me/permissions", bundle, EnumC0069aj.GET, null);
    }

    /* renamed from: c */
    C0072am m396c(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id");
        bundle.putString("access_token", str);
        return new C0072am(null, "me", bundle, EnumC0069aj.GET, null);
    }

    /* renamed from: e */
    private void m382e(C0173r c0173r) {
        if (this.f285e != null) {
            this.f285e.mo331a(c0173r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m384h() {
        if (this.f286f != null) {
            this.f286f.m489a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m385i() {
        if (this.f286f != null) {
            this.f286f.m490b();
        }
    }
}
