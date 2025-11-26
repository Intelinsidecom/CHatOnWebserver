package com.sec.chaton.p025d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import com.sec.chaton.p025d.p026a.C1282u;
import com.sec.chaton.p035io.entry.AvaliableApps;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3219cg;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;
import java.io.IOException;
import java.net.URLEncoder;

/* compiled from: SPPUpdateControl.java */
/* renamed from: com.sec.chaton.d.as */
/* loaded from: classes.dex */
public class C1306as {

    /* renamed from: c */
    private static String f4937c;

    /* renamed from: a */
    final String f4938a = "com.sec.android.app.samsungapps";

    /* renamed from: b */
    private final String f4939b = getClass().getSimpleName();

    /* renamed from: d */
    private Handler f4940d;

    static {
        try {
            f4937c = CommonApplication.m11493l().getPackageManager().getPackageInfo("com.sec.spp.push", 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            C3250y.m11450b("SPPPushClient is not installed yet.", "SPPVersionControl()");
        }
    }

    public C1306as(Handler handler) {
        this.f4940d = handler;
    }

    /* renamed from: a */
    public void m5613a(Context context) throws Throwable {
        if (C3347i.m11778a(context, "com.sec.android.app.samsungapps") && Build.VERSION.SDK_INT >= 7) {
            String strM11078p = "";
            try {
                strM11078p = C3171am.m11078p();
            } catch (IOException e) {
                C3250y.m11450b("progressSPPUpdate() : IOException at DeviceInfoUtil.getCSC()", this.f4939b);
                e.printStackTrace();
            }
            C1582j c1582jM6712a = new C1582j(EnumC3219cg.APPS, "/product/appCheck.as").m6710a(EnumC1583k.GET).m6709a(1106).m6712a(AvaliableApps.class);
            c1582jM6712a.m6714a("appInfo", "com.sec.spp.push@" + f4937c).m6714a("deviceId", URLEncoder.encode(C3171am.m11055b())).m6714a("mcc", C3171am.m11068h() != null ? C3171am.m11068h() : C3171am.m11064f()).m6714a("mnc", C3171am.m11070i() != null ? C3171am.m11070i() : C3171am.m11066g()).m6714a("csc", strM11078p).m6714a("openApi", Build.VERSION.SDK).m6714a("pd", "");
            C1595w.m6742a().m6745b().m6723a(new C1282u(this.f4940d, c1582jM6712a.m6708a()));
        }
    }
}
