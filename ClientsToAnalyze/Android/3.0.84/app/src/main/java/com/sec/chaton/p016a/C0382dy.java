package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dy */
/* loaded from: classes.dex */
public final class C0382dy extends GeneratedMessageLite.Builder<C0381dx, C0382dy> implements InterfaceC0383dz {

    /* renamed from: a */
    private int f1345a;

    /* renamed from: b */
    private long f1346b;

    /* renamed from: c */
    private long f1347c;

    /* renamed from: d */
    private C0369dl f1348d = C0369dl.m2485a();

    private C0382dy() {
        m2674i();
    }

    /* renamed from: i */
    private void m2674i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0382dy m2675j() {
        return new C0382dy();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0382dy clear() {
        super.clear();
        this.f1346b = 0L;
        this.f1345a &= -2;
        this.f1347c = 0L;
        this.f1345a &= -3;
        this.f1348d = C0369dl.m2485a();
        this.f1345a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0382dy mo13386clone() {
        return m2675j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0381dx getDefaultInstanceForType() {
        return C0381dx.m2660a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0381dx build() {
        C0381dx c0381dxBuildPartial = buildPartial();
        if (!c0381dxBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0381dxBuildPartial);
        }
        return c0381dxBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0381dx buildPartial() {
        C0381dx c0381dx = new C0381dx(this);
        int i = this.f1345a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0381dx.f1340c = this.f1346b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0381dx.f1341d = this.f1347c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0381dx.f1342e = this.f1348d;
        c0381dx.f1339b = i2;
        return c0381dx;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0382dy mergeFrom(C0381dx c0381dx) {
        if (c0381dx != C0381dx.m2660a()) {
            if (c0381dx.m2665c()) {
                m2677a(c0381dx.m2666d());
            }
            if (c0381dx.m2667e()) {
                m2682b(c0381dx.m2668f());
            }
            if (c0381dx.m2669g()) {
                m2683b(c0381dx.m2670h());
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
    public C0382dy mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1345a |= 1;
                    this.f1346b = codedInputStream.readInt64();
                    break;
                case 16:
                    this.f1345a |= 2;
                    this.f1347c = codedInputStream.readInt64();
                    break;
                case 26:
                    C0370dm c0370dmNewBuilder = C0369dl.newBuilder();
                    if (m2687f()) {
                        c0370dmNewBuilder.mergeFrom(m2688g());
                    }
                    codedInputStream.readMessage(c0370dmNewBuilder, extensionRegistryLite);
                    m2679a(c0370dmNewBuilder.buildPartial());
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
    public C0382dy m2677a(long j) {
        this.f1345a |= 1;
        this.f1346b = j;
        return this;
    }

    /* renamed from: b */
    public C0382dy m2682b(long j) {
        this.f1345a |= 2;
        this.f1347c = j;
        return this;
    }

    /* renamed from: f */
    public boolean m2687f() {
        return (this.f1345a & 4) == 4;
    }

    /* renamed from: g */
    public C0369dl m2688g() {
        return this.f1348d;
    }

    /* renamed from: a */
    public C0382dy m2679a(C0369dl c0369dl) {
        if (c0369dl == null) {
            throw new NullPointerException();
        }
        this.f1348d = c0369dl;
        this.f1345a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0382dy m2683b(C0369dl c0369dl) {
        if ((this.f1345a & 4) == 4 && this.f1348d != C0369dl.m2485a()) {
            this.f1348d = C0369dl.m2486a(this.f1348d).mergeFrom(c0369dl).buildPartial();
        } else {
            this.f1348d = c0369dl;
        }
        this.f1345a |= 4;
        return this;
    }
}
