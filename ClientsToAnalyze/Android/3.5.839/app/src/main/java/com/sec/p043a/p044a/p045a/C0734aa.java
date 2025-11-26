package com.sec.p043a.p044a.p045a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.aa */
/* loaded from: classes.dex */
public final class C0734aa extends GeneratedMessageLite implements InterfaceC0736ac {

    /* renamed from: a */
    private static final C0734aa f1689a = new C0734aa(true);

    /* renamed from: b */
    private int f1690b;

    /* renamed from: c */
    private int f1691c;

    /* renamed from: d */
    private long f1692d;

    /* renamed from: e */
    private int f1693e;

    /* renamed from: f */
    private byte f1694f;

    /* renamed from: g */
    private int f1695g;

    private C0734aa(C0735ab c0735ab) {
        super(c0735ab);
        this.f1694f = (byte) -1;
        this.f1695g = -1;
    }

    private C0734aa(boolean z) {
        this.f1694f = (byte) -1;
        this.f1695g = -1;
    }

    /* renamed from: a */
    public static C0734aa m2313a() {
        return f1689a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0734aa getDefaultInstanceForType() {
        return f1689a;
    }

    /* renamed from: c */
    public boolean m2320c() {
        return (this.f1690b & 1) == 1;
    }

    /* renamed from: d */
    public int m2321d() {
        return this.f1691c;
    }

    /* renamed from: e */
    public boolean m2322e() {
        return (this.f1690b & 2) == 2;
    }

    /* renamed from: f */
    public long m2323f() {
        return this.f1692d;
    }

    /* renamed from: g */
    public boolean m2324g() {
        return (this.f1690b & 4) == 4;
    }

    /* renamed from: h */
    public int m2325h() {
        return this.f1693e;
    }

    /* renamed from: k */
    private void m2318k() {
        this.f1691c = 0;
        this.f1692d = 0L;
        this.f1693e = 0;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f1694f;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f1694f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f1690b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f1691c);
        }
        if ((this.f1690b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f1692d);
        }
        if ((this.f1690b & 4) == 4) {
            codedOutputStream.writeInt32(3, this.f1693e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f1695g;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f1690b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f1691c) : 0;
            if ((this.f1690b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt64Size(2, this.f1692d);
            }
            if ((this.f1690b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, this.f1693e);
            }
            this.f1695g = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0734aa m2314a(byte[] bArr) {
        return ((C0735ab) newBuilder().mergeFrom(bArr)).m2332i();
    }

    public static C0735ab newBuilder() {
        return C0735ab.m2331h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0735ab newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0735ab m2315a(C0734aa c0734aa) {
        return newBuilder().mergeFrom(c0734aa);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0735ab toBuilder() {
        return m2315a(this);
    }

    static {
        f1689a.m2318k();
    }
}
