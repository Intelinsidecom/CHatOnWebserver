package p021c.p022a;

import java.io.File;
import java.io.Serializable;

/* compiled from: PostParameter.java */
/* renamed from: c.a.g */
/* loaded from: classes.dex */
public class C0332g implements Serializable, Comparable {

    /* renamed from: a */
    String f758a;

    /* renamed from: b */
    String f759b;

    /* renamed from: c */
    private File f760c = null;

    public C0332g(String str, String str2) {
        this.f758a = str;
        this.f759b = str2;
    }

    public C0332g(String str, int i) {
        this.f758a = str;
        this.f759b = String.valueOf(i);
    }

    public int hashCode() {
        return (this.f760c != null ? this.f760c.hashCode() : 0) + (((this.f758a.hashCode() * 31) + this.f759b.hashCode()) * 31);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0332g)) {
            return false;
        }
        C0332g c0332g = (C0332g) obj;
        if (this.f760c != null) {
            if (!this.f760c.equals(c0332g.f760c)) {
                return false;
            }
        } else if (c0332g.f760c != null) {
            return false;
        }
        return this.f758a.equals(c0332g.f758a) && this.f759b.equals(c0332g.f759b);
    }

    public String toString() {
        return "PostParameter{name='" + this.f758a + "', value='" + this.f759b + "', file=" + this.f760c + '}';
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        C0332g c0332g = (C0332g) obj;
        int iCompareTo = this.f758a.compareTo(c0332g.f758a);
        if (iCompareTo == 0) {
            return this.f759b.compareTo(c0332g.f759b);
        }
        return iCompareTo;
    }
}
