package com.sec.chaton.p013a;

import android.os.Handler;
import com.sec.chaton.p013a.p014a.C0126ab;
import com.sec.chaton.p013a.p014a.C0139ao;
import com.sec.chaton.p013a.p014a.C0150az;
import com.sec.chaton.p013a.p014a.C0159bh;
import com.sec.chaton.p013a.p014a.C0161bj;
import com.sec.chaton.p013a.p014a.C0162bk;
import com.sec.chaton.p013a.p014a.C0165d;
import com.sec.chaton.p013a.p014a.C0169h;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.C0512s;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.p033io.entry.GetBuddyList;
import com.sec.chaton.p033io.entry.GetRecommendeeList;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.EnumC1333h;
import java.util.concurrent.BlockingQueue;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: ContactControl.java */
/* renamed from: com.sec.chaton.a.ao */
/* loaded from: classes.dex */
public class C0202ao {

    /* renamed from: a */
    private Handler f499a;

    public C0202ao(Handler handler) {
        this.f499a = handler;
    }

    /* renamed from: a */
    public void m760a(String str) {
        m755a(str, false);
    }

    /* renamed from: a */
    public int m755a(String str, boolean z) {
        C0162bk c0162bk = new C0162bk(this.f499a, new C0519z(EnumC1333h.CONTACT, "/address").m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a(RtspHeaders.Values.MODE, str).m2580a(302).m2581a(EnumC0511r.POST).m2579a());
        if (z) {
            c0162bk.m687e();
            return c0162bk.m700b();
        }
        C0512s.m2577a().offer(c0162bk);
        return -1;
    }

    /* renamed from: a */
    public void m757a() {
        m762a(false);
    }

    /* renamed from: a */
    public void m762a(boolean z) {
        C0519z c0519zM2582a = new C0519z(EnumC1333h.CONTACT, "/v3/buddies").m2581a(EnumC0511r.GET).m2580a(301).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("timestamp", String.valueOf(Long.valueOf(C1323bs.m4575a().getLong("get_all_buddies_timestamp", 0L)))).m2584a(RtspHeaders.Values.MODE, "blocked").m2582a(GetBuddyList.class);
        if (z) {
            new C0150az(this.f499a, c0519zM2582a.m2579a()).m687e();
        } else {
            C0512s.m2577a().offer(new C0150az(this.f499a, c0519zM2582a.m2579a()));
        }
    }

    /* renamed from: b */
    public void m764b(String str) {
        m765b(str, true);
    }

    /* renamed from: b */
    public void m765b(String str, boolean z) {
        C0519z c0519zM2582a = new C0519z(EnumC1333h.CONTACT, "/v3/buddy").m2581a(EnumC0511r.POST).m2580a(303).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a(RtspHeaders.Values.MODE, "call").m2582a(GetBuddyList.class);
        BlockingQueue blockingQueueM2577a = C0512s.m2577a();
        Handler handler = this.f499a;
        C0503j c0503jM2579a = c0519zM2582a.m2579a();
        if (z) {
            str = "+" + str;
        }
        blockingQueueM2577a.offer(new C0169h(handler, c0503jM2579a, str));
    }

    /* renamed from: c */
    public void m767c(String str, boolean z) {
        C0519z c0519zM2582a = new C0519z(EnumC1333h.CONTACT, "/v3/buddy").m2581a(EnumC0511r.POST).m2580a(307).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a(RtspHeaders.Values.MODE, "preview").m2582a(GetBuddyList.class);
        BlockingQueue blockingQueueM2577a = C0512s.m2577a();
        Handler handler = this.f499a;
        C0503j c0503jM2579a = c0519zM2582a.m2579a();
        if (z) {
            str = "+" + str;
        }
        blockingQueueM2577a.offer(new C0161bj(handler, c0503jM2579a, str));
    }

    /* renamed from: b */
    public void m766b(boolean z) {
        m769d("phonenumber", z);
    }

    /* renamed from: d */
    public void m769d(String str, boolean z) {
        C0512s.m2577a().offer(new C0139ao(this.f499a, new C0519z(EnumC1333h.CONTACT, "/privacy").m2581a(EnumC0511r.POST).m2580a(304).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2579a(), str, z));
    }

    /* renamed from: c */
    public void m768c(boolean z) {
        if (C0159bh.m690b()) {
            m761a((String) null, 0, z);
        }
    }

    /* renamed from: a */
    public void m761a(String str, int i, boolean z) {
        C0159bh c0159bh = new C0159bh(this.f499a, new C0519z(EnumC1333h.CONTACT, "/extra/info").m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2580a(305).m2581a(EnumC0511r.POST).m2579a(), str, i);
        if (z) {
            c0159bh.m687e();
        } else {
            C0512s.m2577a().offer(c0159bh);
        }
    }

    /* renamed from: a */
    public void m759a(int i, String[] strArr, int[] iArr, boolean z) {
        C0159bh c0159bh = new C0159bh(this.f499a, new C0519z(EnumC1333h.CONTACT, "/extra/info").m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2580a(305).m2581a(EnumC0511r.POST).m2579a(), i, strArr, iArr);
        if (z) {
            c0159bh.m687e();
        } else {
            C0512s.m2577a().offer(c0159bh);
        }
    }

    /* renamed from: e */
    public int m770e(String str, boolean z) {
        return m756a(str, z, -1);
    }

    /* renamed from: a */
    public int m756a(String str, boolean z, int i) {
        C0519z c0519zM2582a = new C0519z(EnumC1333h.CONTACT, "/check/" + str).m2581a(EnumC0511r.GET).m2580a(306).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2582a(GetBuddyList.class);
        if (z) {
            c0519zM2582a.m2585b(i);
        }
        C0126ab c0126ab = new C0126ab(this.f499a, c0519zM2582a.m2579a());
        if (z) {
            c0126ab.m687e();
            return c0126ab.m672b();
        }
        C0512s.m2577a().offer(c0126ab);
        return 0;
    }

    /* renamed from: b */
    public void m763b() {
        m758a(-1, -1);
    }

    /* renamed from: a */
    public void m758a(int i, int i2) {
        C0519z c0519zM2582a = new C0519z(EnumC1333h.CONTACT, "/buddyrecommendeelist").m2581a(EnumC0511r.GET).m2580a(301).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2582a(GetRecommendeeList.class);
        if (i >= 0) {
            c0519zM2582a.m2584a("startidx", String.valueOf(i));
        }
        if (i2 >= 0) {
            c0519zM2582a.m2584a("count", String.valueOf(i2));
        }
        C0512s.m2577a().offer(new C0165d(this.f499a, c0519zM2582a.m2579a()));
    }
}
