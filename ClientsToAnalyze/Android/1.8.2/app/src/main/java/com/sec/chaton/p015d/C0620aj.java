package com.sec.chaton.p015d;

import android.content.pm.PackageInfo;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;
import java.util.Iterator;

/* compiled from: PushControlFactory.java */
/* renamed from: com.sec.chaton.d.aj */
/* loaded from: classes.dex */
public class C0620aj {

    /* renamed from: a */
    private static final String f2438a = C0620aj.class.getSimpleName();

    /* renamed from: b */
    private static C0612ab f2439b;

    /* renamed from: a */
    public static AbstractC0531a m2804a() {
        if (m2805b()) {
            return C0649u.m2967e();
        }
        if (f2439b == null) {
            f2439b = new C0612ab();
        }
        return f2439b;
    }

    /* renamed from: b */
    public static boolean m2805b() {
        Iterator<PackageInfo> it = GlobalApplication.m3260b().getPackageManager().getInstalledPackages(8192).iterator();
        while (it.hasNext()) {
            if (it.next().packageName.equals("com.sec.spp.push")) {
                C1786r.m6061b("Public push service is installed, using it", f2438a);
                return true;
            }
        }
        return false;
    }
}
