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
/* renamed from: com.sec.chaton.a.da */
/* loaded from: classes.dex */
public final class C0874da extends GeneratedMessageLite implements InterfaceC0876dc {

    /* renamed from: a */
    private static final C0874da f2625a = new C0874da(true);

    /* renamed from: b */
    private int f2626b;

    /* renamed from: c */
    private long f2627c;

    /* renamed from: d */
    private EnumC0908eh f2628d;

    /* renamed from: e */
    private EnumC0822bc f2629e;

    /* renamed from: f */
    private Object f2630f;

    /* renamed from: g */
    private Object f2631g;

    /* renamed from: h */
    private long f2632h;

    /* renamed from: i */
    private Object f2633i;

    /* renamed from: j */
    private LazyStringList f2634j;

    /* renamed from: k */
    private Object f2635k;

    /* renamed from: l */
    private boolean f2636l;

    /* renamed from: m */
    private Object f2637m;

    /* renamed from: n */
    private int f2638n;

    /* renamed from: o */
    private Object f2639o;

    /* renamed from: p */
    private int f2640p;

    /* renamed from: q */
    private Object f2641q;

    /* renamed from: r */
    private byte f2642r;

    /* renamed from: s */
    private int f2643s;

    private C0874da(C0875db c0875db) {
        super(c0875db);
        this.f2642r = (byte) -1;
        this.f2643s = -1;
    }

    private C0874da(boolean z) {
        this.f2642r = (byte) -1;
        this.f2643s = -1;
    }

