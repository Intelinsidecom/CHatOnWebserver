package com.google.android.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import com.google.protobuf.CodedOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class GCMRegistrar {
    private static final String BACKOFF_MS = "backoff_ms";
    private static final int DEFAULT_BACKOFF_MS = 3000;
    private static final String GSF_PACKAGE = "com.google.android.gsf";
    private static final String PREFERENCES = "com.google.android.gcm";
    private static final String PROPERTY_APP_VERSION = "appVersion";
    private static final String PROPERTY_ON_SERVER = "onServer";
    private static final String PROPERTY_REG_ID = "regId";
    private static final String TAG = "GCMRegistrar";
    private static GCMBroadcastReceiver sRetryReceiver;

    public static void checkDevice(Context context) throws PackageManager.NameNotFoundException {
        int version = Build.VERSION.SDK_INT;
        if (version < 8) {
            throw new UnsupportedOperationException("Device must be at least API Level 8 (instead of " + version + ")");
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo(GSF_PACKAGE, 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new UnsupportedOperationException("Device does not have package com.google.android.gsf");
        }
    }

    public static void checkManifest(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        String permissionName = packageName + ".permission.C2D_MESSAGE";
        try {
            packageManager.getPermissionInfo(permissionName, CodedOutputStream.DEFAULT_BUFFER_SIZE);
            try {
                PackageInfo receiversInfo = packageManager.getPackageInfo(packageName, 2);
                ActivityInfo[] receivers = receiversInfo.receivers;
                if (receivers == null || receivers.length == 0) {
                    throw new IllegalStateException("No receiver for package " + packageName);
                }
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "number of receivers for " + packageName + ": " + receivers.length);
                }
                Set<String> allowedReceivers = new HashSet<>();
                for (ActivityInfo receiver : receivers) {
                    if (GCMConstants.PERMISSION_GCM_INTENTS.equals(receiver.permission)) {
                        allowedReceivers.add(receiver.name);
                    }
                }
                if (allowedReceivers.isEmpty()) {
                    throw new IllegalStateException("No receiver allowed to receive com.google.android.c2dm.permission.SEND");
                }
                checkReceiver(context, allowedReceivers, GCMConstants.INTENT_FROM_GCM_REGISTRATION_CALLBACK);
                checkReceiver(context, allowedReceivers, GCMConstants.INTENT_FROM_GCM_MESSAGE);
            } catch (PackageManager.NameNotFoundException e) {
                throw new IllegalStateException("Could not get receivers for package " + packageName);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalStateException("Application does not define permission " + permissionName);
        }
    }

    private static void checkReceiver(Context context, Set<String> allowedReceivers, String action) {
        PackageManager pm = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(action);
        intent.setPackage(packageName);
        List<ResolveInfo> receivers = pm.queryBroadcastReceivers(intent, 32);
        if (receivers.isEmpty()) {
            throw new IllegalStateException("No receivers for action " + action);
        }
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Found " + receivers.size() + " receivers for action " + action);
        }
        for (ResolveInfo receiver : receivers) {
            String name = receiver.activityInfo.name;
            if (!allowedReceivers.contains(name)) {
                throw new IllegalStateException("Receiver " + name + " is not set with permission " + GCMConstants.PERMISSION_GCM_INTENTS);
            }
        }
    }

    public static void register(Context context, String... senderIds) {
        setRetryBroadcastReceiver(context);
        resetBackoff(context);
        internalRegister(context, senderIds);
    }

    static void internalRegister(Context context, String... senderIds) {
        if (senderIds == null || senderIds.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder builder = new StringBuilder(senderIds[0]);
        for (int i = 1; i < senderIds.length; i++) {
            builder.append(',').append(senderIds[i]);
        }
        String senders = builder.toString();
        Log.v(TAG, "Registering app " + context.getPackageName() + " of senders " + senders);
        Intent intent = new Intent(GCMConstants.INTENT_TO_GCM_REGISTRATION);
        intent.setPackage(GSF_PACKAGE);
        intent.putExtra(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        intent.putExtra("sender", senders);
        context.startService(intent);
    }

    public static void unregister(Context context) {
        setRetryBroadcastReceiver(context);
        resetBackoff(context);
        internalUnregister(context);
    }

    public static synchronized void onDestroy(Context context) {
        if (sRetryReceiver != null) {
            Log.v(TAG, "Unregistering receiver");
            context.unregisterReceiver(sRetryReceiver);
            sRetryReceiver = null;
        }
    }

    static void internalUnregister(Context context) {
        Log.v(TAG, "Unregistering app " + context.getPackageName());
        Intent intent = new Intent(GCMConstants.INTENT_TO_GCM_UNREGISTRATION);
        intent.setPackage(GSF_PACKAGE);
        intent.putExtra(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT, PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        context.startService(intent);
    }

    private static synchronized void setRetryBroadcastReceiver(Context context) {
        if (sRetryReceiver == null) {
            sRetryReceiver = new GCMBroadcastReceiver();
            String category = context.getPackageName();
            IntentFilter filter = new IntentFilter(GCMConstants.INTENT_FROM_GCM_LIBRARY_RETRY);
            filter.addCategory(category);
            String permission = category + ".permission.C2D_MESSAGE";
            Log.v(TAG, "Registering receiver");
            context.registerReceiver(sRetryReceiver, filter, permission, null);
        }
    }

    public static String getRegistrationId(Context context) throws PackageManager.NameNotFoundException {
        SharedPreferences prefs = getGCMPreferences(context);
        String registrationId = prefs.getString(PROPERTY_REG_ID, "");
        int oldVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
        int newVersion = getAppVersion(context);
        if (oldVersion != Integer.MIN_VALUE && oldVersion != newVersion) {
            Log.v(TAG, "App version changed from " + oldVersion + " to " + newVersion + "; resetting registration id");
            clearRegistrationId(context);
            return "";
        }
        return registrationId;
    }

    public static boolean isRegistered(Context context) {
        return getRegistrationId(context).length() > 0;
    }

    static String clearRegistrationId(Context context) {
        return setRegistrationId(context, "");
    }

    static String setRegistrationId(Context context, String regId) throws PackageManager.NameNotFoundException {
        SharedPreferences prefs = getGCMPreferences(context);
        String oldRegistrationId = prefs.getString(PROPERTY_REG_ID, "");
        int appVersion = getAppVersion(context);
        Log.v(TAG, "Saving regId on app version " + appVersion);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PROPERTY_REG_ID, regId);
        editor.putInt(PROPERTY_APP_VERSION, appVersion);
        editor.commit();
        return oldRegistrationId;
    }

    public static void setRegisteredOnServer(Context context, boolean flag) {
        SharedPreferences prefs = getGCMPreferences(context);
        Log.v(TAG, "Setting registered on server status as: " + flag);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(PROPERTY_ON_SERVER, flag);
        editor.commit();
    }

    public static boolean isRegisteredOnServer(Context context) {
        SharedPreferences prefs = getGCMPreferences(context);
        boolean isRegistered = prefs.getBoolean(PROPERTY_ON_SERVER, false);
        Log.v(TAG, "Is registered on server: " + isRegistered);
        return isRegistered;
    }

    private static int getAppVersion(Context context) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Coult not get package name: " + e);
        }
    }

    static void resetBackoff(Context context) {
        Log.d(TAG, "resetting backoff for " + context.getPackageName());
        setBackoff(context, 3000);
    }

    static int getBackoff(Context context) {
        SharedPreferences prefs = getGCMPreferences(context);
        return prefs.getInt(BACKOFF_MS, 3000);
    }

    static void setBackoff(Context context, int backoff) {
        SharedPreferences prefs = getGCMPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(BACKOFF_MS, backoff);
        editor.commit();
    }

    private static SharedPreferences getGCMPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCES, 0);
    }

    private GCMRegistrar() {
        throw new UnsupportedOperationException();
    }
}
