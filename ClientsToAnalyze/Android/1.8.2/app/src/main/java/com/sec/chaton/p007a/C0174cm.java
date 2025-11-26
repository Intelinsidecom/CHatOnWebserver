package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cm */
/* loaded from: classes.dex */
public final class C0174cm extends GeneratedMessageLite implements InterfaceC0176co {

    /* renamed from: a */
    private static final C0174cm f630a = new C0174cm(true);

    /* renamed from: b */
    private int f631b;

    /* renamed from: c */
    private Object f632c;

    /* renamed from: d */
    private int f633d;

    /* renamed from: e */
    private byte f634e;

    /* renamed from: f */
    private int f635f;

    private C0174cm(C0175cn c0175cn) {
        super(c0175cn);
        this.f634e = (byte) -1;
        this.f635f = -1;
    }

    private C0174cm(boolean z) {
        this.f634e = (byte) -1;
        this.f635f = -1;
    }

    /* renamed from: a */
    public static C0174cm m1485a() {
        return f630a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0174cm getDefaultInstanceForType() {
        return f630a;
    }

    /* renamed from: c */
    public boolean m1492c() {
        return (this.f631b & 1) == 1;
    }

    /* renamed from: d */
    public String m1493d() {
        Object obj = this.f632c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f632c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m1489i() {
        Object obj = this.f632c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f632c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m1494e() {
        return (this.f631b & 2) == 2;
    }

    /* renamed from: f */
    public int m1495f() {
        return this.f633d;
    }

    /* renamed from: j */
    private void m1490j() {
        this.f632c = "";
        this.f633d = 0;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f634e;
        if (b != -1) {
            return b == 1;
        }
        this.f634e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f631b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1489i());
        }
        if ((this.f631b & 2) == 2) {
            codedOutputStream.writeInt32(2, this.f633d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f635f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f631b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m1489i()) : 0;
            if ((this.f631b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(2, this.f633d);
            }
            this.f635f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0175cn newBuilder() {
        return C0175cn.m1500h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0175cn newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0175cn m1486a(C0174cm c0174cm) {
        return newBuilder().mergeFrom(c0174cm);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0175cn toBuilder() {
        return m1486a(this);
    }

    static {
        f630a.m1490j();
    }
}
