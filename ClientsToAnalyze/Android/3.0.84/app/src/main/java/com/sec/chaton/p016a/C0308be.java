package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.be */
/* loaded from: classes.dex */
public final class C0308be extends GeneratedMessageLite.Builder<C0307bd, C0308be> implements InterfaceC0309bf {

    /* renamed from: a */
    private int f1016a;

    /* renamed from: f */
    private boolean f1021f;

    /* renamed from: b */
    private Object f1017b = "";

    /* renamed from: c */
    private EnumC0302az f1018c = EnumC0302az.SINGLE;

    /* renamed from: d */
    private List<C0333cc> f1019d = Collections.emptyList();

    /* renamed from: e */
    private Object f1020e = "";

    /* renamed from: g */
    private Object f1022g = "";

    private C0308be() {
        m1741g();
    }

    /* renamed from: g */
    private void m1741g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0308be m1742h() {
        return new C0308be();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0308be clear() {
        super.clear();
        this.f1017b = "";
        this.f1016a &= -2;
        this.f1018c = EnumC0302az.SINGLE;
        this.f1016a &= -3;
        this.f1019d = Collections.emptyList();
        this.f1016a &= -5;
        this.f1020e = "";
        this.f1016a &= -9;
        this.f1021f = false;
        this.f1016a &= -17;
        this.f1022g = "";
        this.f1016a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0308be mo13386clone() {
        return m1742h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0307bd getDefaultInstanceForType() {
        return C0307bd.m1710a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0307bd build() {
        C0307bd c0307bdBuildPartial = buildPartial();
        if (!c0307bdBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0307bdBuildPartial);
        }
        return c0307bdBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0307bd m1743i() throws InvalidProtocolBufferException {
        C0307bd c0307bdBuildPartial = buildPartial();
        if (!c0307bdBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0307bdBuildPartial).asInvalidProtocolBufferException();
        }
        return c0307bdBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0307bd buildPartial() {
        C0307bd c0307bd = new C0307bd(this);
        int i = this.f1016a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0307bd.f1008c = this.f1017b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0307bd.f1009d = this.f1018c;
        if ((this.f1016a & 4) == 4) {
            this.f1019d = Collections.unmodifiableList(this.f1019d);
            this.f1016a &= -5;
        }
        c0307bd.f1010e = this.f1019d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0307bd.f1011f = this.f1020e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0307bd.f1012g = this.f1021f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0307bd.f1013h = this.f1022g;
        c0307bd.f1007b = i2;
        return c0307bd;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0308be mergeFrom(C0307bd c0307bd) {
        if (c0307bd != C0307bd.m1710a()) {
            if (c0307bd.m1725c()) {
                m1750a(c0307bd.m1726d());
            }
            if (c0307bd.m1727e()) {
                m1747a(c0307bd.m1728f());
            }
            if (!c0307bd.f1010e.isEmpty()) {
                if (this.f1019d.isEmpty()) {
                    this.f1019d = c0307bd.f1010e;
                    this.f1016a &= -5;
                } else {
                    m1744j();
                    this.f1019d.addAll(c0307bd.f1010e);
                }
            }
            if (c0307bd.m1731i()) {
                m1753b(c0307bd.m1732j());
            }
            if (c0307bd.m1733k()) {
                m1751a(c0307bd.m1734l());
            }
            if (c0307bd.m1735m()) {
                m1755c(c0307bd.m1736n());
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
    public C0308be mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f1016a |= 1;
                    this.f1017b = codedInputStream.readBytes();
                    break;
                case 16:
                    EnumC0302az enumC0302azM1704a = EnumC0302az.m1704a(codedInputStream.readEnum());
                    if (enumC0302azM1704a == null) {
                        break;
                    } else {
                        this.f1016a |= 2;
                        this.f1018c = enumC0302azM1704a;
                        break;
                    }
                case 26:
                    C0334cd c0334cdNewBuilder = C0333cc.newBuilder();
                    codedInputStream.readMessage(c0334cdNewBuilder, extensionRegistryLite);
                    m1749a(c0334cdNewBuilder.buildPartial());
                    break;
                case 34:
                    this.f1016a |= 8;
                    this.f1020e = codedInputStream.readBytes();
                    break;
                case 40:
                    this.f1016a |= 16;
                    this.f1021f = codedInputStream.readBool();
                    break;
                case 50:
                    this.f1016a |= 32;
                    this.f1022g = codedInputStream.readBytes();
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
    public C0308be m1750a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1016a |= 1;
        this.f1017b = str;
        return this;
    }

    /* renamed from: a */
    public C0308be m1747a(EnumC0302az enumC0302az) {
        if (enumC0302az == null) {
            throw new NullPointerException();
        }
        this.f1016a |= 2;
        this.f1018c = enumC0302az;
        return this;
    }

    /* renamed from: j */
    private void m1744j() {
        if ((this.f1016a & 4) != 4) {
            this.f1019d = new ArrayList(this.f1019d);
            this.f1016a |= 4;
        }
    }

    /* renamed from: a */
    public C0308be m1749a(C0333cc c0333cc) {
        if (c0333cc == null) {
            throw new NullPointerException();
        }
        m1744j();
        this.f1019d.add(c0333cc);
        return this;
    }

    /* renamed from: b */
    public C0308be m1753b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1016a |= 8;
        this.f1020e = str;
        return this;
    }

    /* renamed from: a */
    public C0308be m1751a(boolean z) {
        this.f1016a |= 16;
        this.f1021f = z;
        return this;
    }

    /* renamed from: c */
    public C0308be m1755c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1016a |= 32;
        this.f1022g = str;
        return this;
    }
}
