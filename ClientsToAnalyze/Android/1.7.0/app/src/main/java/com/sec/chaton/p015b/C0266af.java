package com.sec.chaton.p015b;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.af */
/* loaded from: classes.dex */
public final class C0266af extends GeneratedMessageLite implements InterfaceC0296bi {

    /* renamed from: a */
    private static final C0266af f667a = new C0266af(true);

    /* renamed from: b */
    private int f668b;

    /* renamed from: c */
    private long f669c;

    /* renamed from: d */
    private EnumC0341o f670d;

    /* renamed from: e */
    private C0313bz f671e;

    /* renamed from: f */
    private byte f672f;

    /* renamed from: g */
    private int f673g;

    private C0266af(C0321cg c0321cg) {
        super(c0321cg);
        this.f672f = (byte) -1;
        this.f673g = -1;
    }

    private C0266af(boolean z) {
        this.f672f = (byte) -1;
        this.f673g = -1;
    }

    /* renamed from: a */
    public static C0266af m1037a() {
        return f667a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0266af getDefaultInstanceForType() {
        return f667a;
    }

    /* renamed from: c */
    public boolean m1044c() {
        return (this.f668b & 1) == 1;
    }

    /* renamed from: d */
    public long m1045d() {
        return this.f669c;
    }

    /* renamed from: e */
    public boolean m1046e() {
        return (this.f668b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0341o m1047f() {
        return this.f670d;
    }

    /* renamed from: g */
    public boolean m1048g() {
        return (this.f668b & 4) == 4;
    }

    /* renamed from: h */
    public C0313bz m1049h() {
        return this.f671e;
    }

    /* renamed from: k */
    private void m1042k() {
        this.f669c = 0L;
        this.f670d = EnumC0341o.CLOSE;
        this.f671e = C0313bz.m1619a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f672f;
        if (b != -1) {
            return b == 1;
        }
        this.f672f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f668b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f669c);
        }
        if ((this.f668b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f670d.getNumber());
        }
        if ((this.f668b & 4) == 4) {
            codedOutputStream.writeMessage(3, this.f671e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f673g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f668b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f669c) : 0;
            if ((this.f668b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeEnumSize(2, this.f670d.getNumber());
            }
            if ((this.f668b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(3, this.f671e);
            }
            this.f673g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0266af m1038a(byte[] bArr) {
        return ((C0321cg) newBuilder().mergeFrom(bArr)).m1722m();
    }

    public static C0321cg newBuilder() {
        return C0321cg.m1721l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0321cg newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0321cg m1040a(C0266af c0266af) {
        return newBuilder().mergeFrom(c0266af);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0321cg toBuilder() {
        return m1040a(this);
    }

    static {
        f667a.m1042k();
    }
}
