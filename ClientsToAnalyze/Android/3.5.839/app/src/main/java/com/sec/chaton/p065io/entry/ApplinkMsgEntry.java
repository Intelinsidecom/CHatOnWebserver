package com.sec.chaton.p065io.entry;

import android.text.TextUtils;
import com.p137vk.sdk.api.VKApiConst;
import com.renren.android.Renren;
import com.sec.chaton.p065io.entry.MessageType4Entry;
import com.sec.chaton.p072k.p073a.C2477a;
import com.sec.chaton.util.C4874cl;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ApplinkMsgEntry extends MessageType4Entry {
    public ContentEntry content;
    public String format;
    public PushMessageEntry push_message;
    public String type;

    public class ContentEntry extends Entry {
        public AppInfoEntry appInfo;
        public MessageEntry message;
        public String type;

        public class AppInfoEntry extends Entry {
            public String name = "";
            public ArrayList<ParamEntry> param;
            public String version;

            public class ParamEntry extends Entry {

                /* renamed from: OS */
                public String f8551OS;
                public String deviceType;
                public String executeUri;

                /* renamed from: id */
                public String f8552id;
                public String installUrl;
            }
        }

        public class MessageEntry extends Entry {
            public String text = "";
            public String type;
        }
    }

    @Override // com.sec.chaton.p065io.entry.MessageType4Entry
    public String getDisplayMessage() {
        if (this.content == null || this.content.message == null || TextUtils.isEmpty(this.content.message.text)) {
            return "";
        }
        return this.content.message.text;
    }

    public class PushMessageEntry extends MessageType4Entry {
        public String type = "link";
        public String content_type = "app";
        public String text = "";

        @Override // com.sec.chaton.p065io.entry.MessageType4Entry
        public String getDisplayMessage() {
            return TextUtils.isEmpty(this.text) ? "" : this.text;
        }
    }

    public String getAppName() {
        if (this.content == null || this.content.appInfo == null || TextUtils.isEmpty(this.content.appInfo.name)) {
            return "";
        }
        return this.content.appInfo.name;
    }

    public String getAppVersion() {
        return (this.content == null || this.content.appInfo == null) ? "" : this.content.appInfo.version;
    }

    public ContentEntry.AppInfoEntry.ParamEntry getParam(String str, String str2) {
        if (this.content == null || this.content.appInfo == null || this.content.appInfo.param == null) {
            return null;
        }
        Iterator<ContentEntry.AppInfoEntry.ParamEntry> it = this.content.appInfo.param.iterator();
        while (it.hasNext()) {
            ContentEntry.AppInfoEntry.ParamEntry next = it.next();
            if (str.equalsIgnoreCase(next.f8551OS) && "phone".equalsIgnoreCase(next.deviceType)) {
                return next;
            }
        }
        return null;
    }

    public String getAnythingExecuteUri() {
        if (this.content == null || this.content.appInfo == null || this.content.appInfo.param == null) {
            return null;
        }
        Iterator<ContentEntry.AppInfoEntry.ParamEntry> it = this.content.appInfo.param.iterator();
        while (it.hasNext()) {
            ContentEntry.AppInfoEntry.ParamEntry next = it.next();
            if (!TextUtils.isEmpty(next.executeUri)) {
                return next.executeUri;
            }
        }
        return null;
    }

    public static boolean isPushMessage(String str) {
        if (new JSONObject(str).has("push_message")) {
            return false;
        }
        return true;
    }

    public static String getDisplayMessage(String str) {
        try {
            return parse(str).getDisplayMessage();
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, ApplinkMsgEntry.class.getSimpleName());
                return str;
            }
            return str;
        }
    }

    public static MessageType4Entry parse(String str) {
        if (isPushMessage(str)) {
            return parseAsPushMessage(str);
        }
        return parseAsFullMessage(str);
    }

    public static PushMessageEntry parseAsPushMessage(String str) {
        PushMessageEntry pushMessageEntry = new PushMessageEntry();
        try {
            JSONObject jSONObject = new JSONObject(str);
            pushMessageEntry.type = jSONObject.getString("type");
            pushMessageEntry.content_type = jSONObject.getString("content_type");
            pushMessageEntry.text = jSONObject.getString("text");
        } catch (JSONException e) {
            pushMessageEntry.text = str;
        }
        pushMessageEntry.setEntryType(MessageType4Entry.EntryType.ENTRY_TYPE_PUSH);
        return pushMessageEntry;
    }

    public static ApplinkMsgEntry parseAsFullMessage(String str) throws JSONException {
        ApplinkMsgEntry applinkMsgEntry = new ApplinkMsgEntry();
        JSONObject jSONObject = new JSONObject(str);
        applinkMsgEntry.type = jSONObject.getString("type");
        applinkMsgEntry.format = jSONObject.getString("format");
        applinkMsgEntry.content = (ContentEntry) new C2477a(jSONObject.getJSONObject("content").toString()).m10709a(ContentEntry.class);
        Object obj = jSONObject.get("push_message");
        if (obj instanceof JSONObject) {
            applinkMsgEntry.push_message = (PushMessageEntry) new C2477a(((JSONObject) obj).toString()).m10709a(PushMessageEntry.class);
        } else {
            applinkMsgEntry.push_message = new PushMessageEntry();
            applinkMsgEntry.push_message.text = (String) obj;
        }
        applinkMsgEntry.setEntryType(MessageType4Entry.EntryType.ENTRY_TYPE_WHOLE);
        return applinkMsgEntry;
    }

    public static JSONObject createJson(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("type", "link");
        jSONObject.put("format", Renren.RESPONSE_FORMAT_JSON);
        jSONObject.put("push_message", makePushMessage(str));
        jSONObject2.put("type", "app");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("type", "text");
        jSONObject3.put("text", str);
        jSONObject2.put(VKApiConst.MESSAGE, jSONObject3);
        jSONObject2.put("appInfo", new JSONObject(str2));
        jSONObject.put("content", jSONObject2);
        return jSONObject;
    }

    public static JSONObject makePushMessage(String str) throws Exception {
        String strM18510b;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "link");
        jSONObject.put("content_type", "app");
        jSONObject.put("text", str);
        int iM18509b = C4874cl.m18509b(jSONObject.toString());
        if (98 < iM18509b) {
            int iM18509b2 = C4874cl.m18509b("..");
            int iM18509b3 = C4874cl.m18509b(str) - (iM18509b - 98);
            if (iM18509b3 > iM18509b2) {
                strM18510b = C4874cl.m18510b(str, iM18509b3, "..");
            } else {
                strM18510b = C4874cl.m18510b(str, iM18509b2, "..");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "link");
            jSONObject2.put("content_type", "app");
            jSONObject2.put("text", strM18510b);
            if (98 < C4874cl.m18509b(jSONObject2.toString())) {
                throw new Exception("exceeds 100 bytes");
            }
            return jSONObject2;
        }
        return jSONObject;
    }
}
