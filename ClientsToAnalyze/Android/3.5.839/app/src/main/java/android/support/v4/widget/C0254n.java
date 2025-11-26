package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;

/* compiled from: EdgeEffectCompat.java */
/* renamed from: android.support.v4.widget.n */
/* loaded from: classes.dex */
public class C0254n {

    /* renamed from: b */
    private static final InterfaceC0257q f596b;

    /* renamed from: a */
    private Object f597a;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f596b = new C0256p();
        } else {
            f596b = new C0255o();
        }
    }

    public C0254n(Context context) {
        this.f597a = f596b.mo897a(context);
    }

    /* renamed from: a */
    public void m891a(int i, int i2) {
        f596b.mo898a(this.f597a, i, i2);
    }

    /* renamed from: a */
    public boolean m892a() {
        return f596b.mo899a(this.f597a);
    }

    /* renamed from: b */
    public void m895b() {
        f596b.mo902b(this.f597a);
    }

    /* renamed from: a */
    public boolean m893a(float f) {
        return f596b.mo900a(this.f597a, f);
    }

    /* renamed from: c */
    public boolean m896c() {
        return f596b.mo903c(this.f597a);
    }

    /* renamed from: a */
    public boolean m894a(Canvas canvas) {
        return f596b.mo901a(this.f597a, canvas);
    }
}
