package com.sec.chaton.p033i.p034a;

import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3347i;
import com.sec.common.util.log.collector.C3352b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DebugFCLog.java */
/* renamed from: com.sec.chaton.i.a.a */
/* loaded from: classes.dex */
public class C1532a extends C3352b {

    /* renamed from: e */
    private static final String f5620e = C1532a.class.getSimpleName();

    public C1532a() throws JSONException {
        m11827c("01000001");
        this.f12097d = new JSONObject();
        try {
            this.f12097d.put("t", C3347i.m11774a());
        } catch (JSONException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f5620e);
            }
        }
    }

    /* renamed from: a */
    public void m6521a(String str) {
        try {
            this.f12097d.put("c", str);
        } catch (JSONException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f5620e);
            }
        }
    }
}
