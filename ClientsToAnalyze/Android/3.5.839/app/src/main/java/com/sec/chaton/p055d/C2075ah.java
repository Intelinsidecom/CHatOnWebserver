package com.sec.chaton.p055d;

import android.os.Handler;
import android.text.TextUtils;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p046a.p047a.C0792p;
import com.sec.chaton.p055d.p056a.C1913am;
import com.sec.chaton.p055d.p056a.C1941bn;
import com.sec.chaton.p055d.p056a.C1949bv;
import com.sec.chaton.p055d.p056a.C1963ci;
import com.sec.chaton.p055d.p056a.C1964cj;
import com.sec.chaton.p055d.p056a.C1965ck;
import com.sec.chaton.p055d.p056a.C2039fd;
import com.sec.chaton.p055d.p056a.C2042fg;
import com.sec.chaton.p055d.p056a.C2043fh;
import com.sec.chaton.p065io.entry.GetProfileImageList;
import com.sec.chaton.p065io.entry.inner.BuddyMappingInfo;
import com.sec.chaton.p065io.entry.inner.BuddyProfileNew;
import com.sec.chaton.p065io.entry.inner.ProfileInformationList;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import java.util.concurrent.Future;

/* compiled from: ProfileControl.java */
/* renamed from: com.sec.chaton.d.ah */
/* loaded from: classes.dex */
public class C2075ah {

    /* renamed from: b */
    private Handler f7566b;

    /* renamed from: d */
    private Future<C0778b> f7568d;

    /* renamed from: e */
    private Future<C0778b> f7569e;

    /* renamed from: f */
    private Future<C0778b> f7570f;

    /* renamed from: g */
    private Future<C0778b> f7571g;

    /* renamed from: h */
    private Future<C0778b> f7572h;

    /* renamed from: i */
    private Future<C0778b> f7573i;

    /* renamed from: a */
    private String f7565a = getClass().getName();

    /* renamed from: c */
    private Future<C0778b> f7567c = null;

    public C2075ah(Handler handler) {
        this.f7566b = handler;
    }

