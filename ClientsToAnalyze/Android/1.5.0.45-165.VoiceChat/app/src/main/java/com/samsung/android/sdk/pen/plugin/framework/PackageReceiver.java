package com.samsung.android.sdk.pen.plugin.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class PackageReceiver extends BroadcastReceiver {
    static final String META_DATA_KEY_SPEN_PLUGIN_INFO = "SPEN_PLUGIN_INFO";
    private static List<SpenPluginManager.PluginListener> mListener = new ArrayList();

    PackageReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws PackageManager.NameNotFoundException {
        SpenPluginInfo info;
        SpenPluginInfo info2;
        String packageName = intent.getData().getSchemeSpecificPart();
        String action = intent.getAction();
        if (action.equals("android.intent.action.PACKAGE_ADDED")) {
            PackageManager pm = context.getPackageManager();
            try {
                ApplicationInfo ai = pm.getApplicationInfo(packageName, 128);
                Bundle bundle = ai.metaData;
                if (bundle != null) {
                    String pluginInfoData = bundle.getString(META_DATA_KEY_SPEN_PLUGIN_INFO);
                    if (pluginInfoData != null && (info2 = SpenPluginManager.getInstance(context).getPluginInfo(packageName)) != null) {
                        for (SpenPluginManager.PluginListener listener : mListener) {
                            if (listener != null) {
                                listener.onInstalled(info2.type, packageName);
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }
        if (action.equals("android.intent.action.PACKAGE_REMOVED") && (info = SpenPluginManager.getInstance(context).getPluginInfo(packageName)) != null) {
            SpenPluginManager.getInstance(context).deleteAPKPluginInfo(packageName);
            for (SpenPluginManager.PluginListener listener2 : mListener) {
                if (listener2 != null) {
                    listener2.onUninstalled(info.type, packageName);
                }
            }
        }
    }

    public void setNotifyListener(SpenPluginManager.PluginListener listener) {
        mListener.add(listener);
    }
}
