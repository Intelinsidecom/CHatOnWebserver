package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.aw */
/* loaded from: classes.dex */
public final class C0815aw extends GeneratedMessageLite implements InterfaceC0817ay {

    /* renamed from: a */
    private static final C0815aw f2294a = new C0815aw(true);

    /* renamed from: b */
    private int f2295b;

    /* renamed from: c */
    private long f2296c;

    /* renamed from: d */
    private Object f2297d;

    /* renamed from: e */
    private C0957gc f2298e;

    /* renamed from: f */
    private long f2299f;

    /* renamed from: g */
    private C0935fh f2300g;

    /* renamed from: h */
    private long f2301h;

    /* renamed from: i */
    private byte f2302i;

    /* renamed from: j */
    private int f2303j;

    private C0815aw(C0816ax c0816ax) {
        super(c0816ax);
        this.f2302i = (byte) -1;
        this.f2303j = -1;
    }

    private C0815aw(boolean z) {
        this.f2302i = (byte) -1;
        this.f2303j = -1;
    }

    /* renamed from: a */
    public static C0815aw m3432a() {
        return f2294a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0815aw getDefaultInstanceForType() {
        return f2294a;
    }

    /* renamed from: c */
    public boolean m3443c() {
        return (this.f2295b & 1) == 1;
    }

    /* renamed from: d */
    public long m3444d() {
        return this.f2296c;
    }

    /* renamed from: e */
    public boolean m3445e() {
        return (this.f2295b & 2) == 2;
    }

    /* renamed from: f */
    public String m3446f() {
        Object obj = this.f2297d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2297d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m3440q() {
        Object obj = this.f2297d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2297d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m3447g() {
        return (this.f2295b & 4) == 4;
    }

    /* renamed from: h */
    public C0957gc m3448h() {
        return this.f2298e;
    }

    /* renamed from: i */
    public boolean m3449i() {
        return (this.f2295b & 8) == 8;
    }

    /* renamed from: j */
    public long m3450j() {
        return this.f2299f;
    }

    /* renamed from: k */
    public boolean m3451k() {
        return (this.f2295b & 16) == 16;
    }

    /* renamed from: l */
    public C0935fh m3452l() {
        return this.f2300g;
    }

    /* renamed from: m */
    public boolean m3453m() {
        return (this.f2295b & 32) == 32;
    }

    /* renamed from: n */
    public long m3454n() {
        return this.f2301h;
    }

    /* renamed from: r */
    private void m3441r() {
        this.f2296c = 0L;
        this.f2297d = "";
        this.f2298e = C0957gc.m5553a();
        this.f2299f = 0L;
        this.f2300g = C0935fh.m5211a();
        this.f2301h = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2302i;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2302i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2295b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2296c);
        }
        if ((this.f2295b & 2) == 2) {
            codedOutputStream.writeBytes(2, m3440q());
        }
        if ((this.f2295b & 4) == 4) {
            codedOutputStream.writeMessage(3, this.f2298e);
        }
        if ((this.f2295b & 8) == 8) {
            codedOutputStream.writeInt64(4, this.f2299f);
        }
        if ((this.f2295b & 16) == 16) {
            codedOutputStream.writeMessage(5, this.f2300g);
        }
        if ((this.f2295b & 32) == 32) {
            codedOutputStream.writeInt64(6, this.f2301h);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f2303j;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f2295b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f2296c) : 0;
            if ((this.f2295b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m3440q());
            }
            if ((this.f2295b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(3, this.f2298e);
            }
            if ((this.f2295b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(4, this.f2299f);
            }
            if ((this.f2295b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(5, this.f2300g);
            }
            if ((this.f2295b & 32) == 32) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(6, this.f2301h);
            }
            this.f2303j = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0815aw m3433a(byte[] bArr) {
        return ((C0816ax) newBuilder().mergeFrom(bArr)).m3461m();
    }

    public static C0816ax newBuilder() {
        return C0816ax.m3460l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C0816ax newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0816ax m3434a(C0815aw c0815aw) {
        return newBuilder().mergeFrom(c0815aw);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0816ax toBuilder() {
        return m3434a(this);
    }

    static {
        f2294a.m3441r();
    }
}
