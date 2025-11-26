package com.sec.chaton.p022h;

import com.sec.chaton.util.EnumC1765bu;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: HttpEnvelope.java */
/* renamed from: com.sec.chaton.h.j */
/* loaded from: classes.dex */
public class C0800j {

    /* renamed from: a */
    protected String f2941a;

    /* renamed from: b */
    protected EnumC1765bu f2942b;

    /* renamed from: e */
    protected Class f2945e;

    /* renamed from: f */
    protected int f2946f;

    /* renamed from: g */
    protected String f2947g;

    /* renamed from: k */
    protected Class f2951k;

    /* renamed from: c */
    protected EnumC0801k f2943c = EnumC0801k.GET;

    /* renamed from: d */
    protected List f2944d = new ArrayList();

    /* renamed from: h */
    protected List f2948h = new ArrayList();

    /* renamed from: j */
    protected int f2950j = -1;

    /* renamed from: i */
    protected boolean f2949i = true;

    public C0800j(EnumC1765bu enumC1765bu, String str) {
        this.f2942b = enumC1765bu;
        this.f2941a = str;
    }

    /* renamed from: a */
    public C0800j m3406a(EnumC0801k enumC0801k) {
        this.f2943c = enumC0801k;
        return this;
    }

    /* renamed from: a */
    public C0800j m3409a(String str, String str2) {
        if (str != null && str2 != null) {
            this.f2944d.add(new BasicNameValuePair(str, str2));
        }
        return this;
    }

    /* renamed from: b */
    public C0800j m3411b(String str, String str2) {
        if (str != null && str2 != null) {
            this.f2948h.add(new BasicNameValuePair(str, str2));
        }
        return this;
    }

    /* renamed from: a */
    public C0800j m3407a(Class cls) {
        this.f2945e = cls;
        return this;
    }

    /* renamed from: a */
    public C0800j m3405a(int i) {
        this.f2946f = i;
        return this;
    }

    /* renamed from: a */
    public C0800j m3408a(String str) {
        this.f2947g = str;
        return this;
    }

    /* renamed from: a */
    public C0798h m3404a() {
        return new C0798h(this);
    }

    /* renamed from: b */
    public C0800j m3410b(Class cls) {
        this.f2951k = cls;
        return this;
    }
}
