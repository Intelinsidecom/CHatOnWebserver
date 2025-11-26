package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ag */
/* loaded from: classes.dex */
public final class C0063ag extends GeneratedMessageLite implements InterfaceC0065ai {

    /* renamed from: a */
    private static final C0063ag f62a = new C0063ag(true);

    /* renamed from: b */
    private int f63b;

    /* renamed from: c */
    private Object f64c;

    /* renamed from: d */
    private Object f65d;

    /* renamed from: e */
    private Object f66e;

    /* renamed from: f */
    private Object f67f;

    /* renamed from: g */
    private Object f68g;

    /* renamed from: h */
    private byte f69h;

    /* renamed from: i */
    private int f70i;

    private C0063ag(C0064ah c0064ah) {
        super(c0064ah);
        this.f69h = (byte) -1;
        this.f70i = -1;
    }

    private C0063ag(boolean z) {
        this.f69h = (byte) -1;
        this.f70i = -1;
    }

    /* renamed from: a */
    public static C0063ag m156a() {
        return f62a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0063ag getDefaultInstanceForType() {
        return f62a;
    }

    /* renamed from: c */
    public boolean m171c() {
        return (this.f63b & 1) == 1;
    }

    /* renamed from: d */
    public String m172d() {
        Object obj = this.f64c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f64c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m164o() {
        Object obj = this.f64c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f64c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m173e() {
        return (this.f63b & 2) == 2;
    }

    /* renamed from: f */
    public String m174f() {
        Object obj = this.f65d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f65d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m165p() {
        Object obj = this.f65d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f65d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m175g() {
        return (this.f63b & 4) == 4;
    }

    /* renamed from: h */
    public String m176h() {
        Object obj = this.f66e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f66e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m166q() {
        Object obj = this.f66e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f66e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m177i() {
        return (this.f63b & 8) == 8;
    }

    /* renamed from: j */
    public String m178j() {
        Object obj = this.f67f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f67f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m167r() {
        Object obj = this.f67f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f67f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m179k() {
        return (this.f63b & 16) == 16;
    }

    /* renamed from: l */
    public String m180l() {
        Object obj = this.f68g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f68g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m168s() {
        Object obj = this.f68g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f68g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: t */
    private void m169t() {
        this.f64c = "";
        this.f65d = "";
        this.f66e = "";
        this.f67f = "";
        this.f68g = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f69h;
        if (b != -1) {
            return b == 1;
        }
        this.f69h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f63b & 1) == 1) {
            codedOutputStream.writeBytes(2, m164o());
        }
        if ((this.f63b & 2) == 2) {
            codedOutputStream.writeBytes(3, m165p());
        }
        if ((this.f63b & 4) == 4) {
            codedOutputStream.writeBytes(4, m166q());
        }
        if ((this.f63b & 8) == 8) {
            codedOutputStream.writeBytes(5, m167r());
        }
        if ((this.f63b & 16) == 16) {
            codedOutputStream.writeBytes(6, m168s());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f70i;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f63b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(2, m164o()) : 0;
            if ((this.f63b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(3, m165p());
            }
            if ((this.f63b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(4, m166q());
            }
            if ((this.f63b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(5, m167r());
            }
            if ((this.f63b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(6, m168s());
            }
            this.f70i = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0063ag m157a(byte[] bArr) {
        return ((C0064ah) newBuilder().mergeFrom(bArr)).m187i();
    }

    public static C0064ah newBuilder() {
        return C0064ah.m186h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0064ah newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0064ah m158a(C0063ag c0063ag) {
        return newBuilder().mergeFrom(c0063ag);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0064ah toBuilder() {
        return m158a(this);
    }

    static {
        f62a.m169t();
    }
}
