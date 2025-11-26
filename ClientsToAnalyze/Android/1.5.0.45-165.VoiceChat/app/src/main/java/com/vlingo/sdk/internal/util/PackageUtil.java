package com.vlingo.sdk.internal.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.logging.Logger;
import java.util.List;

/* loaded from: classes.dex */
public class PackageUtil {
    private static Logger log = Logger.getLogger(PackageUtil.class);

    public static boolean isGoogleMapsInstalled() {
        return isAppInstalled("com.google.android.apps.maps", 4707);
    }

    public static boolean isBingInstalled() {
        return isAppInstalled("com.microsoft.mobileexperiences.bing", 1);
    }

    public static boolean isSMemoInstalled() {
        return isAppInstalled("com.sec.android.widgetapp.diotek.smemo", 1);
    }

    public static boolean isSNoteInstalled() {
        return isAppInstalled("com.sec.android.app.snotebook", 1);
    }

    public static boolean isSMemo2Installed() throws PackageManager.NameNotFoundException {
        boolean smemo_installed = isSMemoInstalled();
        boolean memo_installed = isMemoInstalled();
        if (!smemo_installed && !memo_installed) {
            return false;
        }
        try {
            Context context = ApplicationAdapter.getInstance().getApplicationContext();
            context.getPackageManager().getApplicationInfo("com.sec.android.provider.snote", 8192);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isMemoInstalled() {
        return isAppInstalled("com.sec.android.app.memo", 1);
    }

    public static boolean isAppInstalled(String packageName, int minVersionCode) throws PackageManager.NameNotFoundException {
        log.debug("isAppInstalled");
        Context ctxt = ApplicationAdapter.getInstance().getApplicationContext();
        PackageManager pm = ctxt.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> activities = pm.queryIntentActivities(intent, 0);
        log.debug("Looking for packageName: " + packageName + " minVersionCode: " + minVersionCode);
        for (ResolveInfo ri : activities) {
            if (ri.activityInfo.packageName != null && ri.activityInfo.packageName.equalsIgnoreCase(packageName)) {
                int packageVersion = getPackageVersionCode(ctxt, packageName);
                log.debug("Found " + packageName + " at version " + packageVersion);
                if (packageVersion >= minVersionCode) {
                    log.debug("Version OK for '" + packageName + "'");
                    return true;
                }
                log.debug("Version NOT OK - Installed package is out of date '" + packageName + "'");
                return false;
            }
        }
        return false;
    }

    public static int getPackageVersionCode(Context context, String packageName) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            return packageInfo.versionCode;
        } catch (Exception e) {
            return -1;
        }
    }

    public static boolean canHandleServiceIntent(Context context, Intent intent) {
        log.debug("queryIntentServices");
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentServices(intent, 0);
        return activities != null && activities.size() > 0;
    }

    public static boolean canHandleBroadcastIntent(Context context, Intent intent) {
        log.debug("canHandleBroadcastIntent");
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> activities = pm.queryBroadcastReceivers(intent, 0);
        return activities != null && activities.size() > 0;
    }

    public static boolean canHandleIntent(Context context, String action, String category, String uri, String packageName) {
        log.debug("canHandleIntent");
        Intent intent = new Intent(action);
        if (category != null && category.length() > 0) {
            intent.addCategory(category);
        }
        if (uri != null && uri.length() > 0) {
            intent.setData(Uri.parse(uri));
        }
        if (packageName != null && packageName.length() > 0) {
            intent.setPackage(packageName);
        }
        return canHandleIntent(context, intent);
    }

    public static boolean canHandleIntent(Context context, Intent intent) {
        log.debug("canHandleIntent");
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(intent, 0);
        return activities != null && activities.size() > 0;
    }
}
