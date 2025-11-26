package com.sec.p043a.p044a.p045a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.x */
/* loaded from: classes.dex */
public final class C0772x extends GeneratedMessageLite implements InterfaceC0774z {

    /* renamed from: a */
    private static final C0772x f1850a = new C0772x(true);

    /* renamed from: b */
    private int f1851b;

    /* renamed from: c */
    private int f1852c;

    /* renamed from: d */
    private long f1853d;

    /* renamed from: e */
    private int f1854e;

    /* renamed from: f */
    private byte f1855f;

    /* renamed from: g */
    private int f1856g;

    private C0772x(C0773y c0773y) {
        super(c0773y);
        this.f1855f = (byte) -1;
        this.f1856g = -1;
    }

    private C0772x(boolean z) {
        this.f1855f = (byte) -1;
        this.f1856g = -1;
    }

    /* renamed from: a */
    public static C0772x m2792a() {
        return f1850a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0772x getDefaultInstanceForType() {
        return f1850a;
    }

    /* renamed from: c */
    public boolean m2799c() {
        return (this.f1851b & 1) == 1;
    }

    /* renamed from: d */
    public int m2800d() {
        return this.f1852c;
    }

    /* renamed from: e */
    public boolean m2801e() {
        return (this.f1851b & 2) == 2;
    }

    /* renamed from: f */
    public long m2802f() {
        return this.f1853d;
    }

    /* renamed from: g */
    public boolean m2803g() {
        return (this.f1851b & 4) == 4;
    }

    /* renamed from: h */
    public int m2804h() {
        return this.f1854e;
    }

    /* renamed from: k */
    private void m2797k() {
        this.f1852c = 0;
        this.f1853d = 0L;
        this.f1854e = 0;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f1855f;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f1855f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1851b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f1852c);
        }
        if ((this.f1851b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f1853d);
        }
        if ((this.f1851b & 4) == 4) {
            codedOutputStream.writeInt32(3, this.f1854e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f1856g;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f1851b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f1852c) : 0;
            if ((this.f1851b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt64Size(2, this.f1853d);
            }
            if ((this.f1851b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, this.f1854e);
            }
            this.f1856g = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0772x m2793a(byte[] bArr) {
        return ((C0773y) newBuilder().mergeFrom(bArr)).m2811i();
    }

    public static C0773y newBuilder() {
        return C0773y.m2810h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0773y newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0773y m2794a(C0772x c0772x) {
        return newBuilder().mergeFrom(c0772x);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0773y toBuilder() {
        return m2794a(this);
    }

    static {
        f1850a.m2797k();
    }
}
