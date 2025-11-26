package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ax */
/* loaded from: classes.dex */
public final class C0816ax extends GeneratedMessageLite.Builder<C0815aw, C0816ax> implements InterfaceC0817ay {

    /* renamed from: a */
    private int f2304a;

    /* renamed from: b */
    private long f2305b;

    /* renamed from: e */
    private long f2308e;

    /* renamed from: g */
    private long f2310g;

    /* renamed from: c */
    private Object f2306c = "";

    /* renamed from: d */
    private C0957gc f2307d = C0957gc.m5553a();

    /* renamed from: f */
    private C0935fh f2309f = C0935fh.m5211a();

    private C0816ax() {
        m3459k();
    }

    /* renamed from: k */
    private void m3459k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0816ax m3460l() {
        return new C0816ax();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0816ax clear() {
        super.clear();
        this.f2305b = 0L;
        this.f2304a &= -2;
        this.f2306c = "";
        this.f2304a &= -3;
        this.f2307d = C0957gc.m5553a();
        this.f2304a &= -5;
        this.f2308e = 0L;
        this.f2304a &= -9;
        this.f2309f = C0935fh.m5211a();
        this.f2304a &= -17;
        this.f2310g = 0L;
        this.f2304a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0816ax mo19949clone() {
        return m3460l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0815aw getDefaultInstanceForType() {
        return C0815aw.m3432a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0815aw build() {
        C0815aw c0815awBuildPartial = buildPartial();
        if (!c0815awBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0815awBuildPartial);
        }
        return c0815awBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0815aw m3461m() throws InvalidProtocolBufferException {
        C0815aw c0815awBuildPartial = buildPartial();
        if (!c0815awBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0815awBuildPartial).asInvalidProtocolBufferException();
        }
        return c0815awBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0815aw buildPartial() {
        C0815aw c0815aw = new C0815aw(this);
        int i = this.f2304a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0815aw.f2296c = this.f2305b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0815aw.f2297d = this.f2306c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0815aw.f2298e = this.f2307d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0815aw.f2299f = this.f2308e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0815aw.f2300g = this.f2309f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0815aw.f2301h = this.f2310g;
        c0815aw.f2295b = i2;
        return c0815aw;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0816ax mergeFrom(C0815aw c0815aw) {
        if (c0815aw != C0815aw.m3432a()) {
            if (c0815aw.m3443c()) {
                m3463a(c0815aw.m3444d());
            }
            if (c0815aw.m3445e()) {
                m3469a(c0815aw.m3446f());
            }
            if (c0815aw.m3447g()) {
                m3473b(c0815aw.m3448h());
            }
            if (c0815aw.m3449i()) {
                m3471b(c0815aw.m3450j());
            }
            if (c0815aw.m3451k()) {
                m3472b(c0815aw.m3452l());
            }
            if (c0815aw.m3453m()) {
                m3475c(c0815aw.m3454n());
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
    public C0816ax mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2304a |= 1;
                    this.f2305b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f2304a |= 2;
                    this.f2306c = codedInputStream.readBytes();
                    break;
                case 26:
                    C0958gd c0958gdNewBuilder = C0957gc.newBuilder();
                    if (m3478f()) {
                        c0958gdNewBuilder.mergeFrom(m3479g());
                    }
                    codedInputStream.readMessage(c0958gdNewBuilder, extensionRegistryLite);
                    m3468a(c0958gdNewBuilder.buildPartial());
                    break;
                case 32:
                    this.f2304a |= 8;
                    this.f2308e = codedInputStream.readInt64();
                    break;
                case 42:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m3480h()) {
                        c0936fiNewBuilder.mergeFrom(m3481i());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m3466a(c0936fiNewBuilder.buildPartial());
                    break;
                case 48:
                    this.f2304a |= 32;
                    this.f2310g = codedInputStream.readInt64();
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
    public C0816ax m3463a(long j) {
        this.f2304a |= 1;
        this.f2305b = j;
        return this;
    }

    /* renamed from: a */
    public C0816ax m3469a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2304a |= 2;
        this.f2306c = str;
        return this;
    }

    /* renamed from: f */
    public boolean m3478f() {
        return (this.f2304a & 4) == 4;
    }

    /* renamed from: g */
    public C0957gc m3479g() {
        return this.f2307d;
    }

    /* renamed from: a */
    public C0816ax m3468a(C0957gc c0957gc) {
        if (c0957gc == null) {
            throw new NullPointerException();
        }
        this.f2307d = c0957gc;
        this.f2304a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0816ax m3473b(C0957gc c0957gc) {
        if ((this.f2304a & 4) == 4 && this.f2307d != C0957gc.m5553a()) {
            this.f2307d = C0957gc.m5554a(this.f2307d).mergeFrom(c0957gc).buildPartial();
        } else {
            this.f2307d = c0957gc;
        }
        this.f2304a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0816ax m3471b(long j) {
        this.f2304a |= 8;
        this.f2308e = j;
        return this;
    }

    /* renamed from: h */
    public boolean m3480h() {
        return (this.f2304a & 16) == 16;
    }

    /* renamed from: i */
    public C0935fh m3481i() {
        return this.f2309f;
    }

    /* renamed from: a */
    public C0816ax m3466a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f2309f = c0935fh;
        this.f2304a |= 16;
        return this;
    }

    /* renamed from: a */
    public C0816ax m3467a(C0936fi c0936fi) {
        this.f2309f = c0936fi.build();
        this.f2304a |= 16;
        return this;
    }

    /* renamed from: b */
    public C0816ax m3472b(C0935fh c0935fh) {
        if ((this.f2304a & 16) == 16 && this.f2309f != C0935fh.m5211a()) {
            this.f2309f = C0935fh.m5212a(this.f2309f).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f2309f = c0935fh;
        }
        this.f2304a |= 16;
        return this;
    }

    /* renamed from: c */
    public C0816ax m3475c(long j) {
        this.f2304a |= 32;
        this.f2310g = j;
        return this;
    }
}
