package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bz */
/* loaded from: classes.dex */
public final class C0845bz extends GeneratedMessageLite implements InterfaceC0848cb {

    /* renamed from: a */
    private static final C0845bz f2447a = new C0845bz(true);

    /* renamed from: b */
    private int f2448b;

    /* renamed from: c */
    private long f2449c;

    /* renamed from: d */
    private C0935fh f2450d;

    /* renamed from: e */
    private Object f2451e;

    /* renamed from: f */
    private byte f2452f;

    /* renamed from: g */
    private int f2453g;

    private C0845bz(C0847ca c0847ca) {
        super(c0847ca);
        this.f2452f = (byte) -1;
        this.f2453g = -1;
    }

    private C0845bz(boolean z) {
        this.f2452f = (byte) -1;
        this.f2453g = -1;
    }

    /* renamed from: a */
    public static C0845bz m3801a() {
        return f2447a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0845bz getDefaultInstanceForType() {
        return f2447a;
    }

    /* renamed from: c */
    public boolean m3809c() {
        return (this.f2448b & 1) == 1;
    }

    /* renamed from: d */
    public long m3810d() {
        return this.f2449c;
    }

    /* renamed from: e */
    public boolean m3811e() {
        return (this.f2448b & 2) == 2;
    }

    /* renamed from: f */
    public C0935fh m3812f() {
        return this.f2450d;
    }

    /* renamed from: g */
    public boolean m3813g() {
        return (this.f2448b & 4) == 4;
    }

    /* renamed from: h */
    public String m3814h() {
        Object obj = this.f2451e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2451e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m3806k() {
        Object obj = this.f2451e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2451e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: l */
    private void m3807l() {
        this.f2449c = 0L;
        this.f2450d = C0935fh.m5211a();
        this.f2451e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2452f;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2452f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2448b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2449c);
        }
        if ((this.f2448b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f2450d);
        }
        if ((this.f2448b & 4) == 4) {
            codedOutputStream.writeBytes(3, m3806k());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f2453g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f2448b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f2449c) : 0;
            if ((this.f2448b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f2450d);
            }
            if ((this.f2448b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m3806k());
            }
            this.f2453g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0845bz m3802a(byte[] bArr) {
        return ((C0847ca) newBuilder().mergeFrom(bArr)).m3835k();
    }

    public static C0847ca newBuilder() {
        return C0847ca.m3834j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0847ca newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0847ca m3803a(C0845bz c0845bz) {
        return newBuilder().mergeFrom(c0845bz);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0847ca toBuilder() {
        return m3803a(this);
    }

    static {
        f2447a.m3807l();
    }
}
