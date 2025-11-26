package com.sec.common.p131f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.sec.common.C4996f;
import java.io.File;

/* compiled from: AdjustCommand.java */
/* renamed from: com.sec.common.f.a */
/* loaded from: classes.dex */
public class C4997a {

    /* renamed from: a */
    private static final String f18230a = C4997a.class.getSimpleName();

    /* renamed from: b */
    private File f18231b;

    /* renamed from: a */
    void m18965a(File file) {
        this.f18231b = file;
    }

    /* renamed from: a */
    public Bitmap m18964a(Bitmap bitmap) {
        Boolean boolValueOf;
        if (this.f18231b == null) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f18230a, "The file is null. skip adjust command.");
                return bitmap;
            }
            return bitmap;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPurgeable = true;
        String attribute = new ExifInterface(this.f18231b.getCanonicalPath()).getAttribute("Orientation");
        Matrix matrix = new Matrix();
        Boolean.valueOf(false);
        if ("6".equals(attribute)) {
            boolValueOf = Boolean.valueOf(matrix.postRotate(90.0f));
        } else if ("3".equals(attribute)) {
            boolValueOf = Boolean.valueOf(matrix.postRotate(180.0f));
        } else if ("8".equals(attribute)) {
            boolValueOf = Boolean.valueOf(matrix.postRotate(270.0f));
        } else {
            boolValueOf = false;
        }
        if (boolValueOf.booleanValue()) {
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
