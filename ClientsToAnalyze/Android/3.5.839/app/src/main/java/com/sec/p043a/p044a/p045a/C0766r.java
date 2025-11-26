package com.sec.p043a.p044a.p045a;

import android.hardware.motion.MotionRecognitionManager;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.r */
/* loaded from: classes.dex */
public final class C0766r extends GeneratedMessageLite implements InterfaceC0768t {

    /* renamed from: a */
    private static final C0766r f1819a = new C0766r(true);

    /* renamed from: b */
    private int f1820b;

    /* renamed from: c */
    private Object f1821c;

    /* renamed from: d */
    private Object f1822d;

    /* renamed from: e */
    private int f1823e;

    /* renamed from: f */
    private int f1824f;

    /* renamed from: g */
    private Object f1825g;

    /* renamed from: h */
    private Object f1826h;

    /* renamed from: i */
    private Object f1827i;

    /* renamed from: j */
    private long f1828j;

    /* renamed from: k */
    private int f1829k;

    /* renamed from: l */
    private Object f1830l;

    /* renamed from: m */
    private byte f1831m;

    /* renamed from: n */
    private int f1832n;

    private C0766r(C0767s c0767s) {
        super(c0767s);
        this.f1831m = (byte) -1;
        this.f1832n = -1;
    }

    private C0766r(boolean z) {
        this.f1831m = (byte) -1;
        this.f1832n = -1;
    }

    /* renamed from: a */
    public static C0766r m2706a() {
        return f1819a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0766r getDefaultInstanceForType() {
        return f1819a;
    }

    /* renamed from: c */
    public boolean m2721c() {
        return (this.f1820b & 1) == 1;
    }

    /* renamed from: d */
    public String m2722d() {
        Object obj = this.f1821c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1821c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m2718y() {
        Object obj = this.f1821c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1821c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m2723e() {
        return (this.f1820b & 2) == 2;
    }

    /* renamed from: f */
    public String m2724f() {
        Object obj = this.f1822d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1822d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m2719z() {
        Object obj = this.f1822d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1822d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m2725g() {
        return (this.f1820b & 4) == 4;
    }

    /* renamed from: h */
    public int m2726h() {
        return this.f1823e;
    }

    /* renamed from: i */
    public boolean m2727i() {
        return (this.f1820b & 8) == 8;
    }

    /* renamed from: j */
    public int m2728j() {
        return this.f1824f;
    }

    /* renamed from: k */
    public boolean m2729k() {
        return (this.f1820b & 16) == 16;
    }

    /* renamed from: l */
    public String m2730l() {
        Object obj = this.f1825g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1825g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: A */
    private ByteString m2699A() {
        Object obj = this.f1825g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1825g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m2731m() {
        return (this.f1820b & 32) == 32;
    }

    /* renamed from: n */
    public String m2732n() {
        Object obj = this.f1826h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1826h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: B */
    private ByteString m2700B() {
        Object obj = this.f1826h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1826h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    public boolean m2733o() {
        return (this.f1820b & 64) == 64;
    }

    /* renamed from: p */
    public String m2734p() {
        Object obj = this.f1827i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1827i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: C */
    private ByteString m2701C() {
        Object obj = this.f1827i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1827i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: q */
    public boolean m2735q() {
        return (this.f1820b & 128) == 128;
    }

    /* renamed from: r */
    public long m2736r() {
        return this.f1828j;
    }

    /* renamed from: s */
    public boolean m2737s() {
        return (this.f1820b & 256) == 256;
    }

    /* renamed from: t */
    public int m2738t() {
        return this.f1829k;
    }

    /* renamed from: u */
    public boolean m2739u() {
        return (this.f1820b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512;
    }

    /* renamed from: v */
    public String m2740v() {
        Object obj = this.f1830l;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1830l = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: D */
    private ByteString m2702D() {
        Object obj = this.f1830l;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1830l = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: E */
    private void m2703E() {
        this.f1821c = "";
        this.f1822d = "";
        this.f1823e = 0;
        this.f1824f = 0;
        this.f1825g = "";
        this.f1826h = "";
        this.f1827i = "";
        this.f1828j = 0L;
        this.f1829k = 0;
        this.f1830l = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f1831m;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f1831m = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1820b & 1) == 1) {
            codedOutputStream.writeBytes(1, m2718y());
        }
        if ((this.f1820b & 2) == 2) {
            codedOutputStream.writeBytes(2, m2719z());
        }
        if ((this.f1820b & 4) == 4) {
            codedOutputStream.writeInt32(3, this.f1823e);
        }
        if ((this.f1820b & 8) == 8) {
            codedOutputStream.writeInt32(4, this.f1824f);
        }
        if ((this.f1820b & 16) == 16) {
            codedOutputStream.writeBytes(5, m2699A());
        }
        if ((this.f1820b & 32) == 32) {
            codedOutputStream.writeBytes(6, m2700B());
        }
        if ((this.f1820b & 64) == 64) {
            codedOutputStream.writeBytes(7, m2701C());
        }
        if ((this.f1820b & 128) == 128) {
            codedOutputStream.writeInt64(11, this.f1828j);
        }
        if ((this.f1820b & 256) == 256) {
            codedOutputStream.writeInt32(12, this.f1829k);
        }
        if ((this.f1820b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            codedOutputStream.writeBytes(13, m2702D());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f1832n;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f1820b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m2718y()) : 0;
            if ((this.f1820b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m2719z());
            }
            if ((this.f1820b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(3, this.f1823e);
            }
            if ((this.f1820b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(4, this.f1824f);
            }
            if ((this.f1820b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(5, m2699A());
            }
            if ((this.f1820b & 32) == 32) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(6, m2700B());
            }
            if ((this.f1820b & 64) == 64) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(7, m2701C());
            }
            if ((this.f1820b & 128) == 128) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(11, this.f1828j);
            }
            if ((this.f1820b & 256) == 256) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(12, this.f1829k);
            }
            if ((this.f1820b & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(13, m2702D());
            }
            this.f1832n = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0766r m2707a(byte[] bArr) {
        return ((C0767s) newBuilder().mergeFrom(bArr)).m2747i();
    }

    public static C0767s newBuilder() {
        return C0767s.m2746h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public C0767s newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0767s m2708a(C0766r c0766r) {
        return newBuilder().mergeFrom(c0766r);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public C0767s toBuilder() {
        return m2708a(this);
    }

    static {
        f1819a.m2703E();
    }
}
