package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cg */
/* loaded from: classes.dex */
public final class C0337cg extends GeneratedMessageLite.Builder<C0336cf, C0337cg> implements InterfaceC0338ch {

    /* renamed from: a */
    private int f1147a;

    /* renamed from: b */
    private long f1148b;

    /* renamed from: d */
    private long f1150d;

    /* renamed from: c */
    private Object f1149c = "";

    /* renamed from: e */
    private C0385ea f1151e = C0385ea.m2690a();

    /* renamed from: f */
    private C0369dl f1152f = C0369dl.m2485a();

    private C0337cg() {
        m2101k();
    }

    /* renamed from: k */
    private void m2101k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0337cg m2102l() {
        return new C0337cg();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0337cg clear() {
        super.clear();
        this.f1148b = 0L;
        this.f1147a &= -2;
        this.f1149c = "";
        this.f1147a &= -3;
        this.f1150d = 0L;
        this.f1147a &= -5;
        this.f1151e = C0385ea.m2690a();
        this.f1147a &= -9;
        this.f1152f = C0369dl.m2485a();
        this.f1147a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0337cg mo13386clone() {
        return m2102l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0336cf getDefaultInstanceForType() {
        return C0336cf.m2077a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0336cf build() {
        C0336cf c0336cfBuildPartial = buildPartial();
        if (!c0336cfBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0336cfBuildPartial);
        }
        return c0336cfBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0336cf m2103m() throws InvalidProtocolBufferException {
        C0336cf c0336cfBuildPartial = buildPartial();
        if (!c0336cfBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0336cfBuildPartial).asInvalidProtocolBufferException();
        }
        return c0336cfBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0336cf buildPartial() {
        C0336cf c0336cf = new C0336cf(this);
        int i = this.f1147a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0336cf.f1140c = this.f1148b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0336cf.f1141d = this.f1149c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0336cf.f1142e = this.f1150d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0336cf.f1143f = this.f1151e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0336cf.f1144g = this.f1152f;
        c0336cf.f1139b = i2;
        return c0336cf;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0337cg mergeFrom(C0336cf c0336cf) {
        if (c0336cf != C0336cf.m2077a()) {
            if (c0336cf.m2087c()) {
                m2105a(c0336cf.m2088d());
            }
            if (c0336cf.m2089e()) {
                m2111a(c0336cf.m2090f());
            }
            if (c0336cf.m2091g()) {
                m2113b(c0336cf.m2092h());
            }
            if (c0336cf.m2093i()) {
                m2115b(c0336cf.m2094j());
            }
            if (c0336cf.m2095k()) {
                m2114b(c0336cf.m2096l());
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
    public C0337cg mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1147a |= 1;
                    this.f1148b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f1147a |= 2;
                    this.f1149c = codedInputStream.readBytes();
                    break;
                case 24:
                    this.f1147a |= 4;
                    this.f1150d = codedInputStream.readInt64();
                    break;
                case 34:
                    C0386eb c0386ebNewBuilder = C0385ea.newBuilder();
                    if (m2119f()) {
                        c0386ebNewBuilder.mergeFrom(m2120g());
                    }
                    codedInputStream.readMessage(c0386ebNewBuilder, extensionRegistryLite);
                    m2110a(c0386ebNewBuilder.buildPartial());
                    break;
                case 42:
                    C0370dm c0370dmNewBuilder = C0369dl.newBuilder();
                    if (m2121h()) {
                        c0370dmNewBuilder.mergeFrom(m2122i());
                    }
                    codedInputStream.readMessage(c0370dmNewBuilder, extensionRegistryLite);
                    m2108a(c0370dmNewBuilder.buildPartial());
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
    public C0337cg m2105a(long j) {
        this.f1147a |= 1;
        this.f1148b = j;
        return this;
    }

    /* renamed from: a */
    public C0337cg m2111a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1147a |= 2;
        this.f1149c = str;
        return this;
    }

    /* renamed from: b */
    public C0337cg m2113b(long j) {
        this.f1147a |= 4;
        this.f1150d = j;
        return this;
    }

    /* renamed from: f */
    public boolean m2119f() {
        return (this.f1147a & 8) == 8;
    }

    /* renamed from: g */
    public C0385ea m2120g() {
        return this.f1151e;
    }

    /* renamed from: a */
    public C0337cg m2110a(C0385ea c0385ea) {
        if (c0385ea == null) {
            throw new NullPointerException();
        }
        this.f1151e = c0385ea;
        this.f1147a |= 8;
        return this;
    }

    /* renamed from: b */
    public C0337cg m2115b(C0385ea c0385ea) {
        if ((this.f1147a & 8) == 8 && this.f1151e != C0385ea.m2690a()) {
            this.f1151e = C0385ea.m2691a(this.f1151e).mergeFrom(c0385ea).buildPartial();
        } else {
            this.f1151e = c0385ea;
        }
        this.f1147a |= 8;
        return this;
    }

    /* renamed from: h */
    public boolean m2121h() {
        return (this.f1147a & 16) == 16;
    }

    /* renamed from: i */
    public C0369dl m2122i() {
        return this.f1152f;
    }

    /* renamed from: a */
    public C0337cg m2108a(C0369dl c0369dl) {
        if (c0369dl == null) {
            throw new NullPointerException();
        }
        this.f1152f = c0369dl;
        this.f1147a |= 16;
        return this;
    }

    /* renamed from: a */
    public C0337cg m2109a(C0370dm c0370dm) {
        this.f1152f = c0370dm.build();
        this.f1147a |= 16;
        return this;
    }

    /* renamed from: b */
    public C0337cg m2114b(C0369dl c0369dl) {
        if ((this.f1147a & 16) == 16 && this.f1152f != C0369dl.m2485a()) {
            this.f1152f = C0369dl.m2486a(this.f1152f).mergeFrom(c0369dl).buildPartial();
        } else {
            this.f1152f = c0369dl;
        }
        this.f1147a |= 16;
        return this;
    }
}
