package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.a */
/* loaded from: classes.dex */
public final class C0066a extends GeneratedMessageLite implements InterfaceC0085d {

    /* renamed from: a */
    private static final C0066a f31a = new C0066a(true);

    /* renamed from: b */
    private int f32b;

    /* renamed from: c */
    private int f33c;

    /* renamed from: d */
    private Object f34d;

    /* renamed from: e */
    private Object f35e;

    /* renamed from: f */
    private Object f36f;

    /* renamed from: g */
    private byte f37g;

    /* renamed from: h */
    private int f38h;

    private C0066a(C0071ae c0071ae) {
        super(c0071ae);
        this.f37g = (byte) -1;
        this.f38h = -1;
    }

    private C0066a(boolean z) {
        this.f37g = (byte) -1;
        this.f38h = -1;
    }

    /* renamed from: a */
    public static C0066a m68a() {
        return f31a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0066a getDefaultInstanceForType() {
        return f31a;
    }

    /* renamed from: c */
    public boolean m80c() {
        return (this.f32b & 1) == 1;
    }

    /* renamed from: d */
    public int m81d() {
        return this.f33c;
    }

    /* renamed from: e */
    public boolean m82e() {
        return (this.f32b & 2) == 2;
    }

    /* renamed from: f */
    public String m83f() {
        Object obj = this.f34d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f34d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m75m() {
        Object obj = this.f34d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f34d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m84g() {
        return (this.f32b & 4) == 4;
    }

    /* renamed from: h */
    public String m85h() {
        Object obj = this.f35e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f35e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m76n() {
        Object obj = this.f35e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f35e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m86i() {
        return (this.f32b & 8) == 8;
    }

    /* renamed from: j */
    public String m87j() {
        Object obj = this.f36f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f36f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m77o() {
        Object obj = this.f36f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f36f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    private void m78p() {
        this.f33c = 0;
        this.f34d = "";
        this.f35e = "";
        this.f36f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f37g;
        if (b != -1) {
            return b == 1;
        }
        this.f37g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f32b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f33c);
        }
        if ((this.f32b & 2) == 2) {
            codedOutputStream.writeBytes(2, m75m());
        }
        if ((this.f32b & 4) == 4) {
            codedOutputStream.writeBytes(3, m76n());
        }
        if ((this.f32b & 8) == 8) {
            codedOutputStream.writeBytes(4, m77o());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f38h;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f32b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f33c) : 0;
            if ((this.f32b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m75m());
            }
            if ((this.f32b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m76n());
            }
            if ((this.f32b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m77o());
            }
            this.f38h = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0066a m69a(byte[] bArr) {
        return ((C0071ae) newBuilder().mergeFrom(bArr)).m170i();
    }

    public static C0071ae newBuilder() {
        return C0071ae.m169h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0071ae newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0071ae m70a(C0066a c0066a) {
        return newBuilder().mergeFrom(c0066a);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0071ae toBuilder() {
        return m70a(this);
    }

    static {
        f31a.m78p();
    }
}
