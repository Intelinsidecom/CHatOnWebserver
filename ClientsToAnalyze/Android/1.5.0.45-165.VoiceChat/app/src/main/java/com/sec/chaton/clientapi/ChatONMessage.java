package com.sec.chaton.clientapi;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gcm.GCMConstants;
import com.sec.chaton.clientapi.ChatONAPI;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class ChatONMessage {
    protected static final String CHATON_HOST = "com.sec.chaton";
    protected static final String CHATON_PATH_CHAT = "/chat?";
    protected static final String CHATON_PATH_CHATLIST = "/chatlist?";
    protected static final String CHATON_SCHEME = "chaton://";
    static final Charset ChatONMessageCharset = Charset.forName("UTF-8");
    static final String ChatONMessageEncoding = ChatONMessageCharset.name();
    protected String action;
    protected String apiver;
    protected String appName;
    protected List<Map<String, String>> appParamInfo;
    protected String appVersion;
    protected ChatType chatType;
    protected Context context;
    protected String encoding;
    protected String inboxNo;
    protected Intent intent;
    protected ChatONAPI.MimeType mimeType;
    protected String msg;
    protected String path;
    protected List<String> recipients;
    protected boolean requiredAccessToken;
    protected contentType type;
    protected String uri;

    public enum contentType {
        unknown("unknown"),
        text("text"),
        multimedia("multimedia"),
        url("url"),
        multimedia_text("multimedia_text"),
        text_url("text_url"),
        app(GCMConstants.EXTRA_APPLICATION_PENDING_INTENT),
        app_multimedia("app_multimedia"),
        app_url("app_url");

        private String value;

        contentType(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum ChatType {
        UNKNOWN(-1),
        ONETOONE(0),
        GROUPCHAT(1),
        BROADCAST(2);

        private int value;

        ChatType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class Builder {
        protected String action;
        protected String appName;
        protected String appVersion;
        protected Context context;
        protected String inboxNo;
        protected String msg;
        protected List<String> recipients;
        protected String uri;
        protected ChatType chatType = ChatType.UNKNOWN;
        protected String path = ChatONMessage.CHATON_PATH_CHAT;
        protected String apiver = "2.0";
        protected contentType type = contentType.unknown;
        protected ChatONAPI.MimeType mimeType = ChatONAPI.MimeType.unknown;
        protected List<Map<String, String>> appParamInfo = null;
        protected String encoding = "UTF-8";
        protected boolean requiredAccessToken = false;

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        public Builder setChatType(ChatType chatType) {
            this.chatType = chatType;
            return this;
        }

        public Builder setRecipients(String[] recipients) {
            if (this.recipients == null) {
                this.recipients = new ArrayList();
            } else if (this.recipients.size() > 0) {
                this.recipients.clear();
            }
            for (String str : recipients) {
                this.recipients.add(str);
            }
            return this;
        }

        public Builder setInboxNo(String inboxNo) {
            this.inboxNo = inboxNo;
            return this;
        }

        public Builder setApiVer(String apiver) {
            this.apiver = apiver;
            return this;
        }

        public Builder setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder setAction(String action) {
            this.action = action;
            return this;
        }

        public Builder setUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder setContentType(contentType type) {
            this.type = type;
            return this;
        }

        public Builder setMimeType(ChatONAPI.MimeType mimeType) {
            this.mimeType = mimeType;
            return this;
        }

        public Builder setAppName(String appName) {
            this.appName = appName;
            return this;
        }

        public Builder setAppVer(String appVersion) {
            this.appVersion = appVersion;
            return this;
        }

        public Builder setAppParamInfo(List<Map<String, String>> appParamInfo) {
            this.appParamInfo = appParamInfo;
            return this;
        }

        public Builder setEncoding(String encoding) {
            this.encoding = encoding;
            return this;
        }

        public Builder setRequiredAccessToken(boolean requiredAccessToken) {
            this.requiredAccessToken = requiredAccessToken;
            return this;
        }

        public ChatONMessage build() throws IllegalArgumentException, UnsupportedEncodingException {
            return new ChatONMessage(this);
        }
    }

    protected ChatONMessage(Builder builder) throws JSONException, IllegalArgumentException, UnsupportedEncodingException {
        this.chatType = ChatType.UNKNOWN;
        this.path = CHATON_PATH_CHAT;
        this.appParamInfo = null;
        this.encoding = "UTF-8";
        this.chatType = builder.chatType;
        this.recipients = builder.recipients;
        this.inboxNo = builder.inboxNo;
        this.context = builder.context;
        this.path = builder.path;
        this.apiver = builder.apiver;
        this.msg = builder.msg;
        this.action = builder.action;
        this.uri = builder.uri;
        this.type = builder.type;
        this.mimeType = builder.mimeType;
        this.appName = builder.appName;
        this.appVersion = builder.appVersion;
        this.appParamInfo = builder.appParamInfo;
        this.encoding = builder.encoding;
        this.requiredAccessToken = builder.requiredAccessToken;
        if ((this.type == contentType.text || this.type == contentType.app) && TextUtils.isEmpty(this.msg)) {
            throw new IllegalArgumentException("text message is empty");
        }
        if (this.path.equals(CHATON_PATH_CHAT)) {
            if ("open".equals(this.action) && ((this.recipients == null || this.recipients.size() == 0) && TextUtils.isEmpty(this.inboxNo))) {
                throw new IllegalArgumentException("recipient list is empty");
            }
            if (!"open".equals(this.action) && this.type == contentType.unknown) {
                throw new IllegalArgumentException("invalid content type");
            }
        }
        this.intent = new Intent("android.intent.action.SEND");
        makeChatONMessage();
    }

    protected void makeChatONMessage() throws JSONException, UnsupportedEncodingException {
        StringBuilder uriString = new StringBuilder();
        uriString.append(CHATON_SCHEME).append(CHATON_HOST).append(this.path);
        uriString.append("apiver=").append(URLEncoder.encode(this.apiver, ChatONMessageEncoding));
        uriString.append("&action=").append(URLEncoder.encode(this.action, ChatONMessageEncoding));
        if (this.type != contentType.unknown) {
            uriString.append("&type=").append(URLEncoder.encode(this.type.getValue(), ChatONMessageEncoding));
        }
        if (this.mimeType != ChatONAPI.MimeType.unknown) {
            uriString.append("&mime=").append(URLEncoder.encode(this.mimeType.getValue(), ChatONMessageEncoding));
        }
        if (!TextUtils.isEmpty(this.msg)) {
            Charset charset = Charset.forName(this.encoding);
            if (!ChatONMessageCharset.equals(charset)) {
                this.msg = new String(this.msg.getBytes(charset.name()), ChatONMessageCharset);
            }
            uriString.append("&msg=").append(URLEncoder.encode(this.msg, ChatONMessageEncoding));
        }
        if (!TextUtils.isEmpty(this.uri)) {
            uriString.append("&uri=").append(URLEncoder.encode(this.uri, ChatONMessageEncoding));
        }
        String appInfo = makeAppInfoData();
        if (!TextUtils.isEmpty(appInfo)) {
            uriString.append("&appInfo=").append(URLEncoder.encode(appInfo, ChatONMessageEncoding));
        }
        if (this.recipients != null && !this.recipients.isEmpty()) {
            StringBuilder recipientString = new StringBuilder();
            for (String recipient : this.recipients) {
                recipientString.append(recipient).append(",");
            }
            recipientString.setLength(recipientString.length() - 1);
            uriString.append("&recipients=").append(URLEncoder.encode(recipientString.toString(), ChatONMessageEncoding));
        }
        if (!TextUtils.isEmpty(this.inboxNo)) {
            uriString.append("&inboxNo=").append(URLEncoder.encode(this.inboxNo, ChatONMessageEncoding));
        }
        if (this.chatType != ChatType.UNKNOWN) {
            uriString.append("&chatType=").append(String.valueOf(this.chatType.getValue()));
        }
        Uri chatONMessageData = Uri.parse(uriString.toString());
        this.intent.setData(chatONMessageData);
        if (this.requiredAccessToken) {
            Uri returnUri = this.context.getContentResolver().insert(ChatONAPI.ACCESS_TOKEN_PROVIDER_URI, new ContentValues());
            this.intent.putExtra("password", returnUri.getLastPathSegment());
        }
    }

    protected String makeAppInfoData() throws JSONException {
        JSONObject appInfo = null;
        try {
            if (!TextUtils.isEmpty(this.appName)) {
                if (0 == 0) {
                    appInfo = new JSONObject();
                }
                appInfo.put(GraphAPI.ME_NAME, this.appName);
            }
            JSONObject appInfo2 = appInfo;
            try {
                if (!TextUtils.isEmpty(this.appVersion)) {
                    JSONObject appInfo3 = appInfo2 == null ? new JSONObject() : appInfo2;
                    appInfo3.put("version", this.appVersion);
                    appInfo2 = appInfo3;
                }
                if (this.appParamInfo != null) {
                    appInfo = appInfo2 == null ? new JSONObject() : appInfo2;
                    JSONArray arrObject = new JSONArray();
                    for (Map<String, String> param : this.appParamInfo) {
                        JSONObject object = new JSONObject();
                        for (String key : param.keySet()) {
                            object.put(key, param.get(key));
                        }
                        arrObject.put(object);
                    }
                    appInfo.put("param", arrObject);
                } else {
                    appInfo = appInfo2;
                }
            } catch (JSONException e) {
                appInfo = appInfo2;
            }
        } catch (JSONException e2) {
        }
        if (appInfo == null) {
            return null;
        }
        return appInfo.toString();
    }

    public Intent getIntent() {
        return this.intent;
    }
}
