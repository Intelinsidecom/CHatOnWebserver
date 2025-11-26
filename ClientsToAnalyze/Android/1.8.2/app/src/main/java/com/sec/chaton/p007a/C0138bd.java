package com.sec.chaton.p007a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bd */
/* loaded from: classes.dex */
public final class C0138bd extends GeneratedMessageLite implements InterfaceC0140bf {

    /* renamed from: a */
    private static final C0138bd f468a = new C0138bd(true);

    /* renamed from: b */
    private int f469b;

    /* renamed from: c */
    private long f470c;

    /* renamed from: d */
    private C0171cj f471d;

    /* renamed from: e */
    private byte f472e;

    /* renamed from: f */
    private int f473f;

    private C0138bd(C0139be c0139be) {
        super(c0139be);
        this.f472e = (byte) -1;
        this.f473f = -1;
    }

    private C0138bd(boolean z) {
        this.f472e = (byte) -1;
        this.f473f = -1;
    }

    /* renamed from: a */
    public static C0138bd m1013a() {
        return f468a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0138bd getDefaultInstanceForType() {
        return f468a;
    }

    /* renamed from: c */
    public boolean m1019c() {
        return (this.f469b & 1) == 1;
    }

    /* renamed from: d */
    public long m1020d() {
        return this.f470c;
    }

    /* renamed from: e */
    public boolean m1021e() {
        return (this.f469b & 2) == 2;
    }

    /* renamed from: f */
    public C0171cj m1022f() {
        return this.f471d;
    }

    /* renamed from: i */
    private void m1017i() {
        this.f470c = 0L;
        this.f471d = C0171cj.m1459a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f472e;
        if (b != -1) {
            return b == 1;
        }
        this.f472e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f469b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f470c);
        }
        if ((this.f469b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f471d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f473f;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f469b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f470c) : 0;
            if ((this.f469b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f471d);
            }
            this.f473f = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0138bd m1014a(byte[] bArr) {
        return ((C0139be) newBuilder().mergeFrom(bArr)).m1029k();
    }

    public static C0139be newBuilder() {
        return C0139be.m1028j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0139be newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0139be m1015a(C0138bd c0138bd) {
        return newBuilder().mergeFrom(c0138bd);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0139be toBuilder() {
        return m1015a(this);
    }

    static {
        f468a.m1017i();
    }
}
