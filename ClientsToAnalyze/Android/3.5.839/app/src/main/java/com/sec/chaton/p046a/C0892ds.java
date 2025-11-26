package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ds */
/* loaded from: classes.dex */
public final class C0892ds extends GeneratedMessageLite implements InterfaceC0894du {

    /* renamed from: a */
    private static final C0892ds f2753a = new C0892ds(true);

    /* renamed from: b */
    private int f2754b;

    /* renamed from: c */
    private Object f2755c;

    /* renamed from: d */
    private Object f2756d;

    /* renamed from: e */
    private byte f2757e;

    /* renamed from: f */
    private int f2758f;

    private C0892ds(C0893dt c0893dt) {
        super(c0893dt);
        this.f2757e = (byte) -1;
        this.f2758f = -1;
    }

    private C0892ds(boolean z) {
        this.f2757e = (byte) -1;
        this.f2758f = -1;
    }

    /* renamed from: a */
    public static C0892ds m4659a() {
        return f2753a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0892ds getDefaultInstanceForType() {
        return f2753a;
    }

    /* renamed from: c */
    public boolean m4667c() {
        return (this.f2754b & 1) == 1;
    }

    /* renamed from: d */
    public String m4668d() {
        Object obj = this.f2755c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2755c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m4663i() {
        Object obj = this.f2755c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2755c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m4669e() {
        return (this.f2754b & 2) == 2;
    }

    /* renamed from: f */
    public String m4670f() {
        Object obj = this.f2756d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2756d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: j */
    private ByteString m4664j() {
        Object obj = this.f2756d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2756d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    private void m4665k() {
        this.f2755c = "";
        this.f2756d = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2757e;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2757e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2754b & 1) == 1) {
            codedOutputStream.writeBytes(1, m4663i());
        }
        if ((this.f2754b & 2) == 2) {
            codedOutputStream.writeBytes(2, m4664j());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f2758f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f2754b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m4663i()) : 0;
            if ((this.f2754b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m4664j());
            }
            this.f2758f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0893dt newBuilder() {
        return C0893dt.m4675h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0893dt newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0893dt m4660a(C0892ds c0892ds) {
        return newBuilder().mergeFrom(c0892ds);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0893dt toBuilder() {
        return m4660a(this);
    }

    static {
        f2753a.m4665k();
    }
}
