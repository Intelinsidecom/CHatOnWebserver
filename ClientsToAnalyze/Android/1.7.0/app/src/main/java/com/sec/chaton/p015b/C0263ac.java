package com.sec.chaton.p015b;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.ac */
/* loaded from: classes.dex */
public final class C0263ac extends GeneratedMessageLite implements InterfaceC0271ak {

    /* renamed from: a */
    private static final C0263ac f651a = new C0263ac(true);

    /* renamed from: b */
    private int f652b;

    /* renamed from: c */
    private long f653c;

    /* renamed from: d */
    private C0313bz f654d;

    /* renamed from: e */
    private byte f655e;

    /* renamed from: f */
    private int f656f;

    private C0263ac(C0276ap c0276ap) {
        super(c0276ap);
        this.f655e = (byte) -1;
        this.f656f = -1;
    }

    private C0263ac(boolean z) {
        this.f655e = (byte) -1;
        this.f656f = -1;
    }

    /* renamed from: a */
    public static C0263ac m985a() {
        return f651a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0263ac getDefaultInstanceForType() {
        return f651a;
    }

    /* renamed from: c */
    public boolean m991c() {
        return (this.f652b & 1) == 1;
    }

    /* renamed from: d */
    public long m992d() {
        return this.f653c;
    }

    /* renamed from: e */
    public boolean m993e() {
        return (this.f652b & 2) == 2;
    }

    /* renamed from: f */
    public C0313bz m994f() {
        return this.f654d;
    }

    /* renamed from: i */
    private void m989i() {
        this.f653c = 0L;
        this.f654d = C0313bz.m1619a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f655e;
        if (b != -1) {
            return b == 1;
        }
        this.f655e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f652b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f653c);
        }
        if ((this.f652b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f654d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f656f;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f652b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f653c) : 0;
            if ((this.f652b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f654d);
            }
            this.f656f = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0263ac m986a(byte[] bArr) {
        return ((C0276ap) newBuilder().mergeFrom(bArr)).m1175k();
    }

    public static C0276ap newBuilder() {
        return C0276ap.m1174j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0276ap newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0276ap m987a(C0263ac c0263ac) {
        return newBuilder().mergeFrom(c0263ac);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0276ap toBuilder() {
        return m987a(this);
    }

    static {
        f651a.m989i();
    }
}
