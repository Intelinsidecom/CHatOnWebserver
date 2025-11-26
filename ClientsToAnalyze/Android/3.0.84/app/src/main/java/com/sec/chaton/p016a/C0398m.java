package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.m */
/* loaded from: classes.dex */
public final class C0398m extends GeneratedMessageLite.Builder<C0397l, C0398m> implements InterfaceC0399n {

    /* renamed from: a */
    private int f1419a;

    /* renamed from: b */
    private long f1420b;

    /* renamed from: c */
    private C0369dl f1421c = C0369dl.m2485a();

    private C0398m() {
        m2882j();
    }

    /* renamed from: j */
    private void m2882j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static C0398m m2883k() {
        return new C0398m();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0398m clear() {
        super.clear();
        this.f1420b = 0L;
        this.f1419a &= -2;
        this.f1421c = C0369dl.m2485a();
        this.f1419a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0398m mo13386clone() {
        return m2883k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0397l getDefaultInstanceForType() {
        return C0397l.m2869a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0397l build() {
        C0397l c0397lBuildPartial = buildPartial();
        if (!c0397lBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0397lBuildPartial);
        }
        return c0397lBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public C0397l m2884l() throws InvalidProtocolBufferException {
        C0397l c0397lBuildPartial = buildPartial();
        if (!c0397lBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0397lBuildPartial).asInvalidProtocolBufferException();
        }
        return c0397lBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0397l buildPartial() {
        C0397l c0397l = new C0397l(this);
        int i = this.f1419a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0397l.f1415c = this.f1420b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0397l.f1416d = this.f1421c;
        c0397l.f1414b = i2;
        return c0397l;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0398m mergeFrom(C0397l c0397l) {
        if (c0397l != C0397l.m2869a()) {
            if (c0397l.m2874c()) {
                m2886a(c0397l.m2875d());
            }
            if (c0397l.m2876e()) {
                m2892b(c0397l.m2877f());
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
    public C0398m mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1419a |= 1;
                    this.f1420b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0370dm c0370dmNewBuilder = C0369dl.newBuilder();
                    if (m2897g()) {
                        c0370dmNewBuilder.mergeFrom(m2898h());
                    }
                    codedInputStream.readMessage(c0370dmNewBuilder, extensionRegistryLite);
                    m2888a(c0370dmNewBuilder.buildPartial());
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
    public long m2896f() {
        return this.f1420b;
    }

    /* renamed from: a */
    public C0398m m2886a(long j) {
        this.f1419a |= 1;
        this.f1420b = j;
        return this;
    }

    /* renamed from: g */
    public boolean m2897g() {
        return (this.f1419a & 2) == 2;
    }

    /* renamed from: h */
    public C0369dl m2898h() {
        return this.f1421c;
    }

    /* renamed from: a */
    public C0398m m2888a(C0369dl c0369dl) {
        if (c0369dl == null) {
            throw new NullPointerException();
        }
        this.f1421c = c0369dl;
        this.f1419a |= 2;
        return this;
    }

    /* renamed from: a */
    public C0398m m2889a(C0370dm c0370dm) {
        this.f1421c = c0370dm.build();
        this.f1419a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0398m m2892b(C0369dl c0369dl) {
        if ((this.f1419a & 2) == 2 && this.f1421c != C0369dl.m2485a()) {
            this.f1421c = C0369dl.m2486a(this.f1421c).mergeFrom(c0369dl).buildPartial();
        } else {
            this.f1421c = c0369dl;
        }
        this.f1419a |= 2;
        return this;
    }
}
