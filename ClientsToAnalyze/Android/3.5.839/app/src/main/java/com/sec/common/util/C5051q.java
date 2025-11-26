package com.sec.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* compiled from: RoundedDrawable.java */
/* renamed from: com.sec.common.util.q */
/* loaded from: classes.dex */
public class C5051q extends Drawable {

    /* renamed from: a */
    private Bitmap f18392a;

    /* renamed from: d */
    private final int f18395d;

    /* renamed from: e */
    private final int f18396e;

    /* renamed from: f */
    private final int f18397f;

    /* renamed from: c */
    private final RectF f18394c = new RectF();

    /* renamed from: b */
    private final Paint f18393b = new Paint();

    public C5051q(Bitmap bitmap) {
        this.f18392a = bitmap;
        this.f18393b.setAntiAlias(true);
        this.f18393b.setDither(true);
        if (this.f18392a != null) {
            this.f18393b.setShader(new BitmapShader(this.f18392a, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.f18395d = this.f18392a.getWidth();
            this.f18396e = this.f18392a.getHeight();
            this.f18397f = Math.min(this.f18395d, this.f18396e);
            return;
        }
        this.f18395d = 0;
        this.f18396e = 0;
        this.f18397f = 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawOval(this.f18394c, this.f18393b);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        RectF rectF;
        super.onBoundsChange(rect);
        this.f18394c.set(rect);
        if (this.f18395d != this.f18396e) {
            RectF rectF2 = new RectF(0.0f, 0.0f, this.f18397f, this.f18397f);
            if (this.f18395d > this.f18396e) {
                int i = this.f18395d >> 2;
                rectF = new RectF(-i, 0.0f, this.f18397f - i, this.f18397f);
            } else {
                int i2 = this.f18396e >> 2;
                rectF = new RectF(0.0f, -i2, this.f18397f, this.f18397f - i2);
            }
            Matrix matrix = new Matrix();
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.FILL);
            this.f18393b.getShader().setLocalMatrix(matrix);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f18393b.getAlpha() != i) {
            this.f18393b.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f18393b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f18397f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f18397f;
    }

    /* renamed from: a */
    public void m19198a(boolean z) {
        this.f18393b.setAntiAlias(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f18393b.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f18393b.setDither(z);
        invalidateSelf();
    }
}
