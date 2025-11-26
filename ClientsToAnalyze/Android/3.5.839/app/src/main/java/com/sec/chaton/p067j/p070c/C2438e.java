package com.sec.chaton.p067j.p070c;

import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.msgsend.C2684ab;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: FileUploadManager.java */
/* renamed from: com.sec.chaton.j.c.e */
/* loaded from: classes.dex */
public class C2438e {

    /* renamed from: a */
    private static final String f8730a = C2438e.class.getSimpleName();

    /* renamed from: c */
    private static C2438e f8731c = null;

    /* renamed from: b */
    private Map<Long, C2439f> f8732b = new ConcurrentHashMap();

    /* renamed from: a */
    public static synchronized C2438e m10572a() {
        if (f8731c == null) {
            f8731c = new C2438e();
        }
        return f8731c;
    }

    /* renamed from: a */
    public RunnableC2440g m10573a(long j) {
        C2439f c2439f = this.f8732b.get(Long.valueOf(j));
        if (c2439f == null) {
            return null;
        }
        return c2439f.m10584b();
    }

    /* renamed from: a */
    public RunnableC2440g m10574a(Handler handler, File file, EnumC2214ab enumC2214ab, Handler handler2) {
        RunnableC2440g runnableC2440g = new RunnableC2440g();
        runnableC2440g.m10594a(handler, file, enumC2214ab, handler2);
        new Thread(runnableC2440g).start();
        return runnableC2440g;
    }

    /* renamed from: a */
    public boolean m10578a(RunnableC2440g runnableC2440g) {
        if (runnableC2440g == null) {
            return false;
        }
        runnableC2440g.m10596a(true);
        runnableC2440g.m10593a((Handler) null);
        return true;
    }

    /* renamed from: a */
    public void m10575a(Handler handler, String str, File file, long j, String str2, EnumC2300t enumC2300t, EnumC2214ab enumC2214ab, String str3, String[] strArr, String str4, boolean z, String str5, String str6, EnumC2706n enumC2706n) {
        m10576a(handler, str, file, j, str2, enumC2300t, enumC2214ab, str3, strArr, str4, z, str5, str6, true, enumC2706n);
    }

    /* renamed from: a */
    public void m10576a(Handler handler, String str, File file, long j, String str2, EnumC2300t enumC2300t, EnumC2214ab enumC2214ab, String str3, String[] strArr, String str4, boolean z, String str5, String str6, boolean z2, EnumC2706n enumC2706n) {
        RunnableC2440g runnableC2440g = new RunnableC2440g();
        runnableC2440g.m10595a(handler, str, file, j, str2, enumC2300t, enumC2214ab, str3, strArr, str4, z, str5, str6, enumC2706n);
        this.f8732b.put(Long.valueOf(j), new C2439f(this, str2, runnableC2440g, z2));
        new Thread(runnableC2440g).start();
    }

    /* renamed from: a */
    public void m10577a(String str, long j) {
        C2684ab.m11290a(f8730a, "cancel upload file inbox(%s), msgId(%d)", str, Long.valueOf(j));
        if (this.f8732b.containsKey(Long.valueOf(j))) {
            this.f8732b.get(Long.valueOf(j)).m10584b().m10596a(true);
        }
    }

    /* renamed from: a */
    public boolean m10579a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f8732b.size() == 0) {
            return true;
        }
        for (Map.Entry<Long, C2439f> entry : this.f8732b.entrySet()) {
            C2439f value = entry.getValue();
            if (value != null && str.equals(value.m10583a())) {
                value.m10584b().m10596a(false);
                this.f8732b.remove(entry.getKey());
            }
        }
        return true;
    }

    /* renamed from: b */
    public boolean m10580b() {
        RunnableC2440g runnableC2440gM10584b;
        if (this.f8732b.size() != 0) {
            Iterator<Map.Entry<Long, C2439f>> it = this.f8732b.entrySet().iterator();
            while (it.hasNext()) {
                C2439f value = it.next().getValue();
                if (value != null && (runnableC2440gM10584b = value.m10584b()) != null) {
                    runnableC2440gM10584b.m10596a(false);
                }
            }
        }
        return true;
    }

    /* renamed from: b */
    public boolean m10581b(long j) {
        C2439f c2439f;
        if (this.f8732b.size() != 0 && this.f8732b.containsKey(Long.valueOf(j)) && (c2439f = this.f8732b.get(Long.valueOf(j))) != null) {
            return c2439f.m10585c();
        }
        return false;
    }

    /* renamed from: c */
    public boolean m10582c(long j) {
        return (this.f8732b.size() != 0 && this.f8732b.containsKey(Long.valueOf(j)) && this.f8732b.remove(Long.valueOf(j)) == null) ? false : true;
    }
}
