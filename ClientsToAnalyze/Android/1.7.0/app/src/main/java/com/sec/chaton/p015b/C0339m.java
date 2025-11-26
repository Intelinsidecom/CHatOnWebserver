package com.sec.chaton.p015b;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.m */
/* loaded from: classes.dex */
public final class C0339m extends GeneratedMessageLite implements InterfaceC0336j {

    /* renamed from: a */
    private static final C0339m f976a = new C0339m(true);

    /* renamed from: b */
    private int f977b;

    /* renamed from: c */
    private long f978c;

    /* renamed from: d */
    private C0313bz f979d;

    /* renamed from: e */
    private byte f980e;

    /* renamed from: f */
    private int f981f;

    private C0339m(C0306bs c0306bs) {
        super(c0306bs);
        this.f980e = (byte) -1;
        this.f981f = -1;
    }

    private C0339m(boolean z) {
        this.f980e = (byte) -1;
        this.f981f = -1;
    }

    /* renamed from: a */
    public static C0339m m1935a() {
        return f976a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0339m getDefaultInstanceForType() {
        return f976a;
    }

    /* renamed from: c */
    public boolean m1939c() {
        return (this.f977b & 1) == 1;
    }

    /* renamed from: d */
    public long m1940d() {
        return this.f978c;
    }

    /* renamed from: e */
    public boolean m1941e() {
        return (this.f977b & 2) == 2;
    }

    /* renamed from: f */
    public C0313bz m1942f() {
        return this.f979d;
    }

    /* renamed from: i */
    private void m1937i() {
        this.f978c = 0L;
        this.f979d = C0313bz.m1619a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f980e;
        if (b != -1) {
            return b == 1;
        }
        this.f980e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f977b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f978c);
        }
        if ((this.f977b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f979d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f981f;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f977b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f978c) : 0;
            if ((this.f977b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f979d);
            }
            this.f981f = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0339m m1936a(byte[] bArr) {
        return ((C0306bs) newBuilder().mergeFrom(bArr)).m1523k();
    }

    public static C0306bs newBuilder() {
        return C0306bs.m1522j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0306bs newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0306bs m1933a(C0339m c0339m) {
        return newBuilder().mergeFrom(c0339m);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0306bs toBuilder() {
        return m1933a(this);
    }

    static {
        f976a.m1937i();
    }
}
