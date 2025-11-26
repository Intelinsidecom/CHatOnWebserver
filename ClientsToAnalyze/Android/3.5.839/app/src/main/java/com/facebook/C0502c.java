package com.facebook;

import android.content.Context;
import android.os.Bundle;
import com.p137vk.sdk.api.VKApiConst;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.c */
/* loaded from: classes.dex */
class C0502c implements Serializable {

    /* renamed from: a */
    List<AbstractC0535i> f1250a;

    /* renamed from: b */
    AbstractC0535i f1251b;

    /* renamed from: c */
    transient Context f1252c;

    /* renamed from: d */
    transient InterfaceC0546t f1253d;

    /* renamed from: e */
    transient InterfaceC0543q f1254e;

    /* renamed from: f */
    transient InterfaceC0537k f1255f;

    /* renamed from: g */
    transient boolean f1256g;

    /* renamed from: h */
    C0536j f1257h;

    C0502c() {
    }

    /* renamed from: a */
    void m1831a(Context context) {
        this.f1252c = context;
        this.f1253d = null;
    }

    /* renamed from: a */
    void m1832a(C0536j c0536j) {
        if (m1838b()) {
            m1830a();
        } else {
            m1836b(c0536j);
        }
    }

    /* renamed from: b */
    void m1836b(C0536j c0536j) {
        if (c0536j != null) {
            if (this.f1257h != null) {
                throw new C0551y("Attempted to authorize while a request is pending.");
            }
            if (!c0536j.m1931i() || m1841c()) {
                this.f1257h = c0536j;
                this.f1250a = m1824c(c0536j);
                m1843d();
            }
        }
    }

    /* renamed from: a */
    void m1830a() {
        if (this.f1257h == null || this.f1251b == null) {
            throw new C0551y("Attempted to continue authorization without a pending request.");
        }
        if (this.f1251b.mo1918a()) {
            this.f1251b.mo1921c();
            m1844e();
        }
    }

    /* renamed from: b */
    boolean m1838b() {
        return (this.f1257h == null || this.f1251b == null) ? false : true;
    }

    /* renamed from: c */
    private List<AbstractC0535i> m1824c(C0536j c0536j) {
        ArrayList arrayList = new ArrayList();
        EnumC0495br enumC0495brM1925c = c0536j.m1925c();
        if (enumC0495brM1925c.m1803a()) {
            if (!c0536j.m1929g()) {
                arrayList.add(new C0538l(this));
                arrayList.add(new C0541o(this));
            }
            arrayList.add(new C0542p(this));
        }
        if (enumC0495brM1925c.m1804b()) {
            arrayList.add(new C0547u(this));
        }
        return arrayList;
    }

    /* renamed from: c */
    boolean m1841c() {
        if (this.f1256g) {
            return true;
        }
        if (m1829a("android.permission.INTERNET") != 0) {
            m1837b(C0544r.m1938a("AndroidManifest Error", "WebView login requires INTERNET permission"));
            return false;
        }
        this.f1256g = true;
        return true;
    }

    /* renamed from: d */
    void m1843d() {
        while (this.f1250a != null && !this.f1250a.isEmpty()) {
            this.f1251b = this.f1250a.remove(0);
            if (m1844e()) {
                return;
            }
        }
        if (this.f1257h != null) {
            m1826g();
        }
    }

    /* renamed from: g */
    private void m1826g() {
        m1837b(C0544r.m1938a("Login attempt failed.", null));
    }

    /* renamed from: e */
    boolean m1844e() {
        if (!this.f1251b.mo1920b() || m1841c()) {
            return this.f1251b.mo1919a(this.f1257h);
        }
        return false;
    }

    /* renamed from: a */
    void m1834a(C0544r c0544r) {
        if (c0544r.f1359b != null && this.f1257h.m1931i()) {
            m1840c(c0544r);
        } else {
            m1837b(c0544r);
        }
    }

    /* renamed from: b */
    void m1837b(C0544r c0544r) {
        this.f1250a = null;
        this.f1251b = null;
        this.f1257h = null;
        m1825e(c0544r);
    }

    /* renamed from: a */
    void m1833a(InterfaceC0543q interfaceC0543q) {
        this.f1254e = interfaceC0543q;
    }

    /* renamed from: f */
    InterfaceC0546t m1845f() {
        if (this.f1253d != null) {
            return this.f1253d;
        }
        if (this.f1257h != null) {
            return new C0530d(this);
        }
        return null;
    }

    /* renamed from: a */
    int m1829a(String str) {
        return this.f1252c.checkCallingOrSelfPermission(str);
    }

    /* renamed from: c */
    void m1840c(C0544r c0544r) {
        if (c0544r.f1359b == null) {
            throw new C0551y("Can't validate without a token");
        }
        C0454ax c0454axM1842d = m1842d(c0544r);
        m1827h();
        c0454axM1842d.m1650h();
    }

    /* renamed from: d */
    C0454ax m1842d(C0544r c0544r) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strM1532a = c0544r.f1359b.m1532a();
        C0531e c0531e = new C0531e(this, arrayList);
        String strM1930h = this.f1257h.m1930h();
        C0443am c0443amM1839c = m1839c(strM1930h);
        c0443amM1839c.m1615a((InterfaceC0448ar) c0531e);
        C0443am c0443amM1839c2 = m1839c(strM1532a);
        c0443amM1839c2.m1615a((InterfaceC0448ar) c0531e);
        C0443am c0443amM1835b = m1835b(strM1930h);
        c0443amM1835b.m1615a((InterfaceC0448ar) new C0532f(this, arrayList2));
        C0454ax c0454ax = new C0454ax(c0443amM1839c, c0443amM1839c2, c0443amM1835b);
        c0454ax.m1640a(this.f1257h.m1928f());
        c0454ax.m1639a(new C0533g(this, arrayList, c0544r, arrayList2));
        return c0454ax;
    }

    /* renamed from: b */
    C0443am m1835b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(VKApiConst.FIELDS, "id");
        bundle.putString("access_token", str);
        return new C0443am(null, "me/permissions", bundle, EnumC0440aj.GET, null);
    }

    /* renamed from: c */
    C0443am m1839c(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(VKApiConst.FIELDS, "id");
        bundle.putString("access_token", str);
        return new C0443am(null, "me", bundle, EnumC0440aj.GET, null);
    }

    /* renamed from: e */
    private void m1825e(C0544r c0544r) {
        if (this.f1254e != null) {
            this.f1254e.mo1774a(c0544r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m1827h() {
        if (this.f1255f != null) {
            this.f1255f.m1932a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m1828i() {
        if (this.f1255f != null) {
            this.f1255f.m1933b();
        }
    }
}
