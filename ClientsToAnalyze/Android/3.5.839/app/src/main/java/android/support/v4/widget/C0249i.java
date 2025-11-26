package android.support.v4.widget;

import android.graphics.Rect;
import android.support.v4.view.C0109a;
import android.support.v4.view.C0159at;
import android.support.v4.view.p009a.C0110a;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: DrawerLayout.java */
/* renamed from: android.support.v4.widget.i */
/* loaded from: classes.dex */
class C0249i extends C0109a {

    /* renamed from: b */
    final /* synthetic */ DrawerLayout f589b;

    /* renamed from: c */
    private final Rect f590c = new Rect();

    C0249i(DrawerLayout drawerLayout) {
        this.f589b = drawerLayout;
    }

    @Override // android.support.v4.view.C0109a
    /* renamed from: a */
    public void mo433a(View view, C0110a c0110a) {
        C0110a c0110aM440a = C0110a.m440a(c0110a);
        super.mo433a(view, c0110aM440a);
        c0110a.m446a(view);
        Object objM643f = C0159at.m643f(view);
        if (objM643f instanceof View) {
            c0110a.m457c((View) objM643f);
        }
        m881a(c0110a, c0110aM440a);
        c0110aM440a.m483t();
        m882a(c0110a, (ViewGroup) view);
    }

    /* renamed from: a */
    private void m882a(C0110a c0110a, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (!m883b(childAt)) {
                switch (C0159at.m640c(childAt)) {
                    case 0:
                        C0159at.m639b(childAt, 1);
                        break;
                    case 2:
                        if (childAt instanceof ViewGroup) {
                            m882a(c0110a, (ViewGroup) childAt);
                            break;
                        } else {
                            continue;
                        }
                }
                c0110a.m452b(childAt);
            }
        }
    }

    @Override // android.support.v4.view.C0109a
    /* renamed from: a */
    public boolean mo436a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (m883b(view)) {
            return false;
        }
        return super.mo436a(viewGroup, view, accessibilityEvent);
    }

    /* renamed from: b */
    public boolean m883b(View view) {
        View viewM760a = this.f589b.m760a();
        return (viewM760a == null || viewM760a == view) ? false : true;
    }

    /* renamed from: a */
    private void m881a(C0110a c0110a, C0110a c0110a2) {
        Rect rect = this.f590c;
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
    }
}
