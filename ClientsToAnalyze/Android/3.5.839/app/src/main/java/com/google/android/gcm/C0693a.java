package com.google.android.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import com.sec.spp.push.Config;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: GCMRegistrar.java */
/* renamed from: com.google.android.gcm.a */
/* loaded from: classes.dex */
public final class C0693a {

    /* renamed from: a */
    private static GCMBroadcastReceiver f1635a;

    /* renamed from: b */
    private static String f1636b;

    /* renamed from: a */
    public static void m2213a(Context context) throws PackageManager.NameNotFoundException {
        int i = Build.VERSION.SDK_INT;
        if (i < 8) {
            throw new UnsupportedOperationException("Device must be at least API Level 8 (instead of " + i + ")");
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gsf", 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new UnsupportedOperationException("Device does not have package com.google.android.gsf");
        }
    }

    /* renamed from: b */
    public static void m2218b(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        String str = packageName + ".permission.C2D_MESSAGE";
        try {
            packageManager.getPermissionInfo(str, 4096);
            try {
                ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(packageName, 2).receivers;
                if (activityInfoArr == null || activityInfoArr.length == 0) {
                    throw new IllegalStateException("No receiver for package " + packageName);
                }
                if (Log.isLoggable("GCMRegistrar", 2)) {
                    Log.v("GCMRegistrar", "number of receivers for " + packageName + ": " + activityInfoArr.length);
                }
                HashSet hashSet = new HashSet();
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if ("com.google.android.c2dm.permission.SEND".equals(activityInfo.permission)) {
                        hashSet.add(activityInfo.name);
                    }
                }
                if (hashSet.isEmpty()) {
                    throw new IllegalStateException("No receiver allowed to receive com.google.android.c2dm.permission.SEND");
                }
                m2215a(context, hashSet, "com.google.android.c2dm.intent.REGISTRATION");
                m2215a(context, hashSet, "com.google.android.c2dm.intent.RECEIVE");
            } catch (PackageManager.NameNotFoundException e) {
                throw new IllegalStateException("Could not get receivers for package " + packageName);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalStateException("Application does not define permission " + str);
        }
    }

    /* renamed from: a */
    private static void m2215a(Context context, Set<String> set, String str) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 32);
        if (listQueryBroadcastReceivers.isEmpty()) {
            throw new IllegalStateException("No receivers for action " + str);
        }
        if (Log.isLoggable("GCMRegistrar", 2)) {
            Log.v("GCMRegistrar", "Found " + listQueryBroadcastReceivers.size() + " receivers for action " + str);
        }
        Iterator<ResolveInfo> it = listQueryBroadcastReceivers.iterator();
        while (it.hasNext()) {
            String str2 = it.next().activityInfo.name;
            if (!set.contains(str2)) {
                throw new IllegalStateException("Receiver " + str2 + " is not set with permission com.google.android.c2dm.permission.SEND");
            }
        }
    }

    /* renamed from: a */
    public static void m2216a(Context context, String... strArr) {
        m2225h(context);
        m2219b(context, strArr);
    }

    /* renamed from: b */
    static void m2219b(Context context, String... strArr) {
        String strM2212a = m2212a(strArr);
        Log.v("GCMRegistrar", "Registering app " + context.getPackageName() + " of senders " + strM2212a);
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        intent.putExtra(Config.NOTIFICATION_INTENT_SENDER, strM2212a);
        context.startService(intent);
    }

    /* renamed from: a */
    static String m2212a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(',').append(strArr[i]);
        }
        return sb.toString();
    }

    /* renamed from: c */
    static void m2220c(Context context) {
        Log.v("GCMRegistrar", "Unregistering app " + context.getPackageName());
        Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        context.startService(intent);
    }

    /* renamed from: d */
    static synchronized void m2221d(Context context) {
        if (f1635a == null) {
            if (f1636b == null) {
                Log.e("GCMRegistrar", "internal error: retry receiver class not set yet");
                f1635a = new GCMBroadcastReceiver();
            } else {
                try {
                    f1635a = (GCMBroadcastReceiver) Class.forName(f1636b).newInstance();
                } catch (Exception e) {
                    Log.e("GCMRegistrar", "Could not create instance of " + f1636b + ". Using " + GCMBroadcastReceiver.class.getName() + " directly.");
                    f1635a = new GCMBroadcastReceiver();
                }
            }
            String packageName = context.getPackageName();
            IntentFilter intentFilter = new IntentFilter("com.google.android.gcm.intent.RETRY");
            intentFilter.addCategory(packageName);
            Log.v("GCMRegistrar", "Registering receiver");
            context.registerReceiver(f1635a, intentFilter, packageName + ".permission.C2D_MESSAGE", null);
        }
    }

    /* renamed from: a */
    static void m2217a(String str) {
        Log.v("GCMRegistrar", "Setting the name of retry receiver class to " + str);
        f1636b = str;
    }

    /* renamed from: e */
    public static String m2222e(Context context) {
        SharedPreferences sharedPreferencesM2228k = m2228k(context);
        String string = sharedPreferencesM2228k.getString("regId", "");
        int i = sharedPreferencesM2228k.getInt("appVersion", Integer.MIN_VALUE);
        int iM2227j = m2227j(context);
        if (i != Integer.MIN_VALUE && i != iM2227j) {
            Log.v("GCMRegistrar", "App version changed from " + i + " to " + iM2227j + "; resetting registration id");
            m2224g(context);
            return "";
        }
        return string;
    }

    /* renamed from: f */
    public static boolean m2223f(Context context) {
        return m2222e(context).length() > 0;
    }

    /* renamed from: g */
    static String m2224g(Context context) {
        return m2211a(context, "");
    }

    /* renamed from: a */
    static String m2211a(Context context, String str) {
        SharedPreferences sharedPreferencesM2228k = m2228k(context);
        String string = sharedPreferencesM2228k.getString("regId", "");
        int iM2227j = m2227j(context);
        Log.v("GCMRegistrar", "Saving regId on app version " + iM2227j);
        SharedPreferences.Editor editorEdit = sharedPreferencesM2228k.edit();
        editorEdit.putString("regId", str);
        editorEdit.putInt("appVersion", iM2227j);
        editorEdit.commit();
        return string;
    }

    /* renamed from: j */
    private static int m2227j(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Coult not get package name: " + e);
        }
    }

    /* renamed from: h */
    static void m2225h(Context context) {
        Log.d("GCMRegistrar", "resetting backoff for " + context.getPackageName());
        m2214a(context, 3000);
    }

    /* renamed from: i */
    static int m2226i(Context context) {
        return m2228k(context).getInt("backoff_ms", 3000);
    }

    /* renamed from: a */
    static void m2214a(Context context, int i) {
        SharedPreferences.Editor editorEdit = m2228k(context).edit();
        editorEdit.putInt("backoff_ms", i);
        editorEdit.commit();
    }

    /* renamed from: k */
    private static SharedPreferences m2228k(Context context) {
        return context.getSharedPreferences("com.google.android.gcm", 0);
    }
}
