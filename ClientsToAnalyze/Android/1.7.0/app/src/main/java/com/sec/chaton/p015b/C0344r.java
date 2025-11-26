package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.r */
/* loaded from: classes.dex */
public final class C0344r extends GeneratedMessageLite implements InterfaceC0287b {

    /* renamed from: a */
    private static final C0344r f987a = new C0344r(true);

    /* renamed from: b */
    private int f988b;

    /* renamed from: c */
    private Object f989c;

    /* renamed from: d */
    private long f990d;

    /* renamed from: e */
    private byte f991e;

    /* renamed from: f */
    private int f992f;

    private C0344r(C0346t c0346t) {
        super(c0346t);
        this.f991e = (byte) -1;
        this.f992f = -1;
    }

    private C0344r(boolean z) {
        this.f991e = (byte) -1;
        this.f992f = -1;
    }

    /* renamed from: a */
    public static C0344r m1949a() {
        return f987a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0344r getDefaultInstanceForType() {
        return f987a;
    }

    /* renamed from: c */
    public boolean m1955c() {
        return (this.f988b & 1) == 1;
    }

    /* renamed from: d */
    public String m1956d() {
        Object obj = this.f989c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f989c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m1952i() {
        Object obj = this.f989c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f989c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m1957e() {
        return (this.f988b & 2) == 2;
    }

    /* renamed from: f */
    public long m1958f() {
        return this.f990d;
    }

    /* renamed from: j */
    private void m1953j() {
        this.f989c = "";
        this.f990d = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f991e;
        if (b != -1) {
            return b == 1;
        }
        this.f991e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f988b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1952i());
        }
        if ((this.f988b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f990d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f992f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f988b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m1952i()) : 0;
            if ((this.f988b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(2, this.f990d);
            }
            this.f992f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0346t newBuilder() {
        return C0346t.m1963h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0346t newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0346t m1950a(C0344r c0344r) {
        return newBuilder().mergeFrom(c0344r);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0346t toBuilder() {
        return m1950a(this);
    }

    static {
        f987a.m1953j();
    }
}
