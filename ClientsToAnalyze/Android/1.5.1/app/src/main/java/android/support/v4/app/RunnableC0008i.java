package android.support.v4.app;

/* renamed from: android.support.v4.app.i */
/* loaded from: classes.dex */
class RunnableC0008i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ListFragment f46a;

    RunnableC0008i(ListFragment listFragment) {
        this.f46a = listFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f46a.f17f.focusableViewAvailable(this.f46a.f17f);
    }
}
