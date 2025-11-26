package com.google.protobuf;

/* renamed from: com.google.protobuf.f */
/* loaded from: classes.dex */
final class C0058f {

    /* renamed from: a */
    private final CodedOutputStream f278a;

    /* renamed from: b */
    private final byte[] f279b;

    private C0058f(int i) {
        this.f279b = new byte[i];
        this.f278a = CodedOutputStream.m299a(this.f279b);
    }

    /* renamed from: a */
    public ByteString m354a() {
        this.f278a.m333c();
        return new ByteString(this.f279b);
    }

    /* renamed from: b */
    public CodedOutputStream m355b() {
        return this.f278a;
    }
}
