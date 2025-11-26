package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.C0109a;
import android.support.v4.view.C0159at;
import android.support.v4.view.p009a.C0110a;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: SlidingPaneLayout.java */
/* renamed from: android.support.v4.widget.ad */
/* loaded from: classes.dex */
class C0229ad extends C0109a {

    /* renamed from: b */
    final /* synthetic */ SlidingPaneLayout f545b;

    /* renamed from: c */
    private final Rect f546c = new Rect();

    C0229ad(SlidingPaneLayout slidingPaneLayout) {
        this.f545b = slidingPaneLayout;
    }

    @Override // android.support.v4.view.C0109a
    /* renamed from: a */
    public void mo433a(View view, C0110a c0110a) {
        C0110a c0110aM440a = C0110a.m440a(c0110a);
        super.mo433a(view, c0110aM440a);
        m808a(c0110a, c0110aM440a);
        c0110aM440a.m483t();
        c0110a.m453b(SlidingPaneLayout.class.getName());
        c0110a.m446a(view);
        Object objM643f = C0159at.m643f(view);
        if (objM643f instanceof View) {
            c0110a.m457c((View) objM643f);
        }
        int childCount = this.f545b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f545b.getChildAt(i);
            if (!m809b(childAt) && childAt.getVisibility() == 0) {
                C0159at.m639b(childAt, 1);
                c0110a.m452b(childAt);
            }
        }
    }

    @Override // android.support.v4.view.C0109a
    /* renamed from: d */
    public void mo439d(View view, AccessibilityEvent accessibilityEvent) {
        super.mo439d(view, accessibilityEvent);
        accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }

    @Override // android.support.v4.view.C0109a
    /* renamed from: a */
    public boolean mo436a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (m809b(view)) {
            return false;
        }
        return super.mo436a(viewGroup, view, accessibilityEvent);
    }

    /* renamed from: b */
    public boolean m809b(View view) {
        return this.f545b.m805e(view);
    }

    /* renamed from: a */
    private void m808a(C0110a c0110a, C0110a c0110a2) {
        Rect rect = this.f546c;
        c0110a2.m445a(rect);
        c0110a.m451b(rect);
        c0110a2.m456c(rect);
        c0110a.m460d(rect);
        c0110a.m459c(c0110a2.m470h());
        c0110a.m447a(c0110a2.m479p());
        c0110a.m453b(c0110a2.m480q());
        c0110a.m458c(c0110a2.m482s());
        c0110a.m469h(c0110a2.m476m());
        c0110a.m465f(c0110a2.m474k());
        c0110a.m448a(c0110a2.m466f());
        c0110a.m454b(c0110a2.m468g());
        c0110a.m461d(c0110a2.m472i());
        c0110a.m463e(c0110a2.m473j());
        c0110a.m467g(c0110a2.m475l());
        c0110a.m444a(c0110a2.m449b());
        c0110a.m450b(c0110a2.m455c());
    }
}
