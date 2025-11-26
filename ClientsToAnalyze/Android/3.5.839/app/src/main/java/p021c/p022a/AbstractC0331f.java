package p021c.p022a;

import java.io.Serializable;
import javax.crypto.spec.SecretKeySpec;
import p021c.p023b.p024a.C0339c;

/* compiled from: OAuthToken.java */
/* renamed from: c.a.f */
/* loaded from: classes.dex */
abstract class AbstractC0331f implements Serializable {

    /* renamed from: a */
    String[] f753a;

    /* renamed from: b */
    C0339c f754b;

    /* renamed from: c */
    private String f755c;

    /* renamed from: d */
    private String f756d;

    /* renamed from: e */
    private transient SecretKeySpec f757e;

    AbstractC0331f() {
        this.f753a = null;
        this.f754b = null;
    }

    public AbstractC0331f(String str, String str2) {
        this.f753a = null;
        this.f754b = null;
        this.f755c = str;
        this.f756d = str2;
    }

    AbstractC0331f(C0334i c0334i) {
        this(c0334i.m1174b());
    }

    AbstractC0331f(String str) {
        this.f753a = null;
        this.f754b = null;
        this.f753a = str.split("&");
        this.f756d = mo1120a("oauth_token_secret");
        this.f755c = mo1120a("oauth_token");
    }

    /* renamed from: d */
    public String mo1123d() {
        return this.f755c;
    }

    /* renamed from: c */
    public String mo1122c() {
        return this.f756d;
    }

    /* renamed from: a */
    void m1166a(SecretKeySpec secretKeySpec) {
        this.f757e = secretKeySpec;
    }

    /* renamed from: e */
    SecretKeySpec m1167e() {
        return this.f757e;
    }

    /* renamed from: a */
    public String mo1120a(String str) {
        for (String str2 : this.f753a) {
            if (str2.startsWith(str + '=')) {
                return str2.split("=")[1].trim();
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC0331f)) {
            return false;
        }
        AbstractC0331f abstractC0331f = (AbstractC0331f) obj;
        if (this.f757e == null ? abstractC0331f.f757e != null : !this.f757e.equals(abstractC0331f.f757e)) {
            return false;
        }
        return this.f755c.equals(abstractC0331f.f755c) && this.f756d.equals(abstractC0331f.f756d);
    }

    public int hashCode() {
        return (this.f757e != null ? this.f757e.hashCode() : 0) + (((this.f755c.hashCode() * 31) + this.f756d.hashCode()) * 31);
    }

    public String toString() {
        return "OAuthToken{token='" + this.f755c + "', tokenSecret='" + this.f756d + "', secretKeySpec=" + this.f757e + '}';
    }
}
