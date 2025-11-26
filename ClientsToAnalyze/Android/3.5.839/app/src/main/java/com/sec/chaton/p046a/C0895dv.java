package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dv */
/* loaded from: classes.dex */
public final class C0895dv extends GeneratedMessageLite implements InterfaceC0897dx {

    /* renamed from: a */
    private static final C0895dv f2762a = new C0895dv(true);

    /* renamed from: b */
    private int f2763b;

    /* renamed from: c */
    private long f2764c;

    /* renamed from: d */
    private Object f2765d;

    /* renamed from: e */
    private C0935fh f2766e;

    /* renamed from: f */
    private long f2767f;

    /* renamed from: g */
    private byte f2768g;

    /* renamed from: h */
    private int f2769h;

    private C0895dv(C0896dw c0896dw) {
        super(c0896dw);
        this.f2768g = (byte) -1;
        this.f2769h = -1;
    }

    private C0895dv(boolean z) {
        this.f2768g = (byte) -1;
        this.f2769h = -1;
    }

    /* renamed from: a */
    public static C0895dv m4687a() {
        return f2762a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0895dv getDefaultInstanceForType() {
        return f2762a;
    }

    /* renamed from: c */
    public boolean m4696c() {
        return (this.f2763b & 1) == 1;
    }

    /* renamed from: d */
    public long m4697d() {
        return this.f2764c;
    }

    /* renamed from: e */
    public boolean m4698e() {
        return (this.f2763b & 2) == 2;
    }

    /* renamed from: f */
    public String m4699f() {
        Object obj = this.f2765d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2765d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m4693m() {
        Object obj = this.f2765d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2765d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m4700g() {
        return (this.f2763b & 4) == 4;
    }

    /* renamed from: h */
    public C0935fh m4701h() {
        return this.f2766e;
    }

    /* renamed from: i */
    public boolean m4702i() {
        return (this.f2763b & 8) == 8;
    }

    /* renamed from: j */
    public long m4703j() {
        return this.f2767f;
    }

    /* renamed from: n */
    private void m4694n() {
        this.f2764c = 0L;
        this.f2765d = "";
        this.f2766e = C0935fh.m5211a();
        this.f2767f = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2768g;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2768g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2763b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2764c);
        }
        if ((this.f2763b & 2) == 2) {
            codedOutputStream.writeBytes(2, m4693m());
        }
        if ((this.f2763b & 4) == 4) {
            codedOutputStream.writeMessage(3, this.f2766e);
        }
        if ((this.f2763b & 8) == 8) {
            codedOutputStream.writeInt64(4, this.f2767f);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f2769h;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f2763b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f2764c) : 0;
            if ((this.f2763b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m4693m());
            }
            if ((this.f2763b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(3, this.f2766e);
            }
            if ((this.f2763b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(4, this.f2767f);
            }
            this.f2769h = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0895dv m4688a(byte[] bArr) {
        return ((C0896dw) newBuilder().mergeFrom(bArr)).m4710k();
    }

    public static C0896dw newBuilder() {
        return C0896dw.m4709j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0896dw newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0896dw m4689a(C0895dv c0895dv) {
        return newBuilder().mergeFrom(c0895dv);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0896dw toBuilder() {
        return m4689a(this);
    }

    static {
        f2762a.m4694n();
    }
}
