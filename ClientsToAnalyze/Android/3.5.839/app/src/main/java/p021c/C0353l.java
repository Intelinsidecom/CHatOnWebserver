package p021c;

import p021c.p022a.C0328c;

/* compiled from: WeiboSupport.java */
/* renamed from: c.l */
/* loaded from: classes.dex */
class C0353l {

    /* renamed from: f */
    protected C0328c f858f;

    /* renamed from: g */
    protected String f859g;

    /* renamed from: h */
    protected final boolean f860h;

    C0353l() {
        this(null, null);
    }

    C0353l(String str, String str2) {
        this.f858f = new C0328c();
        this.f859g = C0325a.m1100e();
        this.f860h = C0325a.m1097c();
        mo1240h(null);
        mo1239g(null);
        mo1238f(str);
        mo1237e(str2);
    }

    /* renamed from: h */
    public void mo1240h(String str) {
        mo1233b("X-Weibo-Client-Version", C0325a.m1089a(str));
    }

    /* renamed from: g */
    public void mo1239g(String str) {
        mo1233b("X-Weibo-Client-URL", C0325a.m1094b(str));
    }

    /* renamed from: f */
    public synchronized void mo1238f(String str) {
        this.f858f.m1139a(C0325a.m1096c(str));
    }

    /* renamed from: e */
    public synchronized void mo1237e(String str) {
        this.f858f.m1144b(C0325a.m1099d(str));
    }

    /* renamed from: b */
    public void mo1233b(String str, String str2) {
        this.f858f.m1145b(str, str2);
    }
}
