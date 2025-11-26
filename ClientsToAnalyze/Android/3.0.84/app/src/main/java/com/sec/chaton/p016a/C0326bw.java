package com.sec.chaton.p016a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bw */
/* loaded from: classes.dex */
public final class C0326bw extends GeneratedMessageLite implements InterfaceC0328by {

    /* renamed from: a */
    private static final C0326bw f1085a = new C0326bw(true);

    /* renamed from: b */
    private int f1086b;

    /* renamed from: c */
    private long f1087c;

    /* renamed from: d */
    private C0369dl f1088d;

    /* renamed from: e */
    private byte f1089e;

    /* renamed from: f */
    private int f1090f;

    private C0326bw(C0327bx c0327bx) {
        super(c0327bx);
        this.f1089e = (byte) -1;
        this.f1090f = -1;
    }

    private C0326bw(boolean z) {
        this.f1089e = (byte) -1;
        this.f1090f = -1;
    }

    /* renamed from: a */
    public static C0326bw m1925a() {
        return f1085a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0326bw getDefaultInstanceForType() {
        return f1085a;
    }

    /* renamed from: c */
    public boolean m1931c() {
        return (this.f1086b & 1) == 1;
    }

    /* renamed from: d */
    public long m1932d() {
        return this.f1087c;
    }

    /* renamed from: e */
    public boolean m1933e() {
        return (this.f1086b & 2) == 2;
    }

    /* renamed from: f */
    public C0369dl m1934f() {
        return this.f1088d;
    }

    /* renamed from: i */
    private void m1929i() {
        this.f1087c = 0L;
        this.f1088d = C0369dl.m2485a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1089e;
        if (b != -1) {
            return b == 1;
        }
        this.f1089e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1086b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1087c);
        }
        if ((this.f1086b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f1088d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f1090f;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f1086b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f1087c) : 0;
            if ((this.f1086b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f1088d);
            }
            this.f1090f = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0326bw m1926a(byte[] bArr) {
        return ((C0327bx) newBuilder().mergeFrom(bArr)).m1941k();
    }

    public static C0327bx newBuilder() {
        return C0327bx.m1940j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0327bx newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0327bx m1927a(C0326bw c0326bw) {
        return newBuilder().mergeFrom(c0326bw);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0327bx toBuilder() {
        return m1927a(this);
    }

    static {
        f1085a.m1929i();
    }
}
