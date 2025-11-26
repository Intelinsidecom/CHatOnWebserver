package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.an */
/* loaded from: classes.dex */
public final class C0806an extends GeneratedMessageLite.Builder<C0805am, C0806an> implements InterfaceC0807ao {

    /* renamed from: a */
    private int f2243a;

    /* renamed from: b */
    private long f2244b;

    /* renamed from: d */
    private long f2246d;

    /* renamed from: c */
    private C0935fh f2245c = C0935fh.m5211a();

    /* renamed from: e */
    private Object f2247e = "";

    private C0806an() {
        m3330i();
    }

    /* renamed from: i */
    private void m3330i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0806an m3331j() {
        return new C0806an();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0806an clear() {
        super.clear();
        this.f2244b = 0L;
        this.f2243a &= -2;
        this.f2245c = C0935fh.m5211a();
        this.f2243a &= -3;
        this.f2246d = 0L;
        this.f2243a &= -5;
        this.f2247e = "";
        this.f2243a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0806an mo19949clone() {
        return m3331j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0805am getDefaultInstanceForType() {
        return C0805am.m3309a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0805am build() {
        C0805am c0805amBuildPartial = buildPartial();
        if (!c0805amBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0805amBuildPartial);
        }
        return c0805amBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0805am m3332k() throws InvalidProtocolBufferException {
        C0805am c0805amBuildPartial = buildPartial();
        if (!c0805amBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0805amBuildPartial).asInvalidProtocolBufferException();
        }
        return c0805amBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0805am buildPartial() {
        C0805am c0805am = new C0805am(this);
        int i = this.f2243a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0805am.f2237c = this.f2244b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0805am.f2238d = this.f2245c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0805am.f2239e = this.f2246d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0805am.f2240f = this.f2247e;
        c0805am.f2236b = i2;
        return c0805am;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0806an mergeFrom(C0805am c0805am) {
        if (c0805am != C0805am.m3309a()) {
            if (c0805am.m3318c()) {
                m3334a(c0805am.m3319d());
            }
            if (c0805am.m3320e()) {
                m3341b(c0805am.m3321f());
            }
            if (c0805am.m3322g()) {
                m3340b(c0805am.m3323h());
            }
            if (c0805am.m3324i()) {
                m3338a(c0805am.m3325j());
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
    public C0806an mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2243a |= 1;
                    this.f2244b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m3345f()) {
                        c0936fiNewBuilder.mergeFrom(m3346g());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m3337a(c0936fiNewBuilder.buildPartial());
                    break;
                case 24:
                    this.f2243a |= 4;
                    this.f2246d = codedInputStream.readInt64();
                    break;
                case 34:
                    this.f2243a |= 8;
                    this.f2247e = codedInputStream.readBytes();
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
    public C0806an m3334a(long j) {
        this.f2243a |= 1;
        this.f2244b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m3345f() {
        return (this.f2243a & 2) == 2;
    }

    /* renamed from: g */
    public C0935fh m3346g() {
        return this.f2245c;
    }

    /* renamed from: a */
    public C0806an m3337a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f2245c = c0935fh;
        this.f2243a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0806an m3341b(C0935fh c0935fh) {
        if ((this.f2243a & 2) == 2 && this.f2245c != C0935fh.m5211a()) {
            this.f2245c = C0935fh.m5212a(this.f2245c).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f2245c = c0935fh;
        }
        this.f2243a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0806an m3340b(long j) {
        this.f2243a |= 4;
        this.f2246d = j;
        return this;
    }

    /* renamed from: a */
    public C0806an m3338a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2243a |= 8;
        this.f2247e = str;
        return this;
    }
}
