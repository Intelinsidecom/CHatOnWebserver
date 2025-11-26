package com.infraware.office.evengine;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class EvImageUtil {
    static EvImageUtil mEvImageUtil = null;

    protected EvImageUtil() {
    }

    static EvImageUtil getEvImageUtil() {
        if (mEvImageUtil == null) {
            mEvImageUtil = new EvImageUtil();
        }
        return mEvImageUtil;
    }

    Bitmap CreateBitmap(int w, int h) {
        try {
            return Bitmap.createBitmap(w, h, Bitmap.Config.RGB_565);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    Bitmap ScaleBitmap(Bitmap src, int dw, int dh) {
        try {
            return Bitmap.createScaledBitmap(src, dw, dh, true);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }
}
