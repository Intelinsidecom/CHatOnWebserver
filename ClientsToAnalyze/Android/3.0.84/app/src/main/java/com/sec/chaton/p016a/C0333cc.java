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
/* renamed from: com.sec.chaton.a.cc */
/* loaded from: classes.dex */
public final class C0333cc extends GeneratedMessageLite implements InterfaceC0335ce {

    /* renamed from: a */
    private static final C0333cc f1119a = new C0333cc(true);

    /* renamed from: b */
    private int f1120b;

    /* renamed from: c */
    private Object f1121c;

    /* renamed from: d */
    private LazyStringList f1122d;

    /* renamed from: e */
    private long f1123e;

    /* renamed from: f */
    private Object f1124f;

    /* renamed from: g */
    private long f1125g;

    /* renamed from: h */
    private EnumC0354cx f1126h;

    /* renamed from: i */
    private EnumC0302az f1127i;

    /* renamed from: j */
    private byte f1128j;

    /* renamed from: k */
    private int f1129k;

    private C0333cc(C0334cd c0334cd) {
        super(c0334cd);
        this.f1128j = (byte) -1;
        this.f1129k = -1;
    }

    private C0333cc(boolean z) {
        this.f1128j = (byte) -1;
        this.f1129k = -1;
    }

    /* renamed from: a */
    public static C0333cc m2030a() {
        return f1119a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0333cc getDefaultInstanceForType() {
        return f1119a;
    }

    /* renamed from: c */
    public boolean m2042c() {
        return (this.f1120b & 1) == 1;
    }

    /* renamed from: d */
    public String m2043d() {
        Object obj = this.f1121c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1121c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m2037s() {
        Object obj = this.f1121c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1121c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public List<String> m2044e() {
        return this.f1122d;
    }

    /* renamed from: f */
    public int m2045f() {
        return this.f1122d.size();
    }

    /* renamed from: a */
    public String m2040a(int i) {
        return this.f1122d.get(i);
    }

    /* renamed from: g */
    public boolean m2046g() {
        return (this.f1120b & 2) == 2;
    }

    /* renamed from: h */
    public long m2047h() {
        return this.f1123e;
    }

    /* renamed from: i */
    public boolean m2048i() {
        return (this.f1120b & 4) == 4;
    }

    /* renamed from: j */
    public String m2049j() {
        Object obj = this.f1124f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1124f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: t */
    private ByteString m2038t() {
        Object obj = this.f1124f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1124f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m2050k() {
        return (this.f1120b & 8) == 8;
    }

    /* renamed from: l */
    public long m2051l() {
        return this.f1125g;
    }

    /* renamed from: m */
    public boolean m2052m() {
        return (this.f1120b & 16) == 16;
    }

    /* renamed from: n */
    public EnumC0354cx m2053n() {
        return this.f1126h;
    }

    /* renamed from: o */
    public boolean m2054o() {
        return (this.f1120b & 32) == 32;
    }

    /* renamed from: p */
    public EnumC0302az m2055p() {
        return this.f1127i;
    }

    /* renamed from: u */
    private void m2039u() {
        this.f1121c = "";
        this.f1122d = LazyStringArrayList.EMPTY;
        this.f1123e = 0L;
        this.f1124f = "";
        this.f1125g = 0L;
        this.f1126h = EnumC0354cx.TEXT;
        this.f1127i = EnumC0302az.SINGLE;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1128j;
        if (b != -1) {
            return b == 1;
        }
        this.f1128j = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1120b & 1) == 1) {
            codedOutputStream.writeBytes(1, m2037s());
        }
        for (int i = 0; i < this.f1122d.size(); i++) {
            codedOutputStream.writeBytes(2, this.f1122d.getByteString(i));
        }
        if ((this.f1120b & 2) == 2) {
            codedOutputStream.writeInt64(3, this.f1123e);
        }
        if ((this.f1120b & 4) == 4) {
            codedOutputStream.writeBytes(4, m2038t());
        }
        if ((this.f1120b & 8) == 8) {
            codedOutputStream.writeInt64(5, this.f1125g);
        }
        if ((this.f1120b & 16) == 16) {
            codedOutputStream.writeEnum(6, this.f1126h.getNumber());
        }
        if ((this.f1120b & 32) == 32) {
            codedOutputStream.writeEnum(7, this.f1127i.getNumber());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f1129k;
        if (size == -1) {
            int iComputeBytesSize = (this.f1120b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m2037s()) + 0 : 0;
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f1122d.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f1122d.getByteString(i));
            }
            size = iComputeBytesSize + iComputeBytesSizeNoTag + (m2044e().size() * 1);
            if ((this.f1120b & 2) == 2) {
                size += CodedOutputStream.computeInt64Size(3, this.f1123e);
            }
            if ((this.f1120b & 4) == 4) {
                size += CodedOutputStream.computeBytesSize(4, m2038t());
            }
            if ((this.f1120b & 8) == 8) {
                size += CodedOutputStream.computeInt64Size(5, this.f1125g);
            }
            if ((this.f1120b & 16) == 16) {
                size += CodedOutputStream.computeEnumSize(6, this.f1126h.getNumber());
            }
            if ((this.f1120b & 32) == 32) {
                size += CodedOutputStream.computeEnumSize(7, this.f1127i.getNumber());
            }
            this.f1129k = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0334cd newBuilder() {
        return C0334cd.m2060h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C0334cd newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0334cd m2031a(C0333cc c0333cc) {
        return newBuilder().mergeFrom(c0333cc);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C0334cd toBuilder() {
        return m2031a(this);
    }

    static {
        f1119a.m2039u();
    }
}
