package com.coolots.chaton.common.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.sds.coolots.common.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FactoryModeHandler {
    private static final String CLASSNAME = "[FactoryModeHandler]";
    private static final String DEFAULT_CALL_CLASS_NAME = "com.android.phone.PrivilegedOutgoingCallBroadcaster";

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public void handleFactoryMode(Context context) {
        if (isPossibleDevice()) {
            if (isFactoryMode() || isFactorySim(context)) {
                setDefaultCallClass(context);
            }
        }
    }

    private void setDefaultCallClass(Context context) {
        logE("START TEST!!");
        Intent homeIntent = new Intent();
        homeIntent.setAction("android.intent.action.CALL_PRIVILEGED");
        homeIntent.setData(Uri.parse("tel:1111"));
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> rList = packageManager.queryIntentActivities(homeIntent, 65600);
        ArrayList<ComponentName> prefActList = new ArrayList<>();
        ComponentName defaultHomeComp = null;
        int defaultHomeMatch = 0;
        for (ResolveInfo resolve : rList) {
            logE("r1 = " + resolve);
            if (resolve.priority <= 0) {
                logE("pass priority check!!");
                ComponentName comp = new ComponentName(resolve.activityInfo.packageName, resolve.activityInfo.name);
                prefActList.add(comp);
                if (resolve.activityInfo.name.contains(DEFAULT_CALL_CLASS_NAME)) {
                    defaultHomeComp = comp;
                    defaultHomeMatch = resolve.match;
                }
            }
        }
        if (defaultHomeComp != null) {
            logE("Default home is " + defaultHomeComp);
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.intent.action.CALL_PRIVILEGED");
            filter.addCategory("android.intent.category.DEFAULT");
            filter.addDataScheme("tel");
            ComponentName[] prefActArray = new ComponentName[prefActList.size()];
            for (int i = 0; i < prefActList.size(); i++) {
                prefActArray[i] = prefActList.get(i);
            }
            try {
                packageManager.addPreferredActivity(filter, defaultHomeMatch, prefActArray, defaultHomeComp);
            } catch (Exception e) {
                logE("Exception!! " + e.getMessage());
            }
        }
    }

    private boolean isPossibleDevice() {
        return !"GT-N7000".equals(Build.MODEL);
    }

    private boolean isFactoryMode() throws Throwable {
        boolean isFactoryMode = false;
        BufferedReader buffer = null;
        try {
            try {
                BufferedReader buffer2 = new BufferedReader(new FileReader("efs/FactoryApp/factorymode"));
                try {
                    String str = buffer2.readLine();
                    if (str != null) {
                        if (str.toLowerCase().contains("off")) {
                            isFactoryMode = true;
                        }
                    }
                    try {
                        buffer2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e2) {
                    e = e2;
                    buffer = buffer2;
                    System.err.println(e);
                    System.exit(1);
                    try {
                        buffer.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return isFactoryMode;
                } catch (Throwable th) {
                    th = th;
                    buffer = buffer2;
                    try {
                        buffer.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        }
        return isFactoryMode;
    }

    private boolean isFactorySim(Context context) {
        boolean factorysim = false;
        TelephonyManager telephony = (TelephonyManager) context.getSystemService("phone");
        String imsi = telephony.getSubscriberId();
        if (imsi != null && imsi.equals("999999999999999")) {
            factorysim = true;
        }
        return factorysim;
    }
}
