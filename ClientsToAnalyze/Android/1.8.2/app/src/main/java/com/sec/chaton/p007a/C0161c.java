package com.sec.chaton.p007a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.c */
/* loaded from: classes.dex */
public final class C0161c extends GeneratedMessageLite implements InterfaceC0178e {

    /* renamed from: a */
    private static final C0161c f586a = new C0161c(true);

    /* renamed from: b */
    private int f587b;

    /* renamed from: c */
    private long f588c;

    /* renamed from: d */
    private C0171cj f589d;

    /* renamed from: e */
    private byte f590e;

    /* renamed from: f */
    private int f591f;

    private C0161c(C0177d c0177d) {
        super(c0177d);
        this.f590e = (byte) -1;
        this.f591f = -1;
    }

    private C0161c(boolean z) {
        this.f590e = (byte) -1;
        this.f591f = -1;
    }

    /* renamed from: a */
    public static C0161c m1351a() {
        return f586a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0161c getDefaultInstanceForType() {
        return f586a;
    }

    /* renamed from: c */
    public boolean m1357c() {
        return (this.f587b & 1) == 1;
    }

    /* renamed from: d */
    public long m1358d() {
        return this.f588c;
    }

    /* renamed from: e */
    public boolean m1359e() {
        return (this.f587b & 2) == 2;
    }

    /* renamed from: f */
    public C0171cj m1360f() {
        return this.f589d;
    }

    /* renamed from: i */
    private void m1355i() {
        this.f588c = 0L;
        this.f589d = C0171cj.m1459a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f590e;
        if (b != -1) {
            return b == 1;
        }
        this.f590e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f587b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f588c);
        }
        if ((this.f587b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f589d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f591f;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f587b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f588c) : 0;
            if ((this.f587b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f589d);
            }
            this.f591f = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0161c m1352a(byte[] bArr) {
        return ((C0177d) newBuilder().mergeFrom(bArr)).m1514k();
    }

    public static C0177d newBuilder() {
        return C0177d.m1513j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0177d newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0177d m1354a(C0161c c0161c) {
        return newBuilder().mergeFrom(c0161c);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0177d toBuilder() {
        return m1354a(this);
    }

    static {
        f586a.m1355i();
    }
}
