package com.sec.chaton.p013a;

import android.os.Handler;
import com.sec.chaton.memo.C0734g;
import com.sec.chaton.p013a.p014a.C0129ae;
import com.sec.chaton.p013a.p014a.C0147aw;
import com.sec.chaton.p013a.p014a.C0160bi;
import com.sec.chaton.p013a.p014a.C0168g;
import com.sec.chaton.p013a.p014a.C0174m;
import com.sec.chaton.p013a.p014a.C0179r;
import com.sec.chaton.p018c.C0512s;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.p033io.entry.GetMemoBlindList;
import com.sec.chaton.p033io.entry.GetMemoList;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.EnumC1333h;
import java.util.ArrayList;

/* compiled from: MemoControl.java */
/* renamed from: com.sec.chaton.a.w */
/* loaded from: classes.dex */
public class C0224w {

    /* renamed from: a */
    private Handler f559a;

    public C0224w(Handler handler) {
        this.f559a = handler;
    }

    /* renamed from: a */
    public void m864a(String str) {
        C0512s.m2577a().offer(new C0179r(this.f559a, new C0519z(EnumC1333h.CONTACT, "/memo/list/" + str).m2581a(EnumC0511r.GET).m2580a(901).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("count", "30").m2584a("fulltext", "false").m2584a("length", "140").m2582a(GetMemoList.class).m2579a(), str));
    }

    /* renamed from: a */
    public void m865a(String str, String str2) {
        C0512s.m2577a().offer(new C0168g(this.f559a, new C0519z(EnumC1333h.CONTACT, "/memo/list/" + str).m2581a(EnumC0511r.GET).m2580a(901).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("count", "30").m2584a("starttime", Long.valueOf(Long.parseLong(str2) - 1).toString()).m2584a("fulltext", "false").m2584a("length", "140").m2582a(GetMemoList.class).m2579a(), str));
    }

    /* renamed from: a */
    public void m863a(C0734g c0734g) {
        C0512s.m2577a().offer(new C0147aw(this.f559a, new C0519z(EnumC1333h.CONTACT, "/memo").m2581a(EnumC0511r.PUT).m2580a(903).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2579a(), c0734g));
    }

    /* renamed from: a */
    public void m866a(String str, String str2, String str3) {
        C0512s.m2577a().offer(new C0160bi(this.f559a, new C0519z(EnumC1333h.CONTACT, "/memo").m2581a(EnumC0511r.DELETE).m2580a(904).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("buddyid", str).m2584a("timestamp", str2).m2584a("isreceiver", str3).m2579a(), str2));
    }

    /* renamed from: b */
    public void m868b(String str, String str2) {
        C0512s.m2577a().offer(new C0160bi(this.f559a, new C0519z(EnumC1333h.CONTACT, "/memo").m2581a(EnumC0511r.DELETE).m2580a(904).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("buddyid", str).m2584a("timestamp", str2).m2579a(), str2));
    }

    /* renamed from: a */
    public void m862a() {
        C0512s.m2577a().offer(new C0129ae(this.f559a, new C0519z(EnumC1333h.CONTACT, "/memo/blind").m2581a(EnumC0511r.GET).m2580a(905).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("count", "2000").m2582a(GetMemoBlindList.class).m2579a()));
    }

    /* renamed from: a */
    public void m867a(ArrayList arrayList, ArrayList arrayList2) {
        C0512s.m2577a().offer(new C0174m(this.f559a, new C0519z(EnumC1333h.CONTACT, "/memo/blind").m2581a(EnumC0511r.POST).m2580a(906).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2579a(), arrayList, arrayList2));
    }
}
