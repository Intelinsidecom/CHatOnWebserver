package com.sec.chaton.p015d;

import android.os.Handler;
import com.sec.chaton.memo.C0839c;
import com.sec.chaton.p015d.p016a.C0552at;
import com.sec.chaton.p015d.p016a.C0553au;
import com.sec.chaton.p015d.p016a.C0554av;
import com.sec.chaton.p015d.p016a.C0587ca;
import com.sec.chaton.p015d.p016a.C0594j;
import com.sec.chaton.p015d.p016a.C0599o;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.p028io.entry.GetMemoBlindList;
import com.sec.chaton.p028io.entry.GetMemoList;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;
import java.util.ArrayList;

/* compiled from: MemoControl.java */
/* renamed from: com.sec.chaton.d.j */
/* loaded from: classes.dex */
public class C0638j {

    /* renamed from: a */
    private Handler f2478a;

    /* renamed from: b */
    private C0594j f2479b;

    /* renamed from: c */
    private C0552at f2480c;

    public C0638j(Handler handler) {
        this.f2478a = handler;
    }

    /* renamed from: a */
    public void m2897a(String str) {
        C0802l.m3412a().offer(new C0554av(this.f2478a, new C0800j(EnumC1765bu.CONTACT, "/memo/list/" + str).m3406a(EnumC0801k.GET).m3405a(901).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("count", "30").m3409a("fulltext", "false").m3409a("length", "140").m3407a(GetMemoList.class).m3404a(), str));
    }

    /* renamed from: a */
    public void m2898a(String str, String str2) {
        C0802l.m3412a().offer(new C0553au(this.f2478a, new C0800j(EnumC1765bu.CONTACT, "/memo/list/" + str).m3406a(EnumC0801k.GET).m3405a(901).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("count", "30").m3409a("starttime", Long.valueOf(Long.parseLong(str2) - 1).toString()).m3409a("fulltext", "false").m3409a("length", "140").m3407a(GetMemoList.class).m3404a(), str));
    }

    /* renamed from: a */
    public void m2896a(C0839c c0839c) {
        C0802l.m3412a().offer(new C0587ca(this.f2478a, new C0800j(EnumC1765bu.CONTACT, "/memo").m3406a(EnumC0801k.PUT).m3405a(903).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a(), c0839c));
    }

    /* renamed from: a */
    public void m2899a(String str, String str2, String str3) {
        C0802l.m3412a().offer(new C0599o(this.f2478a, new C0800j(EnumC1765bu.CONTACT, "/memo").m3406a(EnumC0801k.DELETE).m3405a(904).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("buddyid", str).m3409a("timestamp", str2).m3409a("isreceiver", str3).m3404a(), str2));
    }

    /* renamed from: b */
    public void m2902b(String str, String str2) {
        C0802l.m3412a().offer(new C0599o(this.f2478a, new C0800j(EnumC1765bu.CONTACT, "/memo").m3406a(EnumC0801k.DELETE).m3405a(904).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("buddyid", str).m3409a("timestamp", str2).m3404a(), str2));
    }

    /* renamed from: a */
    public void m2895a() {
        this.f2480c = new C0552at(this.f2478a, new C0800j(EnumC1765bu.CONTACT, "/memo/blind").m3406a(EnumC0801k.GET).m3405a(905).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("count", "2000").m3407a(GetMemoBlindList.class).m3404a());
        C0802l.m3412a().offer(this.f2480c);
    }

    /* renamed from: a */
    public void m2900a(ArrayList arrayList, ArrayList arrayList2) {
        this.f2479b = new C0594j(this.f2478a, new C0800j(EnumC1765bu.CONTACT, "/memo/blind").m3406a(EnumC0801k.POST).m3405a(906).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a(), arrayList, arrayList2);
        C0802l.m3412a().offer(this.f2479b);
    }

    /* renamed from: b */
    public void m2901b() {
        if (this.f2479b != null) {
            this.f2479b.m2710c();
        }
    }

    /* renamed from: c */
    public void m2903c() {
        if (this.f2480c != null) {
            this.f2480c.m2710c();
        }
    }
}
