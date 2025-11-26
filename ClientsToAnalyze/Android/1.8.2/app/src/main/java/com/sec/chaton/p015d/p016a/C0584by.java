package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p007a.p008a.C0107h;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.C1793y;
import java.util.LinkedHashMap;

/* compiled from: UploadProfileTask2.java */
/* renamed from: com.sec.chaton.d.a.by */
/* loaded from: classes.dex */
public class C0584by extends AbstractRunnableC0532a {

    /* renamed from: d */
    private C0107h f2322d;

    /* renamed from: e */
    private String f2323e;

    /* renamed from: f */
    private String f2324f;

    public C0584by(Handler handler, C0798h c0798h, C0107h c0107h, String str) {
        super(handler, c0798h);
        this.f2322d = c0107h;
        this.f2324f = str;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        C1793y c1793y = new C1793y();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.f2322d.m682a() != null) {
            linkedHashMap.put("name", this.f2322d.m682a());
        }
        if (this.f2322d.m684b() != null) {
            linkedHashMap.put("status", this.f2322d.m684b());
        }
        if (this.f2322d.m686c() != null) {
            this.f2323e = this.f2322d.m686c();
            if ("FULL".equals(this.f2324f)) {
                linkedHashMap.put("birthday", this.f2322d.m686c());
            } else if ("SHORT".equals(this.f2324f)) {
                linkedHashMap.put("birthday", this.f2322d.m686c().substring(5, 10));
            } else if ("DONT".equals(this.f2324f)) {
                linkedHashMap.put("birthday", "0000-12-31");
            } else {
                C1786r.m6061b("Unknown birthday option", getClass().getSimpleName());
            }
        }
        if (this.f2322d.m688d() != null) {
            linkedHashMap.put("email", this.f2322d.m688d());
        }
        if (this.f2322d.m689e() != null) {
            linkedHashMap.put("samsungemail", this.f2322d.m689e());
        }
        String strM6112a = c1793y.m6112a((Object) linkedHashMap);
        C1786r.m6066e(strM6112a, getClass().getSimpleName());
        return strM6112a;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m664a() && c0101b.m665b() != EnumC0803m.ERROR) {
            if (this.f2322d.m682a() != null) {
                C1789u.m6079a("Push Name", this.f2322d.m682a());
            }
            if (this.f2322d.m684b() != null) {
                C1789u.m6079a("status_message", this.f2322d.m684b());
            }
            if (this.f2322d.m686c() != null) {
                C1789u.m6079a("birthday", this.f2323e);
                C1789u.m6079a("birthday_type", this.f2324f);
            }
            if (this.f2322d.m688d() != null) {
                C1789u.m6079a("email", this.f2322d.m688d());
            }
            if (this.f2322d.m689e() != null) {
                C1789u.m6079a("samsung_email", this.f2322d.m689e());
            }
            if (this.f2324f == "DONT") {
                C1789u.m6076a("birthday_show", (Boolean) false);
            } else {
                C1789u.m6076a("birthday_show", (Boolean) true);
            }
            c0101b.m667b(this.f2322d);
        }
    }
}
