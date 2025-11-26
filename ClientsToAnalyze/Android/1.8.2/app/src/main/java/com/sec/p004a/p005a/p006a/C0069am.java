package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.am */
/* loaded from: classes.dex */
public final class C0069am extends GeneratedMessageLite implements InterfaceC0071ao {

    /* renamed from: a */
    private static final C0069am f92a = new C0069am(true);

    /* renamed from: b */
    private int f93b;

    /* renamed from: c */
    private int f94c;

    /* renamed from: d */
    private Object f95d;

    /* renamed from: e */
    private Object f96e;

    /* renamed from: f */
    private Object f97f;

    /* renamed from: g */
    private byte f98g;

    /* renamed from: h */
    private int f99h;

    private C0069am(C0070an c0070an) {
        super(c0070an);
        this.f98g = (byte) -1;
        this.f99h = -1;
    }

    private C0069am(boolean z) {
        this.f98g = (byte) -1;
        this.f99h = -1;
    }

    /* renamed from: a */
    public static C0069am m244a() {
        return f92a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0069am getDefaultInstanceForType() {
        return f92a;
    }

    /* renamed from: c */
    public boolean m256c() {
        return (this.f93b & 1) == 1;
    }

    /* renamed from: d */
    public int m257d() {
        return this.f94c;
    }

    /* renamed from: e */
    public boolean m258e() {
        return (this.f93b & 2) == 2;
    }

    /* renamed from: f */
    public String m259f() {
        Object obj = this.f95d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f95d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m251m() {
        Object obj = this.f95d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f95d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m260g() {
        return (this.f93b & 4) == 4;
    }

    /* renamed from: h */
    public String m261h() {
        Object obj = this.f96e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f96e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m252n() {
        Object obj = this.f96e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f96e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m262i() {
        return (this.f93b & 8) == 8;
    }

    /* renamed from: j */
    public String m263j() {
        Object obj = this.f97f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f97f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m253o() {
        Object obj = this.f97f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f97f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    private void m254p() {
        this.f94c = 0;
        this.f95d = "";
        this.f96e = "";
        this.f97f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f98g;
        if (b != -1) {
            return b == 1;
        }
        this.f98g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f93b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f94c);
        }
        if ((this.f93b & 2) == 2) {
            codedOutputStream.writeBytes(2, m251m());
        }
        if ((this.f93b & 4) == 4) {
            codedOutputStream.writeBytes(3, m252n());
        }
        if ((this.f93b & 8) == 8) {
            codedOutputStream.writeBytes(4, m253o());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f99h;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f93b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f94c) : 0;
            if ((this.f93b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m251m());
            }
            if ((this.f93b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m252n());
            }
            if ((this.f93b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m253o());
            }
            this.f99h = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0069am m245a(byte[] bArr) {
        return ((C0070an) newBuilder().mergeFrom(bArr)).m270i();
    }

    public static C0070an newBuilder() {
        return C0070an.m269h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0070an newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0070an m246a(C0069am c0069am) {
        return newBuilder().mergeFrom(c0069am);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0070an toBuilder() {
        return m246a(this);
    }

    static {
        f92a.m254p();
    }
}
