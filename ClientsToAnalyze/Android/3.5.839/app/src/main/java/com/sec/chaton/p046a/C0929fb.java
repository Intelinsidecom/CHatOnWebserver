package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fb */
/* loaded from: classes.dex */
public final class C0929fb extends GeneratedMessageLite implements InterfaceC0931fd {

    /* renamed from: a */
    private static final C0929fb f2914a = new C0929fb(true);

    /* renamed from: b */
    private int f2915b;

    /* renamed from: c */
    private long f2916c;

    /* renamed from: d */
    private C0935fh f2917d;

    /* renamed from: e */
    private Object f2918e;

    /* renamed from: f */
    private byte f2919f;

    /* renamed from: g */
    private int f2920g;

    private C0929fb(C0930fc c0930fc) {
        super(c0930fc);
        this.f2919f = (byte) -1;
        this.f2920g = -1;
    }

    private C0929fb(boolean z) {
        this.f2919f = (byte) -1;
        this.f2920g = -1;
    }

    /* renamed from: a */
    public static C0929fb m5105a() {
        return f2914a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0929fb getDefaultInstanceForType() {
        return f2914a;
    }

    /* renamed from: c */
    public boolean m5113c() {
        return (this.f2915b & 1) == 1;
    }

    /* renamed from: d */
    public long m5114d() {
        return this.f2916c;
    }

    /* renamed from: e */
    public boolean m5115e() {
        return (this.f2915b & 2) == 2;
    }

    /* renamed from: f */
    public C0935fh m5116f() {
        return this.f2917d;
    }

    /* renamed from: g */
    public boolean m5117g() {
        return (this.f2915b & 4) == 4;
    }

    /* renamed from: h */
    public String m5118h() {
        Object obj = this.f2918e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2918e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m5110k() {
        Object obj = this.f2918e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2918e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: l */
    private void m5111l() {
        this.f2916c = 0L;
        this.f2917d = C0935fh.m5211a();
        this.f2918e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2919f;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2919f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2915b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2916c);
        }
        if ((this.f2915b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f2917d);
        }
        if ((this.f2915b & 4) == 4) {
            codedOutputStream.writeBytes(3, m5110k());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f2920g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f2915b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f2916c) : 0;
            if ((this.f2915b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f2917d);
            }
            if ((this.f2915b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m5110k());
            }
            this.f2920g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0929fb m5106a(byte[] bArr) {
        return ((C0930fc) newBuilder().mergeFrom(bArr)).m5125k();
    }

    public static C0930fc newBuilder() {
        return C0930fc.m5124j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0930fc newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0930fc m5107a(C0929fb c0929fb) {
        return newBuilder().mergeFrom(c0929fb);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0930fc toBuilder() {
        return m5107a(this);
    }

    static {
        f2914a.m5111l();
    }
}
