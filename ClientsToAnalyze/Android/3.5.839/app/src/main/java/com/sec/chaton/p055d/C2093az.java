package com.sec.chaton.p055d;

import android.content.pm.PackageManager;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;

/* compiled from: PushControlFactory.java */
/* renamed from: com.sec.chaton.d.az */
/* loaded from: classes.dex */
public class C2093az {

    /* renamed from: a */
    private static final String f7604a = C2093az.class.getSimpleName();

    /* renamed from: b */
    private static C2085ar f7605b;

    /* renamed from: a */
    public static AbstractC1899a<?> m9337a() {
        if (m9338b()) {
            return C2078ak.m9325e();
        }
        if (f7605b == null) {
            f7605b = new C2085ar();
        }
        return f7605b;
    }

    /* renamed from: b */
    public static boolean m9338b() throws PackageManager.NameNotFoundException {
        boolean zM19095a = C5034k.m19095a(CommonApplication.m18732r(), "com.sec.spp.push");
        if (C4904y.f17872b && zM19095a) {
            C4904y.m18639b("Public push service is insatlled, using it.", f7604a);
        }
        return zM19095a;
    }
}
