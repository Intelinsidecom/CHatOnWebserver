package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.o */
/* loaded from: classes.dex */
public final class C0096o extends GeneratedMessageLite implements InterfaceC0079am {

    /* renamed from: a */
    private static final C0096o f162a = new C0096o(true);

    /* renamed from: b */
    private int f163b;

    /* renamed from: c */
    private Object f164c;

    /* renamed from: d */
    private Object f165d;

    /* renamed from: e */
    private Object f166e;

    /* renamed from: f */
    private Object f167f;

    /* renamed from: g */
    private Object f168g;

    /* renamed from: h */
    private byte f169h;

    /* renamed from: i */
    private int f170i;

    private C0096o(C0083b c0083b) {
        super(c0083b);
        this.f169h = (byte) -1;
        this.f170i = -1;
    }

    private C0096o(boolean z) {
        this.f169h = (byte) -1;
        this.f170i = -1;
    }

    /* renamed from: a */
    public static C0096o m458a() {
        return f162a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0096o getDefaultInstanceForType() {
        return f162a;
    }

    /* renamed from: c */
    public boolean m472c() {
        return (this.f163b & 1) == 1;
    }

    /* renamed from: d */
    public String m473d() {
        Object obj = this.f164c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f164c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m465o() {
        Object obj = this.f164c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f164c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m474e() {
        return (this.f163b & 2) == 2;
    }

    /* renamed from: f */
    public String m475f() {
        Object obj = this.f165d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f165d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m466p() {
        Object obj = this.f165d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f165d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m476g() {
        return (this.f163b & 4) == 4;
    }

    /* renamed from: h */
    public String m477h() {
        Object obj = this.f166e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f166e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m467q() {
        Object obj = this.f166e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f166e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m478i() {
        return (this.f163b & 8) == 8;
    }

    /* renamed from: j */
    public String m479j() {
        Object obj = this.f167f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f167f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m468r() {
        Object obj = this.f167f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f167f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m480k() {
        return (this.f163b & 16) == 16;
    }

    /* renamed from: l */
    public String m481l() {
        Object obj = this.f168g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f168g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m469s() {
        Object obj = this.f168g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f168g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: t */
    private void m470t() {
        this.f164c = "";
        this.f165d = "";
        this.f166e = "";
        this.f167f = "";
        this.f168g = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f169h;
        if (b != -1) {
            return b == 1;
        }
        this.f169h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f163b & 1) == 1) {
            codedOutputStream.writeBytes(2, m465o());
        }
        if ((this.f163b & 2) == 2) {
            codedOutputStream.writeBytes(3, m466p());
        }
        if ((this.f163b & 4) == 4) {
            codedOutputStream.writeBytes(4, m467q());
        }
        if ((this.f163b & 8) == 8) {
            codedOutputStream.writeBytes(5, m468r());
        }
        if ((this.f163b & 16) == 16) {
            codedOutputStream.writeBytes(6, m469s());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f170i;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f163b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(2, m465o()) : 0;
            if ((this.f163b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(3, m466p());
            }
            if ((this.f163b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(4, m467q());
            }
            if ((this.f163b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(5, m468r());
            }
            if ((this.f163b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(6, m469s());
            }
            this.f170i = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0096o m459a(byte[] bArr) {
        return ((C0083b) newBuilder().mergeFrom(bArr)).m315i();
    }

    public static C0083b newBuilder() {
        return C0083b.m314h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0083b newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0083b m457a(C0096o c0096o) {
        return newBuilder().mergeFrom(c0096o);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0083b toBuilder() {
        return m457a(this);
    }

    static {
        f162a.m470t();
    }
}
