package com.sec.common.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/* compiled from: IcsColorDrawable.java */
/* renamed from: com.sec.common.widget.i */
/* loaded from: classes.dex */
public class C5064i extends Drawable {

    /* renamed from: a */
    private int f18497a;

    /* renamed from: b */
    private final Paint f18498b = new Paint();

    public C5064i(ColorDrawable colorDrawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        colorDrawable.draw(new Canvas(bitmapCreateBitmap));
        this.f18497a = bitmapCreateBitmap.getPixel(0, 0);
        bitmapCreateBitmap.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if ((this.f18497a >>> 24) != 0) {
            this.f18498b.setColor(this.f18497a);
            canvas.drawRect(getBounds(), this.f18498b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != (this.f18497a >>> 24)) {
            this.f18497a = (this.f18497a & 16777215) | (i << 24);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f18497a >>> 24;
    }
}
