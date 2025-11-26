package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.x */
/* loaded from: classes.dex */
public final class C0259x extends GeneratedMessageLite implements InterfaceC0261z {

    /* renamed from: a */
    private static final C0259x f614a = new C0259x(true);

    /* renamed from: b */
    private int f615b;

    /* renamed from: c */
    private int f616c;

    /* renamed from: d */
    private long f617d;

    /* renamed from: e */
    private int f618e;

    /* renamed from: f */
    private byte f619f;

    /* renamed from: g */
    private int f620g;

    private C0259x(C0260y c0260y) {
        super(c0260y);
        this.f619f = (byte) -1;
        this.f620g = -1;
    }

    private C0259x(boolean z) {
        this.f619f = (byte) -1;
        this.f620g = -1;
    }

    /* renamed from: a */
    public static C0259x m1060a() {
        return f614a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0259x getDefaultInstanceForType() {
        return f614a;
    }

    /* renamed from: c */
    public boolean m1067c() {
        return (this.f615b & 1) == 1;
    }

    /* renamed from: d */
    public int m1068d() {
        return this.f616c;
    }

    /* renamed from: e */
    public boolean m1069e() {
        return (this.f615b & 2) == 2;
    }

    /* renamed from: f */
    public long m1070f() {
        return this.f617d;
    }

    /* renamed from: g */
    public boolean m1071g() {
        return (this.f615b & 4) == 4;
    }

    /* renamed from: h */
    public int m1072h() {
        return this.f618e;
    }

    /* renamed from: k */
    private void m1065k() {
        this.f616c = 0;
        this.f617d = 0L;
        this.f618e = 0;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f619f;
        if (b != -1) {
            return b == 1;
        }
        this.f619f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f615b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f616c);
        }
        if ((this.f615b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f617d);
        }
        if ((this.f615b & 4) == 4) {
            codedOutputStream.writeInt32(3, this.f618e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f620g;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f615b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f616c) : 0;
            if ((this.f615b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt64Size(2, this.f617d);
            }
            if ((this.f615b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, this.f618e);
            }
            this.f620g = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0259x m1061a(byte[] bArr) {
        return ((C0260y) newBuilder().mergeFrom(bArr)).m1079i();
    }

    public static C0260y newBuilder() {
        return C0260y.m1078h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0260y newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0260y m1062a(C0259x c0259x) {
        return newBuilder().mergeFrom(c0259x);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0260y toBuilder() {
        return m1062a(this);
    }

    static {
        f614a.m1065k();
    }
}
