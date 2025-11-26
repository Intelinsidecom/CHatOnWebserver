package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ap */
/* loaded from: classes.dex */
public final class C0808ap extends GeneratedMessageLite implements InterfaceC0810ar {

    /* renamed from: a */
    private static final C0808ap f2248a = new C0808ap(true);

    /* renamed from: b */
    private int f2249b;

    /* renamed from: c */
    private long f2250c;

    /* renamed from: d */
    private EnumC0822bc f2251d;

    /* renamed from: e */
    private Object f2252e;

    /* renamed from: f */
    private Object f2253f;

    /* renamed from: g */
    private LazyStringList f2254g;

    /* renamed from: h */
    private EnumC0811as f2255h;

    /* renamed from: i */
    private LazyStringList f2256i;

    /* renamed from: j */
    private long f2257j;

    /* renamed from: k */
    private Object f2258k;

    /* renamed from: l */
    private long f2259l;

    /* renamed from: m */
    private boolean f2260m;

    /* renamed from: n */
    private byte f2261n;

    /* renamed from: o */
    private int f2262o;

    private C0808ap(C0809aq c0809aq) {
        super(c0809aq);
        this.f2261n = (byte) -1;
        this.f2262o = -1;
    }

    private C0808ap(boolean z) {
        this.f2261n = (byte) -1;
        this.f2262o = -1;
    }

    /* renamed from: a */
    public static C0808ap m3352a() {
        return f2248a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0808ap getDefaultInstanceForType() {
        return f2248a;
    }

    /* renamed from: c */
    public boolean m3369c() {
        return (this.f2249b & 1) == 1;
    }

    /* renamed from: d */
    public long m3370d() {
        return this.f2250c;
    }

    /* renamed from: e */
    public boolean m3371e() {
        return (this.f2249b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0822bc m3372f() {
        return this.f2251d;
    }

    /* renamed from: g */
    public boolean m3373g() {
        return (this.f2249b & 4) == 4;
    }

    /* renamed from: h */
    public String m3374h() {
        Object obj = this.f2252e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2252e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m3366y() {
        Object obj = this.f2252e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2252e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m3375i() {
        return (this.f2249b & 8) == 8;
    }

    /* renamed from: j */
    public String m3376j() {
        Object obj = this.f2253f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2253f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m3367z() {
        Object obj = this.f2253f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2253f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public List<String> m3377k() {
        return this.f2254g;
    }

    /* renamed from: l */
    public boolean m3378l() {
        return (this.f2249b & 16) == 16;
    }

    /* renamed from: m */
    public EnumC0811as m3379m() {
        return this.f2255h;
    }

    /* renamed from: n */
    public List<String> m3380n() {
        return this.f2256i;
    }

    /* renamed from: o */
    public boolean m3381o() {
        return (this.f2249b & 32) == 32;
    }

    /* renamed from: p */
    public long m3382p() {
        return this.f2257j;
    }

    /* renamed from: q */
    public boolean m3383q() {
        return (this.f2249b & 64) == 64;
    }

    /* renamed from: r */
    public String m3384r() {
        Object obj = this.f2258k;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2258k = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: A */
    private ByteString m3347A() {
        Object obj = this.f2258k;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2258k = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: s */
    public boolean m3385s() {
        return (this.f2249b & 128) == 128;
    }

    /* renamed from: t */
    public long m3386t() {
        return this.f2259l;
    }

    /* renamed from: u */
    public boolean m3387u() {
        return (this.f2249b & 256) == 256;
    }

    /* renamed from: v */
    public boolean m3388v() {
        return this.f2260m;
    }

    /* renamed from: B */
    private void m3348B() {
        this.f2250c = 0L;
        this.f2251d = EnumC0822bc.SINGLE;
        this.f2252e = "";
        this.f2253f = "";
        this.f2254g = LazyStringArrayList.EMPTY;
        this.f2255h = EnumC0811as.ADD;
        this.f2256i = LazyStringArrayList.EMPTY;
        this.f2257j = 0L;
        this.f2258k = "";
        this.f2259l = 0L;
        this.f2260m = false;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2261n;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2261n = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2249b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2250c);
        }
        if ((this.f2249b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f2251d.getNumber());
        }
        if ((this.f2249b & 4) == 4) {
            codedOutputStream.writeBytes(3, m3366y());
        }
        if ((this.f2249b & 8) == 8) {
            codedOutputStream.writeBytes(4, m3367z());
        }
        for (int i = 0; i < this.f2254g.size(); i++) {
            codedOutputStream.writeBytes(5, this.f2254g.getByteString(i));
        }
        if ((this.f2249b & 16) == 16) {
            codedOutputStream.writeEnum(6, this.f2255h.getNumber());
        }
        for (int i2 = 0; i2 < this.f2256i.size(); i2++) {
            codedOutputStream.writeBytes(7, this.f2256i.getByteString(i2));
        }
        if ((this.f2249b & 32) == 32) {
            codedOutputStream.writeInt64(8, this.f2257j);
        }
        if ((this.f2249b & 64) == 64) {
            codedOutputStream.writeBytes(9, m3347A());
        }
        if ((this.f2249b & 128) == 128) {
            codedOutputStream.writeInt64(10, this.f2259l);
        }
        if ((this.f2249b & 256) == 256) {
            codedOutputStream.writeBool(11, this.f2260m);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f2262o;
        if (size == -1) {
            int iComputeInt64Size = (this.f2249b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f2250c) + 0 : 0;
            if ((this.f2249b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f2251d.getNumber());
            }
            if ((this.f2249b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m3366y());
            }
            if ((this.f2249b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m3367z());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f2254g.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f2254g.getByteString(i));
            }
            int size2 = iComputeInt64Size + iComputeBytesSizeNoTag + (m3377k().size() * 1);
            if ((this.f2249b & 16) == 16) {
                size2 += CodedOutputStream.computeEnumSize(6, this.f2255h.getNumber());
            }
            int iComputeBytesSizeNoTag2 = 0;
            for (int i2 = 0; i2 < this.f2256i.size(); i2++) {
                iComputeBytesSizeNoTag2 += CodedOutputStream.computeBytesSizeNoTag(this.f2256i.getByteString(i2));
            }
            size = size2 + iComputeBytesSizeNoTag2 + (m3380n().size() * 1);
            if ((this.f2249b & 32) == 32) {
                size += CodedOutputStream.computeInt64Size(8, this.f2257j);
            }
            if ((this.f2249b & 64) == 64) {
                size += CodedOutputStream.computeBytesSize(9, m3347A());
            }
            if ((this.f2249b & 128) == 128) {
                size += CodedOutputStream.computeInt64Size(10, this.f2259l);
            }
            if ((this.f2249b & 256) == 256) {
                size += CodedOutputStream.computeBoolSize(11, this.f2260m);
            }
            this.f2262o = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0808ap m3353a(byte[] bArr) {
        return ((C0809aq) newBuilder().mergeFrom(bArr)).m3395s();
    }

    public static C0809aq newBuilder() {
        return C0809aq.m3394r();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public C0809aq newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0809aq m3354a(C0808ap c0808ap) {
        return newBuilder().mergeFrom(c0808ap);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public C0809aq toBuilder() {
        return m3354a(this);
    }

    static {
        f2248a.m3348B();
    }
}
