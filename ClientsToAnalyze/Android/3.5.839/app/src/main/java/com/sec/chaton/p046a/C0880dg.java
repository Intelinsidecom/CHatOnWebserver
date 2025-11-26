package com.sec.chaton.p046a;

import android.hardware.motion.MotionRecognitionManager;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dg */
/* loaded from: classes.dex */
public final class C0880dg extends GeneratedMessageLite implements InterfaceC0882di {

    /* renamed from: a */
    private static final C0880dg f2673a = new C0880dg(true);

    /* renamed from: b */
    private int f2674b;

    /* renamed from: c */
    private long f2675c;

    /* renamed from: d */
    private EnumC0908eh f2676d;

    /* renamed from: e */
    private Object f2677e;

    /* renamed from: f */
    private Object f2678f;

    /* renamed from: g */
    private LazyStringList f2679g;

    /* renamed from: h */
    private LazyStringList f2680h;

    /* renamed from: i */
    private long f2681i;

    /* renamed from: j */
    private Object f2682j;

    /* renamed from: k */
    private long f2683k;

    /* renamed from: l */
    private boolean f2684l;

    /* renamed from: m */
    private Object f2685m;

    /* renamed from: n */
    private int f2686n;

    /* renamed from: o */
    private EnumC0822bc f2687o;

    /* renamed from: p */
    private byte f2688p;

    /* renamed from: q */
    private int f2689q;

    private C0880dg(C0881dh c0881dh) {
        super(c0881dh);
        this.f2688p = (byte) -1;
        this.f2689q = -1;
    }

    private C0880dg(boolean z) {
        this.f2688p = (byte) -1;
        this.f2689q = -1;
    }

