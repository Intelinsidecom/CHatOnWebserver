package com.sec.common.util.log.collector;

import com.sec.common.C4996f;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5052r;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
import org.p138a.p139a.p140a.InterfaceC5223f;
import org.p138a.p139a.p140a.p141a.C5218p;

/* compiled from: LogWriter.java */
/* renamed from: com.sec.common.util.log.collector.h */
/* loaded from: classes.dex */
public class C5043h {

    /* renamed from: a */
    private static final String f18374a = C5043h.class.getSimpleName();

    /* renamed from: b */
    private static C5043h f18375b;

    /* renamed from: c */
    private ExecutorService f18376c = Executors.newFixedThreadPool(1, new ThreadFactoryC5044i(this));

    /* renamed from: d */
    private InterfaceC5223f<C5045j> f18377d = new C5218p(new C5046k(this, null));

    /* renamed from: a */
    public static synchronized C5043h m19179a() {
        if (f18375b == null) {
            f18375b = new C5043h();
        }
        return f18375b;
    }

    private C5043h() {
    }

    /* renamed from: a */
    public void m19185a(String str, String str2, boolean z) {
        if (!C5038c.m19168q() || !C5038c.m19167p()) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f18374a, "writeWithParam return because LogCollectorManager.isLogCollectorEnabled(" + C5038c.m19168q() + ") LogCollectorManager.isLogCollectorRegistered(" + C5038c.m19167p() + ")");
                return;
            }
            return;
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f18374a, C5052r.m19199a("Requested writing log message. pageId = ", str, " eventId = ", str2));
        }
        try {
            C5037b c5037bM19173a = C5040e.m19173a();
            if (c5037bM19173a != null) {
                new Date(C5034k.m19090a());
                new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
                c5037bM19173a.m19134a(System.currentTimeMillis());
                c5037bM19173a.m19137b(str);
                c5037bM19173a.m19139c(str2);
                C5045j c5045jMo19898c = this.f18377d.mo19898c();
                c5045jMo19898c.f18379a = c5037bM19173a;
                c5045jMo19898c.f18380b = z;
                c5045jMo19898c.f18381c = false;
                c5045jMo19898c.f18382d = false;
                c5045jMo19898c.f18383e = 0;
                this.f18376c.submit(c5045jMo19898c);
            }
        } catch (Exception e) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f18374a, e.getMessage(), e);
            }
        }
    }

    /* renamed from: a */
    public void m19182a(String str) {
        if (!C5038c.m19168q() || !C5038c.m19167p()) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f18374a, "writeWithParam return because LogCollectorManager.isLogCollectorEnabled(" + C5038c.m19168q() + ") LogCollectorManager.isLogCollectorRegistered(" + C5038c.m19167p() + ")");
                return;
            }
            return;
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f18374a, C5052r.m19199a("Requested writing QOS log message. pageId = ", "2001", " eventId = ", "8100"));
        }
        try {
            C5037b c5037bM19173a = C5040e.m19173a();
            if (c5037bM19173a != null) {
                c5037bM19173a.m19141d(str);
                C5045j c5045jMo19898c = this.f18377d.mo19898c();
                c5045jMo19898c.f18379a = c5037bM19173a;
                c5045jMo19898c.f18380b = false;
                c5045jMo19898c.f18381c = false;
                c5045jMo19898c.f18382d = true;
                c5045jMo19898c.f18383e = 0;
                this.f18376c.submit(c5045jMo19898c);
            }
        } catch (Exception e) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f18374a, e.getMessage(), e);
            }
        }
    }

    /* renamed from: a */
    public void m19186a(String str, String str2, boolean z, int i) {
        if (!C5038c.m19168q() || !C5038c.m19167p()) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f18374a, "writeWithParam return because LogCollectorManager.isLogCollectorEnabled(" + C5038c.m19168q() + ") LogCollectorManager.isLogCollectorRegistered(" + C5038c.m19167p() + ")");
                return;
            }
            return;
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f18374a, C5052r.m19199a("Requested writing log message. pageId = ", str, " eventId = ", str2));
        }
        try {
            C5037b c5037bM19173a = C5040e.m19173a();
            if (c5037bM19173a != null) {
                new Date(C5034k.m19090a());
                new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
                c5037bM19173a.m19134a(System.currentTimeMillis());
                c5037bM19173a.m19137b(str);
                c5037bM19173a.m19139c(str2);
                C5045j c5045jMo19898c = this.f18377d.mo19898c();
                c5045jMo19898c.f18379a = c5037bM19173a;
                c5045jMo19898c.f18380b = z;
                c5045jMo19898c.f18381c = false;
                c5045jMo19898c.f18382d = false;
                c5045jMo19898c.f18383e = i;
                this.f18376c.submit(c5045jMo19898c);
            }
        } catch (Exception e) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f18374a, e.getMessage(), e);
            }
        }
    }

    /* renamed from: a */
    public void m19184a(String str, String str2, JSONObject jSONObject, boolean z) {
        if (!C5038c.m19168q() || !C5038c.m19167p()) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f18374a, "writeWithParam return because LogCollectorManager.isLogCollectorEnabled(" + C5038c.m19168q() + ") LogCollectorManager.isLogCollectorRegistered(" + C5038c.m19167p() + ")");
                return;
            }
            return;
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f18374a, C5052r.m19199a("Requested writing log message. pageId = ", str, " eventId = ", str2));
        }
        try {
            C5037b c5037bM19173a = C5040e.m19173a();
            if (c5037bM19173a != null) {
                new Date(C5034k.m19090a());
                new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
                c5037bM19173a.m19134a(System.currentTimeMillis());
                c5037bM19173a.m19137b(str);
                c5037bM19173a.m19139c(str2);
                c5037bM19173a.m19135a(jSONObject);
                C5045j c5045jMo19898c = this.f18377d.mo19898c();
                c5045jMo19898c.f18382d = false;
                c5045jMo19898c.f18379a = c5037bM19173a;
                c5045jMo19898c.f18380b = z;
                c5045jMo19898c.f18381c = false;
                c5045jMo19898c.f18383e = 0;
                this.f18376c.submit(c5045jMo19898c);
            }
        } catch (Exception e) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f18374a, e.getMessage(), e);
            }
        }
    }

    /* renamed from: a */
    public void m19183a(String str, String str2) {
        if (!C5038c.m19168q() || !C5038c.m19167p()) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f18374a, "writeWithParam return because LogCollectorManager.isLogCollectorEnabled(" + C5038c.m19168q() + ") LogCollectorManager.isLogCollectorRegistered(" + C5038c.m19167p() + ")");
                return;
            }
            return;
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f18374a, C5052r.m19199a("Requested writing log message. pageId = ", str, " eventId = ", str2));
        }
        try {
            C5037b c5037bM19173a = C5040e.m19173a();
            if (c5037bM19173a != null) {
                new Date(C5034k.m19090a());
                new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
                c5037bM19173a.m19134a(System.currentTimeMillis());
                c5037bM19173a.m19137b(str);
                c5037bM19173a.m19139c(str2);
                C5045j c5045jMo19898c = this.f18377d.mo19898c();
                c5045jMo19898c.f18379a = c5037bM19173a;
                c5045jMo19898c.f18380b = false;
                c5045jMo19898c.f18381c = true;
                c5045jMo19898c.f18382d = false;
                c5045jMo19898c.f18383e = 0;
                this.f18376c.submit(c5045jMo19898c);
            }
        } catch (Exception e) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f18374a, e.getMessage(), e);
            }
        }
    }
}
