package p021c;

/* compiled from: WeiboException.java */
/* renamed from: c.j */
/* loaded from: classes.dex */
public class C0351j extends Exception {

    /* renamed from: a */
    private int f852a;

    public C0351j(String str) {
        super(str);
        this.f852a = -1;
    }

    public C0351j(Exception exc) {
        super(exc);
        this.f852a = -1;
    }

    public C0351j(String str, int i) {
        super(str);
        this.f852a = -1;
        this.f852a = i;
    }

    public C0351j(String str, Exception exc) {
        super(str, exc);
        this.f852a = -1;
    }

    public C0351j(String str, Exception exc, int i) {
        super(str, exc);
        this.f852a = -1;
        this.f852a = i;
    }

    /* renamed from: a */
    public int m1241a() {
        return this.f852a;
    }
}
