package com.sec.chaton.p015d;

import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.buddy.p011b.C0287b;
import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.p015d.p016a.C0537ae;
import com.sec.chaton.p015d.p016a.C0540ah;
import com.sec.chaton.p015d.p016a.C0549aq;
import com.sec.chaton.p015d.p016a.C0550ar;
import com.sec.chaton.p015d.p016a.C0555aw;
import com.sec.chaton.p015d.p016a.C0557ay;
import com.sec.chaton.p015d.p016a.C0558az;
import com.sec.chaton.p015d.p016a.C0577br;
import com.sec.chaton.p015d.p016a.C0578bs;
import com.sec.chaton.p015d.p016a.C0579bt;
import com.sec.chaton.p015d.p016a.C0580bu;
import com.sec.chaton.p015d.p016a.C0582bw;
import com.sec.chaton.p015d.p016a.C0588d;
import com.sec.chaton.p015d.p016a.C0589e;
import com.sec.chaton.p015d.p016a.C0597m;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.p028io.entry.Entry;
import com.sec.chaton.p028io.entry.GetBuddyList;
import com.sec.chaton.p028io.entry.GetContentCategoryList;
import com.sec.chaton.p028io.entry.GetRecommendeeList;
import com.sec.chaton.p028io.entry.GetSnsFriendsList;
import com.sec.chaton.p028io.entry.GetSpecialBuddyList;
import com.sec.chaton.p028io.entry.specialbuddy.SpecialBuddyProxyEntry;
import com.sec.chaton.p028io.p029a.C0831b;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: ContactControl.java */
/* renamed from: com.sec.chaton.d.e */
/* loaded from: classes.dex */
public class C0633e {

    /* renamed from: a */
    private Handler f2472a;

    /* renamed from: b */
    private C0578bs f2473b;

    public C0633e(Handler handler) {
        this.f2472a = handler;
    }

    /* renamed from: a */
    public void m2858a(String str) {
        m2851a(str, false);
    }

    /* renamed from: a */
    public int m2851a(String str, boolean z) {
        C0582bw c0582bw = new C0582bw(this.f2472a, new C0800j(EnumC1765bu.CONTACT, "/address").m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a(RtspHeaders.Values.MODE, str).m3405a(HttpResponseCode.FOUND).m3406a(EnumC0801k.POST).m3404a());
        if (z) {
            c0582bw.m2712e();
            return c0582bw.m2775f();
        }
        C0802l.m3412a().offer(c0582bw);
        return -1;
    }

    /* renamed from: a */
    public int m2852a(String str, boolean z, String str2, String str3) {
        C0582bw c0582bw = new C0582bw(this.f2472a, new C0800j(EnumC1765bu.CONTACT, "/address").m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a(RtspHeaders.Values.MODE, str).m3405a(HttpResponseCode.FOUND).m3406a(EnumC0801k.POST).m3404a(), str2, str3);
        if (z) {
            c0582bw.m2712e();
            return c0582bw.m2775f();
        }
        C0802l.m3412a().offer(c0582bw);
        return -1;
    }

    /* renamed from: a */
    public void m2853a() {
        m2865a(false);
    }

    /* renamed from: a */
    public void m2865a(boolean z) {
        C0800j c0800jM3407a = new C0800j(EnumC1765bu.CONTACT, "/v3/buddies").m3406a(EnumC0801k.GET).m3405a(301).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("timestamp", String.valueOf(Long.valueOf(C1789u.m6075a().getLong("get_all_buddies_timestamp", 0L)))).m3409a(RtspHeaders.Values.MODE, "blocked").m3407a(GetBuddyList.class);
        if (z) {
            new C0540ah(this.f2472a, c0800jM3407a.m3404a()).m2712e();
        } else {
            C0802l.m3412a().offer(new C0540ah(this.f2472a, c0800jM3407a.m3404a()));
        }
    }

    /* renamed from: b */
    public void m2868b(String str) {
        m2869b(str, true);
    }

    /* renamed from: b */
    public void m2869b(String str, boolean z) {
        C0800j c0800jM3407a = new C0800j(EnumC1765bu.CONTACT, "/v3/buddy").m3406a(EnumC0801k.POST).m3405a(303).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a(RtspHeaders.Values.MODE, "call").m3407a(GetBuddyList.class);
        BlockingQueue blockingQueueM3412a = C0802l.m3412a();
        Handler handler = this.f2472a;
        C0798h c0798hM3404a = c0800jM3407a.m3404a();
        if (z) {
            str = "+" + str;
        }
        blockingQueueM3412a.offer(new C0589e(handler, c0798hM3404a, str));
    }

    /* renamed from: c */
    public void m2873c(String str) {
        C0802l.m3412a().offer(new C0537ae(this.f2472a, new C0800j(EnumC1765bu.CONTACT, "/specialbuddy/follow").m3406a(EnumC0801k.POST).m3405a(317).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a(), str));
    }

