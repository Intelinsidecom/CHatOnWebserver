package com.sec.chaton.push.p039c;

import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.push.p035a.p037b.AbstractC0865c;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.a */
/* loaded from: classes.dex */
public class C0881a {

    /* renamed from: a */
    private AbstractC0865c f3019a;

    /* renamed from: b */
    private GeneratedMessageLite f3020b;

    /* renamed from: a */
    public AbstractC0865c m3476a() {
        return this.f3019a;
    }

    /* renamed from: a */
    public C0881a m3478a(AbstractC0865c abstractC0865c) {
        this.f3019a = abstractC0865c;
        return this;
    }

    /* renamed from: b */
    public GeneratedMessageLite m3479b() {
        return this.f3020b;
    }

    /* renamed from: a */
    public C0881a m3477a(GeneratedMessageLite generatedMessageLite) {
        this.f3020b = generatedMessageLite;
        return this;
    }

    public String toString() {
        return String.format("TaskOperation(Connection: %s, Request: %s).", this.f3019a, this.f3020b);
    }
}
