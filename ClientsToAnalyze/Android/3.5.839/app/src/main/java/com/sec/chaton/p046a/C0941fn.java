package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fn */
/* loaded from: classes.dex */
public final class C0941fn extends GeneratedMessageLite implements InterfaceC0943fp {

    /* renamed from: a */
    private static final C0941fn f2982a = new C0941fn(true);

    /* renamed from: b */
    private int f2983b;

    /* renamed from: c */
    private long f2984c;

    /* renamed from: d */
    private Object f2985d;

    /* renamed from: e */
    private Object f2986e;

    /* renamed from: f */
    private Object f2987f;

    /* renamed from: g */
    private byte f2988g;

    /* renamed from: h */
    private int f2989h;

    private C0941fn(C0942fo c0942fo) {
        super(c0942fo);
        this.f2988g = (byte) -1;
        this.f2989h = -1;
    }

    private C0941fn(boolean z) {
        this.f2988g = (byte) -1;
        this.f2989h = -1;
    }

    /* renamed from: a */
    public static C0941fn m5301a() {
        return f2982a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0941fn getDefaultInstanceForType() {
        return f2982a;
    }

    /* renamed from: c */
    public boolean m5312c() {
        return (this.f2983b & 1) == 1;
    }

    /* renamed from: d */
    public long m5313d() {
        return this.f2984c;
    }

    /* renamed from: e */
    public boolean m5314e() {
        return (this.f2983b & 2) == 2;
    }

    /* renamed from: f */
    public String m5315f() {
        Object obj = this.f2985d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2985d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m5307m() {
        Object obj = this.f2985d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2985d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m5316g() {
        return (this.f2983b & 4) == 4;
    }

    /* renamed from: h */
    public String m5317h() {
        Object obj = this.f2986e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2986e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m5308n() {
        Object obj = this.f2986e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2986e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m5318i() {
        return (this.f2983b & 8) == 8;
    }

    /* renamed from: j */
    public String m5319j() {
        Object obj = this.f2987f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2987f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m5309o() {
        Object obj = this.f2987f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2987f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    private void m5310p() {
        this.f2984c = 0L;
        this.f2985d = "";
        this.f2986e = "";
        this.f2987f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2988g;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2988g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2983b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2984c);
        }
        if ((this.f2983b & 2) == 2) {
            codedOutputStream.writeBytes(2, m5307m());
        }
        if ((this.f2983b & 4) == 4) {
            codedOutputStream.writeBytes(3, m5308n());
        }
        if ((this.f2983b & 8) == 8) {
            codedOutputStream.writeBytes(4, m5309o());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f2989h;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f2983b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f2984c) : 0;
            if ((this.f2983b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m5307m());
            }
            if ((this.f2983b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m5308n());
            }
            if ((this.f2983b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m5309o());
            }
            this.f2989h = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0941fn m5302a(byte[] bArr) {
        return ((C0942fo) newBuilder().mergeFrom(bArr)).m5326i();
    }

    public static C0942fo newBuilder() {
        return C0942fo.m5325h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0942fo newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0942fo m5303a(C0941fn c0941fn) {
        return newBuilder().mergeFrom(c0941fn);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0942fo toBuilder() {
        return m5303a(this);
    }

    static {
        f2982a.m5310p();
    }
}
