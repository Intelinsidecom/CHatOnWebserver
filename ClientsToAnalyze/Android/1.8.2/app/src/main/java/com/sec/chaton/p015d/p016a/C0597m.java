package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.p022h.C0798h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.Compatibility;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.C1793y;
import java.util.ArrayList;

/* compiled from: CompatibilityTask.java */
/* renamed from: com.sec.chaton.d.a.m */
/* loaded from: classes.dex */
public class C0597m extends AbstractRunnableC0532a {

    /* renamed from: d */
    public static int f2362d = 1;

    public C0597m(Handler handler, C0798h c0798h) {
        super(handler, c0798h);
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public String mo2707a() {
        ArrayList arrayList = new ArrayList();
        Compatibility compatibility = new Compatibility();
        compatibility.type = "mixed message";
        compatibility.value = "true";
        Compatibility compatibility2 = new Compatibility();
        compatibility2.type = "doc";
        compatibility2.value = "true";
        arrayList.add(compatibility);
        arrayList.add(compatibility2);
        String strM6113b = new C1793y().m6113b(arrayList);
        C1786r.m6066e(strM6113b, getClass().getSimpleName());
        return strM6113b;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractRunnableC0532a
    /* renamed from: a */
    public void mo2708a(C0101b c0101b) {
        if (c0101b.m665b() == EnumC0803m.SUCCESS) {
            C1789u.m6079a("compatibility", C0452a.f1723b);
        } else {
            C1786r.m6066e("httpEntry.getHttpResultCode : " + c0101b.m665b(), getClass().getSimpleName());
            C1789u.m6079a("compatibility", "");
        }
    }
}
