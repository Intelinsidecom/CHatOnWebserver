package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bu */
/* loaded from: classes.dex */
public final class C0840bu extends GeneratedMessageLite implements InterfaceC0842bw {

    /* renamed from: a */
    private static final C0840bu f2431a = new C0840bu(true);

    /* renamed from: b */
    private int f2432b;

    /* renamed from: c */
    private long f2433c;

    /* renamed from: d */
    private EnumC0843bx f2434d;

    /* renamed from: e */
    private Object f2435e;

    /* renamed from: f */
    private byte f2436f;

    /* renamed from: g */
    private int f2437g;

    private C0840bu(C0841bv c0841bv) {
        super(c0841bv);
        this.f2436f = (byte) -1;
        this.f2437g = -1;
    }

    private C0840bu(boolean z) {
        this.f2436f = (byte) -1;
        this.f2437g = -1;
    }

    /* renamed from: a */
    public static C0840bu m3766a() {
        return f2431a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0840bu getDefaultInstanceForType() {
        return f2431a;
    }

    /* renamed from: c */
    public boolean m3774c() {
        return (this.f2432b & 1) == 1;
    }

    /* renamed from: d */
    public long m3775d() {
        return this.f2433c;
    }

    /* renamed from: e */
    public boolean m3776e() {
        return (this.f2432b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0843bx m3777f() {
        return this.f2434d;
    }

    /* renamed from: g */
    public boolean m3778g() {
        return (this.f2432b & 4) == 4;
    }

    /* renamed from: h */
    public String m3779h() {
        Object obj = this.f2435e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2435e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: k */
    private ByteString m3771k() {
        Object obj = this.f2435e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2435e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: l */
    private void m3772l() {
        this.f2433c = 0L;
        this.f2434d = EnumC0843bx.TIMEOUT;
        this.f2435e = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2436f;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2436f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2432b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2433c);
        }
        if ((this.f2432b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f2434d.getNumber());
        }
        if ((this.f2432b & 4) == 4) {
            codedOutputStream.writeBytes(3, m3771k());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f2437g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f2432b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f2433c) : 0;
            if ((this.f2432b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f2434d.getNumber());
            }
            if ((this.f2432b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m3771k());
            }
            this.f2437g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0840bu m3767a(byte[] bArr) {
        return ((C0841bv) newBuilder().mergeFrom(bArr)).m3786i();
    }

    public static C0841bv newBuilder() {
        return C0841bv.m3785h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0841bv newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0841bv m3768a(C0840bu c0840bu) {
        return newBuilder().mergeFrom(c0840bu);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0841bv toBuilder() {
        return m3768a(this);
    }

    static {
        f2431a.m3772l();
    }
}