    /* renamed from: a */
    public static C0874da m4312a() {
        return f2625a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0874da getDefaultInstanceForType() {
        return f2625a;
    }

    /* renamed from: c */
    public boolean m4336c() {
        return (this.f2626b & 1) == 1;
    }

    /* renamed from: d */
    public long m4337d() {
        return this.f2627c;
    }

    /* renamed from: e */
    public boolean m4338e() {
        return (this.f2626b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0908eh m4339f() {
        return this.f2628d;
    }

    /* renamed from: g */
    public boolean m4340g() {
        return (this.f2626b & 4) == 4;
    }

    /* renamed from: h */
    public EnumC0822bc m4341h() {
        return this.f2629e;
    }

    /* renamed from: i */
    public boolean m4342i() {
        return (this.f2626b & 8) == 8;
    }

    /* renamed from: j */
    public String m4343j() {
        Object obj = this.f2630f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2630f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: H */
    private ByteString m4300H() {
        Object obj = this.f2630f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2630f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m4344k() {
        return (this.f2626b & 16) == 16;
    }

    /* renamed from: l */
    public String m4345l() {
        Object obj = this.f2631g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2631g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: I */
    private ByteString m4301I() {
        Object obj = this.f2631g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2631g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m4346m() {
        return (this.f2626b & 32) == 32;
    }

    /* renamed from: n */
    public long m4347n() {
        return this.f2632h;
    }

    /* renamed from: o */
    public boolean m4348o() {
        return (this.f2626b & 64) == 64;
    }

    /* renamed from: p */
    public String m4349p() {
        Object obj = this.f2633i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2633i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: J */
    private ByteString m4302J() {
        Object obj = this.f2633i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2633i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: q */
    public List<String> m4350q() {
        return this.f2634j;
    }

    /* renamed from: r */
    public boolean m4351r() {
        return (this.f2626b & 128) == 128;
    }

    /* renamed from: s */
    public String m4352s() {
        Object obj = this.f2635k;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2635k = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: K */
    private ByteString m4303K() {
        Object obj = this.f2635k;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2635k = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: t */
    public boolean m4353t() {
        return (this.f2626b & 256) == 256;
    }

    /* renamed from: u */
    public boolean m4354u() {
        return this.f2636l;
    }

    /* renamed from: v */
    public boolean m4355v() {
        return (this.f2626b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512;
    }

    /* renamed from: w */
    public String m4356w() {
        Object obj = this.f2637m;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2637m = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: L */
    private ByteString m4304L() {
        Object obj = this.f2637m;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2637m = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: x */
    public boolean m4357x() {
        return (this.f2626b & 1024) == 1024;
    }

    /* renamed from: y */
    public int m4358y() {
        return this.f2638n;
    }

    /* renamed from: z */
    public boolean m4359z() {
        return (this.f2626b & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048;
    }

    /* renamed from: A */
    public String m4328A() {
        Object obj = this.f2639o;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2639o = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: M */
    private ByteString m4305M() {
        Object obj = this.f2639o;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2639o = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: B */
    public boolean m4329B() {
        return (this.f2626b & 4096) == 4096;
    }

    /* renamed from: C */
    public int m4330C() {
        return this.f2640p;
    }

    /* renamed from: D */
    public boolean m4331D() {
        return (this.f2626b & MotionRecognitionManager.EVENT_FLAT) == 8192;
    }

    /* renamed from: E */
    public String m4332E() {
        Object obj = this.f2641q;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2641q = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: N */
    private ByteString m4306N() {
        Object obj = this.f2641q;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2641q = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: O */
    private void m4307O() {
        this.f2627c = 0L;
        this.f2628d = EnumC0908eh.TEXT;
        this.f2629e = EnumC0822bc.SINGLE;
        this.f2630f = "";
        this.f2631g = "";
        this.f2632h = 0L;
        this.f2633i = "";
        this.f2634j = LazyStringArrayList.EMPTY;
        this.f2635k = "";
        this.f2636l = false;
        this.f2637m = "";
        this.f2638n = 0;
        this.f2639o = "";
        this.f2640p = 0;
        this.f2641q = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2642r;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2642r = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2626b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2627c);
        }
        if ((this.f2626b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f2628d.getNumber());
        }
        if ((this.f2626b & 4) == 4) {
            codedOutputStream.writeEnum(3, this.f2629e.getNumber());
        }
        if ((this.f2626b & 8) == 8) {
            codedOutputStream.writeBytes(4, m4300H());
        }
        if ((this.f2626b & 16) == 16) {
            codedOutputStream.writeBytes(5, m4301I());
        }
        if ((this.f2626b & 32) == 32) {
            codedOutputStream.writeInt64(6, this.f2632h);
        }
        if ((this.f2626b & 64) == 64) {
            codedOutputStream.writeBytes(7, m4302J());
        }
        for (int i = 0; i < this.f2634j.size(); i++) {
            codedOutputStream.writeBytes(8, this.f2634j.getByteString(i));
        }
        if ((this.f2626b & 128) == 128) {
            codedOutputStream.writeBytes(9, m4303K());
        }
        if ((this.f2626b & 256) == 256) {
            codedOutputStream.writeBool(10, this.f2636l);
        }
        if ((this.f2626b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            codedOutputStream.writeBytes(11, m4304L());
        }
        if ((this.f2626b & 1024) == 1024) {
            codedOutputStream.writeInt32(12, this.f2638n);
        }
        if ((this.f2626b & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048) {
            codedOutputStream.writeBytes(13, m4305M());
        }
        if ((this.f2626b & 4096) == 4096) {
            codedOutputStream.writeInt32(14, this.f2640p);
        }
        if ((this.f2626b & MotionRecognitionManager.EVENT_FLAT) == 8192) {
            codedOutputStream.writeBytes(15, m4306N());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f2643s;
        if (size == -1) {
            int iComputeInt64Size = (this.f2626b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f2627c) + 0 : 0;
            if ((this.f2626b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f2628d.getNumber());
            }
            if ((this.f2626b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(3, this.f2629e.getNumber());
            }
            if ((this.f2626b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m4300H());
            }
            if ((this.f2626b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m4301I());
            }
            if ((this.f2626b & 32) == 32) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(6, this.f2632h);
            }
            if ((this.f2626b & 64) == 64) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(7, m4302J());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f2634j.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f2634j.getByteString(i));
            }
            size = iComputeInt64Size + iComputeBytesSizeNoTag + (m4350q().size() * 1);
            if ((this.f2626b & 128) == 128) {
                size += CodedOutputStream.computeBytesSize(9, m4303K());
            }
            if ((this.f2626b & 256) == 256) {
                size += CodedOutputStream.computeBoolSize(10, this.f2636l);
            }
            if ((this.f2626b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
                size += CodedOutputStream.computeBytesSize(11, m4304L());
            }
            if ((this.f2626b & 1024) == 1024) {
                size += CodedOutputStream.computeInt32Size(12, this.f2638n);
            }
            if ((this.f2626b & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048) {
                size += CodedOutputStream.computeBytesSize(13, m4305M());
            }
            if ((this.f2626b & 4096) == 4096) {
                size += CodedOutputStream.computeInt32Size(14, this.f2640p);
            }
            if ((this.f2626b & MotionRecognitionManager.EVENT_FLAT) == 8192) {
                size += CodedOutputStream.computeBytesSize(15, m4306N());
            }
            this.f2643s = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0874da m4313a(byte[] bArr) {
        return ((C0875db) newBuilder().mergeFrom(bArr)).m4364i();
    }

    public static C0875db newBuilder() {
        return C0875db.m4363h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public C0875db newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0875db m4314a(C0874da c0874da) {
        return newBuilder().mergeFrom(c0874da);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public C0875db toBuilder() {
        return m4314a(this);
    }

    static {
        f2625a.m4307O();
    }
}
