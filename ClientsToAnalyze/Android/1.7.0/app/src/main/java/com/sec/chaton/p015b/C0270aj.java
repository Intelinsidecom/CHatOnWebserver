package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.aj */
/* loaded from: classes.dex */
public final class C0270aj extends GeneratedMessageLite implements InterfaceC0343q {

    /* renamed from: a */
    private static final C0270aj f700a = new C0270aj(true);

    /* renamed from: b */
    private int f701b;

    /* renamed from: c */
    private long f702c;

    /* renamed from: d */
    private EnumC0286az f703d;

    /* renamed from: e */
    private Object f704e;

    /* renamed from: f */
    private byte f705f;

    /* renamed from: g */
    private int f706g;

    private C0270aj(C0264ad c0264ad) {
        super(c0264ad);
        this.f705f = (byte) -1;
        this.f706g = -1;
    }

    private C0270aj(boolean z) {
        this.f705f = (byte) -1;
        this.f706g = -1;
    }

    /* renamed from: a */
    public static C0270aj m1142a() {
        return f700a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0270aj getDefaultInstanceForType() {
        return f700a;
    }

    /* renamed from: c */
    public boolean m1149c() {
        return (this.f701b & 1) == 1;
    }

    /* renamed from: d */
    public long m1150d() {
        return this.f702c;
    }

    /* renamed from: e */
    public boolean m1151e() {
        return (this.f701b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0286az m1152f() {
        return this.f703d;
    }

    /* renamed from: g */
    public boolean m1153g() {
        return (this.f701b & 4) == 4;
    }

    /* renamed from: h */
    public String m1154h() {
        Object obj = this.f704e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f704e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m1146k() {
        Object obj = this.f704e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f704e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: l */
    private void m1147l() {
        this.f702c = 0L;
        this.f703d = EnumC0286az.TIMEOUT;
        this.f704e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f705f;
        if (b != -1) {
            return b == 1;
        }
        this.f705f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f701b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f702c);
        }
        if ((this.f701b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f703d.getNumber());
        }
        if ((this.f701b & 4) == 4) {
            codedOutputStream.writeBytes(3, m1146k());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f706g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f701b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f702c) : 0;
            if ((this.f701b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f703d.getNumber());
            }
            if ((this.f701b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m1146k());
            }
            this.f706g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0270aj m1143a(byte[] bArr) {
        return ((C0264ad) newBuilder().mergeFrom(bArr)).m1001i();
    }

    public static C0264ad newBuilder() {
        return C0264ad.m1000h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0264ad newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0264ad m1141a(C0270aj c0270aj) {
        return newBuilder().mergeFrom(c0270aj);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0264ad toBuilder() {
        return m1141a(this);
    }

    static {
        f700a.m1147l();
    }
}
