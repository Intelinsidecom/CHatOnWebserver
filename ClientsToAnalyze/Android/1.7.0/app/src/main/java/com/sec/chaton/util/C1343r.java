package com.sec.chaton.util;

import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.p014a.C0149ay;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.p033io.entry.GetVersion;

/* compiled from: ChatONCryptoKeyMgr.java */
/* renamed from: com.sec.chaton.util.r */
/* loaded from: classes.dex */
public class C1343r {

    /* renamed from: a */
    private String f4584a = "";

    /* renamed from: a */
    public synchronized String m4670a() {
        if (TextUtils.isEmpty(this.f4584a)) {
            m4669c();
        }
        return this.f4584a;
    }

    /* renamed from: b */
    public synchronized void m4671b() {
        this.f4584a = "";
    }

    /* renamed from: c */
    private boolean m4669c() {
        GetVersion getVersion;
        C1341p.m4658b("retrieveCryptoKey", getClass().getSimpleName());
        C0519z c0519zM2582a = new C0519z(EnumC1333h.CONTACT, "/version").m2581a(EnumC0511r.GET).m2580a(1101).m2582a(GetVersion.class);
        c0519zM2582a.m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("version", C0684a.f2331b);
        if (GlobalApplication.f2407a != null) {
            c0519zM2582a.m2584a("regid", GlobalApplication.f2407a).m2584a("pushtype", "SPP");
        }
        c0519zM2582a.m2584a("region", C1323bs.m4575a().getString("primary_region", ""));
        C0259g c0259gE = new C0149ay(null, c0519zM2582a.m2579a()).m687e();
        if (c0259gE.m927a() && c0259gE.m928b() != EnumC0518y.ERROR && (getVersion = (GetVersion) c0259gE.m932d()) != null) {
            C1341p.m4662e(getVersion.toString(), getClass().getSimpleName());
            if (getVersion.key != null) {
                this.f4584a = getVersion.key;
                if (!TextUtils.isEmpty(this.f4584a)) {
                    C1341p.m4658b("retrieveCryptoKey - Success", getClass().getSimpleName());
                    return true;
                }
            }
        }
        C1341p.m4658b("retrieveCryptoKey - Fail", getClass().getSimpleName());
        return false;
    }
}
