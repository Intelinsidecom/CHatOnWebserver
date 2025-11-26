package com.sec.chaton.event;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.p035io.entry.EventPageEntry;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3219cg;

/* compiled from: EventPageControl.java */
/* renamed from: com.sec.chaton.event.e */
/* loaded from: classes.dex */
public class C1463e {

    /* renamed from: a */
    private static final String f5440a = C1463e.class.getSimpleName();

    /* renamed from: b */
    private Handler f5441b;

    public C1463e(Context context, Handler handler) {
        this.f5441b = handler;
    }

    /* renamed from: a */
    public C1465g m6383a() {
        return m6384a(0, 0);
    }

    /* renamed from: a */
    public C1465g m6384a(int i, int i2) {
        C1465g c1465g = new C1465g(this.f5441b, new C1582j(EnumC3219cg.CONTACT, "/promotion/event/banner").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("iso2", C3171am.m11082t()).m6714a("startidx", String.valueOf(i)).m6714a("count", String.valueOf(i2)).m6709a(1200).m6712a(EventPageEntry.class).m6717b(C1537b.class).m6708a());
        C1595w.m6742a().m6745b().m6723a(c1465g);
        return c1465g;
    }

    /* renamed from: b */
    public synchronized void m6386b() {
        if (!C1464f.m6398e()) {
            C3250y.m11450b("image not downloaded yet", f5440a);
            String strM6404k = C1464f.m6404k();
            if (strM6404k != null) {
                m6385a(strM6404k);
            }
        }
    }

    /* renamed from: a */
    public void m6385a(String str) {
        C1459a.m6382a(str, this.f5441b);
    }
}
