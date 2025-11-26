package com.sec.chaton.p046a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fk */
/* loaded from: classes.dex */
public final class C0938fk extends GeneratedMessageLite implements InterfaceC0940fm {

    /* renamed from: a */
    private static final C0938fk f2973a = new C0938fk(true);

    /* renamed from: b */
    private int f2974b;

    /* renamed from: c */
    private long f2975c;

    /* renamed from: d */
    private C0935fh f2976d;

    /* renamed from: e */
    private byte f2977e;

    /* renamed from: f */
    private int f2978f;

    private C0938fk(C0939fl c0939fl) {
        super(c0939fl);
        this.f2977e = (byte) -1;
        this.f2978f = -1;
    }

    private C0938fk(boolean z) {
        this.f2977e = (byte) -1;
        this.f2978f = -1;
    }

    /* renamed from: a */
    public static C0938fk m5271a() {
        return f2973a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0938fk getDefaultInstanceForType() {
        return f2973a;
    }

    /* renamed from: c */
    public boolean m5276c() {
        return (this.f2974b & 1) == 1;
    }

    /* renamed from: d */
    public long m5277d() {
        return this.f2975c;
    }

    /* renamed from: e */
    public boolean m5278e() {
        return (this.f2974b & 2) == 2;
    }

    /* renamed from: f */
    public C0935fh m5279f() {
        return this.f2976d;
    }

    /* renamed from: i */
    private void m5274i() {
        this.f2975c = 0L;
        this.f2976d = C0935fh.m5211a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2977e;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2977e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2974b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2975c);
        }
        if ((this.f2974b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f2976d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f2978f;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f2974b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f2975c) : 0;
            if ((this.f2974b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f2976d);
            }
            this.f2978f = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0938fk m5272a(byte[] bArr) {
        return ((C0939fl) newBuilder().mergeFrom(bArr)).m5286k();
    }

    public static C0939fl newBuilder() {
        return C0939fl.m5285j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0939fl newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0939fl m5273a(C0938fk c0938fk) {
        return newBuilder().mergeFrom(c0938fk);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0939fl toBuilder() {
        return m5273a(this);
    }

    static {
        f2973a.m5274i();
    }
}
