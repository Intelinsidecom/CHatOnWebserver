package com.sec.chaton.p031g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.facebook.AsyncTaskC0082aw;
import com.facebook.C0060aa;
import com.facebook.C0072am;
import com.facebook.C0107ba;
import com.facebook.C0117bk;
import com.facebook.C0118bl;
import com.facebook.C0178w;
import com.facebook.EnumC0124br;
import com.facebook.EnumC0125bs;
import com.facebook.model.GraphCustomUser;
import com.facebook.model.GraphObject;
import com.facebook.p007a.C0054a;
import com.facebook.p007a.C0057d;
import com.facebook.p007a.C0058e;
import com.facebook.p007a.InterfaceC0056c;
import com.facebook.p008b.C0101o;
import com.facebook.p009c.C0154v;
import com.sec.chaton.R;
import com.sec.chaton.facebook.FacebookManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p020c.C0817b;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2787c;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.g.a */
/* loaded from: classes.dex */
public class C1483a {

    /* renamed from: c */
    private Activity f5492c;

    /* renamed from: d */
    private InterfaceC2787c f5493d;

    /* renamed from: e */
    private C0101o f5494e;

    /* renamed from: b */
    private final Object f5491b = new Object();

    /* renamed from: f */
    private final Map<C0072am, AsyncTaskC0082aw> f5495f = new HashMap();

    /* renamed from: g */
    private ArrayList<FacebookManager.BlockingTasksExecutor> f5496g = new ArrayList<>();

    /* renamed from: a */
    Handler f5490a = new HandlerC1489g(this);

    public C1483a(Activity activity, InterfaceC2787c interfaceC2787c) {
        this.f5492c = activity;
        this.f5493d = interfaceC2787c;
        this.f5494e = new C0101o(this.f5492c, new C1491i(this, null));
        m6431h();
    }

    /* renamed from: h */
    private C0107ba m6431h() {
        C0107ba c0107baM258a = this.f5494e.m258a();
        if (c0107baM258a == null || c0107baM258a.m320c().m363b()) {
            this.f5494e.m259a((C0107ba) null);
            if (C0107ba.m282a(GlobalApplication.m11493l()) == null) {
                C0107ba c0107baM349a = new C0117bk(GlobalApplication.m11493l()).m350a("254066384616989").m349a();
                C0107ba.m289a(c0107baM349a);
                return c0107baM349a;
            }
            return c0107baM258a;
        }
        return c0107baM258a;
    }

    /* renamed from: a */
    public void m6435a(int i) {
        C0107ba c0107baM6431h = m6431h();
        if (!c0107baM6431h.m319b()) {
            c0107baM6431h.m317b(m6432i());
        }
    }

