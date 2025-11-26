package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ej */
/* loaded from: classes.dex */
public final class C0910ej extends GeneratedMessageLite implements InterfaceC0912el {

    /* renamed from: a */
    private static final C0910ej f2845a = new C0910ej(true);

    /* renamed from: b */
    private int f2846b;

    /* renamed from: c */
    private Object f2847c;

    /* renamed from: d */
    private Object f2848d;

    /* renamed from: e */
    private byte f2849e;

    /* renamed from: f */
    private int f2850f;

    private C0910ej(C0911ek c0911ek) {
        super(c0911ek);
        this.f2849e = (byte) -1;
        this.f2850f = -1;
    }

    private C0910ej(boolean z) {
        this.f2849e = (byte) -1;
        this.f2850f = -1;
    }

    /* renamed from: a */
    public static C0910ej m4890a() {
        return f2845a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0910ej getDefaultInstanceForType() {
        return f2845a;
    }

    /* renamed from: c */
    public boolean m4898c() {
        return (this.f2846b & 1) == 1;
    }

    /* renamed from: d */
    public String m4899d() {
        Object obj = this.f2847c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2847c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m4894i() {
        Object obj = this.f2847c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2847c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m4900e() {
        return (this.f2846b & 2) == 2;
    }

    /* renamed from: f */
    public String m4901f() {
        Object obj = this.f2848d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2848d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: j */
    private ByteString m4895j() {
        Object obj = this.f2848d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2848d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    private void m4896k() {
        this.f2847c = "";
        this.f2848d = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2849e;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2849e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2846b & 1) == 1) {
            codedOutputStream.writeBytes(1, m4894i());
        }
        if ((this.f2846b & 2) == 2) {
            codedOutputStream.writeBytes(2, m4895j());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f2850f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f2846b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m4894i()) : 0;
            if ((this.f2846b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m4895j());
            }
            this.f2850f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0911ek newBuilder() {
        return C0911ek.m4906h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0911ek newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0911ek m4891a(C0910ej c0910ej) {
        return newBuilder().mergeFrom(c0910ej);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0911ek toBuilder() {
        return m4891a(this);
    }

    static {
        f2845a.m4896k();
    }
}
