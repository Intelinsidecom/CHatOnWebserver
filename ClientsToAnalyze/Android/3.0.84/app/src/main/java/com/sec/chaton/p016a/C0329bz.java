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
/* renamed from: com.sec.chaton.a.bz */
/* loaded from: classes.dex */
public final class C0329bz extends GeneratedMessageLite implements InterfaceC0332cb {

    /* renamed from: a */
    private static final C0329bz f1094a = new C0329bz(true);

    /* renamed from: b */
    private int f1095b;

    /* renamed from: c */
    private long f1096c;

    /* renamed from: d */
    private EnumC0302az f1097d;

    /* renamed from: e */
    private Object f1098e;

    /* renamed from: f */
    private Object f1099f;

    /* renamed from: g */
    private Object f1100g;

    /* renamed from: h */
    private LazyStringList f1101h;

    /* renamed from: i */
    private long f1102i;

    /* renamed from: j */
    private byte f1103j;

    /* renamed from: k */
    private int f1104k;

    private C0329bz(C0331ca c0331ca) {
        super(c0331ca);
        this.f1103j = (byte) -1;
        this.f1104k = -1;
    }

    private C0329bz(boolean z) {
        this.f1103j = (byte) -1;
        this.f1104k = -1;
    }

    /* renamed from: a */
    public static C0329bz m1958a() {
        return f1094a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0329bz getDefaultInstanceForType() {
        return f1094a;
    }

    /* renamed from: c */
    public boolean m1971c() {
        return (this.f1095b & 1) == 1;
    }

    /* renamed from: d */
    public long m1972d() {
        return this.f1096c;
    }

    /* renamed from: e */
    public boolean m1973e() {
        return (this.f1095b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0302az m1974f() {
        return this.f1097d;
    }

    /* renamed from: g */
    public boolean m1975g() {
        return (this.f1095b & 4) == 4;
    }

    /* renamed from: h */
    public String m1976h() {
        Object obj = this.f1098e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1098e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m1966r() {
        Object obj = this.f1098e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1098e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m1977i() {
        return (this.f1095b & 8) == 8;
    }

    /* renamed from: j */
    public String m1978j() {
        Object obj = this.f1099f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1099f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m1967s() {
        Object obj = this.f1099f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1099f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m1979k() {
        return (this.f1095b & 16) == 16;
    }

    /* renamed from: l */
    public String m1980l() {
        Object obj = this.f1100g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1100g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: t */
    private ByteString m1968t() {
        Object obj = this.f1100g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1100g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public List<String> m1981m() {
        return this.f1101h;
    }

    /* renamed from: n */
    public boolean m1982n() {
        return (this.f1095b & 32) == 32;
    }

    /* renamed from: o */
    public long m1983o() {
        return this.f1102i;
    }

    /* renamed from: u */
    private void m1969u() {
        this.f1096c = 0L;
        this.f1097d = EnumC0302az.SINGLE;
        this.f1098e = "";
        this.f1099f = "";
        this.f1100g = "";
        this.f1101h = LazyStringArrayList.EMPTY;
        this.f1102i = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1103j;
        if (b != -1) {
            return b == 1;
        }
        this.f1103j = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1095b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1096c);
        }
        if ((this.f1095b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f1097d.getNumber());
        }
        if ((this.f1095b & 4) == 4) {
            codedOutputStream.writeBytes(3, m1966r());
        }
        if ((this.f1095b & 8) == 8) {
            codedOutputStream.writeBytes(4, m1967s());
        }
        if ((this.f1095b & 16) == 16) {
            codedOutputStream.writeBytes(5, m1968t());
        }
        for (int i = 0; i < this.f1101h.size(); i++) {
            codedOutputStream.writeBytes(6, this.f1101h.getByteString(i));
        }
        if ((this.f1095b & 32) == 32) {
            codedOutputStream.writeInt64(7, this.f1102i);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f1104k;
        if (size == -1) {
            int iComputeInt64Size = (this.f1095b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f1096c) + 0 : 0;
            if ((this.f1095b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f1097d.getNumber());
            }
            if ((this.f1095b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m1966r());
            }
            if ((this.f1095b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m1967s());
            }
            if ((this.f1095b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m1968t());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f1101h.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f1101h.getByteString(i));
            }
            size = iComputeInt64Size + iComputeBytesSizeNoTag + (m1981m().size() * 1);
            if ((this.f1095b & 32) == 32) {
                size += CodedOutputStream.computeInt64Size(7, this.f1102i);
            }
            this.f1104k = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0329bz m1959a(byte[] bArr) {
        return ((C0331ca) newBuilder().mergeFrom(bArr)).m2004o();
    }

    public static C0331ca newBuilder() {
        return C0331ca.m2003n();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0331ca newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0331ca m1960a(C0329bz c0329bz) {
        return newBuilder().mergeFrom(c0329bz);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C0331ca toBuilder() {
        return m1960a(this);
    }

    static {
        f1094a.m1969u();
    }
}