    /* renamed from: i */
    private C0118bl m6432i() {
        C0118bl c0118blM354b = new C0118bl(this.f5492c).mo335a(new C1484b(this, new C1492j(this, 3, null, 0 == true ? 1 : 0))).mo336a(EnumC0124br.SSO_WITH_FALLBACK).mo334a(32665).m354b(Arrays.asList("user_photos", "publish_stream", "read_stream", "email", "offline_access"));
        c0118blM354b.m340a(true);
        return c0118blM354b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6418a(C0107ba c0107ba, EnumC0125bs enumC0125bs, Exception exc, InterfaceC0056c interfaceC0056c) {
        Bundle bundleM309a = c0107ba.m309a();
        if (enumC0125bs == EnumC0125bs.OPENED) {
            C0107ba c0107baM258a = this.f5494e.m258a();
            synchronized (this.f5491b) {
                if (c0107ba == c0107baM258a) {
                    c0107baM258a = null;
                } else {
                    this.f5494e.m259a(c0107ba);
                }
            }
            if (c0107baM258a != null) {
                c0107baM258a.m325h();
            }
            interfaceC0056c.mo97a(bundleM309a);
            return;
        }
        if (exc != null) {
            if (exc instanceof C0060aa) {
                interfaceC0056c.mo96a();
                return;
            }
            if ((exc instanceof C0178w) && bundleM309a != null && bundleM309a.containsKey("com.facebook.sdk.WebViewErrorCode") && bundleM309a.containsKey("com.facebook.sdk.FailingUrl")) {
                interfaceC0056c.mo98a(new C0054a(exc.getMessage(), bundleM309a.getInt("com.facebook.sdk.WebViewErrorCode"), bundleM309a.getString("com.facebook.sdk.FailingUrl")));
            } else {
                interfaceC0056c.mo99a(new C0057d(exc.getMessage()));
            }
        }
    }

    /* renamed from: a */
    public String m6434a() {
        return C0058e.m102b(this.f5492c);
    }

    /* renamed from: b */
    public String m6440b() {
        return C0058e.m104c(this.f5492c);
    }

    /* renamed from: c */
    public String m6441c() {
        return C0058e.m106d(this.f5492c);
    }

    /* renamed from: d */
    public String m6442d() {
        return C0058e.m108e(this.f5492c);
    }

    /* renamed from: a */
    public void m6436a(int i, int i2, Intent intent) {
        m6429d("Login onActivityResult requstCode=" + i + ", resultCode=" + i2);
    }

    /* renamed from: e */
    public boolean m6443e() {
        return this.f5494e.m260b() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m6433j() {
        C0107ba c0107baM260b = this.f5494e.m260b();
        if (c0107baM260b != null) {
            C0072am c0072amM133a = C0072am.m133a(c0107baM260b, new C1485c(this));
            Bundle bundle = new Bundle();
            bundle.putString("fields", "name,email");
            c0072amM133a.m169a(bundle);
            this.f5495f.put(c0072amM133a, C0072am.m154b(c0072amM133a));
        }
    }

    /* renamed from: a */
    public static void m6417a(Context context) {
        C0058e.m100a(context);
    }

    /* renamed from: f */
    public void m6444f() {
        C0107ba c0107baM260b = this.f5494e.m260b();
        if (c0107baM260b != null) {
            C0072am c0072amM134a = C0072am.m134a(c0107baM260b, new C1486d(this));
            Bundle bundle = new Bundle();
            bundle.putString("fields", "name,email,installed");
            c0072amM134a.m169a(bundle);
            this.f5495f.put(c0072amM134a, C0072am.m154b(c0072amM134a));
        }
    }

    /* renamed from: a */
    public void m6437a(int i, String str) {
        if (str != null && !str.isEmpty()) {
            m6427c(str);
        }
    }

    /* renamed from: a */
    public void m6438a(int i, String str, String str2) {
        C0107ba c0107baM260b = this.f5494e.m260b();
        if (c0107baM260b != null) {
            GraphObject graphObjectCreate = GraphObject.Factory.create();
            graphObjectCreate.setProperty("picture", this.f5492c.getString(R.string.logo_url_for_facebook));
            graphObjectCreate.setProperty("message", str2);
            graphObjectCreate.setProperty("description", this.f5492c.getString(R.string.twitter_invite));
            graphObjectCreate.setProperty("link", "www.chaton.com/invite.html");
            graphObjectCreate.setProperty("name", "ChatON");
            graphObjectCreate.setProperty("caption", "www.chaton.com/invite.html");
            C0072am c0072amM136a = C0072am.m136a(c0107baM260b, (str == null || str.isEmpty()) ? "me/feed" : str + "/feed", graphObjectCreate, new C1487e(this));
            this.f5495f.put(c0072amM136a, C0072am.m154b(c0072amM136a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6419a(GraphCustomUser graphCustomUser) {
        C0058e.m103b(this.f5492c, graphCustomUser.getId());
        C0058e.m101a(this.f5492c, graphCustomUser.getName());
        C0058e.m105c(this.f5492c, graphCustomUser.getEmail());
        C0058e.m107d(this.f5492c, C0817b.f3136h + graphCustomUser.getId() + "/picture");
    }

    /* renamed from: c */
    private void m6427c(String str) {
        C0107ba c0107baM260b = this.f5494e.m260b();
        Bundle bundle = new Bundle();
        bundle.putString("picture", this.f5492c.getString(R.string.logo_url_for_facebook));
        bundle.putString("message", "asdasdasdasd");
        bundle.putString("description", this.f5492c.getString(R.string.twitter_invite));
        bundle.putString("link", "www.chaton.com/invite.html");
        bundle.putString("name", "ChatON");
        bundle.putString("caption", "www.chaton.com/invite.html");
        bundle.putString("to", str);
        new C0154v(this.f5492c, c0107baM260b, bundle).m459a(new C1488f(this)).mo457a().show();
    }

    /* renamed from: a */
    public void m6439a(EnumC0125bs enumC0125bs, Exception exc) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m6429d(String str) {
        C3250y.m11450b(str, "FacebookManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static void m6430e(String str) {
        C3250y.m11442a(str, "FacebookManager");
    }

    /* renamed from: g */
    public void m6445g() {
        m6429d("killAllTask() \t- Requests count : " + this.f5495f.size() + "\tRequests : " + this.f5495f);
        synchronized (this.f5495f) {
            Iterator<C0072am> it = this.f5495f.keySet().iterator();
            while (it.hasNext()) {
                AsyncTaskC0082aw asyncTaskC0082aw = this.f5495f.get(it.next());
                if (asyncTaskC0082aw != null) {
                    asyncTaskC0082aw.cancel(true);
                }
            }
            this.f5495f.clear();
        }
    }
}
