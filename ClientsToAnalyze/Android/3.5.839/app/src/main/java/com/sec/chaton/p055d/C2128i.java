package com.sec.chaton.p055d;

import android.os.Handler;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.p056a.C1901aa;
import com.sec.chaton.p055d.p056a.C1909ai;
import com.sec.chaton.p055d.p056a.C1914an;
import com.sec.chaton.p055d.p056a.C1925ay;
import com.sec.chaton.p055d.p056a.C1932be;
import com.sec.chaton.p055d.p056a.C1933bf;
import com.sec.chaton.p055d.p056a.C1946bs;
import com.sec.chaton.p055d.p056a.C1947bt;
import com.sec.chaton.p055d.p056a.C1948bu;
import com.sec.chaton.p055d.p056a.C1952by;
import com.sec.chaton.p055d.p056a.C1953bz;
import com.sec.chaton.p055d.p056a.C1955ca;
import com.sec.chaton.p055d.p056a.C1962ch;
import com.sec.chaton.p055d.p056a.C1966cl;
import com.sec.chaton.p055d.p056a.C1968cn;
import com.sec.chaton.p055d.p056a.C2024ep;
import com.sec.chaton.p055d.p056a.C2025eq;
import com.sec.chaton.p055d.p056a.C2026er;
import com.sec.chaton.p055d.p056a.C2028et;
import com.sec.chaton.p055d.p056a.C2035f;
import com.sec.chaton.p055d.p056a.C2036fa;
import com.sec.chaton.p055d.p056a.C2040fe;
import com.sec.chaton.p055d.p056a.C2048g;
import com.sec.chaton.p065io.entry.FlagImageURLEntry;
import com.sec.chaton.p065io.entry.GetBuddyList;
import com.sec.chaton.p065io.entry.GetContentCategoryList;
import com.sec.chaton.p065io.entry.GetCurationList;
import com.sec.chaton.p065io.entry.GetPrivacyList;
import com.sec.chaton.p065io.entry.GetRecommendeeList;
import com.sec.chaton.p065io.entry.GetSnsFriendsList;
import com.sec.chaton.p065io.entry.GetSpecialBuddyList;
import com.sec.chaton.p065io.entry.GetSpecialUserList;
import com.sec.chaton.p065io.entry.specialbuddy.LivepartnerLikesCountEntry;
import com.sec.chaton.p065io.p066a.C2407b;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4868cf;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Future;

/* compiled from: ContactControl.java */
/* renamed from: com.sec.chaton.d.i */
/* loaded from: classes.dex */
public class C2128i {

    /* renamed from: a */
    public String f7716a = "blocked|sainfoenc|multi-results";

    /* renamed from: b */
    private Handler f7717b;

    /* renamed from: c */
    private Future<C0778b> f7718c;

    /* renamed from: d */
    private Future<C0778b> f7719d;

    public C2128i(Handler handler) {
        this.f7717b = handler;
    }

    /* renamed from: a */
    public void m9497a(String str) {
        m9484a(str, false);
    }

