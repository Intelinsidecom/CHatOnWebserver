package com.sec.chaton.p046a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dm */
/* loaded from: classes.dex */
public final class C0886dm extends GeneratedMessageLite implements InterfaceC0888do {

    /* renamed from: a */
    private static final C0886dm f2723a = new C0886dm(true);

    /* renamed from: b */
    private int f2724b;

    /* renamed from: c */
    private long f2725c;

    /* renamed from: d */
    private C0935fh f2726d;

    /* renamed from: e */
    private byte f2727e;

    /* renamed from: f */
    private int f2728f;

    private C0886dm(C0887dn c0887dn) {
        super(c0887dn);
        this.f2727e = (byte) -1;
        this.f2728f = -1;
    }

    private C0886dm(boolean z) {
        this.f2727e = (byte) -1;
        this.f2728f = -1;
    }

    /* renamed from: a */
    public static C0886dm m4572a() {
        return f2723a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0886dm getDefaultInstanceForType() {
        return f2723a;
    }

    /* renamed from: c */
    public boolean m4578c() {
        return (this.f2724b & 1) == 1;
    }

    /* renamed from: d */
    public long m4579d() {
        return this.f2725c;
    }

    /* renamed from: e */
    public boolean m4580e() {
        return (this.f2724b & 2) == 2;
    }

    /* renamed from: f */
    public C0935fh m4581f() {
        return this.f2726d;
    }

    /* renamed from: i */
    private void m4576i() {
        this.f2725c = 0L;
        this.f2726d = C0935fh.m5211a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2727e;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2727e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2724b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2725c);
        }
        if ((this.f2724b & 2) == 2) {
            codedOutputStream.writeMessage(2, this.f2726d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt64Size = this.f2728f;
        if (iComputeInt64Size == -1) {
            iComputeInt64Size = (this.f2724b & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.f2725c) : 0;
            if ((this.f2724b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeMessageSize(2, this.f2726d);
            }
            this.f2728f = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0886dm m4573a(byte[] bArr) {
        return ((C0887dn) newBuilder().mergeFrom(bArr)).m4588k();
    }

    public static C0887dn newBuilder() {
        return C0887dn.m4587j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0887dn newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0887dn m4574a(C0886dm c0886dm) {
        return newBuilder().mergeFrom(c0886dm);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0887dn toBuilder() {
        return m4574a(this);
    }

    static {
        f2723a.m4576i();
    }
}
