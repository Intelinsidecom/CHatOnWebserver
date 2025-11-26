package com.sec.chaton.p055d;

import android.os.Handler;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.C1911ak;
import com.sec.chaton.p055d.p056a.C1912al;
import com.sec.chaton.p055d.p056a.C1958cd;
import com.sec.chaton.p055d.p056a.C1959ce;
import com.sec.chaton.p055d.p056a.C1960cf;
import com.sec.chaton.p055d.p056a.C1961cg;
import com.sec.chaton.p055d.p056a.C2046fk;
import com.sec.chaton.p055d.p056a.C2047fl;
import com.sec.chaton.p055d.p056a.C2058q;
import com.sec.chaton.p065io.entry.GetPostONBlindList;
import com.sec.chaton.p065io.entry.GetPostONCommentList;
import com.sec.chaton.p065io.entry.GetPostONDetailInfoList;
import com.sec.chaton.p065io.entry.GetPostONList;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.poston.C3016k;
import com.sec.chaton.poston.C3021p;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import java.util.ArrayList;
import java.util.concurrent.Future;

/* compiled from: PostONControl.java */
/* renamed from: com.sec.chaton.d.ag */
/* loaded from: classes.dex */
public class C2074ag {

    /* renamed from: a */
    private Handler f7560a;

    /* renamed from: b */
    private Future<C0778b> f7561b = null;

    /* renamed from: c */
    private Future<C0778b> f7562c;

    /* renamed from: d */
    private Future<C0778b> f7563d;

    /* renamed from: e */
    private Future<C0778b> f7564e;

    public C2074ag(Handler handler) {
        this.f7560a = handler;
    }

    /* renamed from: a */
    public void m9288a(String str) {
        this.f7561b = C2472w.m10687a().m10691c().m10662a(new C1961cg(new C2456g(EnumC4868cf.CONTACT, "/v3/poston/list").m10637a(EnumC2457h.GET).m10641a("buddyid", str).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(VKApiConst.COUNT, "30").m10641a("fulltext", "false").m10641a("length", "140").m10641a("mode", "showorder").m10643b(C2407b.class).m10639a(GetPostONList.class).m10635a(), true, str), 901, this.f7560a);
    }

    /* renamed from: a */
    public void m9286a() {
        if (this.f7561b != null) {
            C4904y.m18646e("getPostONListCancel() is called", "PostONControl");
            this.f7561b.cancel(true);
        }
    }

    /* renamed from: a */
    public void m9290a(String str, String str2) {
        C2472w.m10687a().m10691c().m10662a(new C1961cg(new C2456g(EnumC4868cf.CONTACT, "/v3/poston/list").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("buddyid", str).m10641a("imei", C4822an.m18228d()).m10641a(VKApiConst.COUNT, "30").m10641a("endtime", Long.valueOf(Long.parseLong(str2) - 1).toString()).m10641a("fulltext", "false").m10641a("length", "140").m10643b(C2407b.class).m10639a(GetPostONList.class).m10635a(), false, str), 901, this.f7560a);
    }

