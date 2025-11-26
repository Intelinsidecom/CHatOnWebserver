package com.sec.chaton.p035io.entry;

import android.text.TextUtils;
import com.renren.android.Renren;
import com.sec.chaton.p035io.entry.MessageType4Entry;
import com.sec.chaton.p042k.p043a.C1600a;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3224cl;
import com.sec.chaton.util.C3250y;
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
            public String name;
            public ArrayList<ParamEntry> param;
            public String version;

            public class ParamEntry extends Entry {

                /* renamed from: OS */
                public String f5630OS;
                public String deviceType;
                public String executeUri;

                /* renamed from: id */
                public String f5631id;
                public String installUrl;
            }
        }

        public class MessageEntry extends Entry {
            public String text;
            public String type;
        }
    }

    @Override // com.sec.chaton.p035io.entry.MessageType4Entry
    public String getDisplayMessage() {
        return (this.content == null || this.content.message == null) ? "" : this.content.message.text;
    }

    public class PushMessageEntry extends MessageType4Entry {
        public String type = "link";
        public String content_type = "app";
        public String text = "";

        @Override // com.sec.chaton.p035io.entry.MessageType4Entry
        public String getDisplayMessage() {
            return this.text;
        }
    }

    public String getAppName() {
        return (this.content == null || this.content.appInfo == null) ? "" : this.content.appInfo.name;
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
            if (str.equalsIgnoreCase(next.f5630OS) && "phone".equalsIgnoreCase(next.deviceType)) {
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
        return !new JSONObject(str).has("push_message");
    }

    public static String getDisplayMessage(String str) {
        try {
            return parse(str).getDisplayMessage();
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, ApplinkMsgEntry.class.getSimpleName());
                return str;
            }
            return str;
        }
    }

    public static MessageType4Entry parse(String str) {
        return isPushMessage(str) ? parseAsPushMessage(str) : parseAsFullMessage(str);
    }

    public static PushMessageEntry parseAsPushMessage(String str) {
        PushMessageEntry pushMessageEntry = new PushMessageEntry();
        try {
            JSONObject jSONObject = new JSONObject(str);
            pushMessageEntry.type = jSONObject.getString(PrefFragmentChats.TYPE);
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
        applinkMsgEntry.type = jSONObject.getString(PrefFragmentChats.TYPE);
        applinkMsgEntry.format = jSONObject.getString("format");
        applinkMsgEntry.content = (ContentEntry) new C1600a(jSONObject.getJSONObject("content").toString()).m6782a(ContentEntry.class);
        Object obj = jSONObject.get("push_message");
        if (obj instanceof JSONObject) {
            applinkMsgEntry.push_message = (PushMessageEntry) new C1600a(((JSONObject) obj).toString()).m6782a(PushMessageEntry.class);
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
        jSONObject.put(PrefFragmentChats.TYPE, "link");
        jSONObject.put("format", Renren.RESPONSE_FORMAT_JSON);
        jSONObject.put("push_message", makePushMessage(str));
        jSONObject2.put(PrefFragmentChats.TYPE, "app");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(PrefFragmentChats.TYPE, "text");
        jSONObject3.put("text", str);
        jSONObject2.put("message", jSONObject3);
        jSONObject2.put("appInfo", new JSONObject(str2));
        jSONObject.put("content", jSONObject2);
        return jSONObject;
    }

    public static JSONObject makePushMessage(String str) throws Exception {
        String strM11336b;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(PrefFragmentChats.TYPE, "link");
        jSONObject.put("content_type", "app");
        jSONObject.put("text", str);
        int iM11332a = C3224cl.m11332a(jSONObject.toString());
        if (98 < iM11332a) {
            int iM11332a2 = C3224cl.m11332a("..");
            int iM11332a3 = C3224cl.m11332a(str) - (iM11332a - 98);
            if (iM11332a3 > iM11332a2) {
                strM11336b = C3224cl.m11336b(str, iM11332a3, "..");
            } else {
                strM11336b = C3224cl.m11336b(str, iM11332a2, "..");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(PrefFragmentChats.TYPE, "link");
            jSONObject2.put("content_type", "app");
            jSONObject2.put("text", strM11336b);
            if (98 >= C3224cl.m11332a(jSONObject2.toString())) {
                return jSONObject2;
            }
            throw new Exception("exceeds 100 bytes");
        }
        return jSONObject;
    }
}
