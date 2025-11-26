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
/* renamed from: com.sec.chaton.a.dy */
/* loaded from: classes.dex */
public final class C0898dy extends GeneratedMessageLite implements InterfaceC0901ea {

    /* renamed from: a */
    private static final C0898dy f2775a = new C0898dy(true);

    /* renamed from: b */
    private int f2776b;

    /* renamed from: c */
    private long f2777c;

    /* renamed from: d */
    private Object f2778d;

    /* renamed from: e */
    private Object f2779e;

    /* renamed from: f */
    private Object f2780f;

    /* renamed from: g */
    private EnumC0822bc f2781g;

    /* renamed from: h */
    private Object f2782h;

    /* renamed from: i */
    private Object f2783i;

    /* renamed from: j */
    private long f2784j;

    /* renamed from: k */
    private long f2785k;

    /* renamed from: l */
    private Object f2786l;

    /* renamed from: m */
    private long f2787m;

    /* renamed from: n */
    private Object f2788n;

    /* renamed from: o */
    private long f2789o;

    /* renamed from: p */
    private LazyStringList f2790p;

    /* renamed from: q */
    private byte f2791q;

    /* renamed from: r */
    private int f2792r;

    private C0898dy(C0899dz c0899dz) {
        super(c0899dz);
        this.f2791q = (byte) -1;
        this.f2792r = -1;
    }

    private C0898dy(boolean z) {
        this.f2791q = (byte) -1;
        this.f2792r = -1;
    }

