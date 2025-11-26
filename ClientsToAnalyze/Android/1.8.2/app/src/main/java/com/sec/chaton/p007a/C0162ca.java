package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ca */
/* loaded from: classes.dex */
public final class C0162ca extends GeneratedMessageLite implements InterfaceC0164cc {

    /* renamed from: a */
    private static final C0162ca f592a = new C0162ca(true);

    /* renamed from: b */
    private int f593b;

    /* renamed from: c */
    private Object f594c;

    /* renamed from: d */
    private Object f595d;

    /* renamed from: e */
    private byte f596e;

    /* renamed from: f */
    private int f597f;

    private C0162ca(C0163cb c0163cb) {
        super(c0163cb);
        this.f596e = (byte) -1;
        this.f597f = -1;
    }

    private C0162ca(boolean z) {
        this.f596e = (byte) -1;
        this.f597f = -1;
    }

    /* renamed from: a */
    public static C0162ca m1364a() {
        return f592a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0162ca getDefaultInstanceForType() {
        return f592a;
    }

    /* renamed from: c */
    public boolean m1372c() {
        return (this.f593b & 1) == 1;
    }

    /* renamed from: d */
    public String m1373d() {
        Object obj = this.f594c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f594c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m1368i() {
        Object obj = this.f594c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f594c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m1374e() {
        return (this.f593b & 2) == 2;
    }

    /* renamed from: f */
    public String m1375f() {
        Object obj = this.f595d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f595d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: j */
    private ByteString m1369j() {
        Object obj = this.f595d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f595d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    private void m1370k() {
        this.f594c = "";
        this.f595d = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f596e;
        if (b != -1) {
            return b == 1;
        }
        this.f596e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f593b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1368i());
        }
        if ((this.f593b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1369j());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f597f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f593b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m1368i()) : 0;
            if ((this.f593b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m1369j());
            }
            this.f597f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0163cb newBuilder() {
        return C0163cb.m1380h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0163cb newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0163cb m1365a(C0162ca c0162ca) {
        return newBuilder().mergeFrom(c0162ca);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0163cb toBuilder() {
        return m1365a(this);
    }

    static {
        f592a.m1370k();
    }
}
