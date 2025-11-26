package android.support.v4.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.InterfaceC0250j;
import android.view.View;

/* compiled from: ActionBarDrawerToggle.java */
/* renamed from: android.support.v4.app.a */
/* loaded from: classes.dex */
public class C0014a implements InterfaceC0250j {

    /* renamed from: a */
    private static final InterfaceC0049c f76a;

    /* renamed from: b */
    private final Activity f77b;

    /* renamed from: c */
    private final InterfaceC0052f f78c;

    /* renamed from: d */
    private final DrawerLayout f79d;

    /* renamed from: e */
    private boolean f80e = true;

    /* renamed from: f */
    private Drawable f81f;

    /* renamed from: g */
    private Drawable f82g;

    /* renamed from: h */
    private C0054h f83h;

    /* renamed from: i */
    private final int f84i;

    /* renamed from: j */
    private final int f85j;

    /* renamed from: k */
    private final int f86k;

    /* renamed from: l */
    private Object f87l;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f76a = new C0051e();
        } else {
            f76a = new C0050d();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0014a(Activity activity, DrawerLayout drawerLayout, int i, int i2, int i3) {
        C0041b c0041b = null;
        this.f77b = activity;
        if (activity instanceof InterfaceC0053g) {
            this.f78c = ((InterfaceC0053g) activity).m159a();
        } else {
            this.f78c = null;
        }
        this.f79d = drawerLayout;
        this.f84i = i;
        this.f85j = i2;
        this.f86k = i3;
        this.f81f = m65a();
        this.f82g = activity.getResources().getDrawable(i);
        this.f83h = new C0054h(this, this.f82g);
        this.f83h.m162b(0.33333334f);
    }

    @Override // android.support.v4.widget.InterfaceC0250j
    /* renamed from: a */
    public void mo68a(View view, float f) {
        float fMin;
        float fM160a = this.f83h.m160a();
        if (f > 0.5f) {
            fMin = Math.max(fM160a, Math.max(0.0f, f - 0.5f) * 2.0f);
        } else {
            fMin = Math.min(fM160a, f * 2.0f);
        }
        this.f83h.m161a(fMin);
    }

    @Override // android.support.v4.widget.InterfaceC0250j
    /* renamed from: a */
    public void mo67a(View view) {
        this.f83h.m161a(1.0f);
        if (this.f80e) {
            m69b(this.f86k);
        }
    }

    @Override // android.support.v4.widget.InterfaceC0250j
    /* renamed from: b */
    public void mo70b(View view) {
        this.f83h.m161a(0.0f);
        if (this.f80e) {
            m69b(this.f85j);
        }
    }

    @Override // android.support.v4.widget.InterfaceC0250j
    /* renamed from: a */
    public void mo66a(int i) {
    }

    /* renamed from: a */
    Drawable m65a() {
        return this.f78c != null ? this.f78c.m157a() : f76a.mo155a(this.f77b);
    }

    /* renamed from: b */
    void m69b(int i) {
        if (this.f78c != null) {
            this.f78c.m158a(i);
        } else {
            this.f87l = f76a.mo156a(this.f87l, this.f77b, i);
        }
    }
}
