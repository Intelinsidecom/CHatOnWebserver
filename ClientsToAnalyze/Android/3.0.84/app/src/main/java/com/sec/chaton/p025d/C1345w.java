package com.sec.chaton.p025d;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0276m;
import com.sec.chaton.p025d.p026a.C1160ao;
import com.sec.chaton.p025d.p026a.C1184bl;
import com.sec.chaton.p025d.p026a.C1185bm;
import com.sec.chaton.p025d.p026a.C1204ce;
import com.sec.chaton.p025d.p026a.C1205cf;
import com.sec.chaton.p025d.p026a.C1214co;
import com.sec.chaton.p025d.p026a.C1258ee;
import com.sec.chaton.p025d.p026a.C1261eh;
import com.sec.chaton.p025d.p026a.C1262ei;
import com.sec.chaton.p035io.entry.GetProfileImageList;
import com.sec.chaton.p035io.entry.inner.BuddyMappingInfo;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3219cg;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: ProfileControl.java */
/* renamed from: com.sec.chaton.d.w */
/* loaded from: classes.dex */
public class C1345w {

    /* renamed from: b */
    private Handler f5075b;

    /* renamed from: d */
    private C1204ce f5077d;

    /* renamed from: e */
    private C1214co f5078e;

    /* renamed from: f */
    private C1185bm f5079f;

    /* renamed from: g */
    private C1184bl f5080g;

    /* renamed from: a */
    private String f5074a = getClass().getName();

    /* renamed from: c */
    private C1205cf f5076c = null;

    public C1345w(Handler handler) {
        this.f5075b = handler;
    }

    /* renamed from: a */
    public void m5928a(C0276m c0276m, String str) {
        C1595w.m6742a().m6745b().m6723a(new C1262ei(this.f5075b, new C1582j(EnumC3219cg.CONTACT, "/profile").m6710a(EnumC1583k.POST).m6709a(HttpResponseCode.UNAUTHORIZED).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6708a(), c0276m, str));
    }

    /* renamed from: a */
    public void m5929a(String str) {
        new AsyncTaskC1346x(this, str).execute(new String[0]);
    }

