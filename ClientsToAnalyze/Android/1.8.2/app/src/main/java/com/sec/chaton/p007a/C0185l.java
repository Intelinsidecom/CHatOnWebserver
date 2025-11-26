package com.sec.chaton.p007a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.l */
/* loaded from: classes.dex */
public final class C0185l extends GeneratedMessageLite implements InterfaceC0187n {

    /* renamed from: a */
    private static final C0185l f678a = new C0185l(true);

    /* renamed from: b */
    private int f679b;

    /* renamed from: c */
    private long f680c;

    /* renamed from: d */
    private C0171cj f681d;

    /* renamed from: e */
    private byte f682e;

    /* renamed from: f */
    private int f683f;

    private C0185l(C0186m c0186m) {
        super(c0186m);
        this.f682e = (byte) -1;
        this.f683f = -1;
    }

    private C0185l(boolean z) {
        this.f682e = (byte) -1;
        this.f683f = -1;
    }

    /* renamed from: a */
    public static C0185l m1638a() {
        return f678a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0185l getDefaultInstanceForType() {
        return f678a;
    }

    /* renamed from: c */
    public boolean m1643c() {
        return (this.f679b & 1) == 1;
    }

    /* renamed from: d */
    public long m1644d() {
        return this.f680c;
    }

    /* renamed from: e */
    public boolean m1645e() {
        return (this.f679b & 2) == 2;
    }

    /* renamed from: f */
    public C0171cj m1646f() {
        return this.f681d;
    }

    /* renamed from: i */
    private void m1641i() {
        this.f680c = 0L;
        this.f681d = C0171cj.m1459a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f682e;
        if (b != -1) {
            return b == 1;
        }
        this.f682e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f679b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f680c);
        }
        if ((this.f679b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f681d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f683f;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f679b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f680c) : 0;
            if ((this.f679b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f681d);
            }
            this.f683f = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0185l m1639a(byte[] bArr) {
        return ((C0186m) newBuilder().mergeFrom(bArr)).m1653l();
    }

    public static C0186m newBuilder() {
        return C0186m.m1652k();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0186m newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0186m m1640a(C0185l c0185l) {
        return newBuilder().mergeFrom(c0185l);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0186m toBuilder() {
        return m1640a(this);
    }

    static {
        f678a.m1641i();
    }
}
