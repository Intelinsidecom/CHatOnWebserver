package com.sec.chaton.sns.p114b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.facebook.AsyncTaskC0453aw;
import com.facebook.C0431aa;
import com.facebook.C0443am;
import com.facebook.C0478ba;
import com.facebook.C0488bk;
import com.facebook.C0489bl;
import com.facebook.C0549w;
import com.facebook.EnumC0495br;
import com.facebook.EnumC0496bs;
import com.facebook.model.GraphCustomUser;
import com.facebook.model.GraphObject;
import com.facebook.p031a.C0425a;
import com.facebook.p031a.C0428d;
import com.facebook.p031a.C0429e;
import com.facebook.p031a.InterfaceC0427c;
import com.facebook.p032b.C0472o;
import com.facebook.p033c.C0525v;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p051c.C1428b;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p113a.InterfaceC4367d;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.dlc.api.DlcApi;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.sns.b.a */
/* loaded from: classes.dex */
public class C4374a {

    /* renamed from: c */
    private Context f15847c;

    /* renamed from: d */
    private InterfaceC4367d f15848d;

    /* renamed from: e */
    private C0472o f15849e;

    /* renamed from: b */
    private final Object f15846b = new Object();

    /* renamed from: f */
    private final Map<C0443am, AsyncTaskC0453aw> f15850f = new HashMap();

    /* renamed from: a */
    Handler f15845a = new HandlerC4423g(this);

    public C4374a(Context context, InterfaceC4367d interfaceC4367d) {
        this.f15847c = context;
        this.f15848d = interfaceC4367d;
        this.f15849e = new C0472o(this.f15847c, new C4425i(this, null));
        m16601h();
    }

    /* renamed from: h */
    private C0478ba m16601h() {
        C0478ba c0478baM1702a = this.f15849e.m1702a();
        if (c0478baM1702a == null || c0478baM1702a.m1763c().m1806b()) {
            this.f15849e.m1703a((C0478ba) null);
            if (C0478ba.m1726a(GlobalApplication.m18732r()) == null) {
                C0478ba c0478baM1792a = new C0488bk(GlobalApplication.m18732r()).m1793a("254066384616989").m1792a();
                C0478ba.m1733a(c0478baM1792a);
                return c0478baM1792a;
            }
            return c0478baM1702a;
        }
        return c0478baM1702a;
    }

    /* renamed from: a */
    public void m16605a(int i) {
        C0478ba c0478baM16601h = m16601h();
        C4904y.m18639b("login() -> debug currentSession " + c0478baM16601h.toString(), "[FacebookManager]");
        if (!c0478baM16601h.m1762b()) {
            C4904y.m18639b("login() -> requesting login for FB", "[FacebookManager]");
            c0478baM16601h.m1757a(m16602i());
        } else {
            C4904y.m18639b("login() -> session is opened. proceed to fetchUserInfo", "[FacebookManager]");
            m16603j();
        }
    }

