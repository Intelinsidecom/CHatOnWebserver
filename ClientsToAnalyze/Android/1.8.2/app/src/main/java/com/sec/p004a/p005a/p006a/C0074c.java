package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.c */
/* loaded from: classes.dex */
public final class C0074c extends GeneratedMessageLite implements InterfaceC0076e {

    /* renamed from: a */
    private static final C0074c f105a = new C0074c(true);

    /* renamed from: b */
    private int f106b;

    /* renamed from: c */
    private int f107c;

    /* renamed from: d */
    private int f108d;

    /* renamed from: e */
    private Object f109e;

    /* renamed from: f */
    private Object f110f;

    /* renamed from: g */
    private byte f111g;

    /* renamed from: h */
    private int f112h;

    private C0074c(C0075d c0075d) {
        super(c0075d);
        this.f111g = (byte) -1;
        this.f112h = -1;
    }

    private C0074c(boolean z) {
        this.f111g = (byte) -1;
        this.f112h = -1;
    }

    /* renamed from: a */
    public static C0074c m287a() {
        return f105a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0074c getDefaultInstanceForType() {
        return f105a;
    }

    /* renamed from: c */
    public boolean m298c() {
        return (this.f106b & 1) == 1;
    }

    /* renamed from: d */
    public int m299d() {
        return this.f107c;
    }

    /* renamed from: e */
    public boolean m300e() {
        return (this.f106b & 2) == 2;
    }

    /* renamed from: f */
    public int m301f() {
        return this.f108d;
    }

    /* renamed from: g */
    public boolean m302g() {
        return (this.f106b & 4) == 4;
    }

    /* renamed from: h */
    public String m303h() {
        Object obj = this.f109e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f109e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m294m() {
        Object obj = this.f109e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f109e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m304i() {
        return (this.f106b & 8) == 8;
    }

    /* renamed from: j */
    public String m305j() {
        Object obj = this.f110f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f110f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m295n() {
        Object obj = this.f110f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f110f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    private void m296o() {
        this.f107c = 0;
        this.f108d = 0;
        this.f109e = "";
        this.f110f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f111g;
        if (b != -1) {
            return b == 1;
        }
        this.f111g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f106b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f107c);
        }
        if ((this.f106b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f108d);
        }
        if ((this.f106b & 4) == 4) {
            codedOutputStream.writeBytes(3, m294m());
        }
        if ((this.f106b & 8) == 8) {
            codedOutputStream.writeBytes(4, m295n());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f112h;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f106b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f107c) : 0;
            if ((this.f106b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.f108d);
            }
            if ((this.f106b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m294m());
            }
            if ((this.f106b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m295n());
            }
            this.f112h = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0074c m288a(byte[] bArr) {
        return ((C0075d) newBuilder().mergeFrom(bArr)).m312i();
    }

    public static C0075d newBuilder() {
        return C0075d.m311h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0075d newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0075d m289a(C0074c c0074c) {
        return newBuilder().mergeFrom(c0074c);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0075d toBuilder() {
        return m289a(this);
    }

    static {
        f105a.m296o();
    }
}
