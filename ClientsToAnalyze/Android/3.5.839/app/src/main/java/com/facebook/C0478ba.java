package com.facebook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.C0096i;
import android.util.Log;
import com.facebook.p032b.C0476s;
import com.facebook.p032b.C0477t;
import com.facebook.p032b.EnumC0471n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* compiled from: Session.java */
/* renamed from: com.facebook.ba */
/* loaded from: classes.dex */
public class C0478ba implements Serializable {

    /* renamed from: c */
    private static C0478ba f1168c;

    /* renamed from: d */
    private static volatile Context f1169d;

    /* renamed from: f */
    private String f1171f;

    /* renamed from: g */
    private EnumC0496bs f1172g;

    /* renamed from: h */
    private C0424a f1173h;

    /* renamed from: i */
    private Date f1174i;

    /* renamed from: j */
    private C0484bg f1175j;

    /* renamed from: k */
    private C0502c f1176k;

    /* renamed from: l */
    private volatile Bundle f1177l;

    /* renamed from: m */
    private final List<InterfaceC0491bn> f1178m;

    /* renamed from: n */
    private Handler f1179n;

    /* renamed from: o */
    private AsyncTaskC0487bj f1180o;

    /* renamed from: p */
    private final Object f1181p;

    /* renamed from: q */
    private AbstractC0501bx f1182q;

    /* renamed from: r */
    private volatile ServiceConnectionC0492bo f1183r;

    /* renamed from: a */
    public static final String f1166a = C0478ba.class.getCanonicalName();

    /* renamed from: b */
    private static final Object f1167b = new Object();

    /* renamed from: e */
    private static final Set<String> f1170e = new C0479bb();

    C0478ba(Context context, String str, AbstractC0501bx abstractC0501bx) {
        this(context, str, abstractC0501bx, true);
    }

    C0478ba(Context context, String str, AbstractC0501bx abstractC0501bx, boolean z) {
        this.f1174i = new Date(0L);
        this.f1181p = new Object();
        if (context != null && str == null) {
            str = "254066384616989";
        }
        C0477t.m1721a((Object) str, "applicationId");
        m1740b(context);
        abstractC0501bx = abstractC0501bx == null ? new C0500bw(f1169d) : abstractC0501bx;
        this.f1171f = str;
        this.f1182q = abstractC0501bx;
        this.f1172g = EnumC0496bs.CREATED;
        this.f1175j = null;
        this.f1178m = new ArrayList();
        this.f1179n = new Handler(Looper.getMainLooper());
        Bundle bundleMo1815a = z ? abstractC0501bx.mo1815a() : null;
        if (AbstractC0501bx.m1820b(bundleMo1815a)) {
            Date dateM1818a = AbstractC0501bx.m1818a(bundleMo1815a, "com.facebook.TokenCachingStrategy.ExpirationDate");
            Date date = new Date();
            if (dateM1818a == null || dateM1818a.before(date)) {
                abstractC0501bx.mo1817b();
                this.f1173h = C0424a.m1526a((List<String>) Collections.emptyList());
                return;
            } else {
                this.f1173h = C0424a.m1522a(bundleMo1815a);
                this.f1172g = EnumC0496bs.CREATED_TOKEN_LOADED;
                return;
            }
        }
        this.f1173h = C0424a.m1526a((List<String>) Collections.emptyList());
    }

    /* renamed from: a */
    public final Bundle m1753a() {
        Bundle bundle;
        synchronized (this.f1181p) {
            bundle = this.f1177l;
        }
        return bundle;
    }

    /* renamed from: b */
    public final boolean m1762b() {
        boolean zM1805a;
        synchronized (this.f1181p) {
            zM1805a = this.f1172g.m1805a();
        }
        return zM1805a;
    }

    /* renamed from: c */
    public final EnumC0496bs m1763c() {
        EnumC0496bs enumC0496bs;
        synchronized (this.f1181p) {
            enumC0496bs = this.f1172g;
        }
        return enumC0496bs;
    }

    /* renamed from: d */
    public final String m1764d() {
        return this.f1171f;
    }

    /* renamed from: e */
    public final String m1765e() {
        String strM1532a;
        synchronized (this.f1181p) {
            strM1532a = this.f1173h == null ? null : this.f1173h.m1532a();
        }
        return strM1532a;
    }

    /* renamed from: f */
    public final Date m1766f() {
        Date dateM1533b;
        synchronized (this.f1181p) {
            dateM1533b = this.f1173h == null ? null : this.f1173h.m1533b();
        }
        return dateM1533b;
    }

    /* renamed from: g */
    public final List<String> m1767g() {
        List<String> listM1534c;
        synchronized (this.f1181p) {
            listM1534c = this.f1173h == null ? null : this.f1173h.m1534c();
        }
        return listM1534c;
    }

