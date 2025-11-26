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
/* renamed from: com.sec.chaton.a.ci */
/* loaded from: classes.dex */
public final class C0339ci extends GeneratedMessageLite implements InterfaceC0341ck {

    /* renamed from: a */
    private static final C0339ci f1153a = new C0339ci(true);

    /* renamed from: b */
    private int f1154b;

    /* renamed from: c */
    private long f1155c;

    /* renamed from: d */
    private EnumC0354cx f1156d;

    /* renamed from: e */
    private EnumC0302az f1157e;

    /* renamed from: f */
    private Object f1158f;

    /* renamed from: g */
    private Object f1159g;

    /* renamed from: h */
    private long f1160h;

    /* renamed from: i */
    private Object f1161i;

    /* renamed from: j */
    private LazyStringList f1162j;

    /* renamed from: k */
    private Object f1163k;

    /* renamed from: l */
    private byte f1164l;

    /* renamed from: m */
    private int f1165m;

    private C0339ci(C0340cj c0340cj) {
        super(c0340cj);
        this.f1164l = (byte) -1;
        this.f1165m = -1;
    }

    private C0339ci(boolean z) {
        this.f1164l = (byte) -1;
        this.f1165m = -1;
    }

    /* renamed from: a */
    public static C0339ci m2127a() {
        return f1153a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0339ci getDefaultInstanceForType() {
        return f1153a;
    }

    /* renamed from: c */
    public boolean m2143c() {
        return (this.f1154b & 1) == 1;
    }

    /* renamed from: d */
    public long m2144d() {
        return this.f1155c;
    }

    /* renamed from: e */
    public boolean m2145e() {
        return (this.f1154b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0354cx m2146f() {
        return this.f1156d;
    }

    /* renamed from: g */
    public boolean m2147g() {
        return (this.f1154b & 4) == 4;
    }

    /* renamed from: h */
    public EnumC0302az m2148h() {
        return this.f1157e;
    }

    /* renamed from: i */
    public boolean m2149i() {
        return (this.f1154b & 8) == 8;
    }

    /* renamed from: j */
    public String m2150j() {
        Object obj = this.f1158f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1158f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: v */
    private ByteString m2137v() {
        Object obj = this.f1158f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1158f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m2151k() {
        return (this.f1154b & 16) == 16;
    }

    /* renamed from: l */
    public String m2152l() {
        Object obj = this.f1159g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1159g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: w */
    private ByteString m2138w() {
        Object obj = this.f1159g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1159g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m2153m() {
        return (this.f1154b & 32) == 32;
    }

    /* renamed from: n */
    public long m2154n() {
        return this.f1160h;
    }

    /* renamed from: o */
    public boolean m2155o() {
        return (this.f1154b & 64) == 64;
    }

    /* renamed from: p */
    public String m2156p() {
        Object obj = this.f1161i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1161i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m2139x() {
        Object obj = this.f1161i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1161i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: q */
    public List<String> m2157q() {
        return this.f1162j;
    }

    /* renamed from: r */
    public boolean m2158r() {
        return (this.f1154b & 128) == 128;
    }

    /* renamed from: s */
    public String m2159s() {
        Object obj = this.f1163k;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1163k = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m2140y() {
        Object obj = this.f1163k;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1163k = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: z */
    private void m2141z() {
        this.f1155c = 0L;
        this.f1156d = EnumC0354cx.TEXT;
        this.f1157e = EnumC0302az.SINGLE;
        this.f1158f = "";
        this.f1159g = "";
        this.f1160h = 0L;
        this.f1161i = "";
        this.f1162j = LazyStringArrayList.EMPTY;
        this.f1163k = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1164l;
        if (b != -1) {
            return b == 1;
        }
        this.f1164l = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1154b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1155c);
        }
        if ((this.f1154b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f1156d.getNumber());
        }
        if ((this.f1154b & 4) == 4) {
            codedOutputStream.writeEnum(3, this.f1157e.getNumber());
        }
        if ((this.f1154b & 8) == 8) {
            codedOutputStream.writeBytes(4, m2137v());
        }
        if ((this.f1154b & 16) == 16) {
            codedOutputStream.writeBytes(5, m2138w());
        }
        if ((this.f1154b & 32) == 32) {
            codedOutputStream.writeInt64(6, this.f1160h);
        }
        if ((this.f1154b & 64) == 64) {
            codedOutputStream.writeBytes(7, m2139x());
        }
        for (int i = 0; i < this.f1162j.size(); i++) {
            codedOutputStream.writeBytes(8, this.f1162j.getByteString(i));
        }
        if ((this.f1154b & 128) == 128) {
            codedOutputStream.writeBytes(9, m2140y());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f1165m;
        if (size == -1) {
            int iComputeInt64Size = (this.f1154b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f1155c) + 0 : 0;
            if ((this.f1154b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f1156d.getNumber());
            }
            if ((this.f1154b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(3, this.f1157e.getNumber());
            }
            if ((this.f1154b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m2137v());
            }
            if ((this.f1154b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m2138w());
            }
            if ((this.f1154b & 32) == 32) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(6, this.f1160h);
            }
            if ((this.f1154b & 64) == 64) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(7, m2139x());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f1162j.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f1162j.getByteString(i));
            }
            size = iComputeInt64Size + iComputeBytesSizeNoTag + (m2157q().size() * 1);
            if ((this.f1154b & 128) == 128) {
                size += CodedOutputStream.computeBytesSize(9, m2140y());
            }
            this.f1165m = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0339ci m2128a(byte[] bArr) {
        return ((C0340cj) newBuilder().mergeFrom(bArr)).m2166i();
    }

    public static C0340cj newBuilder() {
        return C0340cj.m2165h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public C0340cj newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0340cj m2129a(C0339ci c0339ci) {
        return newBuilder().mergeFrom(c0339ci);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public C0340cj toBuilder() {
        return m2129a(this);
    }

    static {
        f1153a.m2141z();
    }
}
