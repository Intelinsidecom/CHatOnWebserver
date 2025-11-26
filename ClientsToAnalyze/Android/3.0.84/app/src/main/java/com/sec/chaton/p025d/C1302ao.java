package com.sec.chaton.p025d;

import android.content.pm.PackageManager;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;

/* compiled from: PushControlFactory.java */
/* renamed from: com.sec.chaton.d.ao */
/* loaded from: classes.dex */
public class C1302ao {

    /* renamed from: a */
    private static final String f4931a = C1302ao.class.getSimpleName();

    /* renamed from: b */
    private static C1294ag f4932b;

    /* renamed from: a */
    public static AbstractC1144a<?> m5594a() {
        if (m5595b()) {
            return C1348z.m5947e();
        }
        if (f4932b == null) {
            f4932b = new C1294ag();
        }
        return f4932b;
    }

    /* renamed from: b */
    public static boolean m5595b() throws PackageManager.NameNotFoundException {
        boolean zM11778a = C3347i.m11778a(CommonApplication.m11493l(), "com.sec.spp.push");
        if (C3250y.f11734b && zM11778a) {
            C3250y.m11450b("Public push service is insatlled, using it.", f4931a);
        }
        return zM11778a;
    }
}
