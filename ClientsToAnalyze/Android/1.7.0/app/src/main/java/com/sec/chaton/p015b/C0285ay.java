package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.ay */
/* loaded from: classes.dex */
public final class C0285ay extends GeneratedMessageLite implements InterfaceC0320cf {

    /* renamed from: a */
    private static final C0285ay f756a = new C0285ay(true);

    /* renamed from: b */
    private int f757b;

    /* renamed from: c */
    private Object f758c;

    /* renamed from: d */
    private Object f759d;

    /* renamed from: e */
    private long f760e;

    /* renamed from: f */
    private EnumC0275ao f761f;

    /* renamed from: g */
    private byte f762g;

    /* renamed from: h */
    private int f763h;

    private C0285ay(C0325ck c0325ck) {
        super(c0325ck);
        this.f762g = (byte) -1;
        this.f763h = -1;
    }

    private C0285ay(boolean z) {
        this.f762g = (byte) -1;
        this.f763h = -1;
    }

    /* renamed from: a */
    public static C0285ay m1278a() {
        return f756a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0285ay getDefaultInstanceForType() {
        return f756a;
    }

    /* renamed from: c */
    public boolean m1286c() {
        return (this.f757b & 1) == 1;
    }

    /* renamed from: d */
    public String m1287d() {
        Object obj = this.f758c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f758c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m1282m() {
        Object obj = this.f758c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f758c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m1288e() {
        return (this.f757b & 2) == 2;
    }

    /* renamed from: f */
    public String m1289f() {
        Object obj = this.f759d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f759d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: n */
    private ByteString m1283n() {
        Object obj = this.f759d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f759d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m1290g() {
        return (this.f757b & 4) == 4;
    }

    /* renamed from: h */
    public long m1291h() {
        return this.f760e;
    }

    /* renamed from: i */
    public boolean m1292i() {
        return (this.f757b & 8) == 8;
    }

    /* renamed from: j */
    public EnumC0275ao m1293j() {
        return this.f761f;
    }

    /* renamed from: o */
    private void m1284o() {
        this.f758c = "";
        this.f759d = "";
        this.f760e = 0L;
        this.f761f = EnumC0275ao.TEXT;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f762g;
        if (b != -1) {
            return b == 1;
        }
        this.f762g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f757b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1282m());
        }
        if ((this.f757b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1283n());
        }
        if ((this.f757b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f760e);
        }
        if ((this.f757b & 8) == 8) {
            codedOutputStream.writeEnum(4, this.f761f.getNumber());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f763h;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f757b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m1282m()) : 0;
            if ((this.f757b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m1283n());
            }
            if ((this.f757b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(3, this.f760e);
            }
            if ((this.f757b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeEnumSize(4, this.f761f.getNumber());
            }
            this.f763h = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0325ck newBuilder() {
        return C0325ck.m1775h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0325ck newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0325ck m1279a(C0285ay c0285ay) {
        return newBuilder().mergeFrom(c0285ay);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0325ck toBuilder() {
        return m1279a(this);
    }

    static {
        f756a.m1284o();
    }
}
