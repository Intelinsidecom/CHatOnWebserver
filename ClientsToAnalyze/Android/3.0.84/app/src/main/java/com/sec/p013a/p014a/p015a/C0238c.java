package com.sec.p013a.p014a.p015a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.c */
/* loaded from: classes.dex */
public final class C0238c extends GeneratedMessageLite implements InterfaceC0240e {

    /* renamed from: a */
    private static final C0238c f528a = new C0238c(true);

    /* renamed from: b */
    private int f529b;

    /* renamed from: c */
    private int f530c;

    /* renamed from: d */
    private int f531d;

    /* renamed from: e */
    private Object f532e;

    /* renamed from: f */
    private Object f533f;

    /* renamed from: g */
    private byte f534g;

    /* renamed from: h */
    private int f535h;

    private C0238c(C0239d c0239d) {
        super(c0239d);
        this.f534g = (byte) -1;
        this.f535h = -1;
    }

    private C0238c(boolean z) {
        this.f534g = (byte) -1;
        this.f535h = -1;
    }

    /* renamed from: a */
    public static C0238c m799a() {
        return f528a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0238c getDefaultInstanceForType() {
        return f528a;
    }

    /* renamed from: c */
    public boolean m810c() {
        return (this.f529b & 1) == 1;
    }

    /* renamed from: d */
    public int m811d() {
        return this.f530c;
    }

    /* renamed from: e */
    public boolean m812e() {
        return (this.f529b & 2) == 2;
    }

    /* renamed from: f */
    public int m813f() {
        return this.f531d;
    }

    /* renamed from: g */
    public boolean m814g() {
        return (this.f529b & 4) == 4;
    }

    /* renamed from: h */
    public String m815h() {
        Object obj = this.f532e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f532e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m806m() {
        Object obj = this.f532e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f532e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m816i() {
        return (this.f529b & 8) == 8;
    }

    /* renamed from: j */
    public String m817j() {
        Object obj = this.f533f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f533f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m807n() {
        Object obj = this.f533f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f533f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    private void m808o() {
        this.f530c = 0;
        this.f531d = 0;
        this.f532e = "";
        this.f533f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f534g;
        if (b != -1) {
            return b == 1;
        }
        this.f534g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f529b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f530c);
        }
        if ((this.f529b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f531d);
        }
        if ((this.f529b & 4) == 4) {
            codedOutputStream.writeBytes(3, m806m());
        }
        if ((this.f529b & 8) == 8) {
            codedOutputStream.writeBytes(4, m807n());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f535h;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f529b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f530c) : 0;
            if ((this.f529b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.f531d);
            }
            if ((this.f529b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m806m());
            }
            if ((this.f529b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m807n());
            }
            this.f535h = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0238c m800a(byte[] bArr) {
        return ((C0239d) newBuilder().mergeFrom(bArr)).m824i();
    }

    public static C0239d newBuilder() {
        return C0239d.m823h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0239d newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0239d m801a(C0238c c0238c) {
        return newBuilder().mergeFrom(c0238c);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0239d toBuilder() {
        return m801a(this);
    }

    static {
        f528a.m808o();
    }
}
