package com.sec.chaton.clientapi;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class ChatONAPI {
    static final Uri ACCESS_TOKEN_PROVIDER_URI = Uri.parse("content://com.sec.chaton.access_token.provider");
    static final String ACTION_FILE = "file";
    protected static final String DATA_PREFIX = "chaton://";
    protected static final String EXTRA_KEY_RECEIVER = "receiver";
    public static final int RESULT_CODE_FAILED = 0;
    public static final int RESULT_CODE_FAIL_ADD_BUDDY_USER_SELF = 101;
    public static final int RESULT_CODE_FAIL_ALREADY_ADDED_BUDDY = 102;
    public static final int RESULT_CODE_FAIL_API_NOT_AVAILABLE = 2;
    public static final int RESULT_CODE_FAIL_BLOCKED_BUDDY = 103;
    public static final int RESULT_CODE_FAIL_EXCEPTION = 3;
    public static final int RESULT_CODE_FAIL_EXCEPTION_ACTIVITY_NOT_FOUND = 4;
    public static final int RESULT_CODE_FAIL_EXCEPTION_ILLEGAL_ARGUMENT = 7;
    public static final int RESULT_CODE_FAIL_EXCEPTION_UNSUPPOERT_ENCODING = 5;
    public static final int RESULT_CODE_FAIL_INVALID_PHONE_NUMBER = 104;
    public static final int RESULT_CODE_FAIL_INVALID_USER = 100;
    public static final int RESULT_CODE_FAIL_MULTIMEDIA_LIMIT_EXCEEDED = 8;
    public static final int RESULT_CODE_FAIL_TEXT_LIMIT_EXCEEDED = 6;
    public static final int RESULT_CODE_INITIALIZE_CONNECTION_FAILED = 9;
    public static final int RESULT_CODE_INVALID_ACCESS_KEY = 3;
    public static final int RESULT_CODE_INVALID_CHAT_TYPE = 5;
    public static final int RESULT_CODE_INVALID_CONTENT = 11;
    public static final int RESULT_CODE_INVALID_MEDIA_TYPE = 6;
    public static final int RESULT_CODE_INVALID_MESSAGE_ID = 10;
    public static final int RESULT_CODE_INVALID_MULTIMEDIA_DATA = 9;
    public static final int RESULT_CODE_INVALID_RECEIVER_LIST = 13;
    public static final int RESULT_CODE_INVALID_REQUEST = 4;
    public static final int RESULT_CODE_MESSAGE_QUEUE_CREATE_FAILED = 7;
    public static final int RESULT_CODE_MESSAGE_QUEUE_FULL = 8;
    public static final int RESULT_CODE_NETWORK_NOT_AVAILABLE = 2;
    public static final int RESULT_CODE_NOT_SUPPORT_MEDIA = 12;
    public static final int RESULT_CODE_SUCCESS = 1;

    public enum MimeType {
        unknown(""),
        text("text/*"),
        image("image/*"),
        video("video/*"),
        audio("audio/*");

        private String value;

        MimeType(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    @Deprecated
    static Intent openMessageChatRoom(Context context, String receiver) {
        return getActivityIntent(context, null, null, null, receiver, null);
    }

    @Deprecated
    static Intent openMessageChatRoomWithDialog(Context context, String receiver, String action) {
        return getActivityIntent(context, null, null, null, receiver, action);
    }

    @Deprecated
    static Intent sendMessageContent(Context context, MimeType mimeType, String text, Uri stream) {
        return getActivityIntent(context, mimeType, text, stream, null, null);
    }

    @Deprecated
    static Intent sendMessageContent(Context context, MimeType mimeType, String text, Uri stream, String receiver) {
        return getActivityIntent(context, mimeType, text, stream, receiver, null);
    }

    protected static Intent getActivityIntent(Context context, MimeType mimeType, String extraText, Uri extraStream, String receiver, String action) {
        Uri data;
        Intent i = new Intent("android.intent.action.SEND");
        if (action == null) {
            data = Uri.parse(DATA_PREFIX);
        } else {
            data = Uri.parse(DATA_PREFIX + action);
        }
        if (mimeType != null && (!TextUtils.isEmpty(extraText) || extraStream != null)) {
            i.setDataAndType(data, mimeType.getValue());
        } else {
            i.setData(data);
        }
        if (!TextUtils.isEmpty(extraText)) {
            i.putExtra("android.intent.extra.TEXT", extraText);
        }
        if (extraStream != null) {
            i.putExtra("android.intent.extra.STREAM", extraStream);
        }
        if (!TextUtils.isEmpty(receiver)) {
            i.putExtra(EXTRA_KEY_RECEIVER, receiver);
        }
        if (receiver != null && (!TextUtils.isEmpty(extraText) || extraStream != null)) {
            addPassword(context, i);
        }
        i.setFlags(268435456);
        return i;
    }

    protected static void addPassword(Context context, Intent intent) {
        Uri returnUri = context.getContentResolver().insert(ACCESS_TOKEN_PROVIDER_URI, new ContentValues());
        intent.putExtra("password", returnUri.getLastPathSegment());
    }
}
