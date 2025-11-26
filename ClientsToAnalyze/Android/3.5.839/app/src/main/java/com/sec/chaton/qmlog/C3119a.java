package com.sec.chaton.qmlog;

import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4904y;
import java.util.Hashtable;

/* compiled from: QMLogHelper.java */
/* renamed from: com.sec.chaton.qmlog.a */
/* loaded from: classes.dex */
public class C3119a {

    /* renamed from: a */
    private static final String f11467a = C3119a.class.getSimpleName();

    /* renamed from: c */
    private static C3119a f11468c;

    /* renamed from: b */
    private Hashtable<Object, C3120b> f11469b = new Hashtable<>();

    /* renamed from: a */
    public static C3119a m12716a() {
        synchronized (C3119a.class) {
            if (f11468c == null) {
                f11468c = new C3119a();
            }
        }
        return f11468c;
    }

    private C3119a() {
    }

    /* renamed from: a */
    public void m12717a(long j) {
        m12719a("launch", j);
    }

    /* renamed from: b */
    public boolean m12723b(long j) {
        if (m12720a("launch", C4843bh.m18322a(), 0L)) {
            return m12721a("launch", EnumC3124f.LAUNCH, j);
        }
        return false;
    }

    /* renamed from: a */
    public void m12718a(EnumC3126h enumC3126h, long j) {
        m12719a(enumC3126h.m12752a(), j);
    }

    /* renamed from: b */
    public boolean m12724b(EnumC3126h enumC3126h, long j) {
        C3120b c3120b = null;
        if (this.f11469b.containsKey(enumC3126h.m12752a())) {
            c3120b = this.f11469b.get(enumC3126h.m12752a());
            this.f11469b.remove(enumC3126h.m12752a());
        }
        if (c3120b == null) {
            return false;
        }
        boolean zM12748a = C3122d.m12732a().m12748a(enumC3126h, c3120b.m12726a(), j);
        if (C4904y.f17872b) {
            C4904y.m18639b("writeQMLogs : " + enumC3126h.m12752a() + ", the size of table : " + String.valueOf(this.f11469b.size()), f11467a);
            return zM12748a;
        }
        return zM12748a;
    }

    /* renamed from: c */
    public void m12725c(long j) {
        m12719a("url_load", j);
    }

    /* renamed from: a */
    public boolean m12722a(String str, String str2, long j) {
        C3120b c3120b = null;
        if (this.f11469b.containsKey("url_load")) {
            c3120b = this.f11469b.get("url_load");
            this.f11469b.remove("url_load");
        }
        if (c3120b == null) {
            return false;
        }
        boolean zM12749a = C3122d.m12732a().m12749a(str, str2, c3120b.m12726a(), j);
        if (C4904y.f17872b) {
            C4904y.m18639b("writeQMLogs : url_load, the size of table : " + String.valueOf(this.f11469b.size()), f11467a);
            return zM12749a;
        }
        return zM12749a;
    }

    /* renamed from: a */
    public void m12719a(Object obj, long j) {
        C3120b c3120b = null;
        if (this.f11469b.containsKey(obj)) {
            c3120b = this.f11469b.get(obj);
        }
        if (c3120b == null) {
            c3120b = new C3120b(this);
        }
        c3120b.m12727a(j);
        this.f11469b.put(obj, c3120b);
        if (C4904y.f17872b) {
            C4904y.m18639b("setTimeToRequest : " + obj.toString() + ", the size of table : " + String.valueOf(this.f11469b.size()), f11467a);
        }
    }

    /* renamed from: a */
    public boolean m12720a(Object obj, long j, long j2) {
        C3120b c3120b = null;
        if (this.f11469b.containsKey(obj)) {
            c3120b = this.f11469b.get(obj);
        }
        if (c3120b == null) {
            return false;
        }
        c3120b.m12728a(j, j2);
        this.f11469b.put(obj, c3120b);
        if (C4904y.f17872b) {
            C4904y.m18639b("addMsgInfoToSendQMLogs : " + obj.toString() + ", the size of table : " + String.valueOf(this.f11469b.size()), f11467a);
        }
        return true;
    }

    /* renamed from: a */
    public boolean m12721a(Object obj, EnumC3124f enumC3124f, long j) {
        C3120b c3120b = null;
        if (this.f11469b.containsKey(obj)) {
            c3120b = this.f11469b.get(obj);
        }
        if (c3120b == null) {
            return false;
        }
        c3120b.m12729a(enumC3124f, j);
        this.f11469b.remove(obj);
        if (C4904y.f17872b) {
            C4904y.m18639b("writeQMLogs : " + obj.toString() + ", the size of table : " + String.valueOf(this.f11469b.size()), f11467a);
        }
        return true;
    }
}
