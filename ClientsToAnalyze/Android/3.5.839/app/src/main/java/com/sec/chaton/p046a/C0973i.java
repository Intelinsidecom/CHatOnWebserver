package com.sec.chaton.p046a;

import android.hardware.motion.MotionRecognitionManager;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.i */
/* loaded from: classes.dex */
public final class C0973i extends GeneratedMessageLite implements InterfaceC0975k {

    /* renamed from: a */
    private static final C0973i f3141a = new C0973i(true);

    /* renamed from: b */
    private int f3142b;

    /* renamed from: c */
    private long f3143c;

    /* renamed from: d */
    private EnumC0822bc f3144d;

    /* renamed from: e */
    private Object f3145e;

    /* renamed from: f */
    private Object f3146f;

    /* renamed from: g */
    private Object f3147g;

    /* renamed from: h */
    private Object f3148h;

    /* renamed from: i */
    private Object f3149i;

    /* renamed from: j */
    private int f3150j;

    /* renamed from: k */
    private long f3151k;

    /* renamed from: l */
    private long f3152l;

    /* renamed from: m */
    private boolean f3153m;

    /* renamed from: n */
    private long f3154n;

    /* renamed from: o */
    private boolean f3155o;

    /* renamed from: p */
    private boolean f3156p;

    /* renamed from: q */
    private byte f3157q;

    /* renamed from: r */
    private int f3158r;

    private C0973i(C0974j c0974j) {
        super(c0974j);
        this.f3157q = (byte) -1;
        this.f3158r = -1;
    }

    private C0973i(boolean z) {
        this.f3157q = (byte) -1;
        this.f3158r = -1;
    }

