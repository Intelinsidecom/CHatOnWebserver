package com.facebook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.p008b.C0105s;
import com.facebook.p008b.C0106t;
import com.facebook.p008b.EnumC0100n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* compiled from: Session.java */
/* renamed from: com.facebook.ba */
/* loaded from: classes.dex */
public class C0107ba implements Serializable {

    /* renamed from: c */
    private static C0107ba f199c;

    /* renamed from: d */
    private static volatile Context f200d;

    /* renamed from: f */
    private String f202f;

    /* renamed from: g */
    private EnumC0125bs f203g;

    /* renamed from: h */
    private C0053a f204h;

    /* renamed from: i */
    private Date f205i;

    /* renamed from: j */
    private C0113bg f206j;

    /* renamed from: k */
    private C0131c f207k;

    /* renamed from: l */
    private volatile Bundle f208l;

    /* renamed from: m */
    private final List<InterfaceC0120bn> f209m;

    /* renamed from: n */
    private Handler f210n;

    /* renamed from: o */
    private AsyncTaskC0116bj f211o;

    /* renamed from: p */
    private final Object f212p;

    /* renamed from: q */
    private AbstractC0130bx f213q;

    /* renamed from: r */
    private volatile ServiceConnectionC0121bo f214r;

    /* renamed from: a */
    public static final String f197a = C0107ba.class.getCanonicalName();

    /* renamed from: b */
    private static final Object f198b = new Object();

    /* renamed from: e */
    private static final Set<String> f201e = new C0108bb();

    C0107ba(Context context, String str, AbstractC0130bx abstractC0130bx) {
        this(context, str, abstractC0130bx, true);
    }

    C0107ba(Context context, String str, AbstractC0130bx abstractC0130bx, boolean z) {
        this.f205i = new Date(0L);
        this.f212p = new Object();
        if (context != null && str == null) {
            str = "254066384616989";
        }
        C0106t.m277a((Object) str, "applicationId");
        m296b(context);
        abstractC0130bx = abstractC0130bx == null ? new C0129bw(f200d) : abstractC0130bx;
        this.f202f = str;
        this.f213q = abstractC0130bx;
        this.f203g = EnumC0125bs.CREATED;
        this.f206j = null;
        this.f209m = new ArrayList();
        this.f210n = new Handler(Looper.getMainLooper());
        Bundle bundleMo372a = z ? abstractC0130bx.mo372a() : null;
        if (AbstractC0130bx.m377b(bundleMo372a)) {
            Date dateM375a = AbstractC0130bx.m375a(bundleMo372a, "com.facebook.TokenCachingStrategy.ExpirationDate");
            Date date = new Date();
            if (dateM375a == null || dateM375a.before(date)) {
                abstractC0130bx.mo374b();
                this.f204h = C0053a.m83a((List<String>) Collections.emptyList());
                return;
            } else {
                this.f204h = C0053a.m79a(bundleMo372a);
                this.f203g = EnumC0125bs.CREATED_TOKEN_LOADED;
                return;
            }
        }
        this.f204h = C0053a.m83a((List<String>) Collections.emptyList());
    }

    /* renamed from: a */
    public final Bundle m309a() {
        Bundle bundle;
        synchronized (this.f212p) {
            bundle = this.f208l;
        }
        return bundle;
    }

    /* renamed from: b */
    public final boolean m319b() {
        boolean zM362a;
        synchronized (this.f212p) {
            zM362a = this.f203g.m362a();
        }
        return zM362a;
    }

    /* renamed from: c */
    public final EnumC0125bs m320c() {
        EnumC0125bs enumC0125bs;
        synchronized (this.f212p) {
            enumC0125bs = this.f203g;
        }
        return enumC0125bs;
    }

    /* renamed from: d */
    public final String m321d() {
        return this.f202f;
    }

    /* renamed from: e */
    public final String m322e() {
        String strM89a;
        synchronized (this.f212p) {
            strM89a = this.f204h == null ? null : this.f204h.m89a();
        }
        return strM89a;
    }

    /* renamed from: f */
    public final Date m323f() {
        Date dateM90b;
        synchronized (this.f212p) {
            dateM90b = this.f204h == null ? null : this.f204h.m90b();
        }
        return dateM90b;
    }

    /* renamed from: g */
    public final List<String> m324g() {
        List<String> listM91c;
        synchronized (this.f212p) {
            listM91c = this.f204h == null ? null : this.f204h.m91c();
        }
        return listM91c;
    }

