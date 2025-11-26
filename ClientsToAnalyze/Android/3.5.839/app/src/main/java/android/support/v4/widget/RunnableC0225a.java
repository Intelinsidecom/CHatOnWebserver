package android.support.v4.widget;

/* compiled from: ContentLoadingProgressBar.java */
/* renamed from: android.support.v4.widget.a */
/* loaded from: classes.dex */
class RunnableC0225a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ContentLoadingProgressBar f544a;

    RunnableC0225a(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f544a = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f544a.f489b = false;
        this.f544a.f488a = -1L;
        this.f544a.setVisibility(8);
    }
}
