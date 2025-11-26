package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ca */
/* loaded from: classes.dex */
public final class C0847ca extends GeneratedMessageLite.Builder<C0845bz, C0847ca> implements InterfaceC0848cb {

    /* renamed from: a */
    private int f2460a;

    /* renamed from: b */
    private long f2461b;

    /* renamed from: c */
    private C0935fh f2462c = C0935fh.m5211a();

    /* renamed from: d */
    private Object f2463d = "";

    private C0847ca() {
        m3833i();
    }

    /* renamed from: i */
    private void m3833i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0847ca m3834j() {
        return new C0847ca();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0847ca clear() {
        super.clear();
        this.f2461b = 0L;
        this.f2460a &= -2;
        this.f2462c = C0935fh.m5211a();
        this.f2460a &= -3;
        this.f2463d = "";
        this.f2460a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0847ca mo19949clone() {
        return m3834j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0845bz getDefaultInstanceForType() {
        return C0845bz.m3801a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0845bz build() {
        C0845bz c0845bzBuildPartial = buildPartial();
        if (!c0845bzBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0845bzBuildPartial);
        }
        return c0845bzBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0845bz m3835k() throws InvalidProtocolBufferException {
        C0845bz c0845bzBuildPartial = buildPartial();
        if (!c0845bzBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0845bzBuildPartial).asInvalidProtocolBufferException();
        }
        return c0845bzBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0845bz buildPartial() {
        C0845bz c0845bz = new C0845bz(this);
        int i = this.f2460a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0845bz.f2449c = this.f2461b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0845bz.f2450d = this.f2462c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0845bz.f2451e = this.f2463d;
        c0845bz.f2448b = i2;
        return c0845bz;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0847ca mergeFrom(C0845bz c0845bz) {
        if (c0845bz != C0845bz.m3801a()) {
            if (c0845bz.m3809c()) {
                m3837a(c0845bz.m3810d());
            }
            if (c0845bz.m3811e()) {
                m3843b(c0845bz.m3812f());
            }
            if (c0845bz.m3813g()) {
                m3841a(c0845bz.m3814h());
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
    public C0847ca mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2460a |= 1;
                    this.f2461b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m3847f()) {
                        c0936fiNewBuilder.mergeFrom(m3848g());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m3840a(c0936fiNewBuilder.buildPartial());
                    break;
                case 26:
                    this.f2460a |= 4;
                    this.f2463d = codedInputStream.readBytes();
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
    public C0847ca m3837a(long j) {
        this.f2460a |= 1;
        this.f2461b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m3847f() {
        return (this.f2460a & 2) == 2;
    }

    /* renamed from: g */
    public C0935fh m3848g() {
        return this.f2462c;
    }

    /* renamed from: a */
    public C0847ca m3840a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f2462c = c0935fh;
        this.f2460a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0847ca m3843b(C0935fh c0935fh) {
        if ((this.f2460a & 2) == 2 && this.f2462c != C0935fh.m5211a()) {
            this.f2462c = C0935fh.m5212a(this.f2462c).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f2462c = c0935fh;
        }
        this.f2460a |= 2;
        return this;
    }

    /* renamed from: a */
    public C0847ca m3841a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2460a |= 4;
        this.f2463d = str;
        return this;
    }
}