    /* renamed from: a */
    public static C0973i m5748a() {
        return f3141a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0973i getDefaultInstanceForType() {
        return f3141a;
    }

    /* renamed from: c */
    public boolean m5770c() {
        return (this.f3142b & 1) == 1;
    }

    /* renamed from: d */
    public long m5771d() {
        return this.f3143c;
    }

    /* renamed from: e */
    public boolean m5772e() {
        return (this.f3142b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0822bc m5773f() {
        return this.f3144d;
    }

    /* renamed from: g */
    public boolean m5774g() {
        return (this.f3142b & 4) == 4;
    }

    /* renamed from: h */
    public String m5775h() {
        Object obj = this.f3145e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3145e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: G */
    private ByteString m5739G() {
        Object obj = this.f3145e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3145e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m5776i() {
        return (this.f3142b & 8) == 8;
    }

    /* renamed from: j */
    public String m5777j() {
        Object obj = this.f3146f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3146f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: H */
    private ByteString m5740H() {
        Object obj = this.f3146f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3146f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m5778k() {
        return (this.f3142b & 16) == 16;
    }

    /* renamed from: l */
    public String m5779l() {
        Object obj = this.f3147g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3147g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: I */
    private ByteString m5741I() {
        Object obj = this.f3147g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3147g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m5780m() {
        return (this.f3142b & 32) == 32;
    }

    /* renamed from: n */
    public String m5781n() {
        Object obj = this.f3148h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3148h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: J */
    private ByteString m5742J() {
        Object obj = this.f3148h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3148h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    public boolean m5782o() {
        return (this.f3142b & 64) == 64;
    }

    /* renamed from: p */
    public String m5783p() {
        Object obj = this.f3149i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3149i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: K */
    private ByteString m5743K() {
        Object obj = this.f3149i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3149i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: q */
    public boolean m5784q() {
        return (this.f3142b & 128) == 128;
    }

    /* renamed from: r */
    public int m5785r() {
        return this.f3150j;
    }

    /* renamed from: s */
    public boolean m5786s() {
        return (this.f3142b & 256) == 256;
    }

    /* renamed from: t */
    public long m5787t() {
        return this.f3151k;
    }

    /* renamed from: u */
    public boolean m5788u() {
        return (this.f3142b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512;
    }

    /* renamed from: v */
    public long m5789v() {
        return this.f3152l;
    }

    /* renamed from: w */
    public boolean m5790w() {
        return (this.f3142b & 1024) == 1024;
    }

    /* renamed from: x */
    public boolean m5791x() {
        return this.f3153m;
    }

    /* renamed from: y */
    public boolean m5792y() {
        return (this.f3142b & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048;
    }

    /* renamed from: z */
    public long m5793z() {
        return this.f3154n;
    }

    /* renamed from: A */
    public boolean m5763A() {
        return (this.f3142b & 4096) == 4096;
    }

    /* renamed from: B */
    public boolean m5764B() {
        return this.f3155o;
    }

    /* renamed from: C */
    public boolean m5765C() {
        return (this.f3142b & MotionRecognitionManager.EVENT_FLAT) == 8192;
    }

    /* renamed from: D */
    public boolean m5766D() {
        return this.f3156p;
    }

    /* renamed from: L */
    private void m5744L() {
        this.f3143c = 0L;
        this.f3144d = EnumC0822bc.SINGLE;
        this.f3145e = "";
        this.f3146f = "";
        this.f3147g = "";
        this.f3148h = "";
        this.f3149i = "";
        this.f3150j = 0;
        this.f3151k = 0L;
        this.f3152l = 0L;
        this.f3153m = false;
        this.f3154n = 0L;
        this.f3155o = false;
        this.f3156p = false;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3157q;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3157q = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f3142b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f3143c);
        }
        if ((this.f3142b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f3144d.getNumber());
        }
        if ((this.f3142b & 4) == 4) {
            codedOutputStream.writeBytes(3, m5739G());
        }
        if ((this.f3142b & 8) == 8) {
            codedOutputStream.writeBytes(4, m5740H());
        }
        if ((this.f3142b & 16) == 16) {
            codedOutputStream.writeBytes(5, m5741I());
        }
        if ((this.f3142b & 32) == 32) {
            codedOutputStream.writeBytes(6, m5742J());
        }
        if ((this.f3142b & 64) == 64) {
            codedOutputStream.writeBytes(7, m5743K());
        }
        if ((this.f3142b & 128) == 128) {
            codedOutputStream.writeInt32(8, this.f3150j);
        }
        if ((this.f3142b & 256) == 256) {
            codedOutputStream.writeInt64(9, this.f3151k);
        }
        if ((this.f3142b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            codedOutputStream.writeInt64(10, this.f3152l);
        }
        if ((this.f3142b & 1024) == 1024) {
            codedOutputStream.writeBool(11, this.f3153m);
        }
        if ((this.f3142b & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048) {
            codedOutputStream.writeInt64(12, this.f3154n);
        }
        if ((this.f3142b & 4096) == 4096) {
            codedOutputStream.writeBool(13, this.f3155o);
        }
        if ((this.f3142b & MotionRecognitionManager.EVENT_FLAT) == 8192) {
            codedOutputStream.writeBool(14, this.f3156p);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f3158r;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f3142b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3143c) : 0;
            if ((this.f3142b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f3144d.getNumber());
            }
            if ((this.f3142b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m5739G());
            }
            if ((this.f3142b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m5740H());
            }
            if ((this.f3142b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m5741I());
            }
            if ((this.f3142b & 32) == 32) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(6, m5742J());
            }
            if ((this.f3142b & 64) == 64) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(7, m5743K());
            }
            if ((this.f3142b & 128) == 128) {
                iComputeInt64Size += CodedOutputStream.computeInt32Size(8, this.f3150j);
            }
            if ((this.f3142b & 256) == 256) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(9, this.f3151k);
            }
            if ((this.f3142b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(10, this.f3152l);
            }
            if ((this.f3142b & 1024) == 1024) {
                iComputeInt64Size += CodedOutputStream.computeBoolSize(11, this.f3153m);
            }
            if ((this.f3142b & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(12, this.f3154n);
            }
            if ((this.f3142b & 4096) == 4096) {
                iComputeInt64Size += CodedOutputStream.computeBoolSize(13, this.f3155o);
            }
            if ((this.f3142b & MotionRecognitionManager.EVENT_FLAT) == 8192) {
                iComputeInt64Size += CodedOutputStream.computeBoolSize(14, this.f3156p);
            }
            this.f3158r = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0973i m5749a(byte[] bArr) {
        return ((C0974j) newBuilder().mergeFrom(bArr)).m5798i();
    }

    public static C0974j newBuilder() {
        return C0974j.m5797h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public C0974j newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0974j m5750a(C0973i c0973i) {
        return newBuilder().mergeFrom(c0973i);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public C0974j toBuilder() {
        return m5750a(this);
    }

    static {
        f3141a.m5744L();
    }
}
