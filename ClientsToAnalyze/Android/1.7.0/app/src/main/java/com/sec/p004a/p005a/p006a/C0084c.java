package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.c */
/* loaded from: classes.dex */
public final class C0084c extends GeneratedMessageLite implements InterfaceC0099r {

    /* renamed from: a */
    private static final C0084c f118a = new C0084c(true);

    /* renamed from: b */
    private int f119b;

    /* renamed from: c */
    private int f120c;

    /* renamed from: d */
    private int f121d;

    /* renamed from: e */
    private Object f122e;

    /* renamed from: f */
    private byte f123f;

    /* renamed from: g */
    private int f124g;

    private C0084c(C0080an c0080an) {
        super(c0080an);
        this.f123f = (byte) -1;
        this.f124g = -1;
    }

    private C0084c(boolean z) {
        this.f123f = (byte) -1;
        this.f124g = -1;
    }

    /* renamed from: a */
    public static C0084c m330a() {
        return f118a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0084c getDefaultInstanceForType() {
        return f118a;
    }

    /* renamed from: c */
    public boolean m338c() {
        return (this.f119b & 1) == 1;
    }

    /* renamed from: d */
    public int m339d() {
        return this.f120c;
    }

    /* renamed from: e */
    public boolean m340e() {
        return (this.f119b & 2) == 2;
    }

    /* renamed from: f */
    public int m341f() {
        return this.f121d;
    }

    /* renamed from: g */
    public boolean m342g() {
        return (this.f119b & 4) == 4;
    }

    /* renamed from: h */
    public String m343h() {
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

    /* renamed from: k */
    private ByteString m335k() {
        Object obj = this.f122e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f122e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: l */
    private void m336l() {
        this.f120c = 0;
        this.f121d = 0;
        this.f122e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f123f;
        if (b != -1) {
            return b == 1;
        }
        this.f123f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f119b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f120c);
        }
        if ((this.f119b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f121d);
        }
        if ((this.f119b & 4) == 4) {
            codedOutputStream.writeBytes(3, m335k());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f124g;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f119b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f120c) : 0;
            if ((this.f119b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.f121d);
            }
            if ((this.f119b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m335k());
            }
            this.f124g = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0084c m331a(byte[] bArr) {
        return ((C0080an) newBuilder().mergeFrom(bArr)).m280i();
    }

    public static C0080an newBuilder() {
        return C0080an.m279h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0080an newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0080an m329a(C0084c c0084c) {
        return newBuilder().mergeFrom(c0084c);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0080an toBuilder() {
        return m329a(this);
    }

    static {
        f118a.m336l();
    }
}
