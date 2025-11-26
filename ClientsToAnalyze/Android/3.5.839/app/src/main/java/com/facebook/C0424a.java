package com.facebook;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.p032b.C0476s;
import com.p137vk.sdk.VKAccessToken;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* compiled from: AccessToken.java */
/* renamed from: com.facebook.a */
/* loaded from: classes.dex */
public final class C0424a implements Serializable {

    /* renamed from: a */
    static final /* synthetic */ boolean f1020a;

    /* renamed from: b */
    private static final Date f1021b;

    /* renamed from: c */
    private static final Date f1022c;

    /* renamed from: d */
    private static final Date f1023d;

    /* renamed from: e */
    private static final Date f1024e;

    /* renamed from: f */
    private static final EnumC0457b f1025f;

    /* renamed from: g */
    private static final Date f1026g;

    /* renamed from: h */
    private final Date f1027h;

    /* renamed from: i */
    private final List<String> f1028i;

    /* renamed from: j */
    private final String f1029j;

    /* renamed from: k */
    private final EnumC0457b f1030k;

    /* renamed from: l */
    private final Date f1031l;

    static {
        f1020a = !C0424a.class.desiredAssertionStatus();
        f1021b = new Date(Long.MIN_VALUE);
        f1022c = new Date(Long.MAX_VALUE);
        f1023d = f1022c;
        f1024e = new Date();
        f1025f = EnumC0457b.FACEBOOK_APPLICATION_WEB;
        f1026g = f1021b;
    }

    C0424a(String str, Date date, List<String> list, EnumC0457b enumC0457b, Date date2) {
        list = list == null ? Collections.emptyList() : list;
        this.f1027h = date;
        this.f1028i = Collections.unmodifiableList(list);
        this.f1029j = str;
        this.f1030k = enumC0457b;
        this.f1031l = date2;
    }

    /* renamed from: a */
    public String m1532a() {
        return this.f1029j;
    }

    /* renamed from: b */
    public Date m1533b() {
        return this.f1027h;
    }

    /* renamed from: c */
    public List<String> m1534c() {
        return this.f1028i;
    }

    /* renamed from: d */
    public EnumC0457b m1535d() {
        return this.f1030k;
    }

    /* renamed from: e */
    public Date m1536e() {
        return this.f1031l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{AccessToken");
        sb.append(" token:").append(m1531h());
        m1530a(sb);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    static C0424a m1526a(List<String> list) {
        return new C0424a("", f1026g, list, EnumC0457b.NONE, f1024e);
    }

    /* renamed from: a */
    static C0424a m1523a(Bundle bundle, EnumC0457b enumC0457b) throws NumberFormatException {
        return m1528a(bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS"), bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), m1529a(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L)), enumC0457b);
    }

    /* renamed from: a */
    static C0424a m1527a(List<String> list, Bundle bundle, EnumC0457b enumC0457b) throws NumberFormatException {
        return m1528a(list, bundle.getString("access_token"), m1529a(bundle, VKAccessToken.EXPIRES_IN, new Date()), enumC0457b);
    }

    @SuppressLint({"FieldGetter"})
    /* renamed from: a */
    static C0424a m1524a(C0424a c0424a, Bundle bundle) throws NumberFormatException {
        if (!f1020a && c0424a.f1030k != EnumC0457b.FACEBOOK_APPLICATION_WEB && c0424a.f1030k != EnumC0457b.FACEBOOK_APPLICATION_NATIVE && c0424a.f1030k != EnumC0457b.FACEBOOK_APPLICATION_SERVICE) {
            throw new AssertionError();
        }
        Date dateM1529a = m1529a(bundle, VKAccessToken.EXPIRES_IN, new Date(0L));
        return m1528a(c0424a.m1534c(), bundle.getString("access_token"), dateM1529a, c0424a.f1030k);
    }

    /* renamed from: a */
    static C0424a m1525a(C0424a c0424a, List<String> list) {
        return new C0424a(c0424a.f1029j, c0424a.f1027h, list, c0424a.f1030k, c0424a.f1031l);
    }

    /* renamed from: a */
    private static C0424a m1528a(List<String> list, String str, Date date, EnumC0457b enumC0457b) {
        return (C0476s.m1717a(str) || date == null) ? m1526a(list) : new C0424a(str, date, list, enumC0457b, new Date());
    }

    /* renamed from: a */
    static C0424a m1522a(Bundle bundle) {
        List listUnmodifiableList;
        ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.TokenCachingStrategy.Permissions");
        if (stringArrayList == null) {
            listUnmodifiableList = Collections.emptyList();
        } else {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(stringArrayList));
        }
        return new C0424a(bundle.getString("com.facebook.TokenCachingStrategy.Token"), AbstractC0501bx.m1818a(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate"), listUnmodifiableList, AbstractC0501bx.m1821c(bundle), AbstractC0501bx.m1818a(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"));
    }

    /* renamed from: f */
    Bundle m1537f() {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.TokenCachingStrategy.Token", this.f1029j);
        AbstractC0501bx.m1819a(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate", this.f1027h);
        bundle.putStringArrayList("com.facebook.TokenCachingStrategy.Permissions", new ArrayList<>(this.f1028i));
        bundle.putSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource", this.f1030k);
        AbstractC0501bx.m1819a(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate", this.f1031l);
        return bundle;
    }

    /* renamed from: g */
    boolean m1538g() {
        return C0476s.m1717a(this.f1029j) || new Date().after(this.f1027h);
    }

    /* renamed from: h */
    private String m1531h() {
        if (this.f1029j == null) {
            return "null";
        }
        if (C0498bu.m1810a(EnumC0441ak.INCLUDE_ACCESS_TOKENS)) {
            return this.f1029j;
        }
        return "ACCESS_TOKEN_REMOVED";
    }

    /* renamed from: a */
    private void m1530a(StringBuilder sb) {
        sb.append(" permissions:");
        if (this.f1028i == null) {
            sb.append("null");
            return;
        }
        sb.append("[");
        sb.append(TextUtils.join(", ", this.f1028i));
        sb.append("]");
    }

    /* renamed from: a */
    private static Date m1529a(Bundle bundle, String str, Date date) throws NumberFormatException {
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
