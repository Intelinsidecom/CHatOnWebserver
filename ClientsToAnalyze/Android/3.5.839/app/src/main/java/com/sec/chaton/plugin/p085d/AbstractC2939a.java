package com.sec.chaton.plugin.p085d;

/* compiled from: AbstractHttpError.java */
/* renamed from: com.sec.chaton.plugin.d.a */
/* loaded from: classes.dex */
public abstract class AbstractC2939a {

    /* renamed from: a */
    private int f10829a = -1;

    /* renamed from: b */
    private String f10830b = null;

    /* renamed from: c */
    private String f10831c;

    /* renamed from: a */
    public void m12174a(int i) {
        this.f10829a = i;
    }

    /* renamed from: a */
    public void m12175a(String str) {
        this.f10830b = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HttpError [httpResponseCode=").append(this.f10829a).append(", httpResponseMsg=").append(this.f10830b).append(", mErrorPayload=").append(this.f10831c).append("]");
        return sb.toString();
    }
}
