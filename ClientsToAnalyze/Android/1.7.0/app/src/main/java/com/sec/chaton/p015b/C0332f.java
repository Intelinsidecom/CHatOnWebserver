package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.f */
/* loaded from: classes.dex */
public final class C0332f extends GeneratedMessageLite implements InterfaceC0326cl {

    /* renamed from: a */
    private static final C0332f f955a = new C0332f(true);

    /* renamed from: b */
    private int f956b;

    /* renamed from: c */
    private long f957c;

    /* renamed from: d */
    private EnumC0275ao f958d;

    /* renamed from: e */
    private EnumC0323ci f959e;

    /* renamed from: f */
    private Object f960f;

    /* renamed from: g */
    private Object f961g;

    /* renamed from: h */
    private LazyStringList f962h;

    /* renamed from: i */
    private Object f963i;

    /* renamed from: j */
    private Object f964j;

    /* renamed from: k */
    private Object f965k;

    /* renamed from: l */
    private Object f966l;

    /* renamed from: m */
    private byte f967m;

    /* renamed from: n */
    private int f968n;

    private C0332f(C0299bl c0299bl) {
        super(c0299bl);
        this.f967m = (byte) -1;
        this.f968n = -1;
    }

    private C0332f(boolean z) {
        this.f967m = (byte) -1;
        this.f968n = -1;
    }

    /* renamed from: a */
    public static C0332f m1878a() {
        return f955a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0332f getDefaultInstanceForType() {
        return f955a;
    }

    /* renamed from: c */
    public boolean m1891c() {
        return (this.f956b & 1) == 1;
    }

    /* renamed from: d */
    public long m1892d() {
        return this.f957c;
    }

    /* renamed from: e */
    public boolean m1893e() {
        return (this.f956b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0275ao m1894f() {
        return this.f958d;
    }

    /* renamed from: g */
    public boolean m1895g() {
        return (this.f956b & 4) == 4;
    }

    /* renamed from: h */
    public EnumC0323ci m1896h() {
        return this.f959e;
    }

    /* renamed from: i */
    public boolean m1897i() {
        return (this.f956b & 8) == 8;
    }

    /* renamed from: j */
    public String m1898j() {
        Object obj = this.f960f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f960f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m1887x() {
        Object obj = this.f960f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f960f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m1899k() {
        return (this.f956b & 16) == 16;
    }

    /* renamed from: l */
    public String m1900l() {
        Object obj = this.f961g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f961g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m1888y() {
        Object obj = this.f961g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f961g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public List m1901m() {
        return this.f962h;
    }

    /* renamed from: n */
    public boolean m1902n() {
        return (this.f956b & 32) == 32;
    }

    /* renamed from: o */
    public String m1903o() {
        Object obj = this.f963i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f963i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m1889z() {
        Object obj = this.f963i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f963i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    public boolean m1904p() {
        return (this.f956b & 64) == 64;
    }

    /* renamed from: q */
    public String m1905q() {
        Object obj = this.f964j;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f964j = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: A */
    private ByteString m1868A() {
        Object obj = this.f964j;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f964j = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: r */
    public boolean m1906r() {
        return (this.f956b & 128) == 128;
    }

    /* renamed from: s */
    public String m1907s() {
        Object obj = this.f965k;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f965k = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: B */
    private ByteString m1869B() {
        Object obj = this.f965k;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f965k = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: t */
    public boolean m1908t() {
        return (this.f956b & 256) == 256;
    }

    /* renamed from: u */
    public String m1909u() {
        Object obj = this.f966l;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f966l = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: C */
    private ByteString m1870C() {
        Object obj = this.f966l;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f966l = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: D */
    private void m1871D() {
        this.f957c = 0L;
        this.f958d = EnumC0275ao.TEXT;
        this.f959e = EnumC0323ci.SINGLE;
        this.f960f = "";
        this.f961g = "";
        this.f962h = LazyStringArrayList.EMPTY;
        this.f963i = "";
        this.f964j = "";
        this.f965k = "";
        this.f966l = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f967m;
        if (b != -1) {
            return b == 1;
        }
        this.f967m = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f956b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f957c);
        }
        if ((this.f956b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f958d.getNumber());
        }
        if ((this.f956b & 4) == 4) {
            codedOutputStream.writeEnum(3, this.f959e.getNumber());
        }
        if ((this.f956b & 8) == 8) {
            codedOutputStream.writeBytes(4, m1887x());
        }
        if ((this.f956b & 16) == 16) {
            codedOutputStream.writeBytes(5, m1888y());
        }
        for (int i = 0; i < this.f962h.size(); i++) {
            codedOutputStream.writeBytes(6, this.f962h.getByteString(i));
        }
        if ((this.f956b & 32) == 32) {
            codedOutputStream.writeBytes(7, m1889z());
        }
        if ((this.f956b & 64) == 64) {
            codedOutputStream.writeBytes(8, m1868A());
        }
        if ((this.f956b & 128) == 128) {
            codedOutputStream.writeBytes(9, m1869B());
        }
        if ((this.f956b & 256) == 256) {
            codedOutputStream.writeBytes(10, m1870C());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f968n;
        if (size == -1) {
            int iComputeInt64Size = (this.f956b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f957c) + 0 : 0;
            if ((this.f956b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f958d.getNumber());
            }
            if ((this.f956b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(3, this.f959e.getNumber());
            }
            if ((this.f956b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m1887x());
            }
            if ((this.f956b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m1888y());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f962h.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f962h.getByteString(i));
            }
            size = iComputeInt64Size + iComputeBytesSizeNoTag + (m1901m().size() * 1);
            if ((this.f956b & 32) == 32) {
                size += CodedOutputStream.computeBytesSize(7, m1889z());
            }
            if ((this.f956b & 64) == 64) {
                size += CodedOutputStream.computeBytesSize(8, m1868A());
            }
            if ((this.f956b & 128) == 128) {
                size += CodedOutputStream.computeBytesSize(9, m1869B());
            }
            if ((this.f956b & 256) == 256) {
                size += CodedOutputStream.computeBytesSize(10, m1870C());
            }
            this.f968n = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0332f m1879a(byte[] bArr) {
        return ((C0299bl) newBuilder().mergeFrom(bArr)).m1379p();
    }

    public static C0299bl newBuilder() {
        return C0299bl.m1378o();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public C0299bl newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0299bl m1876a(C0332f c0332f) {
        return newBuilder().mergeFrom(c0332f);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public C0299bl toBuilder() {
        return m1876a(this);
    }

    static {
        f955a.m1871D();
    }
}
