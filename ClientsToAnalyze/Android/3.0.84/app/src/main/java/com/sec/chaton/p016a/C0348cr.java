package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cr */
/* loaded from: classes.dex */
public final class C0348cr extends GeneratedMessageLite implements InterfaceC0350ct {

    /* renamed from: a */
    private static final C0348cr f1206a = new C0348cr(true);

    /* renamed from: b */
    private int f1207b;

    /* renamed from: c */
    private EnumC0302az f1208c;

    /* renamed from: d */
    private Object f1209d;

    /* renamed from: e */
    private Object f1210e;

    /* renamed from: f */
    private Object f1211f;

    /* renamed from: g */
    private EnumC0305bb f1212g;

    /* renamed from: h */
    private int f1213h;

    /* renamed from: i */
    private byte f1214i;

    /* renamed from: j */
    private int f1215j;

    private C0348cr(C0349cs c0349cs) {
        super(c0349cs);
        this.f1214i = (byte) -1;
        this.f1215j = -1;
    }

    private C0348cr(boolean z) {
        this.f1214i = (byte) -1;
        this.f1215j = -1;
    }

    /* renamed from: a */
    public static C0348cr m2281a() {
        return f1206a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0348cr getDefaultInstanceForType() {
        return f1206a;
    }

    /* renamed from: c */
    public boolean m2293c() {
        return (this.f1207b & 1) == 1;
    }

    /* renamed from: d */
    public EnumC0302az m2294d() {
        return this.f1208c;
    }

    /* renamed from: e */
    public boolean m2295e() {
        return (this.f1207b & 2) == 2;
    }

    /* renamed from: f */
    public String m2296f() {
        Object obj = this.f1209d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1209d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m2288q() {
        Object obj = this.f1209d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1209d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m2297g() {
        return (this.f1207b & 4) == 4;
    }

    /* renamed from: h */
    public String m2298h() {
        Object obj = this.f1210e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1210e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m2289r() {
        Object obj = this.f1210e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1210e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m2299i() {
        return (this.f1207b & 8) == 8;
    }

    /* renamed from: j */
    public String m2300j() {
        Object obj = this.f1211f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1211f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m2290s() {
        Object obj = this.f1211f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1211f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m2301k() {
        return (this.f1207b & 16) == 16;
    }

    /* renamed from: l */
    public EnumC0305bb m2302l() {
        return this.f1212g;
    }

    /* renamed from: m */
    public boolean m2303m() {
        return (this.f1207b & 32) == 32;
    }

    /* renamed from: n */
    public int m2304n() {
        return this.f1213h;
    }

    /* renamed from: t */
    private void m2291t() {
        this.f1208c = EnumC0302az.SINGLE;
        this.f1209d = "";
        this.f1210e = "";
        this.f1211f = "";
        this.f1212g = EnumC0305bb.CONTENT_TEXT;
        this.f1213h = 0;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1214i;
        if (b != -1) {
            return b == 1;
        }
        this.f1214i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1207b & 1) == 1) {
            codedOutputStream.writeEnum(1, this.f1208c.getNumber());
        }
        if ((this.f1207b & 2) == 2) {
            codedOutputStream.writeBytes(2, m2288q());
        }
        if ((this.f1207b & 4) == 4) {
            codedOutputStream.writeBytes(3, m2289r());
        }
        if ((this.f1207b & 8) == 8) {
            codedOutputStream.writeBytes(4, m2290s());
        }
        if ((this.f1207b & 16) == 16) {
            codedOutputStream.writeEnum(5, this.f1212g.getNumber());
        }
        if ((this.f1207b & 32) == 32) {
            codedOutputStream.writeInt32(6, this.f1213h);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeEnumSize = this.f1215j;
        if (iComputeEnumSize == -1) {
            iComputeEnumSize = (this.f1207b & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.f1208c.getNumber()) : 0;
            if ((this.f1207b & 2) == 2) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(2, m2288q());
            }
            if ((this.f1207b & 4) == 4) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(3, m2289r());
            }
            if ((this.f1207b & 8) == 8) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(4, m2290s());
            }
            if ((this.f1207b & 16) == 16) {
                iComputeEnumSize += CodedOutputStream.computeEnumSize(5, this.f1212g.getNumber());
            }
            if ((this.f1207b & 32) == 32) {
                iComputeEnumSize += CodedOutputStream.computeInt32Size(6, this.f1213h);
            }
            this.f1215j = iComputeEnumSize;
        }
        return iComputeEnumSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0348cr m2282a(byte[] bArr) {
        return ((C0349cs) newBuilder().mergeFrom(bArr)).m2311i();
    }

    public static C0349cs newBuilder() {
        return C0349cs.m2310h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C0349cs newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0349cs m2283a(C0348cr c0348cr) {
        return newBuilder().mergeFrom(c0348cr);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0349cs toBuilder() {
        return m2283a(this);
    }

    static {
        f1206a.m2291t();
    }
}
