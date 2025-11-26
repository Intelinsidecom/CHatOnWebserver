package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cy */
/* loaded from: classes.dex */
public final class C0871cy extends GeneratedMessageLite.Builder<C0870cx, C0871cy> implements InterfaceC0872cz {

    /* renamed from: a */
    private int f2615a;

    /* renamed from: b */
    private long f2616b;

    /* renamed from: d */
    private long f2618d;

    /* renamed from: g */
    private long f2621g;

    /* renamed from: c */
    private Object f2617c = "";

    /* renamed from: e */
    private C0957gc f2619e = C0957gc.m5553a();

    /* renamed from: f */
    private C0935fh f2620f = C0935fh.m5211a();

    private C0871cy() {
        m4265k();
    }

    /* renamed from: k */
    private void m4265k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0871cy m4266l() {
        return new C0871cy();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0871cy clear() {
        super.clear();
        this.f2616b = 0L;
        this.f2615a &= -2;
        this.f2617c = "";
        this.f2615a &= -3;
        this.f2618d = 0L;
        this.f2615a &= -5;
        this.f2619e = C0957gc.m5553a();
        this.f2615a &= -9;
        this.f2620f = C0935fh.m5211a();
        this.f2615a &= -17;
        this.f2621g = 0L;
        this.f2615a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0871cy mo19949clone() {
        return m4266l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0870cx getDefaultInstanceForType() {
        return C0870cx.m4238a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0870cx build() {
        C0870cx c0870cxBuildPartial = buildPartial();
        if (!c0870cxBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0870cxBuildPartial);
        }
        return c0870cxBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0870cx m4267m() throws InvalidProtocolBufferException {
        C0870cx c0870cxBuildPartial = buildPartial();
        if (!c0870cxBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0870cxBuildPartial).asInvalidProtocolBufferException();
        }
        return c0870cxBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0870cx buildPartial() {
        C0870cx c0870cx = new C0870cx(this);
        int i = this.f2615a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0870cx.f2607c = this.f2616b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0870cx.f2608d = this.f2617c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0870cx.f2609e = this.f2618d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0870cx.f2610f = this.f2619e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0870cx.f2611g = this.f2620f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0870cx.f2612h = this.f2621g;
        c0870cx.f2606b = i2;
        return c0870cx;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0871cy mergeFrom(C0870cx c0870cx) {
        if (c0870cx != C0870cx.m4238a()) {
            if (c0870cx.m4249c()) {
                m4269a(c0870cx.m4250d());
            }
            if (c0870cx.m4251e()) {
                m4275a(c0870cx.m4252f());
            }
            if (c0870cx.m4253g()) {
                m4277b(c0870cx.m4254h());
            }
            if (c0870cx.m4255i()) {
                m4279b(c0870cx.m4256j());
            }
            if (c0870cx.m4257k()) {
                m4278b(c0870cx.m4258l());
            }
            if (c0870cx.m4259m()) {
                m4281c(c0870cx.m4260n());
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
    public C0871cy mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2615a |= 1;
                    this.f2616b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f2615a |= 2;
                    this.f2617c = codedInputStream.readBytes();
                    break;
                case 24:
                    this.f2615a |= 4;
                    this.f2618d = codedInputStream.readInt64();
                    break;
                case 34:
                    C0958gd c0958gdNewBuilder = C0957gc.newBuilder();
                    if (m4284f()) {
                        c0958gdNewBuilder.mergeFrom(m4285g());
                    }
                    codedInputStream.readMessage(c0958gdNewBuilder, extensionRegistryLite);
                    m4274a(c0958gdNewBuilder.buildPartial());
                    break;
                case 42:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m4286h()) {
                        c0936fiNewBuilder.mergeFrom(m4287i());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m4272a(c0936fiNewBuilder.buildPartial());
                    break;
                case 48:
                    this.f2615a |= 32;
                    this.f2621g = codedInputStream.readInt64();
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
    public C0871cy m4269a(long j) {
        this.f2615a |= 1;
        this.f2616b = j;
        return this;
    }

    /* renamed from: a */
    public C0871cy m4275a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2615a |= 2;
        this.f2617c = str;
        return this;
    }

    /* renamed from: b */
    public C0871cy m4277b(long j) {
        this.f2615a |= 4;
        this.f2618d = j;
        return this;
    }

    /* renamed from: f */
    public boolean m4284f() {
        return (this.f2615a & 8) == 8;
    }

    /* renamed from: g */
    public C0957gc m4285g() {
        return this.f2619e;
    }

    /* renamed from: a */
    public C0871cy m4274a(C0957gc c0957gc) {
        if (c0957gc == null) {
            throw new NullPointerException();
        }
        this.f2619e = c0957gc;
        this.f2615a |= 8;
        return this;
    }

    /* renamed from: b */
    public C0871cy m4279b(C0957gc c0957gc) {
        if ((this.f2615a & 8) == 8 && this.f2619e != C0957gc.m5553a()) {
            this.f2619e = C0957gc.m5554a(this.f2619e).mergeFrom(c0957gc).buildPartial();
        } else {
            this.f2619e = c0957gc;
        }
        this.f2615a |= 8;
        return this;
    }

    /* renamed from: h */
    public boolean m4286h() {
        return (this.f2615a & 16) == 16;
    }

    /* renamed from: i */
    public C0935fh m4287i() {
        return this.f2620f;
    }

    /* renamed from: a */
    public C0871cy m4272a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f2620f = c0935fh;
        this.f2615a |= 16;
        return this;
    }

    /* renamed from: a */
    public C0871cy m4273a(C0936fi c0936fi) {
        this.f2620f = c0936fi.build();
        this.f2615a |= 16;
        return this;
    }

    /* renamed from: b */
    public C0871cy m4278b(C0935fh c0935fh) {
        if ((this.f2615a & 16) == 16 && this.f2620f != C0935fh.m5211a()) {
            this.f2620f = C0935fh.m5212a(this.f2620f).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f2620f = c0935fh;
        }
        this.f2615a |= 16;
        return this;
    }

    /* renamed from: c */
    public C0871cy m4281c(long j) {
        this.f2615a |= 32;
        this.f2621g = j;
        return this;
    }
}