    /* renamed from: a */
    public int m9484a(String str, boolean z) {
        C2040fe c2040fe = new C2040fe(new C2456g(EnumC4868cf.CONTACT, "/address").m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", str).m10637a(EnumC2457h.POST).m10635a());
        if (z) {
            c2040fe.m9082a();
            return c2040fe.m9177e();
        }
        C2472w.m10687a().m10690b().m10662a(c2040fe, 302, this.f7717b);
        return -1;
    }

    /* renamed from: a */
    public int m9488a(String str, boolean z, String str2, String str3) {
        C2040fe c2040fe = new C2040fe(this.f7717b, new C2456g(EnumC4868cf.CONTACT, "/address").m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", str).m10637a(EnumC2457h.POST).m10635a(), str2, str3, str);
        if (z) {
            c2040fe.m9082a();
            return c2040fe.m9177e();
        }
        C2472w.m10687a().m10690b().m10662a(c2040fe, 302, this.f7717b);
        return -1;
    }

    /* renamed from: a */
    public int m9487a(String str, boolean z, int i, ArrayList<String> arrayList, HashMap<String, ArrayList<String>> map) {
        C2040fe c2040fe = new C2040fe(this.f7717b, new C2456g(EnumC4868cf.CONTACT, "/address").m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", str).m10637a(EnumC2457h.POST).m10635a(), i, arrayList, map);
        if (z) {
            c2040fe.m9082a();
            return c2040fe.m9177e();
        }
        C2472w.m10687a().m10690b().m10662a(c2040fe, 302, this.f7717b);
        return -1;
    }

    /* renamed from: a */
    public int m9486a(String str, boolean z, int i, String str2, String[] strArr, String[] strArr2) {
        C2040fe c2040fe = new C2040fe(this.f7717b, new C2456g(EnumC4868cf.CONTACT, "/address").m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", str).m10637a(EnumC2457h.POST).m10635a(), str2, strArr, strArr2, i);
        if (z) {
            c2040fe.m9082a();
            return c2040fe.m9177e();
        }
        C2472w.m10687a().m10690b().m10662a(c2040fe, 302, this.f7717b);
        return -1;
    }

    /* renamed from: a */
    public int m9489a(String str, boolean z, String str2, String str3, String[] strArr, int i) {
        C2040fe c2040fe = new C2040fe(this.f7717b, new C2456g(EnumC4868cf.CONTACT, "/address").m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", str).m10637a(EnumC2457h.POST).m10635a(), str2, str3, strArr, i);
        if (z) {
            c2040fe.m9082a();
            return c2040fe.m9177e();
        }
        C2472w.m10687a().m10690b().m10662a(c2040fe, 302, this.f7717b);
        return -1;
    }

    /* renamed from: a */
    public void m9495a() {
        m9504a(false);
    }

    /* renamed from: a */
    public void m9504a(boolean z) throws UnsupportedEncodingException {
        String strEncode = null;
        Long lValueOf = Long.valueOf(C4809aa.m18104a().m18118a("get_all_buddies_timestamp", 0L));
        try {
            strEncode = URLEncoder.encode(this.f7716a, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C4904y.m18646e("getAllBuddies() : " + e.getMessage(), "ContactControl");
        }
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/v5/buddies").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("timestamp", String.valueOf(lValueOf)).m10641a("mode", strEncode).m10641a("item", "devicetype").m10639a(GetBuddyList.class);
        if (z) {
            new C1932be(c2456gM10639a.m10635a()).m9082a();
        } else {
            C2472w.m10687a().m10690b().m10662a(new C1932be(c2456gM10639a.m10635a()), 301, this.f7717b);
        }
    }

    /* renamed from: a */
    public void m9505a(boolean z, int i) throws UnsupportedEncodingException {
        boolean z2;
        String strEncode;
        Long l;
        String strEncode2 = null;
        Long lValueOf = Long.valueOf(C4809aa.m18104a().m18118a("get_all_buddies_timestamp", 0L));
        switch (i) {
            case 200:
                try {
                    z2 = false;
                    strEncode = URLEncoder.encode(this.f7716a + "|instance", "UTF-8");
                    l = 0L;
                    break;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    z2 = false;
                    strEncode = null;
                    l = 0L;
                    break;
                }
            case 201:
                try {
                    strEncode2 = URLEncoder.encode(this.f7716a, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                z2 = true;
                strEncode = strEncode2;
                l = lValueOf;
                break;
            default:
                z2 = false;
                strEncode = null;
                l = lValueOf;
                break;
        }
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/v5/buddies").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("timestamp", String.valueOf(l)).m10641a("mode", strEncode).m10641a("item", "devicetype").m10639a(GetBuddyList.class);
        if (i == 200) {
            C2472w.m10687a().m10690b().m10662a(new C1933bf(c2456gM10639a.m10635a()), 301, this.f7717b);
        } else if (z) {
            new C1932be(c2456gM10639a.m10635a(), z2).m9082a();
        } else {
            C2472w.m10687a().m10690b().m10662a(new C1932be(c2456gM10639a.m10635a()), 301, this.f7717b);
        }
    }

    /* renamed from: b */
    public void m9513b(boolean z) throws UnsupportedEncodingException {
        String strEncode = null;
        try {
            strEncode = URLEncoder.encode(this.f7716a, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C4904y.m18646e("getAllBuddiesReset() : " + e.getMessage(), "ContactControl");
        }
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/v5/buddies").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("timestamp", String.valueOf((Object) 0L)).m10641a("mode", strEncode).m10641a("item", "devicetype").m10639a(GetBuddyList.class);
        if (z) {
            new C1932be(c2456gM10639a.m10635a()).m9082a();
        } else {
            C2472w.m10687a().m10690b().m10662a(new C1932be(c2456gM10639a.m10635a()), 301, this.f7717b);
        }
    }

    /* renamed from: b */
    public Future<C0778b> m9508b(String str) {
        return m9494a(str, true, EnumC2463n.BACKGROUND);
    }

    /* renamed from: a */
    public Future<C0778b> m9492a(String str, EnumC2129j enumC2129j, EnumC2463n enumC2463n) {
        return m9493a(str, false, enumC2129j, enumC2463n);
    }

    /* renamed from: a */
    public Future<C0778b> m9494a(String str, boolean z, EnumC2463n enumC2463n) {
        return m9493a(str, z, EnumC2129j.NONE, enumC2463n);
    }

    /* renamed from: a */
    public Future<C0778b> m9493a(String str, boolean z, EnumC2129j enumC2129j, EnumC2463n enumC2463n) throws UnsupportedEncodingException {
        String strEncode = null;
        try {
            strEncode = URLEncoder.encode("call|sainfoenc", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        C2454e c2454eM10635a = new C2456g(EnumC4868cf.CONTACT, "/v6/buddy").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", strEncode).m10639a(GetBuddyList.class).m10635a();
        if (z) {
            str = "+" + str;
        }
        return C2472w.m10687a().m10690b().m10664a(new C2048g(c2454eM10635a, str), enumC2463n, 303, this.f7717b);
    }

    /* renamed from: b */
    public C2048g m9507b(String str, boolean z, EnumC2463n enumC2463n) throws UnsupportedEncodingException {
        String strEncode = "";
        try {
            strEncode = URLEncoder.encode("call|sainfoenc", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            if (C4904y.f17875e) {
                e.printStackTrace();
            }
        }
        C2454e c2454eM10635a = new C2456g(EnumC4868cf.CONTACT, "/v6/buddy").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", strEncode).m10639a(GetBuddyList.class).m10635a();
        if (z) {
            str = "+" + str;
        }
        C2048g c2048g = new C2048g(c2454eM10635a, str, false);
        C2472w.m10687a().m10690b().m10664a(c2048g, enumC2463n, 303, this.f7717b);
        return c2048g;
    }

    /* renamed from: b */
    public void m9511b(String str, boolean z) {
        C2472w.m10687a().m10690b().m10662a(new C1925ay(this.f7717b, new C2456g(EnumC4868cf.CONTACT, "/specialbuddy/follow/app").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), str, z), 317, this.f7717b);
    }

    /* renamed from: c */
    public void m9516c(String str) {
        C2472w.m10687a().m10690b().m10662a(new C2036fa(new C2456g(EnumC4868cf.CONTACT, "/specialbuddy/unfollow/app").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), str), 318, this.f7717b);
    }

    /* renamed from: d */
    public void m9519d(String str) {
        C2472w.m10687a().m10690b().m10662a(new C2028et(new C2456g(EnumC4868cf.CONTACT, "/specialbuddy/like").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10643b(C2407b.class).m10639a(LivepartnerLikesCountEntry.class).m10635a(), str), 319, this.f7717b);
    }

    /* renamed from: e */
    public void m9524e(String str) {
        C2472w.m10687a().m10690b().m10662a(new C2028et(new C2456g(EnumC4868cf.CONTACT, "/specialbuddy/unlike").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10643b(C2407b.class).m10639a(LivepartnerLikesCountEntry.class).m10635a(), str), 320, this.f7717b);
    }

    /* renamed from: b */
    public void m9509b() {
        C2472w.m10687a().m10690b().m10662a(new C1946bs(new C2456g(EnumC4868cf.CONTACT, "/specialbuddy/curation/iso2").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10643b(C2407b.class).m10639a(GetCurationList.class).m10635a()), 331, this.f7717b);
    }

    /* renamed from: c */
    public void m9515c() {
        m9496a(0, 0);
    }

    /* renamed from: a */
    public void m9496a(int i, int i2) {
        int i3;
        long jM18118a = C4809aa.m18104a().m18118a("get_myfollowing_buddies_timestamp", 0L);
        if (C2349a.m10301a("live_chat_feature")) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        C2472w.m10687a().m10690b().m10662a(new C1955ca(new C2456g(EnumC4868cf.CONTACT, "/specialbuddy/myfollowings").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("timestamp", String.valueOf(jM18118a)).m10641a(VKOpenAuthActivity.VK_EXTRA_API_VERSION, String.valueOf(i3)).m10641a("startidx", String.valueOf(i)).m10641a(VKApiConst.COUNT, String.valueOf(i2)).m10643b(C2407b.class).m10639a(GetSpecialBuddyList.class).m10635a()), 321, this.f7717b);
    }

    /* renamed from: d */
    public void m9518d() {
        int i;
        if (C2349a.m10301a("live_chat_feature")) {
            i = 3;
        } else {
            i = 2;
        }
        C2472w.m10687a().m10690b().m10662a(new C1953bz(new C2456g(EnumC4868cf.CONTACT, "/specialbuddy/myfollowings").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("timestamp", String.valueOf(0L)).m10641a(VKOpenAuthActivity.VK_EXTRA_API_VERSION, String.valueOf(i)).m10641a("startidx", Spam.ACTIVITY_CANCEL).m10641a(VKApiConst.COUNT, Spam.ACTIVITY_CANCEL).m10643b(C2407b.class).m10639a(GetSpecialBuddyList.class).m10635a()), 321, this.f7717b);
    }

    /* renamed from: a */
    public void m9498a(String str, int i, int i2) {
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/specialbuddy/contentcategory/user/list").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10643b(C2407b.class).m10639a(GetContentCategoryList.class);
        if (i >= 0) {
            c2456gM10639a.m10641a("startidx", String.valueOf(i));
        }
        if (i2 >= 0) {
            c2456gM10639a.m10641a(VKApiConst.COUNT, String.valueOf(i2));
        }
        C2472w.m10687a().m10691c().m10662a(new C1968cn(c2456gM10639a.m10635a(), str), 316, this.f7717b);
    }

    /* renamed from: a */
    public void m9503a(ArrayList<String> arrayList, boolean z) {
        int size = arrayList.size();
        if (size > 0) {
            C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/v6/buddy").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "multiple").m10639a(GetBuddyList.class);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(z ? "+" + arrayList.get(i) : arrayList.get(i));
                sb.append(",");
            }
            C2472w.m10687a().m10690b().m10662a(new C2048g(c2456gM10639a.m10635a(), sb.toString()), 311, this.f7717b);
        }
    }

    /* renamed from: b */
    public void m9512b(ArrayList<String> arrayList, boolean z) {
        int size = arrayList.size();
        if (size > 0) {
            C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/v6/buddy").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "multi-results").m10639a(GetBuddyList.class);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(z ? "+" + arrayList.get(i) : arrayList.get(i));
                sb.append(",");
            }
            C2472w.m10687a().m10690b().m10662a(new C2048g(c2456gM10639a.m10635a(), sb.toString()), 311, this.f7717b);
        }
    }

    /* renamed from: a */
    public C2035f m9490a(String str, EnumC2129j enumC2129j) {
        return m9491a(str, false, enumC2129j);
    }

    /* renamed from: c */
    public C2035f m9514c(String str, boolean z) {
        return m9491a(str, z, EnumC2129j.NONE);
    }

    /* renamed from: a */
    public C2035f m9491a(String str, boolean z, EnumC2129j enumC2129j) {
        C2454e c2454eM10635a = new C2456g(EnumC4868cf.CONTACT, "/v6/buddy").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "preview").m10639a(GetBuddyList.class).m10635a();
        if (z) {
            str = "+" + str;
        }
        C2035f c2035f = new C2035f(c2454eM10635a, str, enumC2129j);
        C2472w.m10687a().m10690b().m10664a(c2035f, EnumC2463n.UI, 307, this.f7717b);
        return c2035f;
    }

    /* renamed from: c */
    public void m9517c(boolean z) {
        m9520d("phonenumber", z);
    }

    /* renamed from: d */
    public void m9521d(boolean z) {
        m9520d("emailsamsung", z);
    }

    /* renamed from: e */
    public void m9525e(boolean z) {
        m9520d("showprofileimage", z);
    }

    /* renamed from: f */
    public void m9529f(boolean z) {
        if (z) {
        }
        m9520d("ignorerecommendation", z);
    }

    /* renamed from: g */
    public void m9532g(boolean z) {
        if (z) {
        }
        m9520d("recommendationbuddy", z);
    }

    /* renamed from: d */
    public void m9520d(String str, boolean z) {
        C2472w.m10687a().m10690b().m10662a(new C2025eq(new C2456g(EnumC4868cf.CONTACT, "/privacy").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), str, z), 304, this.f7717b);
    }

    /* renamed from: f */
    public void m9527f(String str) {
        this.f7718c = C2472w.m10687a().m10690b().m10662a(new C1962ch(new C2456g(EnumC4868cf.CONTACT, "/privacy").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("type", URLEncoder.encode(str)).m10641a("mode", "multiple").m10643b(C2407b.class).m10639a(GetPrivacyList.class).m10635a()), 322, this.f7717b);
    }

    /* renamed from: e */
    public void m9523e() {
        if (this.f7718c != null) {
            C4904y.m18646e("getPrivacyAllCancel() is called", "ContactControl");
            this.f7718c.cancel(true);
        }
    }

    /* renamed from: f */
    public void m9526f() {
        if (this.f7719d != null) {
            C4904y.m18646e("SetExtraInfoTaskCancel() is called", "ContactControl");
            this.f7719d.cancel(true);
        }
    }

    /* renamed from: a */
    public void m9499a(String str, int i, boolean z) {
        C2456g c2456gM10637a = new C2456g(EnumC4868cf.CONTACT, "/extra/info").m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10637a(EnumC2457h.POST);
        if (z) {
            new C2024ep(c2456gM10637a.m10635a(), str, i).m9082a();
        } else {
            this.f7719d = C2472w.m10687a().m10690b().m10662a(new C2024ep(c2456gM10637a.m10635a(), str, i), 305, this.f7717b);
        }
    }

    /* renamed from: e */
    public int m9522e(String str, boolean z) throws UnsupportedEncodingException {
        return m9485a(str, z, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0073  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m9485a(java.lang.String r8, boolean r9, int r10) throws java.io.UnsupportedEncodingException {
        /*
            r7 = this;
            r0 = 0
            java.lang.String r1 = "nonbuddy|sainfoenc"
            java.lang.String r2 = "preview|spammer"
            java.lang.String r3 = "UTF-8"
            java.lang.String r1 = java.net.URLEncoder.encode(r1, r3)     // Catch: java.io.UnsupportedEncodingException -> L89
            java.lang.String r3 = "UTF-8"
            java.lang.String r0 = java.net.URLEncoder.encode(r2, r3)     // Catch: java.io.UnsupportedEncodingException -> Lbd
        L15:
            com.sec.chaton.j.g r2 = new com.sec.chaton.j.g
            com.sec.chaton.util.cf r3 = com.sec.chaton.util.EnumC4868cf.CONTACT
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "/v6/check/"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r4 = r4.toString()
            r2.<init>(r3, r4)
            com.sec.chaton.j.h r3 = com.sec.chaton.p067j.EnumC2457h.GET
            com.sec.chaton.j.g r2 = r2.m10637a(r3)
            java.lang.String r3 = "buddyid"
            com.sec.chaton.j.g r2 = r2.m10641a(r3, r8)
            java.lang.String r3 = "uid"
            com.sec.chaton.util.ab r4 = com.sec.chaton.util.C4809aa.m18104a()
            java.lang.String r5 = "uid"
            java.lang.String r6 = ""
            java.lang.String r4 = r4.m18121a(r5, r6)
            com.sec.chaton.j.g r2 = r2.m10641a(r3, r4)
            java.lang.String r3 = "imei"
            java.lang.String r4 = com.sec.chaton.util.C4822an.m18228d()
            com.sec.chaton.j.g r2 = r2.m10641a(r3, r4)
            java.lang.String r3 = "mode"
            com.sec.chaton.j.g r1 = r2.m10641a(r3, r1)
            java.lang.String r2 = "item"
            com.sec.chaton.j.g r0 = r1.m10641a(r2, r0)
            java.lang.Class<com.sec.chaton.io.entry.CheckBuddyList> r1 = com.sec.chaton.p065io.entry.CheckBuddyList.class
            com.sec.chaton.j.g r0 = r0.m10639a(r1)
            if (r9 == 0) goto L76
            r0.m10636a(r10)
        L76:
            com.sec.chaton.d.a.y r1 = new com.sec.chaton.d.a.y
            com.sec.chaton.j.e r0 = r0.m10635a()
            r1.<init>(r0)
            if (r9 == 0) goto Lac
            r1.m9082a()
            int r0 = r1.m9201e()
        L88:
            return r0
        L89:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L8c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "checkBuddy6() : "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "ContactControl"
            com.sec.chaton.util.C4904y.m18646e(r2, r3)
            goto L15
        Lac:
            com.sec.chaton.j.w r0 = com.sec.chaton.p067j.C2472w.m10687a()
            com.sec.chaton.j.l r0 = r0.m10690b()
            r2 = 306(0x132, float:4.29E-43)
            android.os.Handler r3 = r7.f7717b
            r0.m10662a(r1, r2, r3)
            r0 = 0
            goto L88
        Lbd:
            r2 = move-exception
            goto L8c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p055d.C2128i.m9485a(java.lang.String, boolean, int):int");
    }

    /* renamed from: g */
    public void m9530g() {
        m9510b(-1, -1);
    }

    /* renamed from: b */
    public void m9510b(int i, int i2) {
        C2456g c2456gM10639a = new C2456g(EnumC4868cf.CONTACT, "/buddyrecommendee/list").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("mode", "timestamp").m10639a(GetRecommendeeList.class);
        if (i >= 0) {
            c2456gM10639a.m10641a("startidx", String.valueOf(i));
        }
        if (i2 >= 0) {
            c2456gM10639a.m10641a(VKApiConst.COUNT, String.valueOf(i2));
        }
        C2472w.m10687a().m10690b().m10662a(new C1966cl(c2456gM10639a.m10635a(), false), 301, this.f7717b);
    }

    /* renamed from: h */
    public void m9533h() {
        C2472w.m10687a().m10690b().m10662a(new C1901aa(new C2456g(EnumC4868cf.CONTACT, "/compatibility").m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10637a(EnumC2457h.POST).m10635a()), 310, this.f7717b);
    }

    /* renamed from: a */
    public void m9500a(String str, String str2) {
        C2472w.m10687a().m10690b().m10662a(new C2026er(new C2456g(EnumC4868cf.CONTACT, "/sns/id").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), str, str2), 313, this.f7717b);
    }

    /* renamed from: a */
    public void m9501a(String str, String str2, Integer num) {
        C2472w.m10687a().m10690b().m10662a(new C1914an(new C2456g(EnumC4868cf.CONTACT, "/sns/delid").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), str, str2, num), 335, this.f7717b);
    }

    /* renamed from: a */
    public void m9502a(String str, long[] jArr) {
        C2472w.m10687a().m10690b().m10662a(new C1947bt(new C2456g(EnumC4868cf.CONTACT, "/sns/friend").m10637a(EnumC2457h.POST).m10639a(GetSnsFriendsList.class).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10635a(), str, jArr), 314, this.f7717b);
    }

    /* renamed from: g */
    public void m9531g(String str) {
        C2472w.m10687a().m10690b().m10662a(new C1948bu(new C2456g(EnumC4868cf.CONTACT, "/nationalflag").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("contrycode", str).m10639a(FlagImageURLEntry.class).m10635a()), 324, this.f7717b);
    }

    /* renamed from: h */
    public void m9534h(String str) {
        C2472w.m10687a().m10691c().m10662a(new C1909ai(new C2456g(EnumC4868cf.CONTACT, "/buddy/delete").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10643b(C2407b.class).m10635a(), str), 332, this.f7717b);
    }

    /* renamed from: a */
    public void m9506a(String[] strArr) {
        C2472w.m10687a().m10691c().m10662a(new C1909ai(new C2456g(EnumC4868cf.CONTACT, "/buddy/delete").m10637a(EnumC2457h.POST).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10643b(C2407b.class).m10635a(), strArr), 332, this.f7717b);
    }

    /* renamed from: i */
    public void m9535i(String str) {
        m9528f(str, false);
    }

    /* renamed from: f */
    public void m9528f(String str, boolean z) {
        C2472w.m10687a().m10690b().m10664a(new C1952by(new C2456g(EnumC4868cf.CONTACT, z ? "/specialbuddy/buddy/profile/noauth" : "/specialbuddy/buddy/profile").m10637a(EnumC2457h.GET).m10641a("uid", C4809aa.m18104a().m18121a("uid", "")).m10641a("imei", C4822an.m18228d()).m10641a("specialuserid", str).m10643b(C2407b.class).m10639a(GetSpecialUserList.class).m10635a(), z), EnumC2463n.UI, 334, this.f7717b);
    }
}
