package com.sec.chaton.p013a;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.p014a.C0148ax;
import com.sec.chaton.p013a.p014a.C0149ay;
import com.sec.chaton.p013a.p014a.C0156be;
import com.sec.chaton.p018c.C0512s;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.p033io.entry.GetVersion;
import com.sec.chaton.p033io.entry.GetVersionNotice;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.EnumC1333h;
import java.net.URLEncoder;

/* compiled from: VersionControl.java */
/* renamed from: com.sec.chaton.a.q */
/* loaded from: classes.dex */
public class C0218q {

    /* renamed from: a */
    private Handler f529a;

    public C0218q(Handler handler) {
        this.f529a = handler;
    }

    /* renamed from: a */
    public void m799a() {
        C0519z c0519zM2582a = new C0519z(EnumC1333h.CONTACT, "/version").m2581a(EnumC0511r.GET).m2580a(1101).m2582a(GetVersion.class);
        c0519zM2582a.m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("version", C0684a.f2331b);
        if (GlobalApplication.f2407a != null) {
            c0519zM2582a.m2584a("regid", GlobalApplication.f2407a).m2584a("pushtype", "SPP");
        }
        c0519zM2582a.m2584a("region", C1323bs.m4575a().getString("primary_region", ""));
        C0512s.m2577a().offer(new C0149ay(this.f529a, c0519zM2582a.m2579a()));
    }

    /* renamed from: b */
    public void m801b() {
        C1341p.m4658b("enter getVersionNoti", "ChatON");
        if (C1323bs.m4575a().getString("primary_contact_addrss", null) != null) {
            C0519z c0519zM2582a = new C0519z(EnumC1333h.CONTACT, "/version/versionnotidis").m2581a(EnumC0511r.GET).m2580a(1104).m2582a(GetVersionNotice.class);
            C1341p.m4658b("Exist iso from sim : " + TextUtils.isEmpty(C1336k.m4628e()) + "iso from file : " + C1323bs.m4575a().getString("country_letter", "GB"), getClass().getSimpleName());
            c0519zM2582a.m2584a("mcc", TextUtils.isEmpty(C1323bs.m4575a().getString("registration_mcc", null)) ? C1336k.m4630g() : C1323bs.m4575a().getString("registration_mcc", null)).m2584a("imei", C1336k.m4621a()).m2584a("iso", TextUtils.isEmpty(C1336k.m4628e()) ? C1323bs.m4575a().getString("country_letter", "GB") : C1336k.m4628e()).m2584a("platform", "android").m2584a("osversion", Build.VERSION.SDK).m2584a("model", URLEncoder.encode(C1336k.m4625c())).m2584a("appversion", C0684a.f2331b).m2584a("language", C1336k.m4633j()).m2584a("timestamp", C1323bs.m4575a().getString("accept_time", "0")).m2584a("screensize", C1336k.m4635l()).m2584a("samsungapps", String.valueOf(C1336k.m4634k()));
            C0512s.m2577a().offer(new C0148ax(this.f529a, c0519zM2582a.m2579a()));
        }
    }

    /* renamed from: a */
    public void m800a(String str) {
        if (C1323bs.m4575a().getString("primary_contact_addrss", null) != null) {
            C0512s.m2577a().offer(new C0156be(this.f529a, new C0519z(EnumC1333h.CONTACT, "/disclaimer/accept").m2581a(EnumC0511r.POST).m2580a(1105).m2579a(), str));
        }
    }
}
