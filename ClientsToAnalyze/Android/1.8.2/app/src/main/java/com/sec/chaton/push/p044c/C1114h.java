package com.sec.chaton.push.p044c;

import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.p041b.p042a.AbstractC1084a;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.h */
/* loaded from: classes.dex */
public class C1114h {

    /* renamed from: a */
    private AbstractC1084a f4085a;

    /* renamed from: b */
    private GeneratedMessageLite f4086b;

    /* renamed from: a */
    public AbstractC1084a m4192a() {
        return this.f4085a;
    }

    /* renamed from: a */
    public C1114h m4194a(AbstractC1084a abstractC1084a) {
        this.f4085a = abstractC1084a;
        return this;
    }

    /* renamed from: b */
    public GeneratedMessageLite m4195b() {
        return this.f4086b;
    }

    /* renamed from: a */
    public C1114h m4193a(GeneratedMessageLite generatedMessageLite) {
        this.f4086b = generatedMessageLite;
        return this;
    }

    public String toString() {
        return String.format("TaskOperation(Connection: %s, Request: %s).", this.f4085a, this.f4086b);
    }
}
