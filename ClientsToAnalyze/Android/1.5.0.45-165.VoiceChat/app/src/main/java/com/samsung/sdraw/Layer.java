package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
class Layer {

    /* renamed from: g */
    public static final Matrix f1060g = new Matrix();

    /* renamed from: a */
    protected Canvas f1061a;

    /* renamed from: b */
    protected Bitmap f1062b;

    /* renamed from: h */
    private boolean f1067h = true;

    /* renamed from: c */
    public PointF f1063c = new PointF();

    /* renamed from: d */
    public float f1064d = 1.0f;

    /* renamed from: e */
    public Matrix f1065e = new Matrix();

    /* renamed from: f */
    public Matrix f1066f = new Matrix();

    public Layer(int width, int height) {
        m1016c();
        m1015b(width, height);
    }

    /* renamed from: a */
    public void m1007a() {
        if (this.f1062b != null) {
            this.f1062b.recycle();
        }
        this.f1062b = null;
        this.f1061a = null;
    }

    /* renamed from: a */
    public void m1012a(PointF pointF) {
        this.f1063c = new PointF(pointF);
        m1016c();
    }

    /* renamed from: a */
    public void m1008a(float f) {
        this.f1064d = f;
        m1016c();
    }

    /* renamed from: a */
    public void m1009a(int i, int i2) {
        if (this.f1062b != null) {
            this.f1062b.recycle();
        }
        this.f1062b = null;
        m1015b(i, i2);
    }

    /* renamed from: b */
    protected void m1015b(int i, int i2) {
        this.f1062b = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.f1062b.eraseColor(0);
        this.f1061a = new Canvas();
        this.f1061a.setBitmap(this.f1062b);
    }

    /* renamed from: b */
    public void m1014b() {
        m1011a(new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1062b.getWidth(), this.f1062b.getHeight()));
    }

    /* renamed from: a */
    public void m1011a(RectF rectF) {
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f1061a.drawRect(rectF, paint);
    }

    public void renderSprite(AbstractSprite sprite, RectF refreshRect) {
        if (sprite instanceof C0989ab) {
            if (!sprite.isVisible() || !m1017d()) {
                return;
            }
        } else if (!sprite.isVisible() || !m1017d() || !sprite.isHitted(refreshRect)) {
            return;
        }
        sprite.mo1139a(this.f1061a, refreshRect);
    }

    /* renamed from: c */
    protected void m1016c() {
        this.f1065e.setScale(this.f1064d, this.f1064d);
        this.f1065e.postTranslate(-this.f1063c.x, -this.f1063c.y);
        this.f1065e.invert(this.f1066f);
    }

    /* renamed from: a */
    public void m1010a(Matrix matrix) {
        this.f1065e.set(matrix);
        this.f1065e.invert(this.f1066f);
    }

    /* renamed from: a */
    public void m1013a(boolean z) {
        this.f1067h = z;
    }

    /* renamed from: d */
    public boolean m1017d() {
        return this.f1067h;
    }
}
