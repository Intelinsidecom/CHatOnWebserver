package android.support.v4.app;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Build;
import android.support.v4.p005a.p006a.C0008a;
import android.support.v4.view.C0159at;

/* compiled from: ActionBarDrawerToggle.java */
/* renamed from: android.support.v4.app.h */
/* loaded from: classes.dex */
class C0054h extends LevelListDrawable implements Drawable.Callback {

    /* renamed from: a */
    final /* synthetic */ C0014a f161a;

    /* renamed from: b */
    private final boolean f162b;

    /* renamed from: c */
    private final Rect f163c;

    /* renamed from: d */
    private float f164d;

    /* renamed from: e */
    private float f165e;

    private C0054h(C0014a c0014a, Drawable drawable) {
        this.f161a = c0014a;
        this.f162b = Build.VERSION.SDK_INT > 18;
        this.f163c = new Rect();
        if (C0008a.m26a(drawable)) {
            C0008a.m25a(this, true);
        }
        addLevel(0, 0, drawable);
    }

    /* renamed from: a */
    public void m161a(float f) {
        this.f164d = f;
        invalidateSelf();
    }

    /* renamed from: a */
    public float m160a() {
        return this.f164d;
    }

    /* renamed from: b */
    public void m162b(float f) {
        this.f165e = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        copyBounds(this.f163c);
        canvas.save();
        boolean z = C0159at.m642e(this.f161a.f77b.getWindow().getDecorView()) == 1;
        int i = z ? -1 : 1;
        int iWidth = this.f163c.width();
        canvas.translate(i * (-this.f165e) * iWidth * this.f164d, 0.0f);
        if (z && !this.f162b) {
            canvas.translate(iWidth, 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        super.draw(canvas);
        canvas.restore();
    }
}
