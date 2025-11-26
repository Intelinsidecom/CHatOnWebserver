package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bv */
/* loaded from: classes.dex */
public final class C0156bv extends GeneratedMessageLite implements InterfaceC0158bx {

    /* renamed from: a */
    private static final C0156bv f562a = new C0156bv(true);

    /* renamed from: b */
    private int f563b;

    /* renamed from: c */
    private long f564c;

    /* renamed from: d */
    private EnumC0159by f565d;

    /* renamed from: e */
    private Object f566e;

    /* renamed from: f */
    private Object f567f;

    /* renamed from: g */
    private LazyStringList f568g;

    /* renamed from: h */
    private LazyStringList f569h;

    /* renamed from: i */
    private byte f570i;

    /* renamed from: j */
    private int f571j;

    private C0156bv(C0157bw c0157bw) {
        super(c0157bw);
        this.f570i = (byte) -1;
        this.f571j = -1;
    }

    private C0156bv(boolean z) {
        this.f570i = (byte) -1;
        this.f571j = -1;
    }

    /* renamed from: a */
    public static C0156bv m1296a() {
        return f562a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0156bv getDefaultInstanceForType() {
        return f562a;
    }

    /* renamed from: c */
    public boolean m1309c() {
        return (this.f563b & 1) == 1;
    }

    /* renamed from: d */
    public long m1310d() {
        return this.f564c;
    }

    /* renamed from: e */
    public boolean m1311e() {
        return (this.f563b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0159by m1312f() {
        return this.f565d;
    }

    /* renamed from: g */
    public boolean m1313g() {
        return (this.f563b & 4) == 4;
    }

    /* renamed from: h */
    public String m1314h() {
        Object obj = this.f566e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f566e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m1305o() {
        Object obj = this.f566e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f566e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m1315i() {
        return (this.f563b & 8) == 8;
    }

    /* renamed from: j */
    public String m1316j() {
        Object obj = this.f567f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f567f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m1306p() {
        Object obj = this.f567f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f567f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public List m1317k() {
        return this.f568g;
    }

    /* renamed from: l */
    public List m1318l() {
        return this.f569h;
    }

    /* renamed from: q */
    private void m1307q() {
        this.f564c = 0L;
        this.f565d = EnumC0159by.TEXT;
        this.f566e = "";
        this.f567f = "";
        this.f568g = LazyStringArrayList.EMPTY;
        this.f569h = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f570i;
        if (b != -1) {
            return b == 1;
        }
        this.f570i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f563b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f564c);
        }
        if ((this.f563b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f565d.getNumber());
        }
        if ((this.f563b & 4) == 4) {
            codedOutputStream.writeBytes(3, m1305o());
        }
        if ((this.f563b & 8) == 8) {
            codedOutputStream.writeBytes(4, m1306p());
        }
        for (int i = 0; i < this.f568g.size(); i++) {
            codedOutputStream.writeBytes(5, this.f568g.getByteString(i));
        }
        for (int i2 = 0; i2 < this.f569h.size(); i2++) {
            codedOutputStream.writeBytes(6, this.f569h.getByteString(i2));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f571j;
        if (i == -1) {
            int iComputeInt64Size = (this.f563b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f564c) + 0 : 0;
            if ((this.f563b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f565d.getNumber());
            }
            if ((this.f563b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m1305o());
            }
            if ((this.f563b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m1306p());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f568g.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f568g.getByteString(i2));
            }
            int size = (m1317k().size() * 1) + iComputeInt64Size + iComputeBytesSizeNoTag;
            int iComputeBytesSizeNoTag2 = 0;
            for (int i3 = 0; i3 < this.f569h.size(); i3++) {
                iComputeBytesSizeNoTag2 += CodedOutputStream.computeBytesSizeNoTag(this.f569h.getByteString(i3));
            }
            int size2 = iComputeBytesSizeNoTag2 + size + (m1318l().size() * 1);
            this.f571j = size2;
            return size2;
        }
        return i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0156bv m1297a(byte[] bArr) {
        return ((C0157bw) newBuilder().mergeFrom(bArr)).m1325o();
    }

    public static C0157bw newBuilder() {
        return C0157bw.m1324n();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0157bw newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0157bw m1298a(C0156bv c0156bv) {
        return newBuilder().mergeFrom(c0156bv);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0157bw toBuilder() {
        return m1298a(this);
    }

    static {
        f562a.m1307q();
    }
}
