package com.sec.chaton.p025d;

import android.os.Handler;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.p025d.p026a.C1148ac;
import com.sec.chaton.p025d.p026a.C1150ae;
import com.sec.chaton.p025d.p026a.C1171az;
import com.sec.chaton.p025d.p026a.C1174bb;
import com.sec.chaton.p025d.p026a.C1175bc;
import com.sec.chaton.p025d.p026a.C1191bs;
import com.sec.chaton.p025d.p026a.C1192bt;
import com.sec.chaton.p025d.p026a.C1193bu;
import com.sec.chaton.p025d.p026a.C1196bx;
import com.sec.chaton.p025d.p026a.C1197by;
import com.sec.chaton.p025d.p026a.C1203cd;
import com.sec.chaton.p025d.p026a.C1206cg;
import com.sec.chaton.p025d.p026a.C1209cj;
import com.sec.chaton.p025d.p026a.C1244dr;
import com.sec.chaton.p025d.p026a.C1245ds;
import com.sec.chaton.p025d.p026a.C1246dt;
import com.sec.chaton.p025d.p026a.C1248dv;
import com.sec.chaton.p025d.p026a.C1256ec;
import com.sec.chaton.p025d.p026a.C1259ef;
import com.sec.chaton.p025d.p026a.C1268g;
import com.sec.chaton.p025d.p026a.C1269h;
import com.sec.chaton.p035io.entry.CheckBuddyList;
import com.sec.chaton.p035io.entry.FlagImageURLEntry;
import com.sec.chaton.p035io.entry.GetBuddyList;
import com.sec.chaton.p035io.entry.GetContentCategoryList;
import com.sec.chaton.p035io.entry.GetCurationList;
import com.sec.chaton.p035io.entry.GetPrivacyList;
import com.sec.chaton.p035io.entry.GetRecommendeeList;
import com.sec.chaton.p035io.entry.GetSnsFriendsList;
import com.sec.chaton.p035io.entry.GetSpecialBuddyList;
import com.sec.chaton.p035io.entry.GetSpecialUserList;
import com.sec.chaton.p035io.entry.specialbuddy.LivepartnerLikesCountEntry;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1584l;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3219cg;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: ContactControl.java */
/* renamed from: com.sec.chaton.d.h */
/* loaded from: classes.dex */
public class C1330h {

    /* renamed from: a */
    public String f5019a = "blocked|sainfoenc|multi-results";

    /* renamed from: b */
    private Handler f5020b;

    /* renamed from: c */
    private C1203cd f5021c;

    /* renamed from: d */
    private C1244dr f5022d;

    public C1330h(Handler handler) {
        this.f5020b = handler;
    }

    /* renamed from: a */
    public void m5721a(String str) {
        m5711a(str, false);
    }

