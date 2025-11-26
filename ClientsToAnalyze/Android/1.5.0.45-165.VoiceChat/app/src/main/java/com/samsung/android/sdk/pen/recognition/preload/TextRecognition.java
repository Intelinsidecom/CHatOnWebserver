package com.samsung.android.sdk.pen.recognition.preload;

import android.content.Context;
import android.util.Log;
import com.samsung.vip.engine.VIRecogMode;
import com.samsung.vip.engine.VITextAllRecognitionLib;
import com.samsung.vip.engine.VITextRecognitionLib;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class TextRecognition {
    private static final String TAG = "TextRecognition";
    private String mCurrLanguage;
    private String mDataPath;
    private VITextRecognitionLib mTxtRecLib;

    public boolean init(Context context, String lang) {
        if (!VIRecogUtils.copyDatabase(context)) {
            Log.e(TAG, "Fail to copy database.");
            return false;
        }
        this.mDataPath = String.valueOf(context.getFilesDir().getAbsolutePath()) + "/vidata/";
        if (!init(lang)) {
            Log.e(TAG, "Fail to initialize.");
            this.mDataPath = null;
            return false;
        }
        return true;
    }

    private boolean init(String lang) {
        this.mCurrLanguage = lang;
        if (this.mTxtRecLib != null) {
            this.mTxtRecLib.close();
            this.mTxtRecLib = null;
        }
        this.mTxtRecLib = new VITextAllRecognitionLib();
        int langMode = this.mTxtRecLib.getLanguageMode(lang);
        if (langMode < 0) {
            Log.e(TAG, "Not supported language!");
            return false;
        }
        int nLangMode = VIRecogMode.getLanguageMode(langMode, true);
        short sRangeMode = VIRecogMode.getRangeMode(true, true, true);
        int ret = this.mTxtRecLib.init(this.mDataPath, nLangMode, sRangeMode);
        Log.i(TAG, "init : ret = " + ret);
        return true;
    }

    public void addStroke(float[] x, float[] y) {
        if (this.mTxtRecLib != null) {
            this.mTxtRecLib.addStroke(x, y);
        }
    }

    public String[] process() {
        if (this.mTxtRecLib == null) {
            return null;
        }
        return this.mTxtRecLib.recog();
    }

    public void dispose() {
        if (this.mTxtRecLib != null) {
            this.mTxtRecLib.close();
            this.mTxtRecLib = null;
        }
    }

    public void setLanguage(String lang) {
        Log.d(TAG, "setLanguage() : " + lang);
        if (this.mTxtRecLib != null) {
            if (!this.mTxtRecLib.isSupportedLanguage(lang)) {
                Log.e(TAG, "Unsupported language: " + lang);
            } else {
                init(lang);
            }
        }
    }

    public String getCurrentLanguage() {
        if (this.mTxtRecLib == null) {
            return null;
        }
        return this.mCurrLanguage;
    }

    public ArrayList<String> getSupportedLanguage() {
        if (this.mTxtRecLib == null) {
            return null;
        }
        String[] list = this.mTxtRecLib.getLangList();
        return new ArrayList<>(Arrays.asList(list));
    }
}
