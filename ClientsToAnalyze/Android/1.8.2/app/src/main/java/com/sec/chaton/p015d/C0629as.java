package com.sec.chaton.p015d;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.p015d.p016a.C0560ba;
import com.sec.chaton.p015d.p016a.C0561bb;
import com.sec.chaton.p015d.p016a.C0593i;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.p028io.entry.AvaliableApps;
import com.sec.chaton.p028io.entry.GetVersion;
import com.sec.chaton.p028io.entry.GetVersionNotice;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;
import java.io.IOException;
import java.net.URLEncoder;

/* compiled from: VersionControl.java */
/* renamed from: com.sec.chaton.d.as */
/* loaded from: classes.dex */
public class C0629as {

    /* renamed from: a */
    private Handler f2461a;

    public C0629as(Handler handler) {
        this.f2461a = handler;
    }

    /* renamed from: a */
    public void m2832a() {
        C0800j c0800jM3407a = new C0800j(EnumC1765bu.CONTACT, "/version").m3406a(EnumC0801k.GET).m3405a(1101).m3407a(GetVersion.class);
        c0800jM3407a.m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("version", C0452a.f1723b);
        if (GlobalApplication.f2775a != null) {
            c0800jM3407a.m3409a("regid", GlobalApplication.f2775a).m3409a("pushtype", "SPP");
        }
        c0800jM3407a.m3409a("region", C1789u.m6075a().getString("primary_region", ""));
        C0802l.m3412a().offer(new C0561bb(this.f2461a, c0800jM3407a.m3404a()));
    }

    /* renamed from: b */
    public void m2833b() {
        String strM5891r = "";
        try {
            strM5891r = C1721ad.m5891r();
        } catch (IOException e) {
            C1786r.m6061b("there is exception ", getClass().getSimpleName());
            e.printStackTrace();
        }
        C0800j c0800jM3407a = new C0800j(EnumC1765bu.APPS, "/product/appCheck.as").m3406a(EnumC0801k.GET).m3405a(1107).m3407a(AvaliableApps.class);
        c0800jM3407a.m3409a("appInfo", "com.sec.chaton@" + C0452a.f1723b).m3409a("deviceID", URLEncoder.encode(C1721ad.m5876c())).m3409a("mcc", C1721ad.m5883j() != null ? C1721ad.m5883j() : C1721ad.m5881h()).m3409a("mnc", C1721ad.m5884k() != null ? C1721ad.m5884k() : C1721ad.m5882i()).m3409a("csc", strM5891r).m3409a("openApi", Build.VERSION.SDK).m3409a("pd", "");
        C0802l.m3412a().offer(new C0593i(this.f2461a, c0800jM3407a.m3404a()));
    }

    /* renamed from: c */
    public void m2834c() {
        C1786r.m6061b("enter getVersionNoti", "ChatON");
        if (C1789u.m6075a().getString("primary_contact_addrss", null) != null) {
            C0800j c0800jM3407a = new C0800j(EnumC1765bu.CONTACT, "/version/versionnotidis").m3406a(EnumC0801k.GET).m3405a(1105).m3407a(GetVersionNotice.class);
            C1786r.m6061b("Exist iso from sim : " + TextUtils.isEmpty(C1721ad.m5878e()) + "iso from file : " + C1789u.m6075a().getString("country_letter", "GB"), getClass().getSimpleName());
            c0800jM3407a.m3409a("imei", C1721ad.m5873a()).m3409a("iso", TextUtils.isEmpty(C1721ad.m5892s()) ? "GB" : C1721ad.m5892s()).m3409a("platform", "android").m3409a("osversion", Build.VERSION.SDK).m3409a("model", URLEncoder.encode(C1721ad.m5876c())).m3409a("appversion", C0452a.f1723b).m3409a("language", C1721ad.m5879f()).m3409a("timestamp", C1789u.m6075a().getString("accept_time", "0")).m3409a("screensize", C1721ad.m5890q()).m3409a("samsungapps", String.valueOf(C1721ad.m5889p())).m3409a("iso2", C1721ad.m5893t());
            C0802l.m3412a().offer(new C0560ba(this.f2461a, c0800jM3407a.m3404a()));
        }
    }
}
