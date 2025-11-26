package com.sec.common.p131f;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

/* compiled from: OverlapCommand.java */
/* renamed from: com.sec.common.f.b */
/* loaded from: classes.dex */
public class C4998b {

    /* renamed from: a */
    private int f18232a;

    /* renamed from: b */
    private int f18233b;

    /* renamed from: c */
    private Bitmap f18234c;

    /* renamed from: d */
    private int f18235d;

    public C4998b(int i, int i2, Bitmap bitmap, int i3) {
        this.f18232a = i;
        this.f18233b = i2;
        this.f18234c = bitmap;
        this.f18235d = i3;
    }

    /* renamed from: a */
    public Bitmap m18966a(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setDither(true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        if ((this.f18235d & 5) == 5) {
            this.f18232a += bitmap.getWidth() - this.f18234c.getWidth();
        } else if ((this.f18235d & 1) == 1) {
            this.f18232a += (bitmap.getWidth() / 2) - (this.f18234c.getWidth() / 2);
        }
        if ((this.f18235d & 80) == 80) {
            this.f18233b += bitmap.getHeight() - this.f18234c.getHeight();
        } else if ((this.f18235d & 16) == 16) {
            this.f18233b += (bitmap.getHeight() / 2) - (this.f18234c.getHeight() / 2);
        }
        Rect rect = new Rect(0, 0, this.f18234c.getWidth(), this.f18234c.getHeight());
        Rect rect2 = new Rect(this.f18232a, this.f18233b, this.f18234c.getWidth() + this.f18232a, this.f18234c.getHeight() + this.f18233b);
        canvas.drawBitmap(bitmap, new Matrix(), paint);
        canvas.drawBitmap(this.f18234c, rect, rect2, paint);
        this.f18234c.recycle();
        return bitmapCreateBitmap;
    }
}