    /* renamed from: d */
    public void m2876d(String str) {
        C0802l.m3412a().offer(new C0580bu(this.f2472a, new C0800j(EnumC1765bu.CONTACT, "/specialbuddy/like").m3406a(EnumC0801k.POST).m3405a(319).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a(), str));
    }

    /* renamed from: e */
    public void m2880e(String str) {
        C0802l.m3412a().offer(new C0580bu(this.f2472a, new C0800j(EnumC1765bu.CONTACT, "/specialbuddy/unlike").m3406a(EnumC0801k.POST).m3405a(320).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a(), str));
    }

    /* renamed from: a */
    public void m2854a(int i, int i2) {
        C0800j c0800jM3407a = new C0800j(EnumC1765bu.CONTACT, "/specialbuddy/myfollowings").m3406a(EnumC0801k.GET).m3405a(321).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3410b(C0287b.class).m3407a(GetSpecialBuddyList.class);
        if (i >= 0) {
            c0800jM3407a.m3409a("startidx", String.valueOf(i));
        }
        if (i2 >= 0) {
            c0800jM3407a.m3409a("count", String.valueOf(i2));
        }
        C0802l.m3412a().offer(new C0550ar(this.f2472a, c0800jM3407a.m3404a()));
    }

    /* renamed from: a */
    public void m2859a(String str, int i, int i2) {
        C0800j c0800jM3407a = new C0800j(EnumC1765bu.CONTACT, "/specialbuddy/contentcategory/user/list").m3406a(EnumC0801k.POST).m3405a(316).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3410b(C0831b.class).m3407a(GetContentCategoryList.class);
        if (i >= 0) {
            c0800jM3407a.m3409a("startidx", String.valueOf(i));
        }
        if (i2 >= 0) {
            c0800jM3407a.m3409a("count", String.valueOf(i2));
        }
        C0802l.m3412a().offer(new C0557ay(this.f2472a, c0800jM3407a.m3404a(), str));
    }