    /* renamed from: a */
    public final void m1757a(C0489bl c0489bl) {
        m1736a(c0489bl, EnumC0471n.READ);
    }

    /* renamed from: h */
    public final void m1768h() {
        synchronized (this.f1181p) {
            EnumC0496bs enumC0496bs = this.f1172g;
            switch (C0483bf.f1190a[this.f1172g.ordinal()]) {
                case 1:
                case 2:
                    this.f1172g = EnumC0496bs.CLOSED_LOGIN_FAILED;
                    m1759a(enumC0496bs, this.f1172g, new C0551y("Log in attempt aborted."));
                    break;
                case 3:
                case 4:
                case 5:
                    this.f1172g = EnumC0496bs.CLOSED;
                    m1759a(enumC0496bs, this.f1172g, (Exception) null);
                    break;
            }
        }
    }

    /* renamed from: i */
    public final void m1769i() {
        if (this.f1182q != null) {
            this.f1182q.mo1817b();
        }
        C0476s.m1711a(f1169d);
        m1768h();
    }

    /* renamed from: a */
    public final void m1758a(InterfaceC0491bn interfaceC0491bn) {
        synchronized (this.f1178m) {
            if (interfaceC0491bn != null) {
                if (!this.f1178m.contains(interfaceC0491bn)) {
                    this.f1178m.add(interfaceC0491bn);
                }
            }
        }
    }

    /* renamed from: b */
    public final void m1761b(InterfaceC0491bn interfaceC0491bn) {
        synchronized (this.f1178m) {
            this.f1178m.remove(interfaceC0491bn);
        }
    }

    public String toString() {
        return "{Session state:" + this.f1172g + ", token:" + (this.f1173h == null ? "null" : this.f1173h) + ", appId:" + (this.f1171f == null ? "null" : this.f1171f) + "}";
    }

    /* renamed from: a */
    void m1754a(Bundle bundle) {
        synchronized (this.f1181p) {
            EnumC0496bs enumC0496bs = this.f1172g;
            switch (C0483bf.f1190a[this.f1172g.ordinal()]) {
                case 4:
                    this.f1172g = EnumC0496bs.OPENED_TOKEN_UPDATED;
                    m1759a(enumC0496bs, this.f1172g, (Exception) null);
                    break;
                case 5:
                    break;
                default:
                    Log.d(f1166a, "refreshToken ignored in state " + this.f1172g);
                    return;
            }
            this.f1173h = C0424a.m1524a(this.f1173h, bundle);
            if (this.f1182q != null) {
                this.f1182q.mo1816a(this.f1173h.m1537f());
            }
        }
    }

    /* renamed from: j */
    public static final C0478ba m1749j() {
        C0478ba c0478ba;
        synchronized (f1167b) {
            c0478ba = f1168c;
        }
        return c0478ba;
    }

