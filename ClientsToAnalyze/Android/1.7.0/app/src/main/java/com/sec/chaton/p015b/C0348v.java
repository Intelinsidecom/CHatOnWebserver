package com.sec.chaton.p015b;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.v */
/* loaded from: classes.dex */
public final class C0348v extends GeneratedMessageLite implements InterfaceC0327cm {

    /* renamed from: a */
    private static final C0348v f1002a = new C0348v(true);

    /* renamed from: b */
    private int f1003b;

    /* renamed from: c */
    private long f1004c;

    /* renamed from: d */
    private C0313bz f1005d;

    /* renamed from: e */
    private long f1006e;

    /* renamed from: f */
    private byte f1007f;

    /* renamed from: g */
    private int f1008g;

    private C0348v(C0319ce c0319ce) {
        super(c0319ce);
        this.f1007f = (byte) -1;
        this.f1008g = -1;
    }

    private C0348v(boolean z) {
        this.f1007f = (byte) -1;
        this.f1008g = -1;
    }

    /* renamed from: a */
    public static C0348v m2000a() {
        return f1002a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0348v getDefaultInstanceForType() {
        return f1002a;
    }

    /* renamed from: c */
    public boolean m2005c() {
        return (this.f1003b & 1) == 1;
    }

    /* renamed from: d */
    public long m2006d() {
        return this.f1004c;
    }

    /* renamed from: e */
    public boolean m2007e() {
        return (this.f1003b & 2) == 2;
    }

    /* renamed from: f */
    public C0313bz m2008f() {
        return this.f1005d;
    }

    /* renamed from: g */
    public boolean m2009g() {
        return (this.f1003b & 4) == 4;
    }

    /* renamed from: h */
    public long m2010h() {
        return this.f1006e;
    }

    /* renamed from: k */
    private void m2003k() {
        this.f1004c = 0L;
        this.f1005d = C0313bz.m1619a();
        this.f1006e = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1007f;
        if (b != -1) {
            return b == 1;
        }
        this.f1007f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1003b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1004c);
        }
        if ((this.f1003b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f1005d);
        }
        if ((this.f1003b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f1006e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f1008g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f1003b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f1004c) : 0;
            if ((this.f1003b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f1005d);
            }
            if ((this.f1003b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(3, this.f1006e);
            }
            this.f1008g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0348v m2001a(byte[] bArr) {
        return ((C0319ce) newBuilder().mergeFrom(bArr)).m1704k();
    }

    public static C0319ce newBuilder() {
        return C0319ce.m1703j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0319ce newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0319ce m1999a(C0348v c0348v) {
        return newBuilder().mergeFrom(c0348v);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0319ce toBuilder() {
        return m1999a(this);
    }

    static {
        f1002a.m2003k();
    }
}
