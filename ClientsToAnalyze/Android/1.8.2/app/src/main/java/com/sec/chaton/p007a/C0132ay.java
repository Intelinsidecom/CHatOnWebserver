package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ay */
/* loaded from: classes.dex */
public final class C0132ay extends GeneratedMessageLite implements InterfaceC0135ba {

    /* renamed from: a */
    private static final C0132ay f452a = new C0132ay(true);

    /* renamed from: b */
    private int f453b;

    /* renamed from: c */
    private long f454c;

    /* renamed from: d */
    private EnumC0136bb f455d;

    /* renamed from: e */
    private Object f456e;

    /* renamed from: f */
    private byte f457f;

    /* renamed from: g */
    private int f458g;

    private C0132ay(C0133az c0133az) {
        super(c0133az);
        this.f457f = (byte) -1;
        this.f458g = -1;
    }

    private C0132ay(boolean z) {
        this.f457f = (byte) -1;
        this.f458g = -1;
    }

    /* renamed from: a */
    public static C0132ay m978a() {
        return f452a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0132ay getDefaultInstanceForType() {
        return f452a;
    }

    /* renamed from: c */
    public boolean m986c() {
        return (this.f453b & 1) == 1;
    }

    /* renamed from: d */
    public long m987d() {
        return this.f454c;
    }

    /* renamed from: e */
    public boolean m988e() {
        return (this.f453b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0136bb m989f() {
        return this.f455d;
    }

    /* renamed from: g */
    public boolean m990g() {
        return (this.f453b & 4) == 4;
    }

    /* renamed from: h */
    public String m991h() {
        Object obj = this.f456e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f456e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m983k() {
        Object obj = this.f456e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f456e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: l */
    private void m984l() {
        this.f454c = 0L;
        this.f455d = EnumC0136bb.TIMEOUT;
        this.f456e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f457f;
        if (b != -1) {
            return b == 1;
        }
        this.f457f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f453b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f454c);
        }
        if ((this.f453b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f455d.getNumber());
        }
        if ((this.f453b & 4) == 4) {
            codedOutputStream.writeBytes(3, m983k());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f458g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f453b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f454c) : 0;
            if ((this.f453b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f455d.getNumber());
            }
            if ((this.f453b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m983k());
            }
            this.f458g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0132ay m979a(byte[] bArr) {
        return ((C0133az) newBuilder().mergeFrom(bArr)).m998i();
    }

    public static C0133az newBuilder() {
        return C0133az.m997h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0133az newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0133az m980a(C0132ay c0132ay) {
        return newBuilder().mergeFrom(c0132ay);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0133az toBuilder() {
        return m980a(this);
    }

    static {
        f452a.m984l();
    }
}
