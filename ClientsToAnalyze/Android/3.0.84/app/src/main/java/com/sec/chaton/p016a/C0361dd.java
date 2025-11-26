package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dd */
/* loaded from: classes.dex */
public final class C0361dd extends GeneratedMessageLite.Builder<C0360dc, C0361dd> implements InterfaceC0362de {

    /* renamed from: a */
    private int f1259a;

    /* renamed from: b */
    private long f1260b;

    /* renamed from: c */
    private List<C0356cz> f1261c = Collections.emptyList();

    /* renamed from: d */
    private C0369dl f1262d = C0369dl.m2485a();

    private C0361dd() {
        m2417i();
    }

    /* renamed from: i */
    private void m2417i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0361dd m2418j() {
        return new C0361dd();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0361dd clear() {
        super.clear();
        this.f1260b = 0L;
        this.f1259a &= -2;
        this.f1261c = Collections.emptyList();
        this.f1259a &= -3;
        this.f1262d = C0369dl.m2485a();
        this.f1259a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0361dd mo13386clone() {
        return m2418j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0360dc getDefaultInstanceForType() {
        return C0360dc.m2401a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0360dc build() {
        C0360dc c0360dcBuildPartial = buildPartial();
        if (!c0360dcBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0360dcBuildPartial);
        }
        return c0360dcBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0360dc m2419k() throws InvalidProtocolBufferException {
        C0360dc c0360dcBuildPartial = buildPartial();
        if (!c0360dcBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0360dcBuildPartial).asInvalidProtocolBufferException();
        }
        return c0360dcBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0360dc buildPartial() {
        C0360dc c0360dc = new C0360dc(this);
        int i = this.f1259a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0360dc.f1254c = this.f1260b;
        if ((this.f1259a & 2) == 2) {
            this.f1261c = Collections.unmodifiableList(this.f1261c);
            this.f1259a &= -3;
        }
        c0360dc.f1255d = this.f1261c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0360dc.f1256e = this.f1262d;
        c0360dc.f1253b = i2;
        return c0360dc;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0361dd mergeFrom(C0360dc c0360dc) {
        if (c0360dc != C0360dc.m2401a()) {
            if (c0360dc.m2409c()) {
                m2422a(c0360dc.m2410d());
            }
            if (!c0360dc.f1255d.isEmpty()) {
                if (this.f1261c.isEmpty()) {
                    this.f1261c = c0360dc.f1255d;
                    this.f1259a &= -3;
                } else {
                    m2420l();
                    this.f1261c.addAll(c0360dc.f1255d);
                }
            }
            if (c0360dc.m2411e()) {
                m2428b(c0360dc.m2412f());
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
    public C0361dd mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1259a |= 1;
                    this.f1260b = codedInputStream.readInt64();
                    break;
                case 18:
                    MessageLite.Builder builderNewBuilder = C0356cz.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m2424a(builderNewBuilder.buildPartial());
                    break;
                case 26:
                    C0370dm c0370dmNewBuilder = C0369dl.newBuilder();
                    if (m2432f()) {
                        c0370dmNewBuilder.mergeFrom(m2433g());
                    }
                    codedInputStream.readMessage(c0370dmNewBuilder, extensionRegistryLite);
                    m2426a(c0370dmNewBuilder.buildPartial());
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
    public C0361dd m2422a(long j) {
        this.f1259a |= 1;
        this.f1260b = j;
        return this;
    }

    /* renamed from: l */
    private void m2420l() {
        if ((this.f1259a & 2) != 2) {
            this.f1261c = new ArrayList(this.f1261c);
            this.f1259a |= 2;
        }
    }

    /* renamed from: a */
    public C0361dd m2424a(C0356cz c0356cz) {
        if (c0356cz == null) {
            throw new NullPointerException();
        }
        m2420l();
        this.f1261c.add(c0356cz);
        return this;
    }

    /* renamed from: f */
    public boolean m2432f() {
        return (this.f1259a & 4) == 4;
    }

    /* renamed from: g */
    public C0369dl m2433g() {
        return this.f1262d;
    }

    /* renamed from: a */
    public C0361dd m2426a(C0369dl c0369dl) {
        if (c0369dl == null) {
            throw new NullPointerException();
        }
        this.f1262d = c0369dl;
        this.f1259a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0361dd m2428b(C0369dl c0369dl) {
        if ((this.f1259a & 4) == 4 && this.f1262d != C0369dl.m2485a()) {
            this.f1262d = C0369dl.m2486a(this.f1262d).mergeFrom(c0369dl).buildPartial();
        } else {
            this.f1262d = c0369dl;
        }
        this.f1259a |= 4;
        return this;
    }
}
