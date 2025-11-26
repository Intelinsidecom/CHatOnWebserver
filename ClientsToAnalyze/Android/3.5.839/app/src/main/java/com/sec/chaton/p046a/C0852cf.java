package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cf */
/* loaded from: classes.dex */
public final class C0852cf extends GeneratedMessageLite implements InterfaceC0854ch {

    /* renamed from: a */
    private static final C0852cf f2489a = new C0852cf(true);

    /* renamed from: b */
    private int f2490b;

    /* renamed from: c */
    private Object f2491c;

    /* renamed from: d */
    private C0864cr f2492d;

    /* renamed from: e */
    private boolean f2493e;

    /* renamed from: f */
    private long f2494f;

    /* renamed from: g */
    private long f2495g;

    /* renamed from: h */
    private byte f2496h;

    /* renamed from: i */
    private int f2497i;

    private C0852cf(C0853cg c0853cg) {
        super(c0853cg);
        this.f2496h = (byte) -1;
        this.f2497i = -1;
    }

    private C0852cf(boolean z) {
        this.f2496h = (byte) -1;
        this.f2497i = -1;
    }

    /* renamed from: a */
    public static C0852cf m3921a() {
        return f2489a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0852cf getDefaultInstanceForType() {
        return f2489a;
    }

    /* renamed from: c */
    public boolean m3931c() {
        return (this.f2490b & 1) == 1;
    }

    /* renamed from: d */
    public String m3932d() {
        Object obj = this.f2491c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2491c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m3928o() {
        Object obj = this.f2491c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2491c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m3933e() {
        return (this.f2490b & 2) == 2;
    }

    /* renamed from: f */
    public C0864cr m3934f() {
        return this.f2492d;
    }

    /* renamed from: g */
    public boolean m3935g() {
        return (this.f2490b & 4) == 4;
    }

    /* renamed from: h */
    public boolean m3936h() {
        return this.f2493e;
    }

    /* renamed from: i */
    public boolean m3937i() {
        return (this.f2490b & 8) == 8;
    }

    /* renamed from: j */
    public long m3938j() {
        return this.f2494f;
    }

    /* renamed from: k */
    public boolean m3939k() {
        return (this.f2490b & 16) == 16;
    }

    /* renamed from: l */
    public long m3940l() {
        return this.f2495g;
    }

    /* renamed from: p */
    private void m3929p() {
        this.f2491c = "";
        this.f2492d = C0864cr.m4134a();
        this.f2493e = false;
        this.f2494f = 0L;
        this.f2495g = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2496h;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2496h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2490b & 1) == 1) {
            codedOutputStream.writeBytes(1, m3928o());
        }
        if ((this.f2490b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f2492d);
        }
        if ((this.f2490b & 4) == 4) {
            codedOutputStream.writeBool(3, this.f2493e);
        }
        if ((this.f2490b & 8) == 8) {
            codedOutputStream.writeInt64(4, this.f2494f);
        }
        if ((this.f2490b & 16) == 16) {
            codedOutputStream.writeInt64(5, this.f2495g);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f2497i;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f2490b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m3928o()) : 0;
            if ((this.f2490b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeMessageSize(2, this.f2492d);
            }
            if ((this.f2490b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeBoolSize(3, this.f2493e);
            }
            if ((this.f2490b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(4, this.f2494f);
            }
            if ((this.f2490b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(5, this.f2495g);
            }
            this.f2497i = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0852cf m3922a(byte[] bArr) {
        return ((C0853cg) newBuilder().mergeFrom(bArr)).m3947k();
    }

    public static C0853cg newBuilder() {
        return C0853cg.m3946j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0853cg newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0853cg m3923a(C0852cf c0852cf) {
        return newBuilder().mergeFrom(c0852cf);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0853cg toBuilder() {
        return m3923a(this);
    }

    static {
        f2489a.m3929p();
    }
}