    /* renamed from: a */
    public void m9287a(C3016k c3016k, String str) {
        C2472w.m10687a().m10691c().m10662a(new C2047fl(new C2456g(EnumC4868cf.CONTACT, "/v3/poston").m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "returnlist").m10641a(VKApiConst.COUNT, "30").m10641a("fulltext", "false").m10641a("length", "140").m10641a("blockmode", "true").m10641a("mode", "returnlist|showorder").m10643b(C2407b.class).m10639a(GetPostONList.class).m10635a(), c3016k, str), 902, this.f7560a);
    }

    /* renamed from: b */
    public void m9295b(String str, String str2) {
        C2472w.m10687a().m10691c().m10662a(new C1912al(new C2456g(EnumC4868cf.CONTACT, "/v3/poston/delposton").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("buddyid", str).m10641a("mode", "returnlist").m10641a(VKApiConst.COUNT, "30").m10641a("fulltext", "false").m10641a("length", "140").m10641a("mode", "returnlist|showorder").m10643b(C2407b.class).m10639a(GetPostONList.class).m10635a(), str2, true), 903, this.f7560a);
    }

    /* renamed from: c */
    public void m9298c(String str, String str2) {
        C2472w.m10687a().m10691c().m10662a(new C1912al(new C2456g(EnumC4868cf.CONTACT, "/v3/poston/delposton").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("buddyid", str).m10641a("mode", "returnlist").m10641a(VKApiConst.COUNT, "30").m10641a("fulltext", "false").m10641a("length", "140").m10641a("mode", "returnlist|showorder").m10643b(C2407b.class).m10639a(GetPostONList.class).m10635a(), str2, false), 903, this.f7560a);
    }

    /* renamed from: b */
    public void m9294b() {
        this.f7562c = C2472w.m10687a().m10691c().m10662a(new C1958cd(new C2456g(EnumC4868cf.CONTACT, "/poston/blind").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(VKApiConst.COUNT, "2000").m10639a(GetPostONBlindList.class).m10635a()), 905, this.f7560a);
    }

    /* renamed from: c */
    public void m9297c() {
        if (this.f7562c != null) {
            C4904y.m18646e("getPostONBlindListCancel() is called", "PostONControl");
            this.f7562c.cancel(true);
        }
    }

    /* renamed from: a */
    public void m9293a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        C2472w.m10687a().m10691c().m10662a(new C2058q(new C2456g(EnumC4868cf.CONTACT, "/poston/blind").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "returnlist").m10641a(VKApiConst.COUNT, "2000").m10639a(GetPostONBlindList.class).m10635a(), arrayList, arrayList2), 904, this.f7560a);
    }

    /* renamed from: d */
    public void m9300d(String str, String str2) {
        this.f7563d = C2472w.m10687a().m10691c().m10662a(new C1959ce(new C2456g(EnumC4868cf.CONTACT, "/v3/poston/commentlist").m10637a(EnumC2457h.GET).m10641a("buddyid", str).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("parentpostonid", str2).m10641a(VKApiConst.COUNT, "30").m10641a("fulltext", "false").m10641a("length", "140").m10641a("mode", "checkexist").m10643b(C2407b.class).m10639a(GetPostONCommentList.class).m10635a(), true), 906, this.f7560a);
    }

    /* renamed from: d */
    public void m9299d() {
        if (this.f7563d != null) {
            C4904y.m18646e("getPostONCommentListCancel() is called", "PostONControl");
            this.f7563d.cancel(true);
        }
    }

    /* renamed from: a */
    public void m9291a(String str, String str2, String str3) {
        this.f7563d = C2472w.m10687a().m10691c().m10662a(new C1959ce(new C2456g(EnumC4868cf.CONTACT, "/v3/poston/commentlist").m10637a(EnumC2457h.GET).m10641a("buddyid", str).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(VKApiConst.COUNT, "30").m10641a("starttime", Long.valueOf(Long.parseLong(str2) + 1).toString()).m10641a("fulltext", "false").m10641a("length", "140").m10641a("parentpostonid", str3).m10643b(C2407b.class).m10639a(GetPostONCommentList.class).m10635a(), false), 906, this.f7560a);
    }

    /* renamed from: a */
    public void m9289a(String str, C3021p c3021p, String str2) {
        C2472w.m10687a().m10691c().m10662a(new C2046fk(new C2456g(EnumC4868cf.CONTACT, "/v3/poston/comment").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "returnlist").m10641a(VKApiConst.COUNT, "30").m10641a("fulltext", "false").m10641a("length", "140").m10641a("blockmode", "true").m10643b(C2407b.class).m10639a(GetPostONCommentList.class).m10635a(), str, c3021p, str2), 907, this.f7560a);
    }

    /* renamed from: a */
    public void m9292a(String str, String str2, String str3, String str4) {
        C2472w.m10687a().m10691c().m10662a(new C1911ak(new C2456g(EnumC4868cf.CONTACT, "/v3/poston/delcomment").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("buddyid", str).m10641a("parentpostonid", str3).m10641a("mode", "returnlist").m10641a(VKApiConst.COUNT, "30").m10641a("fulltext", "false").m10641a("length", "140").m10643b(C2407b.class).m10639a(GetPostONCommentList.class).m10635a(), str2, str4), 910, this.f7560a);
    }

    /* renamed from: b */
    public void m9296b(String str, String str2, String str3, String str4) {
        C2472w.m10687a().m10691c().m10662a(new C1911ak(new C2456g(EnumC4868cf.CONTACT, "/v3/poston/delcomment").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("buddyid", str).m10641a("parentpostonid", str3).m10641a("mode", "returnlist").m10641a(VKApiConst.COUNT, "30").m10641a("fulltext", "false").m10641a("length", "140").m10643b(C2407b.class).m10639a(GetPostONCommentList.class).m10635a(), str2, str4), 910, this.f7560a);
    }

    /* renamed from: e */
    public void m9301e(String str, String str2) {
        this.f7564e = C2472w.m10687a().m10691c().m10662a(new C1960cf(new C2456g(EnumC4868cf.CONTACT, "/v3/poston/detail").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("postonid", str).m10641a("checkmode", "true").m10641a("commentmode", "y").m10641a(VKApiConst.COUNT, "30").m10641a("readmode", "read").m10641a("mode", "showorder").m10643b(C2407b.class).m10639a(GetPostONDetailInfoList.class).m10635a(), str2, str), 912, this.f7560a);
    }
}
