package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.de */
/* loaded from: classes.dex */
public final class C0878de extends GeneratedMessageLite.Builder<C0877dd, C0878de> implements InterfaceC0879df {

    /* renamed from: a */
    private int f2668a;

    /* renamed from: b */
    private long f2669b;

    /* renamed from: d */
    private long f2671d;

    /* renamed from: c */
    private C0935fh f2670c = C0935fh.m5211a();

    /* renamed from: e */
    private Object f2672e = "";

    private C0878de() {
        m4411i();
    }

    /* renamed from: i */
    private void m4411i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0878de m4412j() {
        return new C0878de();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0878de clear() {
        super.clear();
        this.f2669b = 0L;
        this.f2668a &= -2;
        this.f2670c = C0935fh.m5211a();
        this.f2668a &= -3;
        this.f2671d = 0L;
        this.f2668a &= -5;
        this.f2672e = "";
        this.f2668a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0878de mo19949clone() {
        return m4412j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0877dd getDefaultInstanceForType() {
        return C0877dd.m4390a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0877dd build() {
        C0877dd c0877ddBuildPartial = buildPartial();
        if (!c0877ddBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0877ddBuildPartial);
        }
        return c0877ddBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0877dd m4413k() throws InvalidProtocolBufferException {
        C0877dd c0877ddBuildPartial = buildPartial();
        if (!c0877ddBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0877ddBuildPartial).asInvalidProtocolBufferException();
        }
        return c0877ddBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0877dd buildPartial() {
        C0877dd c0877dd = new C0877dd(this);
        int i = this.f2668a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0877dd.f2662c = this.f2669b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0877dd.f2663d = this.f2670c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0877dd.f2664e = this.f2671d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0877dd.f2665f = this.f2672e;
        c0877dd.f2661b = i2;
        return c0877dd;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0878de mergeFrom(C0877dd c0877dd) {
        if (c0877dd != C0877dd.m4390a()) {
            if (c0877dd.m4399c()) {
                m4415a(c0877dd.m4400d());
            }
            if (c0877dd.m4401e()) {
                m4422b(c0877dd.m4402f());
            }
            if (c0877dd.m4403g()) {
                m4421b(c0877dd.m4404h());
            }
            if (c0877dd.m4405i()) {
                m4419a(c0877dd.m4406j());
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
    public C0878de mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2668a |= 1;
                    this.f2669b = codedInputStream.readInt64();
                    break;
                case 18:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m4426f()) {
                        c0936fiNewBuilder.mergeFrom(m4427g());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m4418a(c0936fiNewBuilder.buildPartial());
                    break;
                case 24:
                    this.f2668a |= 4;
                    this.f2671d = codedInputStream.readInt64();
                    break;
                case 34:
                    this.f2668a |= 8;
                    this.f2672e = codedInputStream.readBytes();
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
    public C0878de m4415a(long j) {
        this.f2668a |= 1;
        this.f2669b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m4426f() {
        return (this.f2668a & 2) == 2;
    }

    /* renamed from: g */
    public C0935fh m4427g() {
        return this.f2670c;
    }

    /* renamed from: a */
    public C0878de m4418a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f2670c = c0935fh;
        this.f2668a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0878de m4422b(C0935fh c0935fh) {
        if ((this.f2668a & 2) == 2 && this.f2670c != C0935fh.m5211a()) {
            this.f2670c = C0935fh.m5212a(this.f2670c).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f2670c = c0935fh;
        }
        this.f2668a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0878de m4421b(long j) {
        this.f2668a |= 4;
        this.f2671d = j;
        return this;
    }

    /* renamed from: a */
    public C0878de m4419a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2668a |= 8;
        this.f2672e = str;
        return this;
    }
}
