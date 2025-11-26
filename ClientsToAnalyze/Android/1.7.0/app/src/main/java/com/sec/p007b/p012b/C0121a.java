package com.sec.p007b.p012b;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* compiled from: Graphics.java */
/* renamed from: com.sec.b.b.a */
/* loaded from: classes.dex */
public class C0121a {

    /* renamed from: a */
    private static final String f235a = C0121a.class.getSimpleName();

    /* renamed from: a */
    public static void m618a(Drawable drawable) {
        Bitmap bitmap;
        int i = 0;
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            while (i < layerDrawable.getNumberOfLayers()) {
                m618a(layerDrawable.getDrawable(i));
                i++;
            }
        } else if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            animationDrawable.stop();
            while (i < animationDrawable.getNumberOfFrames()) {
                m618a(animationDrawable.getFrame(i));
                i++;
            }
        } else if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            bitmap.recycle();
        }
        drawable.setCallback(null);
    }
}
