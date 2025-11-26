package com.samsung.vip.engine;

/* loaded from: classes.dex */
public class VIRecogMode {
    private static final int[][] LANG_LIST_ID = {new int[2], new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 10}, new int[]{4, 11}, new int[]{5, 12}, new int[]{6, 13}, new int[]{7, 14}, new int[]{8, 15}, new int[]{9, 16}, new int[]{17, 17}, new int[]{18, 18}, new int[]{19, 19}, new int[]{20, 20}, new int[]{21, 21}, new int[]{22, 22}, new int[]{23, 25}, new int[]{24, 26}, new int[]{28, 28}, new int[]{29, 29}};

    public static short getRangeMode(boolean bNumeric, boolean bGesture, boolean bExtendSymbol) {
        short sRet = 0;
        if (bNumeric) {
            sRet = 1;
        }
        if (bGesture) {
            sRet = (short) (sRet + 2);
        }
        if (bExtendSymbol) {
            return (short) (sRet + 4);
        }
        return sRet;
    }

    public static int getLanguageMode(int lang, boolean bFreeStyle) {
        for (int i = 0; i < LANG_LIST_ID.length; i++) {
            if (lang == LANG_LIST_ID[i][0]) {
                int nLang = LANG_LIST_ID[i][bFreeStyle ? (char) 1 : (char) 0];
                return nLang;
            }
        }
        return lang;
    }
}
