package com.sec.p043a.p044a.p045a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.am */
/* loaded from: classes.dex */
public final class C0746am extends GeneratedMessageLite implements InterfaceC0748ao {

    /* renamed from: a */
    private static final C0746am f1751a = new C0746am(true);

    /* renamed from: b */
    private int f1752b;

    /* renamed from: c */
    private int f1753c;

    /* renamed from: d */
    private Object f1754d;

    /* renamed from: e */
    private Object f1755e;

    /* renamed from: f */
    private Object f1756f;

    /* renamed from: g */
    private byte f1757g;

    /* renamed from: h */
    private int f1758h;

    private C0746am(C0747an c0747an) {
        super(c0747an);
        this.f1757g = (byte) -1;
        this.f1758h = -1;
    }

    private C0746am(boolean z) {
        this.f1757g = (byte) -1;
        this.f1758h = -1;
    }

    /* renamed from: a */
    public static C0746am m2488a() {
        return f1751a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0746am getDefaultInstanceForType() {
        return f1751a;
    }

    /* renamed from: c */
    public boolean m2500c() {
        return (this.f1752b & 1) == 1;
    }

    /* renamed from: d */
    public int m2501d() {
        return this.f1753c;
    }

    /* renamed from: e */
    public boolean m2502e() {
        return (this.f1752b & 2) == 2;
    }

    /* renamed from: f */
    public String m2503f() {
        Object obj = this.f1754d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1754d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m2495m() {
        Object obj = this.f1754d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1754d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m2504g() {
        return (this.f1752b & 4) == 4;
    }

    /* renamed from: h */
    public String m2505h() {
        Object obj = this.f1755e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1755e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m2496n() {
        Object obj = this.f1755e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1755e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m2506i() {
        return (this.f1752b & 8) == 8;
    }

    /* renamed from: j */
    public String m2507j() {
        Object obj = this.f1756f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1756f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m2497o() {
        Object obj = this.f1756f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1756f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    private void m2498p() {
        this.f1753c = 0;
        this.f1754d = "";
        this.f1755e = "";
        this.f1756f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f1757g;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f1757g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1752b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f1753c);
        }
        if ((this.f1752b & 2) == 2) {
            codedOutputStream.writeBytes(2, m2495m());
        }
        if ((this.f1752b & 4) == 4) {
            codedOutputStream.writeBytes(3, m2496n());
        }
        if ((this.f1752b & 8) == 8) {
            codedOutputStream.writeBytes(4, m2497o());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f1758h;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f1752b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f1753c) : 0;
            if ((this.f1752b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m2495m());
            }
            if ((this.f1752b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m2496n());
            }
            if ((this.f1752b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m2497o());
            }
            this.f1758h = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0746am m2489a(byte[] bArr) {
        return ((C0747an) newBuilder().mergeFrom(bArr)).m2514i();
    }

    public static C0747an newBuilder() {
        return C0747an.m2513h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0747an newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0747an m2490a(C0746am c0746am) {
        return newBuilder().mergeFrom(c0746am);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0747an toBuilder() {
        return m2490a(this);
    }

    static {
        f1751a.m2498p();
    }
}
