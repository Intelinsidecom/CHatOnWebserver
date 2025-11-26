package com.sec.chaton.p046a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.br */
/* loaded from: classes.dex */
public final class C0837br extends GeneratedMessageLite implements InterfaceC0839bt {

    /* renamed from: a */
    private static final C0837br f2420a = new C0837br(true);

    /* renamed from: b */
    private int f2421b;

    /* renamed from: c */
    private long f2422c;

    /* renamed from: d */
    private EnumC0835bp f2423d;

    /* renamed from: e */
    private C0935fh f2424e;

    /* renamed from: f */
    private byte f2425f;

    /* renamed from: g */
    private int f2426g;

    private C0837br(C0838bs c0838bs) {
        super(c0838bs);
        this.f2425f = (byte) -1;
        this.f2426g = -1;
    }

    private C0837br(boolean z) {
        this.f2425f = (byte) -1;
        this.f2426g = -1;
    }

    /* renamed from: a */
    public static C0837br m3730a() {
        return f2420a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0837br getDefaultInstanceForType() {
        return f2420a;
    }

    /* renamed from: c */
    public boolean m3736c() {
        return (this.f2421b & 1) == 1;
    }

    /* renamed from: d */
    public long m3737d() {
        return this.f2422c;
    }

    /* renamed from: e */
    public boolean m3738e() {
        return (this.f2421b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0835bp m3739f() {
        return this.f2423d;
    }

    /* renamed from: g */
    public boolean m3740g() {
        return (this.f2421b & 4) == 4;
    }

    /* renamed from: h */
    public C0935fh m3741h() {
        return this.f2424e;
    }

    /* renamed from: k */
    private void m3734k() {
        this.f2422c = 0L;
        this.f2423d = EnumC0835bp.CLOSE;
        this.f2424e = C0935fh.m5211a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2425f;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2425f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2421b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2422c);
        }
        if ((this.f2421b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f2423d.getNumber());
        }
        if ((this.f2421b & 4) == 4) {
            codedOutputStream.writeMessage(3, this.f2424e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f2426g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f2421b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f2422c) : 0;
            if ((this.f2421b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f2423d.getNumber());
            }
            if ((this.f2421b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(3, this.f2424e);
            }
            this.f2426g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0837br m3731a(byte[] bArr) {
        return ((C0838bs) newBuilder().mergeFrom(bArr)).m3748m();
    }

    public static C0838bs newBuilder() {
        return C0838bs.m3747l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0838bs newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0838bs m3732a(C0837br c0837br) {
        return newBuilder().mergeFrom(c0837br);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0838bs toBuilder() {
        return m3732a(this);
    }

    static {
        f2420a.m3734k();
    }
}
