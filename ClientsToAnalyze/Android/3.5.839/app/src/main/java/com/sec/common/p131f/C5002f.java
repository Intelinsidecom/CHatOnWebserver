package com.sec.common.p131f;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* compiled from: RotateCommand.java */
/* renamed from: com.sec.common.f.f */
/* loaded from: classes.dex */
public class C5002f {

    /* renamed from: a */
    private int f18254a;

    /* renamed from: a */
    public Bitmap m18986a(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        if (matrix.postRotate(this.f18254a)) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == bitmapCreateBitmap) {
                return bitmapCreateBitmap;
            }
            bitmap.recycle();
            return bitmapCreateBitmap;
        }
        return bitmap;
    }
}
