package com.sec.chaton.push.p054c;

import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.p051b.p052a.AbstractC2057a;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.h */
/* loaded from: classes.dex */
public class C2087h {

    /* renamed from: a */
    private AbstractC2057a f7989a;

    /* renamed from: b */
    private GeneratedMessageLite f7990b;

    /* renamed from: a */
    public AbstractC2057a m8237a() {
        return this.f7989a;
    }

    /* renamed from: a */
    public C2087h m8239a(AbstractC2057a abstractC2057a) {
        this.f7989a = abstractC2057a;
        return this;
    }

    /* renamed from: b */
    public GeneratedMessageLite m8240b() {
        return this.f7990b;
    }

    /* renamed from: a */
    public C2087h m8238a(GeneratedMessageLite generatedMessageLite) {
        this.f7990b = generatedMessageLite;
        return this;
    }

    public String toString() {
        return String.format("TaskOperation(Connection: %s, Request: %s).", this.f7989a, this.f7990b);
    }
}
