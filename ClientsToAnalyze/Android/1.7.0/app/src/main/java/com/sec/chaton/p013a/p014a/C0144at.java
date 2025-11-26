package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p015b.p016a.C0260h;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1349x;
import java.util.LinkedHashMap;

/* compiled from: UploadProfileTask2.java */
/* renamed from: com.sec.chaton.a.a.at */
/* loaded from: classes.dex */
public class C0144at extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private C0260h f357a;

    /* renamed from: b */
    private String f358b;

    /* renamed from: f */
    private String f359f;

    public C0144at(Handler handler, C0503j c0503j, C0260h c0260h, String str) {
        super(handler, c0503j);
        this.f357a = c0260h;
        this.f359f = str;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        C1349x c1349x = new C1349x();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.f357a.m938a() != null) {
            linkedHashMap.put("name", this.f357a.m938a());
        }
        if (this.f357a.m940b() != null) {
            linkedHashMap.put("status", this.f357a.m940b());
        }
        if (this.f357a.m942c() != null) {
            this.f358b = this.f357a.m942c();
            if ("FULL".equals(this.f359f)) {
                linkedHashMap.put("birthday", this.f357a.m942c());
            } else if ("SHORT".equals(this.f359f)) {
                linkedHashMap.put("birthday", this.f357a.m942c().substring(5, 10));
            } else if ("DONT".equals(this.f359f)) {
                linkedHashMap.put("birthday", "0000-12-31");
            } else {
                C1341p.m4658b("Unknown birthday option", getClass().getSimpleName());
            }
        }
        if (this.f357a.m944d() != null) {
            linkedHashMap.put("email", this.f357a.m944d());
        }
        if (this.f357a.m945e() != null) {
            linkedHashMap.put("samsungemail", this.f357a.m945e());
        }
        String strM4714a = c1349x.m4714a((Object) linkedHashMap);
        C1341p.m4662e(strM4714a, getClass().getSimpleName());
        return strM4714a;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
            if (this.f357a.m938a() != null) {
                C1323bs.m4579a("Push Name", this.f357a.m938a());
            }
            if (this.f357a.m940b() != null) {
                C1323bs.m4579a("status_message", this.f357a.m940b());
            }
            if (this.f357a.m942c() != null) {
                C1323bs.m4579a("birthday", this.f358b);
                C1323bs.m4579a("birthday_type", this.f359f);
            }
            if (this.f357a.m944d() != null) {
                C1323bs.m4579a("email", this.f357a.m944d());
            }
            if (this.f357a.m945e() != null) {
                C1323bs.m4579a("samsung_email", this.f357a.m945e());
            }
            if (this.f359f == "DONT") {
                C1323bs.m4576a("birthday_show", (Boolean) false);
            } else {
                C1323bs.m4576a("birthday_show", (Boolean) true);
            }
            c0259g.m930b(this.f357a);
            for (int i = 0; i < 100000; i++) {
            }
        }
    }
}
