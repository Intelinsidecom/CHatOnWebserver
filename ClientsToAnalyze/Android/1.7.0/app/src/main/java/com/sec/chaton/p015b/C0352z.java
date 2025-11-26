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
/* renamed from: com.sec.chaton.b.z */
/* loaded from: classes.dex */
public final class C0352z extends GeneratedMessageLite implements InterfaceC0342p {

    /* renamed from: a */
    private static final C0352z f1009a = new C0352z(true);

    /* renamed from: b */
    private int f1010b;

    /* renamed from: c */
    private long f1011c;

    /* renamed from: d */
    private EnumC0275ao f1012d;

    /* renamed from: e */
    private Object f1013e;

    /* renamed from: f */
    private Object f1014f;

    /* renamed from: g */
    private LazyStringList f1015g;

    /* renamed from: h */
    private LazyStringList f1016h;

    /* renamed from: i */
    private byte f1017i;

    /* renamed from: j */
    private int f1018j;

    private C0352z(C0309bv c0309bv) {
        super(c0309bv);
        this.f1017i = (byte) -1;
        this.f1018j = -1;
    }

    private C0352z(boolean z) {
        this.f1017i = (byte) -1;
        this.f1018j = -1;
    }

    /* renamed from: a */
    public static C0352z m2018a() {
        return f1009a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0352z getDefaultInstanceForType() {
        return f1009a;
    }

    /* renamed from: c */
    public boolean m2029c() {
        return (this.f1010b & 1) == 1;
    }

    /* renamed from: d */
    public long m2030d() {
        return this.f1011c;
    }

    /* renamed from: e */
    public boolean m2031e() {
        return (this.f1010b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0275ao m2032f() {
        return this.f1012d;
    }

    /* renamed from: g */
    public boolean m2033g() {
        return (this.f1010b & 4) == 4;
    }

    /* renamed from: h */
    public String m2034h() {
        Object obj = this.f1013e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1013e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m2025o() {
        Object obj = this.f1013e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1013e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m2035i() {
        return (this.f1010b & 8) == 8;
    }

    /* renamed from: j */
    public String m2036j() {
        Object obj = this.f1014f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1014f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m2026p() {
        Object obj = this.f1014f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1014f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public List m2037k() {
        return this.f1015g;
    }

    /* renamed from: l */
    public List m2038l() {
        return this.f1016h;
    }

    /* renamed from: q */
    private void m2027q() {
        this.f1011c = 0L;
        this.f1012d = EnumC0275ao.TEXT;
        this.f1013e = "";
        this.f1014f = "";
        this.f1015g = LazyStringArrayList.EMPTY;
        this.f1016h = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1017i;
        if (b != -1) {
            return b == 1;
        }
        this.f1017i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1010b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1011c);
        }
        if ((this.f1010b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f1012d.getNumber());
        }
        if ((this.f1010b & 4) == 4) {
            codedOutputStream.writeBytes(3, m2025o());
        }
        if ((this.f1010b & 8) == 8) {
            codedOutputStream.writeBytes(4, m2026p());
        }
        for (int i = 0; i < this.f1015g.size(); i++) {
            codedOutputStream.writeBytes(5, this.f1015g.getByteString(i));
        }
        for (int i2 = 0; i2 < this.f1016h.size(); i2++) {
            codedOutputStream.writeBytes(6, this.f1016h.getByteString(i2));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f1018j;
        if (i == -1) {
            int iComputeInt64Size = (this.f1010b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f1011c) + 0 : 0;
            if ((this.f1010b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f1012d.getNumber());
            }
            if ((this.f1010b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m2025o());
            }
            if ((this.f1010b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m2026p());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f1015g.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f1015g.getByteString(i2));
            }
            int size = (m2037k().size() * 1) + iComputeInt64Size + iComputeBytesSizeNoTag;
            int iComputeBytesSizeNoTag2 = 0;
            for (int i3 = 0; i3 < this.f1016h.size(); i3++) {
                iComputeBytesSizeNoTag2 += CodedOutputStream.computeBytesSizeNoTag(this.f1016h.getByteString(i3));
            }
            int size2 = iComputeBytesSizeNoTag2 + size + (m2038l().size() * 1);
            this.f1018j = size2;
            return size2;
        }
        return i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0352z m2019a(byte[] bArr) {
        return ((C0309bv) newBuilder().mergeFrom(bArr)).m1568o();
    }

    public static C0309bv newBuilder() {
        return C0309bv.m1567n();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0309bv newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0309bv m2017a(C0352z c0352z) {
        return newBuilder().mergeFrom(c0352z);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0309bv toBuilder() {
        return m2017a(this);
    }

    static {
        f1009a.m2027q();
    }
}
