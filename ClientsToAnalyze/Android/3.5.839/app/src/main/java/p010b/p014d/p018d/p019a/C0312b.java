package p010b.p014d.p018d.p019a;

/* compiled from: JSONException.java */
/* renamed from: b.d.d.a.b */
/* loaded from: classes.dex */
public class C0312b extends Exception {

    /* renamed from: a */
    private Throwable f692a;

    public C0312b(String str) {
        super(str);
    }

    public C0312b(Throwable th) {
        super(th.getMessage());
        this.f692a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f692a;
    }
}
