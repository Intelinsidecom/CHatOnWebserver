package com.sec.chaton.control;

import android.content.pm.PackageInfo;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PushControlFactory {

    /* renamed from: a */
    private static final String f1385a = PushControlFactory.class.getSimpleName();

    /* renamed from: b */
    private static PushControl f1386b;

    /* renamed from: a */
    public static AbstractPushControl m2072a() {
        if (m2073b()) {
            return PublicPushControl.m2067a();
        }
        if (f1386b == null) {
            f1386b = new PushControl();
        }
        return f1386b;
    }

    /* renamed from: b */
    public static boolean m2073b() {
        Iterator<PackageInfo> it = GlobalApplication.m2387e().getPackageManager().getInstalledPackages(8192).iterator();
        while (it.hasNext()) {
            if (it.next().packageName.equals("com.sec.spp.push")) {
                ChatONLogWriter.m3506b("Public push service is installed, using it", f1385a);
                return true;
            }
        }
        return false;
    }
}
