package com.sec.chaton.push.p094c;

import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.p091b.p092a.AbstractC3057a;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.h */
/* loaded from: classes.dex */
public class C3087h {

    /* renamed from: a */
    private AbstractC3057a f11399a;

    /* renamed from: b */
    private GeneratedMessageLite f11400b;

    /* renamed from: a */
    public AbstractC3057a m12580a() {
        return this.f11399a;
    }

    /* renamed from: a */
    public C3087h m12582a(AbstractC3057a abstractC3057a) {
        this.f11399a = abstractC3057a;
        return this;
    }

    /* renamed from: b */
    public GeneratedMessageLite m12583b() {
        return this.f11400b;
    }

    /* renamed from: a */
    public C3087h m12581a(GeneratedMessageLite generatedMessageLite) {
        this.f11400b = generatedMessageLite;
        return this;
    }

    public String toString() {
        return String.format("TaskOperation(Connection: %s, Request: %s).", this.f11399a, this.f11400b);
    }
}
