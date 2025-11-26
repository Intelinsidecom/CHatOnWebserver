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
/* renamed from: com.sec.chaton.a.az */
/* loaded from: classes.dex */
public final class C0818az extends GeneratedMessageLite implements InterfaceC0821bb {

    /* renamed from: a */
    private static final C0818az f2311a = new C0818az(true);

    /* renamed from: b */
    private int f2312b;

    /* renamed from: c */
    private long f2313c;

    /* renamed from: d */
    private EnumC0908eh f2314d;

    /* renamed from: e */
    private EnumC0822bc f2315e;

    /* renamed from: f */
    private Object f2316f;

    /* renamed from: g */
    private Object f2317g;

    /* renamed from: h */
    private LazyStringList f2318h;

    /* renamed from: i */
    private Object f2319i;

    /* renamed from: j */
    private Object f2320j;

    /* renamed from: k */
    private Object f2321k;

    /* renamed from: l */
    private Object f2322l;

    /* renamed from: m */
    private long f2323m;

    /* renamed from: n */
    private boolean f2324n;

    /* renamed from: o */
    private Object f2325o;

    /* renamed from: p */
    private Object f2326p;

    /* renamed from: q */
    private long f2327q;

    /* renamed from: r */
    private Object f2328r;

    /* renamed from: s */
    private byte f2329s;

    /* renamed from: t */
    private int f2330t;

    private C0818az(C0820ba c0820ba) {
        super(c0820ba);
        this.f2329s = (byte) -1;
        this.f2330t = -1;
    }

    private C0818az(boolean z) {
        this.f2329s = (byte) -1;
        this.f2330t = -1;
    }

