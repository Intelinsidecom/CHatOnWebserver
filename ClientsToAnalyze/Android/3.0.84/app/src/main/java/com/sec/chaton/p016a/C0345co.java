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
/* renamed from: com.sec.chaton.a.co */
/* loaded from: classes.dex */
public final class C0345co extends GeneratedMessageLite implements InterfaceC0347cq {

    /* renamed from: a */
    private static final C0345co f1187a = new C0345co(true);

    /* renamed from: b */
    private int f1188b;

    /* renamed from: c */
    private long f1189c;

    /* renamed from: d */
    private EnumC0354cx f1190d;

    /* renamed from: e */
    private Object f1191e;

    /* renamed from: f */
    private Object f1192f;

    /* renamed from: g */
    private LazyStringList f1193g;

    /* renamed from: h */
    private LazyStringList f1194h;

    /* renamed from: i */
    private long f1195i;

    /* renamed from: j */
    private byte f1196j;

    /* renamed from: k */
    private int f1197k;

    private C0345co(C0346cp c0346cp) {
        super(c0346cp);
        this.f1196j = (byte) -1;
        this.f1197k = -1;
    }

    private C0345co(boolean z) {
        this.f1196j = (byte) -1;
        this.f1197k = -1;
    }

    /* renamed from: a */
    public static C0345co m2222a() {
        return f1187a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0345co getDefaultInstanceForType() {
        return f1187a;
    }

    /* renamed from: c */
    public boolean m2236c() {
        return (this.f1188b & 1) == 1;
    }

    /* renamed from: d */
    public long m2237d() {
        return this.f1189c;
    }

    /* renamed from: e */
    public boolean m2238e() {
        return (this.f1188b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0354cx m2239f() {
        return this.f1190d;
    }

    /* renamed from: g */
    public boolean m2240g() {
        return (this.f1188b & 4) == 4;
    }

    /* renamed from: h */
    public String m2241h() {
        Object obj = this.f1191e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1191e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m2232q() {
        Object obj = this.f1191e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1191e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m2242i() {
        return (this.f1188b & 8) == 8;
    }

    /* renamed from: j */
    public String m2243j() {
        Object obj = this.f1192f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1192f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m2233r() {
        Object obj = this.f1192f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1192f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public List<String> m2244k() {
        return this.f1193g;
    }

    /* renamed from: l */
    public List<String> m2245l() {
        return this.f1194h;
    }

    /* renamed from: m */
    public boolean m2246m() {
        return (this.f1188b & 16) == 16;
    }

    /* renamed from: n */
    public long m2247n() {
        return this.f1195i;
    }

    /* renamed from: s */
    private void m2234s() {
        this.f1189c = 0L;
        this.f1190d = EnumC0354cx.TEXT;
        this.f1191e = "";
        this.f1192f = "";
        this.f1193g = LazyStringArrayList.EMPTY;
        this.f1194h = LazyStringArrayList.EMPTY;
        this.f1195i = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1196j;
        if (b != -1) {
            return b == 1;
        }
        this.f1196j = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1188b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1189c);
        }
        if ((this.f1188b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f1190d.getNumber());
        }
        if ((this.f1188b & 4) == 4) {
            codedOutputStream.writeBytes(3, m2232q());
        }
        if ((this.f1188b & 8) == 8) {
            codedOutputStream.writeBytes(4, m2233r());
        }
        for (int i = 0; i < this.f1193g.size(); i++) {
            codedOutputStream.writeBytes(5, this.f1193g.getByteString(i));
        }
        for (int i2 = 0; i2 < this.f1194h.size(); i2++) {
            codedOutputStream.writeBytes(6, this.f1194h.getByteString(i2));
        }
        if ((this.f1188b & 16) == 16) {
            codedOutputStream.writeInt64(7, this.f1195i);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f1197k;
        if (size == -1) {
            int iComputeInt64Size = (this.f1188b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f1189c) + 0 : 0;
            if ((this.f1188b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f1190d.getNumber());
            }
            if ((this.f1188b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m2232q());
            }
            if ((this.f1188b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m2233r());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f1193g.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f1193g.getByteString(i));
            }
            int size2 = (m2244k().size() * 1) + iComputeInt64Size + iComputeBytesSizeNoTag;
            int iComputeBytesSizeNoTag2 = 0;
            for (int i2 = 0; i2 < this.f1194h.size(); i2++) {
                iComputeBytesSizeNoTag2 += CodedOutputStream.computeBytesSizeNoTag(this.f1194h.getByteString(i2));
            }
            size = iComputeBytesSizeNoTag2 + size2 + (m2245l().size() * 1);
            if ((this.f1188b & 16) == 16) {
                size += CodedOutputStream.computeInt64Size(7, this.f1195i);
            }
            this.f1197k = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0345co m2223a(byte[] bArr) {
        return ((C0346cp) newBuilder().mergeFrom(bArr)).m2254p();
    }

    public static C0346cp newBuilder() {
        return C0346cp.m2253o();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C0346cp newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0346cp m2224a(C0345co c0345co) {
        return newBuilder().mergeFrom(c0345co);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0346cp toBuilder() {
        return m2224a(this);
    }

    static {
        f1187a.m2234s();
    }
}
