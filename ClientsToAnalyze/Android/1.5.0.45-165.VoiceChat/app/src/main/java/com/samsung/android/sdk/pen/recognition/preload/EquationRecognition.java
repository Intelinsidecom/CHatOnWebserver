package com.samsung.android.sdk.pen.recognition.preload;

import android.content.Context;
import android.util.Log;
import com.samsung.vip.engine.VIEquationRecognitionLib;

/* loaded from: classes.dex */
public class EquationRecognition {
    private static final String TAG = "EquationRecognition";
    private VIEquationRecognitionLib mEqRecLib;

    public EquationRecognition(Context context) {
    }

    public boolean init(Context context) {
        if (!VIRecogUtils.copyDatabase(context)) {
            Log.e(TAG, "Fail to copy database.");
            return false;
        }
        String dataPath = String.valueOf(context.getFilesDir().getAbsolutePath()) + "/vidata/";
        this.mEqRecLib = null;
        this.mEqRecLib = new VIEquationRecognitionLib();
        int ret = this.mEqRecLib.init(dataPath);
        if (ret != 0) {
            Log.e(TAG, "equation engine init : ret = " + ret);
            return false;
        }
        return true;
    }

    public void addStroke(float[] x, float[] y) {
        if (this.mEqRecLib != null) {
            this.mEqRecLib.addStroke(x, y);
        }
    }

    public String process() {
        if (this.mEqRecLib == null) {
            return null;
        }
        return this.mEqRecLib.recog();
    }

    public void dispose() {
        if (this.mEqRecLib != null) {
            this.mEqRecLib.close();
            this.mEqRecLib = null;
        }
    }
}
