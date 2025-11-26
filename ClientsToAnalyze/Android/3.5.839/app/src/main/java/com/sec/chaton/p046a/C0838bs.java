package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bs */
/* loaded from: classes.dex */
public final class C0838bs extends GeneratedMessageLite.Builder<C0837br, C0838bs> implements InterfaceC0839bt {

    /* renamed from: a */
    private int f2427a;

    /* renamed from: b */
    private long f2428b;

    /* renamed from: c */
    private EnumC0835bp f2429c = EnumC0835bp.CLOSE;

    /* renamed from: d */
    private C0935fh f2430d = C0935fh.m5211a();

    private C0838bs() {
        m3746k();
    }

    /* renamed from: k */
    private void m3746k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0838bs m3747l() {
        return new C0838bs();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0838bs clear() {
        super.clear();
        this.f2428b = 0L;
        this.f2427a &= -2;
        this.f2429c = EnumC0835bp.CLOSE;
        this.f2427a &= -3;
        this.f2430d = C0935fh.m5211a();
        this.f2427a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0838bs mo19949clone() {
        return m3747l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0837br getDefaultInstanceForType() {
        return C0837br.m3730a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0837br build() {
        C0837br c0837brBuildPartial = buildPartial();
        if (!c0837brBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0837brBuildPartial);
        }
        return c0837brBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0837br m3748m() throws InvalidProtocolBufferException {
        C0837br c0837brBuildPartial = buildPartial();
        if (!c0837brBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0837brBuildPartial).asInvalidProtocolBufferException();
        }
        return c0837brBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0837br buildPartial() {
        C0837br c0837br = new C0837br(this);
        int i = this.f2427a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0837br.f2422c = this.f2428b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0837br.f2423d = this.f2429c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0837br.f2424e = this.f2430d;
        c0837br.f2421b = i2;
        return c0837br;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0838bs mergeFrom(C0837br c0837br) {
        if (c0837br != C0837br.m3730a()) {
            if (c0837br.m3736c()) {
                m3750a(c0837br.m3737d());
            }
            if (c0837br.m3738e()) {
                m3752a(c0837br.m3739f());
            }
            if (c0837br.m3740g()) {
                m3756b(c0837br.m3741h());
            }
        }
        return this;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0838bs mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2427a |= 1;
                    this.f2428b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0835bp enumC0835bpM3725a = EnumC0835bp.m3725a(codedInputStream.readEnum());
                    if (enumC0835bpM3725a == null) {
                        break;
                    } else {
                        this.f2427a |= 2;
                        this.f2429c = enumC0835bpM3725a;
                        break;
                    }
                case 26:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m3762h()) {
                        c0936fiNewBuilder.mergeFrom(m3763i());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m3754a(c0936fiNewBuilder.buildPartial());
                    break;
                default:
                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this;
    }

    /* renamed from: f */
    public long m3760f() {
        return this.f2428b;
    }

    /* renamed from: a */
    public C0838bs m3750a(long j) {
        this.f2427a |= 1;
        this.f2428b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0835bp m3761g() {
        return this.f2429c;
    }

    /* renamed from: a */
    public C0838bs m3752a(EnumC0835bp enumC0835bp) {
        if (enumC0835bp == null) {
            throw new NullPointerException();
        }
        this.f2427a |= 2;
        this.f2429c = enumC0835bp;
        return this;
    }

    /* renamed from: h */
    public boolean m3762h() {
        return (this.f2427a & 4) == 4;
    }

    /* renamed from: i */
    public C0935fh m3763i() {
        return this.f2430d;
    }

    /* renamed from: a */
    public C0838bs m3754a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f2430d = c0935fh;
        this.f2427a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0838bs m3756b(C0935fh c0935fh) {
        if ((this.f2427a & 4) == 4 && this.f2430d != C0935fh.m5211a()) {
            this.f2430d = C0935fh.m5212a(this.f2430d).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f2430d = c0935fh;
        }
        this.f2427a |= 4;
        return this;
    }
}
