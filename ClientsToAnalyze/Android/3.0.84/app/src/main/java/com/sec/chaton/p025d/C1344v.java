package com.sec.chaton.p025d;

import android.os.Handler;
import com.sec.chaton.p025d.p026a.C1158am;
import com.sec.chaton.p025d.p026a.C1159an;
import com.sec.chaton.p025d.p026a.C1200ca;
import com.sec.chaton.p025d.p026a.C1201cb;
import com.sec.chaton.p025d.p026a.C1202cc;
import com.sec.chaton.p025d.p026a.C1265el;
import com.sec.chaton.p025d.p026a.C1266em;
import com.sec.chaton.p025d.p026a.C1283v;
import com.sec.chaton.p035io.entry.GetPostONBlindList;
import com.sec.chaton.p035io.entry.GetPostONCommentList;
import com.sec.chaton.p035io.entry.GetPostONList;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.poston.C2020k;
import com.sec.chaton.poston.C2025p;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3219cg;
import java.util.ArrayList;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: PostONControl.java */
/* renamed from: com.sec.chaton.d.v */
/* loaded from: classes.dex */
public class C1344v {

    /* renamed from: a */
    private Handler f5070a;

    /* renamed from: b */
    private C1202cc f5071b = null;

    /* renamed from: c */
    private C1200ca f5072c;

    /* renamed from: d */
    private C1201cb f5073d;

    public C1344v(Handler handler) {
        this.f5070a = handler;
    }

    /* renamed from: a */
    public void m5913a(String str) {
        this.f5071b = new C1202cc(this.f5070a, new C1582j(EnumC3219cg.CONTACT, "/v3/poston/list").m6710a(EnumC1583k.GET).m6709a(901).m6714a("buddyid", str).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("count", "30").m6714a("fulltext", "false").m6714a("length", "140").m6717b(C1537b.class).m6712a(GetPostONList.class).m6708a(), true, str);
        C1595w.m6742a().m6746c().m6723a(this.f5071b);
    }

    /* renamed from: a */
    public void m5911a() {
        if (this.f5071b != null) {
            C3250y.m11456e("getPostONListCancel() is called", "PostONControl");
            this.f5071b.m5493c();
        }
    }

    /* renamed from: a */
    public void m5915a(String str, String str2) {
        C1595w.m6742a().m6746c().m6723a(new C1202cc(this.f5070a, new C1582j(EnumC3219cg.CONTACT, "/v3/poston/list").m6710a(EnumC1583k.GET).m6709a(901).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("buddyid", str).m6714a("imei", C3171am.m11045a()).m6714a("count", "30").m6714a("endtime", Long.valueOf(Long.parseLong(str2) - 1).toString()).m6714a("fulltext", "false").m6714a("length", "140").m6717b(C1537b.class).m6712a(GetPostONList.class).m6708a(), false, str));
    }

