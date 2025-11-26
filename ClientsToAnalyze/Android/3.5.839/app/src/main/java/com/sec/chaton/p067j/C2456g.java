package com.sec.chaton.p067j;

import com.sec.chaton.p065io.p066a.C2406a;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.common.p126d.p127a.AbstractC4976a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ChatONHttpTextRequestEntry.java */
/* renamed from: com.sec.chaton.j.g */
/* loaded from: classes.dex */
public class C2456g {

    /* renamed from: a */
    protected String f8807a;

    /* renamed from: b */
    protected EnumC4868cf f8808b;

    /* renamed from: e */
    protected Class<?> f8811e;

    /* renamed from: c */
    protected EnumC2457h f8809c = EnumC2457h.GET;

    /* renamed from: d */
    protected Map<String, String> f8810d = new HashMap();

    /* renamed from: f */
    protected String f8812f = "text/xml";

    /* renamed from: g */
    protected Map<String, String> f8813g = new HashMap();

    /* renamed from: j */
    protected int f8816j = 30000;

    /* renamed from: k */
    protected Class<?> f8817k = C4815ag.class;

    /* renamed from: l */
    protected AbstractC4976a f8818l = new C2406a();

    /* renamed from: h */
    protected boolean f8814h = true;

    /* renamed from: i */
    protected boolean f8815i = true;

    public C2456g(EnumC4868cf enumC4868cf, String str) {
        this.f8808b = enumC4868cf;
        this.f8807a = str;
    }

    /* renamed from: a */
    public C2456g m10637a(EnumC2457h enumC2457h) {
        this.f8809c = enumC2457h;
        return this;
    }

    /* renamed from: a */
    public C2456g m10641a(String str, String str2) {
        if (str != null && str2 != null) {
            this.f8810d.put(str, str2);
        }
        return this;
    }

    /* renamed from: b */
    public C2456g m10644b(String str, String str2) {
        if (str != null && str2 != null) {
            if ("Content-Type".equals(str)) {
                m10640a(str2);
            } else {
                this.f8813g.put(str, str2);
            }
        }
        return this;
    }

    /* renamed from: a */
    public C2456g m10639a(Class<?> cls) {
        this.f8811e = cls;
        return this;
    }

    /* renamed from: a */
    public C2456g m10640a(String str) {
        this.f8812f = str;
        return this;
    }

    /* renamed from: a */
    public C2454e m10635a() {
        return new C2454e(this, null);
    }

    /* renamed from: b */
    public C2456g m10643b(Class<?> cls) {
        this.f8817k = cls;
        return this;
    }

    /* renamed from: a */
    public C2456g m10638a(AbstractC4976a abstractC4976a) {
        this.f8818l = abstractC4976a;
        return this;
    }

    /* renamed from: a */
    public C2456g m10642a(boolean z) {
        this.f8814h = z;
        return this;
    }

    /* renamed from: b */
    public C2456g m10645b(boolean z) {
        this.f8815i = z;
        return this;
    }

    /* renamed from: a */
    public C2456g m10636a(int i) {
        this.f8816j = i;
        return this;
    }
}
