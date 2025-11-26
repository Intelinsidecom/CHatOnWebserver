package com.sec.chaton.clientapi;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.clientapi.exception.NotActivatedClientAPIException;
import com.sec.chaton.clientapi.exception.NotAvailableClientAPIException;

/* loaded from: classes.dex */
public class NotificationAPI {
    public static final String CHATROOM_TITLE = "chatroom_title";
    public static final String CHAT_TYPE = "chat_type";
    public static final String INBOX_NO = "inbox_no";
    public static final String MESSAGE = "message";
    public static final String MESSAGE_ID = "message_id";
    public static final String MESSAGE_TYPE = "message_type";
    public static final String PACKAGE_NAME = "packageName";
    public static final String PARTICIPANT_COUNT = "participant_count";
    public static final String RECEIVED_TIME = "received_time";
    public static final String REQUEST_ID = "request_id";
    public static final String RESULT_CODE = "result_code";
    public static final String SENDER_ID = "sender_id";
    public static final String SENDER_NAME = "sender_name";
    public static final String SENDER_PHONENUMBER = "sender_phoneNumber";
    private static final Uri CHATON_PUSH_PROVIDER_URI = Uri.parse("content://com.sec.chaton.provider.chaton3rdApp");
    private static final Uri CHATON_PUSH_PROVIDER_APP_MANAGE_URI = CHATON_PUSH_PROVIDER_URI.buildUpon().appendPath("appmanage").build();
    private static final Uri CHATON_PUSH_PROVIDER_PUSH_MESSAGE_URI = CHATON_PUSH_PROVIDER_APP_MANAGE_URI.buildUpon().appendPath("simple_push_message").build();

    @API(description = "3.0.0", versionCode = 30000093)
    public static Uri register(Context context, String packageName, String messageTypeFlag) throws NotAvailableClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (!UtilityAPI.isAvailableAPI(context, NotificationAPI.class, "register", Context.class, String.class, String.class)) {
            throw new NotAvailableClientAPIException("API isn't available.");
        }
        ContentValues values = new ContentValues();
        values.put(PACKAGE_NAME, packageName);
        if (messageTypeFlag != null) {
            values.put("messageTypeFlag", messageTypeFlag);
        } else {
            values.put("messageTypeFlag", "0");
        }
        return context.getContentResolver().insert(CHATON_PUSH_PROVIDER_APP_MANAGE_URI, values);
    }

    @API(description = "3.0.0", versionCode = 30000093)
    public static int deregister(Context context, String packageName) throws NotAvailableClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (!UtilityAPI.isAvailableAPI(context, NotificationAPI.class, "deregister", Context.class, String.class)) {
            throw new NotAvailableClientAPIException("API isn't available.");
        }
        ContentValues values = new ContentValues();
        values.put(PACKAGE_NAME, packageName);
        int result = context.getContentResolver().delete(CHATON_PUSH_PROVIDER_APP_MANAGE_URI, "packageName=?", new String[]{packageName});
        return result;
    }

    @API(description = "3.0.0", versionCode = 30000093)
    public static Cursor getNotiInfo(Context context, String inbox_no, long message_id) throws NotAvailableClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (UtilityAPI.isAvailableAPI(context, NotificationAPI.class, "getNotiInfo", Context.class, String.class, Long.TYPE)) {
            return context.getContentResolver().query(CHATON_PUSH_PROVIDER_PUSH_MESSAGE_URI, new String[]{INBOX_NO, MESSAGE_ID, "message_type", "message", SENDER_ID, SENDER_NAME, CHATROOM_TITLE, PARTICIPANT_COUNT, CHAT_TYPE, RECEIVED_TIME}, "inbox_no=? AND message_id=?", new String[]{inbox_no, String.valueOf(message_id)}, null);
        }
        throw new NotAvailableClientAPIException("API isn't available.");
    }

    @API(description = "3.0.0", versionCode = 30000000)
    public static void reqFullMessage(Context context, long request_id, String sender_id, String inbox_no, long message_id) throws NotAvailableClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (!UtilityAPI.isAvailableAPI(context, NotificationAPI.class, "reqFullMessage", Context.class, Long.TYPE, String.class, String.class, Long.TYPE)) {
            throw new NotAvailableClientAPIException("API isn't available. please check your ChatON version.");
        }
        Intent intent = new Intent();
        Uri uri = new Uri.Builder().scheme("chaton").build();
        intent.setData(uri);
        intent.setAction("com.sec.chaton.chat.background.REQ_FULL_MESSAGE");
        intent.putExtra(PACKAGE_NAME, context.getPackageName());
        intent.putExtra(REQUEST_ID, request_id);
        intent.putExtra(SENDER_ID, sender_id);
        intent.putExtra(INBOX_NO, inbox_no);
        intent.putExtra(MESSAGE_ID, message_id);
        ChatONAPI.addPassword(context, intent);
        context.sendBroadcast(intent);
    }
}
