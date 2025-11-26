package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cg */
/* loaded from: classes.dex */
public final class C0853cg extends GeneratedMessageLite.Builder<C0852cf, C0853cg> implements InterfaceC0854ch {

    /* renamed from: a */
    private int f2498a;

    /* renamed from: b */
    private Object f2499b = "";

    /* renamed from: c */
    private C0864cr f2500c = C0864cr.m4134a();

    /* renamed from: d */
    private boolean f2501d;

    /* renamed from: e */
    private long f2502e;

    /* renamed from: f */
    private long f2503f;

    private C0853cg() {
        m3945i();
    }

    /* renamed from: i */
    private void m3945i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0853cg m3946j() {
        return new C0853cg();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0853cg clear() {
        super.clear();
        this.f2499b = "";
        this.f2498a &= -2;
        this.f2500c = C0864cr.m4134a();
        this.f2498a &= -3;
        this.f2501d = false;
        this.f2498a &= -5;
        this.f2502e = 0L;
        this.f2498a &= -9;
        this.f2503f = 0L;
        this.f2498a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0853cg mo19949clone() {
        return m3946j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0852cf getDefaultInstanceForType() {
        return C0852cf.m3921a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0852cf build() {
        C0852cf c0852cfBuildPartial = buildPartial();
        if (!c0852cfBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0852cfBuildPartial);
        }
        return c0852cfBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0852cf m3947k() throws InvalidProtocolBufferException {
        C0852cf c0852cfBuildPartial = buildPartial();
        if (!c0852cfBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0852cfBuildPartial).asInvalidProtocolBufferException();
        }
        return c0852cfBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0852cf buildPartial() {
        C0852cf c0852cf = new C0852cf(this);
        int i = this.f2498a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0852cf.f2491c = this.f2499b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0852cf.f2492d = this.f2500c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0852cf.f2493e = this.f2501d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0852cf.f2494f = this.f2502e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0852cf.f2495g = this.f2503f;
        c0852cf.f2490b = i2;
        return c0852cf;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0853cg mergeFrom(C0852cf c0852cf) {
        if (c0852cf != C0852cf.m3921a()) {
            if (c0852cf.m3931c()) {
                m3953a(c0852cf.m3932d());
            }
            if (c0852cf.m3933e()) {
                m3957b(c0852cf.m3934f());
            }
            if (c0852cf.m3935g()) {
                m3954a(c0852cf.m3936h());
            }
            if (c0852cf.m3937i()) {
                m3949a(c0852cf.m3938j());
            }
            if (c0852cf.m3939k()) {
                m3956b(c0852cf.m3940l());
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
    public C0853cg mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2498a |= 1;
                    this.f2499b = codedInputStream.readBytes();
                    break;
                case 18:
                    C0865cs c0865csNewBuilder = C0864cr.newBuilder();
                    if (m3961f()) {
                        c0865csNewBuilder.mergeFrom(m3962g());
                    }
                    codedInputStream.readMessage(c0865csNewBuilder, extensionRegistryLite);
                    m3952a(c0865csNewBuilder.buildPartial());
                    break;
                case 24:
                    this.f2498a |= 4;
                    this.f2501d = codedInputStream.readBool();
                    break;
                case 32:
                    this.f2498a |= 8;
                    this.f2502e = codedInputStream.readInt64();
                    break;
                case 40:
                    this.f2498a |= 16;
                    this.f2503f = codedInputStream.readInt64();
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
    public C0853cg m3953a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2498a |= 1;
        this.f2499b = str;
        return this;
    }

    /* renamed from: f */
    public boolean m3961f() {
        return (this.f2498a & 2) == 2;
    }

    /* renamed from: g */
    public C0864cr m3962g() {
        return this.f2500c;
    }

    /* renamed from: a */
    public C0853cg m3952a(C0864cr c0864cr) {
        if (c0864cr == null) {
            throw new NullPointerException();
        }
        this.f2500c = c0864cr;
        this.f2498a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0853cg m3957b(C0864cr c0864cr) {
        if ((this.f2498a & 2) == 2 && this.f2500c != C0864cr.m4134a()) {
            this.f2500c = C0864cr.m4135a(this.f2500c).mergeFrom(c0864cr).buildPartial();
        } else {
            this.f2500c = c0864cr;
        }
        this.f2498a |= 2;
        return this;
    }

    /* renamed from: a */
    public C0853cg m3954a(boolean z) {
        this.f2498a |= 4;
        this.f2501d = z;
        return this;
    }

    /* renamed from: a */
    public C0853cg m3949a(long j) {
        this.f2498a |= 8;
        this.f2502e = j;
        return this;
    }

    /* renamed from: b */
    public C0853cg m3956b(long j) {
        this.f2498a |= 16;
        this.f2503f = j;
        return this;
    }
}
