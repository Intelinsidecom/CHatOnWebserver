package com.samsung.vip.engine;

import android.util.Log;
import java.util.HashMap;
import java.util.LinkedList;

/* loaded from: classes.dex */
public abstract class VITextRecognitionLib {
    private static final String[] ENABLE_LANG_SET = {"eng", "kor", "chn"};
    private static final int[] ENABLE_LANG_SET_ID = {3, 1, 0};
    public static final String LIBNAME = "VIText";
    private static final String TAG = "VITextRecognitionLib";
    public static final String VERSION = "0.7.3";
    public static final int VIHW_ENGINE_RAM_SIZE = 43008;
    public static final int VIHW_LANG_CHINESE = 0;
    public static final int VIHW_LANG_CHINESE_CURSIVE_ENG = 26;
    public static final int VIHW_LANG_CHINESE_ENGLISH = 24;
    public static final int VIHW_LANG_CHINESE_HK = 28;
    public static final int VIHW_LANG_CHINESE_T = 27;
    public static final int VIHW_LANG_CHINESE_TW = 29;
    public static final int VIHW_LANG_CURSIVE_ENGLISH = 10;
    public static final int VIHW_LANG_CURSIVE_ENG_FRE = 17;
    public static final int VIHW_LANG_CURSIVE_ENG_GER = 18;
    public static final int VIHW_LANG_CURSIVE_ENG_ITA = 19;
    public static final int VIHW_LANG_CURSIVE_ENG_POR = 20;
    public static final int VIHW_LANG_CURSIVE_ENG_RUS = 22;
    public static final int VIHW_LANG_CURSIVE_ENG_SPA = 21;
    public static final int VIHW_LANG_CURSIVE_FRENCH = 11;
    public static final int VIHW_LANG_CURSIVE_GERMAN = 12;
    public static final int VIHW_LANG_CURSIVE_ITALIAN = 13;
    public static final int VIHW_LANG_CURSIVE_PORTUGUESE = 14;
    public static final int VIHW_LANG_CURSIVE_RUSSIAN = 16;
    public static final int VIHW_LANG_CURSIVE_SPANISH = 15;
    public static final int VIHW_LANG_ENGLISH = 3;
    public static final int VIHW_LANG_FRENCH = 4;
    public static final int VIHW_LANG_GERMAN = 5;
    public static final int VIHW_LANG_ITALIAN = 6;
    public static final int VIHW_LANG_JAPANESE = 2;
    public static final int VIHW_LANG_KOREAN = 1;
    public static final int VIHW_LANG_KOREAN_CURSIVE_ENG = 25;
    public static final int VIHW_LANG_KOREAN_ENGLISH = 23;
    public static final int VIHW_LANG_PORTUGUESE = 7;
    public static final int VIHW_LANG_RUSSIAN = 9;
    public static final int VIHW_LANG_SPANISH = 8;
    public static final int VIHW_MAX_CANDIDATE_NUM = 18;
    public static final int VIHW_MAX_POINT_DATA_NUM = 8000;
    public static final int VIHW_MAX_POINT_NUM = 4000;
    public static final int VIHW_MAX_RECT_HEIGHT = 800;
    public static final int VIHW_MAX_RECT_WIDTH = 800;
    public static final int VIHW_MAX_STRING_LEN = 365;
    public static final int VIHW_RECOG_TYPE_CHAR = 0;
    public static final int VIHW_RECOG_TYPE_MULTI_LINE = 3;
    public static final int VIHW_RECOG_TYPE_SINGLE_LINE = 2;
    public static final int VIHW_RECOG_TYPE_STRING = 1;
    private HashMap<String, Integer> mLangMap;
    private LinkedList<float[]> mXstrokeList;
    private LinkedList<float[]> mYstrokeList;
    private boolean mbAddStrokeDirectly = true;

    protected abstract void VIText_AddStroke(float[] fArr, float[] fArr2);

    protected abstract void VIText_Close();

    protected abstract String VIText_GetResult();

    protected abstract int VIText_Init(String str, int i, int i2, int i3, short s);

    protected abstract int VIText_Recog(int i);

    protected abstract int VIText_Recog(int i, int[] iArr, int i2);

    public VITextRecognitionLib() {
        this.mLangMap = null;
        this.mXstrokeList = null;
        this.mYstrokeList = null;
        this.mXstrokeList = new LinkedList<>();
        this.mYstrokeList = new LinkedList<>();
        this.mLangMap = new HashMap<>();
        for (int i = 0; i < ENABLE_LANG_SET.length; i++) {
            this.mLangMap.put(ENABLE_LANG_SET[i], Integer.valueOf(ENABLE_LANG_SET_ID[i]));
        }
    }

