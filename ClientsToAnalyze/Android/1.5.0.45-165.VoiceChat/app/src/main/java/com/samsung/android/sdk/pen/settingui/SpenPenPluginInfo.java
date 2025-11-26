package com.samsung.android.sdk.pen.settingui;

import com.samsung.android.sdk.pen.plugin.framework.SpenPluginInfo;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface;

/* loaded from: classes.dex */
class SpenPenPluginInfo {
    private String mPenName;
    private SpenPluginInfo mSpenPluginInfo;
    private SpenPenInterface mSpenPenInterface = null;
    private boolean mLoadFlag = false;

    public SpenPenPluginInfo(SpenPluginInfo pluginInfo) {
        this.mSpenPluginInfo = pluginInfo;
    }

    public void close() {
        this.mPenName = null;
        this.mSpenPenInterface = null;
        this.mSpenPluginInfo = null;
        this.mLoadFlag = false;
    }

    public void setName(SpenPluginInfo pluginInfo) {
        this.mPenName = String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName;
    }

    public void setPenPluginObject(SpenPenInterface iPen) {
        this.mSpenPenInterface = iPen;
    }

    public String getPenName() {
        return this.mPenName;
    }

    public SpenPluginInfo getPluginInfo() {
        return this.mSpenPluginInfo;
    }

    public SpenPenInterface getPenPluginObject() {
        return this.mSpenPenInterface;
    }

    public String getPackageName() {
        return this.mSpenPluginInfo.packageName;
    }

    public boolean isLoaded() {
        return this.mLoadFlag;
    }

    public void setLoaded(boolean flag) {
        this.mLoadFlag = flag;
    }
}
