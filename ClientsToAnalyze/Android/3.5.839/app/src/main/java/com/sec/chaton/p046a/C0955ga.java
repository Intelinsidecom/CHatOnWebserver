package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ga */
/* loaded from: classes.dex */
public final class C0955ga extends GeneratedMessageLite.Builder<C0953fz, C0955ga> implements InterfaceC0956gb {

    /* renamed from: a */
    private int f3070a;

    /* renamed from: b */
    private long f3071b;

    /* renamed from: c */
    private long f3072c;

    /* renamed from: d */
    private C0935fh f3073d = C0935fh.m5211a();

    private C0955ga() {
        m5537i();
    }

    /* renamed from: i */
    private void m5537i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0955ga m5538j() {
        return new C0955ga();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0955ga clear() {
        super.clear();
        this.f3071b = 0L;
        this.f3070a &= -2;
        this.f3072c = 0L;
        this.f3070a &= -3;
        this.f3073d = C0935fh.m5211a();
        this.f3070a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0955ga mo19949clone() {
        return m5538j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0953fz getDefaultInstanceForType() {
        return C0953fz.m5497a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0953fz build() {
        C0953fz c0953fzBuildPartial = buildPartial();
        if (!c0953fzBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0953fzBuildPartial);
        }
        return c0953fzBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0953fz buildPartial() {
        C0953fz c0953fz = new C0953fz(this);
        int i = this.f3070a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0953fz.f3054c = this.f3071b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0953fz.f3055d = this.f3072c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0953fz.f3056e = this.f3073d;
        c0953fz.f3053b = i2;
        return c0953fz;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0955ga mergeFrom(C0953fz c0953fz) {
        if (c0953fz != C0953fz.m5497a()) {
            if (c0953fz.m5502c()) {
                m5540a(c0953fz.m5503d());
            }
            if (c0953fz.m5504e()) {
                m5545b(c0953fz.m5505f());
            }
            if (c0953fz.m5506g()) {
                m5546b(c0953fz.m5507h());
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
    public C0955ga mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f3070a |= 1;
                    this.f3071b = codedInputStream.readInt64();
                    break;
                case 16:
                    this.f3070a |= 2;
                    this.f3072c = codedInputStream.readInt64();
                    break;
                case 26:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m5550f()) {
                        c0936fiNewBuilder.mergeFrom(m5551g());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m5542a(c0936fiNewBuilder.buildPartial());
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

    /* renamed from: a */
    public C0955ga m5540a(long j) {
        this.f3070a |= 1;
        this.f3071b = j;
        return this;
    }

    /* renamed from: b */
    public C0955ga m5545b(long j) {
        this.f3070a |= 2;
        this.f3072c = j;
        return this;
    }

    /* renamed from: f */
    public boolean m5550f() {
        return (this.f3070a & 4) == 4;
    }

    /* renamed from: g */
    public C0935fh m5551g() {
        return this.f3073d;
    }

    /* renamed from: a */
    public C0955ga m5542a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f3073d = c0935fh;
        this.f3070a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0955ga m5546b(C0935fh c0935fh) {
        if ((this.f3070a & 4) == 4 && this.f3073d != C0935fh.m5211a()) {
            this.f3073d = C0935fh.m5212a(this.f3073d).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f3073d = c0935fh;
        }
        this.f3070a |= 4;
        return this;
    }
}
