package com.sec.common.util.log.collector;

import com.sec.common.util.C3347i;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: Log.java */
/* renamed from: com.sec.common.util.log.collector.b */
/* loaded from: classes.dex */
public class C3352b {

    /* renamed from: a */
    protected String f12094a = new SimpleDateFormat("yyyyMMdd").format(new Date(C3347i.m11774a()));

    /* renamed from: b */
    protected String f12095b;

    /* renamed from: c */
    protected String f12096c;

    /* renamed from: d */
    protected JSONObject f12097d;

    protected C3352b() {
    }

    /* renamed from: a */
    public String m11822a() {
        return this.f12094a;
    }

    /* renamed from: b */
    public void m11825b(String str) {
        this.f12095b = str;
    }

    /* renamed from: b */
    public String m11824b() {
        return this.f12095b;
    }

    /* renamed from: c */
    public void m11827c(String str) {
        this.f12095b = str;
    }

    /* renamed from: c */
    public String m11826c() {
        return this.f12096c;
    }

    /* renamed from: d */
    public void m11829d(String str) {
        this.f12096c = str;
    }

    /* renamed from: d */
    public JSONObject m11828d() {
        return this.f12097d;
    }

    /* renamed from: a */
    public void m11823a(JSONObject jSONObject) {
        this.f12097d = jSONObject;
    }
}
