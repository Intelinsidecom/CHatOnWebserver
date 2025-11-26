package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ak */
/* loaded from: classes.dex */
public final class C0287ak extends GeneratedMessageLite.Builder<C0286aj, C0287ak> implements InterfaceC0288al {

    /* renamed from: a */
    private int f915a;

    /* renamed from: b */
    private long f916b;

    /* renamed from: c */
    private C0369dl f917c = C0369dl.m2485a();

    /* renamed from: d */
    private long f918d;

    private C0287ak() {
        m1499i();
    }

    /* renamed from: i */
    private void m1499i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0287ak m1500j() {
        return new C0287ak();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0287ak clear() {
        super.clear();
        this.f916b = 0L;
        this.f915a &= -2;
        this.f917c = C0369dl.m2485a();
        this.f915a &= -3;
        this.f918d = 0L;
        this.f915a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0287ak mo13386clone() {
        return m1500j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0286aj getDefaultInstanceForType() {
        return C0286aj.m1482a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0286aj build() {
        C0286aj c0286ajBuildPartial = buildPartial();
        if (!c0286ajBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0286ajBuildPartial);
        }
        return c0286ajBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0286aj m1501k() throws InvalidProtocolBufferException {
        C0286aj c0286ajBuildPartial = buildPartial();
        if (!c0286ajBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0286ajBuildPartial).asInvalidProtocolBufferException();
        }
        return c0286ajBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0286aj buildPartial() {
        C0286aj c0286aj = new C0286aj(this);
        int i = this.f915a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0286aj.f910c = this.f916b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0286aj.f911d = this.f917c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0286aj.f912e = this.f918d;
        c0286aj.f909b = i2;
        return c0286aj;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0287ak mergeFrom(C0286aj c0286aj) {
        if (c0286aj != C0286aj.m1482a()) {
            if (c0286aj.m1489c()) {
                m1503a(c0286aj.m1490d());
            }
            if (c0286aj.m1491e()) {
                m1509b(c0286aj.m1492f());
            }
            if (c0286aj.m1493g()) {
                m1508b(c0286aj.m1494h());
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
    public C0287ak mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f915a |= 1;
                    this.f916b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0370dm c0370dmNewBuilder = C0369dl.newBuilder();
                    if (m1513f()) {
                        c0370dmNewBuilder.mergeFrom(m1514g());
                    }
                    codedInputStream.readMessage(c0370dmNewBuilder, extensionRegistryLite);
                    m1506a(c0370dmNewBuilder.buildPartial());
                    break;
                case 24:
                    this.f915a |= 4;
                    this.f918d = codedInputStream.readInt64();
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
    public C0287ak m1503a(long j) {
        this.f915a |= 1;
        this.f916b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m1513f() {
        return (this.f915a & 2) == 2;
    }

    /* renamed from: g */
    public C0369dl m1514g() {
        return this.f917c;
    }

    /* renamed from: a */
    public C0287ak m1506a(C0369dl c0369dl) {
        if (c0369dl == null) {
            throw new NullPointerException();
        }
        this.f917c = c0369dl;
        this.f915a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0287ak m1509b(C0369dl c0369dl) {
        if ((this.f915a & 2) == 2 && this.f917c != C0369dl.m2485a()) {
            this.f917c = C0369dl.m2486a(this.f917c).mergeFrom(c0369dl).buildPartial();
        } else {
            this.f917c = c0369dl;
        }
        this.f915a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0287ak m1508b(long j) {
        this.f915a |= 4;
        this.f918d = j;
        return this;
    }
}
