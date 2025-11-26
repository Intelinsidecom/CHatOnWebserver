package com.coolots.sso.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.coolots.chaton.common.view.ChatONNativeCallActivity;
import com.sds.coolots.common.controller.DatabaseHelper;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public class ChatONVAPI {
    public static final int RET_CHATONV_FAIL = 1;
    public static final int RET_CHATONV_ID_EMPTY = 3;
    public static final int RET_CHATONV_NOT_ALLOWED_ACCESS = 5;
    public static final int RET_CHATONV_NOT_INSTALLED = 2;
    public static final int RET_CHATONV_SUCCESS = 0;
    public static final int RET_CHATONV_UNEXPECTED_ERROR = 4;
    private static final String TAG = "ChatONVAPI";

    public int checkBuddyForCall(Context context, String samsungAccount) {
        Log.i(TAG, "checkBuddyForCall()");
        if (checkKey(context) == null) {
            Log.e(TAG, "not allowed access");
            return 5;
        }
        if (!isInstalled(context)) {
            Log.e(TAG, "ChatON V is not installed");
            return 2;
        }
        if (samsungAccount == null || samsungAccount.isEmpty()) {
            Log.e(TAG, "samsungAccount is empty");
            return 3;
        }
        String[] columns = {DatabaseHelper.KEY_BUDDYNAME};
        String[] selectionArgs = {String.valueOf(samsungAccount)};
        ContentResolver cr = context.getContentResolver();
        Cursor c = cr.query(Uri.parse("content://com.coolots.chaton/normalbuddy"), columns, null, selectionArgs, null);
        if (c != null) {
            try {
                if (c.getCount() != 0) {
                    if (!c.moveToFirst()) {
                        return 1;
                    }
                    do {
                        Log.i(TAG, "buddyname = " + c.getString(0));
                    } while (c.moveToNext());
                    c.close();
                    return 0;
                }
            } finally {
                c.close();
            }
        }
        return 1;
    }

    public Cursor getAllBuddyList(Context context, String[] columns) {
        if (checkKey(context) == null) {
            Log.e(TAG, "not allowed access");
            return null;
        }
        ContentResolver cr = context.getContentResolver();
        if (cr == null) {
            return null;
        }
        Cursor c = cr.query(Uri.parse("content://com.coolots.chaton/buddy"), columns, null, null, null);
        return c;
    }

    public ParcelFileDescriptor getBuddyImage(Context context, long userNo) throws FileNotFoundException {
        ParcelFileDescriptor parcel = null;
        if (checkKey(context) == null) {
            Log.e(TAG, "not allowed access");
        } else {
            String imageUri = "content://com.coolots.chaton/profileImage/" + userNo;
            parcel = null;
            try {
                ContentResolver cr = context.getContentResolver();
                parcel = cr.openFileDescriptor(Uri.parse(imageUri), null);
                if (parcel == null) {
                    Log.e("#######", "parcel is null!!!!!!!");
                }
            } catch (FileNotFoundException e) {
                Log.e("#######", e.toString());
            }
            clearKey(context);
        }
        return parcel;
    }

    public boolean isInstalled(Context context) throws PackageManager.NameNotFoundException {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getApplicationInfo("com.coolots.chaton", 128);
            Log.i(TAG, "isInstalled() true");
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Log.i(TAG, "isInstalled() false");
            return false;
        }
    }

    public boolean isReadyToCall(Context context) {
        if (checkKey(context) == null) {
            Log.e(TAG, "not allowed access");
        } else if (!isInstalled(context)) {
            Log.e(TAG, "ChatON V is not installed");
        } else {
            ContentResolver cr = context.getContentResolver();
            Cursor c = cr.query(Uri.parse("content://com.coolots.chaton/account"), null, null, null, null);
            isLogin = c != null;
            Log.i(TAG, "isReadyToCall() " + isLogin);
            if (c != null) {
                c.close();
            }
        }
        return isLogin;
    }

    public int outgoingCall(Context context, boolean isVideoCall, String samsungAccount) {
        if (!isInstalled(context)) {
            Log.e(TAG, "ChatON V is not installed");
            return 2;
        }
        if (samsungAccount == null || samsungAccount.isEmpty()) {
            Log.i(TAG, "samsungAccount is empty");
            return 3;
        }
        Log.i(TAG, "outgoingCall() call start");
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setAction(ChatONNativeCallActivity.NATIVE_CONTACT_CALL_ACTION);
        intent.putExtra(ChatONNativeCallActivity.SHORTCUT_USERACCOUNT, samsungAccount);
        intent.putExtra(ChatONNativeCallActivity.SHORTCUT_VIDEOCALL, isVideoCall);
        context.startActivity(intent);
        return 0;
    }

    public static String toString(int returnValue) {
        switch (returnValue) {
            case 0:
                return "RET_CHATONV_SUCCESS";
            case 1:
                return "RET_CHATONV_FAIL";
            case 2:
                return "RET_CHATONV_NOT_INSTALLED";
            case 3:
                return "RET_CHATONV_ID_EMPTY";
            case 4:
                return "RET_CHATONV_UNEXPECTED_ERROR";
            case 5:
                return "RET_CHATONV_NOT_ALLOWED_ACCESS";
            default:
                return "";
        }
    }

    private String checkKey(Context context) {
        ContentValues cv = new ContentValues();
        cv.put("key", context.getPackageName());
        ContentResolver cr = context.getContentResolver();
        Uri uriRet = cr.insert(Uri.parse("content://com.coolots.chaton/key"), cv);
        if (uriRet == null) {
            return null;
        }
        return "";
    }

    private void clearKey(Context context) {
        ContentValues cv = new ContentValues();
        cv.put("key", context.getPackageName());
        ContentResolver cr = context.getContentResolver();
        cr.insert(Uri.parse("content://com.coolots.chaton/key_init"), cv);
    }
}
