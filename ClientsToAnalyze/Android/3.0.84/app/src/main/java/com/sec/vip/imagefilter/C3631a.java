package com.sec.vip.imagefilter;

import android.graphics.Bitmap;
import android.util.Log;
import com.sec.chaton.util.C3250y;

/* compiled from: ImageEffectEngine.java */
/* renamed from: com.sec.vip.imagefilter.a */
/* loaded from: classes.dex */
public class C3631a {
    /* renamed from: a */
    public static boolean m13027a(Bitmap bitmap, int i) {
        if (i < 2000 || i >= 2035) {
            return false;
        }
        try {
            switch (i) {
                case 2001:
                    m13032f(bitmap);
                    break;
                case 2002:
                    m13029c(bitmap);
                    break;
                case 2003:
                    m13030d(bitmap);
                    break;
                case 2004:
                    m13026a(bitmap);
                    break;
                case 2005:
                    m13028b(bitmap);
                    break;
                case 2006:
                case 2007:
                default:
                    return true;
                case 2008:
                    m13034h(bitmap);
                    break;
                case 2009:
                    m13031e(bitmap);
                    break;
                case 2010:
                    m13024F(bitmap);
                    break;
                case 2011:
                    m13035i(bitmap);
                    break;
                case 2012:
                    m13036j(bitmap);
                    break;
                case 2013:
                    m13037k(bitmap);
                    break;
                case 2014:
                    m13038l(bitmap);
                    break;
                case 2015:
                    m13039m(bitmap);
                    break;
                case 2016:
                    m13033g(bitmap);
                    break;
                case 2017:
                    m13040n(bitmap);
                    break;
                case 2018:
                    m13041o(bitmap);
                    break;
                case 2019:
                    m13042p(bitmap);
                    break;
                case 2020:
                    m13025G(bitmap);
                    break;
                case 2021:
                    m13044r(bitmap);
                    break;
                case 2022:
                    m13045s(bitmap);
                    break;
                case 2023:
                    m13046t(bitmap);
                    break;
                case 2024:
                    m13047u(bitmap);
                    break;
                case 2025:
                    m13048v(bitmap);
                    break;
                case 2026:
                    m13049w(bitmap);
                    break;
                case 2027:
                    m13050x(bitmap);
                    break;
                case 2028:
                    m13051y(bitmap);
                    break;
                case 2029:
                    m13052z(bitmap);
                    break;
                case 2030:
                    m13019A(bitmap);
                    break;
                case 2031:
                    m13020B(bitmap);
                    break;
                case 2032:
                    m13021C(bitmap);
                    break;
                case 2033:
                    m13022D(bitmap);
                    break;
                case 2034:
                    m13023E(bitmap);
                    break;
            }
            return true;
        } catch (OutOfMemoryError e) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m13026a(Bitmap bitmap) {
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
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyGray, "ImageEffectEngine");
        }
        return iApplyGray == 0;
    }

    /* renamed from: b */
    public static boolean m13028b(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyNegative = ImageEffectEngineJNI.applyNegative(iArr, iArr2, width, height, 0);
        if (iApplyNegative == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyNegative, "ImageEffectEngine");
        }
        return iApplyNegative == 0;
    }

    /* renamed from: c */
    public static boolean m13029c(Bitmap bitmap) {
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
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyBright, "ImageEffectEngine");
        }
        return iApplyBright == 0;
    }

    /* renamed from: d */
    public static boolean m13030d(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyDark = ImageEffectEngineJNI.applyDark(iArr, iArr2, width, height, 60);
        if (iApplyDark == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyDark, "ImageEffectEngine");
        }
        return iApplyDark == 0;
    }

    /* renamed from: e */
    public static boolean m13031e(Bitmap bitmap) {
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
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplySepia, "ImageEffectEngine");
        }
        return iApplySepia == 0;
    }

    /* renamed from: f */
    public static boolean m13032f(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyBlur = ImageEffectEngineJNI.applyBlur(iArr, iArr2, width, height, 25);
        if (iApplyBlur == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyBlur, "ImageEffectEngine");
        }
        return iApplyBlur == 0;
    }

    /* renamed from: g */
    public static boolean m13033g(Bitmap bitmap) {
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
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyFadedColor, "ImageEffectEngine");
        }
        return iApplyFadedColor == 0;
    }

    /* renamed from: h */
    public static boolean m13034h(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyPencilSketch = ImageEffectEngineJNI.applyPencilSketch(iArr, iArr2, width, height, 60);
        if (iApplyPencilSketch == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyPencilSketch, "ImageEffectEngine");
        }
        return iApplyPencilSketch == 0;
    }

    /* renamed from: i */
    public static boolean m13035i(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyPenSketch = ImageEffectEngineJNI.applyPenSketch(iArr, iArr2, width, height, 5);
        if (iApplyPenSketch == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyPenSketch, "ImageEffectEngine");
        }
        return iApplyPenSketch == 0;
    }

    /* renamed from: j */
    public static boolean m13036j(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyPastelSketch = ImageEffectEngineJNI.applyPastelSketch(iArr, iArr2, width, height, 5);
        if (iApplyPastelSketch == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyPastelSketch, "ImageEffectEngine");
        }
        return iApplyPastelSketch == 0;
    }

    /* renamed from: k */
    public static boolean m13037k(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyColorSketch = ImageEffectEngineJNI.applyColorSketch(iArr, iArr2, width, height, 5);
        if (iApplyColorSketch == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyColorSketch, "ImageEffectEngine");
        }
        return iApplyColorSketch == 0;
    }

    /* renamed from: l */
    public static boolean m13038l(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyPencilPastelSketch = ImageEffectEngineJNI.applyPencilPastelSketch(iArr, iArr2, width, height, 60);
        if (iApplyPencilPastelSketch == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyPencilPastelSketch, "ImageEffectEngine");
        }
        return iApplyPencilPastelSketch == 0;
    }

    /* renamed from: m */
    public static boolean m13039m(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyPencilColorSketch = ImageEffectEngineJNI.applyPencilColorSketch(iArr, iArr2, width, height, 60);
        if (iApplyPencilColorSketch == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyPencilColorSketch, "ImageEffectEngine");
        }
        return iApplyPencilColorSketch == 0;
    }

    /* renamed from: n */
    public static boolean m13040n(Bitmap bitmap) {
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
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyVivid, "ImageEffectEngine");
        }
        return iApplyVivid == 0;
    }

    /* renamed from: o */
    public static boolean m13041o(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyColorize = ImageEffectEngineJNI.applyColorize(iArr, iArr2, width, height, 254);
        if (iApplyColorize == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyColorize, "ImageEffectEngine");
        }
        return iApplyColorize == 0;
    }

    /* renamed from: p */
    public static boolean m13042p(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyCartoonize = ImageEffectEngineJNI.applyCartoonize(iArr, iArr2, width, height, 6);
        if (iApplyCartoonize == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyCartoonize, "ImageEffectEngine");
        }
        return iApplyCartoonize == 0;
    }

    /* renamed from: q */
    public static boolean m13043q(Bitmap bitmap) {
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
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyVignette, "ImageEffectEngine");
        }
        return iApplyVignette == 0;
    }

    /* renamed from: r */
    public static boolean m13044r(Bitmap bitmap) {
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
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyVintage, "ImageEffectEngine");
        }
        return iApplyVintage == 0;
    }

    /* renamed from: s */
    public static boolean m13045s(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyOldPhoto = ImageEffectEngineJNI.applyOldPhoto(iArr, iArr2, width, height, 0);
        if (iApplyOldPhoto == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyOldPhoto, "ImageEffectEngine");
        }
        return iApplyOldPhoto == 0;
    }

    /* renamed from: t */
    public static boolean m13046t(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyPopArt = ImageEffectEngineJNI.applyPopArt(iArr, iArr2, width, height, 0);
        if (iApplyPopArt == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyPopArt, "ImageEffectEngine");
        }
        return iApplyPopArt == 0;
    }

    /* renamed from: u */
    public static boolean m13047u(Bitmap bitmap) {
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
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyRetro, "ImageEffectEngine");
        }
        return iApplyRetro == 0;
    }

    /* renamed from: v */
    public static boolean m13048v(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplySunshine = ImageEffectEngineJNI.applySunshine(iArr, iArr2, width, height, 0);
        if (iApplySunshine == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplySunshine, "ImageEffectEngine");
        }
        return iApplySunshine == 0;
    }

    /* renamed from: w */
    public static boolean m13049w(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyDownlight = ImageEffectEngineJNI.applyDownlight(iArr, iArr2, width, height, 0);
        if (iApplyDownlight == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyDownlight, "ImageEffectEngine");
        }
        return iApplyDownlight == 0;
    }

    /* renamed from: x */
    public static boolean m13050x(Bitmap bitmap) {
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
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyBluewash, "ImageEffectEngine");
        }
        return iApplyBluewash == 0;
    }

    /* renamed from: y */
    public static boolean m13051y(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyNostalgia = ImageEffectEngineJNI.applyNostalgia(iArr, iArr2, width, height, 0);
        if (iApplyNostalgia == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyNostalgia, "ImageEffectEngine");
        }
        return iApplyNostalgia == 0;
    }

    /* renamed from: z */
    public static boolean m13052z(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyYellowglow = ImageEffectEngineJNI.applyYellowglow(iArr, iArr2, width, height, 0);
        if (iApplyYellowglow == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyYellowglow, "ImageEffectEngine");
        }
        return iApplyYellowglow == 0;
    }

    /* renamed from: A */
    public static boolean m13019A(Bitmap bitmap) {
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
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyClassic, "ImageEffectEngine");
        }
        return iApplyClassic == 0;
    }

    /* renamed from: B */
    public static boolean m13020B(Bitmap bitmap) {
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
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplySoftglow, "ImageEffectEngine");
        }
        return iApplySoftglow == 0;
    }

    /* renamed from: C */
    public static boolean m13021C(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyMagicPen = ImageEffectEngineJNI.applyMagicPen(iArr, iArr2, width, height, 0);
        if (iApplyMagicPen == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyMagicPen, "ImageEffectEngine");
        }
        return iApplyMagicPen == 0;
    }

    /* renamed from: D */
    public static boolean m13022D(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyOilpaint = ImageEffectEngineJNI.applyOilpaint(iArr, iArr2, width, height, 0);
        if (iApplyOilpaint == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyOilpaint, "ImageEffectEngine");
        }
        return iApplyOilpaint == 0;
    }

    /* renamed from: E */
    public static boolean m13023E(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return true;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyPosterize = ImageEffectEngineJNI.applyPosterize(iArr, iArr2, width, height, 3);
        if (iApplyPosterize == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyPosterize, "ImageEffectEngine");
        }
        return iApplyPosterize == 0;
    }

    /* renamed from: F */
    public static boolean m13024F(Bitmap bitmap) {
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
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyFusain, "ImageEffectEngine");
        }
        return iApplyFusain == 0;
    }

    /* renamed from: G */
    public static boolean m13025G(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap is null");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iApplyMosaic = ImageEffectEngineJNI.applyMosaic(iArr, iArr2, width, height, 3);
        if (iApplyMosaic == 0) {
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        } else {
            C3250y.m11442a("[ImageEffectEngine] error mesaage: " + iApplyMosaic, "ImageEffectEngine");
        }
        return iApplyMosaic == 0;
    }
}
