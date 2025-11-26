package com.sec.chaton.p055d;

import android.os.Handler;
import android.text.TextUtils;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.sec.chaton.p055d.p056a.C1910aj;
import com.sec.chaton.p055d.p056a.C1997dp;
import com.sec.chaton.p055d.p056a.C2014ef;
import com.sec.chaton.p055d.p056a.C2015eg;
import com.sec.chaton.p055d.p056a.C2038fc;
import com.sec.chaton.p055d.p056a.C2056o;
import com.sec.chaton.p065io.entry.AutoRegisterAccounEntry;
import com.sec.chaton.p065io.entry.MappingAccountEntry;
import com.sec.chaton.p065io.entry.SSOAccessTokenEntry;
import com.sec.chaton.p065io.entry.SSOUserInformationEntry;
import com.sec.chaton.p065io.entry.SkipSMSVerifyServer;
import com.sec.chaton.p065io.entry.UpdateMSISDNEntry;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4901v;
import com.sec.chaton.util.EnumC4868cf;

/* compiled from: SamsungAccountControl.java */
/* renamed from: com.sec.chaton.d.bj */
/* loaded from: classes.dex */
public class C2104bj {

    /* renamed from: a */
    private Handler f7636a;

    public C2104bj(Handler handler) {
        this.f7636a = handler;
    }

    /* renamed from: a */
    public void m9388a(String str) {
        C2472w.m10687a().m10690b().m10662a(new C2014ef(new C2456g(EnumC4868cf.CONTACT, "/reg/ssa").m10637a(EnumC2457h.POST).m10639a(SkipSMSVerifyServer.class).m10635a(), str), 2001, this.f7636a);
    }

    /* renamed from: a */
    public void m9389a(String str, String str2, String str3) {
        C2472w.m10687a().m10690b().m10662a(new C2015eg(new C2456g(EnumC4868cf.SSO, "/auth/oauth2/token").m10637a(EnumC2457h.POST).m10639a(SSOAccessTokenEntry.class).m10644b("Content-Type", "application/json").m10643b(C4901v.class).m10641a("grant_type", "authorization_code").m10641a("code", str).m10641a(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, str2).m10641a("client_secret", str3).m10635a()), 2002, this.f7636a);
    }

    /* renamed from: b */
    public void m9392b(String str, String str2, String str3) {
        C2472w.m10687a().m10690b().m10662a(new C2015eg(new C2456g(EnumC4868cf.SSO_API, "/v2/profile/user/user/" + str3).m10637a(EnumC2457h.GET).m10639a(SSOUserInformationEntry.class).m10644b("authorization", "Bearer " + str).m10644b("x-osp-appId", str2).m10644b("x-osp-userId", str3).m10635a()), 2003, this.f7636a);
    }

    /* renamed from: c */
    public void m9394c(String str, String str2, String str3) {
        C2472w.m10687a().m10690b().m10662a(new C2038fc(new C2456g(EnumC4868cf.CONTACT, "/auth/msisdn/validate").m10637a(EnumC2457h.POST).m10639a(UpdateMSISDNEntry.class).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), str, str2, str3), 2004, this.f7636a);
    }

    /* renamed from: a */
    public void m9387a() {
        C2472w.m10687a().m10690b().m10662a(new C1997dp(new C2456g(EnumC4868cf.CONTACT, "/mapping").m10637a(EnumC2457h.POST).m10639a(MappingAccountEntry.class).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a()), 2005, this.f7636a);
    }

    /* renamed from: b */
    public void m9390b() {
        C2472w.m10687a().m10690b().m10662a(new C2056o(new C2456g(EnumC4868cf.CONTACT, "/reg/auto").m10637a(EnumC2457h.POST).m10639a(AutoRegisterAccounEntry.class).m10635a()), 2006, this.f7636a);
    }

    /* renamed from: b */
    public void m9391b(String str) {
        C2472w.m10687a().m10690b().m10664a(new C1910aj(new C2456g(EnumC4868cf.CONTACT, "/mapping/delete").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), str), EnumC2463n.UI, 2007, this.f7636a);
    }

    /* renamed from: c */
    public void m9393c(String str) {
        C2456g c2456gM10641a = new C2456g(EnumC4868cf.CONTACT, "/mapping/delete/ssa").m10637a(EnumC2457h.POST).m10641a("authcode", C4809aa.m18104a().m18121a("samsung_account_token", ""));
        if (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("samsung_account_api_server", ""))) {
            c2456gM10641a.m10641a("apiserver", C4809aa.m18104a().m18121a("samsung_account_api_server", ""));
        }
        C2472w.m10687a().m10690b().m10664a(new C1910aj(c2456gM10641a.m10635a(), str), EnumC2463n.UI, 2008, this.f7636a);
    }
}
