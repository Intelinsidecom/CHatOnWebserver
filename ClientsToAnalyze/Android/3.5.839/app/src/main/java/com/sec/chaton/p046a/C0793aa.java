package com.sec.chaton.p046a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.aa */
/* loaded from: classes.dex */
public final class C0793aa extends GeneratedMessageLite implements InterfaceC0795ac {

    /* renamed from: a */
    private static final C0793aa f2185a = new C0793aa(true);

    /* renamed from: b */
    private int f2186b;

    /* renamed from: c */
    private long f2187c;

    /* renamed from: d */
    private C0935fh f2188d;

    /* renamed from: e */
    private byte f2189e;

    /* renamed from: f */
    private int f2190f;

    private C0793aa(C0794ab c0794ab) {
        super(c0794ab);
        this.f2189e = (byte) -1;
        this.f2190f = -1;
    }

    private C0793aa(boolean z) {
        this.f2189e = (byte) -1;
        this.f2190f = -1;
    }

    /* renamed from: a */
    public static C0793aa m3165a() {
        return f2185a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0793aa getDefaultInstanceForType() {
        return f2185a;
    }

    /* renamed from: c */
    public boolean m3171c() {
        return (this.f2186b & 1) == 1;
    }

    /* renamed from: d */
    public long m3172d() {
        return this.f2187c;
    }

    /* renamed from: e */
    public boolean m3173e() {
        return (this.f2186b & 2) == 2;
    }

    /* renamed from: f */
    public C0935fh m3174f() {
        return this.f2188d;
    }

    /* renamed from: i */
    private void m3169i() {
        this.f2187c = 0L;
        this.f2188d = C0935fh.m5211a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2189e;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2189e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2186b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2187c);
        }
        if ((this.f2186b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f2188d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f2190f;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f2186b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f2187c) : 0;
            if ((this.f2186b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f2188d);
            }
            this.f2190f = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0793aa m3166a(byte[] bArr) {
        return ((C0794ab) newBuilder().mergeFrom(bArr)).m3181k();
    }

    public static C0794ab newBuilder() {
        return C0794ab.m3180j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0794ab newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0794ab m3167a(C0793aa c0793aa) {
        return newBuilder().mergeFrom(c0793aa);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0794ab toBuilder() {
        return m3167a(this);
    }

    static {
        f2185a.m3169i();
    }
}
