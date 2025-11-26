package com.sec.chaton.p016a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.l */
/* loaded from: classes.dex */
public final class C0397l extends GeneratedMessageLite implements InterfaceC0399n {

    /* renamed from: a */
    private static final C0397l f1413a = new C0397l(true);

    /* renamed from: b */
    private int f1414b;

    /* renamed from: c */
    private long f1415c;

    /* renamed from: d */
    private C0369dl f1416d;

    /* renamed from: e */
    private byte f1417e;

    /* renamed from: f */
    private int f1418f;

    private C0397l(C0398m c0398m) {
        super(c0398m);
        this.f1417e = (byte) -1;
        this.f1418f = -1;
    }

    private C0397l(boolean z) {
        this.f1417e = (byte) -1;
        this.f1418f = -1;
    }

    /* renamed from: a */
    public static C0397l m2869a() {
        return f1413a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0397l getDefaultInstanceForType() {
        return f1413a;
    }

    /* renamed from: c */
    public boolean m2874c() {
        return (this.f1414b & 1) == 1;
    }

    /* renamed from: d */
    public long m2875d() {
        return this.f1415c;
    }

    /* renamed from: e */
    public boolean m2876e() {
        return (this.f1414b & 2) == 2;
    }

    /* renamed from: f */
    public C0369dl m2877f() {
        return this.f1416d;
    }

    /* renamed from: i */
    private void m2872i() {
        this.f1415c = 0L;
        this.f1416d = C0369dl.m2485a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1417e;
        if (b != -1) {
            return b == 1;
        }
        this.f1417e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1414b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f1415c);
        }
        if ((this.f1414b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f1416d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f1418f;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f1414b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f1415c) : 0;
            if ((this.f1414b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f1416d);
            }
            this.f1418f = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0397l m2870a(byte[] bArr) {
        return ((C0398m) newBuilder().mergeFrom(bArr)).m2884l();
    }

    public static C0398m newBuilder() {
        return C0398m.m2883k();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0398m newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0398m m2871a(C0397l c0397l) {
        return newBuilder().mergeFrom(c0397l);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0398m toBuilder() {
        return m2871a(this);
    }

    static {
        f1413a.m2872i();
    }
}
