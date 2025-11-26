package p021c.p023b.p024a;

/* compiled from: JSONException.java */
/* renamed from: c.b.a.b */
/* loaded from: classes.dex */
public class C0338b extends Exception {

    /* renamed from: a */
    private Throwable f776a;

    public C0338b(String str) {
        super(str);
    }

    public C0338b(Throwable th) {
        super(th.getMessage());
        this.f776a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f776a;
    }
}