    public void loadLibrary(String pathName) {
        System.load(pathName);
    }

    public int init(String szDataPath, int nLangMode, short sRangeMode) {
        return VIText_Init(szDataPath, nLangMode, 1600, 1200, sRangeMode);
    }

    public void close() {
        VIText_Close();
    }

    public String[] recog() {
        return recog(this.mbAddStrokeDirectly);
    }

    private String[] recog(boolean bAddStrokeDirectly) {
        int ret;
        if (bAddStrokeDirectly) {
            ret = VIText_Recog(3);
        } else {
            int nStrokeSize = this.mXstrokeList.size();
            int nTotalPointSize = 0;
            for (int i = 0; i < nStrokeSize; i++) {
                nTotalPointSize += this.mXstrokeList.get(i).length + 1;
            }
            int nTotalPointSize2 = nTotalPointSize + 1;
            int[] pPointData = new int[nTotalPointSize2 * 2];
            int nPointIndex = 0;
            for (int i2 = 0; i2 < nStrokeSize; i2++) {
                int nPointSize = this.mXstrokeList.get(i2).length;
                for (int j = 0; j < nPointSize; j++) {
                    int nPointIndex2 = nPointIndex + 1;
                    pPointData[nPointIndex] = (int) this.mXstrokeList.get(i2)[j];
                    nPointIndex = nPointIndex2 + 1;
                    pPointData[nPointIndex2] = (int) this.mYstrokeList.get(i2)[j];
                }
                int nPointIndex3 = nPointIndex + 1;
                pPointData[nPointIndex] = 65535;
                nPointIndex = nPointIndex3 + 1;
                pPointData[nPointIndex3] = 0;
            }
            int nPointIndex4 = nPointIndex + 1;
            pPointData[nPointIndex] = 65535;
            int i3 = nPointIndex4 + 1;
            pPointData[nPointIndex4] = 65535;
            this.mXstrokeList.clear();
            this.mYstrokeList.clear();
            ret = VIText_Recog(3, pPointData, nTotalPointSize2);
        }
        if (ret != 0) {
            Log.e(TAG, "Error Code: " + ret);
            return null;
        }
        String result = VIText_GetResult();
        if (result == null) {
            Log.e(TAG, "GetResult() return null!");
            return null;
        }
        return getRecogResultCandidate(result);
    }

    public String[] recog(int[] pPointData, int nPointNumber) {
        int ret = VIText_Recog(3, pPointData, nPointNumber);
        if (ret != 0) {
            Log.e(TAG, "Error Code: " + ret);
            return null;
        }
        String result = VIText_GetResult();
        if (result == null) {
            Log.e(TAG, "GetResult() return null!");
            return null;
        }
        return getRecogResultCandidate(result);
    }

    public void addStroke(float[] x, float[] y) {
        addStroke(x, y, this.mbAddStrokeDirectly);
    }

    private void addStroke(float[] x, float[] y, boolean bAddStrokeDirectly) {
        if (bAddStrokeDirectly) {
            VIText_AddStroke(x, y);
        } else {
            this.mXstrokeList.add(x);
            this.mYstrokeList.add(y);
        }
    }

    public void setAddStrokeDirectly(boolean bAddStrokeDirectly) {
        this.mbAddStrokeDirectly = bAddStrokeDirectly;
    }

    public String[] getLangList() {
        return ENABLE_LANG_SET;
    }

    public int getLanguageMode(String lang) {
        Integer langMode;
        if (this.mLangMap.containsKey(lang) && (langMode = this.mLangMap.get(lang)) != null) {
            return langMode.intValue();
        }
        return -1;
    }

    public boolean isSupportedLanguage(String lang) {
        if (this.mLangMap == null) {
            return false;
        }
        return this.mLangMap.containsKey(lang);
    }

    private String[] getRecogResultCandidate(String rawRet) {
        int nLen = rawRet.length();
        int nCandNum = 0;
        for (int ii = 0; ii < nLen; ii++) {
            if (rawRet.charAt(ii) == 65535) {
                nCandNum++;
            }
        }
        if (nCandNum == 0) {
            return null;
        }
        String[] arr = new String[nCandNum];
        int startId = 0;
        int jj = 0;
        for (int ii2 = 0; ii2 < nLen; ii2++) {
            if (rawRet.charAt(ii2) == 65535) {
                arr[jj] = rawRet.substring(startId, ii2);
                jj++;
                startId = ii2 + 1;
            }
        }
        return arr;
    }
}
