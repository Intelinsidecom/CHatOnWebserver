package com.sec.chaton.p016a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.c */
/* loaded from: classes.dex */
public final class C0330c extends GeneratedMessageLite implements InterfaceC0384e {

    /* renamed from: a */
    private static final C0330c f1105a = new C0330c(true);

    /* renamed from: b */
    private int f1106b;

    /* renamed from: c */
    private long f1107c;

    /* renamed from: d */
    private C0369dl f1108d;

    /* renamed from: e */
    private byte f1109e;

    /* renamed from: f */
    private int f1110f;

    private C0330c(C0357d c0357d) {
        super(c0357d);
        this.f1109e = (byte) -1;
        this.f1110f = -1;
    }

    private C0330c(boolean z) {
        this.f1109e = (byte) -1;
        this.f1110f = -1;
    }

    /* renamed from: a */
    public static C0330c m1988a() {
        return f1105a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0330c getDefaultInstanceForType() {
        return f1105a;
    }

    /* renamed from: c */
    public boolean m1994c() {
        return (this.f1106b & 1) == 1;
    }

    /* renamed from: d */
    public long m1995d() {
        return this.f1107c;
    }

    /* renamed from: e */
    public boolean m1996e() {
        return (this.f1106b & 2) == 2;
    }

    /* renamed from: f */
    public C0369dl m1997f() {
        return this.f1108d;
    }

    /* renamed from: i */
    private void m1992i() {
        this.f1107c = 0L;
        this.f1108d = C0369dl.m2485a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1109e;
        if (b != -1) {
            return b == 1;
        }
        this.f1109e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1106b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1107c);
        }
        if ((this.f1106b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f1108d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f1110f;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f1106b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f1107c) : 0;
            if ((this.f1106b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f1108d);
            }
            this.f1110f = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0330c m1989a(byte[] bArr) {
        return ((C0357d) newBuilder().mergeFrom(bArr)).m2373k();
    }

    public static C0357d newBuilder() {
        return C0357d.m2372j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0357d newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0357d m1990a(C0330c c0330c) {
        return newBuilder().mergeFrom(c0330c);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0357d toBuilder() {
        return m1990a(this);
    }

    static {
        f1105a.m1992i();
    }
}
