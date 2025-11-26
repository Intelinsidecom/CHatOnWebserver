package p010b.p012b;

import java.io.Serializable;
import p010b.p014d.p015a.AbstractC0297l;

/* compiled from: AccessToken.java */
/* renamed from: b.b.a */
/* loaded from: classes.dex */
public class C0272a extends AbstractC0279h implements Serializable {

    /* renamed from: b */
    private String f613b;

    /* renamed from: c */
    private long f614c;

    @Override // p010b.p012b.AbstractC0279h
    /* renamed from: a */
    public /* bridge */ /* synthetic */ String mo952a(String str) {
        return super.mo952a(str);
    }

    @Override // p010b.p012b.AbstractC0279h
    /* renamed from: b */
    public /* bridge */ /* synthetic */ String mo953b() {
        return super.mo953b();
    }

    @Override // p010b.p012b.AbstractC0279h
    /* renamed from: c */
    public /* bridge */ /* synthetic */ String mo954c() {
        return super.mo954c();
    }

    C0272a(AbstractC0297l abstractC0297l) {
        this(abstractC0297l.m1028c());
    }

    C0272a(String str) {
        super(str);
        this.f614c = -1L;
        this.f613b = mo952a("screen_name");
        String strMo952a = mo952a("user_id");
        if (strMo952a != null) {
            this.f614c = Long.parseLong(strMo952a);
        }
    }

    public C0272a(String str, String str2) {
        super(str, str2);
        this.f614c = -1L;
        int iIndexOf = str.indexOf("-");
        if (iIndexOf != -1) {
            try {
                this.f614c = Long.parseLong(str.substring(0, iIndexOf));
            } catch (NumberFormatException e) {
            }
        }
    }

    /* renamed from: a */
    public long m951a() {
        return this.f614c;
    }

    @Override // p010b.p012b.AbstractC0279h
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        C0272a c0272a = (C0272a) obj;
        if (this.f614c != c0272a.f614c) {
            return false;
        }
        if (this.f613b != null) {
            if (this.f613b.equals(c0272a.f613b)) {
                return true;
            }
        } else if (c0272a.f613b == null) {
            return true;
        }
        return false;
    }

    @Override // p010b.p012b.AbstractC0279h
    public int hashCode() {
        return (((this.f613b != null ? this.f613b.hashCode() : 0) + (super.hashCode() * 31)) * 31) + ((int) (this.f614c ^ (this.f614c >>> 32)));
    }

    @Override // p010b.p012b.AbstractC0279h
    public String toString() {
        return "AccessToken{screenName='" + this.f613b + "', userId=" + this.f614c + '}';
    }
}
