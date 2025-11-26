package com.sec.chaton.p055d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import com.sec.chaton.p055d.p056a.C2057p;
import com.sec.chaton.p065io.entry.AvaliableApps;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import java.io.IOException;
import java.net.URLEncoder;

/* compiled from: SPPUpdateControl.java */
/* renamed from: com.sec.chaton.d.bi */
/* loaded from: classes.dex */
public class C2103bi {

    /* renamed from: c */
    private static String f7632c;

    /* renamed from: a */
    final String f7633a = "com.sec.android.app.samsungapps";

    /* renamed from: b */
    private final String f7634b = getClass().getSimpleName();

    /* renamed from: d */
    private Handler f7635d;

    static {
        try {
            f7632c = CommonApplication.m18732r().getPackageManager().getPackageInfo("com.sec.spp.push", 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            C4904y.m18639b("SPPPushClient is not installed yet.", "SPPVersionControl()");
        }
    }

    public C2103bi(Handler handler) {
        this.f7635d = handler;
    }

    /* renamed from: a */
    public void m9386a(Context context) throws Throwable {
        if (C5034k.m19095a(context, "com.sec.android.app.samsungapps") && Build.VERSION.SDK_INT >= 7) {
            String strM18252t = "";
            try {
                strM18252t = C4822an.m18252t();
            } catch (IOException e) {
                C4904y.m18639b("progressSPPUpdate() : IOException at DeviceInfoUtil.getCSC()", this.f7634b);
                e.printStackTrace();
            }
            C2456g c2456gM10639a = new C2456g(EnumC4868cf.APPS, "/product/appCheck.as").m10637a(EnumC2457h.GET).m10639a(AvaliableApps.class);
            c2456gM10639a.m10641a("appInfo", "com.sec.spp.push@" + f7632c).m10641a("deviceId", URLEncoder.encode(C4822an.m18231e())).m10641a("mcc", C4822an.m18243k() != null ? C4822an.m18243k() : C4822an.m18241i()).m10641a("mnc", C4822an.m18244l() != null ? C4822an.m18244l() : C4822an.m18242j()).m10641a("csc", strM18252t).m10641a("openApi", Build.VERSION.SDK).m10641a("pd", "");
            C2472w.m10687a().m10690b().m10662a(new C2057p(c2456gM10639a.m10635a()), 1106, this.f7635d);
        }
    }
}
