package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cf */
/* loaded from: classes.dex */
public final class C0336cf extends GeneratedMessageLite implements InterfaceC0338ch {

    /* renamed from: a */
    private static final C0336cf f1138a = new C0336cf(true);

    /* renamed from: b */
    private int f1139b;

    /* renamed from: c */
    private long f1140c;

    /* renamed from: d */
    private Object f1141d;

    /* renamed from: e */
    private long f1142e;

    /* renamed from: f */
    private C0385ea f1143f;

    /* renamed from: g */
    private C0369dl f1144g;

    /* renamed from: h */
    private byte f1145h;

    /* renamed from: i */
    private int f1146i;

    private C0336cf(C0337cg c0337cg) {
        super(c0337cg);
        this.f1145h = (byte) -1;
        this.f1146i = -1;
    }

    private C0336cf(boolean z) {
        this.f1145h = (byte) -1;
        this.f1146i = -1;
    }

    /* renamed from: a */
    public static C0336cf m2077a() {
        return f1138a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0336cf getDefaultInstanceForType() {
        return f1138a;
    }

    /* renamed from: c */
    public boolean m2087c() {
        return (this.f1139b & 1) == 1;
    }

    /* renamed from: d */
    public long m2088d() {
        return this.f1140c;
    }

    /* renamed from: e */
    public boolean m2089e() {
        return (this.f1139b & 2) == 2;
    }

    /* renamed from: f */
    public String m2090f() {
        Object obj = this.f1141d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1141d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m2084o() {
        Object obj = this.f1141d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1141d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m2091g() {
        return (this.f1139b & 4) == 4;
    }

    /* renamed from: h */
    public long m2092h() {
        return this.f1142e;
    }

    /* renamed from: i */
    public boolean m2093i() {
        return (this.f1139b & 8) == 8;
    }

    /* renamed from: j */
    public C0385ea m2094j() {
        return this.f1143f;
    }

    /* renamed from: k */
    public boolean m2095k() {
        return (this.f1139b & 16) == 16;
    }

    /* renamed from: l */
    public C0369dl m2096l() {
        return this.f1144g;
    }

    /* renamed from: p */
    private void m2085p() {
        this.f1140c = 0L;
        this.f1141d = "";
        this.f1142e = 0L;
        this.f1143f = C0385ea.m2690a();
        this.f1144g = C0369dl.m2485a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1145h;
        if (b != -1) {
            return b == 1;
        }
        this.f1145h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1139b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1140c);
        }
        if ((this.f1139b & 2) == 2) {
            codedOutputStream.writeBytes(2, m2084o());
        }
        if ((this.f1139b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f1142e);
        }
        if ((this.f1139b & 8) == 8) {
            codedOutputStream.writeMessage(4, this.f1143f);
        }
        if ((this.f1139b & 16) == 16) {
            codedOutputStream.writeMessage(5, this.f1144g);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f1146i;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f1139b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f1140c) : 0;
            if ((this.f1139b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m2084o());
            }
            if ((this.f1139b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(3, this.f1142e);
            }
            if ((this.f1139b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(4, this.f1143f);
            }
            if ((this.f1139b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(5, this.f1144g);
            }
            this.f1146i = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0336cf m2078a(byte[] bArr) {
        return ((C0337cg) newBuilder().mergeFrom(bArr)).m2103m();
    }

    public static C0337cg newBuilder() {
        return C0337cg.m2102l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0337cg newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0337cg m2079a(C0336cf c0336cf) {
        return newBuilder().mergeFrom(c0336cf);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0337cg toBuilder() {
        return m2079a(this);
    }

    static {
        f1138a.m2085p();
    }
}