    /* renamed from: b */
    public void m5933b(String str) {
        new AsyncTaskC1347y(this, str).execute(new String[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012d  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m5936c(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p025d.C1345w.m5936c(java.lang.String):void");
    }

    /* renamed from: a */
    public void m5927a() {
        if (this.f5078e != null) {
            C3250y.m11456e("getUserProfileAllCancel() is called", this.f5074a);
            this.f5078e.m5493c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d6  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m5938d(java.lang.String r9) {
        /*
            r8 = this;
            r2 = 0
            r6 = 0
            if (r9 == 0) goto Lc8
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m11493l()     // Catch: java.lang.Throwable -> Lc9
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> Lc9
            android.database.Cursor r1 = com.sec.chaton.p027e.p028a.C1360d.m6049e(r0, r9)     // Catch: java.lang.Throwable -> Lc9
            if (r1 == 0) goto Ld6
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> Ld1
            if (r0 <= 0) goto Ld6
            r1.moveToFirst()     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r0 = "buddy_updated_timestamp"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r2 = r1.getString(r0)     // Catch: java.lang.Throwable -> Ld1
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Ld1
            if (r0 == 0) goto Ld3
            r3 = 0
            java.lang.Long r0 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> Ld1
            long r3 = r0.longValue()     // Catch: java.lang.Throwable -> Ld1
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 == 0) goto Ld3
            java.lang.String r2 = r0.toString()     // Catch: java.lang.Throwable -> Ld1
            r0 = r2
        L3f:
            if (r1 == 0) goto L44
            r1.close()
        L44:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "/v5/buddy/"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r1 = r1.toString()
            com.sec.chaton.j.j r2 = new com.sec.chaton.j.j
            com.sec.chaton.util.cg r3 = com.sec.chaton.util.EnumC3219cg.CONTACT
            r2.<init>(r3, r1)
            com.sec.chaton.j.k r1 = com.sec.chaton.p037j.EnumC1583k.GET
            com.sec.chaton.j.j r1 = r2.m6710a(r1)
            r2 = 414(0x19e, float:5.8E-43)
            com.sec.chaton.j.j r1 = r1.m6709a(r2)
            java.lang.String r2 = "uid"
            com.sec.chaton.util.ab r3 = com.sec.chaton.util.C3159aa.m10962a()
            java.lang.String r4 = "uid"
            java.lang.String r5 = ""
            java.lang.String r3 = r3.m10979a(r4, r5)
            com.sec.chaton.j.j r1 = r1.m6714a(r2, r3)
            java.lang.String r2 = "imei"
            java.lang.String r3 = com.sec.chaton.util.C3171am.m11045a()
            com.sec.chaton.j.j r1 = r1.m6714a(r2, r3)
            java.lang.String r2 = "timestamp"
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L9c
            com.sec.chaton.util.ab r0 = com.sec.chaton.util.C3159aa.m10962a()
            java.lang.String r3 = "get_all_buddies_timestamp"
            long r3 = r0.m10976a(r3, r6)
            java.lang.String r0 = java.lang.Long.toString(r3)
        L9c:
            com.sec.chaton.j.j r0 = r1.m6714a(r2, r0)
            java.lang.String r1 = "mode"
            java.lang.String r2 = "rtntimestamp"
            com.sec.chaton.j.j r0 = r0.m6714a(r1, r2)
            java.lang.Class<com.sec.chaton.io.entry.inner.BuddyProfileNew> r1 = com.sec.chaton.p035io.entry.inner.BuddyProfileNew.class
            com.sec.chaton.j.j r0 = r0.m6712a(r1)
            com.sec.chaton.d.a.bm r1 = new com.sec.chaton.d.a.bm
            android.os.Handler r2 = r8.f5075b
            com.sec.chaton.j.h r0 = r0.m6708a()
            r1.<init>(r2, r0, r9)
            r8.f5079f = r1
            com.sec.chaton.j.w r0 = com.sec.chaton.p037j.C1595w.m6742a()
            com.sec.chaton.j.l r0 = r0.m6745b()
            com.sec.chaton.d.a.bm r1 = r8.f5079f
            r0.m6723a(r1)
        Lc8:
            return
        Lc9:
            r0 = move-exception
            r1 = r2
        Lcb:
            if (r1 == 0) goto Ld0
            r1.close()
        Ld0:
            throw r0
        Ld1:
            r0 = move-exception
            goto Lcb
        Ld3:
            r0 = r2
            goto L3f
        Ld6:
            r0 = r2
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p025d.C1345w.m5938d(java.lang.String):void");
    }

    /* renamed from: b */
    public void m5932b() {
        if (this.f5079f != null) {
            C3250y.m11456e("getBuddyProfileCancel() is called", "ProfileControl");
            this.f5079f.m5493c();
        }
    }

    /* renamed from: c */
    public void m5935c() {
        String strM10979a = C3159aa.m10962a().m10979a("uid", "");
        C1595w.m6742a().m6745b().m6723a(new C1261eh(this.f5075b, new C1582j(EnumC3219cg.CONTACT, "/profile/historyimage/add").m6710a(EnumC1583k.POST).m6709a(HttpResponseCode.NOT_FOUND).m6714a("uid", strM10979a).m6714a(RtspHeaders.Values.MODE, "returnlist").m6714a("imei", C3171am.m11045a()).m6714a("count", "250").m6717b(C1537b.class).m6712a(GetProfileImageList.class).m6708a(), "/file/" + strM10979a + "/" + (C3159aa.m10962a().m10979a("profile_image_timestamp", "") + "_profileImage.jpg"), "image/jpeg"));
    }

    /* renamed from: a */
    public void m5931a(String str, boolean z) {
        C1595w.m6742a().m6745b().m6723a(new C1160ao(this.f5075b, new C1582j(EnumC3219cg.CONTACT, "/profile/historyimage/del").m6710a(EnumC1583k.GET).m6709a(405).m6714a(RtspHeaders.Values.MODE, "returnlist").m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("profileimageid", str).m6714a("count", "250").m6717b(C1537b.class).m6712a(GetProfileImageList.class).m6708a(), str, z));
    }

    /* renamed from: e */
    public void m5940e(String str) {
        C1595w.m6742a().m6745b().m6723a(new C1258ee(this.f5075b, new C1582j(EnumC3219cg.CONTACT, "/profile/setimage").m6710a(EnumC1583k.POST).m6709a(HttpResponseCode.NOT_ACCEPTABLE).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, "returnlist").m6714a("count", "250").m6717b(C1537b.class).m6712a(GetProfileImageList.class).m6708a(), str));
    }

    /* renamed from: d */
    public void m5937d() {
        this.f5076c = new C1205cf(this.f5075b, new C1582j(EnumC3219cg.CONTACT, "/profile/historyimage/list").m6710a(EnumC1583k.GET).m6709a(407).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, "returnmxcnt").m6714a("count", "250").m6717b(C1537b.class).m6712a(GetProfileImageList.class).m6708a());
        C1595w.m6742a().m6745b().m6723a(this.f5076c);
    }

    /* renamed from: e */
    public void m5939e() {
        if (this.f5076c != null) {
            C3250y.m11456e("getUserProfileImageHistoryListCancel() is called", this.f5074a);
            this.f5076c.m5493c();
        }
    }

    /* renamed from: a */
    public void m5930a(String str, String str2) {
        this.f5077d = new C1204ce(this.f5075b, new C1582j(EnumC3219cg.CONTACT, "/profile/historyimage/" + str).m6710a(EnumC1583k.GET).m6709a(410).m6714a("buddyid", str).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6717b(C1537b.class).m6712a(GetProfileImageList.class).m6708a());
        C1595w.m6742a().m6745b().m6723a(this.f5077d);
    }

    /* renamed from: b */
    public void m5934b(String str, String str2) {
        this.f5077d = new C1204ce(this.f5075b, new C1582j(EnumC3219cg.CONTACT, "/profile/historyimage/" + str).m6710a(EnumC1583k.GET).m6709a(412).m6714a("buddyid", str).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("count", "5").m6714a("updatemode", "y").m6717b(C1537b.class).m6712a(GetProfileImageList.class).m6708a());
        C1595w.m6742a().m6745b().m6723a(this.f5077d);
    }

    /* renamed from: f */
    public void m5941f() {
        if (this.f5077d != null) {
            C3250y.m11456e("getUserProfileImageHistoryListCancel() is called", this.f5074a);
            this.f5077d.m5493c();
        }
    }

    /* renamed from: f */
    public void m5942f(String str) {
        this.f5080g = new C1184bl(this.f5075b, new C1582j(EnumC3219cg.CONTACT, "/mapping/info").m6710a(EnumC1583k.GET).m6709a(HttpResponseCode.TOO_LONG).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6717b(C1537b.class).m6712a(BuddyMappingInfo.class).m6708a(), str);
        C1595w.m6742a().m6745b().m6723a(this.f5080g);
    }

    /* renamed from: g */
    public void m5943g() {
        if (this.f5080g != null) {
            C3250y.m11456e("getBuddyMappingInfoCancel() is called", this.f5074a);
            this.f5080g.m5493c();
        }
    }
}
