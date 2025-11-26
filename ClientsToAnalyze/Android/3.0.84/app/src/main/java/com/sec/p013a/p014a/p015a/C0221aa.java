package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.aa */
/* loaded from: classes.dex */
public final class C0221aa extends GeneratedMessageLite implements InterfaceC0223ac {

    /* renamed from: a */
    private static final C0221aa f453a = new C0221aa(true);

    /* renamed from: b */
    private int f454b;

    /* renamed from: c */
    private int f455c;

    /* renamed from: d */
    private long f456d;

    /* renamed from: e */
    private int f457e;

    /* renamed from: f */
    private byte f458f;

    /* renamed from: g */
    private int f459g;

    private C0221aa(C0222ab c0222ab) {
        super(c0222ab);
        this.f458f = (byte) -1;
        this.f459g = -1;
    }

    private C0221aa(boolean z) {
        this.f458f = (byte) -1;
        this.f459g = -1;
    }

    /* renamed from: a */
    public static C0221aa m581a() {
        return f453a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0221aa getDefaultInstanceForType() {
        return f453a;
    }

    /* renamed from: c */
    public boolean m588c() {
        return (this.f454b & 1) == 1;
    }

    /* renamed from: d */
    public int m589d() {
        return this.f455c;
    }

    /* renamed from: e */
    public boolean m590e() {
        return (this.f454b & 2) == 2;
    }

    /* renamed from: f */
    public long m591f() {
        return this.f456d;
    }

    /* renamed from: g */
    public boolean m592g() {
        return (this.f454b & 4) == 4;
    }

    /* renamed from: h */
    public int m593h() {
        return this.f457e;
    }

    /* renamed from: k */
    private void m586k() {
        this.f455c = 0;
        this.f456d = 0L;
        this.f457e = 0;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f458f;
        if (b != -1) {
            return b == 1;
        }
        this.f458f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f454b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f455c);
        }
        if ((this.f454b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f456d);
        }
        if ((this.f454b & 4) == 4) {
            codedOutputStream.writeInt32(3, this.f457e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f459g;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f454b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f455c) : 0;
            if ((this.f454b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt64Size(2, this.f456d);
            }
            if ((this.f454b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, this.f457e);
            }
            this.f459g = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0221aa m582a(byte[] bArr) {
        return ((C0222ab) newBuilder().mergeFrom(bArr)).m600i();
    }

    public static C0222ab newBuilder() {
        return C0222ab.m599h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0222ab newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0222ab m583a(C0221aa c0221aa) {
        return newBuilder().mergeFrom(c0221aa);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0222ab toBuilder() {
        return m583a(this);
    }

    static {
        f453a.m586k();
    }
}
