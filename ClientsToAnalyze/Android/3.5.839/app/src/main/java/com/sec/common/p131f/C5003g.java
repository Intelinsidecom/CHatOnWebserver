package com.sec.common.p131f;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: RoundCommand.java */
/* renamed from: com.sec.common.f.g */
/* loaded from: classes.dex */
public class C5003g {

    /* renamed from: a */
    private float f18255a;

    /* renamed from: b */
    private float f18256b;

    /* renamed from: a */
    public static C5003g m18987a(float f, float f2) {
        return new C5003g(f, f2);
    }

    private C5003g(float f, float f2) {
        this.f18255a = f;
        this.f18256b = f2;
    }

    /* renamed from: a */
    public Bitmap m18988a(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, this.f18255a, this.f18256b, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }
}
