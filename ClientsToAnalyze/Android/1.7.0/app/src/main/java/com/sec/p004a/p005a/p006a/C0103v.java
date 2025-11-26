package com.sec.p004a.p005a.p006a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.v */
/* loaded from: classes.dex */
public final class C0103v extends GeneratedMessageLite implements InterfaceC0081ao {

    /* renamed from: a */
    private static final C0103v f177a = new C0103v(true);

    /* renamed from: b */
    private int f178b;

    /* renamed from: c */
    private Object f179c;

    /* renamed from: d */
    private Object f180d;

    /* renamed from: e */
    private int f181e;

    /* renamed from: f */
    private int f182f;

    /* renamed from: g */
    private Object f183g;

    /* renamed from: h */
    private Object f184h;

    /* renamed from: i */
    private Object f185i;

    /* renamed from: j */
    private long f186j;

    /* renamed from: k */
    private int f187k;

    /* renamed from: l */
    private Object f188l;

    /* renamed from: m */
    private byte f189m;

    /* renamed from: n */
    private int f190n;

    private C0103v(C0070ad c0070ad) {
        super(c0070ad);
        this.f189m = (byte) -1;
        this.f190n = -1;
    }

    private C0103v(boolean z) {
        this.f189m = (byte) -1;
        this.f190n = -1;
    }

    /* renamed from: a */
    public static C0103v m509a() {
        return f177a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0103v getDefaultInstanceForType() {
        return f177a;
    }

    /* renamed from: c */
    public boolean m523c() {
        return (this.f178b & 1) == 1;
    }

    /* renamed from: d */
    public String m524d() {
        Object obj = this.f179c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f179c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m520y() {
        Object obj = this.f179c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f179c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m525e() {
        return (this.f178b & 2) == 2;
    }

    /* renamed from: f */
    public String m526f() {
        Object obj = this.f180d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f180d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m521z() {
        Object obj = this.f180d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f180d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m527g() {
        return (this.f178b & 4) == 4;
    }

    /* renamed from: h */
    public int m528h() {
        return this.f181e;
    }

    /* renamed from: i */
    public boolean m529i() {
        return (this.f178b & 8) == 8;
    }

    /* renamed from: j */
    public int m530j() {
        return this.f182f;
    }

    /* renamed from: k */
    public boolean m531k() {
        return (this.f178b & 16) == 16;
    }

    /* renamed from: l */
    public String m532l() {
        Object obj = this.f183g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f183g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: A */
    private ByteString m501A() {
        Object obj = this.f183g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f183g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m533m() {
        return (this.f178b & 32) == 32;
    }

    /* renamed from: n */
    public String m534n() {
        Object obj = this.f184h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f184h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: B */
    private ByteString m502B() {
        Object obj = this.f184h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f184h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    public boolean m535o() {
        return (this.f178b & 64) == 64;
    }

    /* renamed from: p */
    public String m536p() {
        Object obj = this.f185i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f185i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: C */
    private ByteString m503C() {
        Object obj = this.f185i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f185i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: q */
    public boolean m537q() {
        return (this.f178b & 128) == 128;
    }

    /* renamed from: r */
    public long m538r() {
        return this.f186j;
    }

    /* renamed from: s */
    public boolean m539s() {
        return (this.f178b & 256) == 256;
    }

    /* renamed from: t */
    public int m540t() {
        return this.f187k;
    }

    /* renamed from: u */
    public boolean m541u() {
        return (this.f178b & 512) == 512;
    }

    /* renamed from: v */
    public String m542v() {
        Object obj = this.f188l;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f188l = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: D */
    private ByteString m504D() {
        Object obj = this.f188l;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f188l = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: E */
    private void m505E() {
        this.f179c = "";
        this.f180d = "";
        this.f181e = 0;
        this.f182f = 0;
        this.f183g = "";
        this.f184h = "";
        this.f185i = "";
        this.f186j = 0L;
        this.f187k = 0;
        this.f188l = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f189m;
        if (b != -1) {
            return b == 1;
        }
        this.f189m = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f178b & 1) == 1) {
            codedOutputStream.writeBytes(1, m520y());
        }
        if ((this.f178b & 2) == 2) {
            codedOutputStream.writeBytes(2, m521z());
        }
        if ((this.f178b & 4) == 4) {
            codedOutputStream.writeInt32(3, this.f181e);
        }
        if ((this.f178b & 8) == 8) {
            codedOutputStream.writeInt32(4, this.f182f);
        }
        if ((this.f178b & 16) == 16) {
            codedOutputStream.writeBytes(5, m501A());
        }
        if ((this.f178b & 32) == 32) {
            codedOutputStream.writeBytes(6, m502B());
        }
        if ((this.f178b & 64) == 64) {
            codedOutputStream.writeBytes(7, m503C());
        }
        if ((this.f178b & 128) == 128) {
            codedOutputStream.writeInt64(11, this.f186j);
        }
        if ((this.f178b & 256) == 256) {
            codedOutputStream.writeInt32(12, this.f187k);
        }
        if ((this.f178b & 512) == 512) {
            codedOutputStream.writeBytes(13, m504D());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f190n;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f178b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m520y()) : 0;
            if ((this.f178b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m521z());
            }
            if ((this.f178b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(3, this.f181e);
            }
            if ((this.f178b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(4, this.f182f);
            }
            if ((this.f178b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(5, m501A());
            }
            if ((this.f178b & 32) == 32) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(6, m502B());
            }
            if ((this.f178b & 64) == 64) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(7, m503C());
            }
            if ((this.f178b & 128) == 128) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(11, this.f186j);
            }
            if ((this.f178b & 256) == 256) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(12, this.f187k);
            }
            if ((this.f178b & 512) == 512) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(13, m504D());
            }
            this.f190n = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0103v m510a(byte[] bArr) {
        return ((C0070ad) newBuilder().mergeFrom(bArr)).m148i();
    }

    public static C0070ad newBuilder() {
        return C0070ad.m147h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public C0070ad newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0070ad m508a(C0103v c0103v) {
        return newBuilder().mergeFrom(c0103v);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public C0070ad toBuilder() {
        return m508a(this);
    }

    static {
        f177a.m505E();
    }
}
