package com.sec.chaton.clientapi;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.clientapi.ChatONAPI;
import com.sec.chaton.clientapi.ChatONMessage;
import com.sec.chaton.clientapi.exception.FileSizeLimitExceededClientAPIException;
import com.sec.chaton.clientapi.exception.IllegalArgumentClientAPIException;
import com.sec.chaton.clientapi.exception.NotActivatedClientAPIException;
import com.sec.chaton.clientapi.exception.NotAvailableClientAPIException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class MessageAPI {
    private static final String EXTRA_KEY_PACKAGE_NAME = "packageName";
    private static final String EXTRA_KEY_SKIP_SPLASH = "skipSplash";
    protected static final int MAX_LENGTH_TEXT = 2000;
    protected static final long MAX_SIZE_IMAGE_VIDEO = 10485760;
    public static final String PARTICIPANT_ID = "participantId";
    public static final String PARTICIPANT_NAME = "participantName";
    private static final Uri CHATON_PUSH_PROVIDER_URI = Uri.parse("content://com.sec.chaton.provider.chaton3rdApp");
    private static final Uri CHATON_PUSH_PROVIDER_APP_MANAGE_URI = CHATON_PUSH_PROVIDER_URI.buildUpon().appendPath("appmanage").build();
    private static final Uri CHATON_PUSH_PROVIDER_PARTICIPANT_LIST = CHATON_PUSH_PROVIDER_APP_MANAGE_URI.buildUpon().appendPath("participant_list").build();

    @API(description = "1.10.0", versionCode = 11000000)
    public static int openChatRoom(Context context, String[] recipients) {
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "openChatRoom", Context.class, String[].class)) {
            return 2;
        }
        ChatONMessage.Builder builder = new ChatONMessage.Builder();
        builder.setAction("open").setContext(context).setRecipients(recipients);
        if (recipients.length == 1) {
            builder.setChatType(ChatONMessage.ChatType.ONETOONE);
        } else {
            builder.setChatType(ChatONMessage.ChatType.GROUPCHAT);
        }
        try {
            ChatONMessage msg = builder.build();
            Intent i = msg.getIntent();
            i.putExtra("packageName", context.getPackageName());
            context.startActivity(i);
            return 1;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return 4;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return 5;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return 7;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 3;
        }
    }

    @API(description = "1.10.0", versionCode = 11000000)
    public static int sendTextMessage(Context context, String text) {
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "sendTextMessage", Context.class, String.class)) {
            return 2;
        }
        if (text.length() > 2000) {
            return 6;
        }
        ChatONMessage.Builder builder = new ChatONMessage.Builder();
        builder.setAction("send").setContext(context).setContentType(ChatONMessage.contentType.text).setMsg(text).setMimeType(ChatONAPI.MimeType.text);
        try {
            ChatONMessage msg = builder.build();
            Intent i = msg.getIntent();
            i.putExtra("packageName", context.getPackageName());
            context.startActivity(i);
            return 1;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return 4;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return 5;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return 7;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 3;
        }
    }

    @API(description = "1.10.0", versionCode = 11000000)
    public static int sendTextMessage(Context context, String[] recipients, String text) {
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "sendTextMessage", Context.class, String[].class, String.class)) {
            return 2;
        }
        if (text.length() > 2000) {
            return 6;
        }
        ChatONMessage.Builder builder = new ChatONMessage.Builder();
        builder.setAction("send").setContext(context).setRecipients(recipients).setContentType(ChatONMessage.contentType.text).setMsg(text).setRequiredAccessToken(true).setMimeType(ChatONAPI.MimeType.text);
        try {
            ChatONMessage msg = builder.build();
            Intent i = msg.getIntent();
            i.putExtra("packageName", context.getPackageName());
            context.startActivity(i);
            return 1;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return 4;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return 5;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return 7;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 3;
        }
    }

    @API(description = "1.10.0", versionCode = 11000000)
    public static int sendTextMessageWithURL(Context context, String[] recipients, String text, String url) {
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "sendTextMessageWithURL", Context.class, String[].class, String.class, String.class)) {
            return 2;
        }
        StringBuilder tempMessage = new StringBuilder(url);
        tempMessage.append("\n\n").append(text);
        if (tempMessage.length() > 2000) {
            return 6;
        }
        ChatONMessage.Builder builder = new ChatONMessage.Builder();
        builder.setAction("send").setContext(context).setRecipients(recipients).setContentType(ChatONMessage.contentType.text_url).setMsg(text).setUri(url).setMimeType(ChatONAPI.MimeType.text).setRequiredAccessToken(true);
        try {
            ChatONMessage msg = builder.build();
            Intent i = msg.getIntent();
            i.putExtra("packageName", context.getPackageName());
            context.startActivity(i);
            return 1;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return 4;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return 5;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return 7;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 3;
        }
    }

    @API(description = "1.10.0", versionCode = 11000000)
    public static int sendTextMessageWithURL(Context context, String text, String url) {
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "sendTextMessageWithURL", Context.class, String.class, String.class)) {
            return 2;
        }
        StringBuilder tempMessage = new StringBuilder(url);
        tempMessage.append("\n\n").append(text);
        if (tempMessage.length() > 2000) {
            return 6;
        }
        ChatONMessage.Builder builder = new ChatONMessage.Builder();
        builder.setAction("send").setContext(context).setContentType(ChatONMessage.contentType.text_url).setMsg(text).setUri(url).setMimeType(ChatONAPI.MimeType.text);
        try {
            ChatONMessage msg = builder.build();
            Intent i = msg.getIntent();
            i.putExtra("packageName", context.getPackageName());
            context.startActivity(i);
            return 1;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return 4;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return 5;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return 7;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 3;
        }
    }

    private static int CheckMultiMediaValidation(Context context, Uri uri) {
        String fileName = null;
        if ("content".equals(uri.getScheme())) {
            try {
                Cursor oCursor = context.getContentResolver().query(uri, null, null, null, null);
                if (oCursor != null) {
                    while (oCursor.moveToNext()) {
                        int columnIndex = oCursor.getColumnIndex("_data");
                        if (columnIndex != -1) {
                            fileName = oCursor.getString(columnIndex);
                        }
                    }
                    oCursor.close();
                }
            } catch (SecurityException e) {
                e.printStackTrace();
                return 3;
            }
        } else {
            if (!"file".equals(uri.getScheme())) {
                return 9;
            }
            fileName = uri.getPath();
        }
        File file = new File(fileName);
        if (file == null || file.length() == 0) {
            return 9;
        }
        if (file.length() > MAX_SIZE_IMAGE_VIDEO) {
            return 8;
        }
        return 1;
    }

    @API(description = "1.10.0", versionCode = 11000000)
    public static int sendMultiMediaMessage(Context context, Uri uri, ChatONAPI.MimeType mimeType) {
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "sendMultiMediaMessage", Context.class, Uri.class, ChatONAPI.MimeType.class)) {
            return 2;
        }
        if (uri == null || !(mimeType == ChatONAPI.MimeType.image || mimeType == ChatONAPI.MimeType.video)) {
            return 7;
        }
        int nCheckResult = CheckMultiMediaValidation(context, uri);
        if (nCheckResult == 1) {
            ChatONMessage.Builder builder = new ChatONMessage.Builder();
            builder.setAction("send").setContext(context).setContentType(ChatONMessage.contentType.multimedia).setUri(uri.toString()).setMimeType(mimeType);
            try {
                ChatONMessage msg = builder.build();
                Intent i = msg.getIntent();
                i.putExtra("packageName", context.getPackageName());
                context.startActivity(i);
                return 1;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                return 4;
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return 5;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return 7;
            } catch (Exception e4) {
                e4.printStackTrace();
                return 3;
            }
        }
        return nCheckResult;
    }

    @API(description = "1.10.0", versionCode = 11000000)
    public static int sendMultiMediaMessage(Context context, String[] recipients, Uri uri, ChatONAPI.MimeType mimeType) {
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "sendMultiMediaMessage", Context.class, String[].class, Uri.class, ChatONAPI.MimeType.class)) {
            return 2;
        }
        int nCheckResult = CheckMultiMediaValidation(context, uri);
        if (nCheckResult == 1) {
            ChatONMessage.Builder builder = new ChatONMessage.Builder();
            builder.setAction("send").setContext(context).setRecipients(recipients).setContentType(ChatONMessage.contentType.multimedia).setUri(uri.toString()).setMimeType(mimeType).setRequiredAccessToken(true);
            try {
                ChatONMessage msg = builder.build();
                Intent i = msg.getIntent();
                i.putExtra("packageName", context.getPackageName());
                context.startActivity(i);
                return 1;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                return 4;
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return 5;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return 7;
            } catch (Exception e4) {
                e4.printStackTrace();
                return 3;
            }
        }
        return nCheckResult;
    }

    @API(description = "1.10.0", versionCode = 11000000)
    public static int sendMultiMediaMessageWithText(Context context, Uri uri, ChatONAPI.MimeType mimeType, String text) {
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "sendMultiMediaMessageWithText", Context.class, Uri.class, ChatONAPI.MimeType.class, String.class)) {
            return 2;
        }
        if (text.length() > 2000) {
            return 6;
        }
        int nCheckResult = CheckMultiMediaValidation(context, uri);
        if (nCheckResult == 1) {
            ChatONMessage.Builder builder = new ChatONMessage.Builder();
            builder.setAction("send").setContext(context).setContentType(ChatONMessage.contentType.multimedia_text).setUri(uri.toString()).setMsg(text).setMimeType(mimeType);
            try {
                ChatONMessage msg = builder.build();
                Intent i = msg.getIntent();
                i.putExtra("packageName", context.getPackageName());
                context.startActivity(i);
                return 1;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                return 4;
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return 5;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return 7;
            } catch (Exception e4) {
                e4.printStackTrace();
                return 3;
            }
        }
        return nCheckResult;
    }

    @API(description = "1.10.0", versionCode = 11000000)
    public static int sendMultiMediaMessageWithText(Context context, String[] recipients, Uri uri, ChatONAPI.MimeType mimeType, String text) {
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "sendMultiMediaMessageWithText", Context.class, String[].class, Uri.class, ChatONAPI.MimeType.class, String.class)) {
            return 2;
        }
        if (text.length() > 2000) {
            return 6;
        }
        int nCheckResult = CheckMultiMediaValidation(context, uri);
        if (nCheckResult == 1) {
            ChatONMessage.Builder builder = new ChatONMessage.Builder();
            builder.setAction("send").setContext(context).setRecipients(recipients).setContentType(ChatONMessage.contentType.multimedia_text).setUri(uri.toString()).setMsg(text).setMimeType(mimeType).setRequiredAccessToken(true);
            try {
                ChatONMessage msg = builder.build();
                Intent i = msg.getIntent();
                i.putExtra("packageName", context.getPackageName());
                context.startActivity(i);
                return 1;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                return 4;
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return 5;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return 7;
            } catch (Exception e4) {
                e4.printStackTrace();
                return 3;
            }
        }
        return nCheckResult;
    }

    @API(description = "1.10.0", versionCode = 11000000)
    public static int sendAppLinkMessage(Context context, String text, String appName, String appVersion, List<Map<String, String>> appParamInfo) {
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "sendAppLinkMessage", Context.class, String.class, String.class, String.class, List.class)) {
            return 2;
        }
        if (text.length() > 2000) {
            return 6;
        }
        ChatONMessage.Builder builder = new ChatONMessage.Builder();
        builder.setAction("send").setContext(context).setMsg(text).setAppName(appName).setContentType(ChatONMessage.contentType.app).setAppVer(appVersion).setAppParamInfo(appParamInfo).setMimeType(ChatONAPI.MimeType.text);
        try {
            ChatONMessage msg = builder.build();
            Intent i = msg.getIntent();
            i.putExtra("packageName", context.getPackageName());
            context.startActivity(i);
            return 1;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return 4;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return 5;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return 7;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 3;
        }
    }

    @API(description = "2.0.0", versionCode = 20000000)
    public static void sendTextMessageBG(Context context, long requestId, String[] recipients, String text, boolean isBroadcast) throws NotAvailableClientAPIException, IllegalArgumentClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "sendTextMessageBG", Context.class, Long.TYPE, String[].class, String.class, Boolean.TYPE)) {
            throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
        }
        if (text.length() > 2000) {
            throw new IllegalArgumentClientAPIException();
        }
        Intent intent = new Intent("com.sec.chaton.chat.background.MESSAGE_SEND");
        intent.setData(new Uri.Builder().scheme("chaton").build());
        intent.putExtra(NotificationAPI.REQUEST_ID, requestId);
        if (isBroadcast) {
            intent.putExtra(NotificationAPI.CHAT_TYPE, ChatONMessage.ChatType.BROADCAST.getValue());
        } else if (recipients.length > 1) {
            intent.putExtra(NotificationAPI.CHAT_TYPE, ChatONMessage.ChatType.GROUPCHAT.getValue());
        } else {
            intent.putExtra(NotificationAPI.CHAT_TYPE, ChatONMessage.ChatType.ONETOONE.getValue());
        }
        intent.putExtra("media_type", 0);
        intent.putExtra("content", text);
        intent.putExtra("receivers", recipients);
        intent.putExtra("packageName", context.getPackageName());
        intent.putExtra("apiVer", "1.0");
        intent.putExtra("packageName", context.getPackageName());
        ChatONAPI.addPassword(context, intent);
        context.sendBroadcast(intent);
    }

    @API(description = "2.0.0", versionCode = 20000000)
    public static void sendMultiMediaMessageBG(Context context, long requestId, String[] recipients, Uri uri, ChatONAPI.MimeType mimeType, boolean isBroadcast) throws NotAvailableClientAPIException, IllegalArgumentClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "sendMultiMediaMessageBG", Context.class, Long.TYPE, String[].class, Uri.class, ChatONAPI.MimeType.class, Boolean.TYPE)) {
            throw new NotAvailableClientAPIException("API isn't available. please check your ChatON version.");
        }
        if (uri == null || (mimeType != ChatONAPI.MimeType.image && mimeType != ChatONAPI.MimeType.video && mimeType != ChatONAPI.MimeType.audio)) {
            throw new NotAvailableClientAPIException("API isn't availble. The mimeType isn't supported");
        }
        int nCheckResult = CheckMultiMediaValidation(context, uri);
        if (nCheckResult != 1) {
            if (nCheckResult == 8) {
                throw new FileSizeLimitExceededClientAPIException();
            }
            throw new IllegalArgumentClientAPIException();
        }
        Intent intent = new Intent("com.sec.chaton.chat.background.MESSAGE_SEND");
        intent.setData(new Uri.Builder().scheme("chaton").build());
        intent.putExtra(NotificationAPI.REQUEST_ID, requestId);
        if (isBroadcast) {
            intent.putExtra(NotificationAPI.CHAT_TYPE, 2);
        } else if (recipients.length > 1) {
            intent.putExtra(NotificationAPI.CHAT_TYPE, 1);
        } else {
            intent.putExtra(NotificationAPI.CHAT_TYPE, 0);
        }
        if (mimeType == ChatONAPI.MimeType.image) {
            intent.putExtra("media_type", 1);
        } else if (mimeType == ChatONAPI.MimeType.video) {
            intent.putExtra("media_type", 2);
        } else if (mimeType == ChatONAPI.MimeType.audio) {
            intent.putExtra("media_type", 4);
        }
        intent.putExtra("content", uri.toString());
        intent.putExtra("receivers", recipients);
        intent.putExtra("packageName", context.getPackageName());
        intent.putExtra("apiVer", "1.0");
        intent.putExtra("packageName", context.getPackageName());
        ChatONAPI.addPassword(context, intent);
        context.sendBroadcast(intent);
    }

    @API(description = "2.1.0", versionCode = 20011000)
    public static int openChatRoom(Context context, String[] recipients, boolean isBroadcast) {
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "openChatRoom", Context.class, String[].class, Boolean.TYPE)) {
            return 2;
        }
        ChatONMessage.Builder builder = new ChatONMessage.Builder();
        builder.setAction("open").setContext(context).setRecipients(recipients);
        if (isBroadcast) {
            builder.setChatType(ChatONMessage.ChatType.BROADCAST);
        } else if (recipients.length == 1) {
            builder.setChatType(ChatONMessage.ChatType.ONETOONE);
        } else {
            builder.setChatType(ChatONMessage.ChatType.GROUPCHAT);
        }
        try {
            ChatONMessage msg = builder.build();
            Intent i = msg.getIntent();
            i.putExtra("packageName", context.getPackageName());
            context.startActivity(i);
            return 1;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return 4;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return 5;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return 7;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 3;
        }
    }

    @API(description = "3.0.0", versionCode = 20011000)
    public static void openChatRoomWithInboxNo(Context context, String inboxNo) throws NotAvailableClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "openChatRoomWithInboxNo", Context.class, String.class)) {
            throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
        }
        ChatONMessage.Builder builder = new ChatONMessage.Builder();
        builder.setAction("open").setContext(context).setInboxNo(inboxNo);
        try {
            ChatONMessage msg = builder.build();
            Intent i = msg.getIntent();
            i.putExtra("packageName", context.getPackageName());
            context.startActivity(i);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    @API(description = "3.0.0", versionCode = 20011000)
    public static void openChatList(Context context) throws NotAvailableClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (!UtilityAPI.isAvailableAPI(context, MessageAPI.class, "openChatList", Context.class)) {
            throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
        }
        ChatONMessage.Builder builder = new ChatONMessage.Builder();
        builder.setAction("open").setContext(context).setPath("/chatlist?");
        try {
            ChatONMessage msg = builder.build();
            Intent i = msg.getIntent();
            i.putExtra("packageName", context.getPackageName());
            context.startActivity(i);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    @API(description = "3.0.0", versionCode = 20011000)
    public static Cursor getParticipantList(Context context, String inboxNo) throws NotAvailableClientAPIException, NotActivatedClientAPIException {
        if (!UtilityAPI.isChatONActivated(context)) {
            throw new NotActivatedClientAPIException("ChatON isn't activated.");
        }
        if (UtilityAPI.isAvailableAPI(context, MessageAPI.class, "getParticipantList", Context.class, String.class)) {
            return context.getContentResolver().query(CHATON_PUSH_PROVIDER_PARTICIPANT_LIST, new String[]{PARTICIPANT_ID, PARTICIPANT_NAME}, "inbox_no=?", new String[]{inboxNo}, "participantName ASC");
        }
        throw new NotAvailableClientAPIException("API isn't availble. please check your ChatON version.");
    }
}
