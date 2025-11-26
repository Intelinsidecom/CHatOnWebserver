package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bp */
/* loaded from: classes.dex */
public final class C0319bp extends GeneratedMessageLite.Builder<C0318bo, C0319bp> implements InterfaceC0320bq {

    /* renamed from: a */
    private int f1065a;

    /* renamed from: b */
    private long f1066b;

    /* renamed from: c */
    private EnumC0316bm f1067c = EnumC0316bm.CLOSE;

    /* renamed from: d */
    private C0369dl f1068d = C0369dl.m2485a();

    private C0319bp() {
        m1870k();
    }

    /* renamed from: k */
    private void m1870k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0319bp m1871l() {
        return new C0319bp();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0319bp clear() {
        super.clear();
        this.f1066b = 0L;
        this.f1065a &= -2;
        this.f1067c = EnumC0316bm.CLOSE;
        this.f1065a &= -3;
        this.f1068d = C0369dl.m2485a();
        this.f1065a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0319bp mo13386clone() {
        return m1871l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0318bo getDefaultInstanceForType() {
        return C0318bo.m1854a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0318bo build() {
        C0318bo c0318boBuildPartial = buildPartial();
        if (!c0318boBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0318boBuildPartial);
        }
        return c0318boBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0318bo m1872m() throws InvalidProtocolBufferException {
        C0318bo c0318boBuildPartial = buildPartial();
        if (!c0318boBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0318boBuildPartial).asInvalidProtocolBufferException();
        }
        return c0318boBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0318bo buildPartial() {
        C0318bo c0318bo = new C0318bo(this);
        int i = this.f1065a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0318bo.f1060c = this.f1066b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0318bo.f1061d = this.f1067c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0318bo.f1062e = this.f1068d;
        c0318bo.f1059b = i2;
        return c0318bo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0319bp mergeFrom(C0318bo c0318bo) {
        if (c0318bo != C0318bo.m1854a()) {
            if (c0318bo.m1860c()) {
                m1874a(c0318bo.m1861d());
            }
            if (c0318bo.m1862e()) {
                m1876a(c0318bo.m1863f());
            }
            if (c0318bo.m1864g()) {
                m1880b(c0318bo.m1865h());
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
    public C0319bp mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1065a |= 1;
                    this.f1066b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0316bm enumC0316bmM1849a = EnumC0316bm.m1849a(codedInputStream.readEnum());
                    if (enumC0316bmM1849a == null) {
                        break;
                    } else {
                        this.f1065a |= 2;
                        this.f1067c = enumC0316bmM1849a;
                        break;
                    }
                case 26:
                    C0370dm c0370dmNewBuilder = C0369dl.newBuilder();
                    if (m1886h()) {
                        c0370dmNewBuilder.mergeFrom(m1887i());
                    }
                    codedInputStream.readMessage(c0370dmNewBuilder, extensionRegistryLite);
                    m1878a(c0370dmNewBuilder.buildPartial());
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
    public long m1884f() {
        return this.f1066b;
    }

    /* renamed from: a */
    public C0319bp m1874a(long j) {
        this.f1065a |= 1;
        this.f1066b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0316bm m1885g() {
        return this.f1067c;
    }

    /* renamed from: a */
    public C0319bp m1876a(EnumC0316bm enumC0316bm) {
        if (enumC0316bm == null) {
            throw new NullPointerException();
        }
        this.f1065a |= 2;
        this.f1067c = enumC0316bm;
        return this;
    }

    /* renamed from: h */
    public boolean m1886h() {
        return (this.f1065a & 4) == 4;
    }

    /* renamed from: i */
    public C0369dl m1887i() {
        return this.f1068d;
    }

    /* renamed from: a */
    public C0319bp m1878a(C0369dl c0369dl) {
        if (c0369dl == null) {
            throw new NullPointerException();
        }
        this.f1068d = c0369dl;
        this.f1065a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0319bp m1880b(C0369dl c0369dl) {
        if ((this.f1065a & 4) == 4 && this.f1068d != C0369dl.m2485a()) {
            this.f1068d = C0369dl.m2486a(this.f1068d).mergeFrom(c0369dl).buildPartial();
        } else {
            this.f1068d = c0369dl;
        }
        this.f1065a |= 4;
        return this;
    }
}
