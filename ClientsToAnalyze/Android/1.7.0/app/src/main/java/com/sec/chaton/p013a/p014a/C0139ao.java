package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1349x;
import java.util.LinkedHashMap;

/* compiled from: SetPrivacyTask.java */
/* renamed from: com.sec.chaton.a.a.ao */
/* loaded from: classes.dex */
public class C0139ao extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private String f335a;

    /* renamed from: b */
    private boolean f336b;

    public C0139ao(Handler handler, C0503j c0503j, String str, boolean z) {
        super(handler, c0503j);
        this.f335a = str;
        this.f336b = z;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        C1349x c1349x = new C1349x();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("privacy", this.f335a);
        linkedHashMap.put("value", this.f336b ? "true" : "false");
        String strM4714a = c1349x.m4714a((Object) linkedHashMap);
        C1341p.m4662e(strM4714a, getClass().getSimpleName());
        return strM4714a;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        if (c0259g.m927a() && c0259g.m928b() == EnumC0518y.SUCCESS) {
            C1323bs.m4576a("show_phone_number_to_all", Boolean.valueOf(this.f336b));
        }
    }
}
