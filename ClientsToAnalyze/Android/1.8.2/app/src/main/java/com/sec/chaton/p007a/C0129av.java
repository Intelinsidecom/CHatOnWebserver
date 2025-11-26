package com.sec.chaton.p007a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.av */
/* loaded from: classes.dex */
public final class C0129av extends GeneratedMessageLite implements InterfaceC0131ax {

    /* renamed from: a */
    private static final C0129av f441a = new C0129av(true);

    /* renamed from: b */
    private int f442b;

    /* renamed from: c */
    private long f443c;

    /* renamed from: d */
    private EnumC0127at f444d;

    /* renamed from: e */
    private C0171cj f445e;

    /* renamed from: f */
    private byte f446f;

    /* renamed from: g */
    private int f447g;

    private C0129av(C0130aw c0130aw) {
        super(c0130aw);
        this.f446f = (byte) -1;
        this.f447g = -1;
    }

    private C0129av(boolean z) {
        this.f446f = (byte) -1;
        this.f447g = -1;
    }

    /* renamed from: a */
    public static C0129av m942a() {
        return f441a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0129av getDefaultInstanceForType() {
        return f441a;
    }

    /* renamed from: c */
    public boolean m948c() {
        return (this.f442b & 1) == 1;
    }

    /* renamed from: d */
    public long m949d() {
        return this.f443c;
    }

    /* renamed from: e */
    public boolean m950e() {
        return (this.f442b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0127at m951f() {
        return this.f444d;
    }

    /* renamed from: g */
    public boolean m952g() {
        return (this.f442b & 4) == 4;
    }

    /* renamed from: h */
    public C0171cj m953h() {
        return this.f445e;
    }

    /* renamed from: k */
    private void m946k() {
        this.f443c = 0L;
        this.f444d = EnumC0127at.CLOSE;
        this.f445e = C0171cj.m1459a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f446f;
        if (b != -1) {
            return b == 1;
        }
        this.f446f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f442b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f443c);
        }
        if ((this.f442b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f444d.getNumber());
        }
        if ((this.f442b & 4) == 4) {
            codedOutputStream.writeMessage(3, this.f445e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f447g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f442b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f443c) : 0;
            if ((this.f442b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f444d.getNumber());
            }
            if ((this.f442b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(3, this.f445e);
            }
            this.f447g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0129av m943a(byte[] bArr) {
        return ((C0130aw) newBuilder().mergeFrom(bArr)).m960m();
    }

    public static C0130aw newBuilder() {
        return C0130aw.m959l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0130aw newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0130aw m944a(C0129av c0129av) {
        return newBuilder().mergeFrom(c0129av);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0130aw toBuilder() {
        return m944a(this);
    }

    static {
        f441a.m946k();
    }
}
