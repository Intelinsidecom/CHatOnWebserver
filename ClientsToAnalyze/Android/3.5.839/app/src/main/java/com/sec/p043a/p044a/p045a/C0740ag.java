package com.sec.p043a.p044a.p045a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ag */
/* loaded from: classes.dex */
public final class C0740ag extends GeneratedMessageLite implements InterfaceC0742ai {

    /* renamed from: a */
    private static final C0740ag f1721a = new C0740ag(true);

    /* renamed from: b */
    private int f1722b;

    /* renamed from: c */
    private Object f1723c;

    /* renamed from: d */
    private Object f1724d;

    /* renamed from: e */
    private Object f1725e;

    /* renamed from: f */
    private Object f1726f;

    /* renamed from: g */
    private Object f1727g;

    /* renamed from: h */
    private byte f1728h;

    /* renamed from: i */
    private int f1729i;

    private C0740ag(C0741ah c0741ah) {
        super(c0741ah);
        this.f1728h = (byte) -1;
        this.f1729i = -1;
    }

    private C0740ag(boolean z) {
        this.f1728h = (byte) -1;
        this.f1729i = -1;
    }

    /* renamed from: a */
    public static C0740ag m2400a() {
        return f1721a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0740ag getDefaultInstanceForType() {
        return f1721a;
    }

    /* renamed from: c */
    public boolean m2415c() {
        return (this.f1722b & 1) == 1;
    }

    /* renamed from: d */
    public String m2416d() {
        Object obj = this.f1723c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1723c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m2408o() {
        Object obj = this.f1723c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1723c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m2417e() {
        return (this.f1722b & 2) == 2;
    }

    /* renamed from: f */
    public String m2418f() {
        Object obj = this.f1724d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1724d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m2409p() {
        Object obj = this.f1724d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1724d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m2419g() {
        return (this.f1722b & 4) == 4;
    }

    /* renamed from: h */
    public String m2420h() {
        Object obj = this.f1725e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1725e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m2410q() {
        Object obj = this.f1725e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1725e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m2421i() {
        return (this.f1722b & 8) == 8;
    }

    /* renamed from: j */
    public String m2422j() {
        Object obj = this.f1726f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1726f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m2411r() {
        Object obj = this.f1726f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1726f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m2423k() {
        return (this.f1722b & 16) == 16;
    }

    /* renamed from: l */
    public String m2424l() {
        Object obj = this.f1727g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1727g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m2412s() {
        Object obj = this.f1727g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1727g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: t */
    private void m2413t() {
        this.f1723c = "";
        this.f1724d = "";
        this.f1725e = "";
        this.f1726f = "";
        this.f1727g = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f1728h;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f1728h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1722b & 1) == 1) {
            codedOutputStream.writeBytes(2, m2408o());
        }
        if ((this.f1722b & 2) == 2) {
            codedOutputStream.writeBytes(3, m2409p());
        }
        if ((this.f1722b & 4) == 4) {
            codedOutputStream.writeBytes(4, m2410q());
        }
        if ((this.f1722b & 8) == 8) {
            codedOutputStream.writeBytes(5, m2411r());
        }
        if ((this.f1722b & 16) == 16) {
            codedOutputStream.writeBytes(6, m2412s());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f1729i;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f1722b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(2, m2408o()) : 0;
            if ((this.f1722b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(3, m2409p());
            }
            if ((this.f1722b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(4, m2410q());
            }
            if ((this.f1722b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(5, m2411r());
            }
            if ((this.f1722b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(6, m2412s());
            }
            this.f1729i = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0740ag m2401a(byte[] bArr) {
        return ((C0741ah) newBuilder().mergeFrom(bArr)).m2431i();
    }

    public static C0741ah newBuilder() {
        return C0741ah.m2430h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0741ah newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0741ah m2402a(C0740ag c0740ag) {
        return newBuilder().mergeFrom(c0740ag);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0741ah toBuilder() {
        return m2402a(this);
    }

    static {
        f1721a.m2413t();
    }
}
