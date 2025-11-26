package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.d */
/* loaded from: classes.dex */
public final class C0357d extends GeneratedMessageLite.Builder<C0330c, C0357d> implements InterfaceC0384e {

    /* renamed from: a */
    private int f1246a;

    /* renamed from: b */
    private long f1247b;

    /* renamed from: c */
    private C0369dl f1248c = C0369dl.m2485a();

    private C0357d() {
        m2371i();
    }

    /* renamed from: i */
    private void m2371i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0357d m2372j() {
        return new C0357d();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0357d clear() {
        super.clear();
        this.f1247b = 0L;
        this.f1246a &= -2;
        this.f1248c = C0369dl.m2485a();
        this.f1246a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0357d mo13386clone() {
        return m2372j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0330c getDefaultInstanceForType() {
        return C0330c.m1988a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0330c build() {
        C0330c c0330cBuildPartial = buildPartial();
        if (!c0330cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0330cBuildPartial);
        }
        return c0330cBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0330c m2373k() throws InvalidProtocolBufferException {
        C0330c c0330cBuildPartial = buildPartial();
        if (!c0330cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0330cBuildPartial).asInvalidProtocolBufferException();
        }
        return c0330cBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0330c buildPartial() {
        C0330c c0330c = new C0330c(this);
        int i = this.f1246a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0330c.f1107c = this.f1247b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0330c.f1108d = this.f1248c;
        c0330c.f1106b = i2;
        return c0330c;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0357d mergeFrom(C0330c c0330c) {
        if (c0330c != C0330c.m1988a()) {
            if (c0330c.m1994c()) {
                m2375a(c0330c.m1995d());
            }
            if (c0330c.m1996e()) {
                m2381b(c0330c.m1997f());
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
    public C0357d mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1246a |= 1;
                    this.f1247b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0370dm c0370dmNewBuilder = C0369dl.newBuilder();
                    if (m2385f()) {
                        c0370dmNewBuilder.mergeFrom(m2386g());
                    }
                    codedInputStream.readMessage(c0370dmNewBuilder, extensionRegistryLite);
                    m2378a(c0370dmNewBuilder.buildPartial());
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
    public C0357d m2375a(long j) {
        this.f1246a |= 1;
        this.f1247b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m2385f() {
        return (this.f1246a & 2) == 2;
    }

    /* renamed from: g */
    public C0369dl m2386g() {
        return this.f1248c;
    }

    /* renamed from: a */
    public C0357d m2378a(C0369dl c0369dl) {
        if (c0369dl == null) {
            throw new NullPointerException();
        }
        this.f1248c = c0369dl;
        this.f1246a |= 2;
        return this;
    }

    /* renamed from: a */
    public C0357d m2379a(C0370dm c0370dm) {
        this.f1248c = c0370dm.build();
        this.f1246a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0357d m2381b(C0369dl c0369dl) {
        if ((this.f1246a & 2) == 2 && this.f1248c != C0369dl.m2485a()) {
            this.f1248c = C0369dl.m2486a(this.f1248c).mergeFrom(c0369dl).buildPartial();
        } else {
            this.f1248c = c0369dl;
        }
        this.f1246a |= 2;
        return this;
    }
}
