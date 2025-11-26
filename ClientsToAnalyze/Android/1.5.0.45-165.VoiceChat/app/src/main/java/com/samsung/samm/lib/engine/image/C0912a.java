package com.samsung.samm.lib.engine.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import com.infraware.office.evengine.InterfaceC0507E;
import com.samsung.spen.lib.image.SPenImageFilterConstants;
import com.sds.coolots.common.controller.EngineCallBackInterface;

/* renamed from: com.samsung.samm.lib.engine.image.a */
/* loaded from: classes.dex */
public class C0912a {
    /* renamed from: a */
    public static boolean m666a(Bitmap bitmap, int i) {
        if (bitmap == null) {
            Log.e("ImageEffectEngine", "Input Bitmap for Alpha Converting Operation is null");
            return false;
        }
        if (i < 0 || i > 255) {
            Log.e("ImageEffectEngine", "Input alpha Level is OutofRange");
            return false;
        }
        if (i == 0) {
            return true;
        }
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAlpha(i);
        canvas.drawPaint(paint);
        return true;
    }

    /* renamed from: a */
    public static boolean m667a(Bitmap bitmap, int i, int i2) {
        return m670c(bitmap, i, i2);
    }

    /* renamed from: b */
    public static Bitmap m669b(Bitmap bitmap, int i, int i2) {
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        if (!m670c(bitmapCopy, i, i2)) {
            return null;
        }
        return bitmapCopy;
    }

