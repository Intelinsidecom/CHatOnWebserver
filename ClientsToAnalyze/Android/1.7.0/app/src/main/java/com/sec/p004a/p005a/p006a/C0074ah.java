package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ah */
/* loaded from: classes.dex */
public final class C0074ah extends GeneratedMessageLite implements InterfaceC0087f {

    /* renamed from: a */
    private static final C0074ah f77a = new C0074ah(true);

    /* renamed from: b */
    private int f78b;

    /* renamed from: c */
    private int f79c;

    /* renamed from: d */
    private Object f80d;

    /* renamed from: e */
    private Object f81e;

    /* renamed from: f */
    private Object f82f;

    /* renamed from: g */
    private byte f83g;

    /* renamed from: h */
    private int f84h;

    private C0074ah(C0093l c0093l) {
        super(c0093l);
        this.f83g = (byte) -1;
        this.f84h = -1;
    }

    private C0074ah(boolean z) {
        this.f83g = (byte) -1;
        this.f84h = -1;
    }

    /* renamed from: a */
    public static C0074ah m213a() {
        return f77a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0074ah getDefaultInstanceForType() {
        return f77a;
    }

    /* renamed from: c */
    public boolean m225c() {
        return (this.f78b & 1) == 1;
    }

    /* renamed from: d */
    public int m226d() {
        return this.f79c;
    }

    /* renamed from: e */
    public boolean m227e() {
        return (this.f78b & 2) == 2;
    }

    /* renamed from: f */
    public String m228f() {
        Object obj = this.f80d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f80d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m220m() {
        Object obj = this.f80d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f80d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m229g() {
        return (this.f78b & 4) == 4;
    }

    /* renamed from: h */
    public String m230h() {
        Object obj = this.f81e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f81e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m221n() {
        Object obj = this.f81e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f81e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m231i() {
        return (this.f78b & 8) == 8;
    }

    /* renamed from: j */
    public String m232j() {
        Object obj = this.f82f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f82f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m222o() {
        Object obj = this.f82f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f82f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    private void m223p() {
        this.f79c = 0;
        this.f80d = "";
        this.f81e = "";
        this.f82f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f83g;
        if (b != -1) {
            return b == 1;
        }
        this.f83g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f78b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f79c);
        }
        if ((this.f78b & 2) == 2) {
            codedOutputStream.writeBytes(2, m220m());
        }
        if ((this.f78b & 4) == 4) {
            codedOutputStream.writeBytes(3, m221n());
        }
        if ((this.f78b & 8) == 8) {
            codedOutputStream.writeBytes(4, m222o());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f84h;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f78b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f79c) : 0;
            if ((this.f78b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(2, m220m());
            }
            if ((this.f78b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m221n());
            }
            if ((this.f78b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m222o());
            }
            this.f84h = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0074ah m214a(byte[] bArr) {
        return ((C0093l) newBuilder().mergeFrom(bArr)).m413i();
    }

    public static C0093l newBuilder() {
        return C0093l.m412h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0093l newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0093l m215a(C0074ah c0074ah) {
        return newBuilder().mergeFrom(c0074ah);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0093l toBuilder() {
        return m215a(this);
    }

    static {
        f77a.m223p();
    }
}