    /* renamed from: a */
    public static C0818az m3495a() {
        return f2311a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0818az getDefaultInstanceForType() {
        return f2311a;
    }

    /* renamed from: c */
    public boolean m3523c() {
        return (this.f2312b & 1) == 1;
    }

    /* renamed from: d */
    public long m3524d() {
        return this.f2313c;
    }

    /* renamed from: e */
    public boolean m3525e() {
        return (this.f2312b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0908eh m3526f() {
        return this.f2314d;
    }

    /* renamed from: g */
    public boolean m3527g() {
        return (this.f2312b & 4) == 4;
    }

    /* renamed from: h */
    public EnumC0822bc m3528h() {
        return this.f2315e;
    }

    /* renamed from: i */
    public boolean m3529i() {
        return (this.f2312b & 8) == 8;
    }

    /* renamed from: j */
    public String m3530j() {
        Object obj = this.f2316f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2316f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: J */
    private ByteString m3482J() {
        Object obj = this.f2316f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2316f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m3531k() {
        return (this.f2312b & 16) == 16;
    }

    /* renamed from: l */
    public String m3532l() {
        Object obj = this.f2317g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2317g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: K */
    private ByteString m3483K() {
        Object obj = this.f2317g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2317g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public List<String> m3533m() {
        return this.f2318h;
    }

    /* renamed from: n */
    public boolean m3534n() {
        return (this.f2312b & 32) == 32;
    }

    /* renamed from: o */
    public String m3535o() {
        Object obj = this.f2319i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2319i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: L */
    private ByteString m3484L() {
        Object obj = this.f2319i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2319i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: p */
    public boolean m3536p() {
        return (this.f2312b & 64) == 64;
    }

    /* renamed from: q */
    public String m3537q() {
        Object obj = this.f2320j;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2320j = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: M */
    private ByteString m3485M() {
        Object obj = this.f2320j;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2320j = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: r */
    public boolean m3538r() {
        return (this.f2312b & 128) == 128;
    }

    /* renamed from: s */
    public String m3539s() {
        Object obj = this.f2321k;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2321k = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: N */
    private ByteString m3486N() {
        Object obj = this.f2321k;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2321k = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: t */
    public boolean m3540t() {
        return (this.f2312b & 256) == 256;
    }

    /* renamed from: u */
    public String m3541u() {
        Object obj = this.f2322l;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2322l = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: O */
    private ByteString m3487O() {
        Object obj = this.f2322l;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2322l = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: v */
    public boolean m3542v() {
        return (this.f2312b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512;
    }

    /* renamed from: w */
    public long m3543w() {
        return this.f2323m;
    }

    /* renamed from: x */
    public boolean m3544x() {
        return (this.f2312b & 1024) == 1024;
    }

    /* renamed from: y */
    public boolean m3545y() {
        return this.f2324n;
    }

    /* renamed from: z */
    public boolean m3546z() {
        return (this.f2312b & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048;
    }

    /* renamed from: A */
    public String m3513A() {
        Object obj = this.f2325o;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2325o = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: P */
    private ByteString m3488P() {
        Object obj = this.f2325o;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2325o = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: B */
    public boolean m3514B() {
        return (this.f2312b & 4096) == 4096;
    }

    /* renamed from: C */
    public String m3515C() {
        Object obj = this.f2326p;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2326p = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: Q */
    private ByteString m3489Q() {
        Object obj = this.f2326p;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2326p = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: D */
    public boolean m3516D() {
        return (this.f2312b & MotionRecognitionManager.EVENT_FLAT) == 8192;
    }

    /* renamed from: E */
    public long m3517E() {
        return this.f2327q;
    }

    /* renamed from: F */
    public boolean m3518F() {
        return (this.f2312b & MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND) == 16384;
    }

    /* renamed from: G */
    public String m3519G() {
        Object obj = this.f2328r;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2328r = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: R */
    private ByteString m3490R() {
        Object obj = this.f2328r;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2328r = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: S */
    private void m3491S() {
        this.f2313c = 0L;
        this.f2314d = EnumC0908eh.TEXT;
        this.f2315e = EnumC0822bc.SINGLE;
        this.f2316f = "";
        this.f2317g = "";
        this.f2318h = LazyStringArrayList.EMPTY;
        this.f2319i = "";
        this.f2320j = "";
        this.f2321k = "";
        this.f2322l = "";
        this.f2323m = 0L;
        this.f2324n = false;
        this.f2325o = "";
        this.f2326p = "";
        this.f2327q = 0L;
        this.f2328r = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2329s;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2329s = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2312b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2313c);
        }
        if ((this.f2312b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f2314d.getNumber());
        }
        if ((this.f2312b & 4) == 4) {
            codedOutputStream.writeEnum(3, this.f2315e.getNumber());
        }
        if ((this.f2312b & 8) == 8) {
            codedOutputStream.writeBytes(4, m3482J());
        }
        if ((this.f2312b & 16) == 16) {
            codedOutputStream.writeBytes(5, m3483K());
        }
        for (int i = 0; i < this.f2318h.size(); i++) {
            codedOutputStream.writeBytes(6, this.f2318h.getByteString(i));
        }
        if ((this.f2312b & 32) == 32) {
            codedOutputStream.writeBytes(7, m3484L());
        }
        if ((this.f2312b & 64) == 64) {
            codedOutputStream.writeBytes(8, m3485M());
        }
        if ((this.f2312b & 128) == 128) {
            codedOutputStream.writeBytes(9, m3486N());
        }
        if ((this.f2312b & 256) == 256) {
            codedOutputStream.writeBytes(10, m3487O());
        }
        if ((this.f2312b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            codedOutputStream.writeInt64(11, this.f2323m);
        }
        if ((this.f2312b & 1024) == 1024) {
            codedOutputStream.writeBool(12, this.f2324n);
        }
        if ((this.f2312b & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048) {
            codedOutputStream.writeBytes(13, m3488P());
        }
        if ((this.f2312b & 4096) == 4096) {
            codedOutputStream.writeBytes(14, m3489Q());
        }
        if ((this.f2312b & MotionRecognitionManager.EVENT_FLAT) == 8192) {
            codedOutputStream.writeInt64(15, this.f2327q);
        }
        if ((this.f2312b & MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND) == 16384) {
            codedOutputStream.writeBytes(16, m3490R());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f2330t;
        if (size == -1) {
            int iComputeInt64Size = (this.f2312b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f2313c) + 0 : 0;
            if ((this.f2312b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f2314d.getNumber());
            }
            if ((this.f2312b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(3, this.f2315e.getNumber());
            }
            if ((this.f2312b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m3482J());
            }
            if ((this.f2312b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m3483K());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f2318h.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f2318h.getByteString(i));
            }
            size = iComputeInt64Size + iComputeBytesSizeNoTag + (m3533m().size() * 1);
            if ((this.f2312b & 32) == 32) {
                size += CodedOutputStream.computeBytesSize(7, m3484L());
            }
            if ((this.f2312b & 64) == 64) {
                size += CodedOutputStream.computeBytesSize(8, m3485M());
            }
            if ((this.f2312b & 128) == 128) {
                size += CodedOutputStream.computeBytesSize(9, m3486N());
            }
            if ((this.f2312b & 256) == 256) {
                size += CodedOutputStream.computeBytesSize(10, m3487O());
            }
            if ((this.f2312b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
                size += CodedOutputStream.computeInt64Size(11, this.f2323m);
            }
            if ((this.f2312b & 1024) == 1024) {
                size += CodedOutputStream.computeBoolSize(12, this.f2324n);
            }
            if ((this.f2312b & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048) {
                size += CodedOutputStream.computeBytesSize(13, m3488P());
            }
            if ((this.f2312b & 4096) == 4096) {
                size += CodedOutputStream.computeBytesSize(14, m3489Q());
            }
            if ((this.f2312b & MotionRecognitionManager.EVENT_FLAT) == 8192) {
                size += CodedOutputStream.computeInt64Size(15, this.f2327q);
            }
            if ((this.f2312b & MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND) == 16384) {
                size += CodedOutputStream.computeBytesSize(16, m3490R());
            }
            this.f2330t = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0818az m3496a(byte[] bArr) {
        return ((C0820ba) newBuilder().mergeFrom(bArr)).m3551i();
    }

    public static C0820ba newBuilder() {
        return C0820ba.m3550h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public C0820ba newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0820ba m3497a(C0818az c0818az) {
        return newBuilder().mergeFrom(c0818az);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public C0820ba toBuilder() {
        return m3497a(this);
    }

    static {
        f2311a.m3491S();
    }
}
