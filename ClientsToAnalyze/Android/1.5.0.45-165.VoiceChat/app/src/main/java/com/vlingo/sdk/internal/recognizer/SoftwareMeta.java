package com.vlingo.sdk.internal.recognizer;

import com.vlingo.sdk.VLSdk;

/* loaded from: classes.dex */
public class SoftwareMeta {
    private static SoftwareMeta instance = null;
    String appChannel;
    String appid;
    String name;
    String version;

    public static SoftwareMeta getInstance() {
        if (instance == null) {
            instance = new SoftwareMeta();
        }
        return instance;
    }

    public static void destroy() {
        instance = null;
    }

    public void setAppId(String appid) {
        this.appid = appid;
    }

    public void setAppName(String appName) {
        this.name = appName;
    }

    public void setAppVersion(String appVersion) {
        this.version = appVersion;
    }

    public void setAppChannel(String appChannel) {
        this.appChannel = appChannel;
    }

    public String getAppId() {
        return this.appid;
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public String getAppChannel() {
        return this.appChannel;
    }

    public String getSdkName() {
        return "AndroidSDK";
    }

    public String getSdkVersion() {
        return VLSdk.VERSION;
    }
}
