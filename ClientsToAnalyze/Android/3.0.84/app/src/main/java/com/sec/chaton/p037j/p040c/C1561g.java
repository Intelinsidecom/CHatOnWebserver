package com.sec.chaton.p037j.p040c;

import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.msgsend.C1756p;
import com.sec.chaton.msgsend.C1759s;
import com.sec.chaton.msgsend.EnumC1741aa;
import com.sec.chaton.msgsend.EnumC1751k;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: FileUploadManager.java */
/* renamed from: com.sec.chaton.j.c.g */
/* loaded from: classes.dex */
public class C1561g {

    /* renamed from: a */
    private static final String f5786a = C1561g.class.getSimpleName();

    /* renamed from: c */
    private static C1561g f5787c = null;

    /* renamed from: b */
    private Map<Long, C1562h> f5788b = new ConcurrentHashMap();

    /* renamed from: a */
    public static synchronized C1561g m6628a() {
        if (f5787c == null) {
            f5787c = new C1561g();
        }
        return f5787c;
    }

    /* renamed from: a */
    public RunnableC1563i m6629a(long j) {
        C1562h c1562h = this.f5788b.get(Long.valueOf(j));
        if (c1562h == null) {
            return null;
        }
        return c1562h.m6640b();
    }

    /* renamed from: a */
    public RunnableC1563i m6630a(Handler handler, File file, EnumC1455w enumC1455w, Handler handler2) {
        RunnableC1563i runnableC1563i = new RunnableC1563i();
        runnableC1563i.m6650a(handler, file, enumC1455w, handler2);
        new Thread(runnableC1563i).start();
        return runnableC1563i;
    }

    /* renamed from: a */
    public boolean m6634a(RunnableC1563i runnableC1563i) {
        if (runnableC1563i == null) {
            return false;
        }
        runnableC1563i.m6652a(true);
        runnableC1563i.m6649a((Handler) null);
        return true;
    }

    /* renamed from: a */
    public void m6631a(Handler handler, String str, File file, long j, String str2, EnumC1450r enumC1450r, EnumC1455w enumC1455w, String str3, String[] strArr, String str4, boolean z, String str5, String str6, EnumC1751k enumC1751k) {
        m6632a(handler, str, file, j, str2, enumC1450r, enumC1455w, str3, strArr, str4, z, str5, str6, true, enumC1751k);
    }

    /* renamed from: a */
    public void m6632a(Handler handler, String str, File file, long j, String str2, EnumC1450r enumC1450r, EnumC1455w enumC1455w, String str3, String[] strArr, String str4, boolean z, String str5, String str6, boolean z2, EnumC1751k enumC1751k) {
        RunnableC1563i runnableC1563i = new RunnableC1563i();
        runnableC1563i.m6651a(handler, str, file, j, str2, enumC1450r, enumC1455w, str3, strArr, str4, z, str5, str6, enumC1751k);
        this.f5788b.put(Long.valueOf(j), new C1562h(this, str2, runnableC1563i, z2));
        new Thread(runnableC1563i).start();
    }

    /* renamed from: a */
    public void m6633a(String str, long j) {
        C1759s.m7260a(f5786a, "cancel upload file inbox(%s), msgId(%d)", str, Long.valueOf(j));
        if (this.f5788b.containsKey(Long.valueOf(j))) {
            this.f5788b.get(Long.valueOf(j)).m6640b().m6652a(true);
        }
        C1373q.m6187b(CommonApplication.m11493l().getContentResolver(), Long.valueOf(j));
        C1756p.m7232a(str, j, EnumC1741aa.FAILED);
    }

    /* renamed from: a */
    public boolean m6635a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f5788b.size() == 0) {
            return true;
        }
        for (Map.Entry<Long, C1562h> entry : this.f5788b.entrySet()) {
            C1562h value = entry.getValue();
            if (value != null && str.equals(value.m6639a())) {
                value.m6640b().m6652a(false);
                this.f5788b.remove(entry.getKey());
            }
        }
        return true;
    }

    /* renamed from: b */
    public boolean m6636b() {
        RunnableC1563i runnableC1563iM6640b;
        if (this.f5788b.size() != 0) {
            Iterator<Map.Entry<Long, C1562h>> it = this.f5788b.entrySet().iterator();
            while (it.hasNext()) {
                C1562h value = it.next().getValue();
                if (value != null && (runnableC1563iM6640b = value.m6640b()) != null) {
                    runnableC1563iM6640b.m6652a(false);
                }
            }
        }
        return true;
    }

    /* renamed from: b */
    public boolean m6637b(long j) {
        C1562h c1562h;
        if (this.f5788b.size() != 0 && this.f5788b.containsKey(Long.valueOf(j)) && (c1562h = this.f5788b.get(Long.valueOf(j))) != null) {
            return c1562h.m6641c();
        }
        return false;
    }

    /* renamed from: c */
    public boolean m6638c(long j) {
        return (this.f5788b.size() != 0 && this.f5788b.containsKey(Long.valueOf(j)) && this.f5788b.remove(Long.valueOf(j)) == null) ? false : true;
    }
}