    /* renamed from: a */
    public int m5711a(String str, boolean z) {
        C1259ef c1259ef = new C1259ef(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/address").m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, str).m6709a(HttpResponseCode.FOUND).m6710a(EnumC1583k.POST).m6708a());
        if (z) {
            c1259ef.m5495e();
            return c1259ef.m5575i();
        }
        C1595w.m6742a().m6745b().m6723a(c1259ef);
        return -1;
    }

    /* renamed from: a */
    public int m5715a(String str, boolean z, String str2, String str3) {
        C1259ef c1259ef = new C1259ef(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/address").m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, str).m6709a(HttpResponseCode.FOUND).m6710a(EnumC1583k.POST).m6708a(), str2, str3);
        if (z) {
            c1259ef.m5495e();
            return c1259ef.m5575i();
        }
        C1595w.m6742a().m6745b().m6723a(c1259ef);
        return -1;
    }

    /* renamed from: a */
    public int m5714a(String str, boolean z, int i, ArrayList<String> arrayList, HashMap<String, ArrayList<String>> map) {
        C1259ef c1259ef = new C1259ef(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/address").m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, str).m6709a(HttpResponseCode.FOUND).m6710a(EnumC1583k.POST).m6708a(), i, arrayList, map);
        if (z) {
            c1259ef.m5495e();
            return c1259ef.m5575i();
        }
        C1595w.m6742a().m6745b().m6723a(c1259ef);
        return -1;
    }

    /* renamed from: a */
    public int m5713a(String str, boolean z, int i, String str2, String[] strArr, String[] strArr2) {
        C1259ef c1259ef = new C1259ef(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/address").m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, str).m6709a(HttpResponseCode.FOUND).m6710a(EnumC1583k.POST).m6708a(), str2, strArr, strArr2, i);
        if (z) {
            c1259ef.m5495e();
            return c1259ef.m5575i();
        }
        C1595w.m6742a().m6745b().m6723a(c1259ef);
        return -1;
    }

    /* renamed from: a */
    public int m5716a(String str, boolean z, String str2, String str3, String[] strArr, int i) {
        C1259ef c1259ef = new C1259ef(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/address").m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, str).m6709a(HttpResponseCode.FOUND).m6710a(EnumC1583k.POST).m6708a(), str2, str3, strArr, i);
        if (z) {
            c1259ef.m5495e();
            return c1259ef.m5575i();
        }
        C1595w.m6742a().m6745b().m6723a(c1259ef);
        return -1;
    }

    /* renamed from: a */
    public void m5717a() throws UnsupportedEncodingException {
        m5727a(false);
    }

    /* renamed from: a */
    public void m5727a(boolean z) throws UnsupportedEncodingException {
        String strEncode = null;
        Long lValueOf = Long.valueOf(C3159aa.m10962a().m10976a("get_all_buddies_timestamp", 0L));
        try {
            strEncode = URLEncoder.encode(this.f5019a, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C3250y.m11456e("getAllBuddies() : " + e.getMessage(), "ContactControl");
        }
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/v5/buddies").m6710a(EnumC1583k.GET).m6709a(301).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("timestamp", String.valueOf(lValueOf)).m6714a(RtspHeaders.Values.MODE, strEncode).m6714a("item", "devicetype").m6712a(GetBuddyList.class);
        if (z) {
            new C1174bb(this.f5020b, c1582jM6712a.m6708a()).m5495e();
        } else {
            C1595w.m6742a().m6745b().m6723a(new C1174bb(this.f5020b, c1582jM6712a.m6708a()));
        }
    }

    /* renamed from: a */
    public void m5728a(boolean z, int i) {
        boolean z2;
        String strEncode;
        Long l;
        String strEncode2 = null;
        Long lValueOf = Long.valueOf(C3159aa.m10962a().m10976a("get_all_buddies_timestamp", 0L));
        switch (i) {
            case HttpResponseCode.f13733OK /* 200 */:
                try {
                    z2 = false;
                    strEncode = URLEncoder.encode(this.f5019a + "|instance", "UTF-8");
                    l = 0L;
                    break;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    z2 = false;
                    strEncode = null;
                    l = 0L;
                    break;
                }
            case 201:
                try {
                    strEncode2 = URLEncoder.encode(this.f5019a, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                z2 = true;
                strEncode = strEncode2;
                l = lValueOf;
                break;
            default:
                z2 = false;
                strEncode = null;
                l = lValueOf;
                break;
        }
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/v5/buddies").m6710a(EnumC1583k.GET).m6709a(301).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("timestamp", String.valueOf(l)).m6714a(RtspHeaders.Values.MODE, strEncode).m6714a("item", "devicetype").m6712a(GetBuddyList.class);
        if (i == 200) {
            C1595w.m6742a().m6745b().m6723a(new C1175bc(this.f5020b, c1582jM6712a.m6708a()));
        } else if (z) {
            new C1174bb(this.f5020b, c1582jM6712a.m6708a(), z2).m5495e();
        } else {
            C1595w.m6742a().m6745b().m6723a(new C1174bb(this.f5020b, c1582jM6712a.m6708a()));
        }
    }

    /* renamed from: b */
    public void m5735b(boolean z) throws UnsupportedEncodingException {
        String strEncode = null;
        try {
            strEncode = URLEncoder.encode(this.f5019a, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C3250y.m11456e("getAllBuddiesReset() : " + e.getMessage(), "ContactControl");
        }
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/v5/buddies").m6710a(EnumC1583k.GET).m6709a(301).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("timestamp", String.valueOf((Object) 0L)).m6714a(RtspHeaders.Values.MODE, strEncode).m6714a("item", "devicetype").m6712a(GetBuddyList.class);
        if (z) {
            new C1174bb(this.f5020b, c1582jM6712a.m6708a()).m5495e();
        } else {
            C1595w.m6742a().m6745b().m6723a(new C1174bb(this.f5020b, c1582jM6712a.m6708a()));
        }
    }

    /* renamed from: b */
    public C1269h m5730b(String str) {
        return m5731b(str, true);
    }

    /* renamed from: b */
    public C1269h m5731b(String str, boolean z) throws UnsupportedEncodingException {
        String strEncode = null;
        try {
            strEncode = URLEncoder.encode("call|sainfoenc", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/v6/buddy").m6710a(EnumC1583k.POST).m6709a(303).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, strEncode).m6712a(GetBuddyList.class);
        Handler handler = this.f5020b;
        C1580h c1580hM6708a = c1582jM6712a.m6708a();
        if (z) {
            str = "+" + str;
        }
        C1269h c1269h = new C1269h(handler, c1580hM6708a, str);
        C1595w.m6742a().m6745b().m6723a(c1269h);
        return c1269h;
    }

    /* renamed from: c */
    public void m5737c(String str) {
        C1595w.m6742a().m6745b().m6723a(new C1171az(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/specialbuddy/follow/app").m6710a(EnumC1583k.POST).m6709a(317).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6708a(), str));
    }

    /* renamed from: d */
    public void m5741d(String str) {
        C1595w.m6742a().m6745b().m6723a(new C1256ec(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/specialbuddy/unfollow/app").m6710a(EnumC1583k.POST).m6709a(318).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6708a(), str));
    }

    /* renamed from: e */
    public void m5746e(String str) {
        C1595w.m6742a().m6745b().m6723a(new C1248dv(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/specialbuddy/like").m6710a(EnumC1583k.POST).m6709a(319).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6717b(C1537b.class).m6712a(LivepartnerLikesCountEntry.class).m6708a(), str));
    }

    /* renamed from: f */
    public void m5750f(String str) {
        C1595w.m6742a().m6745b().m6723a(new C1248dv(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/specialbuddy/unlike").m6710a(EnumC1583k.POST).m6709a(320).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6717b(C1537b.class).m6712a(LivepartnerLikesCountEntry.class).m6708a(), str));
    }

    /* renamed from: b */
    public void m5732b() {
        C1595w.m6742a().m6745b().m6723a(new C1191bs(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/specialbuddy/curation/iso2").m6710a(EnumC1583k.GET).m6709a(331).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6717b(C1537b.class).m6712a(GetCurationList.class).m6708a()));
    }

    /* renamed from: c */
    public void m5736c() {
        m5719a(0, 0);
    }

    /* renamed from: a */
    public void m5719a(int i, int i2) {
        int i3;
        long jM10976a = C3159aa.m10962a().m10976a("get_myfollowing_buddies_timestamp", 0L);
        if (C1493a.m6463a("live_chat_feature")) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        C1595w.m6742a().m6745b().m6723a(new C1197by(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/specialbuddy/myfollowings").m6710a(EnumC1583k.GET).m6709a(321).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("timestamp", String.valueOf(jM10976a)).m6714a("version", String.valueOf(i3)).m6714a("startidx", String.valueOf(i)).m6714a("count", String.valueOf(i2)).m6717b(C1537b.class).m6712a(GetSpecialBuddyList.class).m6708a()));
    }

    /* renamed from: a */
    public void m5722a(String str, int i, int i2) {
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/specialbuddy/contentcategory/user/list").m6710a(EnumC1583k.POST).m6709a(316).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6717b(C1537b.class).m6712a(GetContentCategoryList.class);
        if (i >= 0) {
            c1582jM6712a.m6714a("startidx", String.valueOf(i));
        }
        if (i2 >= 0) {
            c1582jM6712a.m6714a("count", String.valueOf(i2));
        }
        C1595w.m6742a().m6745b().m6723a(new C1209cj(this.f5020b, c1582jM6712a.m6708a(), str));
    }

    /* renamed from: a */
    public void m5726a(ArrayList<String> arrayList, boolean z) {
        int size = arrayList.size();
        if (size > 0) {
            C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/v6/buddy").m6710a(EnumC1583k.POST).m6709a(311).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, "multiple").m6712a(GetBuddyList.class);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(z ? "+" + arrayList.get(i) : arrayList.get(i));
                sb.append(",");
            }
            C1595w.m6742a().m6745b().m6723a(new C1269h(this.f5020b, c1582jM6712a.m6708a(), sb.toString()));
        }
    }

    /* renamed from: b */
    public void m5734b(ArrayList<String> arrayList, boolean z) {
        int size = arrayList.size();
        if (size > 0) {
            C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/v6/buddy").m6710a(EnumC1583k.POST).m6709a(311).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, "multi-results").m6712a(GetBuddyList.class);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(z ? "+" + arrayList.get(i) : arrayList.get(i));
                sb.append(",");
            }
            C1595w.m6742a().m6745b().m6723a(new C1269h(this.f5020b, c1582jM6712a.m6708a(), sb.toString()));
        }
    }

    /* renamed from: c */
    public void m5738c(String str, boolean z) {
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/v6/buddy").m6710a(EnumC1583k.POST).m6709a(307).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, "preview").m6712a(GetBuddyList.class);
        C1584l c1584lM6745b = C1595w.m6742a().m6745b();
        Handler handler = this.f5020b;
        C1580h c1580hM6708a = c1582jM6712a.m6708a();
        if (z) {
            str = "+" + str;
        }
        c1584lM6745b.m6723a(new C1268g(handler, c1580hM6708a, str));
    }

    /* renamed from: c */
    public void m5739c(boolean z) {
        m5742d("phonenumber", z);
    }

    /* renamed from: d */
    public void m5743d(boolean z) {
        m5742d("emailsamsung", z);
    }

    /* renamed from: e */
    public void m5747e(boolean z) {
        m5742d("showprofileimage", z);
    }

    /* renamed from: f */
    public void m5751f(boolean z) {
        m5742d("ignorerecommendation", z);
    }

    /* renamed from: g */
    public void m5754g(boolean z) {
        m5742d("recommendationbuddy", z);
    }

    /* renamed from: d */
    public void m5742d(String str, boolean z) {
        C1595w.m6742a().m6745b().m6723a(new C1245ds(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/privacy").m6710a(EnumC1583k.POST).m6709a(HttpResponseCode.NOT_MODIFIED).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6708a(), str, z));
    }

    /* renamed from: g */
    public void m5753g(String str) {
        this.f5021c = new C1203cd(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/privacy").m6710a(EnumC1583k.GET).m6709a(322).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(PrefFragmentChats.TYPE, URLEncoder.encode(str)).m6714a(RtspHeaders.Values.MODE, "multiple").m6717b(C1537b.class).m6712a(GetPrivacyList.class).m6708a());
        C1595w.m6742a().m6745b().m6723a(this.f5021c);
    }

    /* renamed from: d */
    public void m5740d() {
        if (this.f5021c != null) {
            C3250y.m11456e("getPrivacyAllCancel() is called", "ContactControl");
            this.f5021c.m5493c();
        }
    }

    /* renamed from: e */
    public void m5745e() {
        if (this.f5022d != null) {
            C3250y.m11456e("SetExtraInfoTaskCancel() is called", "ContactControl");
            this.f5022d.m5493c();
        }
    }

    /* renamed from: a */
    public void m5723a(String str, int i, boolean z) {
        this.f5022d = new C1244dr(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/extra/info").m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6709a(305).m6710a(EnumC1583k.POST).m6708a(), str, i);
        if (z) {
            this.f5022d.m5495e();
        } else {
            C1595w.m6742a().m6745b().m6723a(this.f5022d);
        }
    }

    /* renamed from: e */
    public int m5744e(String str, boolean z) {
        return m5712a(str, z, -1);
    }

    /* renamed from: a */
    public int m5712a(String str, boolean z, int i) {
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/v5/check/" + str).m6710a(EnumC1583k.GET).m6709a(306).m6714a("buddyid", str).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, "nonbuddy").m6714a("item", "preview").m6712a(CheckBuddyList.class);
        if (z) {
            c1582jM6712a.m6716b(i);
        }
        C1148ac c1148ac = new C1148ac(this.f5020b, c1582jM6712a.m6708a());
        if (z) {
            c1148ac.m5495e();
            return c1148ac.m5505i();
        }
        C1595w.m6742a().m6745b().m6723a(c1148ac);
        return 0;
    }

    /* renamed from: f */
    public int m5748f(String str, boolean z) {
        return m5729b(str, z, -1);
    }

    /* renamed from: b */
    public int m5729b(String str, boolean z, int i) throws UnsupportedEncodingException {
        String strEncode = null;
        try {
            strEncode = URLEncoder.encode("nonbuddy|sainfoenc", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C3250y.m11456e("checkBuddy6() : " + e.getMessage(), "ContactControl");
        }
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/v6/check/" + str).m6710a(EnumC1583k.GET).m6709a(306).m6714a("buddyid", str).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, strEncode).m6714a("item", "preview").m6712a(CheckBuddyList.class);
        if (z) {
            c1582jM6712a.m6716b(i);
        }
        C1148ac c1148ac = new C1148ac(this.f5020b, c1582jM6712a.m6708a());
        if (z) {
            c1148ac.m5495e();
            return c1148ac.m5505i();
        }
        C1595w.m6742a().m6745b().m6723a(c1148ac);
        return 0;
    }

    /* renamed from: f */
    public void m5749f() {
        m5733b(-1, -1);
    }

    /* renamed from: b */
    public void m5733b(int i, int i2) {
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/buddyrecommendee/list").m6710a(EnumC1583k.GET).m6709a(301).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, "timestamp").m6712a(GetRecommendeeList.class);
        if (i >= 0) {
            c1582jM6712a.m6714a("startidx", String.valueOf(i));
        }
        if (i2 >= 0) {
            c1582jM6712a.m6714a("count", String.valueOf(i2));
        }
        C1595w.m6742a().m6745b().m6723a(new C1206cg(this.f5020b, c1582jM6712a.m6708a(), false));
    }

    /* renamed from: g */
    public void m5752g() {
        m5720a(-1, -1, -1);
    }

    /* renamed from: a */
    public void m5718a(int i) {
        m5720a(-1, -1, i);
    }

    /* renamed from: a */
    public void m5720a(int i, int i2, int i3) {
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/specialbuddy/buddy").m6710a(EnumC1583k.GET).m6709a(301).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("timestamp", String.valueOf(i3 == 600 ? "0" : C3159aa.m10962a().m10979a("get_special_buddies_timestamp", "0"))).m6714a("version", String.valueOf(C1493a.m6463a("live_chat_feature") ? 3 : 2)).m6717b(C1537b.class).m6712a(GetSpecialUserList.class);
        if (i >= 0) {
            c1582jM6712a.m6714a("startidx", String.valueOf(i));
        }
        if (i2 >= 0) {
            c1582jM6712a.m6714a("count", String.valueOf(i2));
        }
        C1595w.m6742a().m6745b().m6723a(new C1196bx(this.f5020b, c1582jM6712a.m6708a()));
    }

    /* renamed from: h */
    public void m5755h() {
        C1595w.m6742a().m6745b().m6723a(new C1150ae(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/compatibility").m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6709a(310).m6710a(EnumC1583k.POST).m6708a()));
    }

    /* renamed from: a */
    public void m5724a(String str, String str2) {
        C1595w.m6742a().m6745b().m6723a(new C1246dt(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/sns/id").m6710a(EnumC1583k.POST).m6709a(313).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6708a(), str, str2));
    }

    /* renamed from: a */
    public void m5725a(String str, long[] jArr) {
        C1595w.m6742a().m6745b().m6723a(new C1192bt(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/sns/friend").m6710a(EnumC1583k.POST).m6709a(314).m6712a(GetSnsFriendsList.class).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6708a(), str, jArr));
    }

    /* renamed from: h */
    public void m5756h(String str) {
        C1595w.m6742a().m6745b().m6723a(new C1193bu(this.f5020b, new C1582j(EnumC3219cg.CONTACT, "/nationalflag").m6710a(EnumC1583k.GET).m6709a(324).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("contrycode", str).m6712a(FlagImageURLEntry.class).m6708a()));
    }
}
