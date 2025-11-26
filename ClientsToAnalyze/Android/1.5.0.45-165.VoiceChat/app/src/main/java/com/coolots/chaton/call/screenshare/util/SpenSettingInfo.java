package com.coolots.chaton.call.screenshare.util;

import com.samsung.android.sdk.pen.SpenSettingEraserInfo;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingTextInfo;
import com.samsung.android.sdk.pen.engine.SpenMultiView;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class SpenSettingInfo {
    private SpenSettingEraserInfo mEraserInfo;
    private int mMode;
    private SpenSettingPenInfo mPenInfo;
    private int mPreAlphaValue;
    private int mPreColorValue;
    private String mPreNameValue;
    private float mPreWidthValue;
    private SpenSettingTextInfo mTextInfo;
    private int mUserId;

    public SpenSettingInfo(int mode, SpenMultiView view, int userId) {
        this.mPenInfo = null;
        this.mEraserInfo = null;
        this.mTextInfo = null;
        this.mMode = mode;
        this.mUserId = userId;
        if (this.mMode == 1) {
            this.mPenInfo = view.getPenSettingInfo(this.mUserId);
        } else if (this.mMode == 2) {
            this.mEraserInfo = view.getEraserSettingInfo(this.mUserId);
        } else if (this.mMode != 3) {
            this.mPenInfo = view.getPenSettingInfo(this.mUserId);
        }
    }

    public void setUserId(int userId) {
        this.mUserId = userId;
    }

    public SpenSettingInfo(int mode) {
        this.mPenInfo = null;
        this.mEraserInfo = null;
        this.mTextInfo = null;
        this.mMode = mode;
    }

    public SpenSettingInfo() {
        this.mPenInfo = null;
        this.mEraserInfo = null;
        this.mTextInfo = null;
    }

    public Object getSpenSettingInfo() {
        if (this.mMode == 1) {
            return this.mPenInfo;
        }
        if (this.mMode == 2) {
            return this.mEraserInfo;
        }
        if (this.mMode == 3) {
            return null;
        }
        return this.mPenInfo;
    }

    public int getMode() {
        return this.mMode;
    }

    public int getStrokeColor() {
        if (onlySavedPreValue()) {
            return this.mPreColorValue;
        }
        if (this.mMode == 1) {
            return this.mPenInfo.color;
        }
        if (this.mMode == 2) {
            return 0;
        }
        if (this.mMode == 3) {
            return this.mTextInfo.color;
        }
        return this.mPenInfo.color;
    }

    public String getStrokeName() {
        if (onlySavedPreValue()) {
            return this.mPreNameValue;
        }
        if (this.mMode == 1) {
            return this.mPenInfo.name;
        }
        if (this.mMode == 2) {
            return null;
        }
        if (this.mMode == 3) {
            return this.mTextInfo.font;
        }
        return this.mPenInfo.name;
    }

    public float getStrokeWidth() {
        if (onlySavedPreValue()) {
            return this.mPreWidthValue;
        }
        if (this.mMode == 1) {
            return this.mPenInfo.size;
        }
        if (this.mMode == 2) {
            return this.mEraserInfo.size;
        }
        if (this.mMode == 3) {
            return this.mTextInfo.size;
        }
        return this.mPenInfo.size;
    }

    public void setStrokeColor(int value) {
        if (onlySavedPreValue()) {
            this.mPreColorValue = value;
        }
    }

    public void setStrokeName(String value) {
        if (onlySavedPreValue()) {
            this.mPreNameValue = value;
        }
    }

    public void setStrokeWidth(float value) {
        if (onlySavedPreValue()) {
            this.mPreWidthValue = value;
        }
    }

    private boolean onlySavedPreValue() {
        return this.mPenInfo == null && this.mEraserInfo == null && this.mTextInfo == null;
    }

    public void setSpenSettingInfoIntoSpenMultiView(SpenMultiView spenmultiview, SettingView settingView, int otherId) {
        int fingerAction = -1;
        int spenAction = -1;
        if (this.mMode == 1) {
            Log.m2963i("YKYU setSpenSettingInfoIntoSpenMultiView -1-");
            SpenSettingPenInfo penInfo = spenmultiview.getPenSettingInfo(otherId);
            penInfo.name = getStrokeName();
            penInfo.color = getStrokeColor();
            penInfo.size = getStrokeWidth();
            Log.m2963i("YKYU penInfo.color = " + penInfo.color);
            Log.m2963i("YKYU penInfo.name = " + penInfo.name);
            Log.m2963i("YKYU penInfo.size = " + penInfo.size);
            spenmultiview.setPenSettingInfo(otherId, penInfo);
            fingerAction = 2;
            spenAction = 2;
        } else if (this.mMode == 2) {
            Log.m2963i("YKYU setSpenSettingInfoIntoSpenMultiView -2-");
            SpenSettingEraserInfo eraserInfo = spenmultiview.getEraserSettingInfo(otherId);
            eraserInfo.size = getStrokeWidth();
            Log.m2963i("YKYU eraserInfo.size = " + eraserInfo.size);
            spenmultiview.setEraserSettingInfo(otherId, eraserInfo);
            fingerAction = 3;
            spenAction = 3;
        } else if (this.mMode != 3) {
        }
        if (fingerAction == -1 || spenAction == -1) {
            Log.m2963i("YKYU setSpenSettingInfoIntoSpenMultiView -error-");
        } else {
            spenmultiview.setToolTypeAction(otherId, 1, fingerAction);
            spenmultiview.setToolTypeAction(otherId, 2, spenAction);
        }
    }
}