    /* renamed from: i */
    private C0489bl m16602i() {
        C0489bl c0489blM1797b = new C0489bl((Activity) this.f15847c).mo1778a(new C4401b(this, new C4426j(this, 3, null, 0 == true ? 1 : 0))).mo1779a(EnumC0495br.SUPPRESS_SSO).mo1777a(32665).m1797b(Arrays.asList("basic_info"));
        c0489blM1797b.m1783a(true);
        return c0489blM1797b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16588a(C0478ba c0478ba, EnumC0496bs enumC0496bs, Exception exc, InterfaceC0427c interfaceC0427c) {
        Bundle bundleM1753a = c0478ba.m1753a();
        if (enumC0496bs == EnumC0496bs.OPENED) {
            C0478ba c0478baM1702a = this.f15849e.m1702a();
            synchronized (this.f15846b) {
                if (c0478ba == c0478baM1702a) {
                    c0478baM1702a = null;
                } else {
                    this.f15849e.m1703a(c0478ba);
                }
            }
            if (c0478baM1702a != null) {
                c0478baM1702a.m1768h();
            }
            interfaceC0427c.mo1540a(bundleM1753a);
            return;
        }
        if (exc != null) {
            if (exc instanceof C0431aa) {
                interfaceC0427c.mo1539a();
                return;
            }
            if ((exc instanceof C0549w) && bundleM1753a != null && bundleM1753a.containsKey("com.facebook.sdk.WebViewErrorCode") && bundleM1753a.containsKey("com.facebook.sdk.FailingUrl")) {
                interfaceC0427c.mo1541a(new C0425a(exc.getMessage(), bundleM1753a.getInt("com.facebook.sdk.WebViewErrorCode"), bundleM1753a.getString("com.facebook.sdk.FailingUrl")));
            } else {
                interfaceC0427c.mo1542a(new C0428d(exc.getMessage()));
            }
        }
    }

    /* renamed from: a */
    public String m16604a() {
        return C0429e.m1545b(this.f15847c);
    }

    /* renamed from: b */
    public String m16611b() {
        return C0429e.m1547c(this.f15847c);
    }

    /* renamed from: c */
    public String m16613c() {
        return C0429e.m1549d(this.f15847c);
    }

    /* renamed from: d */
    public String m16614d() {
        return C0429e.m1551e(this.f15847c);
    }

    /* renamed from: e */
    public String m16615e() {
        C0478ba c0478baM1704b = this.f15849e.m1704b();
        if (c0478baM1704b == null) {
            return "";
        }
        return c0478baM1704b.m1765e();
    }

    /* renamed from: a */
    public void m16606a(int i, int i2, Intent intent) {
        m16599d("Login onActivityResult requstCode=" + i + ", resultCode=" + i2);
    }

    /* renamed from: b */
    public void m16612b(int i) {
        C0478ba c0478baM1704b = this.f15849e.m1704b();
        if (c0478baM1704b != null) {
            c0478baM1704b.m1769i();
        }
        C4368e.m16564a(this.f15847c).m16565a(C4368e.f15815a, false);
        this.f15848d.mo16563a(i, -1, null);
    }

    /* renamed from: f */
    public boolean m16616f() {
        return this.f15849e.m1704b() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m16603j() {
        C0478ba c0478baM1704b = this.f15849e.m1704b();
        if (c0478baM1704b != null) {
            C0443am c0443amM1577a = C0443am.m1577a(c0478baM1704b, new C4419c(this));
            Bundle bundle = new Bundle();
            bundle.putString(VKApiConst.FIELDS, "name,email");
            c0443amM1577a.m1613a(bundle);
            this.f15850f.put(c0443amM1577a, C0443am.m1598b(c0443amM1577a));
        }
    }

    /* renamed from: a */
    public static void m16587a(Context context) {
        C0478ba c0478baM1749j = C0478ba.m1749j();
        if (c0478baM1749j != null) {
            c0478baM1749j.m1769i();
        } else {
            C0478ba c0478baM1726a = C0478ba.m1726a(GlobalApplication.m18732r());
            if (c0478baM1726a != null) {
                c0478baM1726a.m1769i();
            }
        }
        C0429e.m1543a(context);
        C4368e.m16564a(context).m16565a(C4368e.f15815a, false);
        C4809aa.m18108a("register_fb_sns_type", "");
    }

    /* renamed from: a */
    public void m16610a(boolean z) {
        C0478ba c0478baM1704b = this.f15849e.m1704b();
        if (c0478baM1704b != null) {
            C0443am c0443amM1578a = C0443am.m1578a(c0478baM1704b, new C4420d(this));
            Bundle bundle = new Bundle();
            bundle.putString(VKApiConst.FIELDS, "name,email,installed");
            c0443amM1578a.m1613a(bundle);
            if (z) {
                this.f15850f.put(c0443amM1578a, C0443am.m1598b(c0443amM1578a));
                return;
            } else {
                C0443am.m1581a(c0443amM1578a);
                return;
            }
        }
        this.f15848d.mo16563a(0, DlcApi.RC_SVC_NOT_CONNECTED, "NeedUserLoginAgain");
    }

    /* renamed from: a */
    public void m16607a(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            m16597c(str);
        }
    }

    /* renamed from: a */
    public void m16608a(int i, String str, String str2) {
        C0478ba c0478baM1704b = this.f15849e.m1704b();
        if (c0478baM1704b != null) {
            GraphObject graphObjectCreate = GraphObject.Factory.create();
            graphObjectCreate.setProperty("picture", this.f15847c.getString(R.string.logo_url_for_facebook));
            graphObjectCreate.setProperty(VKApiConst.MESSAGE, str2);
            graphObjectCreate.setProperty("description", this.f15847c.getString(R.string.twitter_invite));
            graphObjectCreate.setProperty("link", "www.chaton.com/invite.html");
            graphObjectCreate.setProperty("name", "ChatON");
            graphObjectCreate.setProperty("caption", "www.chaton.com/invite.html");
            C0443am c0443amM1580a = C0443am.m1580a(c0478baM1704b, !TextUtils.isEmpty(str) ? "me/feed" : str + "/feed", graphObjectCreate, new C4421e(this));
            this.f15850f.put(c0443amM1580a, C0443am.m1598b(c0443amM1580a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16589a(GraphCustomUser graphCustomUser) {
        C0429e.m1546b(this.f15847c, graphCustomUser.getId());
        C0429e.m1544a(this.f15847c, graphCustomUser.getName());
        C0429e.m1548c(this.f15847c, graphCustomUser.getEmail());
        C0429e.m1550d(this.f15847c, C1428b.f5108n + graphCustomUser.getId() + "/picture");
    }

    /* renamed from: c */
    private void m16597c(String str) {
        C0478ba c0478baM1704b = this.f15849e.m1704b();
        Bundle bundle = new Bundle();
        bundle.putString("picture", this.f15847c.getString(R.string.logo_url_for_facebook));
        bundle.putString(VKApiConst.MESSAGE, "asdasdasdasd");
        bundle.putString("description", this.f15847c.getString(R.string.twitter_invite));
        bundle.putString("link", "www.chaton.com/invite.html");
        bundle.putString("name", "ChatON");
        bundle.putString("caption", "www.chaton.com/invite.html");
        bundle.putString("to", str);
        new C0525v(this.f15847c, c0478baM1704b, bundle).m1902a(new C4422f(this)).mo1900a().show();
    }

    /* renamed from: a */
    public void m16609a(EnumC0496bs enumC0496bs, Exception exc) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m16599d(String str) {
        C4904y.m18639b(str, "FacebookManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static void m16600e(String str) {
        C4904y.m18634a(str, "FacebookManager");
    }

    /* renamed from: g */
    public void m16617g() {
        m16599d("killAllTask() \t- Requests count : " + this.f15850f.size() + "\tRequests : " + this.f15850f);
        synchronized (this.f15850f) {
            Iterator<C0443am> it = this.f15850f.keySet().iterator();
            while (it.hasNext()) {
                AsyncTaskC0453aw asyncTaskC0453aw = this.f15850f.get(it.next());
                if (asyncTaskC0453aw != null) {
                    asyncTaskC0453aw.cancel(true);
                }
            }
            this.f15850f.clear();
        }
    }
}
