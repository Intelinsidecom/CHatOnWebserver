package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.u */
/* loaded from: classes.dex */
public final class C0406u extends GeneratedMessageLite implements InterfaceC0408w {

    /* renamed from: a */
    private static final C0406u f1439a = new C0406u(true);

    /* renamed from: b */
    private int f1440b;

    /* renamed from: c */
    private Object f1441c;

    /* renamed from: d */
    private long f1442d;

    /* renamed from: e */
    private byte f1443e;

    /* renamed from: f */
    private int f1444f;

    private C0406u(C0407v c0407v) {
        super(c0407v);
        this.f1443e = (byte) -1;
        this.f1444f = -1;
    }

    private C0406u(boolean z) {
        this.f1443e = (byte) -1;
        this.f1444f = -1;
    }

    /* renamed from: a */
    public static C0406u m2966a() {
        return f1439a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0406u getDefaultInstanceForType() {
        return f1439a;
    }

    /* renamed from: c */
    public boolean m2972c() {
        return (this.f1440b & 1) == 1;
    }

    /* renamed from: d */
    public String m2973d() {
        Object obj = this.f1441c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1441c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m2969i() {
        Object obj = this.f1441c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1441c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m2974e() {
        return (this.f1440b & 2) == 2;
    }

    /* renamed from: f */
    public long m2975f() {
        return this.f1442d;
    }

    /* renamed from: j */
    private void m2970j() {
        this.f1441c = "";
        this.f1442d = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1443e;
        if (b != -1) {
            return b == 1;
        }
        this.f1443e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1440b & 1) == 1) {
            codedOutputStream.writeBytes(1, m2969i());
        }
        if ((this.f1440b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f1442d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f1444f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f1440b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m2969i()) : 0;
            if ((this.f1440b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(2, this.f1442d);
            }
            this.f1444f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0407v newBuilder() {
        return C0407v.m2980h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0407v newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0407v m2967a(C0406u c0406u) {
        return newBuilder().mergeFrom(c0406u);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0407v toBuilder() {
        return m2967a(this);
    }

    static {
        f1439a.m2970j();
    }
}
