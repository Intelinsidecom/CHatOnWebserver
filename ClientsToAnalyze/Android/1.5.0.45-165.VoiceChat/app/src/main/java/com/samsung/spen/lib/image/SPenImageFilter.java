package com.samsung.spen.lib.image;

import android.graphics.Bitmap;
import com.samsung.samm.lib.engine.image.C0912a;

/* loaded from: classes.dex */
public class SPenImageFilter {
    public static boolean filterImage(Bitmap bitmap, int i, int i2) {
        return C0912a.m667a(bitmap, i, i2);
    }

    public static Bitmap filterImageCopy(Bitmap bitmap, int i, int i2) {
        return C0912a.m669b(bitmap, i, i2);
    }

    public static boolean setImageTransparency(Bitmap bitmap, int i) {
        return C0912a.m666a(bitmap, i);
    }
}
