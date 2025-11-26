package com.sec.chaton.util;

import android.text.TextUtils;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.p056a.C1977cw;
import com.sec.chaton.p065io.entry.GetVersion5;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.p067j.EnumC2464o;

/* compiled from: ChatONCryptoKeyMgr.java */
/* renamed from: com.sec.chaton.util.n */
/* loaded from: classes.dex */
public class C4893n {

    /* renamed from: a */
    private String f17850a = "";

    /* renamed from: b */
    private String f17851b = "";

    /* renamed from: a */
    public synchronized String m18595a() {
        if (TextUtils.isEmpty(this.f17850a)) {
            m18594d();
        }
        return this.f17850a;
    }

    /* renamed from: b */
    public synchronized String m18596b() {
        return this.f17851b;
    }

    /* renamed from: c */
    public synchronized void m18597c() {
        this.f17850a = "";
        this.f17851b = "";
    }

    /* renamed from: d */
    private boolean m18594d() {
        GetVersion5 getVersion5;
        C4904y.m18639b("retrieveCryptoKey", getClass().getSimpleName());
        String str = "/version";
        if (C2349a.m10301a("push_message_encrypt_feature")) {
            str = "/v5/version";
        }
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, str).m10637a(EnumC2457h.GET).m10639a(GetVersion5.class);
        c2456gM10639a.m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(VKOpenAuthActivity.VK_EXTRA_API_VERSION, C1427a.f5063a);
        if (GlobalApplication.f8355a != null) {
            c2456gM10639a.m10641a("regid", GlobalApplication.f8355a).m10641a("pushtype", "SPP");
        }
        c2456gM10639a.m10641a("region", C4809aa.m18104a().m18121a("primary_region", ""));
        C0778b c0778bA = new C1977cw(c2456gM10639a.m10635a()).m9082a();
        if (c0778bA.m18954n() && c0778bA.m3107b() != EnumC2464o.ERROR && (getVersion5 = (GetVersion5) c0778bA.m3110e()) != null) {
            C4904y.m18646e(getVersion5.toString(), getClass().getSimpleName());
            if (getVersion5.expiredkey != null) {
                this.f17851b = getVersion5.expiredkey;
                if (!TextUtils.isEmpty(this.f17851b)) {
                    C4904y.m18639b("retrieveExpiredCryptoKey - Success", getClass().getSimpleName());
                } else {
                    C4904y.m18639b("retrieveExpiredCryptoKey - expiredkey is empty", getClass().getSimpleName());
                }
            } else {
                C4904y.m18639b("retrieveExpiredCryptoKey - expiredkey is null", getClass().getSimpleName());
            }
            if (getVersion5.key != null) {
                this.f17850a = getVersion5.key;
                if (!TextUtils.isEmpty(this.f17850a)) {
                    C4904y.m18639b("retrieveCryptoKey - Success", getClass().getSimpleName());
                    return true;
                }
            }
        }
        C4904y.m18639b("retrieveCryptoKey - Fail", getClass().getSimpleName());
        return false;
    }
}
