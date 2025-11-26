package com.sec.chaton.p016a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.aj */
/* loaded from: classes.dex */
public final class C0286aj extends GeneratedMessageLite implements InterfaceC0288al {

    /* renamed from: a */
    private static final C0286aj f908a = new C0286aj(true);

    /* renamed from: b */
    private int f909b;

    /* renamed from: c */
    private long f910c;

    /* renamed from: d */
    private C0369dl f911d;

    /* renamed from: e */
    private long f912e;

    /* renamed from: f */
    private byte f913f;

    /* renamed from: g */
    private int f914g;

    private C0286aj(C0287ak c0287ak) {
        super(c0287ak);
        this.f913f = (byte) -1;
        this.f914g = -1;
    }

    private C0286aj(boolean z) {
        this.f913f = (byte) -1;
        this.f914g = -1;
    }

    /* renamed from: a */
    public static C0286aj m1482a() {
        return f908a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0286aj getDefaultInstanceForType() {
        return f908a;
    }

    /* renamed from: c */
    public boolean m1489c() {
        return (this.f909b & 1) == 1;
    }

    /* renamed from: d */
    public long m1490d() {
        return this.f910c;
    }

    /* renamed from: e */
    public boolean m1491e() {
        return (this.f909b & 2) == 2;
    }

    /* renamed from: f */
    public C0369dl m1492f() {
        return this.f911d;
    }

    /* renamed from: g */
    public boolean m1493g() {
        return (this.f909b & 4) == 4;
    }

    /* renamed from: h */
    public long m1494h() {
        return this.f912e;
    }

    /* renamed from: k */
    private void m1487k() {
        this.f910c = 0L;
        this.f911d = C0369dl.m2485a();
        this.f912e = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f913f;
        if (b != -1) {
            return b == 1;
        }
        this.f913f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f909b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f910c);
        }
        if ((this.f909b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f911d);
        }
        if ((this.f909b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f912e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f914g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f909b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f910c) : 0;
            if ((this.f909b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f911d);
            }
            if ((this.f909b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(3, this.f912e);
            }
            this.f914g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0286aj m1483a(byte[] bArr) {
        return ((C0287ak) newBuilder().mergeFrom(bArr)).m1501k();
    }

    public static C0287ak newBuilder() {
        return C0287ak.m1500j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0287ak newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0287ak m1484a(C0286aj c0286aj) {
        return newBuilder().mergeFrom(c0286aj);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0287ak toBuilder() {
        return m1484a(this);
    }

    static {
        f908a.m1487k();
    }
}
