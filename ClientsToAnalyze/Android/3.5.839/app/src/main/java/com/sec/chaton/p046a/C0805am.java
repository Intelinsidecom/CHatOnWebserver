package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.am */
/* loaded from: classes.dex */
public final class C0805am extends GeneratedMessageLite implements InterfaceC0807ao {

    /* renamed from: a */
    private static final C0805am f2235a = new C0805am(true);

    /* renamed from: b */
    private int f2236b;

    /* renamed from: c */
    private long f2237c;

    /* renamed from: d */
    private C0935fh f2238d;

    /* renamed from: e */
    private long f2239e;

    /* renamed from: f */
    private Object f2240f;

    /* renamed from: g */
    private byte f2241g;

    /* renamed from: h */
    private int f2242h;

    private C0805am(C0806an c0806an) {
        super(c0806an);
        this.f2241g = (byte) -1;
        this.f2242h = -1;
    }

    private C0805am(boolean z) {
        this.f2241g = (byte) -1;
        this.f2242h = -1;
    }

    /* renamed from: a */
    public static C0805am m3309a() {
        return f2235a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0805am getDefaultInstanceForType() {
        return f2235a;
    }

    /* renamed from: c */
    public boolean m3318c() {
        return (this.f2236b & 1) == 1;
    }

    /* renamed from: d */
    public long m3319d() {
        return this.f2237c;
    }

    /* renamed from: e */
    public boolean m3320e() {
        return (this.f2236b & 2) == 2;
    }

    /* renamed from: f */
    public C0935fh m3321f() {
        return this.f2238d;
    }

    /* renamed from: g */
    public boolean m3322g() {
        return (this.f2236b & 4) == 4;
    }

    /* renamed from: h */
    public long m3323h() {
        return this.f2239e;
    }

    /* renamed from: i */
    public boolean m3324i() {
        return (this.f2236b & 8) == 8;
    }

    /* renamed from: j */
    public String m3325j() {
        Object obj = this.f2240f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2240f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m3315m() {
        Object obj = this.f2240f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2240f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: n */
    private void m3316n() {
        this.f2237c = 0L;
        this.f2238d = C0935fh.m5211a();
        this.f2239e = 0L;
        this.f2240f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2241g;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2241g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2236b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2237c);
        }
        if ((this.f2236b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f2238d);
        }
        if ((this.f2236b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f2239e);
        }
        if ((this.f2236b & 8) == 8) {
            codedOutputStream.writeBytes(4, m3315m());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f2242h;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f2236b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f2237c) : 0;
            if ((this.f2236b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f2238d);
            }
            if ((this.f2236b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(3, this.f2239e);
            }
            if ((this.f2236b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m3315m());
            }
            this.f2242h = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0805am m3310a(byte[] bArr) {
        return ((C0806an) newBuilder().mergeFrom(bArr)).m3332k();
    }

    public static C0806an newBuilder() {
        return C0806an.m3331j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0806an newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0806an m3311a(C0805am c0805am) {
        return newBuilder().mergeFrom(c0805am);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0806an toBuilder() {
        return m3311a(this);
    }

    static {
        f2235a.m3316n();
    }
}
