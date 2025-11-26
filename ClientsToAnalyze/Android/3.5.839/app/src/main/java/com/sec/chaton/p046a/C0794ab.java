package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ab */
/* loaded from: classes.dex */
public final class C0794ab extends GeneratedMessageLite.Builder<C0793aa, C0794ab> implements InterfaceC0795ac {

    /* renamed from: a */
    private int f2191a;

    /* renamed from: b */
    private long f2192b;

    /* renamed from: c */
    private C0935fh f2193c = C0935fh.m5211a();

    private C0794ab() {
        m3179i();
    }

    /* renamed from: i */
    private void m3179i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0794ab m3180j() {
        return new C0794ab();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0794ab clear() {
        super.clear();
        this.f2192b = 0L;
        this.f2191a &= -2;
        this.f2193c = C0935fh.m5211a();
        this.f2191a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0794ab mo19949clone() {
        return m3180j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0793aa getDefaultInstanceForType() {
        return C0793aa.m3165a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0793aa build() {
        C0793aa c0793aaBuildPartial = buildPartial();
        if (!c0793aaBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0793aaBuildPartial);
        }
        return c0793aaBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0793aa m3181k() throws InvalidProtocolBufferException {
        C0793aa c0793aaBuildPartial = buildPartial();
        if (!c0793aaBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0793aaBuildPartial).asInvalidProtocolBufferException();
        }
        return c0793aaBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0793aa buildPartial() {
        C0793aa c0793aa = new C0793aa(this);
        int i = this.f2191a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0793aa.f2187c = this.f2192b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0793aa.f2188d = this.f2193c;
        c0793aa.f2186b = i2;
        return c0793aa;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0794ab mergeFrom(C0793aa c0793aa) {
        if (c0793aa != C0793aa.m3165a()) {
            if (c0793aa.m3171c()) {
                m3183a(c0793aa.m3172d());
            }
            if (c0793aa.m3173e()) {
                m3188b(c0793aa.m3174f());
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
    public C0794ab mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2191a |= 1;
                    this.f2192b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m3192f()) {
                        c0936fiNewBuilder.mergeFrom(m3193g());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m3186a(c0936fiNewBuilder.buildPartial());
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
    public C0794ab m3183a(long j) {
        this.f2191a |= 1;
        this.f2192b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m3192f() {
        return (this.f2191a & 2) == 2;
    }

    /* renamed from: g */
    public C0935fh m3193g() {
        return this.f2193c;
    }

    /* renamed from: a */
    public C0794ab m3186a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f2193c = c0935fh;
        this.f2191a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0794ab m3188b(C0935fh c0935fh) {
        if ((this.f2191a & 2) == 2 && this.f2193c != C0935fh.m5211a()) {
            this.f2193c = C0935fh.m5212a(this.f2193c).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f2193c = c0935fh;
        }
        this.f2191a |= 2;
        return this;
    }
}
