package com.sec.common.p055a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.sec.common.p056b.C1825d;
import com.sec.common.p056b.p060d.C1828c;
import java.io.File;
import java.io.IOException;

/* compiled from: Graphics.java */
/* renamed from: com.sec.common.a.a */
/* loaded from: classes.dex */
public class C1811a {

    /* renamed from: a */
    private static final String f6503a = C1811a.class.getSimpleName();

    /* renamed from: a */
    public static Bitmap m6144a(Context context, File file, int i, int i2) throws IOException {
        try {
            String canonicalPath = file.getCanonicalPath();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = 1;
            BitmapFactory.decodeFile(canonicalPath, options);
            int i3 = options.outWidth >> 1;
            for (int i4 = options.outHeight >> 1; i3 > i && i4 > i2; i4 >>= 1) {
                options.inSampleSize <<= 1;
                i3 >>= 1;
            }
            if (C1825d.f6539a.f6541b) {
                C1825d.f6539a.m6200a(f6503a, C1828c.m6207a("Sampling size: ", Integer.valueOf(options.inSampleSize)));
            }
            options.inJustDecodeBounds = false;
            options.inDither = true;
            options.inPurgeable = true;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(canonicalPath, options);
            if (C1825d.f6539a.f6541b) {
                C1825d.f6539a.m6200a(f6503a, C1828c.m6207a("Request(Width: ", Integer.valueOf(i), ", Height: ", Integer.valueOf(i2), "), Response(Width: ", Integer.valueOf(bitmapDecodeFile.getWidth()), ", Height: ", Integer.valueOf(bitmapDecodeFile.getHeight()), ")"));
                return bitmapDecodeFile;
            }
            return bitmapDecodeFile;
        } catch (IOException e) {
            if (C1825d.f6539a.f6544e) {
                C1825d.f6539a.m6201a(f6503a, e.getMessage(), e);
            }
            return null;
        }
    }

    /* renamed from: a */
    public static void m6145a(Drawable drawable) {
        Bitmap bitmap;
        int i = 0;
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            while (i < layerDrawable.getNumberOfLayers()) {
                m6145a(layerDrawable.getDrawable(i));
                i++;
            }
        } else if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            animationDrawable.stop();
            while (i < animationDrawable.getNumberOfFrames()) {
                m6145a(animationDrawable.getFrame(i));
                i++;
            }
        } else if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            bitmap.recycle();
        }
        drawable.setCallback(null);
    }
}