    /* renamed from: a */
    public static final void m1733a(C0478ba c0478ba) {
        synchronized (f1167b) {
            if (c0478ba != f1168c) {
                C0478ba c0478ba2 = f1168c;
                if (c0478ba2 != null) {
                    c0478ba2.m1768h();
                }
                f1168c = c0478ba;
                if (c0478ba2 != null) {
                    m1744b("com.facebook.sdk.ACTIVE_SESSION_UNSET");
                }
                if (c0478ba != null) {
                    m1744b("com.facebook.sdk.ACTIVE_SESSION_SET");
                    if (c0478ba.m1762b()) {
                        m1744b("com.facebook.sdk.ACTIVE_SESSION_OPENED");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static C0478ba m1726a(Context context) {
        return m1727a(context, false, (C0489bl) null);
    }

    /* renamed from: a */
    private static C0478ba m1727a(Context context, boolean z, C0489bl c0489bl) {
        C0478ba c0478baM1792a = new C0488bk(context).m1792a();
        if (!EnumC0496bs.CREATED_TOKEN_LOADED.equals(c0478baM1792a.m1763c()) && !z) {
            return null;
        }
        m1733a(c0478baM1792a);
        c0478baM1792a.m1757a(c0489bl);
        return c0478baM1792a;
    }

    /* renamed from: k */
    static Context m1750k() {
        return f1169d;
    }

    /* renamed from: b */
    static void m1740b(Context context) {
        if (context != null && f1169d == null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            f1169d = context;
        }
    }

    /* renamed from: a */
    void m1756a(C0484bg c0484bg) {
        boolean zM1747c = false;
        c0484bg.m1782a(this.f1171f);
        m1752q();
        if (c0484bg.f1195e) {
            zM1747c = m1747c(c0484bg);
        }
        if (!zM1747c) {
            synchronized (this.f1181p) {
                EnumC0496bs enumC0496bs = this.f1172g;
                switch (C0483bf.f1190a[this.f1172g.ordinal()]) {
                    case 6:
                    case 7:
                        break;
                    default:
                        this.f1172g = EnumC0496bs.CLOSED_LOGIN_FAILED;
                        m1759a(enumC0496bs, this.f1172g, new C0551y("Log in attempt failed."));
                        break;
                }
            }
        }
    }

    /* renamed from: a */
    private void m1736a(C0489bl c0489bl, EnumC0471n enumC0471n) {
        EnumC0496bs enumC0496bs;
        m1735a((C0484bg) c0489bl, enumC0471n);
        m1743b(c0489bl);
        synchronized (this.f1181p) {
            if (this.f1175j != null) {
                m1759a(this.f1172g, this.f1172g, new UnsupportedOperationException("Session: an attempt was made to open a session that has a pending request."));
                return;
            }
            EnumC0496bs enumC0496bs2 = this.f1172g;
            switch (C0483bf.f1190a[this.f1172g.ordinal()]) {
                case 1:
                    enumC0496bs = EnumC0496bs.OPENING;
                    this.f1172g = enumC0496bs;
                    if (c0489bl == null) {
                        throw new IllegalArgumentException("openRequest cannot be null when opening a new Session");
                    }
                    this.f1175j = c0489bl;
                    break;
                case 2:
                default:
                    throw new UnsupportedOperationException("Session: an attempt was made to open an already opened session.");
                case 3:
                    if (c0489bl != null && !C0476s.m1718a(c0489bl.m1784b()) && !C0476s.m1719a(c0489bl.m1784b(), m1767g())) {
                        this.f1175j = c0489bl;
                    }
                    if (this.f1175j == null) {
                        enumC0496bs = EnumC0496bs.OPENED;
                        this.f1172g = enumC0496bs;
                        break;
                    } else {
                        enumC0496bs = EnumC0496bs.OPENING;
                        this.f1172g = enumC0496bs;
                        break;
                    }
            }
            if (c0489bl != null) {
                m1758a(c0489bl.m1781a());
            }
            m1759a(enumC0496bs2, enumC0496bs, (Exception) null);
            if (enumC0496bs == EnumC0496bs.OPENING) {
                m1756a((C0484bg) c0489bl);
            }
        }
    }

    /* renamed from: b */
    private void m1743b(C0484bg c0484bg) {
    }

    /* renamed from: a */
    private void m1735a(C0484bg c0484bg, EnumC0471n enumC0471n) {
        if (c0484bg == null || C0476s.m1718a(c0484bg.m1784b())) {
            if (EnumC0471n.PUBLISH.equals(enumC0471n)) {
                throw new C0551y("Cannot request publish or manage authorization with no permissions.");
            }
            return;
        }
        for (String str : c0484bg.m1784b()) {
            if (m1738a(str)) {
                if (EnumC0471n.READ.equals(enumC0471n)) {
                    throw new C0551y(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", str));
                }
            } else if (EnumC0471n.PUBLISH.equals(enumC0471n)) {
                Log.w(f1166a, String.format("Should not pass a read permission (%s) to a request for publish or manage authorization", str));
            }
        }
    }

    /* renamed from: a */
    static boolean m1738a(String str) {
        return str != null && (str.startsWith("publish") || str.startsWith("manage") || f1170e.contains(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1730a(int i, C0544r c0544r) {
        Exception c0431aa;
        C0424a c0424a;
        if (i == -1) {
            if (c0544r.f1358a == EnumC0545s.SUCCESS) {
                c0424a = c0544r.f1359b;
                c0431aa = null;
            } else {
                c0431aa = new C0549w(c0544r.f1360c);
                c0424a = null;
            }
        } else if (i == 0) {
            c0431aa = new C0431aa(c0544r.f1360c);
            c0424a = null;
        } else {
            c0431aa = null;
            c0424a = null;
        }
        this.f1176k = null;
        m1755a(c0424a, c0431aa);
    }

    /* renamed from: c */
    private boolean m1747c(C0484bg c0484bg) {
        this.f1176k = new C0502c();
        this.f1176k.m1833a(new C0480bc(this));
        this.f1176k.m1831a(m1750k());
        this.f1176k.m1832a(c0484bg.m1785c());
        return true;
    }

    /* renamed from: a */
    void m1755a(C0424a c0424a, Exception exc) {
        if (c0424a != null && c0424a.m1538g()) {
            c0424a = null;
            exc = new C0551y("Invalid access token.");
        }
        synchronized (this.f1181p) {
            switch (C0483bf.f1190a[this.f1172g.ordinal()]) {
                case 2:
                    m1742b(c0424a, exc);
                    break;
                case 4:
                case 5:
                    m1746c(c0424a, exc);
                    break;
            }
        }
    }

    /* renamed from: b */
    private void m1742b(C0424a c0424a, Exception exc) {
        EnumC0496bs enumC0496bs = this.f1172g;
        if (c0424a != null) {
            this.f1173h = c0424a;
            m1732a(c0424a);
            this.f1172g = EnumC0496bs.OPENED;
        } else if (exc != null) {
            this.f1172g = EnumC0496bs.CLOSED_LOGIN_FAILED;
        }
        this.f1175j = null;
        m1759a(enumC0496bs, this.f1172g, exc);
    }

    /* renamed from: c */
    private void m1746c(C0424a c0424a, Exception exc) {
        EnumC0496bs enumC0496bs = this.f1172g;
        if (c0424a != null) {
            this.f1173h = c0424a;
            m1732a(c0424a);
            this.f1172g = EnumC0496bs.OPENED_TOKEN_UPDATED;
        }
        this.f1175j = null;
        m1759a(enumC0496bs, this.f1172g, exc);
    }

    /* renamed from: a */
    private void m1732a(C0424a c0424a) {
        if (c0424a != null && this.f1182q != null) {
            this.f1182q.mo1816a(c0424a.m1537f());
        }
    }

    /* renamed from: a */
    void m1759a(EnumC0496bs enumC0496bs, EnumC0496bs enumC0496bs2, Exception exc) {
        if (enumC0496bs != enumC0496bs2 || exc != null) {
            if (enumC0496bs2.m1806b()) {
                this.f1173h = C0424a.m1526a((List<String>) Collections.emptyList());
            }
            synchronized (this.f1178m) {
                m1741b(this.f1179n, new RunnableC0481bd(this, enumC0496bs2, exc));
            }
            if (this == f1168c && enumC0496bs.m1805a() != enumC0496bs2.m1805a()) {
                if (enumC0496bs2.m1805a()) {
                    m1744b("com.facebook.sdk.ACTIVE_SESSION_OPENED");
                } else {
                    m1744b("com.facebook.sdk.ACTIVE_SESSION_CLOSED");
                }
            }
        }
    }

    /* renamed from: b */
    static void m1744b(String str) {
        C0096i.m358a(m1750k()).m363a(new Intent(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m1741b(Handler handler, Runnable runnable) {
        if (handler != null) {
            handler.post(runnable);
        } else {
            C0498bu.m1808a().execute(runnable);
        }
    }

    /* renamed from: l */
    void m1770l() {
        if (m1772n()) {
            m1771m();
        }
    }

    /* renamed from: m */
    void m1771m() {
        ServiceConnectionC0492bo serviceConnectionC0492bo = null;
        synchronized (this.f1181p) {
            if (this.f1183r == null) {
                serviceConnectionC0492bo = new ServiceConnectionC0492bo(this);
                this.f1183r = serviceConnectionC0492bo;
            }
        }
        if (serviceConnectionC0492bo != null) {
            serviceConnectionC0492bo.m1801a();
        }
    }

    /* renamed from: n */
    boolean m1772n() {
        if (this.f1183r != null) {
            return false;
        }
        Date date = new Date();
        return this.f1172g.m1805a() && this.f1173h.m1535d().m1663a() && date.getTime() - this.f1174i.getTime() > 3600000 && date.getTime() - this.f1173h.m1536e().getTime() > 86400000;
    }

    /* renamed from: o */
    C0424a m1773o() {
        return this.f1173h;
    }

    /* renamed from: a */
    void m1760a(Date date) {
        this.f1174i = date;
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0478ba)) {
            return false;
        }
        C0478ba c0478ba = (C0478ba) obj;
        return m1737a(c0478ba.f1171f, this.f1171f) && m1737a(c0478ba.f1177l, this.f1177l) && m1737a(c0478ba.f1172g, this.f1172g) && m1737a(c0478ba.m1766f(), m1766f());
    }

    /* renamed from: a */
    private static boolean m1737a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: q */
    private void m1752q() {
        String str;
        AsyncTaskC0487bj asyncTaskC0487bj = null;
        synchronized (this) {
            if (this.f1180o == null && C0498bu.m1811b() && (str = this.f1171f) != null) {
                asyncTaskC0487bj = new AsyncTaskC0487bj(this, str, f1169d);
                this.f1180o = asyncTaskC0487bj;
            }
        }
        if (asyncTaskC0487bj != null) {
            asyncTaskC0487bj.execute(new Void[0]);
        }
    }
}