    /* renamed from: a */
    public final void m313a(C0118bl c0118bl) {
        m292a(c0118bl, EnumC0100n.READ);
    }

    /* renamed from: b */
    public final void m317b(C0118bl c0118bl) {
        m292a(c0118bl, EnumC0100n.PUBLISH);
    }

    /* renamed from: h */
    public final void m325h() {
        synchronized (this.f212p) {
            EnumC0125bs enumC0125bs = this.f203g;
            switch (C0112bf.f221a[this.f203g.ordinal()]) {
                case 1:
                case 2:
                    this.f203g = EnumC0125bs.CLOSED_LOGIN_FAILED;
                    m315a(enumC0125bs, this.f203g, new C0180y("Log in attempt aborted."));
                    break;
                case 3:
                case 4:
                case 5:
                    this.f203g = EnumC0125bs.CLOSED;
                    m315a(enumC0125bs, this.f203g, (Exception) null);
                    break;
            }
        }
    }

    /* renamed from: i */
    public final void m326i() {
        if (this.f213q != null) {
            this.f213q.mo374b();
        }
        C0105s.m267a(f200d);
        m325h();
    }

    /* renamed from: a */
    public final void m314a(InterfaceC0120bn interfaceC0120bn) {
        synchronized (this.f209m) {
            if (interfaceC0120bn != null) {
                if (!this.f209m.contains(interfaceC0120bn)) {
                    this.f209m.add(interfaceC0120bn);
                }
            }
        }
    }

    /* renamed from: b */
    public final void m318b(InterfaceC0120bn interfaceC0120bn) {
        synchronized (this.f209m) {
            this.f209m.remove(interfaceC0120bn);
        }
    }

    public String toString() {
        return "{Session state:" + this.f203g + ", token:" + (this.f204h == null ? "null" : this.f204h) + ", appId:" + (this.f202f == null ? "null" : this.f202f) + "}";
    }

    /* renamed from: a */
    void m310a(Bundle bundle) {
        synchronized (this.f212p) {
            EnumC0125bs enumC0125bs = this.f203g;
            switch (C0112bf.f221a[this.f203g.ordinal()]) {
                case 4:
                    this.f203g = EnumC0125bs.OPENED_TOKEN_UPDATED;
                    m315a(enumC0125bs, this.f203g, (Exception) null);
                    break;
                case 5:
                    break;
                default:
                    Log.d(f197a, "refreshToken ignored in state " + this.f203g);
                    return;
            }
            this.f204h = C0053a.m81a(this.f204h, bundle);
            if (this.f213q != null) {
                this.f213q.mo373a(this.f204h.m94f());
            }
        }
    }

    /* renamed from: j */
    public static final C0107ba m305j() {
        C0107ba c0107ba;
        synchronized (f198b) {
            c0107ba = f199c;
        }
        return c0107ba;
    }

