package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.aa */
/* loaded from: classes.dex */
public final class C0057aa extends GeneratedMessageLite implements InterfaceC0059ac {

    /* renamed from: a */
    private static final C0057aa f30a = new C0057aa(true);

    /* renamed from: b */
    private int f31b;

    /* renamed from: c */
    private int f32c;

    /* renamed from: d */
    private long f33d;

    /* renamed from: e */
    private int f34e;

    /* renamed from: f */
    private byte f35f;

    /* renamed from: g */
    private int f36g;

    private C0057aa(C0058ab c0058ab) {
        super(c0058ab);
        this.f35f = (byte) -1;
        this.f36g = -1;
    }

    private C0057aa(boolean z) {
        this.f35f = (byte) -1;
        this.f36g = -1;
    }

    /* renamed from: a */
    public static C0057aa m69a() {
        return f30a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0057aa getDefaultInstanceForType() {
        return f30a;
    }

    /* renamed from: c */
    public boolean m76c() {
        return (this.f31b & 1) == 1;
    }

    /* renamed from: d */
    public int m77d() {
        return this.f32c;
    }

    /* renamed from: e */
    public boolean m78e() {
        return (this.f31b & 2) == 2;
    }

    /* renamed from: f */
    public long m79f() {
        return this.f33d;
    }

    /* renamed from: g */
    public boolean m80g() {
        return (this.f31b & 4) == 4;
    }

    /* renamed from: h */
    public int m81h() {
        return this.f34e;
    }

    /* renamed from: k */
    private void m74k() {
        this.f32c = 0;
        this.f33d = 0L;
        this.f34e = 0;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f35f;
        if (b != -1) {
            return b == 1;
        }
        this.f35f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f31b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f32c);
        }
        if ((this.f31b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f33d);
        }
        if ((this.f31b & 4) == 4) {
            codedOutputStream.writeInt32(3, this.f34e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f36g;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f31b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f32c) : 0;
            if ((this.f31b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt64Size(2, this.f33d);
            }
            if ((this.f31b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, this.f34e);
            }
            this.f36g = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0057aa m70a(byte[] bArr) {
        return ((C0058ab) newBuilder().mergeFrom(bArr)).m88i();
    }

    public static C0058ab newBuilder() {
        return C0058ab.m87h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0058ab newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0058ab m71a(C0057aa c0057aa) {
        return newBuilder().mergeFrom(c0057aa);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0058ab toBuilder() {
        return m71a(this);
    }

    static {
        f30a.m74k();
    }
}
