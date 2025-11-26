package com.sec.chaton.p013a;

import android.content.pm.PackageManager;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: PushControlFactory.java */
/* renamed from: com.sec.chaton.a.ae */
/* loaded from: classes.dex */
public class C0192ae {

    /* renamed from: a */
    private static final String f482a = C0192ae.class.getSimpleName();

    /* renamed from: b */
    private static C0219r f483b;

    /* renamed from: a */
    public static AbstractC0196ai m739a() {
        if (m740b()) {
            return C0212k.m778a_();
        }
        if (f483b == null) {
            f483b = new C0219r();
        }
        return f483b;
    }

    /* renamed from: b */
    public static boolean m740b() throws PackageManager.NameNotFoundException {
        try {
            GlobalApplication.m3100a().getPackageManager().getPackageInfo("com.sec.spp.push", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
