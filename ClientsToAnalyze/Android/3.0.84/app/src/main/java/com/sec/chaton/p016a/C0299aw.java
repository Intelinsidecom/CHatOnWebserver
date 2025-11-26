package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.aw */
/* loaded from: classes.dex */
public final class C0299aw extends GeneratedMessageLite implements InterfaceC0301ay {

    /* renamed from: a */
    private static final C0299aw f965a = new C0299aw(true);

    /* renamed from: b */
    private int f966b;

    /* renamed from: c */
    private long f967c;

    /* renamed from: d */
    private EnumC0354cx f968d;

    /* renamed from: e */
    private EnumC0302az f969e;

    /* renamed from: f */
    private Object f970f;

    /* renamed from: g */
    private Object f971g;

    /* renamed from: h */
    private LazyStringList f972h;

    /* renamed from: i */
    private Object f973i;

    /* renamed from: j */
    private Object f974j;

    /* renamed from: k */
    private Object f975k;

    /* renamed from: l */
    private Object f976l;

    /* renamed from: m */
    private long f977m;

    /* renamed from: n */
    private byte f978n;

    /* renamed from: o */
    private int f979o;

    private C0299aw(C0300ax c0300ax) {
        super(c0300ax);
        this.f978n = (byte) -1;
        this.f979o = -1;
    }

    private C0299aw(boolean z) {
        this.f978n = (byte) -1;
        this.f979o = -1;
    }

    /* renamed from: a */
    public static C0299aw m1642a() {
        return f965a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0299aw getDefaultInstanceForType() {
        return f965a;
    }

    /* renamed from: c */
    public boolean m1657c() {
        return (this.f966b & 1) == 1;
    }

    /* renamed from: d */
    public long m1658d() {
        return this.f967c;
    }

    /* renamed from: e */
    public boolean m1659e() {
        return (this.f966b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0354cx m1660f() {
        return this.f968d;
    }

    /* renamed from: g */
    public boolean m1661g() {
        return (this.f966b & 4) == 4;
    }

    /* renamed from: h */
    public EnumC0302az m1662h() {
        return this.f969e;
    }

    /* renamed from: i */
    public boolean m1663i() {
        return (this.f966b & 8) == 8;
    }

    /* renamed from: j */
    public String m1664j() {
        Object obj = this.f970f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f970f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m1655z() {
        Object obj = this.f970f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f970f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m1665k() {
        return (this.f966b & 16) == 16;
    }

    /* renamed from: l */
    public String m1666l() {
        Object obj = this.f971g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f971g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: A */
    private ByteString m1633A() {
        Object obj = this.f971g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f971g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public List<String> m1667m() {
        return this.f972h;
    }

    /* renamed from: n */
    public boolean m1668n() {
        return (this.f966b & 32) == 32;
    }

    /* renamed from: o */
    public String m1669o() {
        Object obj = this.f973i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f973i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: B */
    private ByteString m1634B() {
        Object obj = this.f973i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f973i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    public boolean m1670p() {
        return (this.f966b & 64) == 64;
    }

    /* renamed from: q */
    public String m1671q() {
        Object obj = this.f974j;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f974j = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: C */
    private ByteString m1635C() {
        Object obj = this.f974j;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f974j = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: r */
    public boolean m1672r() {
        return (this.f966b & 128) == 128;
    }

    /* renamed from: s */
    public String m1673s() {
        Object obj = this.f975k;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f975k = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: D */
    private ByteString m1636D() {
        Object obj = this.f975k;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f975k = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: t */
    public boolean m1674t() {
        return (this.f966b & 256) == 256;
    }

    /* renamed from: u */
    public String m1675u() {
        Object obj = this.f976l;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f976l = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: E */
    private ByteString m1637E() {
        Object obj = this.f976l;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f976l = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: v */
    public boolean m1676v() {
        return (this.f966b & 512) == 512;
    }

    /* renamed from: w */
    public long m1677w() {
        return this.f977m;
    }

    /* renamed from: F */
    private void m1638F() {
        this.f967c = 0L;
        this.f968d = EnumC0354cx.TEXT;
        this.f969e = EnumC0302az.SINGLE;
        this.f970f = "";
        this.f971g = "";
        this.f972h = LazyStringArrayList.EMPTY;
        this.f973i = "";
        this.f974j = "";
        this.f975k = "";
        this.f976l = "";
        this.f977m = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f978n;
        if (b != -1) {
            return b == 1;
        }
        this.f978n = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f966b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f967c);
        }
        if ((this.f966b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f968d.getNumber());
        }
        if ((this.f966b & 4) == 4) {
            codedOutputStream.writeEnum(3, this.f969e.getNumber());
        }
        if ((this.f966b & 8) == 8) {
            codedOutputStream.writeBytes(4, m1655z());
        }
        if ((this.f966b & 16) == 16) {
            codedOutputStream.writeBytes(5, m1633A());
        }
        for (int i = 0; i < this.f972h.size(); i++) {
            codedOutputStream.writeBytes(6, this.f972h.getByteString(i));
        }
        if ((this.f966b & 32) == 32) {
            codedOutputStream.writeBytes(7, m1634B());
        }
        if ((this.f966b & 64) == 64) {
            codedOutputStream.writeBytes(8, m1635C());
        }
        if ((this.f966b & 128) == 128) {
            codedOutputStream.writeBytes(9, m1636D());
        }
        if ((this.f966b & 256) == 256) {
            codedOutputStream.writeBytes(10, m1637E());
        }
        if ((this.f966b & 512) == 512) {
            codedOutputStream.writeInt64(11, this.f977m);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f979o;
        if (size == -1) {
            int iComputeInt64Size = (this.f966b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f967c) + 0 : 0;
            if ((this.f966b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f968d.getNumber());
            }
            if ((this.f966b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(3, this.f969e.getNumber());
            }
            if ((this.f966b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m1655z());
            }
            if ((this.f966b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m1633A());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f972h.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f972h.getByteString(i));
            }
            size = iComputeInt64Size + iComputeBytesSizeNoTag + (m1667m().size() * 1);
            if ((this.f966b & 32) == 32) {
                size += CodedOutputStream.computeBytesSize(7, m1634B());
            }
            if ((this.f966b & 64) == 64) {
                size += CodedOutputStream.computeBytesSize(8, m1635C());
            }
            if ((this.f966b & 128) == 128) {
                size += CodedOutputStream.computeBytesSize(9, m1636D());
            }
            if ((this.f966b & 256) == 256) {
                size += CodedOutputStream.computeBytesSize(10, m1637E());
            }
            if ((this.f966b & 512) == 512) {
                size += CodedOutputStream.computeInt64Size(11, this.f977m);
            }
            this.f979o = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0299aw m1643a(byte[] bArr) {
        return ((C0300ax) newBuilder().mergeFrom(bArr)).m1684i();
    }

    public static C0300ax newBuilder() {
        return C0300ax.m1683h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public C0300ax newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0300ax m1644a(C0299aw c0299aw) {
        return newBuilder().mergeFrom(c0299aw);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public C0300ax toBuilder() {
        return m1644a(this);
    }

    static {
        f965a.m1638F();
    }
}