    /* renamed from: a */
    public static C0880dg m4437a() {
        return f2673a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0880dg getDefaultInstanceForType() {
        return f2673a;
    }

    /* renamed from: c */
    public boolean m4455c() {
        return (this.f2674b & 1) == 1;
    }

    /* renamed from: d */
    public long m4456d() {
        return this.f2675c;
    }

    /* renamed from: e */
    public boolean m4457e() {
        return (this.f2674b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0908eh m4458f() {
        return this.f2676d;
    }

    /* renamed from: g */
    public boolean m4459g() {
        return (this.f2674b & 4) == 4;
    }

    /* renamed from: h */
    public String m4460h() {
        Object obj = this.f2677e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2677e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: C */
    private ByteString m4428C() {
        Object obj = this.f2677e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2677e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m4461i() {
        return (this.f2674b & 8) == 8;
    }

    /* renamed from: j */
    public String m4462j() {
        Object obj = this.f2678f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2678f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: D */
    private ByteString m4429D() {
        Object obj = this.f2678f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2678f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public List<String> m4463k() {
        return this.f2679g;
    }

    /* renamed from: l */
    public List<String> m4464l() {
        return this.f2680h;
    }

    /* renamed from: m */
    public boolean m4465m() {
        return (this.f2674b & 16) == 16;
    }

    /* renamed from: n */
    public long m4466n() {
        return this.f2681i;
    }

    /* renamed from: o */
    public boolean m4467o() {
        return (this.f2674b & 32) == 32;
    }

    /* renamed from: p */
    public String m4468p() {
        Object obj = this.f2682j;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2682j = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: E */
    private ByteString m4430E() {
        Object obj = this.f2682j;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2682j = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: q */
    public boolean m4469q() {
        return (this.f2674b & 64) == 64;
    }

    /* renamed from: r */
    public long m4470r() {
        return this.f2683k;
    }

    /* renamed from: s */
    public boolean m4471s() {
        return (this.f2674b & 128) == 128;
    }

    /* renamed from: t */
    public boolean m4472t() {
        return this.f2684l;
    }

    /* renamed from: u */
    public boolean m4473u() {
        return (this.f2674b & 256) == 256;
    }

    /* renamed from: v */
    public String m4474v() {
        Object obj = this.f2685m;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2685m = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: F */
    private ByteString m4431F() {
        Object obj = this.f2685m;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2685m = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: w */
    public boolean m4475w() {
        return (this.f2674b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512;
    }

    /* renamed from: x */
    public int m4476x() {
        return this.f2686n;
    }

    /* renamed from: y */
    public boolean m4477y() {
        return (this.f2674b & 1024) == 1024;
    }

    /* renamed from: z */
    public EnumC0822bc m4478z() {
        return this.f2687o;
    }

    /* renamed from: G */
    private void m4432G() {
        this.f2675c = 0L;
        this.f2676d = EnumC0908eh.TEXT;
        this.f2677e = "";
        this.f2678f = "";
        this.f2679g = LazyStringArrayList.EMPTY;
        this.f2680h = LazyStringArrayList.EMPTY;
        this.f2681i = 0L;
        this.f2682j = "";
        this.f2683k = 0L;
        this.f2684l = false;
        this.f2685m = "";
        this.f2686n = 0;
        this.f2687o = EnumC0822bc.SINGLE;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2688p;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2688p = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2674b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2675c);
        }
        if ((this.f2674b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f2676d.getNumber());
        }
        if ((this.f2674b & 4) == 4) {
            codedOutputStream.writeBytes(3, m4428C());
        }
        if ((this.f2674b & 8) == 8) {
            codedOutputStream.writeBytes(4, m4429D());
        }
        for (int i = 0; i < this.f2679g.size(); i++) {
            codedOutputStream.writeBytes(5, this.f2679g.getByteString(i));
        }
        for (int i2 = 0; i2 < this.f2680h.size(); i2++) {
            codedOutputStream.writeBytes(6, this.f2680h.getByteString(i2));
        }
        if ((this.f2674b & 16) == 16) {
            codedOutputStream.writeInt64(7, this.f2681i);
        }
        if ((this.f2674b & 32) == 32) {
            codedOutputStream.writeBytes(8, m4430E());
        }
        if ((this.f2674b & 64) == 64) {
            codedOutputStream.writeInt64(9, this.f2683k);
        }
        if ((this.f2674b & 128) == 128) {
            codedOutputStream.writeBool(10, this.f2684l);
        }
        if ((this.f2674b & 256) == 256) {
            codedOutputStream.writeBytes(11, m4431F());
        }
        if ((this.f2674b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            codedOutputStream.writeInt32(12, this.f2686n);
        }
        if ((this.f2674b & 1024) == 1024) {
            codedOutputStream.writeEnum(13, this.f2687o.getNumber());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f2689q;
        if (size == -1) {
            int iComputeInt64Size = (this.f2674b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f2675c) + 0 : 0;
            if ((this.f2674b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f2676d.getNumber());
            }
            if ((this.f2674b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m4428C());
            }
            if ((this.f2674b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m4429D());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f2679g.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f2679g.getByteString(i));
            }
            int size2 = (m4463k().size() * 1) + iComputeInt64Size + iComputeBytesSizeNoTag;
            int iComputeBytesSizeNoTag2 = 0;
            for (int i2 = 0; i2 < this.f2680h.size(); i2++) {
                iComputeBytesSizeNoTag2 += CodedOutputStream.computeBytesSizeNoTag(this.f2680h.getByteString(i2));
            }
            size = iComputeBytesSizeNoTag2 + size2 + (m4464l().size() * 1);
            if ((this.f2674b & 16) == 16) {
                size += CodedOutputStream.computeInt64Size(7, this.f2681i);
            }
            if ((this.f2674b & 32) == 32) {
                size += CodedOutputStream.computeBytesSize(8, m4430E());
            }
            if ((this.f2674b & 64) == 64) {
                size += CodedOutputStream.computeInt64Size(9, this.f2683k);
            }
            if ((this.f2674b & 128) == 128) {
                size += CodedOutputStream.computeBoolSize(10, this.f2684l);
            }
            if ((this.f2674b & 256) == 256) {
                size += CodedOutputStream.computeBytesSize(11, m4431F());
            }
            if ((this.f2674b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
                size += CodedOutputStream.computeInt32Size(12, this.f2686n);
            }
            if ((this.f2674b & 1024) == 1024) {
                size += CodedOutputStream.computeEnumSize(13, this.f2687o.getNumber());
            }
            this.f2689q = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0880dg m4438a(byte[] bArr) {
        return ((C0881dh) newBuilder().mergeFrom(bArr)).m4483p();
    }

    public static C0881dh newBuilder() {
        return C0881dh.m4482o();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public C0881dh newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0881dh m4439a(C0880dg c0880dg) {
        return newBuilder().mergeFrom(c0880dg);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public C0881dh toBuilder() {
        return m4439a(this);
    }

    static {
        f2673a.m4432G();
    }
}
