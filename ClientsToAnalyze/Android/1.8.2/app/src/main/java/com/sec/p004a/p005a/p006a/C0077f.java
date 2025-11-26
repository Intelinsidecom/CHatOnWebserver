package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.f */
/* loaded from: classes.dex */
public final class C0077f extends GeneratedMessageLite implements InterfaceC0079h {

    /* renamed from: a */
    private static final C0077f f118a = new C0077f(true);

    /* renamed from: b */
    private int f119b;

    /* renamed from: c */
    private int f120c;

    /* renamed from: d */
    private Object f121d;

    /* renamed from: e */
    private Object f122e;

    /* renamed from: f */
    private Object f123f;

    /* renamed from: g */
    private byte f124g;

    /* renamed from: h */
    private int f125h;

    private C0077f(C0078g c0078g) {
        super(c0078g);
        this.f124g = (byte) -1;
        this.f125h = -1;
    }

    private C0077f(boolean z) {
        this.f124g = (byte) -1;
        this.f125h = -1;
    }

    /* renamed from: a */
    public static C0077f m325a() {
        return f118a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0077f getDefaultInstanceForType() {
        return f118a;
    }

    /* renamed from: c */
    public boolean m337c() {
        return (this.f119b & 1) == 1;
    }

    /* renamed from: d */
    public int m338d() {
        return this.f120c;
    }

    /* renamed from: e */
    public boolean m339e() {
        return (this.f119b & 2) == 2;
    }

    /* renamed from: f */
    public String m340f() {
        Object obj = this.f121d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f121d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m332m() {
        Object obj = this.f121d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f121d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m341g() {
        return (this.f119b & 4) == 4;
    }

    /* renamed from: h */
    public String m342h() {
        Object obj = this.f122e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f122e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m333n() {
        Object obj = this.f122e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f122e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m343i() {
        return (this.f119b & 8) == 8;
    }

    /* renamed from: j */
    public String m344j() {
        Object obj = this.f123f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f123f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m334o() {
        Object obj = this.f123f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f123f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    private void m335p() {
        this.f120c = 0;
        this.f121d = "";
        this.f122e = "";
        this.f123f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f124g;
        if (b != -1) {
            return b == 1;
        }
        this.f124g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f119b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f120c);
        }
        if ((this.f119b & 2) == 2) {
            codedOutputStream.writeBytes(2, m332m());
        }
        if ((this.f119b & 4) == 4) {
            codedOutputStream.writeBytes(3, m333n());
        }
        if ((this.f119b & 8) == 8) {
            codedOutputStream.writeBytes(4, m334o());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f125h;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f119b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f120c) : 0;
            if ((this.f119b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m332m());
            }
            if ((this.f119b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m333n());
            }
            if ((this.f119b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m334o());
            }
            this.f125h = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0077f m326a(byte[] bArr) {
        return ((C0078g) newBuilder().mergeFrom(bArr)).m351i();
    }

    public static C0078g newBuilder() {
        return C0078g.m350h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0078g newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0078g m327a(C0077f c0077f) {
        return newBuilder().mergeFrom(c0077f);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0078g toBuilder() {
        return m327a(this);
    }

    static {
        f118a.m335p();
    }
}