    /* renamed from: a */
    public void m5912a(C2020k c2020k, String str) {
        C1595w.m6742a().m6746c().m6723a(new C1266em(this.f5070a, new C1582j(EnumC3219cg.CONTACT, "/v3/poston").m6709a(902).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, "returnlist").m6714a("count", "30").m6714a("fulltext", "false").m6714a("length", "140").m6714a("blockmode", "true").m6717b(C1537b.class).m6712a(GetPostONList.class).m6708a(), c2020k, str));
    }

    /* renamed from: b */
    public void m5921b(String str, String str2) {
        C1595w.m6742a().m6746c().m6723a(new C1159an(this.f5070a, new C1582j(EnumC3219cg.CONTACT, "/v3/poston/delposton").m6710a(EnumC1583k.POST).m6709a(903).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("buddyid", str).m6714a(RtspHeaders.Values.MODE, "returnlist").m6714a("count", "30").m6714a("fulltext", "false").m6714a("length", "140").m6717b(C1537b.class).m6712a(GetPostONList.class).m6708a(), str2, true));
    }

    /* renamed from: c */
    public void m5923c(String str, String str2) {
        C1595w.m6742a().m6746c().m6723a(new C1159an(this.f5070a, new C1582j(EnumC3219cg.CONTACT, "/v3/poston/delposton").m6710a(EnumC1583k.POST).m6709a(903).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("buddyid", str).m6714a(RtspHeaders.Values.MODE, "returnlist").m6714a("count", "30").m6714a("fulltext", "false").m6714a("length", "140").m6717b(C1537b.class).m6712a(GetPostONList.class).m6708a(), str2, false));
    }

    /* renamed from: b */
    public void m5920b() {
        this.f5072c = new C1200ca(this.f5070a, new C1582j(EnumC3219cg.CONTACT, "/poston/blind").m6710a(EnumC1583k.GET).m6709a(905).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("count", "2000").m6712a(GetPostONBlindList.class).m6708a());
        C1595w.m6742a().m6746c().m6723a(this.f5072c);
    }

    /* renamed from: c */
    public void m5922c() {
        if (this.f5072c != null) {
            C3250y.m11456e("getPostONBlindListCancel() is called", "PostONControl");
            this.f5072c.m5493c();
        }
    }

    /* renamed from: a */
    public void m5919a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        C1595w.m6742a().m6746c().m6723a(new C1283v(this.f5070a, new C1582j(EnumC3219cg.CONTACT, "/poston/blind").m6710a(EnumC1583k.POST).m6709a(904).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, "returnlist").m6714a("count", "2000").m6712a(GetPostONBlindList.class).m6708a(), arrayList, arrayList2));
    }

    /* renamed from: d */
    public void m5925d(String str, String str2) {
        this.f5073d = new C1201cb(this.f5070a, new C1582j(EnumC3219cg.CONTACT, "/v3/poston/commentlist").m6710a(EnumC1583k.GET).m6709a(906).m6714a("buddyid", str).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("parentpostonid", str2).m6714a("count", "30").m6714a("fulltext", "false").m6714a("length", "140").m6717b(C1537b.class).m6712a(GetPostONCommentList.class).m6708a(), true);
        C1595w.m6742a().m6746c().m6723a(this.f5073d);
    }

    /* renamed from: d */
    public void m5924d() {
        if (this.f5073d != null) {
            C3250y.m11456e("getPostONCommentListCancel() is called", "PostONControl");
            this.f5073d.m5493c();
        }
    }

    /* renamed from: a */
    public void m5916a(String str, String str2, String str3, String str4, String str5) {
        this.f5073d = new C1201cb(this.f5070a, new C1582j(EnumC3219cg.CONTACT, "/v3/poston/commentlist").m6710a(EnumC1583k.GET).m6709a(906).m6714a("buddyid", str).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("count", "30").m6714a("starttime", Long.valueOf(Long.parseLong(str4) + 1).toString()).m6714a("fulltext", "false").m6714a("length", "140").m6714a("parentpostonid", str5).m6717b(C1537b.class).m6712a(GetPostONCommentList.class).m6708a(), false);
        C1595w.m6742a().m6746c().m6723a(this.f5073d);
    }

    /* renamed from: a */
    public void m5914a(String str, C2025p c2025p, String str2) {
        C1595w.m6742a().m6746c().m6723a(new C1265el(this.f5070a, new C1582j(EnumC3219cg.CONTACT, "/v3/poston/comment").m6710a(EnumC1583k.POST).m6709a(907).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a(RtspHeaders.Values.MODE, "returnlist").m6714a("count", "30").m6714a("fulltext", "false").m6714a("length", "140").m6714a("blockmode", "true").m6717b(C1537b.class).m6712a(GetPostONCommentList.class).m6708a(), str, c2025p, str2));
    }

    /* renamed from: a */
    public void m5918a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C1595w.m6742a().m6746c().m6723a(new C1158am(this.f5070a, new C1582j(EnumC3219cg.CONTACT, "/v3/poston/delcomment").m6710a(EnumC1583k.POST).m6709a(910).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("buddyid", str).m6714a("parentpostonid", str6).m6714a(RtspHeaders.Values.MODE, "returnlist").m6714a("count", "30").m6714a("fulltext", "false").m6714a("length", "140").m6717b(C1537b.class).m6712a(GetPostONCommentList.class).m6708a(), str4, str7));
    }

    /* renamed from: a */
    public void m5917a(String str, String str2, String str3, String str4, String str5, String str6) {
        C1595w.m6742a().m6746c().m6723a(new C1158am(this.f5070a, new C1582j(EnumC3219cg.CONTACT, "/v3/poston/delcomment").m6710a(EnumC1583k.POST).m6709a(910).m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("buddyid", str).m6714a("parentpostonid", str5).m6714a(RtspHeaders.Values.MODE, "returnlist").m6714a("count", "30").m6714a("fulltext", "false").m6714a("length", "140").m6717b(C1537b.class).m6712a(GetPostONCommentList.class).m6708a(), str4, str6));
    }
}
