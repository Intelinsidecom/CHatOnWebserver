package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.e */
/* loaded from: classes.dex */
public final class C0331e extends GeneratedMessageLite implements InterfaceC0349w {

    /* renamed from: a */
    private static final C0331e f944a = new C0331e(true);

    /* renamed from: b */
    private int f945b;

    /* renamed from: c */
    private long f946c;

    /* renamed from: d */
    private EnumC0323ci f947d;

    /* renamed from: e */
    private Object f948e;

    /* renamed from: f */
    private Object f949f;

    /* renamed from: g */
    private Object f950g;

    /* renamed from: h */
    private Object f951h;

    /* renamed from: i */
    private Object f952i;

    /* renamed from: j */
    private byte f953j;

    /* renamed from: k */
    private int f954k;

    private C0331e(C0295bh c0295bh) {
        super(c0295bh);
        this.f953j = (byte) -1;
        this.f954k = -1;
    }

    private C0331e(boolean z) {
        this.f953j = (byte) -1;
        this.f954k = -1;
    }

    /* renamed from: a */
    public static C0331e m1838a() {
        return f944a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0331e getDefaultInstanceForType() {
        return f944a;
    }

    /* renamed from: c */
    public boolean m1852c() {
        return (this.f945b & 1) == 1;
    }

    /* renamed from: d */
    public long m1853d() {
        return this.f946c;
    }

    /* renamed from: e */
    public boolean m1854e() {
        return (this.f945b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0323ci m1855f() {
        return this.f947d;
    }

    /* renamed from: g */
    public boolean m1856g() {
        return (this.f945b & 4) == 4;
    }

    /* renamed from: h */
    public String m1857h() {
        Object obj = this.f948e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f948e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m1845s() {
        Object obj = this.f948e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f948e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m1858i() {
        return (this.f945b & 8) == 8;
    }

    /* renamed from: j */
    public String m1859j() {
        Object obj = this.f949f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f949f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: t */
    private ByteString m1846t() {
        Object obj = this.f949f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f949f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m1860k() {
        return (this.f945b & 16) == 16;
    }

    /* renamed from: l */
    public String m1861l() {
        Object obj = this.f950g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f950g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: u */
    private ByteString m1847u() {
        Object obj = this.f950g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f950g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m1862m() {
        return (this.f945b & 32) == 32;
    }

    /* renamed from: n */
    public String m1863n() {
        Object obj = this.f951h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f951h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: v */
    private ByteString m1848v() {
        Object obj = this.f951h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f951h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    public boolean m1864o() {
        return (this.f945b & 64) == 64;
    }

    /* renamed from: p */
    public String m1865p() {
        Object obj = this.f952i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f952i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: w */
    private ByteString m1849w() {
        Object obj = this.f952i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f952i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: x */
    private void m1850x() {
        this.f946c = 0L;
        this.f947d = EnumC0323ci.SINGLE;
        this.f948e = "";
        this.f949f = "";
        this.f950g = "";
        this.f951h = "";
        this.f952i = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f953j;
        if (b != -1) {
            return b == 1;
        }
        this.f953j = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f945b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f946c);
        }
        if ((this.f945b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f947d.getNumber());
        }
        if ((this.f945b & 4) == 4) {
            codedOutputStream.writeBytes(3, m1845s());
        }
        if ((this.f945b & 8) == 8) {
            codedOutputStream.writeBytes(4, m1846t());
        }
        if ((this.f945b & 16) == 16) {
            codedOutputStream.writeBytes(5, m1847u());
        }
        if ((this.f945b & 32) == 32) {
            codedOutputStream.writeBytes(6, m1848v());
        }
        if ((this.f945b & 64) == 64) {
            codedOutputStream.writeBytes(7, m1849w());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f954k;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f945b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f946c) : 0;
            if ((this.f945b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f947d.getNumber());
            }
            if ((this.f945b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m1845s());
            }
            if ((this.f945b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m1846t());
            }
            if ((this.f945b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m1847u());
            }
            if ((this.f945b & 32) == 32) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(6, m1848v());
            }
            if ((this.f945b & 64) == 64) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(7, m1849w());
            }
            this.f954k = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0331e m1839a(byte[] bArr) {
        return ((C0295bh) newBuilder().mergeFrom(bArr)).m1320n();
    }

    public static C0295bh newBuilder() {
        return C0295bh.m1319m();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C0295bh newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0295bh m1836a(C0331e c0331e) {
        return newBuilder().mergeFrom(c0331e);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C0295bh toBuilder() {
        return m1836a(this);
    }

    static {
        f944a.m1850x();
    }
}
