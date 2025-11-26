package com.coolots.chaton.common.util;

import android.content.ContentUris;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.PhoneNumberUtil;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class NativeContactUtil {
    private static final String CLASSNAME = "[NativeContactUtil]";
    private static final int MATCH_ENDS_WITH = 2;
    private static final int MATCH_EQUAL = 0;
    private static final int MATCH_INCLUDE = 3;
    private static final int MATCH_STARTS_WITH = 1;
    private static NativeContactUtil instance = new NativeContactUtil();

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private NativeContactUtil() {
        Log.m2963i("[NativeContactUtil] new Instance");
    }

    public static NativeContactUtil getInstance() {
        return instance;
    }

    public Bitmap getChatONContactImageInfo(String phoneNumber) {
        Bitmap image = null;
        Uri contactUri = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI, Uri.encode(phoneNumber));
        Cursor phones = MainApplication.mContext.getContentResolver().query(contactUri, null, null, null, null);
        if (phones != null && phones.moveToFirst()) {
            int contactId_idx = phones.getColumnIndex("contact_id");
            Long contactId = Long.valueOf(phones.getLong(contactId_idx));
            Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, contactId.longValue());
            InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(MainApplication.mContext.getContentResolver(), uri);
            image = input == null ? null : BitmapFactory.decodeStream(input);
        }
        phones.close();
        return image;
    }

    public boolean isNativePhoneBlockedUser(String phoneNumber) {
        Uri AUTOREJECT_CONTENT_URI = Uri.parse("content://com.sec.android.app.callsetting.allcalls/reject_num");
        Cursor cursor = MainApplication.mContext.getContentResolver().query(AUTOREJECT_CONTENT_URI, null, "reject_checked=1", null, null);
        if (cursor != null) {
            try {
                if (cursor.getCount() != 0) {
                    while (cursor.moveToNext()) {
                        String rejectNumber = cursor.getString(cursor.getColumnIndex("reject_number"));
                        int matchCriteria = cursor.getInt(cursor.getColumnIndex("reject_match"));
                        switch (matchCriteria) {
                            case 1:
                                if (startWithMatch(rejectNumber, phoneNumber)) {
                                    cursor.close();
                                    return true;
                                }
                            case 2:
                                if (endWithMatch(rejectNumber, phoneNumber)) {
                                    cursor.close();
                                    return true;
                                }
                            case 3:
                                if (includeMatch(rejectNumber, phoneNumber)) {
                                    cursor.close();
                                    return true;
                                }
                            default:
                                if (exactMatch(rejectNumber, phoneNumber)) {
                                    cursor.close();
                                    return true;
                                }
                        }
                    }
                    return false;
                }
            } finally {
                cursor.close();
            }
        }
        return false;
    }

    private boolean exactMatch(String rejectNumber, String phoneNumber) {
        logI("exactMatch()");
        if (phoneNumber.equals(rejectNumber)) {
            logI("match!!");
            return true;
        }
        PhoneNumberUtil util = new PhoneNumberUtil(phoneNumber);
        String buf = util.getPhoneNumber();
        if (buf.equals(rejectNumber)) {
            logI("match!!");
            return true;
        }
        String buf2 = ChatONStringConvert.getInstance().convertMSISDNfromPhoneNo(phoneNumber);
        if (buf2.equals(rejectNumber)) {
            logI("match!!");
            return true;
        }
        return false;
    }

    private boolean startWithMatch(String rejectNumber, String phoneNumber) {
        logI("startWithMatch()");
        if (phoneNumber.startsWith(rejectNumber)) {
            logI("match!!");
            return true;
        }
        PhoneNumberUtil util = new PhoneNumberUtil(phoneNumber);
        String buf = util.getPhoneNumber();
        if (buf.startsWith(rejectNumber)) {
            logI("match!!");
            return true;
        }
        String buf2 = ChatONStringConvert.getInstance().convertMSISDNfromPhoneNo(phoneNumber);
        if (buf2.startsWith(rejectNumber)) {
            logI("match!!");
            return true;
        }
        return false;
    }

    private boolean endWithMatch(String rejectNumber, String phoneNumber) {
        logI("endWithMatch()");
        if (phoneNumber.endsWith(rejectNumber)) {
            logI("match!!");
            return true;
        }
        PhoneNumberUtil util = new PhoneNumberUtil(phoneNumber);
        String buf = util.getPhoneNumber();
        if (buf.endsWith(rejectNumber)) {
            logI("match!!");
            return true;
        }
        String buf2 = ChatONStringConvert.getInstance().convertMSISDNfromPhoneNo(phoneNumber);
        if (buf2.endsWith(rejectNumber)) {
            logI("match!!");
            return true;
        }
        return false;
    }

    private boolean includeMatch(String rejectNumber, String phoneNumber) {
        logI("includeMatch()");
        if (phoneNumber.contains(rejectNumber)) {
            logI("match!!");
            return true;
        }
        PhoneNumberUtil util = new PhoneNumberUtil(phoneNumber);
        String buf = util.getPhoneNumber();
        if (buf.contains(rejectNumber)) {
            logI("match!!");
            return true;
        }
        String buf2 = ChatONStringConvert.getInstance().convertMSISDNfromPhoneNo(phoneNumber);
        if (buf2.contains(rejectNumber)) {
            logI("match!!");
            return true;
        }
        return false;
    }

    public boolean isNativePhoneBlockedUserByUserID(String userID) {
        return isNativePhoneBlockedUser(ChatONStringConvert.getInstance().removeAfterAt(userID));
    }
}
