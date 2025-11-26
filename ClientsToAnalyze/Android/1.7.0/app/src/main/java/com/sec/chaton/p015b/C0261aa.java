package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.aa */
/* loaded from: classes.dex */
public final class C0261aa extends GeneratedMessageLite implements InterfaceC0290bc {

    /* renamed from: a */
    private static final C0261aa f641a = new C0261aa(true);

    /* renamed from: b */
    private int f642b;

    /* renamed from: c */
    private Object f643c;

    /* renamed from: d */
    private Object f644d;

    /* renamed from: e */
    private byte f645e;

    /* renamed from: f */
    private int f646f;

    private C0261aa(C0282av c0282av) {
        super(c0282av);
        this.f645e = (byte) -1;
        this.f646f = -1;
    }

    private C0261aa(boolean z) {
        this.f645e = (byte) -1;
        this.f646f = -1;
    }

    /* renamed from: a */
    public static C0261aa m947a() {
        return f641a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0261aa getDefaultInstanceForType() {
        return f641a;
    }

    /* renamed from: c */
    public boolean m955c() {
        return (this.f642b & 1) == 1;
    }

    /* renamed from: d */
    public String m956d() {
        Object obj = this.f643c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f643c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m951i() {
        Object obj = this.f643c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f643c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m957e() {
        return (this.f642b & 2) == 2;
    }

    /* renamed from: f */
    public String m958f() {
        Object obj = this.f644d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f644d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: j */
    private ByteString m952j() {
        Object obj = this.f644d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f644d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    private void m953k() {
        this.f643c = "";
        this.f644d = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f645e;
        if (b != -1) {
            return b == 1;
        }
        this.f645e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f642b & 1) == 1) {
            codedOutputStream.writeBytes(1, m951i());
        }
        if ((this.f642b & 2) == 2) {
            codedOutputStream.writeBytes(2, m952j());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f646f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f642b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m951i()) : 0;
            if ((this.f642b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m952j());
            }
            this.f646f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0282av newBuilder() {
        return C0282av.m1228h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0282av newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0282av m948a(C0261aa c0261aa) {
        return newBuilder().mergeFrom(c0261aa);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0282av toBuilder() {
        return m948a(this);
    }

    static {
        f641a.m953k();
    }
}
