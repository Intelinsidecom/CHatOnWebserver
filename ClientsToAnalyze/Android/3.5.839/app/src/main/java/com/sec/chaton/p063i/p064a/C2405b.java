package com.sec.chaton.p063i.p064a;

import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;
import com.sec.common.util.log.collector.C5037b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DebugTcpChatLog.java */
/* renamed from: com.sec.chaton.i.a.b */
/* loaded from: classes.dex */
public class C2405b extends C5037b {

    /* renamed from: f */
    private static final String f8545f = C2405b.class.getSimpleName();

    public C2405b() throws JSONException {
        m19137b("01000006");
        this.f18361e = new JSONObject();
        try {
            this.f18361e.put("t", C5034k.m19090a());
        } catch (JSONException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f8545f);
            }
        }
    }

    /* renamed from: a */
    public void m10432a(String str) throws JSONException {
        try {
            this.f18361e.put("m", str);
        } catch (JSONException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f8545f);
            }
        }
    }

    public String toString() {
        return String.format("%s|%s|%s", this.f18358b, this.f18359c, this.f18361e.toString());
    }
}
