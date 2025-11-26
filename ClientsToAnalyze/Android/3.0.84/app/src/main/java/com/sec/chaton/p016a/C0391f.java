package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.f */
/* loaded from: classes.dex */
public final class C0391f extends GeneratedMessageLite implements InterfaceC0393h {

    /* renamed from: a */
    private static final C0391f f1371a = new C0391f(true);

    /* renamed from: b */
    private int f1372b;

    /* renamed from: c */
    private long f1373c;

    /* renamed from: d */
    private EnumC0302az f1374d;

    /* renamed from: e */
    private Object f1375e;

    /* renamed from: f */
    private Object f1376f;

    /* renamed from: g */
    private Object f1377g;

    /* renamed from: h */
    private Object f1378h;

    /* renamed from: i */
    private Object f1379i;

    /* renamed from: j */
    private int f1380j;

    /* renamed from: k */
    private long f1381k;

    /* renamed from: l */
    private long f1382l;

    /* renamed from: m */
    private byte f1383m;

    /* renamed from: n */
    private int f1384n;

    private C0391f(C0392g c0392g) {
        super(c0392g);
        this.f1383m = (byte) -1;
        this.f1384n = -1;
    }

    private C0391f(boolean z) {
        this.f1383m = (byte) -1;
        this.f1384n = -1;
    }

    /* renamed from: a */
    public static C0391f m2758a() {
        return f1371a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0391f getDefaultInstanceForType() {
        return f1371a;
    }

    /* renamed from: c */
    public boolean m2772c() {
        return (this.f1372b & 1) == 1;
    }

    /* renamed from: d */
    public long m2773d() {
        return this.f1373c;
    }

    /* renamed from: e */
    public boolean m2774e() {
        return (this.f1372b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0302az m2775f() {
        return this.f1374d;
    }

    /* renamed from: g */
    public boolean m2776g() {
        return (this.f1372b & 4) == 4;
    }

    /* renamed from: h */
    public String m2777h() {
        Object obj = this.f1375e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1375e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m2769y() {
        Object obj = this.f1375e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1375e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m2778i() {
        return (this.f1372b & 8) == 8;
    }

    /* renamed from: j */
    public String m2779j() {
        Object obj = this.f1376f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1376f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m2770z() {
        Object obj = this.f1376f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1376f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m2780k() {
        return (this.f1372b & 16) == 16;
    }

    /* renamed from: l */
    public String m2781l() {
        Object obj = this.f1377g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1377g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: A */
    private ByteString m2751A() {
        Object obj = this.f1377g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1377g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m2782m() {
        return (this.f1372b & 32) == 32;
    }

    /* renamed from: n */
    public String m2783n() {
        Object obj = this.f1378h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1378h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: B */
    private ByteString m2752B() {
        Object obj = this.f1378h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1378h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    public boolean m2784o() {
        return (this.f1372b & 64) == 64;
    }

    /* renamed from: p */
    public String m2785p() {
        Object obj = this.f1379i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1379i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: C */
    private ByteString m2753C() {
        Object obj = this.f1379i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1379i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: q */
    public boolean m2786q() {
        return (this.f1372b & 128) == 128;
    }

    /* renamed from: r */
    public int m2787r() {
        return this.f1380j;
    }

    /* renamed from: s */
    public boolean m2788s() {
        return (this.f1372b & 256) == 256;
    }

    /* renamed from: t */
    public long m2789t() {
        return this.f1381k;
    }

    /* renamed from: u */
    public boolean m2790u() {
        return (this.f1372b & 512) == 512;
    }

    /* renamed from: v */
    public long m2791v() {
        return this.f1382l;
    }

    /* renamed from: D */
    private void m2754D() {
        this.f1373c = 0L;
        this.f1374d = EnumC0302az.SINGLE;
        this.f1375e = "";
        this.f1376f = "";
        this.f1377g = "";
        this.f1378h = "";
        this.f1379i = "";
        this.f1380j = 0;
        this.f1381k = 0L;
        this.f1382l = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1383m;
        if (b != -1) {
            return b == 1;
        }
        this.f1383m = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1372b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1373c);
        }
        if ((this.f1372b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f1374d.getNumber());
        }
        if ((this.f1372b & 4) == 4) {
            codedOutputStream.writeBytes(3, m2769y());
        }
        if ((this.f1372b & 8) == 8) {
            codedOutputStream.writeBytes(4, m2770z());
        }
        if ((this.f1372b & 16) == 16) {
            codedOutputStream.writeBytes(5, m2751A());
        }
        if ((this.f1372b & 32) == 32) {
            codedOutputStream.writeBytes(6, m2752B());
        }
        if ((this.f1372b & 64) == 64) {
            codedOutputStream.writeBytes(7, m2753C());
        }
        if ((this.f1372b & 128) == 128) {
            codedOutputStream.writeInt32(8, this.f1380j);
        }
        if ((this.f1372b & 256) == 256) {
            codedOutputStream.writeInt64(9, this.f1381k);
        }
        if ((this.f1372b & 512) == 512) {
            codedOutputStream.writeInt64(10, this.f1382l);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f1384n;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f1372b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f1373c) : 0;
            if ((this.f1372b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f1374d.getNumber());
            }
            if ((this.f1372b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m2769y());
            }
            if ((this.f1372b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m2770z());
            }
            if ((this.f1372b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m2751A());
            }
            if ((this.f1372b & 32) == 32) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(6, m2752B());
            }
            if ((this.f1372b & 64) == 64) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(7, m2753C());
            }
            if ((this.f1372b & 128) == 128) {
                iComputeInt64Size += CodedOutputStream.computeInt32Size(8, this.f1380j);
            }
            if ((this.f1372b & 256) == 256) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(9, this.f1381k);
            }
            if ((this.f1372b & 512) == 512) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(10, this.f1382l);
            }
            this.f1384n = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0391f m2759a(byte[] bArr) {
        return ((C0392g) newBuilder().mergeFrom(bArr)).m2798i();
    }

    public static C0392g newBuilder() {
        return C0392g.m2797h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public C0392g newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0392g m2760a(C0391f c0391f) {
        return newBuilder().mergeFrom(c0391f);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public C0392g toBuilder() {
        return m2760a(this);
    }

    static {
        f1371a.m2754D();
    }
}
