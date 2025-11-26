package android.support.v4.widget;

import android.support.v4.view.C0159at;
import android.view.View;

/* compiled from: SlidingPaneLayout.java */
/* renamed from: android.support.v4.widget.ae */
/* loaded from: classes.dex */
class RunnableC0230ae implements Runnable {

    /* renamed from: a */
    final View f547a;

    /* renamed from: b */
    final /* synthetic */ SlidingPaneLayout f548b;

    RunnableC0230ae(SlidingPaneLayout slidingPaneLayout, View view) {
        this.f548b = slidingPaneLayout;
        this.f547a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f547a.getParent() == this.f548b) {
            C0159at.m633a(this.f547a, 0, null);
            this.f548b.m794g(this.f547a);
        }
        this.f548b.f538t.remove(this);
    }
}
