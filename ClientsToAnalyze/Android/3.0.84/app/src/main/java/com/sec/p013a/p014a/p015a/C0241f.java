package com.sec.p013a.p014a.p015a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.f */
/* loaded from: classes.dex */
public final class C0241f extends GeneratedMessageLite implements InterfaceC0243h {

    /* renamed from: a */
    private static final C0241f f541a = new C0241f(true);

    /* renamed from: b */
    private int f542b;

    /* renamed from: c */
    private int f543c;

    /* renamed from: d */
    private Object f544d;

    /* renamed from: e */
    private Object f545e;

    /* renamed from: f */
    private Object f546f;

    /* renamed from: g */
    private byte f547g;

    /* renamed from: h */
    private int f548h;

    private C0241f(C0242g c0242g) {
        super(c0242g);
        this.f547g = (byte) -1;
        this.f548h = -1;
    }

    private C0241f(boolean z) {
        this.f547g = (byte) -1;
        this.f548h = -1;
    }

    /* renamed from: a */
    public static C0241f m837a() {
        return f541a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0241f getDefaultInstanceForType() {
        return f541a;
    }

    /* renamed from: c */
    public boolean m849c() {
        return (this.f542b & 1) == 1;
    }

    /* renamed from: d */
    public int m850d() {
        return this.f543c;
    }

    /* renamed from: e */
    public boolean m851e() {
        return (this.f542b & 2) == 2;
    }

    /* renamed from: f */
    public String m852f() {
        Object obj = this.f544d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f544d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m844m() {
        Object obj = this.f544d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f544d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m853g() {
        return (this.f542b & 4) == 4;
    }

    /* renamed from: h */
    public String m854h() {
        Object obj = this.f545e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f545e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m845n() {
        Object obj = this.f545e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f545e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m855i() {
        return (this.f542b & 8) == 8;
    }

    /* renamed from: j */
    public String m856j() {
        Object obj = this.f546f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f546f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m846o() {
        Object obj = this.f546f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f546f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    private void m847p() {
        this.f543c = 0;
        this.f544d = "";
        this.f545e = "";
        this.f546f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f547g;
        if (b != -1) {
            return b == 1;
        }
        this.f547g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f542b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f543c);
        }
        if ((this.f542b & 2) == 2) {
            codedOutputStream.writeBytes(2, m844m());
        }
        if ((this.f542b & 4) == 4) {
            codedOutputStream.writeBytes(3, m845n());
        }
        if ((this.f542b & 8) == 8) {
            codedOutputStream.writeBytes(4, m846o());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f548h;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f542b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f543c) : 0;
            if ((this.f542b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m844m());
            }
            if ((this.f542b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m845n());
            }
            if ((this.f542b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m846o());
            }
            this.f548h = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0241f m838a(byte[] bArr) {
        return ((C0242g) newBuilder().mergeFrom(bArr)).m863i();
    }

    public static C0242g newBuilder() {
        return C0242g.m862h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0242g newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0242g m839a(C0241f c0241f) {
        return newBuilder().mergeFrom(c0241f);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0242g toBuilder() {
        return m839a(this);
    }

    static {
        f541a.m847p();
    }
}
