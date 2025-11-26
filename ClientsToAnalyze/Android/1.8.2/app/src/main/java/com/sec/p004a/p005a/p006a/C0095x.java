package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.x */
/* loaded from: classes.dex */
public final class C0095x extends GeneratedMessageLite implements InterfaceC0097z {

    /* renamed from: a */
    private static final C0095x f191a = new C0095x(true);

    /* renamed from: b */
    private int f192b;

    /* renamed from: c */
    private int f193c;

    /* renamed from: d */
    private long f194d;

    /* renamed from: e */
    private int f195e;

    /* renamed from: f */
    private byte f196f;

    /* renamed from: g */
    private int f197g;

    private C0095x(C0096y c0096y) {
        super(c0096y);
        this.f196f = (byte) -1;
        this.f197g = -1;
    }

    private C0095x(boolean z) {
        this.f196f = (byte) -1;
        this.f197g = -1;
    }

    /* renamed from: a */
    public static C0095x m548a() {
        return f191a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0095x getDefaultInstanceForType() {
        return f191a;
    }

    /* renamed from: c */
    public boolean m555c() {
        return (this.f192b & 1) == 1;
    }

    /* renamed from: d */
    public int m556d() {
        return this.f193c;
    }

    /* renamed from: e */
    public boolean m557e() {
        return (this.f192b & 2) == 2;
    }

    /* renamed from: f */
    public long m558f() {
        return this.f194d;
    }

    /* renamed from: g */
    public boolean m559g() {
        return (this.f192b & 4) == 4;
    }

    /* renamed from: h */
    public int m560h() {
        return this.f195e;
    }

    /* renamed from: k */
    private void m553k() {
        this.f193c = 0;
        this.f194d = 0L;
        this.f195e = 0;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f196f;
        if (b != -1) {
            return b == 1;
        }
        this.f196f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f192b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f193c);
        }
        if ((this.f192b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f194d);
        }
        if ((this.f192b & 4) == 4) {
            codedOutputStream.writeInt32(3, this.f195e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f197g;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f192b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f193c) : 0;
            if ((this.f192b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt64Size(2, this.f194d);
            }
            if ((this.f192b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, this.f195e);
            }
            this.f197g = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0095x m549a(byte[] bArr) {
        return ((C0096y) newBuilder().mergeFrom(bArr)).m567i();
    }

    public static C0096y newBuilder() {
        return C0096y.m566h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0096y newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0096y m550a(C0095x c0095x) {
        return newBuilder().mergeFrom(c0095x);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0096y toBuilder() {
        return m550a(this);
    }

    static {
        f191a.m553k();
    }
}
