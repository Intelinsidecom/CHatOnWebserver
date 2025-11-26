package com.sec.vip.imagefilter;

import android.graphics.Bitmap;
import android.util.Log;
import com.sec.chaton.util.C4904y;

/* compiled from: ImageEffectEngine.java */
/* renamed from: com.sec.vip.imagefilter.a */
/* loaded from: classes.dex */
public class C5136a {
    /* renamed from: a */
    public static boolean m19601a(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyGray = ImageEffectEngineJNI.applyGray(iArr, iArr2, width, height, 0);
        if (iApplyGray == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C4904y.m18634a("[ImageEffectEngine] error mesaage: " + iApplyGray, "ImageEffectEngine");
        }
        return iApplyGray == 0;
    }

    /* renamed from: b */
    public static boolean m19602b(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyBright = ImageEffectEngineJNI.applyBright(iArr, iArr2, width, height, 60);
        if (iApplyBright == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C4904y.m18634a("[ImageEffectEngine] error mesaage: " + iApplyBright, "ImageEffectEngine");
        }
        return iApplyBright == 0;
    }

    /* renamed from: c */
    public static boolean m19603c(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplySepia = ImageEffectEngineJNI.applySepia(iArr, iArr2, width, height, 50);
        if (iApplySepia == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C4904y.m18634a("[ImageEffectEngine] error mesaage: " + iApplySepia, "ImageEffectEngine");
        }
        return iApplySepia == 0;
    }

    /* renamed from: d */
    public static boolean m19604d(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyFadedColor = ImageEffectEngineJNI.applyFadedColor(iArr, iArr2, width, height, 60);
        if (iApplyFadedColor == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C4904y.m18634a("[ImageEffectEngine] error mesaage: " + iApplyFadedColor, "ImageEffectEngine");
        }
        return iApplyFadedColor == 0;
    }

    /* renamed from: e */
    public static boolean m19605e(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyVivid = ImageEffectEngineJNI.applyVivid(iArr, iArr2, width, height, 130);
        if (iApplyVivid == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C4904y.m18634a("[ImageEffectEngine] error mesaage: " + iApplyVivid, "ImageEffectEngine");
        }
        return iApplyVivid == 0;
    }

    /* renamed from: f */
    public static boolean m19606f(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyVignette = ImageEffectEngineJNI.applyVignette(iArr, iArr2, width, height, 0);
        if (iApplyVignette == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C4904y.m18634a("[ImageEffectEngine] error mesaage: " + iApplyVignette, "ImageEffectEngine");
        }
        return iApplyVignette == 0;
    }

    /* renamed from: g */
    public static boolean m19607g(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyVintage = ImageEffectEngineJNI.applyVintage(iArr, iArr2, width, height, 0);
        if (iApplyVintage == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C4904y.m18634a("[ImageEffectEngine] error mesaage: " + iApplyVintage, "ImageEffectEngine");
        }
        return iApplyVintage == 0;
    }

    /* renamed from: h */
    public static boolean m19608h(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyRetro = ImageEffectEngineJNI.applyRetro(iArr, iArr2, width, height, 0);
        if (iApplyRetro == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C4904y.m18634a("[ImageEffectEngine] error mesaage: " + iApplyRetro, "ImageEffectEngine");
        }
        return iApplyRetro == 0;
    }

    /* renamed from: i */
    public static boolean m19609i(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyBluewash = ImageEffectEngineJNI.applyBluewash(iArr, iArr2, width, height, 0);
        if (iApplyBluewash == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C4904y.m18634a("[ImageEffectEngine] error mesaage: " + iApplyBluewash, "ImageEffectEngine");
        }
        return iApplyBluewash == 0;
    }

    /* renamed from: j */
    public static boolean m19610j(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return true;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyClassic = ImageEffectEngineJNI.applyClassic(iArr, iArr2, width, height, 0);
        if (iApplyClassic == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C4904y.m18634a("[ImageEffectEngine] error mesaage: " + iApplyClassic, "ImageEffectEngine");
        }
        return iApplyClassic == 0;
    }

    /* renamed from: k */
    public static boolean m19611k(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplySoftglow = ImageEffectEngineJNI.applySoftglow(iArr, iArr2, width, height, 50);
        if (iApplySoftglow == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C4904y.m18634a("[ImageEffectEngine] error mesaage: " + iApplySoftglow, "ImageEffectEngine");
        }
        return iApplySoftglow == 0;
    }

    /* renamed from: l */
    public static boolean m19612l(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyFusain = ImageEffectEngineJNI.applyFusain(iArr, iArr2, width, height, 0);
        if (iApplyFusain == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C4904y.m18634a("[ImageEffectEngine] error mesaage: " + iApplyFusain, "ImageEffectEngine");
        }
        return iApplyFusain == 0;
    }
}
