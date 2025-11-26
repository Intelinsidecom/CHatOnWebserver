package com.sec.chaton.p046a;

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
/* renamed from: com.sec.chaton.a.ft */
/* loaded from: classes.dex */
public final class C0947ft extends GeneratedMessageLite implements InterfaceC0949fv {

    /* renamed from: a */
    private static final C0947ft f3010a = new C0947ft(true);

    /* renamed from: b */
    private int f3011b;

    /* renamed from: c */
    private long f3012c;

    /* renamed from: d */
    private EnumC0822bc f3013d;

    /* renamed from: e */
    private Object f3014e;

    /* renamed from: f */
    private Object f3015f;

    /* renamed from: g */
    private LazyStringList f3016g;

    /* renamed from: h */
    private Object f3017h;

    /* renamed from: i */
    private Object f3018i;

    /* renamed from: j */
    private long f3019j;

    /* renamed from: k */
    private List<C0950fw> f3020k;

    /* renamed from: l */
    private Object f3021l;

    /* renamed from: m */
    private long f3022m;

    /* renamed from: n */
    private byte f3023n;

    /* renamed from: o */
    private int f3024o;

    private C0947ft(C0948fu c0948fu) {
        super(c0948fu);
        this.f3023n = (byte) -1;
        this.f3024o = -1;
    }

    private C0947ft(boolean z) {
        this.f3023n = (byte) -1;
        this.f3024o = -1;
    }

    /* renamed from: a */
    public static C0947ft m5391a() {
        return f3010a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0947ft getDefaultInstanceForType() {
        return f3010a;
    }

    /* renamed from: c */
    public boolean m5407c() {
        return (this.f3011b & 1) == 1;
    }

    /* renamed from: d */
    public long m5408d() {
        return this.f3012c;
    }

    /* renamed from: e */
    public boolean m5409e() {
        return (this.f3011b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0822bc m5410f() {
        return this.f3013d;
    }

    /* renamed from: g */
    public boolean m5411g() {
        return (this.f3011b & 4) == 4;
    }

    /* renamed from: h */
    public String m5412h() {
        Object obj = this.f3014e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3014e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m5404y() {
        Object obj = this.f3014e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3014e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m5413i() {
        return (this.f3011b & 8) == 8;
    }

    /* renamed from: j */
    public String m5414j() {
        Object obj = this.f3015f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3015f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m5405z() {
        Object obj = this.f3015f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3015f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public List<String> m5415k() {
        return this.f3016g;
    }

    /* renamed from: l */
    public boolean m5416l() {
        return (this.f3011b & 16) == 16;
    }

    /* renamed from: m */
    public String m5417m() {
        Object obj = this.f3017h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3017h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: A */
    private ByteString m5383A() {
        Object obj = this.f3017h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3017h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: n */
    public boolean m5418n() {
        return (this.f3011b & 32) == 32;
    }

    /* renamed from: o */
    public String m5419o() {
        Object obj = this.f3018i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3018i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: B */
    private ByteString m5384B() {
        Object obj = this.f3018i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3018i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    public boolean m5420p() {
        return (this.f3011b & 64) == 64;
    }

    /* renamed from: q */
    public long m5421q() {
        return this.f3019j;
    }

    /* renamed from: r */
    public List<C0950fw> m5422r() {
        return this.f3020k;
    }

    /* renamed from: s */
    public boolean m5423s() {
        return (this.f3011b & 128) == 128;
    }

    /* renamed from: t */
    public String m5424t() {
        Object obj = this.f3021l;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3021l = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: C */
    private ByteString m5385C() {
        Object obj = this.f3021l;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3021l = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: u */
    public boolean m5425u() {
        return (this.f3011b & 256) == 256;
    }

    /* renamed from: v */
    public long m5426v() {
        return this.f3022m;
    }

    /* renamed from: D */
    private void m5386D() {
        this.f3012c = 0L;
        this.f3013d = EnumC0822bc.SINGLE;
        this.f3014e = "";
        this.f3015f = "";
        this.f3016g = LazyStringArrayList.EMPTY;
        this.f3017h = "";
        this.f3018i = "";
        this.f3019j = 0L;
        this.f3020k = Collections.emptyList();
        this.f3021l = "";
        this.f3022m = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3023n;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3023n = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f3011b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f3012c);
        }
        if ((this.f3011b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f3013d.getNumber());
        }
        if ((this.f3011b & 4) == 4) {
            codedOutputStream.writeBytes(3, m5404y());
        }
        if ((this.f3011b & 8) == 8) {
            codedOutputStream.writeBytes(4, m5405z());
        }
        for (int i = 0; i < this.f3016g.size(); i++) {
            codedOutputStream.writeBytes(5, this.f3016g.getByteString(i));
        }
        if ((this.f3011b & 16) == 16) {
            codedOutputStream.writeBytes(6, m5383A());
        }
        if ((this.f3011b & 32) == 32) {
            codedOutputStream.writeBytes(7, m5384B());
        }
        if ((this.f3011b & 64) == 64) {
            codedOutputStream.writeInt64(8, this.f3019j);
        }
        for (int i2 = 0; i2 < this.f3020k.size(); i2++) {
            codedOutputStream.writeMessage(9, this.f3020k.get(i2));
        }
        if ((this.f3011b & 128) == 128) {
            codedOutputStream.writeBytes(10, m5385C());
        }
        if ((this.f3011b & 256) == 256) {
            codedOutputStream.writeInt64(11, this.f3022m);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeInt64Size = this.f3024o;
        if (iComputeInt64Size == -1) {
            int iComputeInt64Size2 = (this.f3011b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f3012c) + 0 : 0;
            if ((this.f3011b & 2) == 2) {
                iComputeInt64Size2 += CodedOutputStream.computeEnumSize(2, this.f3013d.getNumber());
            }
            if ((this.f3011b & 4) == 4) {
                iComputeInt64Size2 += CodedOutputStream.computeBytesSize(3, m5404y());
            }
            if ((this.f3011b & 8) == 8) {
                iComputeInt64Size2 += CodedOutputStream.computeBytesSize(4, m5405z());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f3016g.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f3016g.getByteString(i2));
            }
            int size = iComputeInt64Size2 + iComputeBytesSizeNoTag + (m5415k().size() * 1);
            if ((this.f3011b & 16) == 16) {
                size += CodedOutputStream.computeBytesSize(6, m5383A());
            }
            if ((this.f3011b & 32) == 32) {
                size += CodedOutputStream.computeBytesSize(7, m5384B());
            }
            if ((this.f3011b & 64) == 64) {
                size += CodedOutputStream.computeInt64Size(8, this.f3019j);
            }
            while (true) {
                iComputeInt64Size = size;
                if (i >= this.f3020k.size()) {
                    break;
                }
                size = CodedOutputStream.computeMessageSize(9, this.f3020k.get(i)) + iComputeInt64Size;
                i++;
            }
            if ((this.f3011b & 128) == 128) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(10, m5385C());
            }
            if ((this.f3011b & 256) == 256) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(11, this.f3022m);
            }
            this.f3024o = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0947ft m5392a(byte[] bArr) {
        return ((C0948fu) newBuilder().mergeFrom(bArr)).m5433i();
    }

    public static C0948fu newBuilder() {
        return C0948fu.m5432h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public C0948fu newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0948fu m5393a(C0947ft c0947ft) {
        return newBuilder().mergeFrom(c0947ft);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public C0948fu toBuilder() {
        return m5393a(this);
    }

    static {
        f3010a.m5386D();
    }
}
