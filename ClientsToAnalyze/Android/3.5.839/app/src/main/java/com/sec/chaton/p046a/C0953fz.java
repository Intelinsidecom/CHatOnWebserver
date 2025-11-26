package com.sec.chaton.p046a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fz */
/* loaded from: classes.dex */
public final class C0953fz extends GeneratedMessageLite implements InterfaceC0956gb {

    /* renamed from: a */
    private static final C0953fz f3052a = new C0953fz(true);

    /* renamed from: b */
    private int f3053b;

    /* renamed from: c */
    private long f3054c;

    /* renamed from: d */
    private long f3055d;

    /* renamed from: e */
    private C0935fh f3056e;

    /* renamed from: f */
    private byte f3057f;

    /* renamed from: g */
    private int f3058g;

    private C0953fz(C0955ga c0955ga) {
        super(c0955ga);
        this.f3057f = (byte) -1;
        this.f3058g = -1;
    }

    private C0953fz(boolean z) {
        this.f3057f = (byte) -1;
        this.f3058g = -1;
    }

    /* renamed from: a */
    public static C0953fz m5497a() {
        return f3052a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0953fz getDefaultInstanceForType() {
        return f3052a;
    }

    /* renamed from: c */
    public boolean m5502c() {
        return (this.f3053b & 1) == 1;
    }

    /* renamed from: d */
    public long m5503d() {
        return this.f3054c;
    }

    /* renamed from: e */
    public boolean m5504e() {
        return (this.f3053b & 2) == 2;
    }

    /* renamed from: f */
    public long m5505f() {
        return this.f3055d;
    }

    /* renamed from: g */
    public boolean m5506g() {
        return (this.f3053b & 4) == 4;
    }

    /* renamed from: h */
    public C0935fh m5507h() {
        return this.f3056e;
    }

    /* renamed from: k */
    private void m5500k() {
        this.f3054c = 0L;
        this.f3055d = 0L;
        this.f3056e = C0935fh.m5211a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3057f;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3057f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f3053b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f3054c);
        }
        if ((this.f3053b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f3055d);
        }
        if ((this.f3053b & 4) == 4) {
            codedOutputStream.writeMessage(3, this.f3056e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f3058g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f3053b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f3054c) : 0;
            if ((this.f3053b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(2, this.f3055d);
            }
            if ((this.f3053b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(3, this.f3056e);
            }
            this.f3058g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0955ga newBuilder() {
        return C0955ga.m5538j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0955ga newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0955ga m5498a(C0953fz c0953fz) {
        return newBuilder().mergeFrom(c0953fz);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0955ga toBuilder() {
        return m5498a(this);
    }

    static {
        f3052a.m5500k();
    }
}