    /* renamed from: a */
    public void m2864a(ArrayList arrayList, boolean z) {
        int size = arrayList.size();
        if (size > 0) {
            C0800j c0800jM3407a = new C0800j(EnumC1765bu.CONTACT, "/v3/buddy").m3406a(EnumC0801k.POST).m3405a(311).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a(RtspHeaders.Values.MODE, "multiple").m3407a(GetBuddyList.class);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(z ? "+" + ((String) arrayList.get(i)) : (String) arrayList.get(i));
                sb.append(",");
            }
            C0802l.m3412a().offer(new C0589e(this.f2472a, c0800jM3407a.m3404a(), sb.toString()));
        }
    }

    /* renamed from: c */
    public AbstractRunnableC0532a m2871c(String str, boolean z) {
        C0800j c0800jM3407a = new C0800j(EnumC1765bu.CONTACT, "/v3/buddy").m3406a(EnumC0801k.POST).m3405a(307).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a(RtspHeaders.Values.MODE, "preview").m3407a(GetBuddyList.class);
        Handler handler = this.f2472a;
        C0798h c0798hM3404a = c0800jM3407a.m3404a();
        if (z) {
            str = "+" + str;
        }
        C0588d c0588d = new C0588d(handler, c0798hM3404a, str);
        C0802l.m3412a().offer(c0588d);
        return c0588d;
    }

    /* renamed from: b */
    public void m2870b(boolean z) {
        m2877d("phonenumber", z);
    }

    /* renamed from: c */
    public void m2874c(boolean z) {
        m2881e("ignorerecommendation", z);
    }

    /* renamed from: d */
    public void m2878d(boolean z) {
        m2883f("recommendationbuddy", z);
    }

    /* renamed from: d */
    public void m2877d(String str, boolean z) {
        this.f2473b = new C0578bs(this.f2472a, new C0800j(EnumC1765bu.CONTACT, "/privacy").m3406a(EnumC0801k.POST).m3405a(HttpResponseCode.NOT_MODIFIED).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a(), str, z);
        C0802l.m3412a().offer(this.f2473b);
    }

    /* renamed from: e */
    public void m2881e(String str, boolean z) {
        this.f2473b = new C0578bs(this.f2472a, new C0800j(EnumC1765bu.CONTACT, "/privacy").m3406a(EnumC0801k.POST).m3405a(315).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a(), str, z);
        C0802l.m3412a().offer(this.f2473b);
    }

    /* renamed from: f */
    public void m2883f(String str, boolean z) {
        this.f2473b = new C0578bs(this.f2472a, new C0800j(EnumC1765bu.CONTACT, "/privacy").m3406a(EnumC0801k.POST).m3405a(316).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a(), str, z);
        C0802l.m3412a().offer(this.f2473b);
    }

    /* renamed from: e */
    public void m2882e(boolean z) {
        if (C0577br.m2767f()) {
            m2860a((String) null, 0, z);
        }
    }

    /* renamed from: a */
    public void m2860a(String str, int i, boolean z) {
        C0577br c0577br = new C0577br(this.f2472a, new C0800j(EnumC1765bu.CONTACT, "/extra/info").m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3405a(305).m3406a(EnumC0801k.POST).m3404a(), str, i);
        if (z) {
            c0577br.m2712e();
        } else {
            C0802l.m3412a().offer(c0577br);
        }
    }

    /* renamed from: a */
    public void m2856a(int i, String[] strArr, int[] iArr, boolean z) {
        C0577br c0577br = new C0577br(this.f2472a, new C0800j(EnumC1765bu.CONTACT, "/extra/info").m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3405a(305).m3406a(EnumC0801k.POST).m3404a(), i, strArr, iArr);
        if (z) {
            c0577br.m2712e();
        } else {
            C0802l.m3412a().offer(c0577br);
        }
    }

    /* renamed from: b */
    public void m2866b() {
        m2867b(-1, -1);
    }

    /* renamed from: b */
    public void m2867b(int i, int i2) {
        C0800j c0800jM3407a = new C0800j(EnumC1765bu.CONTACT, "/buddyrecommendeelist").m3406a(EnumC0801k.GET).m3405a(301).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3407a(GetRecommendeeList.class);
        if (i >= 0) {
            c0800jM3407a.m3409a("startidx", String.valueOf(i));
        }
        if (i2 >= 0) {
            c0800jM3407a.m3409a("count", String.valueOf(i2));
        }
        C0802l.m3412a().offer(new C0555aw(this.f2472a, c0800jM3407a.m3404a(), false));
    }

    /* renamed from: c */
    public void m2872c() {
        C0802l.m3412a().offer(new C0597m(this.f2472a, new C0800j(EnumC1765bu.CONTACT, "/compatibility").m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3405a(310).m3406a(EnumC0801k.POST).m3404a()));
    }

    /* renamed from: d */
    public void m2875d() {
        m2855a(-1, -1, -1);
    }

    /* renamed from: a */
    public void m2855a(int i, int i2, int i3) {
        C0800j c0800jM3407a = new C0800j(EnumC1765bu.CONTACT, "/specialbuddy/specialusers").m3406a(EnumC0801k.GET).m3405a(301).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3410b(C0287b.class).m3407a(GetSpecialBuddyList.class);
        if (i >= 0) {
            c0800jM3407a.m3409a("startidx", String.valueOf(i));
        }
        if (i2 >= 0) {
            c0800jM3407a.m3409a("count", String.valueOf(i2));
        }
        if (i3 >= 0) {
            c0800jM3407a.m3409a("typecategoryid", String.valueOf(i3));
        }
        C0802l.m3412a().offer(new C0555aw(this.f2472a, c0800jM3407a.m3404a(), true));
    }

    /* renamed from: a */
    public void m2857a(SpecialBuddyProxyEntry specialBuddyProxyEntry) {
        EnumC1765bu enumC1765bu;
        EnumC0801k enumC0801k;
        EnumC1765bu enumC1765bu2 = EnumC1765bu.CONTACT;
        if (TextUtils.isEmpty(specialBuddyProxyEntry.server)) {
            enumC1765bu = EnumC1765bu.BYPASS;
        } else {
            String lowerCase = specialBuddyProxyEntry.server.toLowerCase();
            EnumC1765bu enumC1765bu3 = EnumC1765bu.CONTACT;
            if (lowerCase.equals("file")) {
                enumC1765bu = EnumC1765bu.FILE;
            } else {
                enumC1765bu = EnumC1765bu.CONTACT;
            }
        }
        EnumC0801k enumC0801k2 = EnumC0801k.GET;
        if (specialBuddyProxyEntry.type.toLowerCase().equals("post")) {
            enumC0801k = EnumC0801k.POST;
        } else {
            enumC0801k = EnumC0801k.GET;
        }
        m2861a(specialBuddyProxyEntry.url, enumC1765bu, enumC0801k);
    }

    /* renamed from: a */
    public void m2861a(String str, EnumC1765bu enumC1765bu, EnumC0801k enumC0801k) {
        C0802l.m3412a().offer(new C0558az(this.f2472a, new C0800j(enumC1765bu, str).m3406a(enumC0801k).m3405a(315).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3411b("Content-Type", "application/json").m3407a(Entry.class).m3404a()));
    }

    /* renamed from: e */
    public void m2879e() {
        if (this.f2473b != null) {
            this.f2473b.m2710c();
        }
    }

    /* renamed from: a */
    public void m2862a(String str, String str2) {
        C0802l.m3412a().offer(new C0579bt(this.f2472a, new C0800j(EnumC1765bu.CONTACT, "/sns/id").m3406a(EnumC0801k.POST).m3405a(313).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a(), str, str2));
    }

    /* renamed from: a */
    public void m2863a(String str, long[] jArr) {
        C0802l.m3412a().offer(new C0549aq(this.f2472a, new C0800j(EnumC1765bu.CONTACT, "/sns/friends").m3406a(EnumC0801k.POST).m3405a(314).m3407a(GetSnsFriendsList.class).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a(), str, jArr));
    }
}
