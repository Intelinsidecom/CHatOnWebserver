package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.w */
/* loaded from: classes.dex */
public final class C0104w extends GeneratedMessageLite implements InterfaceC0091j {

    /* renamed from: a */
    private static final C0104w f191a = new C0104w(true);

    /* renamed from: b */
    private int f192b;

    /* renamed from: c */
    private int f193c;

    /* renamed from: d */
    private long f194d;

    /* renamed from: e */
    private int f195e;

    /* renamed from: f */
    private byte f196f;

    /* renamed from: g */
    private int f197g;

    private C0104w(C0075ai c0075ai) {
        super(c0075ai);
        this.f196f = (byte) -1;
        this.f197g = -1;
    }

    private C0104w(boolean z) {
        this.f196f = (byte) -1;
        this.f197g = -1;
    }

    /* renamed from: a */
    public static C0104w m548a() {
        return f191a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0104w getDefaultInstanceForType() {
        return f191a;
    }

    /* renamed from: c */
    public boolean m554c() {
        return (this.f192b & 1) == 1;
    }

    /* renamed from: d */
    public int m555d() {
        return this.f193c;
    }

    /* renamed from: e */
    public boolean m556e() {
        return (this.f192b & 2) == 2;
    }

    /* renamed from: f */
    public long m557f() {
        return this.f194d;
    }

    /* renamed from: g */
    public boolean m558g() {
        return (this.f192b & 4) == 4;
    }

    /* renamed from: h */
    public int m559h() {
        return this.f195e;
    }

    /* renamed from: k */
    private void m552k() {
        this.f193c = 0;
        this.f194d = 0L;
        this.f195e = 0;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f196f;
        if (b != -1) {
            return b == 1;
        }
        this.f196f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f192b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f193c);
        }
        if ((this.f192b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f194d);
        }
        if ((this.f192b & 4) == 4) {
            codedOutputStream.writeInt32(3, this.f195e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f197g;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f192b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f193c) : 0;
            if ((this.f192b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt64Size(2, this.f194d);
            }
            if ((this.f192b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, this.f195e);
            }
            this.f197g = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0104w m549a(byte[] bArr) {
        return ((C0075ai) newBuilder().mergeFrom(bArr)).m239i();
    }

    public static C0075ai newBuilder() {
        return C0075ai.m238h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0075ai newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0075ai m547a(C0104w c0104w) {
        return newBuilder().mergeFrom(c0104w);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0075ai toBuilder() {
        return m547a(this);
    }

    static {
        f191a.m552k();
    }
}
