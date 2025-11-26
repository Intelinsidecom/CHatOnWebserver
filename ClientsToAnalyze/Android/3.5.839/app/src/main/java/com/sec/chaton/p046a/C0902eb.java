package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.eb */
/* loaded from: classes.dex */
public final class C0902eb extends GeneratedMessageLite implements InterfaceC0904ed {

    /* renamed from: a */
    private static final C0902eb f2808a = new C0902eb(true);

    /* renamed from: b */
    private int f2809b;

    /* renamed from: c */
    private Object f2810c;

    /* renamed from: d */
    private long f2811d;

    /* renamed from: e */
    private Object f2812e;

    /* renamed from: f */
    private long f2813f;

    /* renamed from: g */
    private byte f2814g;

    /* renamed from: h */
    private int f2815h;

    private C0902eb(C0903ec c0903ec) {
        super(c0903ec);
        this.f2814g = (byte) -1;
        this.f2815h = -1;
    }

    private C0902eb(boolean z) {
        this.f2814g = (byte) -1;
        this.f2815h = -1;
    }

    /* renamed from: a */
    public static C0902eb m4810a() {
        return f2808a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0902eb getDefaultInstanceForType() {
        return f2808a;
    }

    /* renamed from: c */
    public boolean m4820c() {
        return (this.f2809b & 1) == 1;
    }

    /* renamed from: d */
    public String m4821d() {
        Object obj = this.f2810c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2810c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m4816m() {
        Object obj = this.f2810c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2810c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m4822e() {
        return (this.f2809b & 2) == 2;
    }

    /* renamed from: f */
    public long m4823f() {
        return this.f2811d;
    }

    /* renamed from: g */
    public boolean m4824g() {
        return (this.f2809b & 4) == 4;
    }

    /* renamed from: h */
    public String m4825h() {
        Object obj = this.f2812e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2812e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m4817n() {
        Object obj = this.f2812e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2812e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m4826i() {
        return (this.f2809b & 8) == 8;
    }

    /* renamed from: j */
    public long m4827j() {
        return this.f2813f;
    }

    /* renamed from: o */
    private void m4818o() {
        this.f2810c = "";
        this.f2811d = 0L;
        this.f2812e = "";
        this.f2813f = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2814g;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2814g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2809b & 1) == 1) {
            codedOutputStream.writeBytes(1, m4816m());
        }
        if ((this.f2809b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f2811d);
        }
        if ((this.f2809b & 4) == 4) {
            codedOutputStream.writeBytes(3, m4817n());
        }
        if ((this.f2809b & 8) == 8) {
            codedOutputStream.writeInt64(4, this.f2813f);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f2815h;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f2809b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m4816m()) : 0;
            if ((this.f2809b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(2, this.f2811d);
            }
            if ((this.f2809b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(3, m4817n());
            }
            if ((this.f2809b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(4, this.f2813f);
            }
            this.f2815h = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0902eb m4811a(byte[] bArr) {
        return ((C0903ec) newBuilder().mergeFrom(bArr)).m4834i();
    }

    public static C0903ec newBuilder() {
        return C0903ec.m4833h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0903ec newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0903ec m4812a(C0902eb c0902eb) {
        return newBuilder().mergeFrom(c0902eb);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0903ec toBuilder() {
        return m4812a(this);
    }

    static {
        f2808a.m4818o();
    }
}
