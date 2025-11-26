package com.sec.p013a.p014a.p015a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.r */
/* loaded from: classes.dex */
public final class C0253r extends GeneratedMessageLite implements InterfaceC0255t {

    /* renamed from: a */
    private static final C0253r f583a = new C0253r(true);

    /* renamed from: b */
    private int f584b;

    /* renamed from: c */
    private Object f585c;

    /* renamed from: d */
    private Object f586d;

    /* renamed from: e */
    private int f587e;

    /* renamed from: f */
    private int f588f;

    /* renamed from: g */
    private Object f589g;

    /* renamed from: h */
    private Object f590h;

    /* renamed from: i */
    private Object f591i;

    /* renamed from: j */
    private long f592j;

    /* renamed from: k */
    private int f593k;

    /* renamed from: l */
    private Object f594l;

    /* renamed from: m */
    private byte f595m;

    /* renamed from: n */
    private int f596n;

    private C0253r(C0254s c0254s) {
        super(c0254s);
        this.f595m = (byte) -1;
        this.f596n = -1;
    }

    private C0253r(boolean z) {
        this.f595m = (byte) -1;
        this.f596n = -1;
    }

    /* renamed from: a */
    public static C0253r m974a() {
        return f583a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0253r getDefaultInstanceForType() {
        return f583a;
    }

    /* renamed from: c */
    public boolean m989c() {
        return (this.f584b & 1) == 1;
    }

    /* renamed from: d */
    public String m990d() {
        Object obj = this.f585c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f585c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m986y() {
        Object obj = this.f585c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f585c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m991e() {
        return (this.f584b & 2) == 2;
    }

    /* renamed from: f */
    public String m992f() {
        Object obj = this.f586d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f586d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m987z() {
        Object obj = this.f586d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f586d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m993g() {
        return (this.f584b & 4) == 4;
    }

    /* renamed from: h */
    public int m994h() {
        return this.f587e;
    }

    /* renamed from: i */
    public boolean m995i() {
        return (this.f584b & 8) == 8;
    }

    /* renamed from: j */
    public int m996j() {
        return this.f588f;
    }

    /* renamed from: k */
    public boolean m997k() {
        return (this.f584b & 16) == 16;
    }

    /* renamed from: l */
    public String m998l() {
        Object obj = this.f589g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f589g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: A */
    private ByteString m967A() {
        Object obj = this.f589g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f589g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m999m() {
        return (this.f584b & 32) == 32;
    }

    /* renamed from: n */
    public String m1000n() {
        Object obj = this.f590h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f590h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: B */
    private ByteString m968B() {
        Object obj = this.f590h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f590h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    public boolean m1001o() {
        return (this.f584b & 64) == 64;
    }

    /* renamed from: p */
    public String m1002p() {
        Object obj = this.f591i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f591i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: C */
    private ByteString m969C() {
        Object obj = this.f591i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f591i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: q */
    public boolean m1003q() {
        return (this.f584b & 128) == 128;
    }

    /* renamed from: r */
    public long m1004r() {
        return this.f592j;
    }

    /* renamed from: s */
    public boolean m1005s() {
        return (this.f584b & 256) == 256;
    }

    /* renamed from: t */
    public int m1006t() {
        return this.f593k;
    }

    /* renamed from: u */
    public boolean m1007u() {
        return (this.f584b & 512) == 512;
    }

    /* renamed from: v */
    public String m1008v() {
        Object obj = this.f594l;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f594l = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: D */
    private ByteString m970D() {
        Object obj = this.f594l;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f594l = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: E */
    private void m971E() {
        this.f585c = "";
        this.f586d = "";
        this.f587e = 0;
        this.f588f = 0;
        this.f589g = "";
        this.f590h = "";
        this.f591i = "";
        this.f592j = 0L;
        this.f593k = 0;
        this.f594l = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f595m;
        if (b != -1) {
            return b == 1;
        }
        this.f595m = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f584b & 1) == 1) {
            codedOutputStream.writeBytes(1, m986y());
        }
        if ((this.f584b & 2) == 2) {
            codedOutputStream.writeBytes(2, m987z());
        }
        if ((this.f584b & 4) == 4) {
            codedOutputStream.writeInt32(3, this.f587e);
        }
        if ((this.f584b & 8) == 8) {
            codedOutputStream.writeInt32(4, this.f588f);
        }
        if ((this.f584b & 16) == 16) {
            codedOutputStream.writeBytes(5, m967A());
        }
        if ((this.f584b & 32) == 32) {
            codedOutputStream.writeBytes(6, m968B());
        }
        if ((this.f584b & 64) == 64) {
            codedOutputStream.writeBytes(7, m969C());
        }
        if ((this.f584b & 128) == 128) {
            codedOutputStream.writeInt64(11, this.f592j);
        }
        if ((this.f584b & 256) == 256) {
            codedOutputStream.writeInt32(12, this.f593k);
        }
        if ((this.f584b & 512) == 512) {
            codedOutputStream.writeBytes(13, m970D());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f596n;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f584b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m986y()) : 0;
            if ((this.f584b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m987z());
            }
            if ((this.f584b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(3, this.f587e);
            }
            if ((this.f584b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(4, this.f588f);
            }
            if ((this.f584b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(5, m967A());
            }
            if ((this.f584b & 32) == 32) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(6, m968B());
            }
            if ((this.f584b & 64) == 64) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(7, m969C());
            }
            if ((this.f584b & 128) == 128) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(11, this.f592j);
            }
            if ((this.f584b & 256) == 256) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(12, this.f593k);
            }
            if ((this.f584b & 512) == 512) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(13, m970D());
            }
            this.f596n = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0253r m975a(byte[] bArr) {
        return ((C0254s) newBuilder().mergeFrom(bArr)).m1015i();
    }

    public static C0254s newBuilder() {
        return C0254s.m1014h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public C0254s newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0254s m976a(C0253r c0253r) {
        return newBuilder().mergeFrom(c0253r);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public C0254s toBuilder() {
        return m976a(this);
    }

    static {
        f583a.m971E();
    }
}
