package com.coolots.chaton.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class ChatONVRestrictAccess {
    private static final String CLASSNAME = "[ChatONVRestrictAccess]";
    private ActivityManager activityManager = null;
    private final HashMap<String, String> mAccessablePName;
    private final HashMap<String, String> mAccessablePNameTest;
    private final List<String> mAccessableSharedUserID;
    private final Context mContext;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public ChatONVRestrictAccess(Context context) {
        this.mContext = context;
        String mySharedUserId = null;
        try {
            mySharedUserId = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).sharedUserId;
        } catch (PackageManager.NameNotFoundException e) {
            logE("NameNotFoundException");
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
        this.mAccessablePName = new HashMap<>();
        if (((ChatOnConfigInterface) MainApplication.mConfig).isSkipRestrictAccessCheck()) {
            this.mAccessablePName.put("com.sec.chaton", null);
            this.mAccessablePName.put("com.sec.chatonforcanada", null);
            this.mAccessablePNameTest = null;
        } else {
            this.mAccessablePName.put("com.sec.chaton", "@b3c002d4");
            this.mAccessablePName.put("com.sec.chatonforcanada", "@b3c002d4");
            this.mAccessablePNameTest = new HashMap<>();
            this.mAccessablePNameTest.put("com.sec.chaton", "@38e61192");
            this.mAccessablePNameTest.put("com.sec.chatonforcanada", "@38e61192");
        }
        this.mAccessableSharedUserID = new ArrayList();
        this.mAccessableSharedUserID.add(mySharedUserId);
    }

    public boolean check(int processID) {
        return check(getProcessNameFromPid(processID));
    }

    public boolean check(String packageName) throws PackageManager.NameNotFoundException {
        if (packageName == null) {
            return false;
        }
        if (this.mAccessablePName.containsKey(packageName)) {
            if (this.mAccessablePName.get(packageName) != null) {
                String signature = getSignature(packageName);
                logI("signature: " + signature);
                if (!this.mAccessablePName.get(packageName).equals(signature) && !this.mAccessablePNameTest.get(packageName).equals(signature)) {
                    logI("access check: fail");
                    return false;
                }
            }
            logI("access check(): success");
            return true;
        }
        logI("not included package");
        return checkSharedUID(packageName);
    }

    private boolean checkSharedUID(String packageName) {
        String sharedUID = getSharedUserID(packageName);
        if (sharedUID == null) {
            return false;
        }
        if (this.mAccessableSharedUserID.contains(sharedUID)) {
            logI("access check(): success");
            return true;
        }
        logI("access check(): fail");
        return false;
    }

    private String getProcessNameFromPid(int processID) {
        if (this.activityManager == null) {
            this.activityManager = (ActivityManager) this.mContext.getSystemService("activity");
        }
        List<ActivityManager.RunningAppProcessInfo> list = this.activityManager.getRunningAppProcesses();
        if (list == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo info : list) {
            if (info.pid == processID) {
                return info.processName;
            }
        }
        return null;
    }

    private String getSharedUserID(String packageName) {
        try {
            return this.mContext.getPackageManager().getPackageInfo(packageName, 16384).sharedUserId;
        } catch (PackageManager.NameNotFoundException e) {
            logE("NameNotFoundException");
            return null;
        }
    }

    private String getSignature(String packageName) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo info = this.mContext.getPackageManager().getPackageInfo(packageName, 64);
            Signature[] signature = info.signatures;
            return signature[0].toString().substring("android.content.pm.Signature".length(), signature[0].toString().length());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
