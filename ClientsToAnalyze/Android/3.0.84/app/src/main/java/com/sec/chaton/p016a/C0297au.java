package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.au */
/* loaded from: classes.dex */
public final class C0297au extends GeneratedMessageLite.Builder<C0296at, C0297au> implements InterfaceC0298av {

    /* renamed from: a */
    private int f959a;

    /* renamed from: b */
    private long f960b;

    /* renamed from: e */
    private long f963e;

    /* renamed from: c */
    private Object f961c = "";

    /* renamed from: d */
    private C0385ea f962d = C0385ea.m2690a();

    /* renamed from: f */
    private C0369dl f964f = C0369dl.m2485a();

    private C0297au() {
        m1611k();
    }

    /* renamed from: k */
    private void m1611k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0297au m1612l() {
        return new C0297au();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0297au clear() {
        super.clear();
        this.f960b = 0L;
        this.f959a &= -2;
        this.f961c = "";
        this.f959a &= -3;
        this.f962d = C0385ea.m2690a();
        this.f959a &= -5;
        this.f963e = 0L;
        this.f959a &= -9;
        this.f964f = C0369dl.m2485a();
        this.f959a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0297au mo13386clone() {
        return m1612l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0296at getDefaultInstanceForType() {
        return C0296at.m1587a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0296at build() {
        C0296at c0296atBuildPartial = buildPartial();
        if (!c0296atBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0296atBuildPartial);
        }
        return c0296atBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0296at m1613m() throws InvalidProtocolBufferException {
        C0296at c0296atBuildPartial = buildPartial();
        if (!c0296atBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0296atBuildPartial).asInvalidProtocolBufferException();
        }
        return c0296atBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0296at buildPartial() {
        C0296at c0296at = new C0296at(this);
        int i = this.f959a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0296at.f952c = this.f960b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0296at.f953d = this.f961c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0296at.f954e = this.f962d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0296at.f955f = this.f963e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0296at.f956g = this.f964f;
        c0296at.f951b = i2;
        return c0296at;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0297au mergeFrom(C0296at c0296at) {
        if (c0296at != C0296at.m1587a()) {
            if (c0296at.m1597c()) {
                m1615a(c0296at.m1598d());
            }
            if (c0296at.m1599e()) {
                m1621a(c0296at.m1600f());
            }
            if (c0296at.m1601g()) {
                m1625b(c0296at.m1602h());
            }
            if (c0296at.m1603i()) {
                m1623b(c0296at.m1604j());
            }
            if (c0296at.m1605k()) {
                m1624b(c0296at.m1606l());
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
    public C0297au mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f959a |= 1;
                    this.f960b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f959a |= 2;
                    this.f961c = codedInputStream.readBytes();
                    break;
                case 26:
                    C0386eb c0386ebNewBuilder = C0385ea.newBuilder();
                    if (m1629f()) {
                        c0386ebNewBuilder.mergeFrom(m1630g());
                    }
                    codedInputStream.readMessage(c0386ebNewBuilder, extensionRegistryLite);
                    m1620a(c0386ebNewBuilder.buildPartial());
                    break;
                case 32:
                    this.f959a |= 8;
                    this.f963e = codedInputStream.readInt64();
                    break;
                case 42:
                    C0370dm c0370dmNewBuilder = C0369dl.newBuilder();
                    if (m1631h()) {
                        c0370dmNewBuilder.mergeFrom(m1632i());
                    }
                    codedInputStream.readMessage(c0370dmNewBuilder, extensionRegistryLite);
                    m1618a(c0370dmNewBuilder.buildPartial());
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
    public C0297au m1615a(long j) {
        this.f959a |= 1;
        this.f960b = j;
        return this;
    }

    /* renamed from: a */
    public C0297au m1621a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f959a |= 2;
        this.f961c = str;
        return this;
    }

    /* renamed from: f */
    public boolean m1629f() {
        return (this.f959a & 4) == 4;
    }

    /* renamed from: g */
    public C0385ea m1630g() {
        return this.f962d;
    }

    /* renamed from: a */
    public C0297au m1620a(C0385ea c0385ea) {
        if (c0385ea == null) {
            throw new NullPointerException();
        }
        this.f962d = c0385ea;
        this.f959a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0297au m1625b(C0385ea c0385ea) {
        if ((this.f959a & 4) == 4 && this.f962d != C0385ea.m2690a()) {
            this.f962d = C0385ea.m2691a(this.f962d).mergeFrom(c0385ea).buildPartial();
        } else {
            this.f962d = c0385ea;
        }
        this.f959a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0297au m1623b(long j) {
        this.f959a |= 8;
        this.f963e = j;
        return this;
    }

    /* renamed from: h */
    public boolean m1631h() {
        return (this.f959a & 16) == 16;
    }

    /* renamed from: i */
    public C0369dl m1632i() {
        return this.f964f;
    }

    /* renamed from: a */
    public C0297au m1618a(C0369dl c0369dl) {
        if (c0369dl == null) {
            throw new NullPointerException();
        }
        this.f964f = c0369dl;
        this.f959a |= 16;
        return this;
    }

    /* renamed from: a */
    public C0297au m1619a(C0370dm c0370dm) {
        this.f964f = c0370dm.build();
        this.f959a |= 16;
        return this;
    }

    /* renamed from: b */
    public C0297au m1624b(C0369dl c0369dl) {
        if ((this.f959a & 16) == 16 && this.f964f != C0369dl.m2485a()) {
            this.f964f = C0369dl.m2486a(this.f964f).mergeFrom(c0369dl).buildPartial();
        } else {
            this.f964f = c0369dl;
        }
        this.f959a |= 16;
        return this;
    }
}
