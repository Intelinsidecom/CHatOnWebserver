package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dr */
/* loaded from: classes.dex */
public final class C0375dr extends GeneratedMessageLite implements InterfaceC0377dt {

    /* renamed from: a */
    private static final C0375dr f1304a = new C0375dr(true);

    /* renamed from: b */
    private int f1305b;

    /* renamed from: c */
    private long f1306c;

    /* renamed from: d */
    private EnumC0302az f1307d;

    /* renamed from: e */
    private Object f1308e;

    /* renamed from: f */
    private Object f1309f;

    /* renamed from: g */
    private LazyStringList f1310g;

    /* renamed from: h */
    private Object f1311h;

    /* renamed from: i */
    private Object f1312i;

    /* renamed from: j */
    private long f1313j;

    /* renamed from: k */
    private List<C0378du> f1314k;

    /* renamed from: l */
    private byte f1315l;

    /* renamed from: m */
    private int f1316m;

    private C0375dr(C0376ds c0376ds) {
        super(c0376ds);
        this.f1315l = (byte) -1;
        this.f1316m = -1;
    }

    private C0375dr(boolean z) {
        this.f1315l = (byte) -1;
        this.f1316m = -1;
    }

    /* renamed from: a */
    public static C0375dr m2568a() {
        return f1304a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0375dr getDefaultInstanceForType() {
        return f1304a;
    }

    /* renamed from: c */
    public boolean m2585c() {
        return (this.f1305b & 1) == 1;
    }

    /* renamed from: d */
    public long m2586d() {
        return this.f1306c;
    }

    /* renamed from: e */
    public boolean m2587e() {
        return (this.f1305b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0302az m2588f() {
        return this.f1307d;
    }

    /* renamed from: g */
    public boolean m2589g() {
        return (this.f1305b & 4) == 4;
    }

    /* renamed from: h */
    public String m2590h() {
        Object obj = this.f1308e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1308e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: u */
    private ByteString m2579u() {
        Object obj = this.f1308e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1308e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m2591i() {
        return (this.f1305b & 8) == 8;
    }

    /* renamed from: j */
    public String m2592j() {
        Object obj = this.f1309f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1309f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: v */
    private ByteString m2580v() {
        Object obj = this.f1309f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1309f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public List<String> m2593k() {
        return this.f1310g;
    }

    /* renamed from: l */
    public boolean m2594l() {
        return (this.f1305b & 16) == 16;
    }

    /* renamed from: m */
    public String m2595m() {
        Object obj = this.f1311h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1311h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: w */
    private ByteString m2581w() {
        Object obj = this.f1311h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1311h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: n */
    public boolean m2596n() {
        return (this.f1305b & 32) == 32;
    }

    /* renamed from: o */
    public String m2597o() {
        Object obj = this.f1312i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1312i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m2582x() {
        Object obj = this.f1312i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1312i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    public boolean m2598p() {
        return (this.f1305b & 64) == 64;
    }

    /* renamed from: q */
    public long m2599q() {
        return this.f1313j;
    }

    /* renamed from: r */
    public List<C0378du> m2600r() {
        return this.f1314k;
    }

    /* renamed from: y */
    private void m2583y() {
        this.f1306c = 0L;
        this.f1307d = EnumC0302az.SINGLE;
        this.f1308e = "";
        this.f1309f = "";
        this.f1310g = LazyStringArrayList.EMPTY;
        this.f1311h = "";
        this.f1312i = "";
        this.f1313j = 0L;
        this.f1314k = Collections.emptyList();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1315l;
        if (b != -1) {
            return b == 1;
        }
        this.f1315l = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1305b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1306c);
        }
        if ((this.f1305b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f1307d.getNumber());
        }
        if ((this.f1305b & 4) == 4) {
            codedOutputStream.writeBytes(3, m2579u());
        }
        if ((this.f1305b & 8) == 8) {
            codedOutputStream.writeBytes(4, m2580v());
        }
        for (int i = 0; i < this.f1310g.size(); i++) {
            codedOutputStream.writeBytes(5, this.f1310g.getByteString(i));
        }
        if ((this.f1305b & 16) == 16) {
            codedOutputStream.writeBytes(6, m2581w());
        }
        if ((this.f1305b & 32) == 32) {
            codedOutputStream.writeBytes(7, m2582x());
        }
        if ((this.f1305b & 64) == 64) {
            codedOutputStream.writeInt64(8, this.f1313j);
        }
        for (int i2 = 0; i2 < this.f1314k.size(); i2++) {
            codedOutputStream.writeMessage(9, this.f1314k.get(i2));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int i2 = this.f1316m;
        if (i2 == -1) {
            int iComputeInt64Size = (this.f1305b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f1306c) + 0 : 0;
            if ((this.f1305b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f1307d.getNumber());
            }
            if ((this.f1305b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m2579u());
            }
            if ((this.f1305b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m2580v());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i3 = 0; i3 < this.f1310g.size(); i3++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f1310g.getByteString(i3));
            }
            int size = iComputeInt64Size + iComputeBytesSizeNoTag + (m2593k().size() * 1);
            if ((this.f1305b & 16) == 16) {
                size += CodedOutputStream.computeBytesSize(6, m2581w());
            }
            if ((this.f1305b & 32) == 32) {
                size += CodedOutputStream.computeBytesSize(7, m2582x());
            }
            if ((this.f1305b & 64) == 64) {
                size += CodedOutputStream.computeInt64Size(8, this.f1313j);
            }
            while (true) {
                i2 = size;
                if (i >= this.f1314k.size()) {
                    break;
                }
                size = CodedOutputStream.computeMessageSize(9, this.f1314k.get(i)) + i2;
                i++;
            }
            this.f1316m = i2;
        }
        return i2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0375dr m2569a(byte[] bArr) {
        return ((C0376ds) newBuilder().mergeFrom(bArr)).m2607i();
    }

    public static C0376ds newBuilder() {
        return C0376ds.m2606h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public C0376ds newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0376ds m2570a(C0375dr c0375dr) {
        return newBuilder().mergeFrom(c0375dr);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public C0376ds toBuilder() {
        return m2570a(this);
    }

    static {
        f1304a.m2583y();
    }
}
