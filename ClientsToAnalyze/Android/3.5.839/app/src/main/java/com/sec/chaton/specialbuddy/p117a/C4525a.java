package com.sec.chaton.specialbuddy.p117a;

import com.sec.chaton.util.C4904y;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LiveChatAckEntry.java */
/* renamed from: com.sec.chaton.specialbuddy.a.a */
/* loaded from: classes.dex */
public class C4525a extends C4526b {

    /* renamed from: a */
    public long f16383a;

    public C4525a(long j, String str, long j2) {
        super(j, str);
        this.f16384b = EnumC4527c.TYPE_ACK;
        this.f16383a = j2;
    }

    @Override // com.sec.chaton.specialbuddy.p117a.C4526b
    /* renamed from: a */
    public JSONObject mo17220a() throws JSONException {
        JSONObject jSONObjectMo17220a = super.mo17220a();
        if (jSONObjectMo17220a == null) {
            return null;
        }
        try {
            jSONObjectMo17220a.put("receivetime", String.valueOf(this.f16383a));
            return jSONObjectMo17220a;
        } catch (JSONException e) {
            if (!C4904y.f17875e) {
                return null;
            }
            C4904y.m18635a(e, C4525a.class.getSimpleName());
            return null;
        }
    }

    @Override // com.sec.chaton.specialbuddy.p117a.C4526b
    public String toString() {
        return super.toString() + ", receivetime: " + this.f16383a;
    }
}