    /* renamed from: a */
    public static C0898dy m4737a() {
        return f2775a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0898dy getDefaultInstanceForType() {
        return f2775a;
    }

    /* renamed from: c */
    public boolean m4758c() {
        return (this.f2776b & 1) == 1;
    }

    /* renamed from: d */
    public long m4759d() {
        return this.f2777c;
    }

    /* renamed from: e */
    public boolean m4760e() {
        return (this.f2776b & 2) == 2;
    }

    /* renamed from: f */
    public String m4761f() {
        Object obj = this.f2778d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2778d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: F */
    private ByteString m4725F() {
        Object obj = this.f2778d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2778d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m4762g() {
        return (this.f2776b & 4) == 4;
    }

    /* renamed from: h */
    public String m4763h() {
        Object obj = this.f2779e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2779e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: G */
    private ByteString m4726G() {
        Object obj = this.f2779e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2779e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m4764i() {
        return (this.f2776b & 8) == 8;
    }

    /* renamed from: j */
    public String m4765j() {
        Object obj = this.f2780f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2780f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: H */
    private ByteString m4727H() {
        Object obj = this.f2780f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2780f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m4766k() {
        return (this.f2776b & 16) == 16;
    }

    /* renamed from: l */
    public EnumC0822bc m4767l() {
        return this.f2781g;
    }

    /* renamed from: m */
    public boolean m4768m() {
        return (this.f2776b & 32) == 32;
    }

    /* renamed from: n */
    public String m4769n() {
        Object obj = this.f2782h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2782h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: I */
    private ByteString m4728I() {
        Object obj = this.f2782h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2782h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    public boolean m4770o() {
        return (this.f2776b & 64) == 64;
    }

    /* renamed from: p */
    public String m4771p() {
        Object obj = this.f2783i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2783i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: J */
    private ByteString m4729J() {
        Object obj = this.f2783i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2783i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: q */
    public boolean m4772q() {
        return (this.f2776b & 128) == 128;
    }

    /* renamed from: r */
    public long m4773r() {
        return this.f2784j;
    }

    /* renamed from: s */
    public boolean m4774s() {
        return (this.f2776b & 256) == 256;
    }

    /* renamed from: t */
    public long m4775t() {
        return this.f2785k;
    }

    /* renamed from: u */
    public boolean m4776u() {
        return (this.f2776b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512;
    }

    /* renamed from: v */
    public String m4777v() {
        Object obj = this.f2786l;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2786l = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: K */
    private ByteString m4730K() {
        Object obj = this.f2786l;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2786l = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: w */
    public boolean m4778w() {
        return (this.f2776b & 1024) == 1024;
    }

    /* renamed from: x */
    public long m4779x() {
        return this.f2787m;
    }

    /* renamed from: y */
    public boolean m4780y() {
        return (this.f2776b & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048;
    }

    /* renamed from: z */
    public String m4781z() {
        Object obj = this.f2788n;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2788n = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: L */
    private ByteString m4731L() {
        Object obj = this.f2788n;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2788n = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: A */
    public boolean m4752A() {
        return (this.f2776b & 4096) == 4096;
    }

    /* renamed from: B */
    public long m4753B() {
        return this.f2789o;
    }

    /* renamed from: C */
    public List<String> m4754C() {
        return this.f2790p;
    }

    /* renamed from: M */
    private void m4732M() {
        this.f2777c = 0L;
        this.f2778d = "";
        this.f2779e = "";
        this.f2780f = "";
        this.f2781g = EnumC0822bc.SINGLE;
        this.f2782h = "";
        this.f2783i = "";
        this.f2784j = 0L;
        this.f2785k = 0L;
        this.f2786l = "";
        this.f2787m = 0L;
        this.f2788n = "";
        this.f2789o = 0L;
        this.f2790p = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2791q;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2791q = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2776b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2777c);
        }
        if ((this.f2776b & 2) == 2) {
            codedOutputStream.writeBytes(2, m4725F());
        }
        if ((this.f2776b & 4) == 4) {
            codedOutputStream.writeBytes(3, m4726G());
        }
        if ((this.f2776b & 8) == 8) {
            codedOutputStream.writeBytes(4, m4727H());
        }
        if ((this.f2776b & 16) == 16) {
            codedOutputStream.writeEnum(5, this.f2781g.getNumber());
        }
        if ((this.f2776b & 32) == 32) {
            codedOutputStream.writeBytes(6, m4728I());
        }
        if ((this.f2776b & 64) == 64) {
            codedOutputStream.writeBytes(7, m4729J());
        }
        if ((this.f2776b & 128) == 128) {
            codedOutputStream.writeInt64(8, this.f2784j);
        }
        if ((this.f2776b & 256) == 256) {
            codedOutputStream.writeInt64(9, this.f2785k);
        }
        if ((this.f2776b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            codedOutputStream.writeBytes(10, m4730K());
        }
        if ((this.f2776b & 1024) == 1024) {
            codedOutputStream.writeInt64(11, this.f2787m);
        }
        if ((this.f2776b & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048) {
            codedOutputStream.writeBytes(12, m4731L());
        }
        if ((this.f2776b & 4096) == 4096) {
            codedOutputStream.writeInt64(13, this.f2789o);
        }
        for (int i = 0; i < this.f2790p.size(); i++) {
            codedOutputStream.writeBytes(14, this.f2790p.getByteString(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f2792r;
        if (i == -1) {
            int iComputeInt64Size = (this.f2776b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f2777c) + 0 : 0;
            if ((this.f2776b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m4725F());
            }
            if ((this.f2776b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m4726G());
            }
            if ((this.f2776b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m4727H());
            }
            if ((this.f2776b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(5, this.f2781g.getNumber());
            }
            if ((this.f2776b & 32) == 32) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(6, m4728I());
            }
            if ((this.f2776b & 64) == 64) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(7, m4729J());
            }
            if ((this.f2776b & 128) == 128) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(8, this.f2784j);
            }
            if ((this.f2776b & 256) == 256) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(9, this.f2785k);
            }
            if ((this.f2776b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(10, m4730K());
            }
            if ((this.f2776b & 1024) == 1024) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(11, this.f2787m);
            }
            if ((this.f2776b & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(12, m4731L());
            }
            if ((this.f2776b & 4096) == 4096) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(13, this.f2789o);
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f2790p.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f2790p.getByteString(i2));
            }
            int size = iComputeInt64Size + iComputeBytesSizeNoTag + (m4754C().size() * 1);
            this.f2792r = size;
            return size;
        }
        return i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0898dy m4738a(byte[] bArr) {
        return ((C0899dz) newBuilder().mergeFrom(bArr)).m4786i();
    }

    public static C0899dz newBuilder() {
        return C0899dz.m4785h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public C0899dz newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0899dz m4739a(C0898dy c0898dy) {
        return newBuilder().mergeFrom(c0898dy);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public C0899dz toBuilder() {
        return m4739a(this);
    }

    static {
        f2775a.m4732M();
    }
}
