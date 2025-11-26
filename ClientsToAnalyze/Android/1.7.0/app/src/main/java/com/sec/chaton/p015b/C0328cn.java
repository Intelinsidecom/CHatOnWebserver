package com.sec.chaton.p015b;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.cn */
/* loaded from: classes.dex */
public final class C0328cn extends GeneratedMessageLite implements InterfaceC0292be {

    /* renamed from: a */
    private static final C0328cn f927a = new C0328cn(true);

    /* renamed from: b */
    private int f928b;

    /* renamed from: c */
    private long f929c;

    /* renamed from: d */
    private C0313bz f930d;

    /* renamed from: e */
    private byte f931e;

    /* renamed from: f */
    private int f932f;

    private C0328cn(C0269ai c0269ai) {
        super(c0269ai);
        this.f931e = (byte) -1;
        this.f932f = -1;
    }

    private C0328cn(boolean z) {
        this.f931e = (byte) -1;
        this.f932f = -1;
    }

    /* renamed from: a */
    public static C0328cn m1791a() {
        return f927a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0328cn getDefaultInstanceForType() {
        return f927a;
    }

    /* renamed from: c */
    public boolean m1795c() {
        return (this.f928b & 1) == 1;
    }

    /* renamed from: d */
    public long m1796d() {
        return this.f929c;
    }

    /* renamed from: e */
    public boolean m1797e() {
        return (this.f928b & 2) == 2;
    }

    /* renamed from: f */
    public C0313bz m1798f() {
        return this.f930d;
    }

    /* renamed from: i */
    private void m1793i() {
        this.f929c = 0L;
        this.f930d = C0313bz.m1619a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f931e;
        if (b != -1) {
            return b == 1;
        }
        this.f931e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f928b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f929c);
        }
        if ((this.f928b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f930d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f932f;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f928b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f929c) : 0;
            if ((this.f928b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f930d);
            }
            this.f932f = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0328cn m1792a(byte[] bArr) {
        return ((C0269ai) newBuilder().mergeFrom(bArr)).m1124l();
    }

    public static C0269ai newBuilder() {
        return C0269ai.m1123k();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0269ai newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0269ai m1789a(C0328cn c0328cn) {
        return newBuilder().mergeFrom(c0328cn);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0269ai toBuilder() {
        return m1789a(this);
    }

    static {
        f927a.m1793i();
    }
}
