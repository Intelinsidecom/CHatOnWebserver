package com.samsung.android.sdk.pen.settingui;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.samsung.android.sdk.pen.Spen;
import com.vlingo.sdk.internal.vlservice.config.VLConfigParser;

/* loaded from: classes.dex */
class SPenTextUtil {
    protected Resources mSdkResources;

    public SPenTextUtil(Context context) {
        this.mSdkResources = null;
        try {
            PackageManager manager = context.getPackageManager();
            this.mSdkResources = manager.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected String setString(String strName) throws Resources.NotFoundException {
        int strID;
        String string = null;
        try {
            strID = this.mSdkResources.getIdentifier(strName, VLConfigParser.TYPE_STRING, Spen.SPEN_NATIVE_PACKAGE_NAME);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if (strID == 0) {
            return null;
        }
        string = this.mSdkResources.getString(strID);
        return string;
    }
}
