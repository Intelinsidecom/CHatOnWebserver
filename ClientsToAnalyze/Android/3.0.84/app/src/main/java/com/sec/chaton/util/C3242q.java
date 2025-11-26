package com.sec.chaton.util;

import android.text.TextUtils;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.p026a.C1216cq;
import com.sec.chaton.p035io.entry.GetVersion5;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.p037j.EnumC1587o;

/* compiled from: ChatONCryptoKeyMgr.java */
/* renamed from: com.sec.chaton.util.q */
/* loaded from: classes.dex */
public class C3242q {

    /* renamed from: a */
    private String f11719a = "";

    /* renamed from: b */
    private String f11720b = "";

    /* renamed from: a */
    public synchronized String m11411a() {
        if (TextUtils.isEmpty(this.f11719a)) {
            m11410d();
        }
        return this.f11719a;
    }

    /* renamed from: b */
    public synchronized String m11412b() {
        return this.f11720b;
    }

    /* renamed from: c */
    public synchronized void m11413c() {
        this.f11719a = "";
        this.f11720b = "";
    }

    /* renamed from: d */
    private boolean m11410d() {
        GetVersion5 getVersion5;
        C3250y.m11450b("retrieveCryptoKey", getClass().getSimpleName());
        String str = "/version";
        if (C1493a.m6463a("push_message_encrypt_feature")) {
            str = "/v5/version";
        }
        C1582j c1582jM6712a = new C1582j(EnumC3219cg.CONTACT, str).m6710a(EnumC1583k.GET).m6709a(1101).m6712a(GetVersion5.class);
        c1582jM6712a.m6714a("uid", C3159aa.m10962a().m10979a("uid", "")).m6714a("imei", C3171am.m11045a()).m6714a("version", C0816a.f3112a);
        if (GlobalApplication.f5511a != null) {
            c1582jM6712a.m6714a("regid", GlobalApplication.f5511a).m6714a("pushtype", "SPP");
        }
        c1582jM6712a.m6714a("region", C3159aa.m10962a().m10979a("primary_region", ""));
        C0267d c0267dE = new C1216cq(null, c1582jM6712a.m6708a()).m5495e();
        if (c0267dE.m11704n() && c0267dE.m1351b() != EnumC1587o.ERROR && (getVersion5 = (GetVersion5) c0267dE.m1354e()) != null) {
            C3250y.m11456e(getVersion5.toString(), getClass().getSimpleName());
            if (getVersion5.expiredkey != null) {
                this.f11720b = getVersion5.expiredkey;
                if (!TextUtils.isEmpty(this.f11720b)) {
                    C3250y.m11450b("retrieveExpiredCryptoKey - Success", getClass().getSimpleName());
                } else {
                    C3250y.m11450b("retrieveExpiredCryptoKey - expiredkey is empty", getClass().getSimpleName());
                }
            } else {
                C3250y.m11450b("retrieveExpiredCryptoKey - expiredkey is null", getClass().getSimpleName());
            }
            if (getVersion5.key != null) {
                this.f11719a = getVersion5.key;
                if (!TextUtils.isEmpty(this.f11719a)) {
                    C3250y.m11450b("retrieveCryptoKey - Success", getClass().getSimpleName());
                    return true;
                }
            }
        }
        C3250y.m11450b("retrieveCryptoKey - Fail", getClass().getSimpleName());
        return false;
    }
}
