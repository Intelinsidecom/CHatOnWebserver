package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ac */
/* loaded from: classes.dex */
public final class C0069ac extends GeneratedMessageLite implements InterfaceC0107z {

    /* renamed from: a */
    private static final C0069ac f42a = new C0069ac(true);

    /* renamed from: b */
    private int f43b;

    /* renamed from: c */
    private int f44c;

    /* renamed from: d */
    private Object f45d;

    /* renamed from: e */
    private Object f46e;

    /* renamed from: f */
    private int f47f;

    /* renamed from: g */
    private Object f48g;

    /* renamed from: h */
    private int f49h;

    /* renamed from: i */
    private int f50i;

    /* renamed from: j */
    private Object f51j;

    /* renamed from: k */
    private byte f52k;

    /* renamed from: l */
    private int f53l;

    private C0069ac(C0082ap c0082ap) {
        super(c0082ap);
        this.f52k = (byte) -1;
        this.f53l = -1;
    }

    private C0069ac(boolean z) {
        this.f52k = (byte) -1;
        this.f53l = -1;
    }

    /* renamed from: a */
    public static C0069ac m109a() {
        return f42a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0069ac getDefaultInstanceForType() {
        return f42a;
    }

    /* renamed from: c */
    public boolean m126c() {
        return (this.f43b & 1) == 1;
    }

    /* renamed from: d */
    public int m127d() {
        return this.f44c;
    }

    /* renamed from: e */
    public boolean m128e() {
        return (this.f43b & 2) == 2;
    }

    /* renamed from: f */
    public String m129f() {
        Object obj = this.f45d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f45d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: u */
    private ByteString m120u() {
        Object obj = this.f45d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f45d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m130g() {
        return (this.f43b & 4) == 4;
    }

    /* renamed from: h */
    public String m131h() {
        Object obj = this.f46e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f46e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: v */
    private ByteString m121v() {
        Object obj = this.f46e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f46e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m132i() {
        return (this.f43b & 8) == 8;
    }

    /* renamed from: j */
    public int m133j() {
        return this.f47f;
    }

    /* renamed from: k */
    public boolean m134k() {
        return (this.f43b & 16) == 16;
    }

    /* renamed from: l */
    public String m135l() {
        Object obj = this.f48g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f48g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: w */
    private ByteString m122w() {
        Object obj = this.f48g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f48g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m136m() {
        return (this.f43b & 32) == 32;
    }

    /* renamed from: n */
    public int m137n() {
        return this.f49h;
    }

    /* renamed from: o */
    public boolean m138o() {
        return (this.f43b & 64) == 64;
    }

    /* renamed from: p */
    public int m139p() {
        return this.f50i;
    }

    /* renamed from: q */
    public boolean m140q() {
        return (this.f43b & 128) == 128;
    }

    /* renamed from: r */
    public String m141r() {
        Object obj = this.f51j;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f51j = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m123x() {
        Object obj = this.f51j;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f51j = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: y */
    private void m124y() {
        this.f44c = 0;
        this.f45d = "";
        this.f46e = "";
        this.f47f = 0;
        this.f48g = "";
        this.f49h = 0;
        this.f50i = 0;
        this.f51j = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f52k;
        if (b != -1) {
            return b == 1;
        }
        this.f52k = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f43b & 1) == 1) {
            codedOutputStream.writeInt32(2, this.f44c);
        }
        if ((this.f43b & 2) == 2) {
            codedOutputStream.writeBytes(3, m120u());
        }
        if ((this.f43b & 4) == 4) {
            codedOutputStream.writeBytes(4, m121v());
        }
        if ((this.f43b & 8) == 8) {
            codedOutputStream.writeInt32(5, this.f47f);
        }
        if ((this.f43b & 16) == 16) {
            codedOutputStream.writeBytes(6, m122w());
        }
        if ((this.f43b & 32) == 32) {
            codedOutputStream.writeInt32(7, this.f49h);
        }
        if ((this.f43b & 64) == 64) {
            codedOutputStream.writeInt32(8, this.f50i);
        }
        if ((this.f43b & 128) == 128) {
            codedOutputStream.writeBytes(9, m123x());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f53l;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f43b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(2, this.f44c) : 0;
            if ((this.f43b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m120u());
            }
            if ((this.f43b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m121v());
            }
            if ((this.f43b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.f47f);
            }
            if ((this.f43b & 16) == 16) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(6, m122w());
            }
            if ((this.f43b & 32) == 32) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.f49h);
            }
            if ((this.f43b & 64) == 64) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(8, this.f50i);
            }
            if ((this.f43b & 128) == 128) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(9, m123x());
            }
            this.f53l = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0069ac m110a(byte[] bArr) {
        return ((C0082ap) newBuilder().mergeFrom(bArr)).m295i();
    }

    public static C0082ap newBuilder() {
        return C0082ap.m294h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public C0082ap newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0082ap m111a(C0069ac c0069ac) {
        return newBuilder().mergeFrom(c0069ac);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public C0082ap toBuilder() {
        return m111a(this);
    }

    static {
        f42a.m124y();
    }
}
