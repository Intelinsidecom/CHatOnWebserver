package com.sec.chaton.p016a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.x */
/* loaded from: classes.dex */
public final class C0409x extends GeneratedMessageLite implements InterfaceC0411z {

    /* renamed from: a */
    private static final C0409x f1448a = new C0409x(true);

    /* renamed from: b */
    private int f1449b;

    /* renamed from: c */
    private long f1450c;

    /* renamed from: d */
    private C0369dl f1451d;

    /* renamed from: e */
    private byte f1452e;

    /* renamed from: f */
    private int f1453f;

    private C0409x(C0410y c0410y) {
        super(c0410y);
        this.f1452e = (byte) -1;
        this.f1453f = -1;
    }

    private C0409x(boolean z) {
        this.f1452e = (byte) -1;
        this.f1453f = -1;
    }

    /* renamed from: a */
    public static C0409x m2993a() {
        return f1448a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0409x getDefaultInstanceForType() {
        return f1448a;
    }

    /* renamed from: c */
    public boolean m2998c() {
        return (this.f1449b & 1) == 1;
    }

    /* renamed from: d */
    public long m2999d() {
        return this.f1450c;
    }

    /* renamed from: e */
    public boolean m3000e() {
        return (this.f1449b & 2) == 2;
    }

    /* renamed from: f */
    public C0369dl m3001f() {
        return this.f1451d;
    }

    /* renamed from: i */
    private void m2996i() {
        this.f1450c = 0L;
        this.f1451d = C0369dl.m2485a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1452e;
        if (b != -1) {
            return b == 1;
        }
        this.f1452e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1449b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1450c);
        }
        if ((this.f1449b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f1451d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f1453f;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f1449b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f1450c) : 0;
            if ((this.f1449b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f1451d);
            }
            this.f1453f = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0409x m2994a(byte[] bArr) {
        return ((C0410y) newBuilder().mergeFrom(bArr)).m3008k();
    }

    public static C0410y newBuilder() {
        return C0410y.m3007j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0410y newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0410y m2995a(C0409x c0409x) {
        return newBuilder().mergeFrom(c0409x);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0410y toBuilder() {
        return m2995a(this);
    }

    static {
        f1448a.m2996i();
    }
}
