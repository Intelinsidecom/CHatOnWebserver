package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.c */
/* loaded from: classes.dex */
public final class C0846c extends GeneratedMessageLite implements InterfaceC0900e {

    /* renamed from: a */
    private static final C0846c f2454a = new C0846c(true);

    /* renamed from: b */
    private int f2455b;

    /* renamed from: c */
    private Object f2456c;

    /* renamed from: d */
    private EnumC0822bc f2457d;

    /* renamed from: e */
    private byte f2458e;

    /* renamed from: f */
    private int f2459f;

    private C0846c(C0873d c0873d) {
        super(c0873d);
        this.f2458e = (byte) -1;
        this.f2459f = -1;
    }

    private C0846c(boolean z) {
        this.f2458e = (byte) -1;
        this.f2459f = -1;
    }

    /* renamed from: a */
    public static C0846c m3819a() {
        return f2454a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0846c getDefaultInstanceForType() {
        return f2454a;
    }

    /* renamed from: c */
    public boolean m3825c() {
        return (this.f2455b & 1) == 1;
    }

    /* renamed from: d */
    public String m3826d() {
        Object obj = this.f2456c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2456c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m3822i() {
        Object obj = this.f2456c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2456c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m3827e() {
        return (this.f2455b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0822bc m3828f() {
        return this.f2457d;
    }

    /* renamed from: j */
    private void m3823j() {
        this.f2456c = "";
        this.f2457d = EnumC0822bc.SINGLE;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2458e;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2458e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2455b & 1) == 1) {
            codedOutputStream.writeBytes(1, m3822i());
        }
        if ((this.f2455b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f2457d.getNumber());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f2459f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f2455b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m3822i()) : 0;
            if ((this.f2455b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeEnumSize(2, this.f2457d.getNumber());
            }
            this.f2459f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0873d newBuilder() {
        return C0873d.m4290h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0873d newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0873d m3820a(C0846c c0846c) {
        return newBuilder().mergeFrom(c0846c);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0873d toBuilder() {
        return m3820a(this);
    }

    static {
        f2454a.m3823j();
    }
}
