package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ax */
/* loaded from: classes.dex */
public final class C0300ax extends GeneratedMessageLite.Builder<C0299aw, C0300ax> implements InterfaceC0301ay {

    /* renamed from: a */
    private int f980a;

    /* renamed from: b */
    private long f981b;

    /* renamed from: c */
    private EnumC0354cx f982c = EnumC0354cx.TEXT;

    /* renamed from: d */
    private EnumC0302az f983d = EnumC0302az.SINGLE;

    /* renamed from: e */
    private Object f984e = "";

    /* renamed from: f */
    private Object f985f = "";

    /* renamed from: g */
    private LazyStringList f986g = LazyStringArrayList.EMPTY;

    /* renamed from: h */
    private Object f987h = "";

    /* renamed from: i */
    private Object f988i = "";

    /* renamed from: j */
    private Object f989j = "";

    /* renamed from: k */
    private Object f990k = "";

    /* renamed from: l */
    private long f991l;

    private C0300ax() {
        m1682g();
    }

    /* renamed from: g */
    private void m1682g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0300ax m1683h() {
        return new C0300ax();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0300ax clear() {
        super.clear();
        this.f981b = 0L;
        this.f980a &= -2;
        this.f982c = EnumC0354cx.TEXT;
        this.f980a &= -3;
        this.f983d = EnumC0302az.SINGLE;
        this.f980a &= -5;
        this.f984e = "";
        this.f980a &= -9;
        this.f985f = "";
        this.f980a &= -17;
        this.f986g = LazyStringArrayList.EMPTY;
        this.f980a &= -33;
        this.f987h = "";
        this.f980a &= -65;
        this.f988i = "";
        this.f980a &= -129;
        this.f989j = "";
        this.f980a &= -257;
        this.f990k = "";
        this.f980a &= -513;
        this.f991l = 0L;
        this.f980a &= -1025;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0300ax mo13386clone() {
        return m1683h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0299aw getDefaultInstanceForType() {
        return C0299aw.m1642a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0299aw build() {
        C0299aw c0299awBuildPartial = buildPartial();
        if (!c0299awBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0299awBuildPartial);
        }
        return c0299awBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0299aw m1684i() throws InvalidProtocolBufferException {
        C0299aw c0299awBuildPartial = buildPartial();
        if (!c0299awBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0299awBuildPartial).asInvalidProtocolBufferException();
        }
        return c0299awBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0299aw buildPartial() {
        C0299aw c0299aw = new C0299aw(this);
        int i = this.f980a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0299aw.f967c = this.f981b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0299aw.f968d = this.f982c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0299aw.f969e = this.f983d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0299aw.f970f = this.f984e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0299aw.f971g = this.f985f;
        if ((this.f980a & 32) == 32) {
            this.f986g = new UnmodifiableLazyStringList(this.f986g);
            this.f980a &= -33;
        }
        c0299aw.f972h = this.f986g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0299aw.f973i = this.f987h;
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        c0299aw.f974j = this.f988i;
        if ((i & 256) == 256) {
            i2 |= 128;
        }
        c0299aw.f975k = this.f989j;
        if ((i & 512) == 512) {
            i2 |= 256;
        }
        c0299aw.f976l = this.f990k;
        if ((i & 1024) == 1024) {
            i2 |= 512;
        }
        c0299aw.f977m = this.f991l;
        c0299aw.f966b = i2;
        return c0299aw;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0300ax mergeFrom(C0299aw c0299aw) {
        if (c0299aw != C0299aw.m1642a()) {
            if (c0299aw.m1657c()) {
                m1687a(c0299aw.m1658d());
            }
            if (c0299aw.m1659e()) {
                m1691a(c0299aw.m1660f());
            }
            if (c0299aw.m1661g()) {
                m1690a(c0299aw.m1662h());
            }
            if (c0299aw.m1663i()) {
                m1692a(c0299aw.m1664j());
            }
            if (c0299aw.m1665k()) {
                m1695b(c0299aw.m1666l());
            }
            if (!c0299aw.f972h.isEmpty()) {
                if (this.f986g.isEmpty()) {
                    this.f986g = c0299aw.f972h;
                    this.f980a &= -33;
                } else {
                    m1685j();
                    this.f986g.addAll(c0299aw.f972h);
                }
            }
            if (c0299aw.m1668n()) {
                m1699d(c0299aw.m1669o());
            }
            if (c0299aw.m1670p()) {
                m1701e(c0299aw.m1671q());
            }
            if (c0299aw.m1672r()) {
                m1702f(c0299aw.m1673s());
            }
            if (c0299aw.m1674t()) {
                m1703g(c0299aw.m1675u());
            }
            if (c0299aw.m1676v()) {
                m1694b(c0299aw.m1677w());
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
    public C0300ax mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f980a |= 1;
                    this.f981b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0354cx enumC0354cxM2352a = EnumC0354cx.m2352a(codedInputStream.readEnum());
                    if (enumC0354cxM2352a == null) {
                        break;
                    } else {
                        this.f980a |= 2;
                        this.f982c = enumC0354cxM2352a;
                        break;
                    }
                case 24:
                    EnumC0302az enumC0302azM1704a = EnumC0302az.m1704a(codedInputStream.readEnum());
                    if (enumC0302azM1704a == null) {
                        break;
                    } else {
                        this.f980a |= 4;
                        this.f983d = enumC0302azM1704a;
                        break;
                    }
                case 34:
                    this.f980a |= 8;
                    this.f984e = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f980a |= 16;
                    this.f985f = codedInputStream.readBytes();
                    break;
                case 50:
                    m1685j();
                    this.f986g.add(codedInputStream.readBytes());
                    break;
                case 58:
                    this.f980a |= 64;
                    this.f987h = codedInputStream.readBytes();
                    break;
                case 66:
                    this.f980a |= 128;
                    this.f988i = codedInputStream.readBytes();
                    break;
                case 74:
                    this.f980a |= 256;
                    this.f989j = codedInputStream.readBytes();
                    break;
                case 82:
                    this.f980a |= 512;
                    this.f990k = codedInputStream.readBytes();
                    break;
                case 88:
                    this.f980a |= 1024;
                    this.f991l = codedInputStream.readInt64();
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
    public C0300ax m1687a(long j) {
        this.f980a |= 1;
        this.f981b = j;
        return this;
    }

    /* renamed from: a */
    public C0300ax m1691a(EnumC0354cx enumC0354cx) {
        if (enumC0354cx == null) {
            throw new NullPointerException();
        }
        this.f980a |= 2;
        this.f982c = enumC0354cx;
        return this;
    }

    /* renamed from: a */
    public C0300ax m1690a(EnumC0302az enumC0302az) {
        if (enumC0302az == null) {
            throw new NullPointerException();
        }
        this.f980a |= 4;
        this.f983d = enumC0302az;
        return this;
    }

    /* renamed from: a */
    public C0300ax m1692a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f980a |= 8;
        this.f984e = str;
        return this;
    }

    /* renamed from: b */
    public C0300ax m1695b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f980a |= 16;
        this.f985f = str;
        return this;
    }

    /* renamed from: j */
    private void m1685j() {
        if ((this.f980a & 32) != 32) {
            this.f986g = new LazyStringArrayList(this.f986g);
            this.f980a |= 32;
        }
    }

    /* renamed from: c */
    public C0300ax m1697c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m1685j();
        this.f986g.add((LazyStringList) str);
        return this;
    }

    /* renamed from: d */
    public C0300ax m1699d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f980a |= 64;
        this.f987h = str;
        return this;
    }

    /* renamed from: e */
    public C0300ax m1701e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f980a |= 128;
        this.f988i = str;
        return this;
    }

    /* renamed from: f */
    public C0300ax m1702f(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f980a |= 256;
        this.f989j = str;
        return this;
    }

    /* renamed from: g */
    public C0300ax m1703g(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f980a |= 512;
        this.f990k = str;
        return this;
    }

    /* renamed from: b */
    public C0300ax m1694b(long j) {
        this.f980a |= 1024;
        this.f991l = j;
        return this;
    }
}
