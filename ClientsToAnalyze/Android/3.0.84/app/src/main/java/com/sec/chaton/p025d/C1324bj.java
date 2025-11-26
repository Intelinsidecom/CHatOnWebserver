package com.sec.chaton.p025d;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.p026a.C1215cp;
import com.sec.chaton.p025d.p026a.C1216cq;
import com.sec.chaton.p025d.p026a.C1267f;
import com.sec.chaton.p025d.p026a.C1282u;
import com.sec.chaton.p035io.entry.AvaliableApps;
import com.sec.chaton.p035io.entry.GetVersion;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3219cg;
import java.io.IOException;
import java.net.URLEncoder;

/* compiled from: VersionControl.java */
/* renamed from: com.sec.chaton.d.bj */
/* loaded from: classes.dex */
public class C1324bj {

    /* renamed from: a */
    private Handler f5002a;

    public C1324bj(Handler handler) {
        this.f5002a = handler;
    }

    /* renamed from: a */
    public void m5692a() {
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/version").m6710a(EnumC1583k.GET).m6709a(1101).m6712a(GetVersion.class);
        c1582jM6712a.m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("version", C0816a.f3112a);
        if (GlobalApplication.f5511a != null) {
            c1582jM6712a.m6714a("regid", GlobalApplication.f5511a).m6714a("pushtype", "SPP");
        }
        c1582jM6712a.m6714a("region", C3159aa.m10962a().m10979a("primary_region", ""));
        C1595w.m6742a().m6745b().m6723a(new C1216cq(this.f5002a, c1582jM6712a.m6708a()));
    }

    /* renamed from: b */
    public C1215cp m5694b() {
        C3250y.m11450b("enter getVersionNoti", "ChatON");
        if (C3159aa.m10962a().m10979a("primary_contact_addrss", (String) null) == null) {
            return null;
        }
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, "/version/versionnotidis").m6710a(EnumC1583k.GET).m6709a(1104).m6712a(GetVersionNotice.class);
        C3250y.m11450b("Exist iso from sim : " + TextUtils.isEmpty(C3171am.m11060d()) + "iso from file : " + C3159aa.m10962a().m10979a("country_letter", "GB"), getClass().getSimpleName());
        c1582jM6712a.m6714a("imei", C3171am.m11045a()).m6714a("iso", TextUtils.isEmpty(C3171am.m11082t()) ? "GB" : C3171am.m11082t()).m6714a("platform", "android").m6714a("osversion", Build.VERSION.SDK).m6714a("model", URLEncoder.encode(C3171am.m11055b())).m6714a("appversion", C0816a.f3112a).m6714a("language", C3171am.m11074l()).m6714a("timestamp", C3159aa.m10962a().m10979a("accept_time", "0")).m6714a("screensize", C3171am.m11076n()).m6714a("samsungapps", String.valueOf(C3171am.m11075m())).m6714a("iso2", TextUtils.isEmpty(C3171am.m11082t()) ? "GB" : C3171am.m11082t()).m6714a("uid", C3159aa.m10962a().m10979a("uid", (String) null));
        C1215cp c1215cp = new C1215cp(this.f5002a, c1582jM6712a.m6708a());
        C1595w.m6742a().m6745b().m6723a(c1215cp);
        return c1215cp;
    }

    /* renamed from: a */
    public void m5693a(String str) {
        if (C3159aa.m10962a().m10979a("primary_contact_addrss", (String) null) != null) {
            C1595w.m6742a().m6745b().m6723a(new C1267f(this.f5002a, new C1582j(EnumC3219cg.CONTACT, "/disclaimer/accept").m6710a(EnumC1583k.POST).m6709a(1105).m6708a(), str));
        }
    }

    /* renamed from: c */
    public void m5695c() throws Throwable {
        String strM11078p = "";
        try {
            strM11078p = C3171am.m11078p();
        } catch (IOException e) {
            C3250y.m11450b("there is exception ", getClass().getSimpleName());
            e.printStackTrace();
        }
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.APPS, "/product/appCheck.as").m6710a(EnumC1583k.GET).m6709a(1106).m6712a(AvaliableApps.class);
        c1582jM6712a.m6714a("appInfo", "com.sec.chaton@" + C0816a.f3112a).m6714a("deviceId", URLEncoder.encode(C3171am.m11055b())).m6714a("mcc", C3171am.m11068h() != null ? C3171am.m11068h() : C3171am.m11064f()).m6714a("mnc", C3171am.m11070i() != null ? C3171am.m11070i() : C3171am.m11066g()).m6714a("csc", strM11078p).m6714a("openApi", Build.VERSION.SDK).m6714a("pd", "");
        C1595w.m6742a().m6745b().m6723a(new C1282u(this.f5002a, c1582jM6712a.m6708a()));
    }
}
