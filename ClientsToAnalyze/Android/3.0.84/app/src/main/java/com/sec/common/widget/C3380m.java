package com.sec.common.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/* compiled from: IcsColorDrawable.java */
/* renamed from: com.sec.common.widget.m */
/* loaded from: classes.dex */
public class C3380m extends Drawable {

    /* renamed from: a */
    private int f12251a;

    /* renamed from: b */
    private final Paint f12252b = new Paint();

    public C3380m(ColorDrawable colorDrawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        colorDrawable.draw(new Canvas(bitmapCreateBitmap));
        this.f12251a = bitmapCreateBitmap.getPixel(0, 0);
        bitmapCreateBitmap.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if ((this.f12251a >>> 24) != 0) {
            this.f12252b.setColor(this.f12251a);
            canvas.drawRect(getBounds(), this.f12252b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != (this.f12251a >>> 24)) {
            this.f12251a = (this.f12251a & 16777215) | (i << 24);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f12251a >>> 24;
    }
}
