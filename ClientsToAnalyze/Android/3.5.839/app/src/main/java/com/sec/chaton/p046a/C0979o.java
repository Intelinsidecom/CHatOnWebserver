package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.o */
/* loaded from: classes.dex */
public final class C0979o extends GeneratedMessageLite implements InterfaceC0981q {

    /* renamed from: a */
    private static final C0979o f3195a = new C0979o(true);

    /* renamed from: b */
    private int f3196b;

    /* renamed from: c */
    private long f3197c;

    /* renamed from: d */
    private C0935fh f3198d;

    /* renamed from: e */
    private Object f3199e;

    /* renamed from: f */
    private long f3200f;

    /* renamed from: g */
    private byte f3201g;

    /* renamed from: h */
    private int f3202h;

    private C0979o(C0980p c0980p) {
        super(c0980p);
        this.f3201g = (byte) -1;
        this.f3202h = -1;
    }

    private C0979o(boolean z) {
        this.f3201g = (byte) -1;
        this.f3202h = -1;
    }

    /* renamed from: a */
    public static C0979o m5884a() {
        return f3195a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0979o getDefaultInstanceForType() {
        return f3195a;
    }

    /* renamed from: c */
    public boolean m5892c() {
        return (this.f3196b & 1) == 1;
    }

    /* renamed from: d */
    public long m5893d() {
        return this.f3197c;
    }

    /* renamed from: e */
    public boolean m5894e() {
        return (this.f3196b & 2) == 2;
    }

    /* renamed from: f */
    public C0935fh m5895f() {
        return this.f3198d;
    }

    /* renamed from: g */
    public boolean m5896g() {
        return (this.f3196b & 4) == 4;
    }

    /* renamed from: h */
    public String m5897h() {
        Object obj = this.f3199e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3199e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: m */
    private ByteString m5889m() {
        Object obj = this.f3199e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3199e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m5898i() {
        return (this.f3196b & 8) == 8;
    }

    /* renamed from: j */
    public long m5899j() {
        return this.f3200f;
    }

    /* renamed from: n */
    private void m5890n() {
        this.f3197c = 0L;
        this.f3198d = C0935fh.m5211a();
        this.f3199e = "";
        this.f3200f = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3201g;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3201g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f3196b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f3197c);
        }
        if ((this.f3196b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f3198d);
        }
        if ((this.f3196b & 4) == 4) {
            codedOutputStream.writeBytes(3, m5889m());
        }
        if ((this.f3196b & 8) == 8) {
            codedOutputStream.writeInt64(4, this.f3200f);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f3202h;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f3196b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3197c) : 0;
            if ((this.f3196b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f3198d);
            }
            if ((this.f3196b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(3, m5889m());
            }
            if ((this.f3196b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(4, this.f3200f);
            }
            this.f3202h = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0979o m5885a(byte[] bArr) {
        return ((C0980p) newBuilder().mergeFrom(bArr)).m5906l();
    }

    public static C0980p newBuilder() {
        return C0980p.m5905k();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0980p newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0980p m5886a(C0979o c0979o) {
        return newBuilder().mergeFrom(c0979o);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0980p toBuilder() {
        return m5886a(this);
    }

    static {
        f3195a.m5890n();
    }
}
