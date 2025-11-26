package com.sec.chaton.p018c.p019a;

import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0635o;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: FileUploadManager.java */
/* renamed from: com.sec.chaton.c.a.e */
/* loaded from: classes.dex */
public class C0468e {

    /* renamed from: b */
    private static C0468e f1489b = null;

    /* renamed from: a */
    private Map f1490a = new HashMap();

    /* renamed from: a */
    public static synchronized C0468e m2389a() {
        if (f1489b == null) {
            f1489b = new C0468e();
        }
        return f1489b;
    }

    /* renamed from: a */
    public RunnableC0474k m2390a(long j) {
        C0464a c0464a = (C0464a) this.f1490a.get(Long.valueOf(j));
        if (c0464a == null) {
            return null;
        }
        return c0464a.m2382b();
    }

    /* renamed from: a */
    public void m2391a(Handler handler, String str, File file, long j, String str2, EnumC0665r enumC0665r, EnumC0651d enumC0651d, String[] strArr, String str3, boolean z) {
        RunnableC0474k runnableC0474k = new RunnableC0474k();
        runnableC0474k.m2425a(handler, str, file, j, str2, enumC0665r, enumC0651d, strArr, str3, z);
        this.f1490a.put(Long.valueOf(j), new C0464a(this, str2, runnableC0474k));
        new Thread(runnableC0474k).start();
    }

    /* renamed from: b */
    public void m2393b(long j) {
        if (this.f1490a.containsKey(Long.valueOf(j))) {
            ((C0464a) this.f1490a.get(Long.valueOf(j))).m2382b().m2433i();
        }
        C0635o.m2919a(GlobalApplication.m3100a().getContentResolver(), Long.valueOf(j));
    }

    /* renamed from: a */
    public boolean m2392a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f1490a.size() == 0) {
            return true;
        }
        for (Long l : this.f1490a.keySet()) {
            C0464a c0464a = (C0464a) this.f1490a.get(l);
            if (c0464a != null && str.equals(c0464a.m2381a())) {
                c0464a.m2382b().m2433i();
                this.f1490a.remove(l);
            }
        }
        return true;
    }

    /* renamed from: b */
    public boolean m2394b() {
        RunnableC0474k runnableC0474kM2382b;
        if (this.f1490a.size() != 0) {
            Iterator it = this.f1490a.keySet().iterator();
            while (it.hasNext()) {
                C0464a c0464a = (C0464a) this.f1490a.get((Long) it.next());
                if (c0464a != null && (runnableC0474kM2382b = c0464a.m2382b()) != null) {
                    runnableC0474kM2382b.m2433i();
                }
            }
        }
        return true;
    }

    /* renamed from: c */
    public boolean m2395c(long j) {
        return (this.f1490a.size() != 0 && this.f1490a.containsKey(Long.valueOf(j)) && ((C0464a) this.f1490a.remove(Long.valueOf(j))) == null) ? false : true;
    }
}
