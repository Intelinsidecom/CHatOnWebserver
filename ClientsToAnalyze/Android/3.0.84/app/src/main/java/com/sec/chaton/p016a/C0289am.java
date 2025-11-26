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
/* renamed from: com.sec.chaton.a.am */
/* loaded from: classes.dex */
public final class C0289am extends GeneratedMessageLite implements InterfaceC0291ao {

    /* renamed from: a */
    private static final C0289am f919a = new C0289am(true);

    /* renamed from: b */
    private int f920b;

    /* renamed from: c */
    private long f921c;

    /* renamed from: d */
    private EnumC0302az f922d;

    /* renamed from: e */
    private Object f923e;

    /* renamed from: f */
    private Object f924f;

    /* renamed from: g */
    private LazyStringList f925g;

    /* renamed from: h */
    private EnumC0292ap f926h;

    /* renamed from: i */
    private LazyStringList f927i;

    /* renamed from: j */
    private long f928j;

    /* renamed from: k */
    private byte f929k;

    /* renamed from: l */
    private int f930l;

    private C0289am(C0290an c0290an) {
        super(c0290an);
        this.f929k = (byte) -1;
        this.f930l = -1;
    }

    private C0289am(boolean z) {
        this.f929k = (byte) -1;
        this.f930l = -1;
    }

    /* renamed from: a */
    public static C0289am m1518a() {
        return f919a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0289am getDefaultInstanceForType() {
        return f919a;
    }

    /* renamed from: c */
    public boolean m1533c() {
        return (this.f920b & 1) == 1;
    }

    /* renamed from: d */
    public long m1534d() {
        return this.f921c;
    }

    /* renamed from: e */
    public boolean m1535e() {
        return (this.f920b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0302az m1536f() {
        return this.f922d;
    }

    /* renamed from: g */
    public boolean m1537g() {
        return (this.f920b & 4) == 4;
    }

    /* renamed from: h */
    public String m1538h() {
        Object obj = this.f923e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f923e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m1529s() {
        Object obj = this.f923e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f923e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m1539i() {
        return (this.f920b & 8) == 8;
    }

    /* renamed from: j */
    public String m1540j() {
        Object obj = this.f924f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f924f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: t */
    private ByteString m1530t() {
        Object obj = this.f924f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f924f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public List<String> m1541k() {
        return this.f925g;
    }

    /* renamed from: l */
    public boolean m1542l() {
        return (this.f920b & 16) == 16;
    }

    /* renamed from: m */
    public EnumC0292ap m1543m() {
        return this.f926h;
    }

    /* renamed from: n */
    public List<String> m1544n() {
        return this.f927i;
    }

    /* renamed from: o */
    public boolean m1545o() {
        return (this.f920b & 32) == 32;
    }

    /* renamed from: p */
    public long m1546p() {
        return this.f928j;
    }

    /* renamed from: u */
    private void m1531u() {
        this.f921c = 0L;
        this.f922d = EnumC0302az.SINGLE;
        this.f923e = "";
        this.f924f = "";
        this.f925g = LazyStringArrayList.EMPTY;
        this.f926h = EnumC0292ap.ADD;
        this.f927i = LazyStringArrayList.EMPTY;
        this.f928j = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f929k;
        if (b != -1) {
            return b == 1;
        }
        this.f929k = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f920b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f921c);
        }
        if ((this.f920b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f922d.getNumber());
        }
        if ((this.f920b & 4) == 4) {
            codedOutputStream.writeBytes(3, m1529s());
        }
        if ((this.f920b & 8) == 8) {
            codedOutputStream.writeBytes(4, m1530t());
        }
        for (int i = 0; i < this.f925g.size(); i++) {
            codedOutputStream.writeBytes(5, this.f925g.getByteString(i));
        }
        if ((this.f920b & 16) == 16) {
            codedOutputStream.writeEnum(6, this.f926h.getNumber());
        }
        for (int i2 = 0; i2 < this.f927i.size(); i2++) {
            codedOutputStream.writeBytes(7, this.f927i.getByteString(i2));
        }
        if ((this.f920b & 32) == 32) {
            codedOutputStream.writeInt64(8, this.f928j);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f930l;
        if (size == -1) {
            int iComputeInt64Size = (this.f920b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f921c) + 0 : 0;
            if ((this.f920b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f922d.getNumber());
            }
            if ((this.f920b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m1529s());
            }
            if ((this.f920b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m1530t());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f925g.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f925g.getByteString(i));
            }
            int size2 = iComputeInt64Size + iComputeBytesSizeNoTag + (m1541k().size() * 1);
            if ((this.f920b & 16) == 16) {
                size2 += CodedOutputStream.computeEnumSize(6, this.f926h.getNumber());
            }
            int iComputeBytesSizeNoTag2 = 0;
            for (int i2 = 0; i2 < this.f927i.size(); i2++) {
                iComputeBytesSizeNoTag2 += CodedOutputStream.computeBytesSizeNoTag(this.f927i.getByteString(i2));
            }
            size = size2 + iComputeBytesSizeNoTag2 + (m1544n().size() * 1);
            if ((this.f920b & 32) == 32) {
                size += CodedOutputStream.computeInt64Size(8, this.f928j);
            }
            this.f930l = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0289am m1519a(byte[] bArr) {
        return ((C0290an) newBuilder().mergeFrom(bArr)).m1553s();
    }

    public static C0290an newBuilder() {
        return C0290an.m1552r();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C0290an newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0290an m1520a(C0289am c0289am) {
        return newBuilder().mergeFrom(c0289am);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C0290an toBuilder() {
        return m1520a(this);
    }

    static {
        f919a.m1531u();
    }
}
