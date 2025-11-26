package com.facebook;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.p008b.C0105s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* compiled from: AccessToken.java */
/* renamed from: com.facebook.a */
/* loaded from: classes.dex */
public final class C0053a implements Serializable {

    /* renamed from: a */
    static final /* synthetic */ boolean f51a;

    /* renamed from: b */
    private static final Date f52b;

    /* renamed from: c */
    private static final Date f53c;

    /* renamed from: d */
    private static final Date f54d;

    /* renamed from: e */
    private static final Date f55e;

    /* renamed from: f */
    private static final EnumC0086b f56f;

    /* renamed from: g */
    private static final Date f57g;

    /* renamed from: h */
    private final Date f58h;

    /* renamed from: i */
    private final List<String> f59i;

    /* renamed from: j */
    private final String f60j;

    /* renamed from: k */
    private final EnumC0086b f61k;

    /* renamed from: l */
    private final Date f62l;

    static {
        f51a = !C0053a.class.desiredAssertionStatus();
        f52b = new Date(Long.MIN_VALUE);
        f53c = new Date(Long.MAX_VALUE);
        f54d = f53c;
        f55e = new Date();
        f56f = EnumC0086b.FACEBOOK_APPLICATION_WEB;
        f57g = f52b;
    }

    C0053a(String str, Date date, List<String> list, EnumC0086b enumC0086b, Date date2) {
        list = list == null ? Collections.emptyList() : list;
        this.f58h = date;
        this.f59i = Collections.unmodifiableList(list);
        this.f60j = str;
        this.f61k = enumC0086b;
        this.f62l = date2;
    }

    /* renamed from: a */
    public String m89a() {
        return this.f60j;
    }

    /* renamed from: b */
    public Date m90b() {
        return this.f58h;
    }

    /* renamed from: c */
    public List<String> m91c() {
        return this.f59i;
    }

    /* renamed from: d */
    public EnumC0086b m92d() {
        return this.f61k;
    }

    /* renamed from: e */
    public Date m93e() {
        return this.f62l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{AccessToken");
        sb.append(" token:").append(m88h());
        m87a(sb);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    static C0053a m83a(List<String> list) {
        return new C0053a("", f57g, list, EnumC0086b.NONE, f55e);
    }

    /* renamed from: a */
    static C0053a m80a(Bundle bundle, EnumC0086b enumC0086b) throws NumberFormatException {
        return m85a(bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS"), bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), m86a(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L)), enumC0086b);
    }

    /* renamed from: a */
    static C0053a m84a(List<String> list, Bundle bundle, EnumC0086b enumC0086b) throws NumberFormatException {
        return m85a(list, bundle.getString("access_token"), m86a(bundle, "expires_in", new Date()), enumC0086b);
    }

    @SuppressLint({"FieldGetter"})
    /* renamed from: a */
    static C0053a m81a(C0053a c0053a, Bundle bundle) throws NumberFormatException {
        if (!f51a && c0053a.f61k != EnumC0086b.FACEBOOK_APPLICATION_WEB && c0053a.f61k != EnumC0086b.FACEBOOK_APPLICATION_NATIVE && c0053a.f61k != EnumC0086b.FACEBOOK_APPLICATION_SERVICE) {
            throw new AssertionError();
        }
        Date dateM86a = m86a(bundle, "expires_in", new Date(0L));
        return m85a(c0053a.m91c(), bundle.getString("access_token"), dateM86a, c0053a.f61k);
    }

    /* renamed from: a */
    static C0053a m82a(C0053a c0053a, List<String> list) {
        return new C0053a(c0053a.f60j, c0053a.f58h, list, c0053a.f61k, c0053a.f62l);
    }

    /* renamed from: a */
    private static C0053a m85a(List<String> list, String str, Date date, EnumC0086b enumC0086b) {
        return (C0105s.m273a(str) || date == null) ? m83a(list) : new C0053a(str, date, list, enumC0086b, new Date());
    }

    /* renamed from: a */
    static C0053a m79a(Bundle bundle) {
        List listUnmodifiableList;
        ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.TokenCachingStrategy.Permissions");
        if (stringArrayList == null) {
            listUnmodifiableList = Collections.emptyList();
        } else {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(stringArrayList));
        }
        return new C0053a(bundle.getString("com.facebook.TokenCachingStrategy.Token"), AbstractC0130bx.m375a(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate"), listUnmodifiableList, AbstractC0130bx.m378c(bundle), AbstractC0130bx.m375a(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"));
    }

    /* renamed from: f */
    Bundle m94f() {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.TokenCachingStrategy.Token", this.f60j);
        AbstractC0130bx.m376a(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate", this.f58h);
        bundle.putStringArrayList("com.facebook.TokenCachingStrategy.Permissions", new ArrayList<>(this.f59i));
        bundle.putSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource", this.f61k);
        AbstractC0130bx.m376a(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate", this.f62l);
        return bundle;
    }

    /* renamed from: g */
    boolean m95g() {
        return C0105s.m273a(this.f60j) || new Date().after(this.f58h);
    }

    /* renamed from: h */
    private String m88h() {
        if (this.f60j == null) {
            return "null";
        }
        if (C0127bu.m367a(EnumC0070ak.INCLUDE_ACCESS_TOKENS)) {
            return this.f60j;
        }
        return "ACCESS_TOKEN_REMOVED";
    }

    /* renamed from: a */
    private void m87a(StringBuilder sb) {
        sb.append(" permissions:");
        if (this.f59i == null) {
            sb.append("null");
            return;
        }
        sb.append("[");
        sb.append(TextUtils.join(", ", this.f59i));
        sb.append("]");
    }

    /* renamed from: a */
    private static Date m86a(Bundle bundle, String str, Date date) throws NumberFormatException {
        long jLongValue;
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            jLongValue = ((Long) obj).longValue();
        } else {
            if (!(obj instanceof String)) {
                return null;
            }
            try {
                jLongValue = Long.parseLong((String) obj);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        if (jLongValue == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date((jLongValue * 1000) + date.getTime());
    }
}
