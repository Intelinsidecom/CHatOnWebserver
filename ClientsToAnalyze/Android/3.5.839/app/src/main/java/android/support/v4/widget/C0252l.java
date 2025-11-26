package android.support.v4.widget;

import android.support.v4.widget.DrawerLayout;
import android.view.View;

/* compiled from: DrawerLayout.java */
/* renamed from: android.support.v4.widget.l */
/* loaded from: classes.dex */
class C0252l extends AbstractC0241ap {

    /* renamed from: a */
    final /* synthetic */ DrawerLayout f591a;

    /* renamed from: b */
    private final int f592b;

    /* renamed from: c */
    private C0238am f593c;

    /* renamed from: d */
    private final Runnable f594d = new RunnableC0253m(this);

    public C0252l(DrawerLayout drawerLayout, int i) {
        this.f591a = drawerLayout;
        this.f592b = i;
    }

    /* renamed from: a */
    public void m890a(C0238am c0238am) {
        this.f593c = c0238am;
    }

    /* renamed from: a */
    public void m889a() {
        this.f591a.removeCallbacks(this.f594d);
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: a */
    public boolean mo815a(View view, int i) {
        return this.f591a.m774g(view) && this.f591a.m765a(view, this.f592b) && this.f591a.m759a(view) == 0;
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: a */
    public void mo812a(int i) {
        this.f591a.m762a(this.f592b, i, this.f593c.m858c());
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: a */
    public void mo814a(View view, int i, int i2, int i3, int i4) {
        float width;
        int width2 = view.getWidth();
        if (this.f591a.m765a(view, 3)) {
            width = (width2 + i) / width2;
        } else {
            width = (this.f591a.getWidth() - i) / width2;
        }
        this.f591a.m768b(view, width);
        view.setVisibility(width == 0.0f ? 4 : 0);
        this.f591a.invalidate();
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: b */
    public void mo817b(View view, int i) {
        ((DrawerLayout.LayoutParams) view.getLayoutParams()).f517c = false;
        m887b();
    }

    /* renamed from: b */
    private void m887b() {
        View viewM761a = this.f591a.m761a(this.f592b == 3 ? 5 : 3);
        if (viewM761a != null) {
            this.f591a.m776i(viewM761a);
        }
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: a */
    public void mo813a(View view, float f, float f2) {
        int width;
        float fM771d = this.f591a.m771d(view);
        int width2 = view.getWidth();
        if (this.f591a.m765a(view, 3)) {
            width = (f > 0.0f || (f == 0.0f && fM771d > 0.5f)) ? 0 : -width2;
        } else {
            width = this.f591a.getWidth();
            if (f < 0.0f || (f == 0.0f && fM771d > 0.5f)) {
                width -= width2;
            }
        }
        this.f593c.m848a(width, view.getTop());
        this.f591a.invalidate();
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: a */
    public void mo866a(int i, int i2) {
        this.f591a.postDelayed(this.f594d, 160L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m888c() {
        View view;
        int i;
        int iM852b = this.f593c.m852b();
        boolean z = this.f592b == 3;
        if (z) {
            View viewM761a = this.f591a.m761a(3);
            int i2 = (viewM761a != null ? -viewM761a.getWidth() : 0) + iM852b;
            view = viewM761a;
            i = i2;
        } else {
            View viewM761a2 = this.f591a.m761a(5);
            int width = this.f591a.getWidth() - iM852b;
            view = viewM761a2;
            i = width;
        }
        if (view != null) {
            if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && this.f591a.m759a(view) == 0) {
                DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) view.getLayoutParams();
                this.f593c.m850a(view, i, view.getTop());
                layoutParams.f517c = true;
                this.f591a.invalidate();
                m887b();
                this.f591a.m769c();
            }
        }
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: b */
    public boolean mo869b(int i) {
        return false;
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: b */
    public void mo816b(int i, int i2) {
        View viewM761a;
        if ((i & 1) == 1) {
            viewM761a = this.f591a.m761a(3);
        } else {
            viewM761a = this.f591a.m761a(5);
        }
        if (viewM761a != null && this.f591a.m759a(viewM761a) == 0) {
            this.f593c.m847a(viewM761a, i2);
        }
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: a */
    public int mo810a(View view) {
        return view.getWidth();
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: a */
    public int mo811a(View view, int i, int i2) {
        if (this.f591a.m765a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.f591a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    @Override // android.support.v4.widget.AbstractC0241ap
    /* renamed from: b */
    public int mo868b(View view, int i, int i2) {
        return view.getTop();
    }
}