    /* renamed from: a */
    public void m9304a(C0792p c0792p, String str) {
        C2472w.m10687a().m10690b().m10662a(new C2043fh(new C2456g(EnumC4868cf.CONTACT, "/profile").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), c0792p, str), 401, this.f7566b);
    }

    /* renamed from: a */
    public void m9305a(String str) {
        new AsyncTaskC2076ai(this, str).execute(new String[0]);
    }

    /* renamed from: b */
    public void m9309b(String str) {
        new AsyncTaskC2077aj(this, str).execute(new String[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0139  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m9312c(java.lang.String r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p055d.C2075ah.m9312c(java.lang.String):void");
    }

    /* renamed from: a */
    public void m9303a() {
        if (this.f7569e != null) {
            C4904y.m18646e("getUserProfileAllCancel() is called", this.f7565a);
            this.f7569e.cancel(true);
        }
    }

    /* renamed from: b */
    public void m9308b() {
        if (this.f7570f != null) {
            C4904y.m18646e("getBuddyProfileCancel() is called", "ProfileControl");
            this.f7570f.cancel(true);
        }
    }

    /* renamed from: d */
    public void m9314d(String str) {
        if (str != null) {
            this.f7571g = C2472w.m10687a().m10690b().m10662a(new C1949bv(new C2456g(EnumC4868cf.CONTACT, "/v5/buddy/" + str).m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("timestamp", Spam.ACTIVITY_CANCEL).m10641a("item", "devicetype").m10641a("mode", "sainfoenc").m10639a(BuddyProfileNew.class).m10635a()), 418, this.f7566b);
        }
    }

    /* renamed from: c */
    public void m9311c() {
        if (this.f7571g != null) {
            C4904y.m18646e("getHideBuddyProfileCancel() is called", "ProfileControl");
            this.f7571g.cancel(true);
        }
    }

    /* renamed from: e */
    public void m9316e(String str) {
        String strM18121a = C4809aa.m18104a().m18121a("uid", "");
        C2472w.m10687a().m10690b().m10662a(new C2042fg(new C2456g(EnumC4868cf.CONTACT, "/profile/historyimage/add").m10637a(EnumC2457h.POST).m10641a("uid", strM18121a).m10641a("mode", "returnlist").m10641a("imei", C4822an.m18228d()).m10641a(VKApiConst.COUNT, "250").m10643b(C2407b.class).m10639a(GetProfileImageList.class).m10635a(), "/file/" + strM18121a + "/" + (C4809aa.m18104a().m18121a("profile_image_timestamp", "") + "_profileImage.jpg"), "image/jpeg", str), 404, this.f7566b);
    }

    /* renamed from: a */
    public void m9307a(String str, boolean z) {
        C2472w.m10687a().m10690b().m10662a(new C1913am(new C2456g(EnumC4868cf.CONTACT, "/profile/historyimage/del").m10637a(EnumC2457h.GET).m10641a("mode", "returnlist").m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("profileimageid", str).m10641a(VKApiConst.COUNT, "250").m10643b(C2407b.class).m10639a(GetProfileImageList.class).m10635a(), str, z), 405, this.f7566b);
    }

    /* renamed from: f */
    public void m9318f(String str) {
        C2472w.m10687a().m10690b().m10662a(new C2039fd(new C2456g(EnumC4868cf.CONTACT, "/profile/setimage").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "returnlist").m10641a(VKApiConst.COUNT, "250").m10643b(C2407b.class).m10639a(GetProfileImageList.class).m10635a(), str), 406, this.f7566b);
    }

    /* renamed from: d */
    public void m9313d() {
        this.f7567c = C2472w.m10687a().m10690b().m10662a(new C1964cj(new C2456g(EnumC4868cf.CONTACT, "/profile/historyimage/list").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "returnmxcnt").m10641a(VKApiConst.COUNT, "250").m10643b(C2407b.class).m10639a(GetProfileImageList.class).m10635a()), 407, this.f7566b);
    }

    /* renamed from: e */
    public void m9315e() {
        if (this.f7567c != null) {
            C4904y.m18646e("getUserProfileImageHistoryListCancel() is called", this.f7565a);
            this.f7567c.cancel(true);
        }
    }

    /* renamed from: a */
    public void m9306a(String str, String str2) {
        this.f7568d = C2472w.m10687a().m10690b().m10662a(new C1963ci(new C2456g(EnumC4868cf.CONTACT, "/profile/historyimage/" + str).m10637a(EnumC2457h.GET).m10641a("buddyid", str).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10643b(C2407b.class).m10639a(GetProfileImageList.class).m10635a()), 410, this.f7566b);
    }

    /* renamed from: f */
    public void m9317f() {
        if (this.f7568d != null) {
            C4904y.m18646e("getUserProfileImageHistoryListCancel() is called", this.f7565a);
            this.f7568d.cancel(true);
        }
    }

    /* renamed from: g */
    public void m9320g(String str) {
        this.f7572h = C2472w.m10687a().m10690b().m10662a(new C1941bn(new C2456g(EnumC4868cf.CONTACT, "/mapping/info").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10643b(C2407b.class).m10639a(BuddyMappingInfo.class).m10635a(), str), 413, this.f7566b);
    }

    /* renamed from: g */
    public void m9319g() {
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/mapping/info/ssa").m10637a(EnumC2457h.POST).m10641a("authcode", C4809aa.m18104a().m18121a("samsung_account_token", "")).m10643b(C2407b.class).m10639a(BuddyMappingInfo.class);
        if (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("samsung_account_api_server", ""))) {
            c2456gM10639a.m10641a("apiserver", C4809aa.m18104a().m18121a("samsung_account_api_server", ""));
        }
        this.f7572h = C2472w.m10687a().m10690b().m10662a(new C1941bn(c2456gM10639a.m10635a(), null, C4809aa.m18104a().m18121a("samsung_account_email", (String) null)), 416, this.f7566b);
    }

    /* renamed from: b */
    public void m9310b(String str, String str2) {
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/profile/profileinfo").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a(VKApiConst.COUNT, str2).m10641a("mode", "md").m10643b(C2407b.class).m10639a(ProfileInformationList.class);
        if (str == null) {
            c2456gM10639a.m10641a("timestamp", C4809aa.m18104a().m18121a("profile_information_timestamp", Spam.ACTIVITY_CANCEL));
        } else {
            c2456gM10639a.m10641a("buddyid", str);
            c2456gM10639a.m10641a("timestamp", Spam.ACTIVITY_CANCEL);
        }
        this.f7573i = C2472w.m10687a().m10690b().m10662a(new C1965ck(this.f7566b, c2456gM10639a.m10635a(), str), 417, this.f7566b);
    }

    /* renamed from: h */
    public void m9321h() {
        if (this.f7573i != null) {
            C4904y.m18646e("getUserProfileInformationCancel() is called", this.f7565a);
            this.f7573i.cancel(true);
        }
    }
}
