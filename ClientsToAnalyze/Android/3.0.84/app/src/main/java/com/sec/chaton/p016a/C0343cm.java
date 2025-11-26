package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cm */
/* loaded from: classes.dex */
public final class C0343cm extends GeneratedMessageLite.Builder<C0342cl, C0343cm> implements InterfaceC0344cn {

    /* renamed from: a */
    private int f1183a;

    /* renamed from: b */
    private long f1184b;

    /* renamed from: c */
    private C0369dl f1185c = C0369dl.m2485a();

    /* renamed from: d */
    private long f1186d;

    private C0343cm() {
        m2203i();
    }

    /* renamed from: i */
    private void m2203i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0343cm m2204j() {
        return new C0343cm();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0343cm clear() {
        super.clear();
        this.f1184b = 0L;
        this.f1183a &= -2;
        this.f1185c = C0369dl.m2485a();
        this.f1183a &= -3;
        this.f1186d = 0L;
        this.f1183a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0343cm mo13386clone() {
        return m2204j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0342cl getDefaultInstanceForType() {
        return C0342cl.m2186a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0342cl build() {
        C0342cl c0342clBuildPartial = buildPartial();
        if (!c0342clBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0342clBuildPartial);
        }
        return c0342clBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0342cl m2205k() throws InvalidProtocolBufferException {
        C0342cl c0342clBuildPartial = buildPartial();
        if (!c0342clBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0342clBuildPartial).asInvalidProtocolBufferException();
        }
        return c0342clBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0342cl buildPartial() {
        C0342cl c0342cl = new C0342cl(this);
        int i = this.f1183a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0342cl.f1178c = this.f1184b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0342cl.f1179d = this.f1185c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0342cl.f1180e = this.f1186d;
        c0342cl.f1177b = i2;
        return c0342cl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0343cm mergeFrom(C0342cl c0342cl) {
        if (c0342cl != C0342cl.m2186a()) {
            if (c0342cl.m2193c()) {
                m2207a(c0342cl.m2194d());
            }
            if (c0342cl.m2195e()) {
                m2213b(c0342cl.m2196f());
            }
            if (c0342cl.m2197g()) {
                m2212b(c0342cl.m2198h());
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
    public C0343cm mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1183a |= 1;
                    this.f1184b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0370dm c0370dmNewBuilder = C0369dl.newBuilder();
                    if (m2217f()) {
                        c0370dmNewBuilder.mergeFrom(m2218g());
                    }
                    codedInputStream.readMessage(c0370dmNewBuilder, extensionRegistryLite);
                    m2210a(c0370dmNewBuilder.buildPartial());
                    break;
                case 24:
                    this.f1183a |= 4;
                    this.f1186d = codedInputStream.readInt64();
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
    public C0343cm m2207a(long j) {
        this.f1183a |= 1;
        this.f1184b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m2217f() {
        return (this.f1183a & 2) == 2;
    }

    /* renamed from: g */
    public C0369dl m2218g() {
        return this.f1185c;
    }

    /* renamed from: a */
    public C0343cm m2210a(C0369dl c0369dl) {
        if (c0369dl == null) {
            throw new NullPointerException();
        }
        this.f1185c = c0369dl;
        this.f1183a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0343cm m2213b(C0369dl c0369dl) {
        if ((this.f1183a & 2) == 2 && this.f1185c != C0369dl.m2485a()) {
            this.f1185c = C0369dl.m2486a(this.f1185c).mergeFrom(c0369dl).buildPartial();
        } else {
            this.f1185c = c0369dl;
        }
        this.f1183a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0343cm m2212b(long j) {
        this.f1183a |= 4;
        this.f1186d = j;
        return this;
    }
}
