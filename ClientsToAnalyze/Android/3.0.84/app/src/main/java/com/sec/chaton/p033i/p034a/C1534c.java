package com.sec.chaton.p033i.p034a;

import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3347i;
import com.sec.common.util.log.collector.C3352b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DebugTcpChatLog.java */
/* renamed from: com.sec.chaton.i.a.c */
/* loaded from: classes.dex */
public class C1534c extends C3352b {

    /* renamed from: e */
    private static final String f5622e = C1534c.class.getSimpleName();

    public C1534c() throws JSONException {
        m11827c("01000006");
        this.f12097d = new JSONObject();
        try {
            this.f12097d.put("t", C3347i.m11774a());
        } catch (JSONException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f5622e);
            }
        }
    }

    /* renamed from: a */
    public void m6525a(String str) {
        try {
            this.f12097d.put("m", str);
        } catch (JSONException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f5622e);
            }
        }
    }

    public String toString() {
        return String.format("%s|%s|%s", this.f12095b, this.f12096c, this.f12097d.toString());
    }
}
