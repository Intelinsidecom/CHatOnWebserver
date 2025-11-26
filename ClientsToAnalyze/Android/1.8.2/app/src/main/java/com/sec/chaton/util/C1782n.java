package com.sec.chaton.util;

import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.p015d.p016a.C0561bb;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.p028io.entry.GetVersion;

/* compiled from: ChatONCryptoKeyMgr.java */
/* renamed from: com.sec.chaton.util.n */
/* loaded from: classes.dex */
public class C1782n {

    /* renamed from: a */
    private String f6445a = "";

    /* renamed from: a */
    public synchronized String m6029a() {
        if (TextUtils.isEmpty(this.f6445a)) {
            m6028c();
        }
        return this.f6445a;
    }

    /* renamed from: b */
    public synchronized void m6030b() {
        this.f6445a = "";
    }

    /* renamed from: c */
    private boolean m6028c() {
        GetVersion getVersion;
        C1786r.m6061b("retrieveCryptoKey", getClass().getSimpleName());
        C0800j c0800jM3407a = new C0800j(EnumC1765bu.CONTACT, "/version").m3406a(EnumC0801k.GET).m3405a(1101).m3407a(GetVersion.class);
        c0800jM3407a.m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("version", C0452a.f1723b);
        if (GlobalApplication.f2775a != null) {
            c0800jM3407a.m3409a("regid", GlobalApplication.f2775a).m3409a("pushtype", "SPP");
        }
        c0800jM3407a.m3409a("region", C1789u.m6075a().getString("primary_region", ""));
        C0101b c0101bE = new C0561bb(null, c0800jM3407a.m3404a()).m2712e();
        if (c0101bE.m664a() && c0101bE.m665b() != EnumC0803m.ERROR && (getVersion = (GetVersion) c0101bE.m671d()) != null) {
            C1786r.m6066e(getVersion.toString(), getClass().getSimpleName());
            if (getVersion.key != null) {
                this.f6445a = getVersion.key;
                if (!TextUtils.isEmpty(this.f6445a)) {
                    C1786r.m6061b("retrieveCryptoKey - Success", getClass().getSimpleName());
                    return true;
                }
            }
        }
        C1786r.m6061b("retrieveCryptoKey - Fail", getClass().getSimpleName());
        return false;
    }
}
