package com.sec.chaton.specialbuddy.p117a;

import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LiveChatFeedbackEntry.java */
/* renamed from: com.sec.chaton.specialbuddy.a.b */
/* loaded from: classes.dex */
public class C4526b {

    /* renamed from: b */
    EnumC4527c f16384b = EnumC4527c.TYPE_UNDEFINED;

    /* renamed from: c */
    public long f16385c;

    /* renamed from: d */
    public String f16386d;

    /* renamed from: b */
    public EnumC4527c m17221b() {
        return this.f16384b;
    }

    C4526b(long j, String str) {
        this.f16385c = j;
        this.f16386d = str;
    }

    /* renamed from: a */
    public JSONObject mo17220a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msgid", String.valueOf(this.f16385c));
            jSONObject.put(Config.NOTIFICATION_INTENT_SENDER, this.f16386d);
            return jSONObject;
        } catch (JSONException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, C4526b.class.getSimpleName());
            }
            return null;
        }
    }

    public String toString() {
        return "msgid: " + this.f16385c + ", sender: " + this.f16386d + ", type: " + this.f16384b;
    }
}
