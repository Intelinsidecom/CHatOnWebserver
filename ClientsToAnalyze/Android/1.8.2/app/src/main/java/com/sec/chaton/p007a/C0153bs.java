package com.sec.chaton.p007a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bs */
/* loaded from: classes.dex */
public final class C0153bs extends GeneratedMessageLite implements InterfaceC0155bu {

    /* renamed from: a */
    private static final C0153bs f551a = new C0153bs(true);

    /* renamed from: b */
    private int f552b;

    /* renamed from: c */
    private long f553c;

    /* renamed from: d */
    private C0171cj f554d;

    /* renamed from: e */
    private long f555e;

    /* renamed from: f */
    private byte f556f;

    /* renamed from: g */
    private int f557g;

    private C0153bs(C0154bt c0154bt) {
        super(c0154bt);
        this.f556f = (byte) -1;
        this.f557g = -1;
    }

    private C0153bs(boolean z) {
        this.f556f = (byte) -1;
        this.f557g = -1;
    }

    /* renamed from: a */
    public static C0153bs m1260a() {
        return f551a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0153bs getDefaultInstanceForType() {
        return f551a;
    }

    /* renamed from: c */
    public boolean m1267c() {
        return (this.f552b & 1) == 1;
    }

    /* renamed from: d */
    public long m1268d() {
        return this.f553c;
    }

    /* renamed from: e */
    public boolean m1269e() {
        return (this.f552b & 2) == 2;
    }

    /* renamed from: f */
    public C0171cj m1270f() {
        return this.f554d;
    }

    /* renamed from: g */
    public boolean m1271g() {
        return (this.f552b & 4) == 4;
    }

    /* renamed from: h */
    public long m1272h() {
        return this.f555e;
    }

    /* renamed from: k */
    private void m1265k() {
        this.f553c = 0L;
        this.f554d = C0171cj.m1459a();
        this.f555e = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f556f;
        if (b != -1) {
            return b == 1;
        }
        this.f556f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f552b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f553c);
        }
        if ((this.f552b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f554d);
        }
        if ((this.f552b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f555e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f557g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f552b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f553c) : 0;
            if ((this.f552b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f554d);
            }
            if ((this.f552b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(3, this.f555e);
            }
            this.f557g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0153bs m1261a(byte[] bArr) {
        return ((C0154bt) newBuilder().mergeFrom(bArr)).m1279k();
    }

    public static C0154bt newBuilder() {
        return C0154bt.m1278j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0154bt newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0154bt m1262a(C0153bs c0153bs) {
        return newBuilder().mergeFrom(c0153bs);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0154bt toBuilder() {
        return m1262a(this);
    }

    static {
        f551a.m1265k();
    }
}
