package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dn */
/* loaded from: classes.dex */
public final class C0887dn extends GeneratedMessageLite.Builder<C0886dm, C0887dn> implements InterfaceC0888do {

    /* renamed from: a */
    private int f2729a;

    /* renamed from: b */
    private long f2730b;

    /* renamed from: c */
    private C0935fh f2731c = C0935fh.m5211a();

    private C0887dn() {
        m4586i();
    }

    /* renamed from: i */
    private void m4586i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0887dn m4587j() {
        return new C0887dn();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0887dn clear() {
        super.clear();
        this.f2730b = 0L;
        this.f2729a &= -2;
        this.f2731c = C0935fh.m5211a();
        this.f2729a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0887dn mo19949clone() {
        return m4587j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0886dm getDefaultInstanceForType() {
        return C0886dm.m4572a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0886dm build() {
        C0886dm c0886dmBuildPartial = buildPartial();
        if (!c0886dmBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0886dmBuildPartial);
        }
        return c0886dmBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0886dm m4588k() throws InvalidProtocolBufferException {
        C0886dm c0886dmBuildPartial = buildPartial();
        if (!c0886dmBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0886dmBuildPartial).asInvalidProtocolBufferException();
        }
        return c0886dmBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0886dm buildPartial() {
        C0886dm c0886dm = new C0886dm(this);
        int i = this.f2729a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0886dm.f2725c = this.f2730b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0886dm.f2726d = this.f2731c;
        c0886dm.f2724b = i2;
        return c0886dm;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0887dn mergeFrom(C0886dm c0886dm) {
        if (c0886dm != C0886dm.m4572a()) {
            if (c0886dm.m4578c()) {
                m4590a(c0886dm.m4579d());
            }
            if (c0886dm.m4580e()) {
                m4595b(c0886dm.m4581f());
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
    public C0887dn mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2729a |= 1;
                    this.f2730b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m4599f()) {
                        c0936fiNewBuilder.mergeFrom(m4600g());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m4593a(c0936fiNewBuilder.buildPartial());
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
    public C0887dn m4590a(long j) {
        this.f2729a |= 1;
        this.f2730b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m4599f() {
        return (this.f2729a & 2) == 2;
    }

    /* renamed from: g */
    public C0935fh m4600g() {
        return this.f2731c;
    }

    /* renamed from: a */
    public C0887dn m4593a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f2731c = c0935fh;
        this.f2729a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0887dn m4595b(C0935fh c0935fh) {
        if ((this.f2729a & 2) == 2 && this.f2731c != C0935fh.m5211a()) {
            this.f2731c = C0935fh.m5212a(this.f2731c).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f2731c = c0935fh;
        }
        this.f2729a |= 2;
        return this;
    }
}
