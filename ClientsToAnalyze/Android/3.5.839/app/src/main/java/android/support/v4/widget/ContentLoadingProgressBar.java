package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a */
    private long f488a;

    /* renamed from: b */
    private boolean f489b;

    /* renamed from: c */
    private boolean f490c;

    /* renamed from: d */
    private boolean f491d;

    /* renamed from: e */
    private final Runnable f492e;

    /* renamed from: f */
    private final Runnable f493f;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f488a = -1L;
        this.f489b = false;
        this.f490c = false;
        this.f491d = false;
        this.f492e = new RunnableC0225a(this);
        this.f493f = new RunnableC0242b(this);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m749a();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m749a();
    }

    /* renamed from: a */
    private void m749a() {
        removeCallbacks(this.f492e);
        removeCallbacks(this.f493f);
    }
}
