package android.support.v4.app;

/* compiled from: FragmentManager.java */
/* renamed from: android.support.v4.app.aa */
/* loaded from: classes.dex */
class RunnableC0015aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f88a;

    /* renamed from: b */
    final /* synthetic */ int f89b;

    /* renamed from: c */
    final /* synthetic */ C0071y f90c;

    RunnableC0015aa(C0071y c0071y, int i, int i2) {
        this.f90c = c0071y;
        this.f88a = i;
        this.f89b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f90c.m208a(this.f90c.f225o.f44a, (String) null, this.f88a, this.f89b);
    }
}