    /* renamed from: a */
    public static final void m289a(C0107ba c0107ba) {
        synchronized (f198b) {
            if (c0107ba != f199c) {
                C0107ba c0107ba2 = f199c;
                if (c0107ba2 != null) {
                    c0107ba2.m325h();
                }
                f199c = c0107ba;
                if (c0107ba2 != null) {
                    m300b("com.facebook.sdk.ACTIVE_SESSION_UNSET");
                }
                if (c0107ba != null) {
                    m300b("com.facebook.sdk.ACTIVE_SESSION_SET");
                    if (c0107ba.m319b()) {
                        m300b("com.facebook.sdk.ACTIVE_SESSION_OPENED");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static C0107ba m282a(Context context) {
        return m283a(context, false, (C0118bl) null);
    }

    /* renamed from: a */
    private static C0107ba m283a(Context context, boolean z, C0118bl c0118bl) {
        C0107ba c0107baM349a = new C0117bk(context).m349a();
        if (!EnumC0125bs.CREATED_TOKEN_LOADED.equals(c0107baM349a.m320c()) && !z) {
            return null;
        }
        m289a(c0107baM349a);
        c0107baM349a.m313a(c0118bl);
        return c0107baM349a;
    }

    /* renamed from: k */
    static Context m306k() {
        return f200d;
    }

    /* renamed from: b */
    static void m296b(Context context) {
        if (context != null && f200d == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            f200d = context;
        }
    }

    /* renamed from: a */
    void m312a(C0113bg c0113bg) {
        boolean zM303c = false;
        c0113bg.m339a(this.f202f);
        m308q();
        if (c0113bg.f226e) {
            zM303c = m303c(c0113bg);
        }
        if (!zM303c) {
            synchronized (this.f212p) {
                EnumC0125bs enumC0125bs = this.f203g;
                switch (C0112bf.f221a[this.f203g.ordinal()]) {
                    case 6:
                    case 7:
                        break;
                    default:
                        this.f203g = EnumC0125bs.CLOSED_LOGIN_FAILED;
                        m315a(enumC0125bs, this.f203g, new C0180y("Log in attempt failed."));
                        break;
                }
            }
        }
    }

    /* renamed from: a */
    private void m292a(C0118bl c0118bl, EnumC0100n enumC0100n) {
        EnumC0125bs enumC0125bs;
        m291a((C0113bg) c0118bl, enumC0100n);
        m299b((C0113bg) c0118bl);
        synchronized (this.f212p) {
            if (this.f206j != null) {
                m315a(this.f203g, this.f203g, new UnsupportedOperationException("Session: an attempt was made to open a session that has a pending request."));
                return;
            }
            EnumC0125bs enumC0125bs2 = this.f203g;
            switch (C0112bf.f221a[this.f203g.ordinal()]) {
                case 1:
                    enumC0125bs = EnumC0125bs.OPENING;
                    this.f203g = enumC0125bs;
                    if (c0118bl == null) {
                        throw new IllegalArgumentException("openRequest cannot be null when opening a new Session");
                    }
                    this.f206j = c0118bl;
                    break;
                case 2:
                default:
                    throw new UnsupportedOperationException("Session: an attempt was made to open an already opened session.");
                case 3:
                    if (c0118bl != null && !C0105s.m274a(c0118bl.m341b()) && !C0105s.m275a(c0118bl.m341b(), m324g())) {
                        this.f206j = c0118bl;
                    }
                    if (this.f206j == null) {
                        enumC0125bs = EnumC0125bs.OPENED;
                        this.f203g = enumC0125bs;
                        break;
                    } else {
                        enumC0125bs = EnumC0125bs.OPENING;
                        this.f203g = enumC0125bs;
                        break;
                    }
            }
            if (c0118bl != null) {
                m314a(c0118bl.m338a());
            }
            m315a(enumC0125bs2, enumC0125bs, (Exception) null);
            if (enumC0125bs == EnumC0125bs.OPENING) {
                m312a((C0113bg) c0118bl);
            }
        }
    }

    /* renamed from: b */
    private void m299b(C0113bg c0113bg) {
    }

    /* renamed from: a */
    private void m291a(C0113bg c0113bg, EnumC0100n enumC0100n) {
        if (c0113bg == null || C0105s.m274a(c0113bg.m341b())) {
            if (EnumC0100n.PUBLISH.equals(enumC0100n)) {
                throw new C0180y("Cannot request publish or manage authorization with no permissions.");
            }
            return;
        }
        for (String str : c0113bg.m341b()) {
            if (m294a(str)) {
                if (EnumC0100n.READ.equals(enumC0100n)) {
                    throw new C0180y(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", str));
                }
            } else if (EnumC0100n.PUBLISH.equals(enumC0100n)) {
                Log.w(f197a, String.format("Should not pass a read permission (%s) to a request for publish or manage authorization", str));
            }
        }
    }

    /* renamed from: a */
    static boolean m294a(String str) {
        return str != null && (str.startsWith("publish") || str.startsWith("manage") || f201e.contains(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m286a(int i, C0173r c0173r) {
        Exception c0060aa;
        C0053a c0053a;
        if (i == -1) {
            if (c0173r.f388a == EnumC0174s.SUCCESS) {
                c0053a = c0173r.f389b;
                c0060aa = null;
            } else {
                c0060aa = new C0178w(c0173r.f390c);
                c0053a = null;
            }
        } else if (i == 0) {
            c0060aa = new C0060aa(c0173r.f390c);
            c0053a = null;
        } else {
            c0060aa = null;
            c0053a = null;
        }
        this.f207k = null;
        m311a(c0053a, c0060aa);
    }

    /* renamed from: c */
    private boolean m303c(C0113bg c0113bg) {
        this.f207k = new C0131c();
        this.f207k.m390a(new C0109bc(this));
        this.f207k.m388a(m306k());
        this.f207k.m389a(c0113bg.m342c());
        return true;
    }

    /* renamed from: a */
    void m311a(C0053a c0053a, Exception exc) {
        if (c0053a != null && c0053a.m95g()) {
            c0053a = null;
            exc = new C0180y("Invalid access token.");
        }
        synchronized (this.f212p) {
            switch (C0112bf.f221a[this.f203g.ordinal()]) {
                case 2:
                    m298b(c0053a, exc);
                    break;
                case 4:
                case 5:
                    m302c(c0053a, exc);
                    break;
            }
        }
    }

    /* renamed from: b */
    private void m298b(C0053a c0053a, Exception exc) {
        EnumC0125bs enumC0125bs = this.f203g;
        if (c0053a != null) {
            this.f204h = c0053a;
            m288a(c0053a);
            this.f203g = EnumC0125bs.OPENED;
        } else if (exc != null) {
            this.f203g = EnumC0125bs.CLOSED_LOGIN_FAILED;
        }
        this.f206j = null;
        m315a(enumC0125bs, this.f203g, exc);
    }

    /* renamed from: c */
    private void m302c(C0053a c0053a, Exception exc) {
        EnumC0125bs enumC0125bs = this.f203g;
        if (c0053a != null) {
            this.f204h = c0053a;
            m288a(c0053a);
            this.f203g = EnumC0125bs.OPENED_TOKEN_UPDATED;
        }
        this.f206j = null;
        m315a(enumC0125bs, this.f203g, exc);
    }

    /* renamed from: a */
    private void m288a(C0053a c0053a) {
        if (c0053a != null && this.f213q != null) {
            this.f213q.mo373a(c0053a.m94f());
        }
    }

    /* renamed from: a */
    void m315a(EnumC0125bs enumC0125bs, EnumC0125bs enumC0125bs2, Exception exc) {
        if (enumC0125bs != enumC0125bs2 || exc != null) {
            if (enumC0125bs2.m363b()) {
                this.f204h = C0053a.m83a((List<String>) Collections.emptyList());
            }
            synchronized (this.f209m) {
                m297b(this.f210n, new RunnableC0110bd(this, enumC0125bs2, exc));
            }
            if (this == f199c && enumC0125bs.m362a() != enumC0125bs2.m362a()) {
                if (enumC0125bs2.m362a()) {
                    m300b("com.facebook.sdk.ACTIVE_SESSION_OPENED");
                } else {
                    m300b("com.facebook.sdk.ACTIVE_SESSION_CLOSED");
                }
            }
        }
    }

    /* renamed from: b */
    static void m300b(String str) {
        LocalBroadcastManager.getInstance(m306k()).sendBroadcast(new Intent(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m297b(Handler handler, Runnable runnable) {
        if (handler != null) {
            handler.post(runnable);
        } else {
            C0127bu.m365a().execute(runnable);
        }
    }

    /* renamed from: l */
    void m327l() {
        if (m329n()) {
            m328m();
        }
    }

    /* renamed from: m */
    void m328m() {
        ServiceConnectionC0121bo serviceConnectionC0121bo = null;
        synchronized (this.f212p) {
            if (this.f214r == null) {
                serviceConnectionC0121bo = new ServiceConnectionC0121bo(this);
                this.f214r = serviceConnectionC0121bo;
            }
        }
        if (serviceConnectionC0121bo != null) {
            serviceConnectionC0121bo.m358a();
        }
    }

    /* renamed from: n */
    boolean m329n() {
        if (this.f214r != null) {
            return false;
        }
        Date date = new Date();
        return this.f203g.m362a() && this.f204h.m92d().m219a() && date.getTime() - this.f205i.getTime() > 3600000 && date.getTime() - this.f204h.m93e().getTime() > 86400000;
    }

    /* renamed from: o */
    C0053a m330o() {
        return this.f204h;
    }

    /* renamed from: a */
    void m316a(Date date) {
        this.f205i = date;
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0107ba)) {
            return false;
        }
        C0107ba c0107ba = (C0107ba) obj;
        return m293a(c0107ba.f202f, this.f202f) && m293a(c0107ba.f208l, this.f208l) && m293a(c0107ba.f203g, this.f203g) && m293a(c0107ba.m323f(), m323f());
    }

    /* renamed from: a */
    private static boolean m293a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: q */
    private void m308q() {
        String str;
        AsyncTaskC0116bj asyncTaskC0116bj = null;
        synchronized (this) {
            if (this.f211o == null && C0127bu.m368b() && (str = this.f202f) != null) {
                asyncTaskC0116bj = new AsyncTaskC0116bj(this, str, f200d);
                this.f211o = asyncTaskC0116bj;
            }
        }
        if (asyncTaskC0116bj != null) {
            asyncTaskC0116bj.execute(new Void[0]);
        }
    }
}
