package com.sec.chaton.p016a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cl */
/* loaded from: classes.dex */
public final class C0342cl extends GeneratedMessageLite implements InterfaceC0344cn {

    /* renamed from: a */
    private static final C0342cl f1176a = new C0342cl(true);

    /* renamed from: b */
    private int f1177b;

    /* renamed from: c */
    private long f1178c;

    /* renamed from: d */
    private C0369dl f1179d;

    /* renamed from: e */
    private long f1180e;

    /* renamed from: f */
    private byte f1181f;

    /* renamed from: g */
    private int f1182g;

    private C0342cl(C0343cm c0343cm) {
        super(c0343cm);
        this.f1181f = (byte) -1;
        this.f1182g = -1;
    }

    private C0342cl(boolean z) {
        this.f1181f = (byte) -1;
        this.f1182g = -1;
    }

    /* renamed from: a */
    public static C0342cl m2186a() {
        return f1176a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0342cl getDefaultInstanceForType() {
        return f1176a;
    }

    /* renamed from: c */
    public boolean m2193c() {
        return (this.f1177b & 1) == 1;
    }

    /* renamed from: d */
    public long m2194d() {
        return this.f1178c;
    }

    /* renamed from: e */
    public boolean m2195e() {
        return (this.f1177b & 2) == 2;
    }

    /* renamed from: f */
    public C0369dl m2196f() {
        return this.f1179d;
    }

    /* renamed from: g */
    public boolean m2197g() {
        return (this.f1177b & 4) == 4;
    }

    /* renamed from: h */
    public long m2198h() {
        return this.f1180e;
    }

    /* renamed from: k */
    private void m2191k() {
        this.f1178c = 0L;
        this.f1179d = C0369dl.m2485a();
        this.f1180e = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1181f;
        if (b != -1) {
            return b == 1;
        }
        this.f1181f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1177b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1178c);
        }
        if ((this.f1177b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f1179d);
        }
        if ((this.f1177b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f1180e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f1182g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f1177b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f1178c) : 0;
            if ((this.f1177b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f1179d);
            }
            if ((this.f1177b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(3, this.f1180e);
            }
            this.f1182g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0342cl m2187a(byte[] bArr) {
        return ((C0343cm) newBuilder().mergeFrom(bArr)).m2205k();
    }

    public static C0343cm newBuilder() {
        return C0343cm.m2204j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0343cm newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0343cm m2188a(C0342cl c0342cl) {
        return newBuilder().mergeFrom(c0342cl);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0343cm toBuilder() {
        return m2188a(this);
    }

    static {
        f1176a.m2191k();
    }
}
