package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.m */
/* loaded from: classes.dex */
public final class C0094m extends GeneratedMessageLite implements InterfaceC0078al {

    /* renamed from: a */
    private static final C0094m f153a = new C0094m(true);

    /* renamed from: b */
    private int f154b;

    /* renamed from: c */
    private int f155c;

    /* renamed from: d */
    private long f156d;

    /* renamed from: e */
    private int f157e;

    /* renamed from: f */
    private byte f158f;

    /* renamed from: g */
    private int f159g;

    private C0094m(C0072af c0072af) {
        super(c0072af);
        this.f158f = (byte) -1;
        this.f159g = -1;
    }

    private C0094m(boolean z) {
        this.f158f = (byte) -1;
        this.f159g = -1;
    }

    /* renamed from: a */
    public static C0094m m428a() {
        return f153a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0094m getDefaultInstanceForType() {
        return f153a;
    }

    /* renamed from: c */
    public boolean m434c() {
        return (this.f154b & 1) == 1;
    }

    /* renamed from: d */
    public int m435d() {
        return this.f155c;
    }

    /* renamed from: e */
    public boolean m436e() {
        return (this.f154b & 2) == 2;
    }

    /* renamed from: f */
    public long m437f() {
        return this.f156d;
    }

    /* renamed from: g */
    public boolean m438g() {
        return (this.f154b & 4) == 4;
    }

    /* renamed from: h */
    public int m439h() {
        return this.f157e;
    }

    /* renamed from: k */
    private void m432k() {
        this.f155c = 0;
        this.f156d = 0L;
        this.f157e = 0;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f158f;
        if (b != -1) {
            return b == 1;
        }
        this.f158f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f154b & 1) == 1) {
            codedOutputStream.writeInt32(1, this.f155c);
        }
        if ((this.f154b & 2) == 2) {
            codedOutputStream.writeInt64(2, this.f156d);
        }
        if ((this.f154b & 4) == 4) {
            codedOutputStream.writeInt32(3, this.f157e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f159g;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f154b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.f155c) : 0;
            if ((this.f154b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt64Size(2, this.f156d);
            }
            if ((this.f154b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(3, this.f157e);
            }
            this.f159g = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0094m m429a(byte[] bArr) {
        return ((C0072af) newBuilder().mergeFrom(bArr)).m186i();
    }

    public static C0072af newBuilder() {
        return C0072af.m185h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C0072af newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0072af m427a(C0094m c0094m) {
        return newBuilder().mergeFrom(c0094m);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0072af toBuilder() {
        return m427a(this);
    }

    static {
        f153a.m432k();
    }
}
