package com.sec.chaton.p025d;

import android.os.Handler;
import com.sec.chaton.p025d.p026a.C1151af;
import com.sec.chaton.p025d.p026a.C1152ag;
import com.sec.chaton.p025d.p026a.C1153ah;
import com.sec.chaton.p025d.p026a.C1154ai;
import com.sec.chaton.p025d.p026a.C1155aj;
import com.sec.chaton.p035io.entry.inner.CoverStory;
import com.sec.chaton.p035io.entry.inner.CoverStoryAdd;
import com.sec.chaton.p035io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p035io.entry.inner.CoverStorySampleList;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3219cg;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: CoverStoryControl.java */
/* renamed from: com.sec.chaton.d.i */
/* loaded from: classes.dex */
public class C1331i {

    /* renamed from: a */
    public static int f5023a = 1;

    /* renamed from: b */
    private Handler f5024b;

    /* renamed from: c */
    private C1153ah f5025c = null;

    /* renamed from: d */
    private C1151af f5026d;

    /* renamed from: e */
    private C1155aj f5027e;

    /* renamed from: f */
    private C1152ag f5028f;

    /* renamed from: g */
    private C1154ai f5029g;

    /* renamed from: h */
    private C1152ag f5030h;

    public C1331i(Handler handler) {
        this.f5024b = handler;
    }

    /* renamed from: a */
    public void m5757a() {
        this.f5025c = new C1153ah(this.f5024b, new C1582j(EnumC3219cg.CONTACT, "/coverstory/get").m6710a(EnumC1583k.GET).m6709a(3001).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6717b(C1537b.class).m6712a(CoverStory.class).m6708a());
        C1595w.m6742a().m6746c().m6723a(this.f5025c);
    }

    /* renamed from: b */
    public void m5761b() {
        if (this.f5025c != null) {
            if (C3250y.f11733a) {
                C3250y.m11456e("getMyCoverStoryCancel() is called", "CoverstoryControl");
            }
            this.f5025c.m5493c();
        }
    }

    /* renamed from: a */
    public void m5758a(String str) {
        this.f5025c = new C1153ah(this.f5024b, new C1582j(EnumC3219cg.CONTACT, "/coverstory/get").m6710a(EnumC1583k.GET).m6709a(3001).m6714a("buddyid", str).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6717b(C1537b.class).m6712a(CoverStory.class).m6708a(), str);
        C1595w.m6742a().m6746c().m6723a(this.f5025c);
    }

    /* renamed from: c */
    public void m5764c() {
        if (this.f5025c != null) {
            if (C3250y.f11733a) {
                C3250y.m11456e("mGetCoverStoryTask() is called", "CoverstoryControl");
            }
            this.f5025c.m5493c();
        }
    }

    /* renamed from: a */
    public void m5759a(String str, String str2) {
        this.f5026d = new C1151af(this.f5024b, new C1582j(EnumC3219cg.CONTACT, "/coverstory/add").m6710a(EnumC1583k.POST).m6709a(3002).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, "returninfo").m6717b(C1537b.class).m6712a(CoverStoryAdd.class).m6708a(), "returninfo", str, str2);
        C1595w.m6742a().m6746c().m6723a(this.f5026d);
    }

    /* renamed from: d */
    public void m5765d() {
        this.f5027e = new C1155aj(this.f5024b, new C1582j(EnumC3219cg.CONTACT, "/contents/coverstory").m6710a(EnumC1583k.GET).m6709a(3004).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("timestamp", String.valueOf(C3159aa.m10962a().m10976a("get_coverstory_sample_timestamp", 0L))).m6714a("thwidth", "130").m6714a("thheight", "130").m6717b(C1537b.class).m6712a(CoverStorySampleList.class).m6708a());
        C1595w.m6742a().m6746c().m6723a(this.f5027e);
    }

    /* renamed from: a */
    public void m5760a(String str, String str2, String str3) {
        C3250y.m11456e(" Kmission downloadCoverStory() itemId : " + str + " ## width : " + str2 + " ## height : " + str3, "CoverstoryControl");
        this.f5028f = new C1152ag(this.f5024b, new C1582j(EnumC3219cg.CONTACT, "/contents/coverstory/download").m6710a(EnumC1583k.GET).m6709a(3005).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("id", str).m6714a("width", str2).m6714a("height", str3).m6717b(C1537b.class).m6712a(CoverStoryDownload.class).m6708a());
        C1595w.m6742a().m6746c().m6723a(this.f5028f);
    }

    /* renamed from: e */
    public void m5766e() {
        if (this.f5028f != null) {
            if (C3250y.f11733a) {
                C3250y.m11456e("downloadCoverStoryCancel() is called", "CoverstoryControl");
            }
            this.f5028f.m5493c();
        }
    }

    /* renamed from: b */
    public void m5762b(String str) {
        C3250y.m11456e(" addSampleCoverStory() is called [contentid] :" + str, "CoverstoryControl");
        this.f5029g = new C1154ai(this.f5024b, new C1582j(EnumC3219cg.CONTACT, "/coverstory/add").m6710a(EnumC1583k.POST).m6709a(3002).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, "returninfo").m6717b(C1537b.class).m6712a(CoverStoryAdd.class).m6708a(), str);
        C1595w.m6742a().m6746c().m6723a(this.f5029g);
    }

    /* renamed from: b */
    public void m5763b(String str, String str2) {
        C3250y.m11456e("downloadRandomCoverStory() is called  ## width : " + str + " ## height : " + str2, "CoverstoryControl");
        this.f5030h = new C1152ag(this.f5024b, new C1582j(EnumC3219cg.CONTACT, "/contents/coverstory/download-random").m6710a(EnumC1583k.GET).m6709a(3006).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("width", str).m6714a("height", str2).m6717b(C1537b.class).m6712a(CoverStoryDownload.class).m6708a());
        C1595w.m6742a().m6746c().m6723a(this.f5030h);
    }
}
