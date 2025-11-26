package com.sec.chaton.p016a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dx */
/* loaded from: classes.dex */
public final class C0381dx extends GeneratedMessageLite implements InterfaceC0383dz {

    /* renamed from: a */
    private static final C0381dx f1338a = new C0381dx(true);

    /* renamed from: b */
    private int f1339b;

    /* renamed from: c */
    private long f1340c;

    /* renamed from: d */
    private long f1341d;

    /* renamed from: e */
    private C0369dl f1342e;

    /* renamed from: f */
    private byte f1343f;

    /* renamed from: g */
    private int f1344g;

    private C0381dx(C0382dy c0382dy) {
        super(c0382dy);
        this.f1343f = (byte) -1;
        this.f1344g = -1;
    }

    private C0381dx(boolean z) {
        this.f1343f = (byte) -1;
        this.f1344g = -1;
    }

    /* renamed from: a */
    public static C0381dx m2660a() {
        return f1338a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0381dx getDefaultInstanceForType() {
        return f1338a;
    }

    /* renamed from: c */
    public boolean m2665c() {
        return (this.f1339b & 1) == 1;
    }

    /* renamed from: d */
    public long m2666d() {
        return this.f1340c;
    }

    /* renamed from: e */
    public boolean m2667e() {
        return (this.f1339b & 2) == 2;
    }

    /* renamed from: f */
    public long m2668f() {
        return this.f1341d;
    }

    /* renamed from: g */
    public boolean m2669g() {
        return (this.f1339b & 4) == 4;
    }

    /* renamed from: h */
    public C0369dl m2670h() {
        return this.f1342e;
    }

    /* renamed from: k */
    private void m2663k() {
        this.f1340c = 0L;
        this.f1341d = 0L;
        this.f1342e = C0369dl.m2485a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1343f;
        if (b != -1) {
            return b == 1;
        }
        this.f1343f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1339b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1340c);
        }
        if ((this.f1339b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f1341d);
        }
        if ((this.f1339b & 4) == 4) {
            codedOutputStream.writeMessage(3, this.f1342e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f1344g;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f1339b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f1340c) : 0;
            if ((this.f1339b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(2, this.f1341d);
            }
            if ((this.f1339b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(3, this.f1342e);
            }
            this.f1344g = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0382dy newBuilder() {
        return C0382dy.m2675j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0382dy newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0382dy m2661a(C0381dx c0381dx) {
        return newBuilder().mergeFrom(c0381dx);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0382dy toBuilder() {
        return m2661a(this);
    }

    static {
        f1338a.m2663k();
    }
}
