package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dd */
/* loaded from: classes.dex */
public final class C0877dd extends GeneratedMessageLite implements InterfaceC0879df {

    /* renamed from: a */
    private static final C0877dd f2660a = new C0877dd(true);

    /* renamed from: b */
    private int f2661b;

    /* renamed from: c */
    private long f2662c;

    /* renamed from: d */
    private C0935fh f2663d;

    /* renamed from: e */
    private long f2664e;

    /* renamed from: f */
    private Object f2665f;

    /* renamed from: g */
    private byte f2666g;

    /* renamed from: h */
    private int f2667h;

    private C0877dd(C0878de c0878de) {
        super(c0878de);
        this.f2666g = (byte) -1;
        this.f2667h = -1;
    }

    private C0877dd(boolean z) {
        this.f2666g = (byte) -1;
        this.f2667h = -1;
    }

    /* renamed from: a */
    public static C0877dd m4390a() {
        return f2660a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0877dd getDefaultInstanceForType() {
        return f2660a;
    }

    /* renamed from: c */
    public boolean m4399c() {
        return (this.f2661b & 1) == 1;
    }

    /* renamed from: d */
    public long m4400d() {
        return this.f2662c;
    }

    /* renamed from: e */
    public boolean m4401e() {
        return (this.f2661b & 2) == 2;
    }

    /* renamed from: f */
    public C0935fh m4402f() {
        return this.f2663d;
    }

    /* renamed from: g */
    public boolean m4403g() {
        return (this.f2661b & 4) == 4;
    }

    /* renamed from: h */
    public long m4404h() {
        return this.f2664e;
    }

    /* renamed from: i */
    public boolean m4405i() {
        return (this.f2661b & 8) == 8;
    }

    /* renamed from: j */
    public String m4406j() {
        Object obj = this.f2665f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2665f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m4396m() {
        Object obj = this.f2665f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2665f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: n */
    private void m4397n() {
        this.f2662c = 0L;
        this.f2663d = C0935fh.m5211a();
        this.f2664e = 0L;
        this.f2665f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2666g;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2666g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2661b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2662c);
        }
        if ((this.f2661b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f2663d);
        }
        if ((this.f2661b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f2664e);
        }
        if ((this.f2661b & 8) == 8) {
            codedOutputStream.writeBytes(4, m4396m());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f2667h;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f2661b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f2662c) : 0;
            if ((this.f2661b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f2663d);
            }
            if ((this.f2661b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(3, this.f2664e);
            }
            if ((this.f2661b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m4396m());
            }
            this.f2667h = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0877dd m4391a(byte[] bArr) {
        return ((C0878de) newBuilder().mergeFrom(bArr)).m4413k();
    }

    public static C0878de newBuilder() {
        return C0878de.m4412j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0878de newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0878de m4392a(C0877dd c0877dd) {
        return newBuilder().mergeFrom(c0877dd);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0878de toBuilder() {
        return m4392a(this);
    }

    static {
        f2660a.m4397n();
    }
}
