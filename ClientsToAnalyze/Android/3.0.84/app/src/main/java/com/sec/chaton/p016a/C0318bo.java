package com.sec.chaton.p016a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bo */
/* loaded from: classes.dex */
public final class C0318bo extends GeneratedMessageLite implements InterfaceC0320bq {

    /* renamed from: a */
    private static final C0318bo f1058a = new C0318bo(true);

    /* renamed from: b */
    private int f1059b;

    /* renamed from: c */
    private long f1060c;

    /* renamed from: d */
    private EnumC0316bm f1061d;

    /* renamed from: e */
    private C0369dl f1062e;

    /* renamed from: f */
    private byte f1063f;

    /* renamed from: g */
    private int f1064g;

    private C0318bo(C0319bp c0319bp) {
        super(c0319bp);
        this.f1063f = (byte) -1;
        this.f1064g = -1;
    }

    private C0318bo(boolean z) {
        this.f1063f = (byte) -1;
        this.f1064g = -1;
    }

    /* renamed from: a */
    public static C0318bo m1854a() {
        return f1058a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0318bo getDefaultInstanceForType() {
        return f1058a;
    }

    /* renamed from: c */
    public boolean m1860c() {
        return (this.f1059b & 1) == 1;
    }

    /* renamed from: d */
    public long m1861d() {
        return this.f1060c;
    }

    /* renamed from: e */
    public boolean m1862e() {
        return (this.f1059b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0316bm m1863f() {
        return this.f1061d;
    }

    /* renamed from: g */
    public boolean m1864g() {
        return (this.f1059b & 4) == 4;
    }

    /* renamed from: h */
    public C0369dl m1865h() {
        return this.f1062e;
    }

    /* renamed from: k */
    private void m1858k() {
        this.f1060c = 0L;
        this.f1061d = EnumC0316bm.CLOSE;
        this.f1062e = C0369dl.m2485a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1063f;
        if (b != -1) {
            return b == 1;
        }
        this.f1063f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1059b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1060c);
        }
        if ((this.f1059b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f1061d.getNumber());
        }
        if ((this.f1059b & 4) == 4) {
            codedOutputStream.writeMessage(3, this.f1062e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f1064g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f1059b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f1060c) : 0;
            if ((this.f1059b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f1061d.getNumber());
            }
            if ((this.f1059b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(3, this.f1062e);
            }
            this.f1064g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0318bo m1855a(byte[] bArr) {
        return ((C0319bp) newBuilder().mergeFrom(bArr)).m1872m();
    }

    public static C0319bp newBuilder() {
        return C0319bp.m1871l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0319bp newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0319bp m1856a(C0318bo c0318bo) {
        return newBuilder().mergeFrom(c0318bo);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0319bp toBuilder() {
        return m1856a(this);
    }

    static {
        f1058a.m1858k();
    }
}
