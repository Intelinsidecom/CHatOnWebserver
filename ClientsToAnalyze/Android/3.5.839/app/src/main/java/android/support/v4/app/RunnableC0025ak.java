package android.support.v4.app;

/* compiled from: ListFragment.java */
/* renamed from: android.support.v4.app.ak */
/* loaded from: classes.dex */
class RunnableC0025ak implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ListFragment f105a;

    RunnableC0025ak(ListFragment listFragment) {
        this.f105a = listFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f105a.f66b.focusableViewAvailable(this.f105a.f66b);
    }
}
