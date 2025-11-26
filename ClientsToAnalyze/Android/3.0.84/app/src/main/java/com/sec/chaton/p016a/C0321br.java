package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.br */
/* loaded from: classes.dex */
public final class C0321br extends GeneratedMessageLite implements InterfaceC0323bt {

    /* renamed from: a */
    private static final C0321br f1069a = new C0321br(true);

    /* renamed from: b */
    private int f1070b;

    /* renamed from: c */
    private long f1071c;

    /* renamed from: d */
    private EnumC0324bu f1072d;

    /* renamed from: e */
    private Object f1073e;

    /* renamed from: f */
    private byte f1074f;

    /* renamed from: g */
    private int f1075g;

    private C0321br(C0322bs c0322bs) {
        super(c0322bs);
        this.f1074f = (byte) -1;
        this.f1075g = -1;
    }

    private C0321br(boolean z) {
        this.f1074f = (byte) -1;
        this.f1075g = -1;
    }

    /* renamed from: a */
    public static C0321br m1890a() {
        return f1069a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0321br getDefaultInstanceForType() {
        return f1069a;
    }

    /* renamed from: c */
    public boolean m1898c() {
        return (this.f1070b & 1) == 1;
    }

    /* renamed from: d */
    public long m1899d() {
        return this.f1071c;
    }

    /* renamed from: e */
    public boolean m1900e() {
        return (this.f1070b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0324bu m1901f() {
        return this.f1072d;
    }

    /* renamed from: g */
    public boolean m1902g() {
        return (this.f1070b & 4) == 4;
    }

    /* renamed from: h */
    public String m1903h() {
        Object obj = this.f1073e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f1073e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m1895k() {
        Object obj = this.f1073e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f1073e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: l */
    private void m1896l() {
        this.f1071c = 0L;
        this.f1072d = EnumC0324bu.TIMEOUT;
        this.f1073e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1074f;
        if (b != -1) {
            return b == 1;
        }
        this.f1074f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1070b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1071c);
        }
        if ((this.f1070b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f1072d.getNumber());
        }
        if ((this.f1070b & 4) == 4) {
            codedOutputStream.writeBytes(3, m1895k());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f1075g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f1070b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f1071c) : 0;
            if ((this.f1070b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f1072d.getNumber());
            }
            if ((this.f1070b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m1895k());
            }
            this.f1075g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0321br m1891a(byte[] bArr) {
        return ((C0322bs) newBuilder().mergeFrom(bArr)).m1910i();
    }

    public static C0322bs newBuilder() {
        return C0322bs.m1909h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0322bs newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0322bs m1892a(C0321br c0321br) {
        return newBuilder().mergeFrom(c0321br);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0322bs toBuilder() {
        return m1892a(this);
    }

    static {
        f1069a.m1896l();
    }
}
