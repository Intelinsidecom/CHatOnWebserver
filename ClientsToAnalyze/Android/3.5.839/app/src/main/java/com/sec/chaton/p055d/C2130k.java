package com.sec.chaton.p055d;

import android.os.Handler;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.C1902ab;
import com.sec.chaton.p055d.p056a.C1903ac;
import com.sec.chaton.p055d.p056a.C1904ad;
import com.sec.chaton.p055d.p056a.C1905ae;
import com.sec.chaton.p055d.p056a.C1906af;
import com.sec.chaton.p065io.entry.inner.CoverStory;
import com.sec.chaton.p065io.entry.inner.CoverStoryAdd;
import com.sec.chaton.p065io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p065io.entry.inner.CoverStorySampleList;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import java.util.concurrent.Future;

/* compiled from: CoverStoryControl.java */
/* renamed from: com.sec.chaton.d.k */
/* loaded from: classes.dex */
public class C2130k {

    /* renamed from: a */
    public static int f7727a = 1;

    /* renamed from: b */
    private Handler f7728b;

    /* renamed from: c */
    private Future<C0778b> f7729c = null;

    /* renamed from: d */
    private Future<C0778b> f7730d;

    /* renamed from: e */
    private Future<C0778b> f7731e;

    /* renamed from: f */
    private Future<C0778b> f7732f;

    /* renamed from: g */
    private Future<C0778b> f7733g;

    /* renamed from: h */
    private Future<C0778b> f7734h;

    public C2130k(Handler handler) {
        this.f7728b = handler;
    }

    /* renamed from: a */
    public void m9537a() {
        if (this.f7729c != null) {
            if (C4904y.f17871a) {
                C4904y.m18646e("getMyCoverStoryCancel() is called", "CoverstoryControl");
            }
            this.f7729c.cancel(true);
        }
    }

    /* renamed from: a */
    public void m9538a(String str) {
        this.f7729c = C2472w.m10687a().m10691c().m10662a(new C1904ad(new C2456g(EnumC4868cf.CONTACT, "/coverstory/get").m10637a(EnumC2457h.GET).m10641a("buddyid", str).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10643b(C2407b.class).m10639a(CoverStory.class).m10635a(), str), 3001, this.f7728b);
    }

    /* renamed from: b */
    public void m9541b() {
        if (this.f7729c != null) {
            if (C4904y.f17871a) {
                C4904y.m18646e("mGetCoverStoryTask() is called", "CoverstoryControl");
            }
            this.f7729c.cancel(true);
        }
    }

    /* renamed from: a */
    public void m9539a(String str, String str2) {
        this.f7730d = C2472w.m10687a().m10691c().m10662a(new C1902ab(new C2456g(EnumC4868cf.CONTACT, "/coverstory/add").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "returninfo").m10643b(C2407b.class).m10639a(CoverStoryAdd.class).m10635a(), "returninfo", str, str2), 3002, this.f7728b);
    }

    /* renamed from: c */
    public void m9544c() {
        this.f7731e = C2472w.m10687a().m10691c().m10662a(new C1906af(new C2456g(EnumC4868cf.CONTACT, "/contents/coverstory").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("timestamp", String.valueOf(C4809aa.m18104a().m18118a("get_coverstory_sample_timestamp", 0L))).m10641a("thwidth", "130").m10641a("thheight", "130").m10643b(C2407b.class).m10639a(CoverStorySampleList.class).m10635a()), 3004, this.f7728b);
    }

    /* renamed from: d */
    public void m9545d() {
        if (this.f7731e != null) {
            if (C4904y.f17871a) {
                C4904y.m18646e("listCoverStoryCancel() is called", "CoverstoryControl");
            }
            this.f7731e.cancel(true);
        }
    }

    /* renamed from: a */
    public void m9540a(String str, String str2, String str3) {
        C4904y.m18646e("downloadCoverStory() itemId : " + str + " ## width : " + str2 + " ## height : " + str3, "CoverstoryControl");
        this.f7732f = C2472w.m10687a().m10691c().m10662a(new C1903ac(new C2456g(EnumC4868cf.CONTACT, "/contents/coverstory/download").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("id", str).m10641a("width", str2).m10641a("height", str3).m10643b(C2407b.class).m10639a(CoverStoryDownload.class).m10635a()), 3005, this.f7728b);
    }

    /* renamed from: e */
    public void m9546e() {
        if (this.f7732f != null) {
            if (C4904y.f17871a) {
                C4904y.m18646e("downloadCoverStoryCancel() is called", "CoverstoryControl");
            }
            this.f7732f.cancel(true);
        }
    }

    /* renamed from: b */
    public void m9542b(String str) {
        C4904y.m18646e(" addSampleCoverStory() is called [contentid] :" + str, "CoverstoryControl");
        this.f7733g = C2472w.m10687a().m10691c().m10662a(new C1905ae(new C2456g(EnumC4868cf.CONTACT, "/coverstory/add").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "returninfo").m10643b(C2407b.class).m10639a(CoverStoryAdd.class).m10635a(), str), 3002, this.f7728b);
    }

    /* renamed from: f */
    public void m9547f() {
        if (this.f7733g != null) {
            if (C4904y.f17871a) {
                C4904y.m18646e("addSampleCoverStoryCancel() is called", "CoverstoryControl");
            }
            this.f7733g.cancel(true);
        }
    }

    /* renamed from: b */
    public void m9543b(String str, String str2) {
        C4904y.m18646e("downloadRandomCoverStory() is called  ## width : " + str + " ## height : " + str2, "CoverstoryControl");
        this.f7734h = C2472w.m10687a().m10691c().m10662a(new C1903ac(new C2456g(EnumC4868cf.CONTACT, "/contents/coverstory/download-random").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("width", str).m10641a("height", str2).m10643b(C2407b.class).m10639a(CoverStoryDownload.class).m10635a()), 3006, this.f7728b);
    }

    /* renamed from: g */
    public void m9548g() {
        if (this.f7734h != null) {
            if (C4904y.f17871a) {
                C4904y.m18646e("downloadRandomCoverStoryCancel() is called", "CoverstoryControl");
            }
            this.f7734h.cancel(true);
        }
    }
}
