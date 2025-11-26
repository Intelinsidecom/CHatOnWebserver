package android.support.v4.widget;

/* compiled from: ContentLoadingProgressBar.java */
/* renamed from: android.support.v4.widget.b */
/* loaded from: classes.dex */
class RunnableC0242b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ContentLoadingProgressBar f576a;

    RunnableC0242b(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f576a = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f576a.f490c = false;
        if (!this.f576a.f491d) {
            this.f576a.f488a = System.currentTimeMillis();
            this.f576a.setVisibility(0);
        }
    }
}