    /* renamed from: c */
    static boolean m670c(Bitmap bitmap, int i, int i2) {
        char[] charArray;
        int iM663a;
        String strM664a = m664a();
        if (strM664a == null || (charArray = strM664a.toCharArray()) == null) {
            return false;
        }
        ImageEffectEngineJNI.setCheckSupportingModel(charArray, charArray.length);
        if ((i < 10 && (i = m668b(i)) == -1) || (iM663a = m663a(i, i2)) < 0) {
            return false;
        }
        if (i != 10) {
            if (bitmap == null) {
                Log.e("ImageEffectEngine", "Input Bitmap is null");
                return false;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            int[] iArr2 = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            switch (i) {
                case 11:
                    ImageEffectEngineJNI.applyGray(iArr, iArr2, width, height, iM663a);
                    break;
                case 12:
                    ImageEffectEngineJNI.applySepia(iArr, iArr2, width, height, iM663a);
                    break;
                case 13:
                    ImageEffectEngineJNI.applyNegative(iArr, iArr2, width, height, iM663a);
                    break;
                case 14:
                    ImageEffectEngineJNI.applyBright(iArr, iArr2, width, height, iM663a);
                    break;
                case 15:
                    ImageEffectEngineJNI.applyDark(iArr, iArr2, width, height, iM663a);
                    break;
                case 40:
                    ImageEffectEngineJNI.applyVintage(iArr, iArr2, width, height, iM663a);
                    break;
                case 41:
                    ImageEffectEngineJNI.applyOldPhoto(iArr, iArr2, width, height, iM663a);
                    break;
                case 42:
                    ImageEffectEngineJNI.applyFadedColor(iArr, iArr2, width, height, iM663a);
                    break;
                case 43:
                    ImageEffectEngineJNI.applyVignette(iArr, iArr2, width, height, iM663a);
                    break;
                case 44:
                    ImageEffectEngineJNI.applyVivid(iArr, iArr2, width, height, iM663a);
                    break;
                case 45:
                    ImageEffectEngineJNI.applyColorize(iArr, iArr2, width, height, iM663a);
                    break;
                case 46:
                    ImageEffectEngineJNI.applyBlur(iArr, iArr2, width, height, iM663a);
                    break;
                case 70:
                    ImageEffectEngineJNI.applyPencilSketch(iArr, iArr2, width, height, iM663a);
                    break;
                case 71:
                    ImageEffectEngineJNI.applyFusain(iArr, iArr2, width, height, iM663a);
                    break;
                case 72:
                    ImageEffectEngineJNI.applyPenSketch(iArr, iArr2, width, height, iM663a);
                    break;
                case SPenImageFilterConstants.FILTER_PASTELSKETCH /* 73 */:
                    ImageEffectEngineJNI.applyPastelSketch(iArr, iArr2, width, height, iM663a);
                    break;
                case SPenImageFilterConstants.FILTER_COLORSKETCH /* 74 */:
                    ImageEffectEngineJNI.applyColorSketch(iArr, iArr2, width, height, iM663a);
                    break;
                case SPenImageFilterConstants.FILTER_PENCILPASTELSKETCH /* 75 */:
                    ImageEffectEngineJNI.applyPencilPastelSketch(iArr, iArr2, width, height, iM663a);
                    break;
                case SPenImageFilterConstants.FILTER_PENCILCOLORSKETCH /* 76 */:
                    ImageEffectEngineJNI.applyPencilColorSketch(iArr, iArr2, width, height, iM663a);
                    break;
                case 100:
                    ImageEffectEngineJNI.applyRetro(iArr, iArr2, width, height, iM663a);
                    break;
                case 101:
                    ImageEffectEngineJNI.applySunshine(iArr, iArr2, width, height, iM663a);
                    break;
                case 102:
                    ImageEffectEngineJNI.applyDownlight(iArr, iArr2, width, height, iM663a);
                    break;
                case 103:
                    ImageEffectEngineJNI.applyBluewash(iArr, iArr2, width, height, iM663a);
                    break;
                case 104:
                    ImageEffectEngineJNI.applyNostalgia(iArr, iArr2, width, height, iM663a);
                    break;
                case 105:
                    ImageEffectEngineJNI.applyYellowglow(iArr, iArr2, width, height, iM663a);
                    break;
                case 106:
                    ImageEffectEngineJNI.applySoftglow(iArr, iArr2, width, height, iM663a);
                    break;
                case SPenImageFilterConstants.FILTER_MOSAIC /* 130 */:
                    ImageEffectEngineJNI.applyMosaic(iArr, iArr2, width, height, iM663a);
                    break;
                case SPenImageFilterConstants.FILTER_POPART /* 131 */:
                    ImageEffectEngineJNI.applyPopArt(iArr, iArr2, width, height, iM663a);
                    break;
                case SPenImageFilterConstants.FILTER_MAGICPEN /* 132 */:
                    ImageEffectEngineJNI.applyMagicPen(iArr, iArr2, width, height, iM663a);
                    break;
                case SPenImageFilterConstants.FILTER_OILPAINT /* 133 */:
                    ImageEffectEngineJNI.applyOilpaint(iArr, iArr2, width, height, iM663a);
                    break;
                case SPenImageFilterConstants.FILTER_POSTERIZE /* 134 */:
                    ImageEffectEngineJNI.applyPosterize(iArr, iArr2, width, height, iM663a);
                    break;
                case SPenImageFilterConstants.FILTER_CARTOONIZE /* 135 */:
                    ImageEffectEngineJNI.applyCartoonize(iArr, iArr2, width, height, iM663a);
                    break;
                case SPenImageFilterConstants.FILTER_CLASSIC /* 136 */:
                    ImageEffectEngineJNI.applyClassic(iArr, iArr2, width, height, iM663a);
                    break;
                default:
                    return false;
            }
            bitmap.setPixels(iArr2, 0, width, 0, 0, width, height);
        }
        return true;
    }

    /* renamed from: a */
    static String m664a() {
        String str = Build.MODEL;
        if (Build.MODEL.compareToIgnoreCase("google_sdk") == 0 || Build.MODEL.compareToIgnoreCase("sdk") == 0) {
            return "SAMSUNG_SAMMFORMAT";
        }
        String str2 = Build.BRAND;
        String str3 = Build.MANUFACTURER;
        if (str2 == null || str3 == null) {
            Log.e("ImageEffectEngine", "Unknown Brand/Manufacturer Device");
            return null;
        }
        String str4 = Build.DEVICE;
        if (str2.compareToIgnoreCase("Samsung") != 0 && str3.compareToIgnoreCase("Samsung") != 0) {
            Log.e("ImageEffectEngine", "Device(" + str4 + "), Model(" + str + "), Brand(" + str2 + "), Manufacturer(" + str3 + ") is not a Saumsung device.");
            return null;
        }
        return "SAMSUNG_SAMMFORMAT";
    }

    /* renamed from: a */
    static int m663a(int i, int i2) {
        if (!m665a(i)) {
            return -1;
        }
        switch (i) {
            case 12:
                switch (i2) {
                    case 0:
                        return 30;
                    case 1:
                        return 40;
                    case 2:
                        return 50;
                    case 3:
                        return 60;
                    case 4:
                        return 70;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Sepia Option");
                        return -1;
                }
            case 14:
                switch (i2) {
                    case 0:
                        return 20;
                    case 1:
                        return 40;
                    case 2:
                        return 60;
                    case 3:
                        return 80;
                    case 4:
                        return 100;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Bright Option");
                        return -1;
                }
            case 15:
                switch (i2) {
                    case 0:
                        return 20;
                    case 1:
                        return 40;
                    case 2:
                        return 60;
                    case 3:
                        return 80;
                    case 4:
                        return 100;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Dark Option");
                        return -1;
                }
            case 42:
                switch (i2) {
                    case 0:
                        return 20;
                    case 1:
                        return 40;
                    case 2:
                        return 60;
                    case 3:
                        return 80;
                    case 4:
                        return 95;
                    default:
                        Log.e("ImageEffectEngine", "Invalid FadedColor Option");
                        return -1;
                }
            case 44:
                switch (i2) {
                    case 0:
                        return 20;
                    case 1:
                        return 70;
                    case 2:
                        return SPenImageFilterConstants.FILTER_MOSAIC;
                    case 3:
                        return 160;
                    case 4:
                        return 190;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Vivid Option");
                        return -1;
                }
            case 45:
                switch (i2) {
                    case 0:
                        return 36;
                    case 1:
                        return 108;
                    case 2:
                        return EngineCallBackInterface.SIP_RINGTONE_NONE;
                    case 3:
                        return 250;
                    case 4:
                        return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_IMAGE_EFFECT_EVENT;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Colorize Option");
                        return -1;
                }
            case 46:
                switch (i2) {
                    case 0:
                        return 0;
                    case 1:
                        return 50;
                    case 2:
                        return 75;
                    case 3:
                        return 95;
                    case 4:
                        return 98;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Blurring Option");
                        return -1;
                }
            case 70:
                switch (i2) {
                    case 0:
                        return 10;
                    case 1:
                        return 30;
                    case 2:
                        return 50;
                    case 3:
                        return 70;
                    case 4:
                        return 90;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Sketch Option");
                        return -1;
                }
            case 72:
                switch (i2) {
                    case 0:
                        return 14;
                    case 1:
                        return 11;
                    case 2:
                        return 8;
                    case 3:
                        return 5;
                    case 4:
                        return 2;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Sketch Option");
                        return -1;
                }
            case SPenImageFilterConstants.FILTER_PASTELSKETCH /* 73 */:
                switch (i2) {
                    case 0:
                        return 14;
                    case 1:
                        return 11;
                    case 2:
                        return 8;
                    case 3:
                        return 5;
                    case 4:
                        return 2;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Sketch Option");
                        return -1;
                }
            case SPenImageFilterConstants.FILTER_COLORSKETCH /* 74 */:
                switch (i2) {
                    case 0:
                        return 14;
                    case 1:
                        return 11;
                    case 2:
                        return 8;
                    case 3:
                        return 5;
                    case 4:
                        return 2;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Sketch Option");
                        return -1;
                }
            case SPenImageFilterConstants.FILTER_PENCILPASTELSKETCH /* 75 */:
                switch (i2) {
                    case 0:
                        return 10;
                    case 1:
                        return 30;
                    case 2:
                        return 50;
                    case 3:
                        return 70;
                    case 4:
                        return 90;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Sketch Option");
                        return -1;
                }
            case SPenImageFilterConstants.FILTER_PENCILCOLORSKETCH /* 76 */:
                switch (i2) {
                    case 0:
                        return 10;
                    case 1:
                        return 30;
                    case 2:
                        return 50;
                    case 3:
                        return 70;
                    case 4:
                        return 90;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Sketch Option");
                        return -1;
                }
            case 106:
                switch (i2) {
                    case 0:
                        return 10;
                    case 1:
                        return 30;
                    case 2:
                        return 50;
                    case 3:
                        return 70;
                    case 4:
                        return 90;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Soft glow Option");
                        return -1;
                }
            case SPenImageFilterConstants.FILTER_MOSAIC /* 130 */:
                switch (i2) {
                    case 0:
                        return 1;
                    case 1:
                        return 2;
                    case 2:
                        return 3;
                    case 3:
                        return 4;
                    case 4:
                        return 5;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Mosaic Option");
                        return -1;
                }
            case SPenImageFilterConstants.FILTER_POSTERIZE /* 134 */:
                switch (i2) {
                    case 0:
                        return 5;
                    case 1:
                        return 4;
                    case 2:
                        return 3;
                    case 3:
                        return 2;
                    case 4:
                        return 1;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Posterize Option");
                        return -1;
                }
            case SPenImageFilterConstants.FILTER_CARTOONIZE /* 135 */:
                switch (i2) {
                    case 0:
                        return 4;
                    case 1:
                        return 5;
                    case 2:
                        return 6;
                    case 3:
                        return 7;
                    case 4:
                        return 8;
                    default:
                        Log.e("ImageEffectEngine", "Invalid Cartoonize Option");
                        return -1;
                }
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public static boolean m665a(int i) {
        return i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 40 || i == 41 || i == 42 || i == 43 || i == 44 || i == 45 || i == 46 || i == 70 || i == 71 || i == 72 || i == 73 || i == 74 || i == 75 || i == 76 || i == 100 || i == 101 || i == 102 || i == 103 || i == 104 || i == 105 || i == 106 || i == 130 || i == 131 || i == 132 || i == 133 || i == 134 || i == 135 || i == 136;
    }

    /* renamed from: b */
    static int m668b(int i) {
        if (i == 0) {
            return 10;
        }
        if (i == 1) {
            return 46;
        }
        if (i == 2) {
            return SPenImageFilterConstants.FILTER_MOSAIC;
        }
        if (i == 3) {
            return 11;
        }
        if (i == 4) {
            return 12;
        }
        if (i == 5) {
            return 14;
        }
        if (i == 6) {
            return 15;
        }
        if (i == 7) {
            return 70;
        }
        return -1;
    }
}
