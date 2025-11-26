package p021c;

import java.io.Serializable;
import java.util.Date;
import p021c.p023b.p024a.C0338b;
import p021c.p023b.p024a.C0339c;

/* compiled from: RetweetDetails.java */
/* renamed from: c.c */
/* loaded from: classes.dex */
public class C0344c extends C0352k implements Serializable {

    /* renamed from: a */
    private long f783a;

    /* renamed from: b */
    private Date f784b;

    /* renamed from: c */
    private C0346e f785c;

    C0344c(C0339c c0339c) throws C0351j {
        m1214a(c0339c);
    }

    /* renamed from: a */
    private void m1214a(C0339c c0339c) throws C0351j {
        try {
            this.f783a = c0339c.m1198d("retweetId");
            this.f784b = m1243a(c0339c.m1202h("retweetedAt"), "EEE MMM dd HH:mm:ss z yyyy");
            this.f785c = new C0346e(c0339c.m1200f("retweetingUser"));
        } catch (C0338b e) {
            throw new C0351j(e.getMessage() + ":" + c0339c.toString(), e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0344c) && this.f783a == ((C0344c) obj).f783a;
    }

    public int hashCode() {
        return (((((int) (this.f783a ^ (this.f783a >>> 32))) * 31) + this.f784b.hashCode()) * 31) + this.f785c.hashCode();
    }

    public String toString() {
        return "RetweetDetails{retweetId=" + this.f783a + ", retweetedAt=" + this.f784b + ", retweetingUser=" + this.f785c + '}';
    }
}
