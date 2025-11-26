package com.sec.chaton.p055d;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.p056a.C1976cv;
import com.sec.chaton.p055d.p056a.C1977cw;
import com.sec.chaton.p055d.p056a.C2008e;
import com.sec.chaton.p055d.p056a.C2057p;
import com.sec.chaton.p065io.entry.AvaliableApps;
import com.sec.chaton.p065io.entry.GetVersion;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.spp.push.Config;
import java.io.IOException;
import java.net.URLEncoder;

/* compiled from: VersionControl.java */
/* renamed from: com.sec.chaton.d.ca */
/* loaded from: classes.dex */
public class C2122ca {

    /* renamed from: a */
    private Handler f7699a;

    public C2122ca(Handler handler) {
        this.f7699a = handler;
    }

    /* renamed from: a */
    public void m9469a() {
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/version").m10637a(EnumC2457h.GET).m10639a(GetVersion.class);
        c2456gM10639a.m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(VKOpenAuthActivity.VK_EXTRA_API_VERSION, C1427a.f5063a);
        if (GlobalApplication.f8355a != null) {
            c2456gM10639a.m10641a("regid", GlobalApplication.f8355a).m10641a("pushtype", "SPP");
        }
        if (C2349a.m10301a("gcm_push_feature") && GlobalApplication.f8356b != null) {
            c2456gM10639a.m10641a("gcmid", GlobalApplication.f8356b);
        }
        c2456gM10639a.m10641a("region", C4809aa.m18104a().m18121a("primary_region", ""));
        C2472w.m10687a().m10690b().m10662a(new C1977cw(c2456gM10639a.m10635a()), 1101, this.f7699a);
    }

    /* renamed from: b */
    public C1976cv m9471b() {
        String str;
        C4904y.m18639b("enter getVersionNoti", "ChatON");
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/version/versionnotidis").m10637a(EnumC2457h.GET).m10639a(GetVersionNotice.class);
        String packageName = GlobalApplication.m18732r().getPackageName();
        if (Config.CHATON_PACKAGE_NAME.equals(packageName)) {
            str = "global";
        } else {
            str = "com.sec.chatonforcanada".equals(packageName) ? "canada" : null;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("Exist iso from sim : " + TextUtils.isEmpty(C4822an.m18236g()) + "iso from file : " + C4809aa.m18104a().m18121a("country_letter", "GB"), getClass().getSimpleName());
            C4904y.m18639b("package infor : " + packageName + " region : " + str, getClass().getSimpleName());
        }
        if (C4822an.m18218a()) {
            c2456gM10639a.m10641a("iso", TextUtils.isEmpty(C4822an.m18257y()) ? "GB" : C4822an.m18257y()).m10641a("iso2", TextUtils.isEmpty(C4822an.m18257y()) ? "GB" : C4822an.m18257y());
        } else {
            c2456gM10639a.m10641a("iso", TextUtils.isEmpty(C4822an.m18253u()) ? "GB" : C4822an.m18253u()).m10641a("iso2", TextUtils.isEmpty(C4822an.m18253u()) ? "GB" : C4822an.m18253u());
        }
        c2456gM10639a.m10641a("imei", C4822an.m18228d()).m10641a("platform", "android").m10641a("osversion", Build.VERSION.SDK).m10641a("model", URLEncoder.encode(C4822an.m18231e())).m10641a("appversion", C1427a.f5063a).m10641a("language", C4822an.m18247o()).m10641a("timestamp", C4809aa.m18104a().m18121a("accept_time", Spam.ACTIVITY_CANCEL)).m10641a("screensize", C4822an.m18250r()).m10641a("samsungapps", String.valueOf(C4822an.m18249q())).m10641a("uid", C4809aa.m18104a().m18121a("uid", (String) null));
        if (str != null) {
            c2456gM10639a.m10641a("region", str);
        }
        C1976cv c1976cv = new C1976cv(c2456gM10639a.m10635a());
        C2472w.m10687a().m10690b().m10662a(c1976cv, 1104, this.f7699a);
        return c1976cv;
    }

    /* renamed from: a */
    public void m9470a(String str) {
        C2472w.m10687a().m10690b().m10662a(new C2008e(new C2456g(EnumC4868cf.CONTACT, "/disclaimer/accept").m10637a(EnumC2457h.POST).m10635a(), str), 1105, this.f7699a);
    }

    /* renamed from: c */
    public void m9472c() throws Throwable {
        String strM18252t = "";
        try {
            strM18252t = C4822an.m18252t();
        } catch (IOException e) {
            C4904y.m18639b("there is exception ", getClass().getSimpleName());
            e.printStackTrace();
        }
        String packageName = GlobalApplication.m18732r().getPackageName();
        if (C4904y.f17872b) {
            C4904y.m18639b("[availableApps] packageInfo : " + packageName, getClass().getSimpleName());
        }
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.APPS, "/product/appCheck.as").m10637a(EnumC2457h.GET).m10639a(AvaliableApps.class);
        c2456gM10639a.m10641a("appInfo", packageName + "@" + C1427a.f5063a).m10641a("deviceId", URLEncoder.encode(C4822an.m18231e())).m10641a("mcc", C4822an.m18243k() != null ? C4822an.m18243k() : C4822an.m18241i()).m10641a("mnc", C4822an.m18244l() != null ? C4822an.m18244l() : C4822an.m18242j()).m10641a("csc", strM18252t).m10641a("openApi", Build.VERSION.SDK).m10641a("pd", "");
        C2472w.m10687a().m10690b().m10662a(new C2057p(c2456gM10639a.m10635a()), 1106, this.f7699a);
    }
}
