package p010b.p012b;

import java.io.Serializable;
import javax.crypto.spec.SecretKeySpec;
import p010b.p014d.p015a.AbstractC0297l;
import p010b.p014d.p020e.C0317a;

/* compiled from: OAuthToken.java */
/* renamed from: b.b.h */
/* loaded from: classes.dex */
abstract class AbstractC0279h implements Serializable {

    /* renamed from: a */
    String[] f628a;

    /* renamed from: b */
    private String f629b;

    /* renamed from: c */
    private String f630c;

    /* renamed from: d */
    private transient SecretKeySpec f631d;

    public AbstractC0279h(String str, String str2) {
        this.f628a = null;
        this.f629b = str;
        this.f630c = str2;
    }

    AbstractC0279h(AbstractC0297l abstractC0297l) {
        this(abstractC0297l.m1028c());
    }

    AbstractC0279h(String str) {
        this.f628a = null;
        this.f628a = C0317a.m1074a(str, "&");
        this.f630c = mo952a("oauth_token_secret");
        this.f629b = mo952a("oauth_token");
    }

    /* renamed from: c */
    public String mo954c() {
        return this.f629b;
    }

    /* renamed from: b */
    public String mo953b() {
        return this.f630c;
    }

    /* renamed from: a */
    void m974a(SecretKeySpec secretKeySpec) {
        this.f631d = secretKeySpec;
    }

    /* renamed from: d */
    SecretKeySpec m975d() {
        return this.f631d;
    }

    /* renamed from: a */
    public String mo952a(String str) {
        for (String str2 : this.f628a) {
            if (str2.startsWith(str + '=')) {
                return C0317a.m1074a(str2, "=")[1].trim();
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC0279h)) {
            return false;
        }
        AbstractC0279h abstractC0279h = (AbstractC0279h) obj;
        return this.f629b.equals(abstractC0279h.f629b) && this.f630c.equals(abstractC0279h.f630c);
    }

    public int hashCode() {
        return (this.f629b.hashCode() * 31) + this.f630c.hashCode();
    }

    public String toString() {
        return "OAuthToken{token='" + this.f629b + "', tokenSecret='" + this.f630c + "', secretKeySpec=" + this.f631d + '}';
    }
}
