package com.sec.chaton.clientapi;

import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.sec.chaton.clientapi.exception.IllegalArgumentClientAPIException;
import com.sec.chaton.clientapi.exception.NotActivatedClientAPIException;
import com.sec.chaton.clientapi.exception.NotAvailableClientAPIException;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public class GraphAPI {
    public static final String BUDDY_BIRTHDAY = "buddy_birthday";
    public static final String BUDDY_NAME = "buddy_name";
    public static final String BUDDY_NO = "buddy_no";
    public static final String BUDDY_ORGINAL_NUMBERS = "buddy_orginal_numbers";
    public static final String BUDDY_SAMSUNG_ACCOUNT = "buddy_samsung_email";
    public static final String BUDDY_STATUS_MESSAGE = "buddy_status_message";
    protected static final String CHATON_ACTION_ADD_BUDDY = "com.sec.chaton.action.ADD_BUDDY";
    protected static final String CHATON_ACTION_ADD_BUDDY_BACKGROUND = "com.sec.chaton.api.background.ADD_BUDDY";
    protected static final String CHATON_ACTION_VIEW_BUDDY = "com.sec.chaton.action.VIEW_BUDDY";
    protected static final String DATA_PREFIX = "chaton://";
    protected static final String EXTRA_KEY_API_VER = "apiVer";
    protected static final String EXTRA_KEY_EXCEPT = "except";
    protected static final String EXTRA_KEY_ID = "id";
    protected static final String EXTRA_KEY_IS_CHATONID = "isChatONId";
    protected static final String EXTRA_KEY_MAX_COUNT = "max";
    private static final String EXTRA_KEY_PACKAGE_NAME = "packageName";
    protected static final String EXTRA_KEY_PROFILE_BUDDY_NO = "PROFILE_BUDDY_NO";
    protected static final String EXTRA_KEY_REQUEST_ID = "request_id";
    protected static final String EXTRA_KEY_REQUIRE = "require";
    protected static final String EXTRA_KEY_SINGLE = "single";
    private static final String EXTRA_KEY_SKIP_SPLASH = "skipSplash";
    public static final String ME_COUNTRY_ISO_CODE = "country_iso_code";
    public static final String ME_COUNTRY_NUM = "country_num";
    public static final String ME_ID = "id";
    public static final String ME_NAME = "name";
    protected static final Uri ACCESS_TOKEN_PROVIDER_URI = Uri.parse("content://com.sec.chaton.access_token.provider");
    protected static final Uri BUDDY_URI = Uri.parse("content://com.sec.chaton.provider/buddy");
    protected static final Uri BUDDYGROUP_URI = Uri.parse("content://com.sec.chaton.provider/buddy_group");
    protected static final Uri ME_URI = Uri.parse("content://com.sec.chaton.provider/me");
    protected static final Uri GROUP_RELATION_BUDDY_IN_URI = Uri.parse("content://com.sec.chaton.provider/grouprelation/buddy_in");

    protected static void addPassword(Context context, Intent intent) {
        Uri returnUri = context.getContentResolver().insert(ACCESS_TOKEN_PROVIDER_URI, new ContentValues());
        intent.putExtra("password", returnUri.getLastPathSegment());
    }

    @API(description = "1.10.0", versionCode = 11000000)
    public static Cursor getBuddyList(Context context, String selection, String[] selectionArgs, String sortOrder) throws NotAvailableClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (UtilityAPI.isAvailableAPI(context, GraphAPI.class, "getBuddyList", Context.class, String.class, String[].class, String.class)) {
            return context.getContentResolver().query(BUDDY_URI, new String[]{BUDDY_NO, BUDDY_NAME, BUDDY_STATUS_MESSAGE, BUDDY_ORGINAL_NUMBERS, BUDDY_SAMSUNG_ACCOUNT, BUDDY_BIRTHDAY}, selection, selectionArgs, sortOrder);
        }
        throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
    }

    @API(description = "1.10.0", versionCode = 11000000)
    public static Bitmap getBuddyProfileImage(Context context, String buddyNo) throws NotAvailableClientAPIException, IllegalArgumentClientAPIException, NotActivatedClientAPIException, IOException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (!UtilityAPI.isAvailableAPI(context, GraphAPI.class, "getBuddyProfileImage", Context.class, String.class)) {
            throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
        }
        if (TextUtils.isEmpty(buddyNo)) {
            throw new IllegalArgumentClientAPIException("buddyNo's length must be greater than or equals to 1.");
        }
        if (buddyNo.length() > 100) {
            throw new IllegalArgumentClientAPIException("buddyNo's length must not be more than 100");
        }
        Bitmap bitmap = null;
        ParcelFileDescriptor pfdInput = null;
        try {
            try {
                pfdInput = context.getContentResolver().openFileDescriptor(Uri.withAppendedPath(BUDDY_URI, "buddy_no/" + buddyNo), "r");
                if (pfdInput != null) {
                    bitmap = BitmapFactory.decodeFileDescriptor(pfdInput.getFileDescriptor(), null, null);
                }
                if (pfdInput != null) {
                    try {
                        pfdInput.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                if (pfdInput != null) {
                    try {
                        pfdInput.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return bitmap;
        } catch (Throwable th) {
            if (pfdInput != null) {
                try {
                    pfdInput.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    @API(description = "1.10.0", versionCode = 11000000)
    public static Cursor getMyProfile(Context context) throws NotAvailableClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isAvailableAPI(context, GraphAPI.class, "getMyProfile", Context.class)) {
            throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
        }
        Cursor cursor = null;
        try {
            Cursor cursor2 = context.getContentResolver().query(ME_URI, new String[]{"id", ME_NAME, ME_COUNTRY_NUM, ME_COUNTRY_ISO_CODE}, null, null, null);
            if (cursor2 == null || cursor2.getCount() == 0) {
                throw new NotActivatedClientAPIException("ChatON isn't activated.");
            }
            if (cursor2.moveToNext()) {
                String id = cursor2.getString(cursor2.getColumnIndex("id"));
                if (TextUtils.isEmpty(id)) {
                    throw new NotActivatedClientAPIException("ChatON isn't activated.");
                }
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

    @API(description = "1.10.0", versionCode = 11000000)
    public static Intent pickBuddy(Context context, String[] exceptBuddies, int maxCount) throws NotAvailableClientAPIException {
        if (!UtilityAPI.isAvailableAPI(context, GraphAPI.class, "pickBuddy", Context.class, String[].class, Integer.TYPE)) {
            throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
        }
        Intent i = new Intent("android.intent.action.PICK", Uri.parse(DATA_PREFIX));
        if (maxCount > 0) {
            i.putExtra(EXTRA_KEY_MAX_COUNT, maxCount);
        }
        i.putExtra(EXTRA_KEY_SINGLE, false);
        if (exceptBuddies != null && exceptBuddies.length > 0) {
            i.putExtra(EXTRA_KEY_EXCEPT, exceptBuddies);
        }
        i.putExtra("packageName", context.getPackageName());
        return i;
    }

    @API(description = "1.10.0", versionCode = 11000000)
    public static int addBuddy(Context context, String id) {
        if (!UtilityAPI.isAvailableAPI(context, GraphAPI.class, "addBuddy", Context.class, String.class)) {
            return 2;
        }
        if (TextUtils.isEmpty(id) || id.length() > 100) {
            return 7;
        }
        try {
            Intent i = new Intent(CHATON_ACTION_ADD_BUDDY);
            if (!TextUtils.isEmpty(id)) {
                i.putExtra("id", id);
                i.putExtra(EXTRA_KEY_SKIP_SPLASH, true);
                addPassword(context, i);
            }
            i.putExtra("packageName", context.getPackageName());
            context.startActivity(i);
            return 1;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return 4;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 3;
        }
    }

    @API(description = "2.0.0", versionCode = 20000000)
    public static void addBuddyBackground(Context context, long requestId, String phonenoOrEmail) throws NotAvailableClientAPIException, IllegalArgumentClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (!UtilityAPI.isAvailableAPI(context, GraphAPI.class, "addBuddyBackground", Context.class, Long.TYPE, String.class)) {
            throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
        }
        if (TextUtils.isEmpty(phonenoOrEmail)) {
            throw new IllegalArgumentClientAPIException("buddyId's length must be greater than or equals to 1.");
        }
        if (phonenoOrEmail.length() > 100) {
            throw new IllegalArgumentClientAPIException("buddyId's length must not be more than 100");
        }
        Intent intent = new Intent(CHATON_ACTION_ADD_BUDDY_BACKGROUND, Uri.parse(DATA_PREFIX));
        intent.putExtra("packageName", context.getPackageName());
        intent.putExtra(EXTRA_KEY_API_VER, "1.0");
        intent.putExtra("request_id", requestId);
        intent.putExtra("id", phonenoOrEmail);
        addPassword(context, intent);
        context.sendBroadcast(intent);
    }

    @API(description = "2.0.0", versionCode = 20000000)
    public static Intent viewBuddyProfile(Context context, String buddyNo) throws NotAvailableClientAPIException, IllegalArgumentClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (!UtilityAPI.isAvailableAPI(context, GraphAPI.class, "viewBuddyProfile", Context.class, String.class)) {
            throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
        }
        if (TextUtils.isEmpty(buddyNo)) {
            throw new IllegalArgumentClientAPIException("buddyId's length must be greater than or equals to 1.");
        }
        if (buddyNo.length() > 100) {
            throw new IllegalArgumentClientAPIException("buddyId's length must not be more than 100");
        }
        Intent i = new Intent(CHATON_ACTION_VIEW_BUDDY);
        try {
            if (!TextUtils.isEmpty(buddyNo)) {
                i.putExtra(EXTRA_KEY_PROFILE_BUDDY_NO, buddyNo);
                i.putExtra(EXTRA_KEY_SKIP_SPLASH, true);
                addPassword(context, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        i.putExtra("packageName", context.getPackageName());
        return i;
    }

    @API(description = "2.1.0", versionCode = 20011000)
    public static Intent pickBuddy(Context context, String[] exceptBuddies, String require, int maxCount) throws NotAvailableClientAPIException {
        if (!UtilityAPI.isAvailableAPI(context, GraphAPI.class, "pickBuddy", Context.class, String[].class, String.class, Integer.TYPE)) {
            throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
        }
        Intent i = new Intent("android.intent.action.PICK", Uri.parse(DATA_PREFIX));
        if (maxCount > 0) {
            i.putExtra(EXTRA_KEY_MAX_COUNT, maxCount);
        }
        i.putExtra(EXTRA_KEY_SINGLE, false);
        if (!TextUtils.isEmpty(require)) {
            i.putExtra(EXTRA_KEY_REQUIRE, require);
        }
        if (exceptBuddies != null && exceptBuddies.length > 0) {
            i.putExtra(EXTRA_KEY_EXCEPT, exceptBuddies);
        }
        i.putExtra("packageName", context.getPackageName());
        return i;
    }

    @API(description = "2.3.0", versionCode = 20300000)
    public static Bitmap getGroupProfileImage(Context context, String groupName) throws NotAvailableClientAPIException, IllegalArgumentClientAPIException, NotActivatedClientAPIException, IOException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (!UtilityAPI.isAvailableAPI(context, GraphAPI.class, "getGroupProfileImage", Context.class, String.class)) {
            throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
        }
        if (TextUtils.isEmpty(groupName)) {
            throw new IllegalArgumentClientAPIException("groupName's length must be greater than or equals to 1.");
        }
        Bitmap bitmap = null;
        ParcelFileDescriptor pfdInput = null;
        try {
            try {
                pfdInput = context.getContentResolver().openFileDescriptor(Uri.withAppendedPath(BUDDYGROUP_URI, "group_name/" + groupName), "r");
                if (pfdInput != null) {
                    bitmap = BitmapFactory.decodeFileDescriptor(pfdInput.getFileDescriptor(), null, null);
                }
                if (pfdInput != null) {
                    try {
                        pfdInput.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                if (pfdInput != null) {
                    try {
                        pfdInput.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return bitmap;
        } catch (Throwable th) {
            if (pfdInput != null) {
                try {
                    pfdInput.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    @API(description = "2.6.12", versionCode = 20612000)
    public static void addBuddyBackgroundById(Context context, long requestId, String chatonId) throws NotAvailableClientAPIException, IllegalArgumentClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (!UtilityAPI.isAvailableAPI(context, GraphAPI.class, "addBuddyBackgroundById", Context.class, Long.TYPE, String.class)) {
            throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
        }
        if (TextUtils.isEmpty(chatonId)) {
            throw new IllegalArgumentClientAPIException("buddyId's length must be greater than or equals to 1.");
        }
        if (chatonId.length() > 20) {
            throw new IllegalArgumentClientAPIException("buddyId's length must not be more than 100");
        }
        Intent intent = new Intent(CHATON_ACTION_ADD_BUDDY_BACKGROUND, Uri.parse(DATA_PREFIX));
        intent.putExtra("packageName", context.getPackageName());
        intent.putExtra(EXTRA_KEY_API_VER, "1.0");
        intent.putExtra("request_id", requestId);
        intent.putExtra("id", chatonId);
        intent.putExtra(EXTRA_KEY_IS_CHATONID, true);
        addPassword(context, intent);
        context.sendBroadcast(intent);
    }

    @API(description = "2.7.0", versionCode = 20700000)
    public static Cursor getFavoriteBuddyList(Context context, String sortOrder) throws NotAvailableClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (UtilityAPI.isAvailableAPI(context, GraphAPI.class, "getFavoriteBuddyList", Context.class, String.class)) {
            return context.getContentResolver().query(GROUP_RELATION_BUDDY_IN_URI, new String[]{BUDDY_NO, BUDDY_NAME, BUDDY_STATUS_MESSAGE}, "group_relation_group = 1", null, sortOrder);
        }
        throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
    }
}
