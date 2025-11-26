package com.samsung.android.sdk.pen.settingui;

import android.graphics.Bitmap;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;

/* loaded from: classes.dex */
class SpenPenPresetInfo {
    private int mPresetOrder;
    private Bitmap mBitmap = null;
    private final SpenSettingPenInfo mPenData = new SpenSettingPenInfo();
    private boolean mFlag = false;
    private String mPresetImage = null;

    SpenPenPresetInfo() {
    }

    public void setPresetOrder(int presetOrder) {
        this.mPresetOrder = presetOrder;
    }

    public int getPresetOrder() {
        return this.mPresetOrder;
    }

    public void setFlag(boolean flag) {
        this.mFlag = flag;
    }

    public boolean getFlag() {
        return this.mFlag;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public void setPenSize(float paramInt) {
        this.mPenData.size = paramInt;
    }

    public float getPenSize() {
        return this.mPenData.size;
    }

    public void setPenName(String paramString) {
        this.mPenData.name = paramString;
    }

    public void setPresetImageName(String presetImage) {
        this.mPresetImage = presetImage;
    }

    public void setColor(int paramInt) {
        this.mPenData.color = paramInt;
    }

    public String getPenName() {
        return this.mPenData.name;
    }

    public int getColor() {
        return this.mPenData.color;
    }

    public String getPresetImageName() {
        return this.mPresetImage;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setAdvancedSetting(String advancedSetting) {
        this.mPenData.advancedSetting = advancedSetting;
    }

    public String getAdvancedSetting() {
        return this.mPenData.advancedSetting;
    }

    public void setBitmapSize(int width, int height) {
        if (this.mBitmap == null) {
            this.mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }
    }

    public void close() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
    }
}
