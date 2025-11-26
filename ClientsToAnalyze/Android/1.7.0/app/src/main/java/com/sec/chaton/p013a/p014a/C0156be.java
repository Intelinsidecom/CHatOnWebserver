package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1349x;
import java.util.LinkedHashMap;

/* compiled from: AcceptDisclaimerTask.java */
/* renamed from: com.sec.chaton.a.a.be */
/* loaded from: classes.dex */
public class C0156be extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private String f374a;

    public C0156be(Handler handler, C0503j c0503j, String str) {
        super(handler, c0503j);
        this.f374a = str;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        C1349x c1349x = new C1349x();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("imei", C1336k.m4621a());
        linkedHashMap.put("mcc", C1336k.m4630g());
        linkedHashMap.put("iso", C1336k.m4628e());
        if (!this.f374a.equals("FIRST")) {
            linkedHashMap.put("disclaimerUID", this.f374a);
        }
        String strM4714a = c1349x.m4714a((Object) linkedHashMap);
        C1341p.m4662e(strM4714a, getClass().getSimpleName());
        return strM4714a;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        if (c0259g.m927a() && c0259g.m928b() != EnumC0518y.ERROR) {
            C1341p.m4658b("Success to accept disclaimer", getClass().getSimpleName());
        }
    }
}
