package com.sec.chaton.clientapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.clientapi.exception.NotActivatedClientAPIException;
import com.sec.chaton.clientapi.exception.NotAvailableClientAPIException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class UtilityAPI {
    protected static final String CHATON_CANADA_PACKAGE_NAME = "com.sec.chatonforcanada";
    protected static final String CHATON_DOWNLOAD_URL = "http://www.chaton.com/invite.html";
    protected static final String CHATON_PACKAGE_NAME = "com.sec.chaton";
    public static final int THEME_BLACK = 1;
    public static final int THEME_DEFAULT = 0;
    protected static final Uri URI_SETTING_INFO = Uri.parse("content://com.sec.chaton.provider/setting_info");
    public static final String URI_SETTING_INFO_COLUMN_THEME = "theme";

    public static boolean isChatONInstalled(Context context) throws PackageManager.NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        try {
            manager.getPackageInfo(CHATON_PACKAGE_NAME, 64);
        } catch (PackageManager.NameNotFoundException e) {
            try {
                manager.getPackageInfo(CHATON_CANADA_PACKAGE_NAME, 64);
            } catch (PackageManager.NameNotFoundException e2) {
                return false;
            }
        }
        return true;
    }

    public static void openChatONDownloadPage(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(CHATON_DOWNLOAD_URL));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    @API(description = "1.10.3", versionCode = 11001021)
    public static boolean isChatONActivated(Context context) throws NotAvailableClientAPIException {
        if (!isAvailableAPI(context, UtilityAPI.class, "isChatONActivated", Context.class)) {
            throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
        }
        Cursor cursor = null;
        try {
            Cursor cursor2 = GraphAPI.getMyProfile(context);
            if (cursor2 == null) {
                return true;
            }
            cursor2.close();
            return true;
        } catch (NotActivatedClientAPIException e) {
            if (0 != 0) {
                cursor.close();
            }
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    static boolean isAvailableAPI(Context context, Class<?> clazz, String methodName, Class<?>... paramTypes) throws NoSuchMethodException, SecurityException {
        try {
            Method method = clazz.getMethod(methodName, paramTypes);
            API api = (API) method.getAnnotation(API.class);
            long versionCode = api.versionCode();
            return versionCode <= ((long) getChatONVersionCode(context));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    static int getChatONVersionCode(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo info;
        PackageManager manager = context.getPackageManager();
        try {
            info = manager.getPackageInfo(CHATON_PACKAGE_NAME, 64);
        } catch (PackageManager.NameNotFoundException e) {
            info = manager.getPackageInfo(CHATON_CANADA_PACKAGE_NAME, 64);
        }
        return info.versionCode;
    }

    @API(description = "2.6.0", versionCode = 20600000)
    public static Cursor getSettingInfo(Context context) throws NotAvailableClientAPIException, NotActivatedClientAPIException {
        if (!isAvailableAPI(context, UtilityAPI.class, "getSettingInfo", Context.class)) {
            throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
        }
        Cursor cursor = null;
        try {
            Cursor cursor2 = context.getContentResolver().query(URI_SETTING_INFO, new String[]{URI_SETTING_INFO_COLUMN_THEME}, null, null, null);
            if (cursor2 == null || cursor2.getCount() == 0) {
                throw new NotActivatedClientAPIException("ChatON isn't activated.");
            }
            if (cursor2.moveToNext()) {
                return cursor2;
            }
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        } catch (NotActivatedClientAPIException e) {
            if (0 != 0) {
                cursor.close();
            }
            throw e;
        } catch (RuntimeException e2) {
            if (0 != 0) {
                cursor.close();
            }
            throw e2;
        }
    }
}
